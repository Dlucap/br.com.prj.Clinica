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
import com.toedter.calendar.JCalendar;

/**
 *
 * @author Daniel Lucas
 */
public class DaoMedico {

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
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "\n Não foi possível realizar a inserção dos dados. \n\n" + ex.getMessage());
        }
        conex.DesconectarBd();
    }

    public void Editar(BeansMedico mod) {
        conex.conectarBd();
        String sql = "UPDATE MEDICO SET NOME = ?,CPF = ?, RG = ?, TELRESIDENCIAL = ?,TELCELULAR = ?,LOGRADOURO = ?, BAIRRO = ?,"
                + "NUMERO = ?,CEP = ?,COMPL = ?,CRM = ?,IDESPECIALIDADE = ? WHERE IDMEDICO = ?";

        try {
            PreparedStatement pst = conex.con.prepareStatement(sql);

            pst.setString(1, mod.getMnome());
            pst.setString(2, mod.getMcpf());
            pst.setString(3, mod.getMrg());
            pst.setString(4, mod.getMtelresidencial());
            pst.setString(5, mod.getMtelcelular());
            pst.setString(6, mod.getMlogradouro());
            pst.setString(7, mod.getMbairro());
            pst.setInt(8, mod.getMnumero());
            pst.setString(9, mod.getMcep());
            pst.setString(10, mod.getMcompl());
            pst.setString(11, mod.getMcrm());
            pst.setInt(12, (mod.getMespecialidade()));
            pst.setInt(13, mod.getMcod());
            
            System.out.println(""+mod.getMnome()); 
            System.out.println(""+mod.getMcpf());
            System.out.println(""+mod.getMrg());
            System.out.println(""+mod.getMtelresidencial());
            System.out.println(""+mod.getMtelcelular());
            System.out.println(""+mod.getMlogradouro());
            System.out.println(""+mod.getMbairro());
            System.out.println(""+ mod.getMnumero());
            System.out.println(""+mod.getMcep());
            System.out.println(""+mod.getMcompl());
            System.out.println(""+mod.getMcrm());
            System.out.println(""+(mod.getMespecialidade()));
         
            
            pst.execute();

            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! \nErro: " + ex.getMessage());
             
        }

        conex.DesconectarBd();
    }

    public BeansMedico buscaMedico(BeansMedico mod) {

        conex.conectarBd();

        String sql1 = "select * from medico inner join ESPECIALIDADE on MEDICO.IDESPECIALIDADE = especialidade.idESPECIALIDADE "
                + "where medico.nome like '%" + mod.getPesquisa() + "%'";

        conex.executaSql(sql1);

        try {
            conex.rs.first();
            mod.setMcod(conex.rs.getInt("IDMEDICO"));
            mod.setMnome(conex.rs.getString("Nome"));
            mod.setMcrm(conex.rs.getString("CRM"));
            mod.setMlogradouro(conex.rs.getString("LOGRADOURO"));
            mod.setMnumero(conex.rs.getInt("NUMERO"));
            mod.setMbairro(conex.rs.getString("BAIRRO"));
            mod.setMcpf(conex.rs.getString("CPF"));
            mod.setMrg(conex.rs.getString("RG"));
            mod.setMtelresidencial(conex.rs.getString("TELRESIDENCIAL"));
            mod.setMtelcelular(conex.rs.getString("TELCELULAR"));
            mod.setMcrm(conex.rs.getString("CRM"));
            mod.setMcep(conex.rs.getString("CEP"));
            mod.setMcompl(conex.rs.getString("COMPL"));
            mod.setMSespecialidade(conex.rs.getString("ESPEC"));
            /*
             System.out.println(conex.rs.getString("TELRESIDENCIAL"));
            System.out.println(conex.rs.getString("TELCELULAR"));
            System.out.println(conex.rs.getString("CPF"));
            System.out.println(conex.rs.getString("CEP"));
            System.out.println(conex.rs.getString("RG"));
            System.out.println(conex.rs.getString("CRM"));
            System.out.println(conex.rs.getString("ESPEC"));
            System.out.println("-----------------------------------------");
             */
        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro erros ao carregar os dados do medico!\nErro: " + ex.getMessage());
        }
        conex.DesconectarBd();
        return mod;
    }

    public void Excluir(BeansMedico mod) {
        conex.conectarBd();
        String sql = "DELETE FROM MEDICO WHERE IDMEDICO = ? ";

        try {
            PreparedStatement pst = conex.con.prepareStatement(sql);
            pst.setInt(1, mod.getMcod());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados  excluidos com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(DaoMedico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro erros ao excluir os dados!\nErro: " + ex.getMessage());
        }

        conex.DesconectarBd();
    }

}
