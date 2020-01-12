package ModeloDao;

import ModeloBeans.BeansAgendamento;
import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;

public class DaoAgendamento {

    BeansAgendamento agenda = new BeansAgendamento();

    ConexaoBd conBd = new ConexaoBd();
    ConexaoBd conBdPaciente = new ConexaoBd();
    ConexaoBd conBdMedico = new ConexaoBd();

    public int codMedico, codPaciente, codEspecialidade, codIdHora, idHora;
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

    public void Alterar(BeansAgendamento agenda) {

        BuscarMedico(agenda.getNomeMedico());
        buscarPaciente(agenda.getNomePaciente());
        String sql = "UPDATE AGENDAMENTO SET STATUSCONSULTA = ?,IDPACIENTE = ?, IDMEDICO = ?, IDESPECIALIDADE=?, "
                + "IDHORA = ?,DTAGENDAMENTO = ?,MOTIVO=?,RETORNO=?,IDCONSULTARETORNO =? WHERE IDAGENDAMENTO = ?";
        conBd.conectarBd();
        try {

            PreparedStatement pst = conBd.con.prepareStatement(sql);

            pst.setString(1, agenda.getStatus());
            pst.setInt(2, codPaciente);
            pst.setInt(3, codMedico);
            pst.setInt(4, agenda.getAEspecialidade());
            pst.setInt(5, agenda.getAgenIdHora());
            pst.setDate(6, new java.sql.Date(agenda.getData().getTime()));
            pst.setString(7, agenda.getMotivo());
            pst.setString(8, agenda.getARetorno());
            pst.setInt(9, agenda.getAgenIdConsultaRetorno());
            pst.setInt(10, agenda.getAgendaCod());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Agendamento atualizado com sucesso.");

            conBd.DesconectarBd();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualiza o agendamento. \n Erro:\n" + ex);
        }
    }
 public boolean verificaChoqueHorario(String NomePaciente, String data, int hora) {
     buscarPaciente(NomePaciente);  
     String sql = "SELECT AGENDAMENTO.IDAGENDAMENTO,PACIENTE.NOMEPACIENTE,MEDICO.NOMEMEDICO,"
                + "ESPECIALIDADE.ESPEC,HORARIO.HORA "
                + "FROM PACIENTE (NOLOCK) "
                + "LEFT JOIN AGENDAMENTO (NOLOCK)  ON AGENDAMENTO.IDPACIENTE = PACIENTE.IDPACIENTE "
                + "INNER JOIN MEDICO (NOLOCK) "
                + "ON AGENDAMENTO.IDMEDICO = MEDICO.IDMEDICO "
                + "LEFT JOIN HORARIO (NOLOCK) "
                + "ON AGENDAMENTO.IDHORA  = HORARIO.IDHORA "
                + "LEFT JOIN ESPECIALIDADE (NOLOCK) "
                + "ON AGENDAMENTO.IDESPECIALIDADE = ESPECIALIDADE.IDESPECIALIDADE "
                + "WHERE PACIENTE.IDPACIENTE = " + codPaciente + " AND AGENDAMENTO.DTAGENDAMENTO = '" + data +"' "
                + "AND HORARIO.IDHORA = "+hora;
       
        ArrayList dados = new ArrayList();
        conBd.conectarBd();
        conBd.executaSql(sql);
        try {
            conBd.rs.first();

           while (conBd.rs.next()){
            dados.add(new Object[]{
            conBd.rs.getInt("IDAGENDAMENTO"),conBd.rs.getString("NOMEPACIENTE"),conBd.rs.getString("NOMEMEDICO"),
                conBd.rs.getString("ESPEC"),conBd.rs.getString("HORA")
            });
            }; 
          if(dados.size()>1)
            JOptionPane.showMessageDialog(null, "O Paciente "+NomePaciente+" possui agendamento marcado para o horario escolhido.","Alerta!!!",JOptionPane.WARNING_MESSAGE);
         
            return true;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro. \n Erro:\n" + ex.getMessage());
        }finally{
            conBd.DesconectarBd();
        }
        return false;
    }
    
    
    /**
     * Metodo verifica qual o status da consulta, será retornado um valor
     * inteiro, onde: Aberto = 0 - Em Atendimento = 1 Finalizado = 2 Cancelado =
     * 3 Caso seja apreentado erro sempre será retornado -1
     *
     * @param idConsulta
     * @return
     */
    public int VerificaStatusConsulta(String idConsulta) {
        String sql = "SELECT STATUSCONSULTA FROM AGENDAMENTO (NOLOCK) WHERE IDAGENDAMENTO = " + idConsulta;
        try {
            conBd.conectarBd();
            conBd.executaSql(sql);
            conBd.rs.first();
            switch (conBd.rs.getString("STATUSCONSULTA")) {
                case "Aberto":
                    return 0;
                case "Em Atendimento":
                    return 1;
                case "Finalizado":
                    return 2;
                case "Cancelado":
                    return 3;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro verificar o status da consulta.\n Erro:\n" + ex);
            return -1;
        } finally {
            conBd.DesconectarBd();
        }
        return -1;
    }
    
    public void alteraStatusConsuta(String status, String idconsulta) {

        String sql = "UPDATE AGENDAMENTO SET STATUSCONSULTA = ? WHERE IDAGENDAMENTO = ?";
        conBd.conectarBd();
        try {

            PreparedStatement pst = conBd.con.prepareStatement(sql);

            pst.setString(1, status);
            pst.setString(2, idconsulta);

            pst.execute();

            JOptionPane.showMessageDialog(null, "Agendamento atualizado com sucesso.");

            conBd.DesconectarBd();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualiza o agendamento. \n Erro:\n" + ex);
        }
    }

    public void BuscarMedico(String nomeMedico) {
        conBdMedico.conectarBd();
        conBdMedico.executaSql("SELECT IDMEDICO FROM MEDICO (NOLOCK) WHERE NOMEMEDICO ='" + nomeMedico + "'");
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

            String sql = "SELECT IDMEDICO FROM MEDICO(NOLOCK) WHERE NOMEMEDICO ='" + nomeMedico + "'";
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
        String sql = "SELECT NOMEMEDICO FROM ESPECIALIDADE (NOLOCK) "
                + "INNER JOIN  MEDICO (NOLOCK) ON MEDICO.IDESPECIALIDADE = ESPECIALIDADE.IDESPECIALIDADE "
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
        String sql = "SELECT IDESPECIALIDADE FROM ESPECIALIDADE (NOLOCK) WHERE ESPEC ='" + nomeEspec + "'";
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
        conBdPaciente.executaSql("SELECT IDPACIENTE FROM PACIENTE (NOLOCK) WHERE NOMEPACIENTE ='" + nomePaciente + "'");
        try {
            conBdPaciente.rs.first();
            codPaciente = conBdPaciente.rs.getInt("IDPACIENTE");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Paciente não cadastrado." + ex);
        }

        conBdPaciente.DesconectarBd();
    }

    public BeansAgendamento buscaAgendaPorCodigo(int cod) {
        Boolean retorno;
        BeansAgendamento agen = new BeansAgendamento();
        conBd.conectarBd();
        conBd.executaSql("SELECT PACIENTE.NOMEPACIENTE,PACIENTE.DATANASCIMENTO, "
                + "AGENDAMENTO.MOTIVO,MEDICO.NOMEMEDICO,AGENDAMENTO.RETORNO "
                + "FROM AGENDAMENTO (NOLOCK) "
                + "INNER JOIN PACIENTE (NOLOCK) "
                + "ON PACIENTE.IDPACIENTE = AGENDAMENTO.IDPACIENTE "
                + "INNER JOIN MEDICO (NOLOCK) "
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
                + "FROM AGENDAMENTO (NOLOCK) "
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

    public Integer BuscarIDHora(String descHora) {
        conBd.conectarBd();

        String sql = "SELECT IDHORA FROM HORARIO (NOLOCK) WHERE HORA LIKE '" + descHora + "%'";
        conBd.executaSql(sql);
        try {
            conBd.rs.first();
            idHora = conBd.rs.getInt("IDHORA");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar o codigo da Hora. Erro: \n" + ex.getMessage());
        } finally {
            conBd.DesconectarBd();
        }
        return idHora;
    }

}
