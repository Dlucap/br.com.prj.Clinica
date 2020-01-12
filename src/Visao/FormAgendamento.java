/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * http://blog.caelum.com.br/conheca-a-nova-api-de-datas-do-java-8/
 * http://pt.slideshare.net/mgraciano/finalmente-java-sabe-trabalhar-com-data-e-hora
 * http://javafree.uol.com.br/artigo/878220/javaxtime-Conheca-a-nova-especificacao-de-Data-e-Hora.html
 */
package Visao;

//import Visao.*;
import ModeloBeans.BeansAgendamento;
import ModeloBeans.BeansDadosUsuario;
import ModeloBeans.ModeloTabela;
import ModeloConection.ConexaoBd;
import ModeloConection.Email;
import ModeloDao.DaoAgendamento;
import ModeloDao.DaoCheckDate;
import ModeloDao.DateAndCalendar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Daniel Lucas
 */
public class FormAgendamento extends javax.swing.JFrame {

    ConexaoBd conBd = new ConexaoBd();
    // BeansAgendamento agenda = new BeansAgendamento();
    BeansAgendamento agen = new BeansAgendamento();
    DaoAgendamento daoagenda = new DaoAgendamento();
    Email mail = new Email();

    ResultSet rs = null;
    PreparedStatement pstA;

    private String codigo;
    private String resposta;
    private Integer idMedico;
    public static String cRetorno;
    private Integer idCodigoAgendamento;

    Locale local = new Locale("br", "PT");
    SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy", local);

    int flag = 0;

    /**
     * Creates new form FormAgenda
     */
    FormAgendamento() {
        initComponents();

        preencherEspecMedica();
        preencherTabelaAgendamento("SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,"
                + "CETELRESIDENCIAL,CETELCELULAR FROM PACIENTE (NOLOCK) WHERE NOMEPACIENTE like '%" + jTextFieldPaciente.getText() + "%'");

    }

    public FormAgendamento(BeansDadosUsuario beansDadosUsuario) {
        initComponents();

        preencherEspecMedica();
        preencherTabelaAgendamento("SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,"
                + "CETELRESIDENCIAL,CETELCELULAR FROM PACIENTE (NOLOCK) WHERE NOMEPACIENTE like '%" + jTextFieldPaciente.getText() + "%'");

    }

