/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * http://blog.caelum.com.br/conheca-a-nova-api-de-datas-do-java-8/
 * http://pt.slideshare.net/mgraciano/finalmente-java-sabe-trabalhar-com-data-e-hora
 * http://javafree.uol.com.br/artigo/878220/javaxtime-Conheca-a-nova-especificacao-de-Data-e-Hora.html
 */
package visao;

//não permitir ao usuário agendar uma consulta
//com a especialidade e medico selecionados = "Selecione", 
//alterar o modo de salvar a data para dd/MM/yyyy
import ModeloBeans.BeansAgendamento;
import ModeloBeans.BeansModeloTabela;
import ModeloConection.ConexaoBd;
import ModeloDao.DaoAgendamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Daniel Lucas
 */
public class FormAgendamento extends javax.swing.JFrame {

    ConexaoBd conBd = new ConexaoBd();
    BeansAgendamento agenda = new BeansAgendamento();
    DaoAgendamento daoagenda = new DaoAgendamento();

    ResultSet rs = null;
    PreparedStatement pstA;

    String dtHoje;
    String status;
    String codigo;
    String resposta;

    public String teste;

    /**
     * Creates new form FormAgenda
     */
    public FormAgendamento() {
        initComponents();

        preencherEspecMedica();

        preencherTabelaAgendamento("SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,"
                + "CETELRESIDENCIAL,CETELCELULAR FROM PACIENTE WHERE NOMEPACIENTE like '%" + jTextFieldPaciente.getText() + "%'");
    }

