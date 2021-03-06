package Visao;

import ModeloBeans.BeansAgendamento;
import ModeloBeans.BeansDadosUsuario;
import ModeloBeans.ModeloTabela;
import ModeloConection.ConexaoBd;
import ModeloDao.DaoAgendamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Daniel Lucas
 */
public class FormAgendaMedico extends javax.swing.JFrame {

    ConexaoBd conBd = new ConexaoBd();
    BeansAgendamento agenda = new BeansAgendamento();
    BeansAgendamento agen = new BeansAgendamento();
    DaoAgendamento daoagenda = new DaoAgendamento();

    ResultSet rs = null;
    PreparedStatement pstAM;

    String dtHoje,codigo,Agenda,status;

    public FormAgendaMedico(){
        
    }
     
    public FormAgendaMedico(BeansDadosUsuario beansDadosUsuario) {
        initComponents();
        
        jComboBoxAgendaMedico.removeAll();
        preencherMedico();
        DataHoje();
        
    }

     public void DataHoje() {

        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.format(d);

        dtHoje = dateFormat.format(d);
        status = "Em Atendimento";
    }
    
    public void preencherMedico() {
        conBd.conectarBd();

        try {

           jComboBoxAgendaMedico.addItem("Selecione");
           String sql = "SELECT NOMEMEDICO FROM MEDICO ORDER BY NOMEMEDICO"; // mostrar apenas os medicos ativos 

            pstAM = conBd.con.prepareStatement(sql);
            rs = pstAM.executeQuery();

            while (rs.next()) {
                jComboBoxAgendaMedico.addItem(rs.getString("NOMEMEDICO"));
            }

        } catch (SQLException ex) {
            // Logger.getLogger(FormMedico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher as informações do medico" + ex);
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(rootPane, "Não existem ou não foram encontrado médicos cadastrados." + ex.getMessage());
        }

        conBd.DesconectarBd();
    }

    public final void preencherTabelaAgenda(String sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "STATUS", "NOME PACIENTE", "HORÁRIO", "DATA", "NOME MEDICO", "ESPECIALIDADE"};
        conBd.conectarBd();
       
        conBd.executaSql(sql);

        try {
           conBd.rs.first();

            do {
                dados.add(new Object[]{conBd.rs.getInt("IDAGENDAMENTO"), conBd.rs.getString("STATUSCONSULTA"), conBd.rs.getString("NOMEPACIENTE"),
                    conBd.rs.getString("HORA"), conBd.rs.getString("DTAGENDAMENTO"), conBd.rs.getString("NOMEMEDICO"), conBd.rs.getString("ESPEC")});

            } while (conBd.rs.next());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe agendamentos para o médico selecionado!");
        }

        ModeloTabela modelo = new ModeloTabela(dados,colunas);
        jTableAgendaMedica.setModel(modelo);

        jTableAgendaMedica.getColumnModel().getColumn(0).setPreferredWidth(40);//Tamanho da tabela
        jTableAgendaMedica.getColumnModel().getColumn(0).setResizable(false);

        jTableAgendaMedica.getColumnModel().getColumn(1).setPreferredWidth(110);
        jTableAgendaMedica.getColumnModel().getColumn(1).setResizable(false);

        jTableAgendaMedica.getColumnModel().getColumn(2).setPreferredWidth(237);
        jTableAgendaMedica.getColumnModel().getColumn(2).setResizable(false);

        jTableAgendaMedica.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTableAgendaMedica.getColumnModel().getColumn(3).setResizable(false);

        jTableAgendaMedica.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTableAgendaMedica.getColumnModel().getColumn(4).setResizable(false);

        jTableAgendaMedica.getColumnModel().getColumn(5).setPreferredWidth(237);
        jTableAgendaMedica.getColumnModel().getColumn(5).setResizable(false);

        jTableAgendaMedica.getColumnModel().getColumn(6).setPreferredWidth(111);
        jTableAgendaMedica.getColumnModel().getColumn(6).setResizable(false);

