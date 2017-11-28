/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import ModeloConection.ConexaoBd;
import ModeloBeans.BeansAgendamento;
import ModeloBeans.ModeloTabela;
import ModeloDao.DaoAgendamento;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Daniel Lucas
 */
public class FormConsulta extends javax.swing.JFrame {

    BeansAgendamento agen = new BeansAgendamento();
    DaoAgendamento daoAgenda = new DaoAgendamento();
    ConexaoBd conBd = new ConexaoBd();

    JTabbedPane tabbedPane = new JTabbedPane();

    String codAgenda;
    Integer Idade;

    /**
     * Creates new form FormConsult
     *
     * @param Codigo direto tela FormAgenda
     */
    public FormConsulta(String Codigo) {
        initComponents();
        codAgenda = Codigo;
        int cod = Integer.parseInt(codAgenda);
        agen = daoAgenda.buscaAgendaPorCodigo(cod);
        HabilitaCampos();
        jTextFieldNomePacienteConsulta.setText(agen.getNomePaciente());
        jLabelNomeMedico.setText(agen.getNomeMedico());
        jFormattedTextFieldDtNAscimento.setText(agen.getDtNascPaciente());
        jTextAreaMotivoCosulta.setText(agen.getMotivo());
        //pensar em como retornar na label "sim ou não"
        jLabelRespRetorno.setText(agen.getARetorno());
        jTextFieldNumeroConsulta.setText(codAgenda);
        jTextFieldIdadePacienteConsulta.setText(String.valueOf(Idade));
        String dtNasc = agen.getDtNascPaciente();
        System.out.println(""+dtNasc);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dataNascimento = sdf.parse(dtNasc);
            int idade = calculaIdade(dataNascimento);
            //A idade é:
            jTextFieldIdadePacienteConsulta.setText(Integer.toString(idade));
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(rootPane,"Erro ao calcular a idade do paciente.");
           jTextFieldIdadePacienteConsulta.setText(" ");
        }
    }

    /**
     * Calcula a idade de uma pessoa considerando os meses e dias. 
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
    /* criar um metodo que calcule de forma automática o imc al inserir o peso e a altura
        */
     public void actionPerformed(ActionEvent e) {  
        String res;  
        int result=0;  
        
        if(jTextFieldAlturaPacienteConsulta.getText() == null || jTextFieldPesoPacienteConsulta.getText() == null){
            
        } else if(jTextFieldAlturaPacienteConsulta.getText() != null || jTextFieldPesoPacienteConsulta.getText() == null){
            
        }else if(jTextFieldAlturaPacienteConsulta.getText() == null || jTextFieldPesoPacienteConsulta.getText() != null){
            
        }else {
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
    
    
    private FormConsulta() {
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldNumeroConsulta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabelNome = new javax.swing.JLabel();
        jLabelMotivo = new javax.swing.JLabel();
        jLabelDtNascimento = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaMotivoCosulta = new javax.swing.JTextArea();
        jFormattedTextFieldDtNAscimento = new javax.swing.JFormattedTextField();
        jTextFieldNomePacienteConsulta = new javax.swing.JTextField();
        jLabelIdade = new javax.swing.JLabel();
        jTextFieldIdadePacienteConsulta = new javax.swing.JTextField();
        jLabelAltura = new javax.swing.JLabel();
        jTextFieldAlturaPacienteConsulta = new javax.swing.JTextField();
        jLabelPressaoArterial = new javax.swing.JLabel();
        jTextFieldPaPacienteConsulta = new javax.swing.JTextField();
        jLabelPeso = new javax.swing.JLabel();
        jTextFieldPesoPacienteConsulta = new javax.swing.JTextField();
        jLabelRetorno = new javax.swing.JLabel();
        jLabelRespRetorno = new javax.swing.JLabel();
        jLabelIMC = new javax.swing.JLabel();
        jTextFieldIMC = new javax.swing.JTextField();
        jLabelMedico = new javax.swing.JLabel();
        jLabelDiagnostico = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaDiagnosticoConsulta = new javax.swing.JTextArea();
        jLabelReceita = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaReceitaConsulta = new javax.swing.JTextArea();
        jLabelNomeMedico = new javax.swing.JLabel();
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
        jLabelNomeedicoPc = new javax.swing.JLabel();
        jLabelEspec = new javax.swing.JLabel();
        jLabelEspecPC = new javax.swing.JLabel();
        jLabelConsultaMedica = new javax.swing.JLabel();
        jButtonFimConsulta = new javax.swing.JButton();
        jButtonAtestado = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jTabbedPaneConsulta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPaneConsulta.setToolTipText("\n");
        jTabbedPaneConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneConsultaMouseClicked(evt);
            }
        });

        jLabel1.setText("Paciente");

        jLabel13.setText("Consulta Nº :");

        jTextFieldNumeroConsulta.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelNome.setText("Nome :");

        jLabelMotivo.setText("Motivo :");

        jLabelDtNascimento.setText("Data de nascimento :");

        jTextAreaMotivoCosulta.setColumns(20);
        jTextAreaMotivoCosulta.setRows(5);
        jTextAreaMotivoCosulta.setEnabled(false);
        jScrollPane2.setViewportView(jTextAreaMotivoCosulta);

        jFormattedTextFieldDtNAscimento.setEnabled(false);

        jTextFieldNomePacienteConsulta.setEnabled(false);

        jLabelIdade.setText("Idade :");

        jTextFieldIdadePacienteConsulta.setEnabled(false);

        jLabelAltura.setText("Altura :");

        jTextFieldAlturaPacienteConsulta.setEnabled(false);

        jLabelPressaoArterial.setText("Pressão Arterial :");

        jTextFieldPaPacienteConsulta.setEnabled(false);

        jLabelPeso.setText("Peso :");

        jTextFieldPesoPacienteConsulta.setEnabled(false);

        jLabelRetorno.setText("Retorno :");

        jLabelIMC.setText("IMC :");

        jTextFieldIMC.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomePacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jLabelDtNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextFieldDtNAscimento, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIdade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIdadePacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelAltura)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAlturaPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPeso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldPesoPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRetorno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelRespRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabelMotivo)
                        .addGap(291, 291, 291)
                        .addComponent(jLabelPressaoArterial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPaPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelIMC)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldIMC, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNome)
                    .addComponent(jTextFieldNomePacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDtNascimento)
                    .addComponent(jFormattedTextFieldDtNAscimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdade)
                    .addComponent(jTextFieldIdadePacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAltura)
                    .addComponent(jTextFieldAlturaPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPeso)
                    .addComponent(jTextFieldPesoPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRetorno)
                    .addComponent(jLabelRespRetorno, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelMotivo)
                    .addComponent(jLabelPressaoArterial)
                    .addComponent(jTextFieldPaPacienteConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIMC)
                    .addComponent(jTextFieldIMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabelMedico.setText("Médico :");

        jLabelDiagnostico.setText("Diagnóstico :");

        jTextAreaDiagnosticoConsulta.setColumns(20);
        jTextAreaDiagnosticoConsulta.setRows(5);
        jScrollPane3.setViewportView(jTextAreaDiagnosticoConsulta);

        jLabelReceita.setText("Receita :");

        jTextAreaReceitaConsulta.setColumns(20);
        jTextAreaReceitaConsulta.setRows(5);
        jScrollPane1.setViewportView(jTextAreaReceitaConsulta);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNumeroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelReceita, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDiagnostico, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jLabelMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumeroConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabelNomeMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDiagnostico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelReceita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneConsulta.addTab("Consulta", jPanel1);

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
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDiagnosticoP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelReceitaP)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(3, 3, 3)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabelMotivoPC)
                                .addGap(260, 260, 260)
                                .addComponent(jLabelMedicoP))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabelNomeP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelIdadeP)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
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
                                .addComponent(jLabelRetornoPC, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabelNomeedicoPc, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelEspec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelEspecPC, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(125, 125, 125))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMotivoPC)
                            .addComponent(jLabelMedicoP)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(jLabelNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabelRetornoPC, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                                        .addGap(3, 3, 3))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabelRetornoP)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelNomeedicoPc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelEspec, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabelEspecPC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addContainerGap())
        );

        jTabbedPaneConsulta.addTab("Histórico do Paciente", jPanel3);

        jLabelConsultaMedica.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelConsultaMedica.setText("Consulta Médica");

        jButtonFimConsulta.setText("Finalizar Consulta");
        jButtonFimConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFimConsultaActionPerformed(evt);
            }
        });

        jButtonAtestado.setText("Gerar Atestado");

        jButtonCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPaneConsulta))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(390, 390, 390)
                                .addComponent(jLabelConsultaMedica))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(263, 263, 263)
                                .addComponent(jButtonAtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonFimConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelConsultaMedica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFimConsulta)
                    .addComponent(jButtonAtestado)
                    .addComponent(jButtonCancelar))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1022, 740));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFimConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFimConsultaActionPerformed
        // TODO add your handling code here:
