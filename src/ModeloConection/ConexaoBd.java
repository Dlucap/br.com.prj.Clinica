package ModeloConection;

/**
 * Hibernate http://www.devmedia.com.br/crud-completo-com-hibernate-e-jpa/32711
 */
import ModeloDao.DaoLog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * A classe ConexaoBd tem como objetivo conectar ao banco de dados MsSql sempre
 * que necessário. - Executar Consultas - insert´s - delete - update
 *
 * @author Daniel Lucas
 */
public class ConexaoBd {

    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc"; //private String driver = "com.mysql.jdbc";
    private String caminho = "jdbc:sqlserver://localhost:1433;databaseName=ClinicaMedica";
    //private String caminho = "jdbc:sqlserver://localhost:1433;databaseName=ClinicaMedicaMSSQL";
    // private String caminho = url;
    /**
     * Usuário utilizado para acesso no banco, o mesmo deve estar ativo e com
     * permissões de acesso.
     */
    private String usuario = "Admin";
    private String senha = "123456";
    private boolean  HabilitaProfiler = true;
    public Connection con;

    /**
     * Método usado para conectar ao banco de dados
     * http://ftp.unicamp.br/pub/apoio/treinamentos/linguagens/curso_java_III.pdf
     */
    public void conectarBd() {

        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver()); //Essa linha foi a diferença
            System.setProperty("jdbc.Drivers", driver);

            con = DriverManager.getConnection(caminho, usuario, senha);
            // con = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro !!!\n\n" ,"Erro ao se conectar ao banco de dados:\n" + ex.getMessage(),JOptionPane.ERROR);
        }
    }

    private void conectarBd(String baseDados,String server, Integer tipo) {
 
        String caminho2 = "jdbc:sqlserver://"+server+":1433;databaseName="+baseDados;
        try {
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            System.setProperty("jdbc.Drivers", driver);

            con = DriverManager.getConnection(caminho2, usuario, senha);
            if (tipo == 1) {
                JOptionPane.showMessageDialog(null, "Conectado com sucesso!", "Teste de conexão.", JOptionPane.INFORMATION_MESSAGE);
            }
            // con = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
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
        if(HabilitaProfiler){
             // futuramente adicionar qual meodo realizou a sentença
            DaoLog log = new DaoLog();
            Calendar hoje = Calendar.getInstance();
           String msg = "\t\nSentença Sql:\n\n"+hoje.getTime()+": \n"+sql;
            log.CriaAlias();
            log.salvar(msg);
            System.out.println(msg);
        }
        conectarBd();
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar a sentença em sql\n Sentença: " + sql + "\n Mensagem de erro.:" + ex.getMessage());
        
        } catch (NullPointerException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao exeucutar a sentença: " + sql +
                "\n\n Mensagem de erro.:" + ex.getMessage());
        }
    } 
}
