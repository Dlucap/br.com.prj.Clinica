package ModeloDao;

import ModeloBeans.BeansAgendamento;
import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DaoAgendamento {

    BeansAgendamento agenda = new BeansAgendamento();

    ConexaoBd conBd = new ConexaoBd();
    ConexaoBd conBdPaciente = new ConexaoBd();
    ConexaoBd conBdMedico = new ConexaoBd();

    int codMedico, codPaciente;

    public void Salvar(BeansAgendamento agenda) {
        BuscarMedico(agenda.getNomeMedico());
        Buscarpaciente(agenda.getNomePaciente());

        conBd.conectarBd();
        String sql = "INSERT  INTO AGENDAMENTO (IDPACIENTE,IDMEDICO,TURNO,DTAGENDAMENTO,MOTIVO,STATUS,IDESPECIALIDADE) "
                + "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = conBd.con.prepareStatement(sql);
            pst.setInt(1, codPaciente);
            pst.setInt(2, codMedico);
            pst.setString(3, agenda.getTurno());
            pst.setDate(4, new java.sql.Date(agenda.getData().getTime()));
            pst.setString(5, agenda.getMotivo());
            pst.setString(6, agenda.getStatus());
            pst.setInt(7, agenda.getAEspecialidade());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Agendamento executado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o agendamento. \n Erro:\n " + ex);
        }

        conBd.DesconectarBd();
    }

    public void BuscarMedico(String nomeMedico) {
        conBdMedico.conectarBd();
        conBdMedico.executaSql("SELECT * FROM MEDICO WHERE NOME ='" + nomeMedico + "'");
        try {
            conBdMedico.rs.first();
            codMedico = conBdMedico.rs.getInt("IDMEDICO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Medico não cadastrado." + ex);
        }

        conBdMedico.DesconectarBd();
    }
 public int BuscarCodMedico(String nomeMedico) {
        conBdMedico.conectarBd();
        conBdMedico.executaSql("SELECT * FROM MEDICO WHERE NOME ='" + nomeMedico + "'");
        try {
            conBdMedico.rs.first();
            codMedico = conBdMedico.rs.getInt("IDMEDICO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Medico não cadastrado." + ex);
        }finally{
        conBdMedico.DesconectarBd();
        }
        return codMedico;
       
    }
    public void Buscarpaciente(String nomePaciente) {
        conBdPaciente.conectarBd();
        conBdPaciente.executaSql("SELECT * FROM PACIENTE WHERE NOME ='" + nomePaciente + "'");
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

        String sql = "UPDATE AGENDAMENTO SET STATUS = ?,IDPACIENTE = ?, IDMEDICO = ?, IDESPECIALIDADE=?, "
                + "TURNO = ?,DTAGENDAMENTO = ? WHERE IDAGENDAMENTO = ?";

        try {
            
            PreparedStatement pst = conBd.con.prepareStatement(sql);
            
            pst.setString(1, agenda.getStatus());
            pst.setInt(2 ,agenda.getAIdPaciente());
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
