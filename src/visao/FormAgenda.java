package visao;

import ModeloBeans.BeansAgendamento;
import ModeloBeans.ModeloTabela;
import ModeloConection.ConexaoBd;
import ModeloDao.DaoAgendamento;
import java.sql.SQLException;
//import java.text.DateFormat;
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
public class FormAgenda extends javax.swing.JFrame {

    ConexaoBd conBd = new ConexaoBd();
    BeansAgendamento agenda = new BeansAgendamento();
    BeansAgendamento agen = new BeansAgendamento();
    DaoAgendamento daoagenda = new DaoAgendamento();
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

    String dtHoje;
    String status;

    public void DataHoje() {
        Calendar data = Calendar.getInstance();
        Date d = data.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
     
        dateFormat.format(d);
        dtHoje = dateFormat.format(d);
        status = "Aberto";

    }

    public FormAgenda() {
        initComponents();

        DataHoje();

    }

    public final void preencherTabelaAgenda(String sql) {

        ArrayList dados = new ArrayList();
        String[] colunas = new String[]{"ID", "STATUS", "NOME PACIENTE", "TURNO", "DATA", "NOME MEDICO", "ESPECIALIDADE","RETORNO"};
        String retorno;
        
        conBd.conectarBd();

        conBd.executaSql(sql);

        try {
            conBd.rs.first();

            do {
                if(conBd.rs.getBoolean("RETORNO") == true){
                    retorno = "       Sim";
                }else {
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
        jTableAgenda.setModel(modelo);

        jTableAgenda.getColumnModel().getColumn(0).setPreferredWidth(38);//Tamanho da tabela
        jTableAgenda.getColumnModel().getColumn(0).setResizable(false);

        jTableAgenda.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTableAgenda.getColumnModel().getColumn(1).setResizable(false);

        jTableAgenda.getColumnModel().getColumn(2).setPreferredWidth(237);
        jTableAgenda.getColumnModel().getColumn(2).setResizable(false);

        jTableAgenda.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTableAgenda.getColumnModel().getColumn(3).setResizable(false);

        jTableAgenda.getColumnModel().getColumn(4).setPreferredWidth(80);
        jTableAgenda.getColumnModel().getColumn(4).setResizable(false);

        jTableAgenda.getColumnModel().getColumn(5).setPreferredWidth(237);
        jTableAgenda.getColumnModel().getColumn(5).setResizable(false);

        jTableAgenda.getColumnModel().getColumn(6).setPreferredWidth(124);
        jTableAgenda.getColumnModel().getColumn(6).setResizable(false);
     
        jTableAgenda.getColumnModel().getColumn(7).setPreferredWidth(80);
        jTableAgenda.getColumnModel().getColumn(7).setResizable(false);
        
        jTableAgenda.getTableHeader().setReorderingAllowed(false);//reorganizar o cabeçalho
        jTableAgenda.setAutoResizeMode(jTableAgenda.AUTO_RESIZE_OFF); //NÃO VAI PODER REDIMENCIONAR A TABELA
        jTableAgenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//selecionar um por vez 
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
        jTableAgenda = new javax.swing.JTable();
        jLabelAgenHj = new javax.swing.JLabel();
        jButtonIniConusulta = new javax.swing.JButton();
        jButtonBuscarAgendamento = new javax.swing.JButton();
        jButtonHoje = new javax.swing.JButton();
        jDateChooserAgenda = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jTableAgenda.setBorder(new javax.swing.border.MatteBorder(null));
        jTableAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableAgenda.setToolTipText("");
        jTableAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableAgenda);

        jLabelAgenHj.setText("Agendamento do dia");

        jButtonIniConusulta.setText("Iniciar Consulta");
        jButtonIniConusulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniConusultaActionPerformed(evt);
            }
        });

