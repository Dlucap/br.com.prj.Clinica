package ModeloDao;

import ModeloConection.ConexaoBd;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloBeans.BeansUsuario;
import visao.FormUsuario;

public class DaoUsuario {

    ConexaoBd conex = new ConexaoBd();
    BeansUsuario mod = new BeansUsuario();

    PreparedStatement pstU;

    public void Salvar(BeansUsuario mod) {
        conex.conectarBd();

        String sql1 = "INSERT INTO USUARIO (NOME,SENHA,EMAIL,TIPO,UENVIAEMAIL) VALUES (?,?,?,?,?)";

        try {
            pstU = conex.con.prepareStatement(sql1);

            pstU.setString(1, mod.getUNomeUser());
            pstU.setString(2, mod.getUSenhaUser());
            pstU.setString(3, mod.getUEmaiUser());
            pstU.setString(4, mod.getUTipo());
            pstU.setBoolean(5, mod.getUEnviaEmail());

            pstU.execute();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "\n Não foi possível realizar a inserção dos dados. \n\n" + ex.getMessage());
        }
        conex.DesconectarBd();
    }

    public void SalvarComEnvioEmail(BeansUsuario mod) {
        conex.conectarBd();

        String sql2 = "INSERT INTO USUARIO (NOME,SENHA,EMAIL,TIPO,USENHAEMAIL,USERSAISMTP,UPORTASMTP,UENVIAEMAIL) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        try {
            pstU = conex.con.prepareStatement(sql2);

            pstU.setString(1, mod.getUNomeUser());
            pstU.setString(2, mod.getUSenhaUser());
            pstU.setString(3, mod.getUEmaiUser());
            pstU.setString(4, mod.getUTipo());
            pstU.setString(5, mod.getUSenhaEmail());
            pstU.setString(6, mod.getUSerSaiSMTP());
            pstU.setInt(7, mod.getUSMTP());
            pstU.setBoolean(8, mod.getUEnviaEmail());

            pstU.execute();

            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!!!");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "\n Não foi possível realizar a inserção dos dados. \n\n" + ex.getMessage());
        }
        conex.DesconectarBd();
    }

    public void Editar(BeansUsuario mod) {
        conex.conectarBd();
        String sql4 = "UPDATE USUARIO SET NOME = ?, SENHA = ?,EMAIL = ?,TIPO = ?,UENVIAEMAIL = ? WHERE IDUSUARIO = ?";

        try {
            //PreparedStatement pst = conex.con.prepareStatement(sql);    
            pstU = conex.con.prepareStatement(sql4);

            pstU.setString(1, mod.getUNomeUser());
            pstU.setString(2, mod.getUSenhaUser());
            pstU.setString(3, mod.getUEmaiUser());
            pstU.setString(4, mod.getUTipo());
            pstU.setBoolean(5, mod.getUEnviaEmail());
            pstU.setInt(6, mod.getUCodUser());
            pstU.execute();

            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração do usuário:\nErro: " + ex);
        }

        conex.DesconectarBd();
    }

    public void EditarComEnvioEmail(BeansUsuario mod) {
        conex.conectarBd();
        String sql5 = "UPDATE USUARIO SET NOME = ?, SENHA = ?,EMAIL = ?,TIPO = ?,USENHAEMAIL = ?,"
                + "USERSAISMTP = ?,UENVIAEMAIL = ?, UPORTASMTP = ? WHERE IDUSUARIO = ?";

        try {
            //PreparedStatement pst = conex.con.prepareStatement(sql);    
            pstU = conex.con.prepareStatement(sql5);

            pstU.setString(1, mod.getUNomeUser());
            pstU.setString(2, mod.getUSenhaUser());
            pstU.setString(3, mod.getUEmaiUser());
            pstU.setString(4, mod.getUTipo());
            pstU.setString(5, mod.getUSenhaEmail());
            pstU.setString(6, mod.getUSerSaiSMTP());
            pstU.setBoolean(7, mod.getUEnviaEmail());
            pstU.setInt(8, mod.getUSMTP());
            pstU.setInt(9, mod.getUCodUser());
            pstU.execute();

            JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso.");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração do usuário:\nErro: " + ex);
        }

        conex.DesconectarBd();
    }

    public void Excluir(BeansUsuario mod) {
        conex.conectarBd();
        String sql6 = "DELETE FROM USUARIO WHERE IDUSUARIO = ? ";

        try {
            pstU = conex.con.prepareStatement(sql6);
            pstU.setInt(1, mod.getUCodUser());
            pstU.execute();
            JOptionPane.showMessageDialog(null, "Dados excluidos com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o usuario!\nErro: " + ex.getMessage());
        }
        conex.DesconectarBd();
    }

    public BeansUsuario buscaUsuario(BeansUsuario mod) {

        conex.conectarBd();

        String sql3 = "select * from usuario where nome like '%" + mod.getUPesquisa() + "%'";

        conex.executaSql(sql3);

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

}
