package ModeloConection;
/**
 * Hibernate 
 * http://www.devmedia.com.br/crud-completo-com-hibernate-e-jpa/32711
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import visao.FormAlias;

/**
 * A classe ConexaoBd tem como objetivo conectar ao banco de dados MsSql sempre
 * que necessário. - Executar Consultas - insert´s - delete - update
 *
 * @author Daniel Lucas
 */
public class ConexaoBd {

    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc";
    private String caminho = "jdbc:sqlserver://localhost:1433;databaseName=ClinicaMedica";
    // private String caminho = url;
    private String usuario = "Admin";
    private String senha = "12345";
    public Connection con;

    /**
     * Método usado para conectar ao bancod e dados
     * http://ftp.unicamp.br/pub/apoio/treinamentos/linguagens/curso_java_III.pdf
     */
    public void conectarBd() {

        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver()); //Essa linha foi a diferença
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(caminho, usuario, senha);
            // con = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao se conectar ao banco de dados:\n" + ex.getMessage());
        }
    }

    /**
     * Método utilizado para desconectar.
     */
    public void DesconectarBd() {
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "desconectado com sucesso" + this);
        } catch (SQLException ex) {
            //java.util.logging.Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão com o banco de dados:\n" + ex.getMessage());
        }
    }

    /**
     * Método usado para executar uma consulta sql, o mesmo possui uma string
     * "sentença Sql" como parametro.
     *
     * @param sql
     */
    public void executaSql(String sql) {
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a sentença em sql\n" + ex.getMessage());
        }
        
    }
    
}