        jButtonBuscarAgendamento.setText("Buscar");
        jButtonBuscarAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarAgendamentoActionPerformed(evt);
            }
        });

        jButtonHoje.setText("Hoje");
        jButtonHoje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHojeActionPerformed(evt);
            }
        });

        jDateChooserAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooserAgendaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabelAgenHj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooserAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscarAgendamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonHoje)
                        .addGap(0, 346, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonIniConusulta, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(344, 344, 344))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAgenHj, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonBuscarAgendamento)
                        .addComponent(jButtonHoje))
                    .addComponent(jDateChooserAgenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonIniConusulta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Agenda");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(427, 427, 427)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(980, 560));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAgendaMouseClicked
        // TODO add your handling code here:
        String Agenda = "" + jTableAgenda.getValueAt(jTableAgenda.getSelectedRow(), 0); //pega o primeira coluna da tabela
        conBd.conectarBd();

        String sql = "select STATUSCONSULTA,IDPACIENTE, IDMEDICO, IDESPECIALIDADE, TURNO,DTAGENDAMENTO,IDAGENDAMENTO from agendamento where IDAGENDAMENTO = '" + Agenda + "'";
        conBd.executaSql(sql);

        try {
            conBd.rs.first();
            agen.setStatus("Em Atendimento");
            agen.setAIdPaciente(conBd.rs.getInt("IDPACIENTE"));
            agen.setAIdMedico(conBd.rs.getInt("IDMEDICO"));
            agen.setAEspecialidade(conBd.rs.getInt("IDESPECIALIDADE"));
            agen.setTurno(conBd.rs.getString("TURNO"));
            agen.setData(conBd.rs.getDate("DTAGENDAMENTO"));
            agen.setAgendaCod(conBd.rs.getInt("IDAGENDAMENTO"));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao selecionar os dados" + ex.getMessage());
        }
    }//GEN-LAST:event_jTableAgendaMouseClicked

    private void jButtonIniConusultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniConusultaActionPerformed
        // TODO add your handling code here:
        daoagenda.Alterar(agen);
        preencherTabelaAgenda("SELECT AGENDAMENTO.IDAGENDAMENTO, AGENDAMENTO.STATUSCONSULTA, PACIENTE.NOMEPACIENTE,"
                + " AGENDAMENTO.TURNO, AGENDAMENTO.DTAGENDAMENTO, MEDICO.NOMEMEDICO, ESPECIALIDADE.ESPEC,AGENDAMENTO.RETORNO"
                + " FROM AGENDAMENTO"
                + " INNER JOIN PACIENTE ON AGENDAMENTO.IDPACIENTE = PACIENTE.IDPACIENTE"
                + " INNER JOIN MEDICO ON AGENDAMENTO.IDMEDICO = MEDICO.IDMEDICO"
                + " INNER JOIN ESPECIALIDADE ON AGENDAMENTO.IDESPECIALIDADE = ESPECIALIDADE.IDESPECIALIDADE"
                + " WHERE DTAGENDAMENTO ='" + dtHoje + "' AND STATUSCONSULTA = '" + status + "' ORDER BY TURNO");
    }//GEN-LAST:event_jButtonIniConusultaActionPerformed

    private void jButtonBuscarAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarAgendamentoActionPerformed
        // TODO add your handling code here:

        preencherTabelaAgenda("SELECT AGENDAMENTO.IDAGENDAMENTO, AGENDAMENTO.STATUSCONSULTA, PACIENTE.NOMEPACIENTE,"
                + " AGENDAMENTO.TURNO, AGENDAMENTO.DTAGENDAMENTO, MEDICO.NOMEMEDICO, ESPECIALIDADE.ESPEC, AGENDAMENTO.RETORNO"
                + " FROM AGENDAMENTO"
                + " INNER JOIN PACIENTE ON AGENDAMENTO.IDPACIENTE = PACIENTE.IDPACIENTE"
                + " INNER JOIN MEDICO ON AGENDAMENTO.IDMEDICO = MEDICO.IDMEDICO"
                + " INNER JOIN ESPECIALIDADE ON AGENDAMENTO.IDESPECIALIDADE = ESPECIALIDADE.IDESPECIALIDADE"
                + " WHERE DTAGENDAMENTO ='" + date.format(jDateChooserAgenda.getDate()) + "' AND STATUSCONSULTA = '" + status + "' ORDER BY TURNO");
        if (jDateChooserAgenda.getDate().equals(dtHoje)) {
            jButtonIniConusulta.setVisible(true);
        } else {
            jButtonIniConusulta.setVisible(false);
            jDateChooserAgenda.setDate(null);
        }
    }//GEN-LAST:event_jButtonBuscarAgendamentoActionPerformed

    private void jButtonHojeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHojeActionPerformed
        // TODO add your handling code here:
        preencherTabelaAgenda("SELECT AGENDAMENTO.IDAGENDAMENTO, AGENDAMENTO.STATUSCONSULTA, PACIENTE.NOMEPACIENTE,"
                + " AGENDAMENTO.TURNO, AGENDAMENTO.DTAGENDAMENTO, MEDICO.NOMEMEDICO, ESPECIALIDADE.ESPEC, AGENDAMENTO.RETORNO"
                + " FROM AGENDAMENTO"
                + " INNER JOIN PACIENTE ON AGENDAMENTO.IDPACIENTE = PACIENTE.IDPACIENTE"
                + " INNER JOIN MEDICO ON AGENDAMENTO.IDMEDICO = MEDICO.IDMEDICO"
                + " INNER JOIN ESPECIALIDADE ON AGENDAMENTO.IDESPECIALIDADE = ESPECIALIDADE.IDESPECIALIDADE"
                + " WHERE DTAGENDAMENTO ='" + dtHoje + "' AND STATUSCONSULTA = '" + status + "' ORDER BY TURNO");
        jButtonIniConusulta.setVisible(true);
        jDateChooserAgenda.setDate(null);

    }//GEN-LAST:event_jButtonHojeActionPerformed

    private void jDateChooserAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooserAgendaMouseClicked
        // TODO add your handling code here:

        //	System.out.println(texto.toLowerCase().contains(procurarPor.toLowerCase()));
    }//GEN-LAST:event_jDateChooserAgendaMouseClicked

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
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscarAgendamento;
    private javax.swing.JButton jButtonHoje;
    private javax.swing.JButton jButtonIniConusulta;
    private com.toedter.calendar.JDateChooser jDateChooserAgenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAgenHj;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAgenda;
    // End of variables declaration//GEN-END:variables
}
