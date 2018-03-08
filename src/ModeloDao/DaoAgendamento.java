package ModeloDao;

import ModeloBeans.BeansAgendamento;
import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JOptionPane;

public class DaoAgendamento {

    BeansAgendamento agenda = new BeansAgendamento();

    ConexaoBd conBd = new ConexaoBd();
    ConexaoBd conBdPaciente = new ConexaoBd();
    ConexaoBd conBdMedico = new ConexaoBd();

    public int codMedico, codPaciente, codEspecialidade;
    String nomeMedico;

    public void Salvar(BeansAgendamento agenda) {
        BuscarMedico(agenda.getNomeMedico());
        buscarPaciente(agenda.getNomePaciente());

        conBd.conectarBd();
        String sql = "INSERT  INTO AGENDAMENTO (IDPACIENTE,IDMEDICO,IDHORA,DTAGENDAMENTO,MOTIVO,STATUSCONSULTA,IDESPECIALIDADE,RETORNO,IDCONSULTARETORNO) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement pst = conBd.con.prepareStatement(sql);
            pst.setInt(1, codPaciente);
            pst.setInt(2, codMedico);
            pst.setInt(3, agenda.getAgenIdHora());
            pst.setDate(4, new java.sql.Date(agenda.getData().getTime()));
            pst.setString(5, agenda.getMotivo());
            pst.setString(6, agenda.getStatus());
            pst.setInt(7, agenda.getAEspecialidade());
            pst.setString(8, agenda.getARetorno());
            pst.setInt(9, agenda.getAgenIdConsultaRetorno());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Agendamento executado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o agendamento. \n Erro:\n " + ex.getMessage());

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
        if (nomeMedico == null) {
        } else {
            conBdMedico.conectarBd();

            String sql = "SELECT IDMEDICO FROM MEDICO WHERE NOMEMEDICO ='" + nomeMedico + "'";
            conBdMedico.executaSql(sql);
            try {
                conBdMedico.rs.first();

                codMedico = conBdMedico.rs.getInt("IDMEDICO");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Medico não cadastrado. " + ex);
            } finally {
                conBdMedico.DesconectarBd();
            }

        }
        return codMedico;
    }
     
    /* Método tem a finalidade de buscar o Id da especialidade escolida no JcomboboxEspec e utilizar o id da especialidade 
       * para retornar ao jcomboboxMedico todos os médicos que possui tal especialidade, */
    public String BuscarCodEspec(String nomeEspec) {
        conBdMedico.conectarBd();
        String sql = "SELECT NOMEMEDICO FROM ESPECIALIDADE "
                + "INNER JOIN  MEDICO ON MEDICO.IDESPECIALIDADE = ESPECIALIDADE.IDESPECIALIDADE "
                + "WHERE ESPEC ='" + nomeEspec + "'";
        conBdMedico.executaSql(sql);
        try {
            conBdMedico.rs.first();
            nomeMedico = conBdMedico.rs.getString("NOMEMEDICO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No momento não existe medico cadastrado para essa especialidade selecionada.");
        } finally {
            conBdMedico.DesconectarBd();
        }
        return nomeEspec;
    }

    public Integer BuscarCodEspecEmNumero(String nomeEspec) {
        conBdMedico.conectarBd();
        String sql = "SELECT IDESPECIALIDADE FROM ESPECIALIDADE WHERE ESPEC ='" + nomeEspec + "'";
        conBdMedico.executaSql(sql);
        try {
            conBdMedico.rs.first();
            codEspecialidade = conBdMedico.rs.getInt("IDESPECIALIDADE");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar a especialidade. Erro: \n" + ex.getMessage());
        } finally {
            conBdMedico.DesconectarBd();
        }
        return codEspecialidade;
    }

    public void buscarPaciente(String nomePaciente) {
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
                + "IDHORA = ?,DTAGENDAMENTO = ? WHERE IDAGENDAMENTO = ?";

        try {

            PreparedStatement pst = conBd.con.prepareStatement(sql);

            pst.setString(1, agenda.getStatus());
            pst.setInt(2, agenda.getAIdPaciente());
            pst.setInt(3, agenda.getAIdMedico());
            pst.setInt(4, agenda.getAEspecialidade());
            pst.setInt(5, agenda.getAgenIdHora());
            pst.setDate(6, new java.sql.Date(agenda.getData().getTime()));
            pst.setInt(7, agenda.getAgendaCod());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Agendamento atualizado com sucesso.");

            conBd.DesconectarBd();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atender. \n Erro:\n" + ex);
        }
    }

    public BeansAgendamento buscaAgendaPorCodigo(int cod) {
        Boolean retorno;
        BeansAgendamento agen = new BeansAgendamento();
        conBd.conectarBd();
        conBd.executaSql("SELECT PACIENTE.NOMEPACIENTE,PACIENTE.DATANASCIMENTO, "
                + "AGENDAMENTO.MOTIVO,MEDICO.NOMEMEDICO,AGENDAMENTO.RETORNO "
                + "FROM AGENDAMENTO "
                + "INNER JOIN PACIENTE "
                + "ON PACIENTE.IDPACIENTE = AGENDAMENTO.IDPACIENTE "
                + "INNER JOIN MEDICO "
                + "ON MEDICO.IDMEDICO = AGENDAMENTO.IDMEDICO "
                + "WHERE AGENDAMENTO.IDAGENDAMENTO = '" + cod + "'");
        try {
            conBd.rs.first();
            agen.setNomePaciente(conBd.rs.getString("NOMEPACIENTE"));
            agen.setNomeMedico(conBd.rs.getString("NOMEMEDICO"));
            agen.setMotivo(conBd.rs.getString("MOTIVO"));
            agen.setDtNascPaciente(conBd.rs.getString("DATANASCIMENTO"));
            retorno = conBd.rs.getBoolean("RETORNO");
            if (retorno == true) {
                agen.setARetorno("Sim");
            } else {
                agen.setARetorno("Não");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro  ao carregar os dados do paciente: \n" + ex);
        }
        return agen;
    }

    public BeansAgendamento buscaAgendamentoPorCodigo(int cod) {
        Boolean retorno;
        BeansAgendamento agen = new BeansAgendamento();
        conBd.conectarBd();
        conBd.executaSql("SELECT IDPACIENTE,IDMEDICO,IDESPECIALIDADE,IDHORA,DTAGENDAMENTO "
                + "FROM AGENDAMENTO "
                + "WHERE IDAGENDAMENTO ='" + cod + "'");
        try {
            conBd.rs.first();
            agen.setAIdPaciente(conBd.rs.getInt("IDPACIENTE"));
            agen.setAIdMedico(conBd.rs.getInt("IDMEDICO"));
            agen.setAEspecialidade(conBd.rs.getInt("IDESPECIALIDADE"));
            agen.setAgenIdHora(conBd.rs.getInt("IDHORA"));
            agen.setData(conBd.rs.getDate("DTAGENDAMENTO"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro  ao carregar os dados do paciente: \n" + ex);
        }
        return agen;
    }
}
