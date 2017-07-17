/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Lucas
 */
public class ModeloAlias {
 private static File arquivo;
    
   
    public  void ModeloAlias(){
         arquivo = new File("src/arquivo.txt");           
         criaArquivo();
         leArquivo();            
    }
    
    
    public void criaArquivo(){
          try {  
             DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(getClass()
                        .getResourceAsStream("arquivo.txt").toString())));  
                dos.writeChars("Fernando Paiva");  
                dos.close();  
          } catch (IOException ex) {  
                JOptionPane.showMessageDialog(null, ex.getMessage());  
          }  
    }
    public void leArquivo(){
         DataInputStream dis = null; 
     try {
         dis = new DataInputStream(new FileInputStream(arquivo));
     } catch (FileNotFoundException ex) {
         System.out.println(ex);
     }
       
          // long data = dis.readChar(data);
                  
           //System.out.println(data);
     try {
         dis.close();
     } catch (IOException ex) {
         System.out.println(ex);
     }
    }
    
    
    
}

