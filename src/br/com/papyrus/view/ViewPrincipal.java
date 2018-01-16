package br.com.papyrus.view;

import br.com.papyrus.controller.ControllerAcervo;
import br.com.papyrus.controller.ControllerAutores;
import br.com.papyrus.controller.ControllerClassificacoes;
import br.com.papyrus.controller.ControllerEditoras;
import br.com.papyrus.controller.ControllerDevolucoes;
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jmOpcoes = new javax.swing.JMenu();
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
                .addComponent(fundoViewPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1260, Short.MAX_VALUE)
                .addContainerGap())
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
        jmDevolucoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmDevolucoesActionPerformed(evt);
            }
        });
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

        jmRelatorios.setText("Consultas");

        jMenuItem1.setText("Coltulta Acervo Agrupada por Autor");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmRelatorios.add(jMenuItem1);

        jMenuItem2.setText("Coltulta Acervo Agrupada por Editora");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmRelatorios.add(jMenuItem2);

        jMenuItem3.setText("Coltulta Acervo Agrupada por Classificação");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmRelatorios.add(jMenuItem3);

        jMenuItem4.setText("Coltulta Acervo Agrupada por Tipo");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmRelatorios.add(jMenuItem4);
        jmRelatorios.add(jSeparator1);

        jMenuItem5.setText("Consulta Geral");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jmRelatorios.add(jMenuItem5);
        jmRelatorios.add(jSeparator2);

        jMenuItem6.setText("Contulta por Emprestimos e Devoluções");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jmRelatorios.add(jMenuItem6);

        jMenuBar2.add(jmRelatorios);

        jmOpcoes.setText("Opções");

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
        ViewSobre sobre = new ViewSobre();
        sobre.setVisible(true);
    }//GEN-LAST:event_jmSobreActionPerformed

    private void jmAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAutoresActionPerformed
        ControllerAutores mostrarAutores = new ControllerAutores();
    }//GEN-LAST:event_jmAutoresActionPerformed

    private void jmEditorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmEditorasActionPerformed
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

    private void jmDevolucoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmDevolucoesActionPerformed
        ControllerDevolucoes mostrarDevolucoes = new ControllerDevolucoes();
    }//GEN-LAST:event_jmDevolucoesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ColtultaAcervoAgrupadaPorAutor telaContulta = new ColtultaAcervoAgrupadaPorAutor();
        DesktopPrincipal.add(telaContulta);
        telaContulta.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        ColtultaAcervoAgrupadaPorEditora telaContulta = new ColtultaAcervoAgrupadaPorEditora();
        DesktopPrincipal.add(telaContulta);
        telaContulta.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ColtultaAcervoAgrupadaPorClassificacao telaContulta = new ColtultaAcervoAgrupadaPorClassificacao();
        DesktopPrincipal.add(telaContulta);
        telaContulta.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ColtultaAcervoAgrupadaPorTipo telaContulta = new ColtultaAcervoAgrupadaPorTipo();
        DesktopPrincipal.add(telaContulta);
        telaContulta.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        ColtultaGeral telaContulta = new ColtultaGeral();
        DesktopPrincipal.add(telaContulta);
        telaContulta.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ColtultaEmprestimosEDevolucoes telaContulta = new ColtultaEmprestimosEDevolucoes();
        DesktopPrincipal.add(telaContulta);
        telaContulta.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    public static javax.swing.JMenuItem jmAcervo;
    public static javax.swing.JMenuItem jmAutores;
    private javax.swing.JMenu jmCadastros;
    public static javax.swing.JMenuItem jmClassificacoes;
    public static javax.swing.JMenuItem jmDevolucoes;
    public static javax.swing.JMenuItem jmEditoras;
    public static javax.swing.JMenuItem jmEmprestimos;
    public static javax.swing.JMenuItem jmLeitores;
    private javax.swing.JMenu jmMovimentacao;
    private javax.swing.JMenu jmOpcoes;
    private javax.swing.JMenu jmRelatorios;
    public static javax.swing.JMenuItem jmSair;
    public static javax.swing.JMenuItem jmSobre;
    public static javax.swing.JMenuItem jmTiposDeItens;
    // End of variables declaration//GEN-END:variables
}