//        String sqlFimConsulta = "SELECT * FROM AGENDAMENTO WHERE IDAGENDAMENTO = '"+codAgenda+"'";
//        System.out.println("consulta "+sqlFimConsulta);
//        
//        conBd.executaSql(sqlFimConsulta);
        try {
//       System.out.println(""+conBd.rs.first());

//            conBd.rs.first();
            agen.setStatus("Em Atendimento");
            agen.setAIdPaciente(conBd.rs.getInt("IDPACIENTE"));
            agen.setAIdMedico(conBd.rs.getInt("IDMEDICO"));
            agen.setAEspecialidade(conBd.rs.getInt("IDESPECIALIDADE"));
            agen.setTurno(conBd.rs.getString("TURNO"));
            agen.setData(conBd.rs.getDate("DTAGENDAMENTO"));
            agen.setAgendaCod(conBd.rs.getInt("IDAGENDAMENTO"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar os dados" + ex.getMessage());
        } finally {

            // conBd.DesconectarBd();
        }
        daoAgenda.Alterar(agen);

    }//GEN-LAST:event_jButtonFimConsultaActionPerformed

    private void jTabbedPaneConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneConsultaMouseClicked
        // TODO add your handling code here:
        int i = jTabbedPaneConsulta.getSelectedIndex();
        if (i == 1) {
            //  jTabbedPaneConsulta.setSelectedIndex(jTabbedPaneConsulta.getComponentCount()-1);

            preencherTabelaAgenda("SELECT * FROM AGENDAMENTO WHERE IDAGENDAMENTO = '" + codAgenda + "'");

        }


    }//GEN-LAST:event_jTabbedPaneConsultaMouseClicked

    private void jTableConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jTableConsultaMouseClicked

    public final void preencherTabelaAgenda(String sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "STATUS", "NOME PACIENTE", "TURNO", "DATA", "NOME MEDICO", "ESPECIALIDADE", "RETORNO"};
        String retorno;

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
            JOptionPane.showMessageDialog(null, "Nenhuma consulta localizada para hoje.");
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

    public void HabilitaCampos() {

        jTextFieldAlturaPacienteConsulta.setEnabled(true);
        jTextFieldPaPacienteConsulta.setEnabled(true);
        jTextFieldPesoPacienteConsulta.setEnabled(true);

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
            java.util.logging.Logger.getLogger(FormConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtestado;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonFimConsulta;
    private javax.swing.JFormattedTextField jFormattedTextFieldDtNAscimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabelAltura;
    private javax.swing.JLabel jLabelAlturaP;
    private javax.swing.JLabel jLabelAlturaPC;
    private javax.swing.JLabel jLabelConsultaMedica;
    private javax.swing.JLabel jLabelDiagnostico;
    private javax.swing.JLabel jLabelDiagnosticoP;
    private javax.swing.JLabel jLabelDtNascimento;
    private javax.swing.JLabel jLabelEspec;
    private javax.swing.JLabel jLabelEspecPC;
    private javax.swing.JLabel jLabelIMC;
    private javax.swing.JLabel jLabelIdade;
    private javax.swing.JLabel jLabelIdadeP;
    private javax.swing.JLabel jLabelIdadePC;
    private javax.swing.JLabel jLabelMedico;
    private javax.swing.JLabel jLabelMedicoP;
    private javax.swing.JLabel jLabelMotivo;
    private javax.swing.JLabel jLabelMotivoPC;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeMedico;
    private javax.swing.JLabel jLabelNomeP;
    private javax.swing.JLabel jLabelNomePaciente;
    private javax.swing.JLabel jLabelNomeedicoPc;
    private javax.swing.JLabel jLabelPa;
    private javax.swing.JLabel jLabelPaP;
    private javax.swing.JLabel jLabelPeso;
    private javax.swing.JLabel jLabelPesoP;
    private javax.swing.JLabel jLabelPesoPC;
    private javax.swing.JLabel jLabelPressaoArterial;
    private javax.swing.JLabel jLabelReceita;
    private javax.swing.JLabel jLabelReceitaP;
    private javax.swing.JLabel jLabelRespRetorno;
    private javax.swing.JLabel jLabelRetorno;
    private javax.swing.JLabel jLabelRetornoP;
    private javax.swing.JLabel jLabelRetornoPC;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPaneConsulta;
    private javax.swing.JTable jTableConsulta;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextAreaDiagnosticoConsulta;
    private javax.swing.JTextArea jTextAreaMotivoCosulta;
    private javax.swing.JTextArea jTextAreaMotivoP;
    private javax.swing.JTextArea jTextAreaReceita;
    private javax.swing.JTextArea jTextAreaReceitaConsulta;
    private javax.swing.JTextField jTextFieldAlturaPacienteConsulta;
    private javax.swing.JTextField jTextFieldIMC;
    private javax.swing.JTextField jTextFieldIdadePacienteConsulta;
    private javax.swing.JTextField jTextFieldNomePacienteConsulta;
    private javax.swing.JTextField jTextFieldNumeroConsulta;
    private javax.swing.JTextField jTextFieldPaPacienteConsulta;
    private javax.swing.JTextField jTextFieldPesoPacienteConsulta;
    // End of variables declaration//GEN-END:variables
}
