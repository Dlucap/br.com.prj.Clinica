package ModeloDao;

import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloBeans.BeansEnfermeiro;

/**
 *
 * @author Daniel Lucas
 */
public class DaoEnfermeiro {

    ConexaoBd conex = new ConexaoBd();
    BeansEnfermeiro mod = new BeansEnfermeiro();
   

    PreparedStatement pstE;

    public void salvar(BeansEnfermeiro mod) {
        conex.conectarBd();
        String sql = "INSERT INTO ENFERMEIRO (NOMEENFERMEIRO ,CPF ,RG ,TELRESIDENCIAL ,TELCELULAR ,LOGRADOURO ,BAIRRO,"
                + "NUMERO ,CEP ,COMPL ,EMAIL ,COREN ,ESTADO ,CIDADE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
       
        try {
           
            pstE = conex.con.prepareStatement(sql);
            
            pstE.setString(1, mod.getENome());
            pstE.setString(2, mod.getECpf());
            pstE.setString(3, mod.getERg());
            pstE.setString(4, mod.getETelResidencial());
            pstE.setString(5, mod.getETelCelular());
            pstE.setString(6, mod.getELogradouro());
            pstE.setString(7, mod.getEBairro());
            pstE.setInt(8, mod.getENumero());
            pstE.setString(9, mod.getECep());
            pstE.setString(10, mod.getECompl());
            pstE.setString(11, mod.getEEmail());
            pstE.setString(12, mod.getECoren());
            pstE.setString(13, mod.getESUf());
            pstE.setString(14, mod.getECidade());
            pstE.execute();
           

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n Não foi possível realizar a inserção dos dados. \n\n" + ex.getMessage() + "\n");
           
        }
        conex.DesconectarBd();
    }

    public void Editar(BeansEnfermeiro mod) {
        conex.conectarBd();

        String sql = "UPDATE ENFERMEIRO SET NOMEENFERMEIRO = ?,CPF = ?, RG = ?,TELRESIDENCIAL = ?,TELCELULAR = ?,LOGRADOURO = ?,BAIRRO = ?,"
                + "NUMERO = ?,CEP = ?,COMPL = ?,COREN = ?,ESTADO = ?,CIDADE =?,EMAIL=? WHERE IDENFERMEIRO = ?";

        try {
            pstE = conex.con.prepareStatement(sql);

            pstE.setString(1, mod.getENome());
            pstE.setString(2, mod.getECpf());
            pstE.setString(3, mod.getERg());
            pstE.setString(4, mod.getETelResidencial());
            pstE.setString(5, mod.getETelCelular());
            pstE.setString(6, mod.getELogradouro());
            pstE.setString(7, mod.getEBairro());
            pstE.setInt(8, mod.getENumero());
            pstE.setString(9, mod.getECep());
            pstE.setString(10, mod.getECompl());
            pstE.setString(11, mod.getECoren());
            pstE.setString(12, mod.getESUf());
            pstE.setString(13, mod.getECidade());
            pstE.setString(14, mod.getEEmail());
            pstE.setInt(15, mod.getECod());

            pstE.execute();

            JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados! \nErro: " + ex.getMessage());
        }

        conex.DesconectarBd();
    }

    public BeansEnfermeiro buscaEnfermeiro(BeansEnfermeiro mod) {

        conex.conectarBd();

        String sql1 = "select IDENFERMEIRO,NOMEENFERMEIRO,LOGRADOURO,NUMERO,BAIRRO,CPF,RG,TELRESIDENCIAL,TELCELULAR,"
                + "COREN,CEP,COMPL,CIDADE,ESTADO,EMAIL from ENFERMEIRO where NOMEENFERMEIRO like '%" + mod.getEPesquisa() + "%'";

        conex.executaSql(sql1);

        try {
            conex.rs.first();
            mod.setECod(conex.rs.getInt("IDENFERMEIRO"));
            mod.setENome(conex.rs.getString("NOME"));
            mod.setELogradouro(conex.rs.getString("LOGRADOURO"));
            mod.setENumero(conex.rs.getInt("NUMERO"));
            mod.setEBairro(conex.rs.getString("BAIRRO"));
            mod.setECpf(conex.rs.getString("CPF"));
            mod.setERg(conex.rs.getString("RG"));
            mod.setETelResidencial(conex.rs.getString("TELRESIDENCIAL"));
            mod.setETelCelular(conex.rs.getString("TELCELULAR"));
            mod.setECoren(conex.rs.getString("COREN"));
            mod.setECep(conex.rs.getString("CEP"));
            mod.setECompl(conex.rs.getString("COMPL"));
            mod.setECidade(conex.rs.getString("CIDADE"));
            mod.setESUf(conex.rs.getString("ESTADO"));
            mod.setEEmail(conex.rs.getString("EMAIL"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados do medico!\nErro: " + ex.getMessage());
        }
        conex.DesconectarBd();
        return mod;
    }

    public void Excluir(BeansEnfermeiro mod) {
        conex.conectarBd();
        String sql = "DELETE FROM ENFERMEIRO WHERE IDENFERMEIRO = ? ";

        try {
           
            PreparedStatement pst = conex.con.prepareStatement(sql);
            pst.setInt(1, mod.getECod());
            pst.execute();
           
            JOptionPane.showMessageDialog(null, "Dados  excluidos com sucesso!");
        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, "Enfermeiro não cadastrado na base de dados!\nErro: " + ex.getMessage());
        }

        conex.DesconectarBd();
    }

}
