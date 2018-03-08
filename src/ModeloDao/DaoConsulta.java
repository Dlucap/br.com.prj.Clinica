/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;
import ModeloConection.ConexaoBd;
import ModeloBeans.BeansConsulta;
import java.sql.CallableStatement;
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
    
    public int codMedico, codPaciente;
   
    PreparedStatement pstC;
    
    public void Salvar(BeansConsulta mod){
       
        conex.conectarBd();
        String sqlConsulta1 = "INSERT INTO CONSULTA (IDAGENDAMENTO, ALTURA," +
                              " PESO, PRESSAOARTERIAL, RECEITA,DIAGNOSTICO) " +
                              "VALUES (?,?,?,?,?,?)";
        try{
            
             pstC = conex.con.prepareStatement(sqlConsulta1);
             pstC.setInt(1, mod.getIdAgendamento());
             pstC.setFloat(2, mod.getAltura());
             pstC.setFloat(3, mod.getPeso());
             pstC.setString(4, mod.getPressaoArterial());
             pstC.setString(5, mod.getReceita());
             pstC.setString(6, mod.getDiagnostico());
             
             pstC.execute();
                                
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Erro ao salvar os dados da consulta. \n Erro:\n " + ex.getMessage());
        }finally{
            conex.DesconectarBd();
        }
    }
    
     public void BuscarMedico(String nomeMedico) {
        conex.conectarBd();
        conex.executaSql("SELECT * FROM MEDICO WHERE NOMEMEDICO ='" + nomeMedico + "'");
        try {
            conex.rs.first();
            codMedico = conex.rs.getInt("IDMEDICO");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Medico não cadastrado." + ex);
        }
        conex.DesconectarBd();
    }
    
     
        public void buscarPaciente(String nomePaciente) {
        conex.conectarBd();
        conex.executaSql("SELECT IDPACIENTE FROM PACIENTE WHERE NOMEPACIENTE ='" + nomePaciente + "'");
        try {
            conex.rs.first();
            codPaciente = conex.rs.getInt("IDPACIENTE");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Paciente não cadastrado." + ex);
        }

        conex.DesconectarBd();
    }
}