    FormAgendamento(String paciente) {
        initComponents();
        jTextFieldPaciente.setText(paciente);
        preencherEspecMedica();
        jComboBoxTurno.setSelectedItem("selecione");
        preencherTabelaAgendamento("SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,"
                + "CETELRESIDENCIAL,CETELCELULAR FROM PACIENTE WHERE NOMEPACIENTE like '%" + jTextFieldPaciente.getText() + "%'");
        HabilitarCampos();
        HabilitarBtn();
        preencherMedico();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //preenchimento  Jcombobox Especialidade Medica
    public void preencherEspecMedica() {
        conBd.conectarBd();

        try {

            jComboBoxEspecMedica.addItem("Selecione");
            String sql = "SELECT ESPEC FROM ESPECIALIDADE";

            pstA = conBd.con.prepareStatement(sql);
            rs = pstA.executeQuery();

            while (rs.next()) {
                jComboBoxEspecMedica.addItem(rs.getString("ESPEC"));
            }

        } catch (SQLException ex) {
            // Logger.getLogger(FormMedico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os dados da especialidade" + ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os dados da especialidade" + ex.getMessage());
        }

        conBd.DesconectarBd();
    }

    public void preencherMedico() {
        conBd.conectarBd();

        try {

            String sql = "SELECT MEDICO.NOMEMEDICO FROM MEDICO "
                    + "inner join ESPECIALIDADE ON ESPECIALIDADE.IDESPECIALIDADE = MEDICO.IDESPECIALIDADE "
                    + "WHERE ESPEC = '" + resposta + "'";;

            pstA = conBd.con.prepareStatement(sql);
            rs = pstA.executeQuery();

            while (rs.next()) {
                jComboBoxMedico.addItem(rs.getString("NOMEMEDICO"));
            }
//           }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os dados da especialidade" + ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os dados da especialidade" + ex.getMessage());
        }

        conBd.DesconectarBd();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldPaciente = new javax.swing.JTextField();
        jComboBoxTurno = new javax.swing.JComboBox<>();
        jButtonBuscarPaciente = new javax.swing.JButton();
        jComboBoxMedico = new javax.swing.JComboBox<>();
        jButtonConcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgendamentoConsulta = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButtonEmail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMotivo = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxEspecMedica = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxRetorno = new javax.swing.JComboBox<>();
        jButtonCadUsu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setEnabled(false);

        jLabel2.setText("Paciente:");

        jLabel3.setText("Medico:");

        jLabel4.setText("Data :");

        jLabel5.setText("Motivo:");

        jLabel6.setText("Turno:");

        jComboBoxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino", "Noturno" }));
        jComboBoxTurno.setEnabled(false);
        jComboBoxTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTurnoActionPerformed(evt);
            }
        });

        jButtonBuscarPaciente.setText("Buscar");
        jButtonBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarPacienteActionPerformed(evt);
            }
        });

        jComboBoxMedico.setEnabled(false);
        jComboBoxMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMedicoActionPerformed(evt);
            }
        });

        jButtonConcluir.setText("Concluir Agendamento ");
        jButtonConcluir.setEnabled(false);
        jButtonConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar agendamento");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jTableAgendamentoConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableAgendamentoConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendamentoConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAgendamentoConsulta);

        jDateChooser1.setEnabled(false);

        jButtonEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/email1.png"))); // NOI18N
        jButtonEmail.setEnabled(false);
        jButtonEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmailActionPerformed(evt);
            }
        });

        jTextAreaMotivo.setColumns(20);
        jTextAreaMotivo.setRows(5);
        jTextAreaMotivo.setEnabled(false);
        jScrollPane2.setViewportView(jTextAreaMotivo);

        jLabel7.setText("Especialidade: ");

        jComboBoxEspecMedica.setEnabled(false);
        jComboBoxEspecMedica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxEspecMedicaMouseClicked(evt);
            }
        });
        jComboBoxEspecMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEspecMedicaActionPerformed(evt);
            }
        });

        jLabel8.setText("Retorno :");

        jComboBoxRetorno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxRetorno.setEnabled(false);

        jButtonCadUsu.setText("Cadastrar Usuário");
        jButtonCadUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadUsuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBuscarPaciente)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonConcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonCadUsu)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(424, 424, 424)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxEspecMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(391, 391, 391)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonConcluir)
                            .addComponent(jButtonCancelar)
                            .addComponent(jButtonCadUsu))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarPaciente)
                            .addComponent(jLabel6)
                            .addComponent(jComboBoxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jComboBoxRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBoxEspecMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Agendamento");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(404, 404, 404)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(996, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPacienteActionPerformed
        // TODO add your handling code here:
        if (jTextFieldPaciente.getText().isEmpty()) {
            LimparCampos();
            DesabilitarCampos();
            DesabilitarBtn();
        } else {
            preencherTabelaAgendamento("SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,CETELRESIDENCIAL,CETELCELULAR FROM "
                    + "PACIENTE WHERE NOMEPACIENTE like '%" + jTextFieldPaciente.getText() + "%'");
            HabilitarCampos();
            HabilitarBtn();
            preencherMedico();
        }
    }//GEN-LAST:event_jButtonBuscarPacienteActionPerformed

    private void jTableAgendamentoConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendamentoConsultaMouseClicked
        // TODO add your handling code here:
        String Nome = "" + jTableAgendamentoConsulta.getValueAt(jTableAgendamentoConsulta.getSelectedRow(), 1);
        conBd.conectarBd();
        String sql = "SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,CETELRESIDENCIAL,CETELCELULAR "
                + "FROM PACIENTE WHERE NOMEPACIENTE = '" + Nome + "'";

        try {
            conBd.executaSql(sql);
            conBd.rs.first();
            //LimparCampos();
            // DesabilitarCampos();
            jTextFieldPaciente.setText(conBd.rs.getString("NOMEPACIENTE"));
            //jTextFieldPPesquisar.set

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao selecionar os dados" + ex.getMessage());
        }

        conBd.DesconectarBd();
        HabilitarCampos();
        HabilitarBtn();
        preencherMedico();
        jButtonCadUsu.setEnabled(false);
    }//GEN-LAST:event_jTableAgendamentoConsultaMouseClicked

    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed
        // TODO add your handling code here:
        DaoAgendamento dao = new DaoAgendamento();

        ValidaMedicoEspecialidade();
        
                agenda.setNomePaciente(jTextFieldPaciente.getText());
                agenda.setNomeMedico((String) jComboBoxMedico.getSelectedItem());
                agenda.setATurno((String) jComboBoxTurno.getSelectedItem());
                agenda.setAMotivo(jTextAreaMotivo.getText());
                agenda.setAData(jDateChooser1.getDate());
                System.out.println(jDateChooser1.getDate());
                agenda.setAEspecialidade(jComboBoxEspecMedica.getSelectedIndex());
                agenda.setAStatus("Aberto");
                agenda.setARetorno((String) jComboBoxRetorno.getSelectedItem());

                if (agenda.getARetorno().equalsIgnoreCase("Sim")) {
                    agenda.setARetorno((String) "1");
                } else if (agenda.getARetorno().equalsIgnoreCase("Não")) {
                    agenda.setARetorno((String) "0");
                }

                dao.Salvar(agenda);

                LimparCampos();
                DesabilitarCampos();
                //dispose();
       
    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        LimparCampos();
        DesabilitarCampos();
        DesabilitarBtn();
        preencherTabelaAgendamento("SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,"
                + "CETELRESIDENCIAL,CETELCELULAR FROM PACIENTE WHERE NOMEPACIENTE like '%" + jTextFieldPaciente.getText() + "%'");
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jComboBoxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTurnoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxTurnoActionPerformed

    private void jComboBoxEspecMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEspecMedicaActionPerformed
        // TODO add your handling code here:
        resposta = (String) jComboBoxEspecMedica.getSelectedItem();
        System.out.println("Jcombo Medico" + resposta);
        if (resposta == "Selecione") {
            jComboBoxMedico.removeAllItems();
            jComboBoxMedico.addItem("Selecione");
        } else {
            jComboBoxMedico.addItem("Selecione");
            jComboBoxMedico.removeAllItems();
            preencherMedico();
        }

    }//GEN-LAST:event_jComboBoxEspecMedicaActionPerformed

    private void jComboBoxMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxMedicoActionPerformed

    private void jComboBoxEspecMedicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxEspecMedicaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxEspecMedicaMouseClicked

    private void jButtonEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmailActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jButtonEmailActionPerformed

    private void jButtonCadUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadUsuActionPerformed
        // TODO add your handling code here:
        FormUsuario cadUsu = new FormUsuario();
        cadUsu.setVisible(true);

    }//GEN-LAST:event_jButtonCadUsuActionPerformed

    public void preencherTabelaAgendamento(String sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "NOME DO PACIENTE", "TEL.RESIDENCIAL", "TEL.CELULAR", "ACOMPANHANTE",
            "TEL ACOMPANHANTE", "CEL ACOMPANHANTE"};

        conBd.conectarBd();

        conBd.executaSql(sql);
        try {
            conBd.rs.first();
            do {
                dados.add(new Object[]{
                    conBd.rs.getInt("IDPACIENTE"), conBd.rs.getString("NOMEPACIENTE"), conBd.rs.getString("TELRESIDENCIAL"),
                    conBd.rs.getString("TELCELULAR"), conBd.rs.getString("CENOME"), conBd.rs.getString("CETELRESIDENCIAL"),
                    conBd.rs.getString("CETELCELULAR")}
                );
            } while (conBd.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao carregar os dados da tabela." + ex);
        }

        BeansModeloTabela modelo = new BeansModeloTabela(dados, colunas);
        jTableAgendamentoConsulta.setModel(modelo);

        jTableAgendamentoConsulta.getColumnModel().getColumn(0).setPreferredWidth(38);//Tamanho da tabela
        jTableAgendamentoConsulta.getColumnModel().getColumn(0).setResizable(false);

        jTableAgendamentoConsulta.getColumnModel().getColumn(1).setPreferredWidth(237);
        jTableAgendamentoConsulta.getColumnModel().getColumn(1).setResizable(false);

        jTableAgendamentoConsulta.getColumnModel().getColumn(2).setPreferredWidth(115);
        jTableAgendamentoConsulta.getColumnModel().getColumn(2).setResizable(false);

        jTableAgendamentoConsulta.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTableAgendamentoConsulta.getColumnModel().getColumn(3).setResizable(false);

        jTableAgendamentoConsulta.getColumnModel().getColumn(4).setPreferredWidth(237);
        jTableAgendamentoConsulta.getColumnModel().getColumn(4).setResizable(false);

        jTableAgendamentoConsulta.getColumnModel().getColumn(5).setPreferredWidth(135);
        jTableAgendamentoConsulta.getColumnModel().getColumn(5).setResizable(false);

        jTableAgendamentoConsulta.getColumnModel().getColumn(6).setPreferredWidth(135);
        jTableAgendamentoConsulta.getColumnModel().getColumn(6).setResizable(false);

        jTableAgendamentoConsulta.getTableHeader().setReorderingAllowed(false);//reorganizar o cabeçalho
        jTableAgendamentoConsulta.setAutoResizeMode(jTableAgendamentoConsulta.AUTO_RESIZE_OFF); //NÃO VAI PODER REDIMENCIONAR A TABELA
        jTableAgendamentoConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//selecionar um por vez 
        //total do tamanho dos campos = 38 + 237 + 110 + 65 = 450
        conBd.DesconectarBd();
    }

    public void ValidaMedicoEspecialidade(){
        if(jComboBoxEspecMedica.getSelectedItem().equals("Selecione")){
            System.out.println("Teste Especialidade");  
        }if(jComboBoxMedico.equals("Selecione")){
          System.out.println("Teste Medico");   
        }
    }
    public void LimparCampos() {

        jTextAreaMotivo.setText(" ");
        jComboBoxMedico.setSelectedItem("Selecione");
        jComboBoxTurno.setSelectedItem("Selecione");
        jComboBoxRetorno.setSelectedItem("Selecione");
        jComboBoxEspecMedica.setSelectedItem("Selecione");
        jDateChooser1.setDate(null);
        jTextFieldPaciente.setText(" ");
    }

    public void DesabilitarBtn() {
        jButtonConcluir.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonEmail.setEnabled(false);
        jButtonCadUsu.setEnabled(true);
    }

    public void HabilitarBtn() {
        jButtonConcluir.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonEmail.setEnabled(true);
        jButtonCadUsu.setEnabled(true);
    }

    public void HabilitarCampos() {
        jTextAreaMotivo.setEnabled(true);
        jComboBoxMedico.setEnabled(true);
        jComboBoxTurno.setEnabled(true);
        jComboBoxEspecMedica.setEnabled(true);
        jComboBoxRetorno.setEnabled(true);
        jDateChooser1.setEnabled(true);

    }

    public void DesabilitarCampos() {

        jTextAreaMotivo.setEnabled(false);
        jComboBoxMedico.setEnabled(false);
        jComboBoxTurno.setEnabled(false);
        jDateChooser1.setEnabled(false);
        jComboBoxEspecMedica.setEnabled(false);
        jComboBoxRetorno.setEnabled(false);
        jButtonConcluir.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonEmail.setEnabled(false);
    }

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
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarPaciente;
    private javax.swing.JButton jButtonCadUsu;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JButton jButtonEmail;
    private javax.swing.JComboBox<String> jComboBoxEspecMedica;
    private javax.swing.JComboBox<String> jComboBoxMedico;
    private javax.swing.JComboBox<String> jComboBoxRetorno;
    private javax.swing.JComboBox<String> jComboBoxTurno;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAgendamentoConsulta;
    private javax.swing.JTextArea jTextAreaMotivo;
    private javax.swing.JTextField jTextFieldPaciente;
    // End of variables declaration//GEN-END:variables
}