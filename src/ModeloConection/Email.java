/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConection;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


/**
 *
 * @author Daniel Lucas
 */
public class Email {
    org.apache.commons.mail.Email email;
    // email = new SimpleEmail();
     
     public void configuracao(String hostName,/*Integer SmtpPort,Integer SSL,Integer TLS,*/Integer Autentic) {

        email.setHostName(hostName);//servidor de email
        email.setSmtpPort(465); //porta de conexão pode deixar comentado
        email.setSSL(true);
        email.setTLS(true);
        email.setDebug(true);
//        if (Autentic == 1) {
//             jTextFieldEmailUsu.setEnabled(true);
//          jPasswordFieldSenhaUsu.setEnabled(true);
//            email.setAuthentication(jTextFieldEmailUsu.getText(), jPasswordFieldSenhaUsu.getText()); //usuário e senha 
////email.setAuthenticator(new DefaultAuthenticator("username", "password")); //usuário e senha 
//        } else {
//            System.out.println("visao.FormEnvioEmail.configuracao()");
//            jTextFieldEmailUsu.setEnabled(false);
//          jPasswordFieldSenhaUsu.setEnabled(false);
//        }

        email.setSSLOnConnect(true);// ssl conexão segura

    }

    public void enviarEmail(String from, String subject, String msg, String to) {
        try {
            email.setFrom(from);//quem está enviando 
            email.setSubject(subject); //assunto
            email.setMsg(msg); // mensagem
            email.addTo(to); // quem recebe
            email.addReplyTo(from);
            email.send();// envio do email

        } catch (EmailException ex) {

        }
    }

  }
