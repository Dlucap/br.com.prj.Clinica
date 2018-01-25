/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteTeste.visao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Daniel Lucas
 */
public class javaaplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
          
            // Conteudo
            String content = "Teste 1 \r\n";

            // Cria arquivo
            File file = new File("teste.txt");

            // Se o arquivo nao existir, ele gera
            if (!file.exists()) {
                file.createNewFile();
              
            }

            // Prepara para escrever no arquivo
            //FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
                            
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(),true));
            
            // Escreve e fecha arquivo
            bw.write(content);
            bw.close();
            
            // Le o arquivo
            FileReader ler = new FileReader("teste.txt");
            BufferedReader reader = new BufferedReader(ler);  
            String linha;
            while( (linha = reader.readLine()) != null ){
                System.out.println(linha);
                 System.out.println(" " + file.getAbsolutePath());
               
            }
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
    

