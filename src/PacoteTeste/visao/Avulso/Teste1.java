/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteTeste.visao.Avulso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
/**
 *
 * @author Daniel Lucas
 */
public class Teste1 {

public void arquivo() {
      String linha = null;
 
      try {
         FileReader reader = new FileReader("C:/orderOn_2.txt"); // Localização do Arquivo
         BufferedReader leitor = new BufferedReader(reader);
         StringTokenizer st = null;
          
         String numero;         // Armazena campo de numero
         String matricula;      // Armazena campo de matricula
         String materia;        // Armazena campo de materia
         String prova;          // Armazena campo de prova
         String nota;           // Armazena campo de nota
 
         while ((linha = leitor.readLine()) != null) {
                                           
             
            // UTILIZA DELIMITADOR ; PARA DIVIDIR OS CAMPOS
            st = new StringTokenizer(linha, ";");
            String dados = null;
 
            while (st.hasMoreTokens()) {
 
               // Campo NUMERO
               dados = st.nextToken();
               numero = dados;
                
               // Campo MATRICULA
               dados = st.nextToken();
               matricula = dados;
                
               // Campo MATERIA
               dados = st.nextToken();
               materia = dados;
                
               // Campo PROVA
               dados = st.nextToken();
               prova = dados;
                
               // Campo Nota
               dados = st.nextToken();
               nota = dados;
                
               System.out.println("Numero do telefone " + numero);
               System.out.println("Numero da matricula " + matricula);
               System.out.println("Tag da materia " + materia);
               System.out.println("Prova " + prova);
               System.out.println("Nota " + nota);
            }
         }
         leitor.close();
         reader.close();
 
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
 
   public static void main(String[] args) {
      Teste1 t = new Teste1();
      t.arquivo();
   }
}
