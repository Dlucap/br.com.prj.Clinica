/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteTeste.visao;

import Visao.*;
import ModeloConection.ConexaoBd;
import ModeloBeans.BeansAgendamento;
import ModeloBeans.BeansConsulta;
import ModeloBeans.ModeloTabela;
import ModeloDao.DaoAgendamento;
import ModeloDao.DaoConsulta;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Daniel Lucas
 */
public class FormConsultaNew extends javax.swing.JFrame {

    BeansAgendamento beansAgendamento = new BeansAgendamento();
    BeansConsulta beansConsulta = new BeansConsulta();

    DaoAgendamento daoAgenda = new DaoAgendamento();
    DaoConsulta daoConsulta = new DaoConsulta();

    ConexaoBd conBd = new ConexaoBd();

    JTabbedPane tabbedPane = new JTabbedPane();

    String codAgenda;
    Integer idAgendamento,idPaciente,idMedico,idEspecialidade,idHora;
    Date dtAgendamento;
    Integer Idade;

    /**
     * Creates new form FormConsult tipo 0 e 1.
     * indica se será uma nova consulta(0) ou se será apenas uma consulta 
     * em atendimento já realizado (1) os campos da tela não serão editados.
     *
     * @param Codigo direto tela FormAgendaMedico
     * @param tipo
     */
    public FormConsultaNew(String Codigo, Integer tipo) {
        initComponents();
        codAgenda = Codigo;
        if (tipo == 0) {
            
            //nova consulta
            jButtonSairConsulta.setVisible(false);
            preencherIdConsultaIncluir();
            int cod = Integer.parseInt(codAgenda);
            beansAgendamento = daoAgenda.buscaAgendaPorCodigo(cod);
            
            HabilitaCampos();
            jTextFieldNomePacienteConsulta.setText(beansAgendamento.getNomePaciente());
            //jLabelNomeMedico.setText(beansAgendamento.getNomeMedico());
            jFormattedTextFieldDtNAscimento.setText(beansAgendamento.getDtNascPaciente());
            //jTextAreaMotivoCosulta.setText(beansAgendamento.getMotivo());
            //pensar em como retornar na label "sim ou não"
                      
            if (beansAgendamento.getARetorno() == "Sim") {
                jLabelConsultaRetorno.setText(String.valueOf(beansAgendamento.getAgenIdConsultaRetorno()));
                jLabelRespRetorno.setText(beansAgendamento.getARetorno());
            } else {
                jLabelConsultaRetorno.show(false);
                jLabelRespRetorno.setText("");
            }
            
            jTextFieldIdadePacienteConsulta.setText(String.valueOf(Idade));
            
            String dtNasc = beansAgendamento.getDtNascPaciente();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            try {
                Date dataNascimento = sdf.parse(dtNasc);
                int idade = calculaIdade(dataNascimento);
                //A idade é:
                jTextFieldIdadePacienteConsulta.setText(Integer.toString(idade));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao calcular a idade do paciente.");
                jTextFieldIdadePacienteConsulta.setText(" ");
            }
        } else if (tipo == 1) {
            //consultando uma consulta ja finalizado
            jButtonSairConsulta.setVisible(true);           
         
        }

    }

