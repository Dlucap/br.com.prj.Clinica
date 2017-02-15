
package ModeloDao;

import ModeloBeans.BeansAgendamento;
import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DaoAgenda {
        
    BeansAgendamento agenda = new BeansAgendamento();
   
    ConexaoBd conBd = new ConexaoBd();
    ConexaoBd conBdPaciente = new ConexaoBd();
    ConexaoBd conBdMedico = new ConexaoBd();
    
    int codMedico, codPaciente;
    
    public void Salvar(BeansAgendamento agenda){
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
            pst.setInt(7,agenda.getAEspecialidade());
           
            pst.execute();
             JOptionPane.showMessageDialog(null,"Agendamento executado com sucesso.");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao salvar o agendamento. \n Erro:\n "+ex);
        }
        
        conBd.DesconectarBd();
    }
    
    public void BuscarMedico(String nomeMedico){
        conBdMedico.conectarBd();
        conBdMedico.executaSql("SELECT * FROM MEDICO WHERE NOME ='"+nomeMedico+"'");
        try {
            conBdMedico.rs.first();
            codMedico = conBdMedico.rs.getInt("IDMEDICO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Medico não cadastrado."+ex);
        }
               
        conBdMedico.DesconectarBd();
    }
   
     public void Buscarpaciente(String nomePaciente){
        conBdPaciente.conectarBd();
          conBdPaciente.executaSql("SELECT * FROM PACIENTE WHERE NOME ='"+nomePaciente+"'");
        try {
            conBdPaciente.rs.first();
            codPaciente= conBdPaciente.rs.getInt("IDPACIENTE");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Paciente não cadastrado."+ex);
        }
        
        conBdPaciente.DesconectarBd();
    }
    
}
