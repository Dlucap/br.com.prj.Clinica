package ModeloDao;

import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloBeans.BeansUsuario;

public class DaoUsuario {

    ConexaoBd conex = new ConexaoBd();
    BeansUsuario mod = new BeansUsuario();

    PreparedStatement pstM;

    public void Salvar(BeansUsuario mod) {
        conex.conectarBd();

        String sql = "insert into usuario (NOME ,SENHA,EMAIL, TIPO) values (?,?,?,?)";

        try {
            pstM = conex.con.prepareStatement(sql);

            pstM.setString(1, mod.getUNomeUser());
            pstM.setString(2, mod.getUSenhaUser());
            pstM.setString(3, mod.getUEmaiUser());
            pstM.setString(4, mod.getUTipo());

            pstM.execute();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "\n Não foi possível realizar a inserção dos dados. \n\n" + ex.getMessage());
        }
        conex.DesconectarBd();
    }

    public BeansUsuario buscaUsuario(BeansUsuario mod) {

        conex.conectarBd();

        String sql1 = "select * from usuario where nome like '%" + mod.getUPesquisa() + "%'";

        conex.executaSql(sql1);

        try {
            conex.rs.first();
            mod.setUCodUser(conex.rs.getInt("IDUSUARIO"));
            mod.setUNomeUser(conex.rs.getString("NOME"));
            mod.setUEmaiUser(conex.rs.getString("EMAIL"));
            mod.setUSenhaUser(conex.rs.getString("SENHA"));
            mod.setUTipo(conex.rs.getString("TIPO"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
        }
        conex.DesconectarBd();
        return mod;
    }

    public void Editar(BeansUsuario mod) {
        conex.conectarBd();
        String sql = "UPDATE USUARIO SET NOME = ?, SENHA = ?,EMAIL = ?,TIPO = ? WHERE IDUSUARIO = ?";

        try {
            //PreparedStatement pst = conex.con.prepareStatement(sql);    
            pstM = conex.con.prepareStatement(sql);

            pstM.setString(1, mod.getUNomeUser());
            pstM.setString(2, mod.getUSenhaUser());
            pstM.setString(3, mod.getUEmaiUser());
            pstM.setString(4, mod.getUTipo());
            pstM.setInt(5, mod.getUCodUser());

            pstM.execute();

            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração do usuário:\nErro: " + ex);
                   }

        conex.DesconectarBd();
    }
public void Excluir(BeansUsuario mod) {
        conex.conectarBd();
        String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = ? ";

        try {
            PreparedStatement pst = conex.con.prepareStatement(sql);
            pst.setInt(1, mod.getUCodUser());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o usuario!\nErro: " + ex.getMessage());
        }
        conex.DesconectarBd();
    }
}
