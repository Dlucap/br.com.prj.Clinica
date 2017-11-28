/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloBeans;

/**
 *
 * @author Daniel Lucas
 */
public class BeansDadosUsuario {
    
   private String Nome,senhaEmail,Email,Smtp;
   private int portaSmtp;

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getSenhaEmail() {
        return senhaEmail;
    }

    public void setSenhaEmail(String senhaEmail) {
        this.senhaEmail = senhaEmail;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSmtp() {
        return Smtp;
    }

    public void setSmtp(String Smtp) {
        this.Smtp = Smtp;
    }

    public int getPortaSmtp() {
        return portaSmtp;
    }

    public void setPortaSmtp(int portaSmtp) {
        this.portaSmtp = portaSmtp;
    }
     
}
