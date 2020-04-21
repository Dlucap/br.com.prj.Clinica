package ModeloDao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Lucas
 */
public class DaoLog {

    Date data = new Date(System.currentTimeMillis());
    SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
    
    public final File file = new File(formatarDate.format(data) + "_ProfilerBanco.txt");
    private String msg;

    public void CriaAlias() {

        try {
            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException ex) {
            System.out.println("Erro ao criar o arquivo do profiler" + ex.getMessage());
        }
    }

    //public void salvar(Date data,String sql,String metodoDate) {
    public void salvar(String msg) {
        this.msg = msg;

        StringBuilder msgLog = new StringBuilder();

        try {
            FileWriter fileWriter  = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            try {
                bufferedWriter.write(String.valueOf(msgLog.append(msg)));
                bufferedWriter.newLine();
                bufferedWriter.flush();

                try {
                    bufferedWriter.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar o arquivo de log." + ex.getMessage());
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar o log." + ex.getMessage());
            }

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o alias cadastrado." + ex.getMessage());
        }
    }
}
