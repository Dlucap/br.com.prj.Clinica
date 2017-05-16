/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConection;

import javax.swing.JOptionPane;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Daniel Lucas
 */
public class Email {

    org.apache.commons.mail.Email email;

    String hostname, emailUsuario, senha;
    Integer porta;

    public void Email(String hostname, Integer porta, String emailUsuario, String senha) {
        email = new SimpleEmail();
        this.hostname = hostname;
        this.porta = porta;
        this.emailUsuario = emailUsuario;
        this.senha = senha;
        configuracao(hostname, porta, emailUsuario, senha);
    }

    // public void configuracao(String hostname, Integer porta,String email1, String senha) {
    public void configuracao(String hostname, Integer porta, String email1, String senha) {

        email.setHostName(hostname);//servidor de email
        email.setAuthentication(email1,senha);//usuário e senha 
        email.setSmtpPort(porta); //porta de conexão pode deixar comentado
        email.setSSL(true);
        //email.setStartTLSEnabled(true);
        //email.setTLS(true);
        email.setSSLOnConnect(true);// ssl conexão segura
        email.setDebug(true);
    }
  
       public void enviarEmail(String from, String subject, String msg, String to) {
        // public void enviarEmail() {
        try {
             
            email.setFrom(from);//quem está enviando 
            email.setSubject(subject); //assuntoe
            email.setMsg(msg); // mensagem
            email.addTo(to); // quem recebe
                
            email.send();// envio do email
            email.setDebug(true);
            
        } catch (EmailException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
              System.out.println(ex);

            //ex.printStackTrace();
           // ex.getMessage();
        }
    }
}