        jTableAgendaMedica.getTableHeader().setReorderingAllowed(false);//reorganizar o cabeçalho
        jTableAgendaMedica.setAutoResizeMode(jTableAgendaMedica.AUTO_RESIZE_OFF); //NÃO VAI PODER REDIMENCIONAR A TABELA
        jTableAgendaMedica.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//selecionar um por vez 
        //total do tamanho dos campos = 38 + 237 + 110 + 65 = 450
        conBd.DesconectarBd();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgendaMedica = new javax.swing.JTable();
        jLabelAgenHj = new javax.swing.JLabel();
        jButtonIniAtender = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxAgendaMedico = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabelAgendaMedico = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableAgendaMedica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableAgendaMedica.setToolTipText("");
        jTableAgendaMedica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendaMedicaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAgendaMedica);

        jLabelAgenHj.setText("Agendamento de pacientes");

        jButtonIniAtender.setText("Atender Paciente");
        jButtonIniAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniAtenderActionPerformed(evt);
            }
        });

        jLabel1.setText("Médico :");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelAgenHj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxAgendaMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(352, 352, 352)
                .addComponent(jButtonIniAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxAgendaMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabelAgenHj))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonIniAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );

        jLabelAgendaMedico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelAgendaMedico.setText("Agenda Médico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(jLabelAgendaMedico)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelAgendaMedico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(996, 461));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAgendaMedicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendaMedicaMouseClicked
        // TODO add your handling code here:
      Agenda = "" + jTableAgendaMedica.getValueAt(jTableAgendaMedica.getSelectedRow(), 0); //pega o primeira coluna da tabela
 
    }//GEN-LAST:event_jTableAgendaMedicaMouseClicked

    private void jButtonIniAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniAtenderActionPerformed
       
        if(Agenda == null){
             JOptionPane.showMessageDialog(null, "Selecione a consulta a ser realizada. ");
        } else {
        FormConsulta consulta = new FormConsulta(Agenda,0);
       consulta.setVisible(true);
        }
    }//GEN-LAST:event_jButtonIniAtenderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jComboBoxAgendaMedico.getSelectedItem() != "Selecione" ){//|| jComboBoxAgendaMedico.getSelectedItem() != "Todos"  ){
        int cod = daoagenda.BuscarCodMedico((String)jComboBoxAgendaMedico.getSelectedItem());
       
        codigo = String.valueOf(cod);
          
        preencherTabelaAgenda(
                "SELECT AGENDAMENTO.IDAGENDAMENTO, AGENDAMENTO.STATUSCONSULTA, PACIENTE.NOMEPACIENTE, " +
                "HORARIO.HORA, AGENDAMENTO.DTAGENDAMENTO, MEDICO.NOMEMEDICO, ESPECIALIDADE.ESPEC FROM AGENDAMENTO " +
                "INNER JOIN PACIENTE ON AGENDAMENTO.IDPACIENTE = PACIENTE.IDPACIENTE " +
                "INNER JOIN MEDICO ON AGENDAMENTO.IDMEDICO = MEDICO.IDMEDICO " +
                "INNER JOIN ESPECIALIDADE ON AGENDAMENTO.IDESPECIALIDADE = ESPECIALIDADE.IDESPECIALIDADE " +
                "INNER JOIN HORARIO ON AGENDAMENTO.IDHORA = HORARIO.IDHORA " + 
                "WHERE AGENDAMENTO.IDMEDICO  = '" + codigo + "'AND AGENDAMENTO.DTAGENDAMENTO  = '" + dtHoje + "' AND " +
                "AGENDAMENTO.STATUSCONSULTA = '" + status + "' ORDER BY PACIENTE.NOMEPACIENTE"); 
//       
////        } else if(jComboBoxAgendaMedico.getSelectedItem() == "Todos" ){
//            preencherTabelaAgenda(
//                "SELECT AGENDAMENTO.IDAGENDAMENTO, AGENDAMENTO.STATUSCONSULTA, PACIENTE.NOMEPACIENTE, " +
//                "HORARIO.HORA, AGENDAMENTO.DTAGENDAMENTO, MEDICO.NOMEMEDICO, ESPECIALIDADE.ESPEC FROM AGENDAMENTO " +
//                "INNER JOIN PACIENTE ON AGENDAMENTO.IDPACIENTE = PACIENTE.IDPACIENTE " +
//                "INNER JOIN MEDICO ON AGENDAMENTO.IDMEDICO = MEDICO.IDMEDICO " +
//                "INNER JOIN ESPECIALIDADE ON AGENDAMENTO.IDESPECIALIDADE = ESPECIALIDADE.IDESPECIALIDADE " +
//                "INNER JOIN HORARIO ON AGENDAMENTO.IDHORA = HORARIO.IDHORA " + 
//                "WHERE AGENDAMENTO.IDMEDICO IS NOT NULL AND AGENDAMENTO.DTAGENDAMENTO  = '" + dtHoje + "' AND " +
//                "AGENDAMENTO.STATUSCONSULTA = '" + status + "' ORDER BY PACIENTE.NOMEPACIENTE");
            
        }else{
            JOptionPane.showMessageDialog(rootPane, "Selecione o nome do médico!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormAgendaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgendaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgendaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgendaMedico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgendaMedico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonIniAtender;
    private javax.swing.JComboBox<String> jComboBoxAgendaMedico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAgenHj;
    private javax.swing.JLabel jLabelAgendaMedico;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgendaMedica;
    // End of variables declaration//GEN-END:variables
}
