/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * http://www.mballem.com/post/manipulando-arquivo-txt-com-java/
 */
package ModeloDao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Lucas
 */
public class DaoAlias {

    public final File file = new File("Alias.txt");
    private String Alias, Servidor, Banco, Porta;

    public void CriaAlias() {

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

        String caminho = Alias.trim() + ";" + Servidor.trim() + ";" + Banco.trim() + ";" + Porta.trim();

        try {
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            try {
                bufferedWriter.write(caminho.trim());
                bufferedWriter.newLine();
                bufferedWriter.flush();

                try {
                    bufferedWriter.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao fechar o arquivo alias." + ex.getMessage());
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao gravar o alias." + ex.getMessage());
            }
            JOptionPane.showMessageDialog(null, "Alias cadastrado com sucesso.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar o alias cadastrado." + ex.getMessage());
        }
    }

    public String percorrerAlias() {

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
                return valoresEntreVirgulas[0];
            }

        } catch (FileNotFoundException e) {
            System.out.println("teste4: " + e);
        }
        return null;
    }

    public void alteraLinha(String linhaAntiga, String linhaNova) throws IOException {
        String arquivo = "Alias";
        String arquivoTmp = "Alias-tmp";

        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));

        String linha;
        while ((linha = reader.readLine()) != null) {
            if (linha.contains(linhaAntiga)) {
                linha = linha.replace(linhaAntiga, linhaNova);
            }
            writer.write(linha + "\n");
        }

        writer.close();
        reader.close();

        new File(arquivo).delete();
        new File(arquivoTmp).renameTo(new File(arquivo));
    }
}
