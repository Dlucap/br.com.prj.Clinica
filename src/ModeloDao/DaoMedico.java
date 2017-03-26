package ModeloDao;

import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloBeans.BeansMedico;

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
        String sql = "INSERT INTO MEDICO (NOME ,CPF ,RG ,TELRESIDENCIAL ,TELCELULAR ,LOGRADOURO ,BAIRRO ,"
                + "NUMERO ,CEP ,COMPL ,CRM ,IDESPECIALIDADE ,CIDADE ,ESTADO,EMAIL) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            pstM.setInt(12, mod.getMespecialidade());
            pstM.setString(13, mod.getMSCidade());
            pstM.setString(14, mod.getMSUf());
            pstM.setString(15, mod.getMEmail());

            pstM.execute();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");
        } catch (SQLException ex) {
           // med.HabilitarCampos();
            JOptionPane.showMessageDialog(null, "\n Não foi possível realizar a inserção dos dados. \n\n" + ex.getMessage() + "\n");
         }
        conex.DesconectarBd();
    }

    public void Editar(BeansMedico mod) {
        conex.conectarBd();

        String sql = "UPDATE MEDICO SET NOME = ?,CPF = ?, RG = ?, TELRESIDENCIAL = ?,TELCELULAR = ?,LOGRADOURO = ?, BAIRRO = ?,"
                + "NUMERO = ?,CEP = ?,COMPL = ?,CRM = ?,IDESPECIALIDADE = ?,ESTADO = ?,CIDADE = ? ,EMAIL=? WHERE IDMEDICO = ?";

        try {
            //PreparedStatement pst = conex.con.prepareStatement(sql);    
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
            pstM.setInt(12, (mod.getMespecialidade()));
            pstM.setString(13, (mod.getMSUf()));
            pstM.setString(14, (mod.getMSCidade()));
            pstM.setString(15, mod.getMEmail());
            pstM.setInt(16, mod.getMcod());

            pstM.execute();

            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! \nErro: " + ex.getMessage());
        }

        conex.DesconectarBd();
    }

    public BeansMedico buscaMedico(BeansMedico mod) {

        conex.conectarBd();

        String sql1 = "select * from medico inner join ESPECIALIDADE on MEDICO.IDESPECIALIDADE = especialidade.idESPECIALIDADE "
                + "where medico.nome like '%" + mod.getMPesquisa() + "%'";

        conex.executaSql(sql1);

        try {
            conex.rs.first();
            mod.setMcod(conex.rs.getInt("IDMEDICO"));
            mod.setMnome(conex.rs.getString("Nome"));
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
            mod.setMSCidade(conex.rs.getString("CIDADE"));
            mod.setMSUf(conex.rs.getString("ESTADO"));
            mod.setMSespecialidade(conex.rs.getString("ESPEC"));
            mod.setMEmail(conex.rs.getString("EMAIL"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados do medico!\nErro: " + ex.getMessage());
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

            JOptionPane.showMessageDialog(null, "Medico não cadastrado na base de dados!\nErro: " + ex.getMessage());
        }
        conex.DesconectarBd();
    }

}
