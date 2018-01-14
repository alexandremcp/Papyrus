package br.com.papyrus.view;

import br.com.papyrus.controller.ControllerAcervo;
import br.com.papyrus.controller.ControllerAutores;
import br.com.papyrus.controller.ControllerClassificacoes;
import br.com.papyrus.controller.ControllerEditoras;
import br.com.papyrus.controller.ControllerTipos;
import br.com.papyrus.controller.ControllerLeitores;
import br.com.papyrus.controller.ControllerEmprestimos;
import javax.swing.JOptionPane;
import static br.com.papyrus.view.ViewPrincipal.DesktopPrincipal;

/**
 * Classe principal onde é construido o menu do sistema
 *
 * @author Alexandre Luiz dos Santos
 * @version 1.0
 */
public class ViewPrincipal extends javax.swing.JFrame {

    public String mostrarTelaAutores;

    /**
     * Cria o formulário TelaPrincipal com os Menus do sistema
     */
    public ViewPrincipal() {
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

        DesktopPrincipal = new javax.swing.JDesktopPane();
        fundoViewPrincipal = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jmMovimentacao = new javax.swing.JMenu();
        jmEmprestimos = new javax.swing.JMenuItem();
        jmDevolucoes = new javax.swing.JMenuItem();
        jmCadastros = new javax.swing.JMenu();
        jmAcervo = new javax.swing.JMenuItem();
        jmAutores = new javax.swing.JMenuItem();
        jmEditoras = new javax.swing.JMenuItem();
        jmClassificacoes = new javax.swing.JMenuItem();
        jmTiposDeItens = new javax.swing.JMenuItem();
        jmLeitores = new javax.swing.JMenuItem();
        jmRelatorios = new javax.swing.JMenu();
        jmOpcoes = new javax.swing.JMenu();
        jmAjuda = new javax.swing.JMenuItem();
        jmSobre = new javax.swing.JMenuItem();
        jmSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Papyrus v.1.0");
        setResizable(false);

        DesktopPrincipal.setPreferredSize(new java.awt.Dimension(1280, 640));

        fundoViewPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fundoViewPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/papyrus/icones/LogoPapyrus.png"))); // NOI18N

        DesktopPrincipal.setLayer(fundoViewPrincipal, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPrincipalLayout = new javax.swing.GroupLayout(DesktopPrincipal);
        DesktopPrincipal.setLayout(DesktopPrincipalLayout);
        DesktopPrincipalLayout.setHorizontalGroup(
            DesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fundoViewPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 1250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        DesktopPrincipalLayout.setVerticalGroup(
            DesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DesktopPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fundoViewPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                .addContainerGap())
        );

        jmMovimentacao.setText("Movimentação");

        jmEmprestimos.setText("Empréstimos");
        jmEmprestimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEmprestimosActionPerformed(evt);
            }
        });
        jmMovimentacao.add(jmEmprestimos);

        jmDevolucoes.setText("Devoluções");
        jmMovimentacao.add(jmDevolucoes);

        jMenuBar2.add(jmMovimentacao);

        jmCadastros.setText("Cadastros");

        jmAcervo.setText("Acervo");
        jmAcervo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAcervoActionPerformed(evt);
            }
        });
        jmCadastros.add(jmAcervo);

        jmAutores.setText("Autores");
        jmAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAutoresActionPerformed(evt);
            }
        });
        jmCadastros.add(jmAutores);

        jmEditoras.setText("Editoras");
        jmEditoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmEditorasActionPerformed(evt);
            }
        });
        jmCadastros.add(jmEditoras);

        jmClassificacoes.setText("Classificações");
        jmClassificacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmClassificacoesActionPerformed(evt);
            }
        });
        jmCadastros.add(jmClassificacoes);

        jmTiposDeItens.setText("Tipos de Itens");
        jmTiposDeItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmTiposDeItensActionPerformed(evt);
            }
        });
        jmCadastros.add(jmTiposDeItens);

        jmLeitores.setText("Leitores");
        jmLeitores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmLeitoresActionPerformed(evt);
            }
        });
        jmCadastros.add(jmLeitores);

        jMenuBar2.add(jmCadastros);

        jmRelatorios.setText("Relatórios");
        jMenuBar2.add(jmRelatorios);

        jmOpcoes.setText("Opções");

        jmAjuda.setText("Ajuda");
        jmOpcoes.add(jmAjuda);

        jmSobre.setText("Sobre");
        jmSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSobreActionPerformed(evt);
            }
        });
        jmOpcoes.add(jmSobre);

        jmSair.setText("Sair");
        jmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmSairActionPerformed(evt);
            }
        });
        jmOpcoes.add(jmSair);

        jMenuBar2.add(jmOpcoes);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesktopPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSairActionPerformed
        // Exibe janela perguntando se deseja sair do sistema
        int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair ?", "Aviso", JOptionPane.YES_NO_OPTION);
        if (sair == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jmSairActionPerformed

    private void jmSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmSobreActionPerformed
        // Chama a tela "Sobre"
        ViewSobre sobre = new ViewSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_jmSobreActionPerformed

    private void jmAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAutoresActionPerformed
        // Chama a tela "ViewAutores" dentro do Desktop pane
        // a partir do ControllerAutores.java
        ControllerAutores mostrarAutores = new ControllerAutores();
    }//GEN-LAST:event_jmAutoresActionPerformed

    private void jmEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditorasActionPerformed
        // Chama a tela "ViewEditoras" dentro do Desktop pane
        // a partir do ControllerEditoras.java
        ControllerEditoras mostrarEditoras = new ControllerEditoras();
    }//GEN-LAST:event_jmEditorasActionPerformed

    private void jmClassificacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmClassificacoesActionPerformed
        ControllerClassificacoes mostrarClassificacoes = new ControllerClassificacoes();
    }//GEN-LAST:event_jmClassificacoesActionPerformed

    private void jmTiposDeItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmTiposDeItensActionPerformed
        ControllerTipos mostrarTipos = new ControllerTipos();
    }//GEN-LAST:event_jmTiposDeItensActionPerformed

    private void jmAcervoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAcervoActionPerformed
        ControllerAcervo mostrarAcervo = new ControllerAcervo();
    }//GEN-LAST:event_jmAcervoActionPerformed

    private void jmLeitoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmLeitoresActionPerformed
        ControllerLeitores mostrarLeitores = new ControllerLeitores();
    }//GEN-LAST:event_jmLeitoresActionPerformed

    private void jmEmprestimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEmprestimosActionPerformed
        ControllerEmprestimos mostrarEmprestimos = new ControllerEmprestimos();
    }//GEN-LAST:event_jmEmprestimosActionPerformed

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
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane DesktopPrincipal;
    private javax.swing.JLabel fundoViewPrincipal;
    private javax.swing.JMenuBar jMenuBar2;
    public static javax.swing.JMenuItem jmAcervo;
    public static javax.swing.JMenuItem jmAjuda;
    public static javax.swing.JMenuItem jmAutores;
    private javax.swing.JMenu jmCadastros;
    public static javax.swing.JMenuItem jmClassificacoes;
    private javax.swing.JMenuItem jmDevolucoes;
    public static javax.swing.JMenuItem jmEditoras;
    private javax.swing.JMenuItem jmEmprestimos;
    public static javax.swing.JMenuItem jmLeitores;
    private javax.swing.JMenu jmMovimentacao;
    private javax.swing.JMenu jmOpcoes;
    private javax.swing.JMenu jmRelatorios;
    public static javax.swing.JMenuItem jmSair;
    public static javax.swing.JMenuItem jmSobre;
    public static javax.swing.JMenuItem jmTiposDeItens;
    // End of variables declaration//GEN-END:variables
}
