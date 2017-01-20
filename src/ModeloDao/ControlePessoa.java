
package ModeloDao;

import ModeloDao.ControleMedico;
import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Beans.BeansMedico;
import modelo.Beans.ModeloPessoa;

/**
 *
 * @author Daniel Lucas
 */
public class ControlePessoa {
 
       ConexaoBd conex = new ConexaoBd();
    ModeloPessoa modP = new ModeloPessoa();
  PreparedStatement pstP;
    
    public void salvar(ModeloPessoa modP) {
        conex.conectarBd();

        try {

            pstP = conex.con.prepareStatement("insert into pessoa (Nome,Cpf,Rg,TelResidencial,Telcelular,Bairro,Logradouro,Numero) " //
                    + "values (?,?,?,?,?,?,?,?,?,?)");

            pstP.setString(1, modP.getNome());
            pstP.setString(2, modP.getCpf());
            pstP.setString(3, modP.getRg());
            pstP.setString(4, modP.getTelcel());
            pstP.setString(5, modP.getTelRes());
            pstP.setString(6, modP.getLogradouro());
            pstP.setString(7, modP.getBairro());
            pstP.setInt(8, modP.getNumero());
            //pstP.setString(9,modP.)
          
          
            pstP.execute();
            
           // JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");
        } catch (SQLException ex) {
            Logger.getLogger(ControleMedico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a inserção dos dados. \n" + ex.getMessage());

        }

        
        
        conex.DesconectarBd();

    }

}
 
    
    
