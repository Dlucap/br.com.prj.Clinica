package ModeloDao;

import ModeloConection.ConexaoBd;
import modelo.Beans.ModeloPessoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Beans.BeansMedico;
import br.com.prj.clinica.FormMedico;

/**
 *
 * @author Daniel Lucas
 */
public class ControleMedico {

    ConexaoBd conex = new ConexaoBd();
    BeansMedico mod = new BeansMedico();

    PreparedStatement pstM;

    public void salvar(BeansMedico mod) {
        conex.conectarBd();
        String sql = "insert into Medico (NOME ,CPF ,RG ,TELRESIDENCIAL ,TELCELULAR ,LOGRADOURO ,BAIRRO ,NUMERO ,CEP ,COMPL ,CRM ,IDESPECIALIDADE) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstM = conex.con.prepareStatement(sql);

            pstM.setString(1, mod.getMnome());
            pstM.setString(2, mod.getMcpf());
            pstM.setString(3, mod.getMrg());
            pstM.setString(4, mod.getMtelresidencial());
            pstM.setString(5, mod.getMtelcelular());
            pstM.setString(6, mod.getMlogradouro());
            pstM.setString(7, mod.getMbairro());
            pstM.setInt(8, mod.getMnumero());
            pstM.setString(9, mod.getMcep());
            pstM.setString(10, mod.getMcompl());
            pstM.setString(11, mod.getMcrm());
           // pstM.setInt(12, Integer.parseInt(mod.getMespecialidade()));
            pstM.setInt(12, (mod.getMespecialidade()));
            pstM.execute();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");
        } catch (SQLException ex) {
            Logger.getLogger(ControleMedico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "\n Não foi possível realizar a inserção dos dados. \n\n" + ex.getMessage());
        }
        conex.DesconectarBd();
    }

    public BeansMedico buscaMedico(BeansMedico mod) {
        conex.conectarBd();
 String sql1 = "select * from medico inner join ESPECIALIDADE on MEDICO.IDESPECIALIDADE = especialidade.idESPECIALIDADE " +
"where medico.nome like '%"+ mod.getPesquisa()+"%'";

        conex.executaSql(sql1);
      
        try {
            conex.rs.first();
            mod.setMcod(conex.rs.getInt("IDMEDICO"));
            mod.setMnome(conex.rs.getString("Nome"));
            mod.setMcrm(conex.rs.getString("CRM"));
            mod.setMespecialidade(conex.rs.getInt("IdEspecialidade"));

        } catch (SQLException ex) {
            Logger.getLogger(ControleMedico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro erros ao carregar os dados do medico!\nErro: " + ex.getMessage());
        }

        conex.DesconectarBd();
        return mod;
    }
}
