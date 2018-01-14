package br.com.papyrus.controller;

import br.com.papyrus.model.CriarConexao;
import br.com.papyrus.view.ViewEmprestimos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Luiz dos Santos
 */
public class ControllerEmprestimosComboBoxAcervo extends javax.swing.JFrame {

    public static String s = "SELECT ace.Id, ace.Titulo AS TituloAcervo FROM acervo ace WHERE ace.Disponivel='sim'";

    /**
     * Cria um novo formulário a partir de ControllerEmprestimosComboBoxAcervo
     */
    public ControllerEmprestimosComboBoxAcervo() {
        initComponents();
        CarregarComboBox();
    }

    public void CarregarComboBox() {
        CriarConexao cc = new CriarConexao();
        HashMap<String, Integer> mapEmprestimos = cc.CarregarComboBox(s);
        if (mapEmprestimos.keySet().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existem itens disponíveis para empréstimo !");
        }
        mapEmprestimos.keySet().forEach((s) -> {
            cmbEmprestimosAcervo.addItem(s);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbEmprestimosAcervo = new javax.swing.JComboBox<>();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Escolha o item do acervo");
        setAlwaysOnTop(true);
        setName("Idioma"); // NOI18N

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEmprestimosAcervo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cmbEmprestimosAcervo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Classificação");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        CriarConexao cc = new CriarConexao();
        HashMap<String, Integer> mapEmprestimos = cc.CarregarComboBox(s);
        if (!mapEmprestimos.keySet().isEmpty()) {
            try {
                ViewEmprestimos.txtAcervo_Id.setText(mapEmprestimos.get(cmbEmprestimosAcervo.getSelectedItem().toString()).toString());
                ViewEmprestimos.txtTituloAcervo.setText(cmbEmprestimosAcervo.getItemAt(cmbEmprestimosAcervo.getSelectedIndex()));
                setarInformacoesSobreOAcervo();
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Item já foi selecionado, por favor escolha outro !");
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ControllerEmprestimosComboBoxAcervo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ControllerEmprestimosComboBoxAcervo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    public static javax.swing.JComboBox<String> cmbEmprestimosAcervo;
    // End of variables declaration//GEN-END:variables

    private void setarInformacoesSobreOAcervo() {
        if (!ViewEmprestimos.txtAcervo_Id.getText().isEmpty()) {

            LocalDate dataEmprestimo = LocalDate.now();
            LocalDate dataDevolucao = LocalDate.now();
            DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            try {
                int numeroAcervo = Integer.parseInt(ViewEmprestimos.txtAcervo_Id.getText());
                Connection conn = CriarConexao.abrirConexao();
                String SQL = "SELECT tip.Id, tip.Dias AS DiasDeEmprestimo, "
                        + "ace.Id, ace.Tipos_Id, ace.SubTitulo, ace.Exemplar, "
                        + "ace.Edicao, ace.Volume, ace.Disponivel, ace.Local "
                        + "FROM tipos tip "
                        + "JOIN acervo ace ON ace.Tipos_Id = tip.Id "
                        + "WHERE ace.Id = '" + numeroAcervo + "'";
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(SQL);

                if (rs.next()) {
                    int dias = rs.getInt("DiasDeEmprestimo");
                    dataDevolucao = dataEmprestimo.plusDays(dias);

                    ViewEmprestimos.txtEmprestimo.setText(dataEmprestimo.format(formatoBR));
                    ViewEmprestimos.txtDevolucao.setText(dataDevolucao.format(formatoBR));
                    ViewEmprestimos.txtSubTituloAcervo.setText(rs.getString("SubTitulo"));
                    ViewEmprestimos.txtExemplarAcervo.setText(rs.getString("Exemplar"));
                    ViewEmprestimos.txtEdicaoAcervo.setText(rs.getString("Edicao"));
                    ViewEmprestimos.txtVolumeAcervo.setText(rs.getString("Volume"));
                    ViewEmprestimos.txtDisponivelAcervo.setText(rs.getString("Disponivel"));
                    ViewEmprestimos.txtLocalAcervo.setText(rs.getString("Local"));
                } else {
                    JOptionPane.showMessageDialog(null, "Primeiro selecione um item do acervo");
                }
            } catch (ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Primeiro selecione um item do acervo");
        }
    }
}