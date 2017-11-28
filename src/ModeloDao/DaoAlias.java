/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * http://www.mballem.com/post/manipulando-arquivo-txt-com-java/
 */
package ModeloDao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
 
/**
 *
 * @author Daniel Lucas
 */
public class DaoAlias {

 public final File file = new File("Alias.txt");
    private String Alias, Servidor, Banco, Porta;

    public void criaAlias() {

        try {
            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException ex) {
            System.out.println("Erro ao criar o arquivo Alias.txt: " + ex.getMessage());
        }
    }

    public void salvar(String alias, String servidor, String banco, String porta) {

        this.Alias = alias;
        this.Servidor = servidor;
        this.Banco = banco;
        this.Porta = porta;

        String caminho = Alias+";"+Servidor+";"+Banco +";"+Porta+"\r\n";
//                String caminho = "<BdAlias>\r\n<nomeAlias>" + alias + "</nomeAlias>\r\n<servidor>" + Servidor + "</servidor>\r\n"
//                + "<banco>" + Banco + "</banco>\r\n<porta>" + Porta + "</porta>\r\n</BdAlias>\r\n";
        //"jdbc:sqlserver://" + Servidor + ":" + Porta + ";databaseName=" + Banco;

        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            try {

                bw.write(caminho);
                try {
                    bw.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar o arquivo alias." + ex.getMessage());
                }
            } catch (IOException ex) {
                Logger.getLogger(DaoAlias.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao gravar o alias." + ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Alias cadastrado com sucesso.");
        } catch (IOException ex) {
            Logger.getLogger(DaoAlias.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar o alias cadastrado." + ex.getMessage());
        }
    }

    public void percorrerAlias(){
       
        try {

            //cria um scanner para ler o arquivo
            Scanner leitor = new Scanner(file);

            //variavel que armazenara as linhas do arquivo
            String linhasDoArquivo = new String();

            //ignora a primeira linha do arquivo
          //  leitor.nextLine();
            //percorre todo o arquivo
            while (leitor.hasNext()) {

                //recebe cada linha do arquivo
                linhasDoArquivo = leitor.nextLine();

                //separa os campos entre as virgulas de cada linha
                String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
                //imprime a coluna que quiser
                System.out.println(valoresEntreVirgulas[0]);
                 System.out.println(valoresEntreVirgulas);
            }

        } catch (FileNotFoundException e) {
            System.out.println("teste4: "+e);
        }
    }
        
}