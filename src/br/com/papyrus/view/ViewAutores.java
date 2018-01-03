package br.com.papyrus.view;

import br.com.papyrus.controller.StringLimitada;
import br.com.papyrus.model.CriarConexao;
import br.com.papyrus.model.ModelAutoresDAO;
import br.com.papyrus.model.ModelAutoresVO;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria e gerencia a tela para Autores.
 *
 * @author Alexandre Luiz dos Santos
 */
public class ViewAutores extends javax.swing.JInternalFrame {

    /**
     * Creates new form ViewAutores
     */
    public ViewAutores() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bntAlterar = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        bntExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAutores = new javax.swing.JTable();
        btnFechar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Autores");

        bntAlterar.setText("Alterar");
        bntAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAlterarActionPerformed(evt);
            }
        });

        lblId.setText("Código");

        txtId.setEditable(false);
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lblNome.setText("Nome");

        txtNome.setDocument(new StringLimitada(45));
        txtNome.setToolTipText("Nome do autor da obra");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        bntExcluir.setText("Excluir");
        bntExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntExcluirActionPerformed(evt);
            }
        });

        tbAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbAutores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAutoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbAutores);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnSalvar)
                            .addGap(18, 18, 18)
                            .addComponent(bntAlterar)
                            .addGap(20, 20, 20)
                            .addComponent(bntExcluir)
                            .addGap(18, 18, 18)
                            .addComponent(btnFechar)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(bntExcluir)
                    .addComponent(bntAlterar)
                    .addComponent(btnFechar))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAlterarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntAlterarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        // Exibe janela perguntando se deseja sair da tela autores
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar o formulário ?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnFecharActionPerformed

    private void bntExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntExcluirActionPerformed

    private void tbAutoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAutoresMouseClicked

    }//GEN-LAST:event_tbAutoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAlterar;
    private javax.swing.JButton bntExcluir;
    private javax.swing.JButton btnFechar;
    public javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tbAutores;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables

////////////////////////////////  ATENÇÃO  ////////////////////////////////
    //GET para os campo e botões do formulário para uso do ControllerAutores
    ////////////////////////////////  ATENÇÃO  ////////////////////////////////
     public JButton getBtnSalvar() {  //Método criado na mão para ser usando por 
        return btnSalvar;
    }

    public JButton getBtnExcluir() {  //Método criado na mão para ser usando por ControllerAutores
        return bntExcluir;
    }

    public JButton getBtnAlterar() {  //Método criado na mão para ser usando por ControllerAutores
        return bntAlterar;
    }

    public JTextField getTxtId() { //Método criado na mão para ser usando por ControllerAutores
        return txtId;
    }

    public JTextField getTxtNome() {  //Método criado na mão para ser usando por ControllerAutores
        return txtNome;
    }

    public JTable getTbAutores() {
        return tbAutores;
    }

    /**
     * Método que linka o AbstractTableModel a tabela no formulário setTbAutores
     *
     * @param modelo vindo de ControllerAutores.carregar() com a lista do
     * TableModel
     */
    public void setTbAutores(AbstractTableModel modelo) {
        this.tbAutores.setModel(modelo);
        this.tbAutores.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        this.tbAutores.setSelectionBackground(Color.cyan);  //Põe cor azul na linha atual
        this.tbAutores.setSelectionForeground(Color.red);   //Põe letras em vermelho
        this.tbAutores.setBackground(Color.lightGray);      //põe cor de fundo azul
        this.tbAutores.getColumnModel().getColumn(0).setPreferredWidth(70); //Largura da coluna
        this.tbAutores.getColumnModel().getColumn(0).setResizable(true);    //Coluna redimenciosavel
        this.tbAutores.getColumnModel().getColumn(1).setPreferredWidth(500);
        this.tbAutores.getColumnModel().getColumn(1).setResizable(true);
    }

}