    /**
     * Calcula a idade de uma pessoa considerando os meses e dias.
     *
     * @param dataNasc Data de nascimento
     * @return <code>int</code> Idade
     */
    public static int calculaIdade(java.util.Date dataNasc) {

        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.setTime(dataNasc);
        Calendar hoje = Calendar.getInstance();

        int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
            idade--;
        } else {
            if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH)
                    && hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
                idade--;
            }
        }

        return idade;
    }

    /* criar um metodo que calcule de forma automática o imc ao inserir o peso e a altura
     */
    public void actionPerformed(ActionEvent e) {
        String res;
        int result = 0;

        if (jFormattedTextFieldAlturaPaciente.getText() == null || jFormattedTextFieldPesoPaciente.getText() == null) {

        } else if (jFormattedTextFieldAlturaPaciente.getText() != null || jFormattedTextFieldPesoPaciente.getText() == null) {

        } else if (jFormattedTextFieldAlturaPaciente.getText() == null || jFormattedTextFieldPesoPaciente.getText() != null) {

        } else {
            System.out.println("TESTE");
        }/*
        if (e.getSource() == mais) {   
            result = Integer.parseInt(n1.getText()) + Integer.parseInt(n2.getText());  
            res = Integer.toString(result);  
            resultado.setText(res);   
        }  
        else if (e.getSource() == menos) {  
            result = Integer.parseInt(n1.getText()) - Integer.parseInt(n2.getText());  
            res = Integer.toString(result);  
            resultado.setText(res);  
        }  
        else if (e.getSource() == vezes) {  
            result = Integer.parseInt(n1.getText()) * Integer.parseInt(n2.getText());  
            res = Integer.toString(result);  
            resultado.setText(res);  
        }  */
    }

    private FormConsultaNew() {
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

        jTabbedPaneConsulta = new javax.swing.JTabbedPane();
        jPanelDadosConsulta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableConsulta = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabelDiagnosticoP = new javax.swing.JLabel();
        jLabelReceitaP = new javax.swing.JLabel();
        jLabelNomeP = new javax.swing.JLabel();
        jLabelNomePaciente = new javax.swing.JLabel();
        jLabelIdadeP = new javax.swing.JLabel();
        jLabelAlturaP = new javax.swing.JLabel();
        jLabelPesoP = new javax.swing.JLabel();
        jLabelPaP = new javax.swing.JLabel();
        jLabelRetornoP = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextAreaMotivoP = new javax.swing.JTextArea();
        jLabelRetornoPC = new javax.swing.JLabel();
        jLabelPa = new javax.swing.JLabel();
        jLabelPesoPC = new javax.swing.JLabel();
        jLabelAlturaPC = new javax.swing.JLabel();
        jLabelIdadePC = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextAreaReceita = new javax.swing.JTextArea();
        jLabelMotivoPC = new javax.swing.JLabel();
        jLabelMedicoP = new javax.swing.JLabel();
        jLabelNomeMedicoPc = new javax.swing.JLabel();
        jLabelEspec = new javax.swing.JLabel();
        jLabelEspecPC = new javax.swing.JLabel();
        jLabelHistoricoDataConsulta = new javax.swing.JLabel();
        jLabelHistDataConsul = new javax.swing.JLabel();
        jLabelConsultaMedica = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNumeroConsulta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelDtNascimento = new javax.swing.JLabel();
        jFormattedTextFieldDtNAscimento = new javax.swing.JFormattedTextField();
        jTextFieldNomePacienteConsulta = new javax.swing.JTextField();
        jLabelIdade = new javax.swing.JLabel();
        jTextFieldIdadePacienteConsulta = new javax.swing.JTextField();
        jLabelAltura = new javax.swing.JLabel();
        jLabelPressaoArterial = new javax.swing.JLabel();
        jTextFieldPaPacienteConsulta = new javax.swing.JTextField();
        jLabelPeso = new javax.swing.JLabel();
        jLabelRetorno = new javax.swing.JLabel();
        jLabelRespRetorno = new javax.swing.JLabel();
        jLabelIMC = new javax.swing.JLabel();
        jTextFieldIMC = new javax.swing.JTextField();
        jButtonCalcularIMC = new javax.swing.JButton();
        jLabelConsultaRetorno = new javax.swing.JLabel();
        jFormattedTextFieldAlturaPaciente = new javax.swing.JFormattedTextField();
        jFormattedTextFieldPesoPaciente = new javax.swing.JFormattedTextField();
        jLabelNumeroConsultaRetorno = new javax.swing.JLabel();
        jButtonSairConsulta = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonFimConsulta2 = new javax.swing.JButton();
        jButtonAtestado = new javax.swing.JButton();
        jButtonImprimirReceita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPaneConsulta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPaneConsulta.setToolTipText("\n");
        jTabbedPaneConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneConsultaMouseClicked(evt);
            }
        });
        jTabbedPaneConsulta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTabbedPaneConsultaPropertyChange(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setText("Sintomas.: ");

        javax.swing.GroupLayout jPanelDadosConsultaLayout = new javax.swing.GroupLayout(jPanelDadosConsulta);
        jPanelDadosConsulta.setLayout(jPanelDadosConsultaLayout);
        jPanelDadosConsultaLayout.setHorizontalGroup(
            jPanelDadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosConsultaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelDadosConsultaLayout.createSequentialGroup()
                        .addGap(456, 456, 456)
                        .addComponent(jLabel2)
                        .addGap(0, 528, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelDadosConsultaLayout.setVerticalGroup(
            jPanelDadosConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosConsultaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        jTabbedPaneConsulta.addTab("Consulta", jPanelDadosConsulta);

        jTableConsulta.setBorder(new javax.swing.border.MatteBorder(null));
        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableConsulta);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setEnabled(false);
        jScrollPane6.setViewportView(jTextArea2);

        jLabelDiagnosticoP.setText("Diagnostico :");

        jLabelReceitaP.setText("Receita :");

        jLabelNomeP.setText("Nome :");

        jLabelIdadeP.setText("Idade :");

        jLabelAlturaP.setText("Altura :");

        jLabelPesoP.setText("Peso :");

        jLabelPaP.setText("Pressão Aterial :");

        jLabelRetornoP.setText("Retorno :");

        jTextAreaMotivoP.setColumns(20);
        jTextAreaMotivoP.setRows(5);
        jTextAreaMotivoP.setEnabled(false);
        jScrollPane7.setViewportView(jTextAreaMotivoP);

        jTextAreaReceita.setColumns(20);
        jTextAreaReceita.setRows(5);
        jTextAreaReceita.setEnabled(false);
        jScrollPane9.setViewportView(jTextAreaReceita);

        jLabelMotivoPC.setText("Motivo :");

        jLabelMedicoP.setText("Medico :");

        jLabelEspec.setText("Especialidade : ");

        jLabelHistoricoDataConsulta.setText("Data :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDiagnosticoP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelReceitaP)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabelMotivoPC)
                                .addGap(260, 260, 260)
                                .addComponent(jLabelMedicoP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNomeMedicoPc, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEspec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelEspecPC, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabelHistoricoDataConsulta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelHistDataConsul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNomeP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelIdadeP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelIdadePC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelAlturaP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelAlturaPC, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelPesoP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPesoPC, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPaP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelPa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jLabelRetornoP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRetornoPC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRetornoPC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelHistoricoDataConsulta, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelHistDataConsul, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelPa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNomeP, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelAlturaPC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelPesoP)
                                    .addComponent(jLabelPaP))
                                .addComponent(jLabelPesoPC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelIdadePC, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelAlturaP)
                            .addComponent(jLabelIdadeP)
                            .addComponent(jLabelNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRetornoP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelMotivoPC)
                        .addComponent(jLabelMedicoP))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNomeMedicoPc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEspec, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabelEspecPC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDiagnosticoP)
                    .addComponent(jLabelReceitaP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        jTabbedPaneConsulta.addTab("Histórico do Paciente", jPanel3);

        jLabelConsultaMedica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelConsultaMedica.setText("Consulta Médica");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Paciente");

        jLabel13.setText("Consulta Nº :");

        jTextFieldNumeroConsulta.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelNome.setText("Nome :");

        jLabelDtNascimento.setText("Data de nascimento :");

        jFormattedTextFieldDtNAscimento.setEnabled(false);

        jTextFieldNomePacienteConsulta.setEnabled(false);

        jLabelIdade.setText("Idade :");

        jTextFieldIdadePacienteConsulta.setEnabled(false);

        jLabelAltura.setText("Altura :");

        jLabelPressaoArterial.setText("Pressão Arterial :");

        jTextFieldPaPacienteConsulta.setEnabled(false);

        jLabelPeso.setText("Peso :");

        jLabelRetorno.setText("Retorno :");

        jLabelIMC.setText("IMC :");

        jTextFieldIMC.setEnabled(false);

        jButtonCalcularIMC.setText("Calcular IMC");
        jButtonCalcularIMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularIMCActionPerformed(evt);
            }
        });

        jLabelConsultaRetorno.setText("Número Consulta Retorno:");

        try {
            jFormattedTextFieldAlturaPaciente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldAlturaPaciente.setEnabled(false);

        jFormattedTextFieldPesoPaciente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##,##"))));
        jFormattedTextFieldPesoPaciente.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomePacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPressaoArterial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPaPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldPesoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelDtNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldDtNAscimento, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelIdade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIdadePacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAltura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldAlturaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelIMC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCalcularIMC)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabelRetorno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRespRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNumeroConsultaRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(194, 194, 194)
                                .addComponent(jLabelConsultaRetorno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(176, 176, 176))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(jLabelPressaoArterial)
                                .addComponent(jTextFieldPaPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldNomePacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelNome)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabelPeso))
                                    .addComponent(jFormattedTextFieldPesoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelRespRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelDtNascimento)
                                .addComponent(jFormattedTextFieldDtNAscimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelIdade)
                                .addComponent(jTextFieldIdadePacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jFormattedTextFieldAlturaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelIMC)
                                .addComponent(jTextFieldIMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButtonCalcularIMC))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabelAltura))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelRetorno)
                            .addComponent(jLabelConsultaRetorno))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNumeroConsultaRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNumeroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1058, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumeroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonSairConsulta.setText("Sair Da Consulta");

        jButtonCancelar.setText("Cancelar");

        jButtonFimConsulta2.setText("Finalizar Consulta");
        jButtonFimConsulta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFimConsulta2ActionPerformed(evt);
            }
        });

        jButtonAtestado.setText("Gerar Atestado");

        jButtonImprimirReceita.setText("Imprimir Receita");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(489, 489, 489)
                                .addComponent(jLabelConsultaMedica))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTabbedPaneConsulta))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jButtonImprimirReceita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAtestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFimConsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSairConsulta)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelConsultaMedica)
                .addGap(7, 7, 7)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonImprimirReceita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonAtestado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonFimConsulta2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSairConsulta))))
        );

        setSize(new java.awt.Dimension(1090, 715));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPaneConsultaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneConsultaPropertyChange
        // TODO add your handling code here:
        System.err.println("ddddddddddddd");
    }//GEN-LAST:event_jTabbedPaneConsultaPropertyChange

    private void jTabbedPaneConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneConsultaMouseClicked
        // TODO add your handling code here:
        int i = jTabbedPaneConsulta.getSelectedIndex();
        if (i == 1) {
            //  jTabbedPaneConsulta.setSelectedIndex(jTabbedPaneConsulta.getComponentCount()-1);

            preencherTabelaAgenda("SELECT * FROM AGENDAMENTO WHERE STATUSCONSULTA = 'FINALIZADO' AND  IDPACIENTE = 12");

        }
    }//GEN-LAST:event_jTabbedPaneConsultaMouseClicked

    private void jTableConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTableConsultaMouseClicked

    private void jButtonCalcularIMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularIMCActionPerformed
        // TODO add your handling code here:
        double IMC = 0, altura = 0, peso = 0;
        altura = Float.parseFloat(jFormattedTextFieldAlturaPaciente.getText());
        peso = Float.parseFloat(jFormattedTextFieldPesoPaciente.getText());
        //IMC = Peso ÷ altura x altura.
        DecimalFormat decimal = new DecimalFormat("0.00");
        IMC = peso / Math.pow(altura, 2);
        jTextFieldIMC.setText(String.valueOf(decimal.format(IMC)));

        /*
        *   Classificação               IMC                             O que pode acontecer
        *   Muito abaixo do peso    16 a 16,9 kg/m2         Queda de cabelo, infertilidade, ausência menstrual
        *   Abaixo do peso          17 a 18,4 kg/m2         Fadiga, stress, ansiedade
        *   Peso normal             18,5 a 24,9 kg/m2       Menor risco de doenças cardíacas e vasculares
        *   Acima do peso           25 a 29,9 kg/m2         Fadiga, má circulação, varizes
        *   Obesidade Grau I        30 a 34,9 kg/m2         Diabetes, angina, infarto, aterosclerose
        *   Obesidade Grau II       35 a 40 kg/m2           Apneia do sono, falta de ar
        *   Obesidade Grau III      maior que 40 kg/m2      Refluxo, dificuldade para se mover, escaras, diabetes, infarto, AVC
        */
    }//GEN-LAST:event_jButtonCalcularIMCActionPerformed

    private void jButtonFimConsulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFimConsulta2ActionPerformed
        // TODO add your handling code here:

        int cod = Integer.parseInt(codAgenda);
        beansAgendamento = daoAgenda.buscaAgendamentoPorCodigo(cod);

        beansAgendamento.setStatus("Finalizado");//finalizado
        beansAgendamento.setAIdPaciente(beansAgendamento.getAIdPaciente());
        beansAgendamento.setAIdMedico(beansAgendamento.getAIdMedico());
        beansAgendamento.setAEspecialidade(beansAgendamento.getAEspecialidade());
        beansAgendamento.setAgenIdHora(beansAgendamento.getAgenIdHora());
        beansAgendamento.setData(beansAgendamento.getData());
        beansAgendamento.setAgendaCod(cod);

        daoAgenda.Alterar(beansAgendamento);

        beansConsulta.setIdAgendamento(cod);
        beansConsulta.setAltura(Float.parseFloat(jFormattedTextFieldAlturaPaciente.getText()));
        beansConsulta.setPeso(Float.parseFloat(jFormattedTextFieldPesoPaciente.getText()));
        beansConsulta.setPressaoArterial(jTextFieldPaPacienteConsulta.getText());
       // beansConsulta.setReceita(jTextAreaReceitaConsulta.getText());
       // beansConsulta.setDiagnostico(jTextAreaDiagnosticoConsulta.getText());

        daoConsulta.Salvar(beansConsulta);

        jFormattedTextFieldAlturaPaciente. setEnabled(false);
        jFormattedTextFieldPesoPaciente. setEnabled(false);
        jTextFieldPaPacienteConsulta. setEnabled(false);
       // jTextAreaReceitaConsulta. setEnabled(false);
       // jTextAreaDiagnosticoConsulta. setEnabled(false);
        jButtonSairConsulta.setVisible(true);
        jButtonCalcularIMC.setEnabled(false);
    }//GEN-LAST:event_jButtonFimConsulta2ActionPerformed

    public final void preencherTabelaAgenda(String sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "STATUS", "NOME PACIENTE", "TURNO", "DATA", "NOME MEDICO", "ESPECIALIDADE", "RETORNO"};
        String retorno, statusConsult;

        conBd.conectarBd();

        conBd.executaSql(sql);

        try {
            conBd.rs.first();

            do {
                if (conBd.rs.getBoolean("RETORNO") == true) {
                    retorno = "       Sim";
                } else {
                    retorno = "       Não";
                }

                dados.add(new Object[]{conBd.rs.getInt("IDAGENDAMENTO"), conBd.rs.getString("STATUSCONSULTA"), conBd.rs.getString("NOMEPACIENTE"),
                    conBd.rs.getString("TURNO"), conBd.rs.getString("DTAGENDAMENTO"), conBd.rs.getString("NOMEMEDICO"), conBd.rs.getString("ESPEC"),//});
                    retorno});

            } while (conBd.rs.next());

        } catch (SQLException ex) {
            if (jTabbedPaneConsulta.getSelectedIndex() == 1) {
                JOptionPane.showMessageDialog(null, "Paciente não possui histórico de consultas cadastrada!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma consulta localizada para hoje.");
            }

        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        jTableConsulta.setModel(modelo);

        jTableConsulta.getColumnModel().getColumn(0).setPreferredWidth(38);//Tamanho da tabela
        jTableConsulta.getColumnModel().getColumn(0).setResizable(false);

        jTableConsulta.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTableConsulta.getColumnModel().getColumn(1).setResizable(false);

        jTableConsulta.getColumnModel().getColumn(2).setPreferredWidth(237);
        jTableConsulta.getColumnModel().getColumn(2).setResizable(false);

        jTableConsulta.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTableConsulta.getColumnModel().getColumn(3).setResizable(false);

        jTableConsulta.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTableConsulta.getColumnModel().getColumn(4).setResizable(false);

        jTableConsulta.getColumnModel().getColumn(5).setPreferredWidth(237);
        jTableConsulta.getColumnModel().getColumn(5).setResizable(false);

        jTableConsulta.getColumnModel().getColumn(6).setPreferredWidth(124);
        jTableConsulta.getColumnModel().getColumn(6).setResizable(false);

        jTableConsulta.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTableConsulta.getColumnModel().getColumn(7).setResizable(false);

        jTableConsulta.getTableHeader().setReorderingAllowed(false);//reorganizar o cabeçalho
        jTableConsulta.setAutoResizeMode(jTableConsulta.AUTO_RESIZE_OFF); //NÃO VAI PODER REDIMENCIONAR A TABELA
        jTableConsulta.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//selecionar um por vez 
        //total do tamanho dos campos = 38 + 237 + 110 + 65 = 450
        conBd.DesconectarBd();
    }

    public void preencherIdConsultaIncluir() {
        try {
            conBd.conectarBd();
            String sql = "SELECT MAX(IDCONSULTA+1) AS PROXID FROM CONSULTA";
            conBd.executaSql(sql);

            conBd.rs.first();

            if(String.valueOf(conBd.rs.getInt("PROXID")).equals("0")){
                jTextFieldNumeroConsulta.setText("1");
            }else {
               jTextFieldNumeroConsulta.setText(String.valueOf(conBd.rs.getInt("PROXID")));
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar o proximo ID do usuário! " + ex.getMessage());
        }
        conBd.DesconectarBd();
    }
     
     public void HabilitaCampos() {

        jFormattedTextFieldAlturaPaciente.setEnabled(true);
        jTextFieldPaPacienteConsulta.setEnabled(true);
        jFormattedTextFieldPesoPaciente.setEnabled(true);

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
            java.util.logging.Logger.getLogger(FormConsultaNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConsultaNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConsultaNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConsultaNew.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new FormConsultaNew().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtestado;
    private javax.swing.JButton jButtonCalcularIMC;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonFimConsulta2;
    private javax.swing.JButton jButtonImprimirReceita;
    private javax.swing.JButton jButtonSairConsulta;
    private javax.swing.JFormattedTextField jFormattedTextFieldAlturaPaciente;
    private javax.swing.JFormattedTextField jFormattedTextFieldDtNAscimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldPesoPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelAlturaP;
    private javax.swing.JLabel jLabelAlturaPC;
    private javax.swing.JLabel jLabelConsultaMedica;
    private javax.swing.JLabel jLabelConsultaRetorno;
    private javax.swing.JLabel jLabelDiagnosticoP;
    private javax.swing.JLabel jLabelDtNascimento;
    private javax.swing.JLabel jLabelEspec;
    private javax.swing.JLabel jLabelEspecPC;
    private javax.swing.JLabel jLabelHistDataConsul;
    private javax.swing.JLabel jLabelHistoricoDataConsulta;
    private javax.swing.JLabel jLabelIMC;
    private javax.swing.JLabel jLabelIdade;
    private javax.swing.JLabel jLabelIdadeP;
    private javax.swing.JLabel jLabelIdadePC;
    private javax.swing.JLabel jLabelMedicoP;
    private javax.swing.JLabel jLabelMotivoPC;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeMedicoPc;
    private javax.swing.JLabel jLabelNomeP;
    private javax.swing.JLabel jLabelNomePaciente;
    private javax.swing.JLabel jLabelNumeroConsultaRetorno;
    private javax.swing.JLabel jLabelPa;
    private javax.swing.JLabel jLabelPaP;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelPesoP;
    private javax.swing.JLabel jLabelPesoPC;
    private javax.swing.JLabel jLabelPressaoArterial;
    private javax.swing.JLabel jLabelReceitaP;
    private javax.swing.JLabel jLabelRespRetorno;
    private javax.swing.JLabel jLabelRetorno;
    private javax.swing.JLabel jLabelRetornoP;
    private javax.swing.JLabel jLabelRetornoPC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelDadosConsulta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPaneConsulta;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextAreaMotivoP;
    private javax.swing.JTextArea jTextAreaReceita;
    private javax.swing.JTextField jTextFieldIMC;
    private javax.swing.JTextField jTextFieldIdadePacienteConsulta;
    private javax.swing.JTextField jTextFieldNomePacienteConsulta;
    private javax.swing.JTextField jTextFieldNumeroConsulta;
    private javax.swing.JTextField jTextFieldPaPacienteConsulta;
    // End of variables declaration//GEN-END:variables
}
