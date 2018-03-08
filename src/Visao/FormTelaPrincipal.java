/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Visao.FormAgendamento;
import ModeloConection.ConexaoBd;
import com.toedter.calendar.JCalendar;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Lucas
 */
public class FormTelaPrincipal extends javax.swing.JFrame {

    ConexaoBd conecta = new ConexaoBd();
    FormMedico med = new FormMedico();
    FormUsuario user = new FormUsuario();
    FormEnfermeiro enf = new FormEnfermeiro();
    FormPaciente telapac = new FormPaciente();
    FormAgendamento telaAgenda = new FormAgendamento();
    FormAgenda telaagen = new FormAgenda();
    FormAgendaMedico telaAgenMedico = new FormAgendaMedico();
    FormTelaLogin telaLogin = new FormTelaLogin();
    FormEspecialidade espec = new FormEspecialidade();

    /**
     * Creates new form TelaPrincipal
     *
     * @param usuario usuário de login do sistema
     */
    public FormTelaPrincipal(String usuario) {
        initComponents();
        jLabelUsuario.setText(usuario);
        conecta.conectarBd();
    }

    private FormTelaPrincipal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabelVesao = new javax.swing.JLabel();
        TelaBemVindo = new javax.swing.JInternalFrame();
        jPanelTelaSejaBemVindo = new javax.swing.JPanel();
        jLabelAgenda = new javax.swing.JLabel();
        jLabelCadastro = new javax.swing.JLabel();
        BtnCadMedico = new javax.swing.JButton();
        BtnEnfermeira = new javax.swing.JButton();
        BtnPaciente = new javax.swing.JButton();
        BtnAgenda = new javax.swing.JButton();
        jLabelPainelfundo11 = new javax.swing.JLabel();
        jLabelPainelFundo1 = new javax.swing.JLabel();
        BtnFechaInternalFrame = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jCalendarTelaPrincipal = new com.toedter.calendar.JCalendar();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelFundoPrincipal = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastro = new javax.swing.JMenu();
        jMenuCadMedicos = new javax.swing.JMenuItem();
        jMenuCadPaciente = new javax.swing.JMenuItem();
        jMenuCadEnfermeiro = new javax.swing.JMenuItem();
        jMenuCadUsuario = new javax.swing.JMenuItem();
        jMenuCadUsuario1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuFerramenta = new javax.swing.JMenu();
        jMenuTelaBemVindo = new javax.swing.JMenuItem();
        jMenuItemConfEnvioEmail = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuAjuda = new javax.swing.JMenu();
        jMenuItemAjuda = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuISairb = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Programa de Gerenciamento de Conusltas -  Clinica Medica");
        getContentPane().setLayout(null);

        jLabelVesao.setText("Versão:1.00");
        getContentPane().add(jLabelVesao);
        jLabelVesao.setBounds(1160, 650, 70, 16);

        TelaBemVindo.setResizable(true);
        TelaBemVindo.setTitle("Seja Bem-Vindo");
        TelaBemVindo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TelaBemVindo.setInheritsPopupMenu(true);
        TelaBemVindo.setVisible(true);
        TelaBemVindo.getContentPane().setLayout(null);

        jPanelTelaSejaBemVindo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTelaSejaBemVindo.setLayout(null);

        jLabelAgenda.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabelAgenda.setText("Agenda :");
        jPanelTelaSejaBemVindo.add(jLabelAgenda);
        jLabelAgenda.setBounds(10, 160, 70, 19);

