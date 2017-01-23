/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prj.clinica;

import ModeloConection.ConexaoBd;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Lucas
 */
public class TelaPrincipal extends javax.swing.JFrame {

    ConexaoBd conecta = new ConexaoBd();

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        conecta.conectarBd();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TelaBemVindo = new javax.swing.JInternalFrame();
        jPanelTelaSejaBemVindo = new javax.swing.JPanel();
        jLabelAgenda = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnCadMedico = new javax.swing.JButton();
        BtnEnfermeira = new javax.swing.JButton();
        BtnPaciente = new javax.swing.JButton();
        BtnAgenda = new javax.swing.JButton();
        jLabelPainelfundo11 = new javax.swing.JLabel();
        jLabelPainelFundo1 = new javax.swing.JLabel();
        BtnFechaInternalFrame = new javax.swing.JButton();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jLabelFundoPrincipal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuCadMedicos = new javax.swing.JMenuItem();
        jMenuCadPaciente = new javax.swing.JMenuItem();
        jMenuCadEnfermeiro = new javax.swing.JMenuItem();
        jMenuCadUsuario = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuFerramenta = new javax.swing.JMenu();
        jMenuTelaBemVindo = new javax.swing.JMenuItem();
        jMenuAjuda = new javax.swing.JMenu();
        jMenuItemAjuda = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuISairb = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        TelaBemVindo.setTitle("Seja Bem-Vindo");
        TelaBemVindo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TelaBemVindo.setVisible(true);
        TelaBemVindo.getContentPane().setLayout(null);

        jPanelTelaSejaBemVindo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTelaSejaBemVindo.setLayout(null);

        jLabelAgenda.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabelAgenda.setText("Agenda :");
        jPanelTelaSejaBemVindo.add(jLabelAgenda);
        jLabelAgenda.setBounds(10, 160, 70, 19);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("Cadastro :");
        jPanelTelaSejaBemVindo.add(jLabel2);
        jLabel2.setBounds(10, 0, 100, 40);

        BtnCadMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/CadMedicos.png"))); // NOI18N
        BtnCadMedico.setToolTipText("Cadastro de Médicos");
        BtnCadMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCadMedicoActionPerformed(evt);
            }
        });
        jPanelTelaSejaBemVindo.add(BtnCadMedico);
        BtnCadMedico.setBounds(10, 30, 110, 120);

        BtnEnfermeira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon-infermeira.png"))); // NOI18N
        BtnEnfermeira.setToolTipText("Cadastro de Enfermeiras");
        jPanelTelaSejaBemVindo.add(BtnEnfermeira);
        BtnEnfermeira.setBounds(120, 30, 100, 120);

        BtnPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadPacientes.png"))); // NOI18N
        BtnPaciente.setToolTipText("Cadastro de Pacientes");
        jPanelTelaSejaBemVindo.add(BtnPaciente);
        BtnPaciente.setBounds(220, 30, 100, 120);

        BtnAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Agenda.png"))); // NOI18N
        BtnAgenda.setToolTipText("");
        jPanelTelaSejaBemVindo.add(BtnAgenda);
        BtnAgenda.setBounds(10, 180, 120, 110);

        jLabelPainelfundo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/internalframe.png"))); // NOI18N
        jPanelTelaSejaBemVindo.add(jLabelPainelfundo11);
        jLabelPainelfundo11.setBounds(0, 0, 1220, 300);

        TelaBemVindo.getContentPane().add(jPanelTelaSejaBemVindo);
        jPanelTelaSejaBemVindo.setBounds(0, 50, 1220, 320);

        jLabelPainelFundo1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabelPainelFundo1.setText("Sistema de Gerenciamento de:");
        TelaBemVindo.getContentPane().add(jLabelPainelFundo1);
        jLabelPainelFundo1.setBounds(10, 10, 250, 40);

        BtnFechaInternalFrame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/exit.png"))); // NOI18N
        BtnFechaInternalFrame.setToolTipText("Fechar Tela Bem vindo");
        BtnFechaInternalFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFechaInternalFrameActionPerformed(evt);
            }
        });
        TelaBemVindo.getContentPane().add(BtnFechaInternalFrame);
        BtnFechaInternalFrame.setBounds(1170, 0, 50, 50);

        getContentPane().add(TelaBemVindo);
        TelaBemVindo.setBounds(0, 290, 1240, 390);

        jCalendar2.setBackground(new java.awt.Color(202, 211, 229));
        getContentPane().add(jCalendar2);
        jCalendar2.setBounds(830, 10, 400, 230);

        jLabelFundoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo_telaprincipal.jpg"))); // NOI18N
        getContentPane().add(jLabelFundoPrincipal);
        jLabelFundoPrincipal.setBounds(0, 0, 1240, 1060);

        jMenuCadastro.setText("Cadastros");

        jMenuCadMedicos.setText("Medicos");
        jMenuCadMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadMedicosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadMedicos);

        jMenuCadPaciente.setText("Pacientes");
        jMenuCadastro.add(jMenuCadPaciente);

        jMenuCadEnfermeiro.setText("Enfermeiros");
        jMenuCadastro.add(jMenuCadEnfermeiro);

        jMenuCadUsuario.setText("Usuários");
        jMenuCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadUsuarioActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadUsuario);

        jMenuBar1.add(jMenuCadastro);

        jMenu2.setText("Relatórios");
        jMenuBar1.add(jMenu2);

        jMenuFerramenta.setText("Ferramentas");

        jMenuTelaBemVindo.setText("Tela Bem-Vindos");
        jMenuTelaBemVindo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTelaBemVindoActionPerformed(evt);
            }
        });
        jMenuFerramenta.add(jMenuTelaBemVindo);

        jMenuBar1.add(jMenuFerramenta);

        jMenuAjuda.setText("Ajuda");

        jMenuItemAjuda.setText("Ajuda");
        jMenuAjuda.add(jMenuItemAjuda);

        jMenuBar1.add(jMenuAjuda);

        jMenuSair.setText("Sair");

        jMenuISairb.setText("Sair");
        jMenuISairb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuISairbActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuISairb);

        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(1259, 738));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuCadUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuCadUsuarioActionPerformed

    private void BtnFechaInternalFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFechaInternalFrameActionPerformed
        TelaBemVindo.dispose();

    }//GEN-LAST:event_BtnFechaInternalFrameActionPerformed

    private void jMenuTelaBemVindoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTelaBemVindoActionPerformed
        TelaBemVindo.setVisible(true);

    }//GEN-LAST:event_jMenuTelaBemVindoActionPerformed

    private void jMenuISairbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuISairbActionPerformed
        conecta.DesconectarBd();
        System.exit(0);
    }//GEN-LAST:event_jMenuISairbActionPerformed

    private void jMenuCadMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadMedicosActionPerformed
        FormMedico med = new FormMedico();
        med.setVisible(true);
    }//GEN-LAST:event_jMenuCadMedicosActionPerformed

    private void BtnCadMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadMedicoActionPerformed
        FormMedico med = new FormMedico();
        med.setVisible(true);
    }//GEN-LAST:event_BtnCadMedicoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgenda;
    private javax.swing.JButton BtnCadMedico;
    private javax.swing.JButton BtnEnfermeira;
    private javax.swing.JButton BtnFechaInternalFrame;
    private javax.swing.JButton BtnPaciente;
    private javax.swing.JInternalFrame TelaBemVindo;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAgenda;
    private javax.swing.JLabel jLabelFundoPrincipal;
    private javax.swing.JLabel jLabelPainelFundo1;
    private javax.swing.JLabel jLabelPainelfundo11;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuAjuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCadEnfermeiro;
    private javax.swing.JMenuItem jMenuCadMedicos;
    private javax.swing.JMenuItem jMenuCadPaciente;
    private javax.swing.JMenuItem jMenuCadUsuario;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuFerramenta;
    private javax.swing.JMenuItem jMenuISairb;
    private javax.swing.JMenuItem jMenuItemAjuda;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenuItem jMenuTelaBemVindo;
    private javax.swing.JPanel jPanelTelaSejaBemVindo;
    // End of variables declaration//GEN-END:variables
}