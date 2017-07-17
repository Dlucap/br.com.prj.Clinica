/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

/**
 *
 * @author Daniel Lucas
 */
public class DaoDadosUsuario {

    private String usuario;
    public static String nome;
    private String senhaEmail;
    private String email;
    private Integer porta;
    private String hostname;

    public  DaoDadosUsuario() {
        
    }

    public  DaoDadosUsuario(String nome, String senhaEmail, String email, Integer porta, String hostname) {

        this.nome = nome;
        this.senhaEmail = senhaEmail;
        this.email = email;
        this.porta = porta;
        this.hostname = hostname;
   
    }
  
}
