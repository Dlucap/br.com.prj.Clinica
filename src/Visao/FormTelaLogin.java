//https://www.youtube.com/watch?v=OfsCClnnY6U&list=PLyQ9CRKOzOWqVZ5nDspGFVgybs3zRGPUL video 13
/**
 *    ANDAMENTO DO PROJETO
 *https://cachina.wordpress.com/2008/03/17/muito-material-sobre-java-mega-post/
 * ferramentas / tela de bemvindos ok
 * tela Cadastro medio ok
 * Acesso ao banco de dados ok
 * Cadastro enfermeira
 * cadastro paciente
 * Pesquisa
 * Relatório
 * links para baixar icones
 *https://www.iconfinder.com/search/?q=medico 
 * http://www.iconspedia.com/pack/medico-icons-3755/30.html
 * https://www.youtube.com/playlist?list=PLDXIzdVtlj9OWro7dFDE6HE9VZ7sukYUl
 * https://viacep.com.br/ CEP mais completo
 * http://findicons.com/icon/193102/stock_mail_send icones 0800
 *
 */
package Visao;

import PacoteTeste.visao.FormAlias;
import ModeloBeans.BeansDadosUsuario;
import ModeloConection.ConexaoBd;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloDao.DaoCripSenhaUser;


/**
 * @author Daniel Lucas
 */
public class FormTelaLogin extends javax.swing.JFrame {

    ConexaoBd con = new ConexaoBd();
    String nome, senhaEmail, email, smtp, usuario;
    Integer porta;

    /**
     * Creates new form visão
     */
    public FormTelaLogin() {
        initComponents();
        con.conectarBd();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnAcessar = new javax.swing.JButton();
        BtnSair = new javax.swing.JButton();
        jLabelSenhaUsuario = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jPasswordFieldUsuario = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jButtonBancoDados = new javax.swing.JButton();
        choiceBancoDados = new java.awt.Choice();
        JLTelaLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Clinica Medica");
        setUndecorated(true);
        getContentPane().setLayout(null);

        BtnAcessar.setText("Acessar");
        BtnAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAcessarActionPerformed(evt);
            }
        });
        BtnAcessar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAcessarKeyPressed(evt);
            }
        });
        getContentPane().add(BtnAcessar);
        BtnAcessar.setBounds(270, 260, 80, 30);

        BtnSair.setText("Sair");
        BtnSair.setMaximumSize(new java.awt.Dimension(73, 28));
        BtnSair.setMinimumSize(new java.awt.Dimension(73, 28));
        BtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSairActionPerformed(evt);
            }
        });
        getContentPane().add(BtnSair);
        BtnSair.setBounds(360, 260, 80, 30);

        jLabelSenhaUsuario.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        jLabelSenhaUsuario.setText("Senha");
        getContentPane().add(jLabelSenhaUsuario);
        jLabelSenhaUsuario.setBounds(20, 110, 50, 30);

        jLabelUsuario.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        jLabelUsuario.setText("Usuário");
        getContentPane().add(jLabelUsuario);
        jLabelUsuario.setBounds(20, 60, 54, 21);
        getContentPane().add(jTextFieldUsuario);
        jTextFieldUsuario.setBounds(20, 80, 140, 28);

        jPasswordFieldUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordFieldUsuario);
        jPasswordFieldUsuario.setBounds(20, 140, 140, 28);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 16)); // NOI18N
        jLabel1.setText("Banco de Dados");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 180, 120, 21);

        jButtonBancoDados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Bd.png"))); // NOI18N
        jButtonBancoDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBancoDadosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonBancoDados);
        jButtonBancoDados.setBounds(170, 200, 30, 30);

        choiceBancoDados.setName(""); // NOI18N
        getContentPane().add(choiceBancoDados);
        choiceBancoDados.setBounds(20, 210, 140, 40);

        JLTelaLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundotelaLogin.png"))); // NOI18N
        JLTelaLogin.setName(""); // NOI18N
        getContentPane().add(JLTelaLogin);
        JLTelaLogin.setBounds(0, 0, 490, 300);

        setSize(new java.awt.Dimension(488, 298));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAcessarActionPerformed
       BeansDadosUsuario dadosUser = new BeansDadosUsuario();
        try {
            con.executaSql("SELECT NOME,USENHAEMAIL,EMAIL,UPORTASMTP,USERSAISMTP,"
                    + "SENHA FROM USUARIO WHERE NOME ='" + jTextFieldUsuario.getText() + "' AND ATIVO = 1");
            con.rs.first();

            if (con.rs.getString("SENHA").equals(DaoCripSenhaUser.codificaBase64Encoder(jPasswordFieldUsuario.getText()))) {
                FormTelaPrincipal tela = new FormTelaPrincipal(con.rs.getString("NOME"));
/**
 * Busca os dados de login do usuário
 */
//                DaoDadosUsuario dados = new DaoDadosUsuario(con.rs.getString("NOME"),
//                                                         con.rs.getString("USENHAEMAIL"),
//                                                            con.rs.getString("EMAIL"),
//                                                            con.rs.getInt("UPORTASMTP"),
//                                                            con.rs.getString("USERSAISMTP"));

//                dadosUser.setEmail(con.rs.getString("EMAIL"));
//                dadosUser.setNome(con.rs.getString("NOME"));
//                dadosUser.setPortaSmtp(con.rs.getInt("UPORTASMTP"));
//                dadosUser.setSenhaEmail(con.rs.getString("USENHAEMAIL"));
//                dadosUser.setSmtp( con.rs.getString("USERSAISMTP"));
                
                tela.setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(rootPane, "Usuário/Senha inválido ou não cadastrado no sistema!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Usuário/Senha inválido ou não cadastrado no sistema!\n Erro:" + ex);
        }

        con.DesconectarBd();

    }//GEN-LAST:event_BtnAcessarActionPerformed

    private void BtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSairActionPerformed
        dispose();
    }//GEN-LAST:event_BtnSairActionPerformed

    private void jPasswordFieldUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldUsuarioActionPerformed
    }//GEN-LAST:event_jPasswordFieldUsuarioActionPerformed

    private void BtnAcessarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAcessarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            try {
                con.executaSql("SELECT * FROM USUARIO WHERE NOME ='" + jTextFieldUsuario.getText() + "'");
                con.rs.first();

                if (con.rs.getString("SENHA").equals(DaoCripSenhaUser.codificaBase64Encoder(jPasswordFieldUsuario.getText()))) {
                    FormTelaPrincipal tela = new FormTelaPrincipal(jTextFieldUsuario.getText());

                    tela.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Usuário/Senha inválido ou não cadastrado no sistema!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Usuário/Senha inválido ou não cadastrado no sistema!\nErro:" + ex);
            }
            con.DesconectarBd();
        }
    }//GEN-LAST:event_BtnAcessarKeyPressed

    private void jButtonBancoDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBancoDadosActionPerformed
        // TODO add your handling code here:
        FormAlias bd = new FormAlias();
        bd.setVisible(true);
    }//GEN-LAST:event_jButtonBancoDadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAcessar;
    private javax.swing.JButton BtnSair;
    private javax.swing.JLabel JLTelaLogin;
    private java.awt.Choice choiceBancoDados;
    private javax.swing.JButton jButtonBancoDados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelSenhaUsuario;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPasswordField jPasswordFieldUsuario;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}