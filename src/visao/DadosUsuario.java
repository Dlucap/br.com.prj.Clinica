/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import ModeloDao.DaoUsuario;
import ModeloConection.ConexaoBd;

/**
 *
 * @author Daniel Lucas
 */
public class DadosUsuario {

    DaoUsuario user;
    ConexaoBd con;

    String usuario;
    String nome;
     String senhaEmail;
     String email;
    Integer porta;
    String hostname;

//    DadosUsuario() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//   
   public void  DadosUsuario(){
       
   }
  

    public void DadosUsuario(String nome, String senhaEmail, String email, Integer porta, String hostname) {
    
        this.nome = nome;
        this.senhaEmail = senhaEmail;
        this.email = email;
        this.porta = porta;
        this.hostname = hostname;
        System.out.println(nome + senhaEmail + email + porta + hostname+" Teste de envio de dados - Msg DadosUsuários");

    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the senhaEmail
     */
    public String getSenhaEmail() {
        return senhaEmail;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the porta
     */
    public Integer getPorta() {
        return porta;
    }

    /**
     * @return the hostname
     */
    public String getHostname() {
        return hostname;
    }

}