        jLabelCadastro.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabelCadastro.setText("Cadastro :");
        jLabelCadastro.setToolTipText("");
        jPanelTelaSejaBemVindo.add(jLabelCadastro);
        jLabelCadastro.setBounds(10, 0, 100, 40);

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
        BtnEnfermeira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnfermeiraActionPerformed(evt);
            }
        });
        jPanelTelaSejaBemVindo.add(BtnEnfermeira);
        BtnEnfermeira.setBounds(120, 30, 100, 120);

        BtnPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadPacientes.png"))); // NOI18N
        BtnPaciente.setToolTipText("Cadastro de Pacientes");
        BtnPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPacienteActionPerformed(evt);
            }
        });
        jPanelTelaSejaBemVindo.add(BtnPaciente);
        BtnPaciente.setBounds(220, 30, 100, 120);

        BtnAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Agenda.png"))); // NOI18N
        BtnAgenda.setToolTipText("");
        BtnAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgendaActionPerformed(evt);
            }
        });
        jPanelTelaSejaBemVindo.add(BtnAgenda);
        BtnAgenda.setBounds(10, 180, 120, 110);

        jLabelPainelfundo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/internalframe.png"))); // NOI18N
        jPanelTelaSejaBemVindo.add(jLabelPainelfundo11);
        jLabelPainelfundo11.setBounds(0, 0, 1230, 310);

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
        TelaBemVindo.setBounds(0, 260, 1240, 390);

        jLabel1.setText("Usuário:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 650, 50, 20);

        jCalendarTelaPrincipal.setBackground(new java.awt.Color(102, 102, 102));
        jCalendarTelaPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jCalendarTelaPrincipal.setWeekOfYearVisible(false);
        jCalendarTelaPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCalendarTelaPrincipalMouseClicked(evt);
            }
        });
        jCalendarTelaPrincipal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendarTelaPrincipalPropertyChange(evt);
            }
        });
        getContentPane().add(jCalendarTelaPrincipal);
        jCalendarTelaPrincipal.setBounds(890, 0, 347, 221);
        getContentPane().add(jLabelUsuario);
        jLabelUsuario.setBounds(60, 650, 190, 20);

        jLabelFundoPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fundo_telaprincipal.jpg"))); // NOI18N
        getContentPane().add(jLabelFundoPrincipal);
        jLabelFundoPrincipal.setBounds(0, 0, 1240, 1060);

        jMenuCadastro.setText("Cadastros");

        jMenuCadMedicos.setText("Médicos");
        jMenuCadMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadMedicosActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadMedicos);

        jMenuCadPaciente.setText("Pacientes");
        jMenuCadPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadPacienteActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadPaciente);

        jMenuCadEnfermeiro.setText("Enfermeiros");
        jMenuCadEnfermeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadEnfermeiroActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadEnfermeiro);

        jMenuCadUsuario.setText("Usuários");
        jMenuCadUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadUsuarioActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadUsuario);

        jMenuCadUsuario1.setText("Especialidades");
        jMenuCadUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadUsuario1ActionPerformed(evt);
            }
        });
        jMenuCadastro.add(jMenuCadUsuario1);

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

        jMenuItemConfEnvioEmail.setText("Envio de Email");
        jMenuItemConfEnvioEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConfEnvioEmailActionPerformed(evt);
            }
        });
        jMenuFerramenta.add(jMenuItemConfEnvioEmail);

        jMenuBar1.add(jMenuFerramenta);

        jMenu1.setText("Agenda");

        jMenuItem3.setText("Agenda do Dia");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Agenda do Médico");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenuAjuda.setText("Ajuda");

        jMenuItemAjuda.setText("Ajuda");
        jMenuAjuda.add(jMenuItemAjuda);

        jMenuBar1.add(jMenuAjuda);

        jMenuSair.setText("Sair");
        jMenuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSairMouseClicked(evt);
            }
        });

        jMenuItem2.setText("Logout");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuItem2);

        jMenuISairb.setText("Sair");
        jMenuISairb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuISairbMouseClicked(evt);
            }
        });
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
        try {
            conecta.executaSql("SELECT * FROM USUARIO WHERE NOME ='" + jLabelUsuario.getText() + "'");
            conecta.rs.first();
            if (conecta.rs.getString("TIPO").equalsIgnoreCase("ADMINISTRADOR")) {
                if (user == null) {
                    user = new FormUsuario();
                    user.setVisible(true);
                    user.setResizable(false);
                } else {
                    user.setVisible(true);
                    user.setResizable(false);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                        + "Gentileza entre em contato com o administrador do sistema.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                    + "Gentileza entre em contato com o administrador do sistema." + ex);
        }
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
        try {
            conecta.executaSql("SELECT * FROM USUARIO WHERE NOME ='" + jLabelUsuario.getText() + "'");
            conecta.rs.first();
            if (conecta.rs.getString("TIPO").equalsIgnoreCase("Administrador")) {
                if (med == null) {
                    med = new FormMedico();
                    med.setVisible(true);
                    med.setResizable(false);
                } else {
                    med.setVisible(true);
                    med.setResizable(false);
                }
                // FormMedico med = new FormMedico();
                //  med.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                        + "Gentileza entre em contato com o administrador do sistema.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                    + "Gentileza entre em contato com o administrador do sistema." + ex);
        }
    }//GEN-LAST:event_jMenuCadMedicosActionPerformed

    private void BtnCadMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCadMedicoActionPerformed
        try {
            conecta.executaSql("SELECT * FROM USUARIO WHERE NOME ='" + jLabelUsuario.getText() + "'");
            conecta.rs.first();
            if (conecta.rs.getString("TIPO").equalsIgnoreCase("Administrador")) {
                if (med == null) {
                    med = new FormMedico();
                    med.setVisible(true);
                    med.setResizable(false);
                } else {
                    med.setVisible(true);
                    med.setResizable(false);
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                        + "Gentileza entre em contato com o administrador do sistema.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                    + "Gentileza entre em contato com o administrador do sistema." + ex);
        }
    }//GEN-LAST:event_BtnCadMedicoActionPerformed

    private void jMenuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSairMouseClicked

        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuSairMouseClicked

    private void BtnEnfermeiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnfermeiraActionPerformed
        // TODO add your handling code here:
        try {
            conecta.executaSql("SELECT * FROM USUARIO WHERE NOME ='" + jLabelUsuario.getText() + "'");
            conecta.rs.first();
            if (conecta.rs.getString("TIPO").equalsIgnoreCase("ADMINISTRADOR")) {
                if (user == null) {
                    user = new FormUsuario();
                    enf.setVisible(true);
                    enf.setResizable(false);
                } else {
                    enf.setVisible(true);
                    enf.setResizable(false);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                        + "Gentileza entre em contato com o administrador do sistema.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                    + "Gentileza entre em contato com o administrador do sistema." + ex);
        }

    }//GEN-LAST:event_BtnEnfermeiraActionPerformed

    private void jMenuCadEnfermeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadEnfermeiroActionPerformed
        // TODO add your handling code here:
        FormEnfermeiro enf = new FormEnfermeiro();
        enf.setVisible(true);
    }//GEN-LAST:event_jMenuCadEnfermeiroActionPerformed

    private void BtnPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPacienteActionPerformed
        // TODO add your handling code here:
        try {
            conecta.executaSql("SELECT * FROM USUARIO WHERE NOME ='" + jLabelUsuario.getText() + "'");
            conecta.rs.first();
            if (conecta.rs.getString("TIPO").equalsIgnoreCase("ADMINISTRADOR")) {
                if (telapac == null) {
                    telapac = new FormPaciente();
                    telapac.setVisible(true);
                    telapac.setResizable(false);
                } else {
                    telapac.setVisible(true);
                    telapac.setResizable(false);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                        + "Gentileza entre em contato com o administrador do sistema.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                    + "Gentileza entre em contato com o administrador do sistema." + ex);
        }
    }//GEN-LAST:event_BtnPacienteActionPerformed

    private void jMenuCadPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadPacienteActionPerformed
        // TODO add your handling code here:
        try {
            conecta.executaSql("SELECT * FROM USUARIO WHERE NOME ='" + jLabelUsuario.getText() + "'");
            conecta.rs.first();
            if (conecta.rs.getString("TIPO").equalsIgnoreCase("ADMINISTRADOR")) {
                if (telapac == null) {
                    telapac = new FormPaciente();
                    telapac.setVisible(true);
                    telapac.setResizable(false);
                } else {
                    telapac.setVisible(true);
                    telapac.setResizable(false);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                        + "Gentileza entre em contato com o administrador do sistema.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                    + "Gentileza entre em contato com o administrador do sistema." + ex);
        }
    }//GEN-LAST:event_jMenuCadPacienteActionPerformed

    private void jMenuItemConfEnvioEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConfEnvioEmailActionPerformed
        // TODO add your handling code here:
        FormEnvioEmail email = new FormEnvioEmail();
        email.setVisible(true);
    }//GEN-LAST:event_jMenuItemConfEnvioEmailActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
//        TelaPrincipal principal = new TelaPrincipal();
//        principal.setVisible(false);
        dispose();

        FormTelaLogin login = new FormTelaLogin();
        login.setVisible(true);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void BtnAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgendaActionPerformed
        // TODO add your handling code here:
        try {
            conecta.executaSql("SELECT * FROM USUARIO WHERE NOME ='" + jLabelUsuario.getText() + "'");
            conecta.rs.first();
            if (conecta.rs.getString("TIPO").equalsIgnoreCase("ADMINISTRADOR")) {
                if (telaAgenda == null) {
                    telaAgenda = new FormAgendamento();
                    telaAgenda.setVisible(true);
                    telaAgenda.setResizable(false);
                } else {
                    telaAgenda.setVisible(true);
                    telaAgenda.setResizable(false);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                        + "Gentileza entre em contato com o administrador do sistema.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "O seu usuário não tem permissão para acessar está funcionalidade do sistema.\n"
                    + "Gentileza entre em contato com o administrador do sistema." + ex);
        }
    }//GEN-LAST:event_BtnAgendaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        telaagen.setVisible(true);

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        telaAgenMedico.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuISairbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuISairbMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuISairbMouseClicked

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuCadUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadUsuario1ActionPerformed
        // TODO add your handling code here:
        espec.setVisible(true);
    }//GEN-LAST:event_jMenuCadUsuario1ActionPerformed

    private void jCalendarTelaPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCalendarTelaPrincipalMouseClicked
        // TODO add your handling code here:
        System.out.println("button"+ evt.getButton());
         System.out.println("id"+ evt.getID());
         System.out.println("String param"+ evt.paramString());
         System.out.println("is consumed"+ evt.isConsumed());
         
        
    }//GEN-LAST:event_jCalendarTelaPrincipalMouseClicked
    
    private void jCalendarTelaPrincipalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendarTelaPrincipalPropertyChange
        // TODO add your handling code here:
    System.out.println(evt.getPropertyName()+ ": " + evt.getNewValue()); //getNewValue()
    }//GEN-LAST:event_jCalendarTelaPrincipalPropertyChange

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
            java.util.logging.Logger.getLogger(FormTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTelaPrincipal().setVisible(true);
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
    private com.toedter.calendar.JCalendar jCalendarTelaPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAgenda;
    private javax.swing.JLabel jLabelCadastro;
    private javax.swing.JLabel jLabelFundoPrincipal;
    private javax.swing.JLabel jLabelPainelFundo1;
    private javax.swing.JLabel jLabelPainelfundo11;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelVesao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenuAjuda;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCadEnfermeiro;
    private javax.swing.JMenuItem jMenuCadMedicos;
    private javax.swing.JMenuItem jMenuCadPaciente;
    private javax.swing.JMenuItem jMenuCadUsuario;
    private javax.swing.JMenuItem jMenuCadUsuario1;
    private javax.swing.JMenu jMenuCadastro;
    private javax.swing.JMenu jMenuFerramenta;
    private javax.swing.JMenuItem jMenuISairb;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItemAjuda;
    private javax.swing.JMenuItem jMenuItemConfEnvioEmail;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenuItem jMenuTelaBemVindo;
    private javax.swing.JPanel jPanelTelaSejaBemVindo;
    // End of variables declaration//GEN-END:variables
}
