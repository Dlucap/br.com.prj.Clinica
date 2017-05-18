package ModeloDao;

import ModeloBeans.BeansAgendamento;
import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DaoAgendamento {

    BeansAgendamento agenda = new BeansAgendamento();

    ConexaoBd conBd = new ConexaoBd();
    ConexaoBd conBdPaciente = new ConexaoBd();
    ConexaoBd conBdMedico = new ConexaoBd();

    int codMedico, codPaciente;
    String nomeMedico;

    public void Salvar(BeansAgendamento agenda) {
        BuscarMedico(agenda.getNomeMedico());
        Buscarpaciente(agenda.getNomePaciente());

        conBd.conectarBd();
        String sql = "INSERT  INTO AGENDAMENTO (IDPACIENTE,IDMEDICO,TURNO,DTAGENDAMENTO,MOTIVO,STATUSCONSULTA,IDESPECIALIDADE,RETORNO) "
                + "VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = conBd.con.prepareStatement(sql);
            pst.setInt(1, codPaciente);
            pst.setInt(2, codMedico);
            pst.setString(3, agenda.getTurno());
            pst.setDate(4, new java.sql.Date(agenda.getData().getTime()));
            pst.setString(5, agenda.getMotivo());
            pst.setString(6, agenda.getStatus());
            pst.setInt(7, agenda.getAEspecialidade());
            pst.setString(8, agenda.getARetorno());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Agendamento executado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o agendamento. \n Erro:\n " + ex);
        }

        conBd.DesconectarBd();
    }

    public void BuscarMedico(String nomeMedico) {
        conBdMedico.conectarBd();
        conBdMedico.executaSql("SELECT * FROM MEDICO WHERE NOMEMEDICO ='" + nomeMedico + "'");
        try {
            conBdMedico.rs.first();
            codMedico = conBdMedico.rs.getInt("IDMEDICO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Medico não cadastrado." + ex);
        }
        conBdMedico.DesconectarBd();
    }

    //RETORNA O ID DO MÉDICO
    public int BuscarCodMedico(String nomeMedico) {
        conBdMedico.conectarBd();
        String sql = "SELECT IDMEDICO FROM MEDICO WHERE NOMEMEDICO ='" + nomeMedico + "'";
        conBdMedico.executaSql(sql);
        try {
            conBdMedico.rs.first();
            codMedico = conBdMedico.rs.getInt("IDMEDICO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Medico não cadastrado. 1" + ex);
        } finally {
            conBdMedico.DesconectarBd();
        } return codMedico;
    } 
    /* Método tem a finalidade de buscar o Id da especialidade escolida no JcomboboxEspec e utilizar o id da especialidade 
       * para retornar ao jcomboboxMedico todos os médicos que possui tal especialidade, */
    public String BuscarCodEspec(String nomeEspec) {
        conBdMedico.conectarBd();
        String sql = "SELECT NOMEMEDICO FROM ESPECIALIDADE " +
                    "INNER JOIN  MEDICO on MEDICO.IDESPECIALIDADE= ESPECIALIDADE.IDESPECIALIDADE " +
                    "WHERE ESPEC ='"+nomeEspec+"'";
        conBdMedico.executaSql(sql);
        try {
            conBdMedico.rs.first();
            nomeMedico = conBdMedico.rs.getString("NOMEMEDICO");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No momento não existe medico cadastrado para essa especialidade selecionada.");
        } finally {
            conBdMedico.DesconectarBd();
        } return nomeEspec;
    }

    public void Buscarpaciente(String nomePaciente) {
        conBdPaciente.conectarBd();
        conBdPaciente.executaSql("SELECT IDPACIENTE FROM PACIENTE WHERE NOMEPACIENTE ='" + nomePaciente + "'");
        try {
            conBdPaciente.rs.first();
            codPaciente = conBdPaciente.rs.getInt("IDPACIENTE");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Paciente não cadastrado." + ex);
        }

        conBdPaciente.DesconectarBd();
    }

    public void Alterar(BeansAgendamento agenda) {
        conBd.conectarBd();

        String sql = "UPDATE AGENDAMENTO SET STATUSCONSULTA = ?,IDPACIENTE = ?, IDMEDICO = ?, IDESPECIALIDADE=?, "
                + "TURNO = ?,DTAGENDAMENTO = ? WHERE IDAGENDAMENTO = ?";

        try {

            PreparedStatement pst = conBd.con.prepareStatement(sql);

            pst.setString(1, agenda.getStatus());
            pst.setInt(2, agenda.getAIdPaciente());
            pst.setInt(3, agenda.getAIdMedico());
            pst.setInt(4, agenda.getAEspecialidade());
            pst.setString(5, agenda.getTurno());
            pst.setDate(6, new java.sql.Date(agenda.getData().getTime()));
            pst.setInt(7, agenda.getAgendaCod());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Agendamento em atendimento.");

            conBd.DesconectarBd();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atender. \n Erro:\n" + ex);
        }
    }

}