    public FormAgendamento(String agenda, int flag) {

        initComponents();
        this.flag = flag;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date dt = null;

        preencherTabelaAgendamento("SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,"
                + "CETELRESIDENCIAL,CETELCELULAR FROM PACIENTE (NOLOCK) WHERE NOMEPACIENTE like '%" + jTextFieldPaciente.getText() + "%'");
        jComboBoxMedico.removeAll();

        HabilitarCampos();
        HabilitarBtn();
        conBd.conectarBd();

        String sql = "SELECT AGENDAMENTO.IDAGENDAMENTO, STATUSCONSULTA, ESPECIALIDADE.ESPEC, PACIENTE.NOMEPACIENTE, "
                + "MEDICO.NOMEMEDICO, HORARIO.IDHORA, DTAGENDAMENTO, HORARIO.HORA  FROM AGENDAMENTO (NOLOCK) "
                + "INNER JOIN PACIENTE (NOLOCK) ON PACIENTE.IDPACIENTE = AGENDAMENTO.IDPACIENTE "
                + "INNER JOIN MEDICO (NOLOCK) ON MEDICO.IDMEDICO = AGENDAMENTO.IDMEDICO "
                + "INNER JOIN ESPECIALIDADE (NOLOCK) ON ESPECIALIDADE.IDESPECIALIDADE= AGENDAMENTO.IDESPECIALIDADE "
                + "INNER JOIN HORARIO (NOLOCK) ON HORARIO.IDHORA = AGENDAMENTO.IDHORA "
                + "WHERE IDAGENDAMENTO = '" + agenda + "'";
        try {
            conBd.executaSql(sql);

            conBd.rs.first();
            idCodigoAgendamento = conBd.rs.getInt("IDAGENDAMENTO");
            jTextFieldPaciente.setText(conBd.rs.getString("NOMEPACIENTE"));
            jComboBoxEspecMedica.addItem(conBd.rs.getString("ESPEC"));
            jComboBoxMedico.addItem(conBd.rs.getString("NOMEMEDICO"));
            String input = conBd.rs.getString("HORA");
            try {
                dt = sdf.parse(input);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao converter a hora. " + ex);
            }

            SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
            String strDate = sdf2.format(dt);

            jDateChooserAgendamento.setDate(conBd.rs.getDate("DTAGENDAMENTO"));
            jComboBoxHorario.addItem(strDate);
            // jComboBoxHorario.setEnabled(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar os dados" + ex.getMessage());
        } finally {
            conBd.DesconectarBd();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * http://findicons.com/icon/193102/stock_mail_send
     */
    public final void preencherEspecMedica() {
        conBd.conectarBd();

        try {
            jComboBoxEspecMedica.addItem("Selecione");
            String sql = "SELECT ESPEC FROM ESPECIALIDADE (NOLOCK) WHERE ATIVO = 1 ORDER BY ESPEC";

            pstA = conBd.con.prepareStatement(sql);
            rs = pstA.executeQuery();

            while (rs.next()) {
                jComboBoxEspecMedica.addItem(rs.getString("ESPEC"));
            }

        } catch (SQLException ex) {
            // Logger.getLogger(FormMedico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os dados da especialidade  sql" + ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os dados da especialidade null" + ex.getMessage());
        }
        conBd.DesconectarBd();
    }

    public void preencherMedico() {

        conBd.conectarBd();
        String nomeEspec;
        nomeEspec = daoagenda.BuscarCodEspec((String) jComboBoxEspecMedica.getSelectedItem());
        codigo = String.valueOf(nomeEspec);

        if (jComboBoxEspecMedica.getSelectedItem() == "Selecione") {
            jComboBoxMedico.setEnabled(false);
        } else {

            try {
                String sql = "SELECT MEDICO.NOMEMEDICO FROM MEDICO (NOLOCK)"
                        + "INNER JOIN ESPECIALIDADE (NOLOCK)ON ESPECIALIDADE.IDESPECIALIDADE = MEDICO.IDESPECIALIDADE "
                        + "WHERE ESPEC = '" + resposta + "'";

                pstA = conBd.con.prepareStatement(sql);
                rs = pstA.executeQuery();

                while (rs.next()) {
                    jComboBoxMedico.addItem(rs.getString("NOMEMEDICO"));
                }
            } catch (SQLException ex) {
                // Logger.getLogger(FormMedico.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os dados do Medico  " + ex);
            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os dados do Medico  " + ex.getMessage());
            }
        }
        conBd.DesconectarBd();
    }

    public void preencherHorario() {
        conBd.conectarBd();
        Integer nomeEspec;

        try {
            String sql = "SELECT HORARIO.IDHORA,HORARIO.HORA FROM HORARIO (NOLOCK)"
                    + "LEFT JOIN AGENDAMENTO (NOLOCK)ON HORARIO.IDHORA = AGENDAMENTO.IDHORA "
                    + "AND AGENDAMENTO.DTAGENDAMENTO = ('" + dt.format(jDateChooserAgendamento.getDate()) + "') "
                    + "AND AGENDAMENTO.IDMEDICO = '" + idMedico + "' WHERE "
                    + "AGENDAMENTO.DTAGENDAMENTO IS NULL";

            pstA = conBd.con.prepareStatement(sql);
            rs = pstA.executeQuery();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date dt = null;
            while (rs.next()) {
                // String inputText = rs.getString("HORA");
                String input = rs.getString("HORA");

                try {
                    dt = sdf.parse(input);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Erro ao converter a hora. " + ex);
                }

                SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
                String strDate = sdf2.format(dt);

                jComboBoxHorario.addItem(strDate);
            }
        } catch (SQLException ex) {
            // Logger.getLogger(FormMedico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os dados do quadro de horario no banco de dados " + "\n" + ex.getMessage() + "\n" + ex + "\n" + ex.getErrorCode() + "\n" + ex.getSQLState());
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os dados do quadro de horario NullPointerException " + ex.getMessage() + "\n" + ex);
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
        jTextFieldPaciente = new javax.swing.JTextField();
        jButtonBuscarPaciente = new javax.swing.JButton();
        jComboBoxMedico = new javax.swing.JComboBox<>();
        jButtonConcluir = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgendamentoConsulta = new javax.swing.JTable();
        jButtonEmail = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMotivo = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxEspecMedica = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxRetorno = new javax.swing.JComboBox<>();
        jDateChooserAgendamento = new com.toedter.calendar.JDateChooser();
        jButtonBuscarConsulta = new javax.swing.JButton();
        jComboBoxHorario = new javax.swing.JComboBox<>();
        jLabelHorario = new javax.swing.JLabel();
        jFormattedTextFieldIdRetorno = new javax.swing.JFormattedTextField();
        jButtonAtualizaConsultaRetorno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setEnabled(false);

        jLabel2.setText("Paciente:");

        jLabel3.setText("Medico:");

        jLabel4.setText("Data:");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Informações Adicionais");

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
        jComboBoxMedico.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxMedicoPropertyChange(evt);
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

        jButtonEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/email1.png"))); // NOI18N
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

        jLabel8.setText("Retorno:");

        jComboBoxRetorno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não", "Sim" }));
        jComboBoxRetorno.setEnabled(false);
        jComboBoxRetorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxRetornoActionPerformed(evt);
            }
        });

        jDateChooserAgendamento.setDateFormatString("dd/MM/yyyy");
        jDateChooserAgendamento.setEnabled(false);
        jDateChooserAgendamento.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserAgendamentoPropertyChange(evt);
            }
        });

        jButtonBuscarConsulta.setText("Buscar Consulta");
        jButtonBuscarConsulta.setEnabled(false);
        jButtonBuscarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarConsultaActionPerformed(evt);
            }
        });

        jComboBoxHorario.setEnabled(false);

        jLabelHorario.setText("Horários disponíveis:");

        try {
            jFormattedTextFieldIdRetorno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldIdRetorno.setEnabled(false);
        jFormattedTextFieldIdRetorno.setInheritsPopupMenu(true);
        jFormattedTextFieldIdRetorno.setKeymap(null);
        jFormattedTextFieldIdRetorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jFormattedTextFieldIdRetornoMouseClicked(evt);
            }
        });
        jFormattedTextFieldIdRetorno.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jFormattedTextFieldIdRetornoPropertyChange(evt);
            }
        });

        jButtonAtualizaConsultaRetorno.setText("Atualiza Consuta de Retorno");
        jButtonAtualizaConsultaRetorno.setEnabled(false);
        jButtonAtualizaConsultaRetorno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaConsultaRetornoActionPerformed(evt);
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
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(360, 360, 360)
                                    .addComponent(jLabel5))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxEspecMedica, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelHorario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooserAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonConcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBuscarPaciente)
                                .addGap(303, 303, 303)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBoxRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFormattedTextFieldIdRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscarConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAtualizaConsultaRetorno)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonConcluir)
                            .addComponent(jButtonCancelar))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarPaciente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jComboBoxEspecMedica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelHorario)
                        .addComponent(jLabel4))
                    .addComponent(jDateChooserAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBoxMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButtonBuscarConsulta)
                    .addComponent(jFormattedTextFieldIdRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAtualizaConsultaRetorno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        setSize(new java.awt.Dimension(996, 587));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxRetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxRetornoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxRetorno.getSelectedItem().equals("Sim")) {

            jButtonBuscarConsulta.setEnabled(true);
            jButtonAtualizaConsultaRetorno.setEnabled(true);

        } else if (jComboBoxRetorno.getSelectedItem().equals("Não")) {

            jButtonBuscarConsulta.setEnabled(false);
            jButtonAtualizaConsultaRetorno.setEnabled(false);
            jFormattedTextFieldIdRetorno.setText("");

        }
    }//GEN-LAST:event_jComboBoxRetornoActionPerformed

    public void IdConsultaRetorno(String idConsultaRetorno) {
        cRetorno = idConsultaRetorno;
//          if(!cRetorno.isEmpty()){
//           
//             jFormattedTextFieldIdRetorno.setText(idConsultaRetorno); 
//             System.out.println("idConsultaRetorno 1: "+idConsultaRetorno);
//             
//          }            
    }

    private void jComboBoxEspecMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEspecMedicaActionPerformed
        // TODO add your handling code here:
        if (flag == 0) {
            resposta = (String) jComboBoxEspecMedica.getSelectedItem();
            if (resposta != "Selecione") {

                jComboBoxMedico.removeAllItems();
                jComboBoxMedico.addItem("Selecione");
                preencherMedico();
            } else if (resposta == "Selecione") {
                jComboBoxMedico.removeAllItems();
                jComboBoxMedico.addItem("Selecione");
            }
        }

    }//GEN-LAST:event_jComboBoxEspecMedicaActionPerformed

    private void jComboBoxEspecMedicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxEspecMedicaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jComboBoxEspecMedicaMouseClicked

    private void jButtonEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmailActionPerformed
        // TODO add your handling code here:
        Email emaill = new Email();
        BeansDadosUsuario dadosUser;

        String msg = jTextFieldPaciente.getText()
                + ",\n\n     Informamos que a sua consulta foi agendada com o(a) Doutor(a) "
                + jComboBoxMedico.getSelectedItem() + "(" + jComboBoxEspecMedica.getSelectedItem() + ") para o dia "
                + dt.format(jDateChooserAgendamento.getDate()) + ", ás " + jComboBoxHorario.getSelectedItem() + ". Próximo ao dia \n"
                + "da consulta será encaminhado um e-mail de confirmação, solicitamos que o mesmo seja respondido "
                + "e caso haja desistência, gentileza nos informar em um prazo de 48h.\n\n"
                + "Certo de sua compreensão. \n\n"
                + "Att,\n\n"
                + "Clínica Medica";
        //        System.out.println(dadosUser.getNome());
        // emaill.Email(hostname, portas, emails, senhaEmail);//senha
        // emaill.enviarEmail(emails, subject, msg, jTextFieldTesteEnvioemailRemetente.getText());
        System.out.println("Envio concluido com sucesso\n\n" + msg);
        /**
         * https://pt.stackoverflow.com/questions/43074/comunica%C3%A7%C3%A3o-com-a-api-do-google-calendar-usando-rest
         * http://www.devmedia.com.br/artigo-java-magazine-67-google-data-apis-calendar-2-0/12779
         * https://developers.google.com/google-apps/calendar/v3/reference/calendars/insert
         * https://developers.google.com/google-apps/calendar/v3/reference/events/insert
         */
    }//GEN-LAST:event_jButtonEmailActionPerformed

    private void jTableAgendamentoConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendamentoConsultaMouseClicked
        // TODO add your handling code here:
        String Nome = "" + jTableAgendamentoConsulta.getValueAt(jTableAgendamentoConsulta.getSelectedRow(), 1);
        conBd.conectarBd();
        // String sql = "SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL,TELCELULAR,CENOME,CETELRESIDENCIAL,CETELCELULAR "
        //        + "FROM PACIENTE WHERE NOMEPACIENTE = '" + Nome + "'";

        String sql = "SELECT NOMEPACIENTE FROM PACIENTE (NOLOCK) WHERE NOMEPACIENTE = '" + Nome + "'";

        try {
            conBd.executaSql(sql);
            conBd.rs.first();

            jTextFieldPaciente.setText(conBd.rs.getString("NOMEPACIENTE"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "erro ao selecionar os dados" + ex.getMessage());
        }

        conBd.DesconectarBd();
        HabilitarCampos();
        HabilitarBtn();
    }//GEN-LAST:event_jTableAgendamentoConsultaMouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
        LimparCampos();
        jFormattedTextFieldIdRetorno.setText("");
        DesabilitarCampos();
        DesabilitarBtn();

        preencherTabelaAgendamento("SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,"
                + "CETELRESIDENCIAL,CETELCELULAR FROM PACIENTE (NOLOCK) WHERE NOMEPACIENTE like '%" + jTextFieldPaciente.getText() + "%'");
    }//GEN-LAST:event_jButtonCancelarActionPerformed


    private void jButtonConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirActionPerformed

        DaoAgendamento daoAgendamento = new DaoAgendamento();
        Locale localZone = new Locale("br", "PT");
        SimpleDateFormat dtq = new SimpleDateFormat("yyyy-MM-dd", localZone);
        System.out.println("hora convertida :" + dtq.format(jDateChooserAgendamento.getDate()));
        int hora = daoAgendamento.BuscarIDHora((String) jComboBoxHorario.getSelectedItem());
        System.out.println("idhora " + hora);
        //if (!daoagenda.verificaChoqueHorario(jTextFieldPaciente.getText(), dtq.format(jDateChooserAgendamento.getDate()),hora)) {

        agen.setNomePaciente(jTextFieldPaciente.getText());
        agen.setNomeMedico((String) jComboBoxMedico.getSelectedItem());
        agen.setAgenIdHora(hora);
        agen.setMotivo(jTextAreaMotivo.getText());
        agen.setData(jDateChooserAgendamento.getDate());//dt.format(jDateChooserAgendamento.getDate()) String convertido em Date
        System.out.println("Data: " + jDateChooserAgendamento.getDate());
        System.out.println("Data: " + jDateChooserAgendamento.getDateFormatString());

        agen.setAEspecialidade(daoAgendamento.BuscarCodEspecEmNumero(String.valueOf(jComboBoxEspecMedica.getSelectedItem())));
        agen.setStatus("Aberto"); //status aberto
        agen.setARetorno((String) jComboBoxRetorno.getSelectedItem());
        //DEFINIR QUANTOS E QUAIS STATUS DEVEM EXISTIR TRANSFORMAR PARA NÚMERO
        if (agen.getARetorno().equalsIgnoreCase("Sim")) {

            agen.setARetorno("1");// retorno igual a sim
            agen.setAgenIdConsultaRetorno(Integer.parseInt(jFormattedTextFieldIdRetorno.getText().trim()));

        } else if (agen.getARetorno().equalsIgnoreCase("Não")) {

            agen.setARetorno("0"); // retorno igial a não
            agen.setAgenIdConsultaRetorno(0);
        }

        if (flag == 0) {
            daoAgendamento.Salvar(agen);
        } else if (flag == 1) {
            agen.setAgendaCod(idCodigoAgendamento);
            daoAgendamento.Alterar(agen);
        }

        // }
        LimparCampos();
        DesabilitarCampos();
        DesabilitarBtn();

        preencherTabelaAgendamento("SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,"
                + "CETELRESIDENCIAL,CETELCELULAR FROM PACIENTE (NOLOCK) WHERE NOMEPACIENTE like '%" + jTextFieldPaciente.getText() + "%'");

    }//GEN-LAST:event_jButtonConcluirActionPerformed

    private void jComboBoxMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMedicoActionPerformed
        // TODO add your handling code here:
        if (jComboBoxMedico.getSelectedItem() != "Selecione") {
            idMedico = daoagenda.BuscarCodMedico((String) jComboBoxMedico.getSelectedItem());
        }

    }//GEN-LAST:event_jComboBoxMedicoActionPerformed

    private void jButtonBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarPacienteActionPerformed
        // TODO add your handling code here:
        preencherTabelaAgendamento("SELECT IDPACIENTE,NOMEPACIENTE,TELRESIDENCIAL, TELCELULAR,CENOME,CETELRESIDENCIAL,CETELCELULAR "
                + "FROM PACIENTE (NOLOCK) WHERE NOMEPACIENTE like '%" + jTextFieldPaciente.getText() + "%'");
    }//GEN-LAST:event_jButtonBuscarPacienteActionPerformed

    private void jButtonBuscarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarConsultaActionPerformed
        // TODO add your handling code here:
        DaoAgendamento daoAgendamento = new DaoAgendamento();
        daoAgendamento.buscarPaciente(jTextFieldPaciente.getText());
        daoAgendamento.BuscarCodMedico(String.valueOf(jComboBoxMedico.getSelectedItem()));

        FormConsultaRetorno formConsultaRetorno = new FormConsultaRetorno(daoAgendamento.codPaciente, daoAgendamento.codMedico);
        formConsultaRetorno.setVisible(true);

    }//GEN-LAST:event_jButtonBuscarConsultaActionPerformed

    private void jButtonAtualizaConsultaRetornoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaConsultaRetornoActionPerformed
        // TODO add your handling code here:
        jFormattedTextFieldIdRetorno.setText(cRetorno);
    }//GEN-LAST:event_jButtonAtualizaConsultaRetornoActionPerformed

    private void jFormattedTextFieldIdRetornoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jFormattedTextFieldIdRetornoMouseClicked
        // TODO add your handling code here:
        if (jFormattedTextFieldIdRetorno.getText().isEmpty() == true) {
            String consultaRetorno = jFormattedTextFieldIdRetorno.getText().trim();

            FormConsulta formConsulta = new FormConsulta(consultaRetorno, 1);
            formConsulta.setVisible(true);
        }
    }//GEN-LAST:event_jFormattedTextFieldIdRetornoMouseClicked

    private void jFormattedTextFieldIdRetornoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jFormattedTextFieldIdRetornoPropertyChange
        // TODO add your handling code here:
        if (jFormattedTextFieldIdRetorno.getText().isEmpty() == true) {
            String consultaRetorno = jFormattedTextFieldIdRetorno.getText().trim();

            FormConsulta formConsulta = new FormConsulta(consultaRetorno, 1);
            formConsulta.setVisible(true);
        }
    }//GEN-LAST:event_jFormattedTextFieldIdRetornoPropertyChange

    private void jDateChooserAgendamentoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserAgendamentoPropertyChange
        try {
            DaoCheckDate daoCheckDate = new DaoCheckDate();
            DateAndCalendar dateAndCalendar = new DateAndCalendar();
            Calendar calendar = dateAndCalendar.dateToCalendar(jDateChooserAgendamento.getDate());
            DaoAgendamento dao = new DaoAgendamento();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            if (daoCheckDate.EhFimDeSemana(calendar)) {

                JOptionPane.showMessageDialog(rootPane, "A data selecionada (" + format.format(jDateChooserAgendamento.getDate()) 
                        + ") encontra-se em um fim de semana.\n "
                        + "Gentileza realizar agendamentos apenas de segunda a sexta conforme disponibilidade de horário.");
                jDateChooserAgendamento.setDate(null);
                 jComboBoxHorario.removeAllItems();
            jComboBoxHorario.setEnabled(false);
            }
        } catch (NullPointerException ex) {

        }finally{
             HabilitaComboHorario();
        }
    }//GEN-LAST:event_jDateChooserAgendamentoPropertyChange

    private void jComboBoxMedicoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxMedicoPropertyChange
        HabilitaComboHorario();
    }//GEN-LAST:event_jComboBoxMedicoPropertyChange

    public void preencherTabelaAgendamento(String sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "NOME DO PACIENTE", "TEL.RESIDENCIAL", "TEL.CELULAR", "ACOMPANHANTE", "TEL ACOMPANHANTE", "CEL ACOMPANHANTE"};

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

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
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
    
     protected void HabilitaComboHorario() {
        resposta = (String) jComboBoxEspecMedica.getSelectedItem();
        if (resposta != "Selecione") {

            if (jDateChooserAgendamento.getDate() != null) {
                jComboBoxHorario.removeAllItems();
                jComboBoxHorario.setEnabled(true);
                preencherHorario();
            }
        }
    }

    public void LimparCampos() {
        jTextAreaMotivo.setText(" ");
        jComboBoxMedico.removeAllItems();
        jComboBoxEspecMedica.setSelectedItem("Selecione");
        jComboBoxMedico.setSelectedItem("Selecione");
        //jComboBoxTurno.setSelectedItem("Selecione");
        jTextFieldPaciente.setText(" ");
        jComboBoxRetorno.setSelectedItem("Não");
        jDateChooserAgendamento.setDate(null);
        jComboBoxHorario.removeAllItems();
        jComboBoxHorario.setSelectedItem("Selecione");
        jFormattedTextFieldIdRetorno.setText(null);

    }

    public void DesabilitarBtn() {
        jButtonConcluir.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonEmail.setEnabled(false);
        jButtonBuscarConsulta.setEnabled(false);
        jButtonEmail.setEnabled(false);
    }

    public void HabilitarBtn() {
        jButtonConcluir.setEnabled(true);
        jButtonCancelar.setEnabled(true);
        jButtonEmail.setEnabled(true);
        jButtonEmail.setEnabled(true);
    }

    public void HabilitarCampos() {
        jTextAreaMotivo.setEnabled(true);
        jComboBoxMedico.setEnabled(true);
        //jComboBoxTurno.setEnabled(true);
        jDateChooserAgendamento.setEnabled(true);
        jComboBoxEspecMedica.setEnabled(true);
        jComboBoxRetorno.setEnabled(true);
        jDateChooserAgendamento.setEnabled(true);
        //   jComboBoxHorario.setEnabled(true);

    }

    public void DesabilitarCampos() {
        jTextAreaMotivo.setEnabled(false);
        jComboBoxMedico.setEnabled(false);
        // jComboBoxTurno.setEnabled(false);
        jDateChooserAgendamento.setEnabled(false);
        jComboBoxEspecMedica.setEnabled(false);
        jComboBoxRetorno.setEnabled(false);
        jDateChooserAgendamento.setEnabled(false);
        jComboBoxHorario.setEnabled(false);
        jFormattedTextFieldIdRetorno.setEnabled(false);
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
            java.util.logging.Logger.getLogger(FormAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendamento.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new FormAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizaConsultaRetorno;
    private javax.swing.JButton jButtonBuscarConsulta;
    private javax.swing.JButton jButtonBuscarPaciente;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConcluir;
    private javax.swing.JButton jButtonEmail;
    private javax.swing.JComboBox<String> jComboBoxEspecMedica;
    private javax.swing.JComboBox<String> jComboBoxHorario;
    private javax.swing.JComboBox<String> jComboBoxMedico;
    private javax.swing.JComboBox<String> jComboBoxRetorno;
    private com.toedter.calendar.JDateChooser jDateChooserAgendamento;
    private javax.swing.JFormattedTextField jFormattedTextFieldIdRetorno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAgendamentoConsulta;
    private javax.swing.JTextArea jTextAreaMotivo;
    private javax.swing.JTextField jTextFieldPaciente;
    // End of variables declaration//GEN-END:variables
}
