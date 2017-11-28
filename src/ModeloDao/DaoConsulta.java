/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;
import ModeloConection.ConexaoBd;
import ModeloBeans.BeansConsulta;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Daniel Lucas
 */
public class DaoConsulta {
    
    ConexaoBd conex = new ConexaoBd();
    BeansConsulta consulta = new BeansConsulta();
    
    PreparedStatement pstC;
    
    public void Salvar(BeansConsulta mod){
        conex.conectarBd();
        String sqlConsulta1 = " INSERT INTO CONSULTA (IDAGENDAMENTO, IDPACIENTE, IDMEDICO," +
                                                 "IDESPECIALIDADE, DATANASCIMENTO, ALTURA," +
                                              "PESO, PRESSAOARTERIAL, RECEITA,DIAGNOSTICO)" +
                                              "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try{
             pstC = conex.con.prepareStatement(sqlConsulta1);
             
             pstC.setInt(1, mod.getIdAgendamento());
             pstC.setInt(2, mod.getIdPaciente());
             pstC.setInt(3, mod.getIdMedico());
             pstC.setInt(4, mod.getIdEspecialidade());
             pstC.setDate(5, new java.sql.Date(mod.getDataNascimento().getTime()));
             pstC.setFloat(6, mod.getAltura());
             pstC.setFloat(7, mod.getPeso());
             pstC.setString(8, mod.getPressaoArterial());
             pstC.setString(9, mod.getReceita());
             pstC.setString(10, mod.getDiagnostico());
             
             pstC.execute();
                                
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Erro ao salvar a consulta. \n Erro:\n " + ex.getMessage());
        }finally{
            conex.DesconectarBd();
        }
    }
    
    
}
