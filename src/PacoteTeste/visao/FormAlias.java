/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteTeste.visao;

import ModeloConection.ConexaoBd;
import java.io.File;
import ModeloDao.DaoAlias;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Lucas
 */
public class FormAlias extends javax.swing.JFrame {

    private static File arquivo;
    String Url;
    DaoAlias DaoAlias = new DaoAlias();
    //ModeloAlias DaoAlias;

    /**
     * Creates new form FormBancoDados
     */
    public FormAlias() {
        initComponents();
        DaoAlias.CriaAlias();
        percorrerAlias();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelServidor = new javax.swing.JLabel();
        jLabelBd = new javax.swing.JLabel();
        jLabelAlias = new javax.swing.JLabel();
        jTextFieldAlias = new javax.swing.JTextField();
        jTextFieldServidor = new javax.swing.JTextField();
        jTextFieldDataBaseName = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jlistAlias = new java.awt.List();
        jButtonTestarConexao = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonSair = new javax.swing.JButton();
        jLabelPorta = new javax.swing.JLabel();
        jTextFieldPorta = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Alias");
        setResizable(false);

        jLabelServidor.setText("Servidor: ");

        jLabelBd.setText("Banco de Dados: ");

        jLabelAlias.setText("Alias: ");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSalvarMouseClicked(evt);
            }
        });
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jlistAlias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlistAlias.setName(""); // NOI18N
        jlistAlias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistAliasMouseClicked(evt);
            }
        });

        jButtonTestarConexao.setText("Testar Conexão");
        jButtonTestarConexao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonTestarConexaoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonTestarConexaoMouseEntered(evt);
            }
        });
        jButtonTestarConexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTestarConexaoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setText("Gerenciamento de alias");

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelPorta.setText("Porta:");

        jButtonNovo.setText("Novo");
        jButtonNovo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonNovoMouseClicked(evt);
            }
        });
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jButtonNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jlistAlias, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelAlias)
                            .addComponent(jLabelServidor)
                            .addComponent(jLabelBd)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPorta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldServidor)
                            .addComponent(jTextFieldAlias)
                            .addComponent(jTextFieldDataBaseName)
                            .addComponent(jButtonTestarConexao, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAlias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelServidor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelBd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDataBaseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPorta)
                            .addComponent(jTextFieldPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonTestarConexao))
                    .addComponent(jlistAlias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonSalvar)
                    .addComponent(jButtonNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSair)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(355, 395));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTestarConexaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTestarConexaoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonTestarConexaoActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:

        DaoAlias.CriaAlias();
        jlistAlias.removeAll();
        DaoAlias.salvar(jTextFieldAlias.getText(), jTextFieldServidor.getText(), jTextFieldDataBaseName.getText(),
                jTextFieldPorta.getText());
        
        percorrerAlias();
        limparCampos();
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonNovoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonNovoMouseClicked
        // TODO add your handling code here:

        limparCampos();
    }//GEN-LAST:event_jButtonNovoMouseClicked

    private void jButtonSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jButtonSalvarMouseClicked

    private void jButtonTestarConexaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTestarConexaoMouseClicked
     
        Url = "jdbc:sqlserver://" + jTextFieldServidor.getText() + ":"+jTextFieldPorta.getText()+";databaseName="
                + jTextFieldDataBaseName.getText();
        ConexaoBd conexaoBD = new ConexaoBd();
       /// conexaoBD.conectarBd(Url, 1);
    }//GEN-LAST:event_jButtonTestarConexaoMouseClicked

    private void jButtonTestarConexaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonTestarConexaoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonTestarConexaoMouseEntered

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
//        ModeloAlias DaoAlias = new ModeloAlias();
//        DaoAlias.percorrerAlias();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jlistAliasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistAliasMouseClicked

        BufferedReader arquivo = null;
        limparCampos();

        try {
            String Nome = String.valueOf(jlistAlias.getSelectedItem());

            System.out.println("Nome: " + Nome);

            DaoAlias txt = new DaoAlias();
            arquivo = new BufferedReader(new FileReader(txt.file));

            try {
                while (arquivo.ready()) {
                    String linha = arquivo.readLine();

                    if (linha.toLowerCase().contains(Nome.toLowerCase())) {
                        //                   if( linha.toLowerCase().contentEquals(Nome.toLowerCase())){
                        // contains(Nome.toLowerCase()
                        // pega a linha
                        String[] valoresEntreVirgulas = linha.split(";");

                        jTextFieldAlias.setText(valoresEntreVirgulas[0]);
                        jTextFieldServidor.setText(valoresEntreVirgulas[1]);
                        jTextFieldDataBaseName.setText(valoresEntreVirgulas[2]);
                        jTextFieldPorta.setText(valoresEntreVirgulas[3]);

                    }

                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro na leitura do arquivo: " + ex.getMessage());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormAlias.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arquivo.close();
            } catch (IOException ex) {
                Logger.getLogger(FormAlias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jlistAliasMouseClicked

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExcluirActionPerformed
    public void limparCampos() {
        jTextFieldAlias.setText(" ");
        jTextFieldDataBaseName.setText(" ");
        jTextFieldServidor.setText(" ");
        jTextFieldPorta.setText(" ");
    }

    public void percorrerAlias() {
        DaoAlias txt = new DaoAlias();
        try {
            //cria um scanner para ler o arquivo
            Scanner leitor = new Scanner(txt.file);
            //variavel que armazenara as linhas do arquivo
            String linhasDoArquivo = new String();
            //percorre todo o arquivo
            while (leitor.hasNext()) {
                //recebe cada linha do arquivo
                linhasDoArquivo = leitor.nextLine();
                //separa os campos entre as virgulas de cada linha
                String[] valoresEntreVirgulas = linhasDoArquivo.split(";");
                //imprime a coluna que quiser
                jlistAlias.add(valoresEntreVirgulas[0]);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showConfirmDialog(rootPane, "Erro ao carregar os dados: ccccc " + e);
        }
    }
//https://commons.apache.org/proper/commons-io/javadocs/api-2.5/org/apache/commons/io/FilenameUtils.html#method_detail
    //http://www.guj.com.br/t/como-ler-apenas-a-linha-20-de-um-txt/136542/5

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
            java.util.logging.Logger.getLogger(FormAlias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAlias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAlias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAlias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAlias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonTestarConexao;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelAlias;
    private javax.swing.JLabel jLabelBd;
    private javax.swing.JLabel jLabelPorta;
    private javax.swing.JLabel jLabelServidor;
    private javax.swing.JTextField jTextFieldAlias;
    private javax.swing.JTextField jTextFieldDataBaseName;
    private javax.swing.JTextField jTextFieldPorta;
    private javax.swing.JTextField jTextFieldServidor;
    private java.awt.List jlistAlias;
    // End of variables declaration//GEN-END:variables
}
/**
 * BufferedReader arquivo = new BufferedReader(new
 * FileReader("caminho_do_arquivo")); while(arquivo.ready()) { * // pega a linha
 * String linha = arquivo.readLine();
 * System.out.println(linha.substring(linha.indexOf("<xMotivo>") +
 * "<xMotivo>".length(), linha.indexOf("</xMotivo>"))); * }
 * http://www.javac.com.br/jc/posts/list/215-pegar-informacao-de-um-arquivo-txt-resolvido.page
 *
 */
