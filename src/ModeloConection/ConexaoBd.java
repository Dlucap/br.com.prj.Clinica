package ModeloConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.JOptionPane;

public class ConexaoBd {

    public Statement stm;
    public ResultSet rs;
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String caminho = "jdbc:sqlserver://localhost:1433;databaseName=ClinicaMedica";
    private String usuario = "Admin";
    private String senha = "12345";
    public Connection con;

    public void conectarBd() {

        try {
            // Class.forName("com.mysql.jdbc.Driver");http://ftp.unicamp.br/pub/apoio/treinamentos/linguagens/curso_java_III.pdf
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver()); //Essa linha foi a diferença
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao se conectar ao banco de dados:\n" + ex.getMessage());
        }
    }

    public void DesconectarBd() {
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "desconectado com sucesso" + this);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão com o banco de dados:\n" + ex.getMessage());
        }

    }
    
    public void executaSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, "Erro ao executar a sentença em sql\n" + ex.getMessage());
                  JOptionPane.showMessageDialog(null, "Erro ao executar a sentença em sql\n" + ex.getSQLState());
                  JOptionPane.showMessageDialog(null, "Erro ao executar a sentença em sql\n" + ex);
                  JOptionPane.showMessageDialog(null, "Erro ao executar a sentença em sql\n" + ex.getCause());
                  JOptionPane.showMessageDialog(null, "Erro ao executar a sentença em sql\n" + ex.getErrorCode());
                 
        }
    }
}
