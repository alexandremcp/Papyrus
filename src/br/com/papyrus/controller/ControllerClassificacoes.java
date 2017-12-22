package br.com.papyrus.controller;

import br.com.papyrus.model.ModelClassificacoesDAO;
import br.com.papyrus.model.ModelClassificacoesTableModel;
import br.com.papyrus.model.ModelClassificacoesVO;
import br.com.papyrus.view.ViewClassificacoes;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import static br.com.papyrus.view.ViewPrincipal.DesktopPrincipal;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 * Classe que cria e gerencia o AbstractTableModel para Classificacoes
 *
 * @author Alexandre Luiz dos Santos.
 *
 * varAlterar: Controla se é uma alteração ou uma inclusão no
 * AbstractTableModel, se True é para incluir um novo registro, se False é para
 * alterarClassificacoes um registro existente.
 *
 * telaClassificacoes: Recebe as informações da ViewClassificacoes.java que é a
 * tela com os dados do Autor.
 */
public final class ControllerClassificacoes {

    public ViewClassificacoes telaClassificacoes;
    private ModelClassificacoesTableModel tbModel;
    private boolean varAlterar = false;

    public ControllerClassificacoes() {

        telaClassificacoes = new ViewClassificacoes();
        DesktopPrincipal.add(telaClassificacoes);
        telaClassificacoes.show();

        carregarClassificacoes();

        telaClassificacoes.getBtnSalvar().addActionListener((ActionEvent ae) -> {
            salvarClassificacoes();
        });

        telaClassificacoes.getBtnExcluir().addActionListener((ActionEvent ae) -> {
            excluirClassificacoes();
        });

        telaClassificacoes.getBtnAlterar().addActionListener((ActionEvent ae) -> {
            alterarClassificacoes();
        });
    }

    public ControllerClassificacoes(JDesktopPane DesktopPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que salva os dados no AbstractTableModel para Classificacoes,
     * utiliza a variável varAlterar que se for True indica que é para gravar um
     * novo registro na tabela Classificacoes através do AbstractTableModel.
     */
    public void salvarClassificacoes() {

        if (!varAlterar) {
            if (telaClassificacoes.getTxtNome().getText().equals("")) { //Objeto novo
                JOptionPane.showMessageDialog(null, "Por favor preencha os dados !");
            } else {
                ModelClassificacoesVO classificacao = new ModelClassificacoesVO();
                classificacao.setNome(telaClassificacoes.getTxtNome().getText());
                ModelClassificacoesDAO classificacoesDAO = new ModelClassificacoesDAO();

                if (classificacoesDAO.inserirClassificacoes(classificacao)) {
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
                    carregarClassificacoes();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar gravar !");
                }
            }
        }

        if (varAlterar) {
            ModelClassificacoesVO classificacao = new ModelClassificacoesVO();
            classificacao.setNome(telaClassificacoes.getTxtNome().getText());
            ModelClassificacoesDAO classificacoesDAO = new ModelClassificacoesDAO();

            classificacao.setId(Integer.valueOf(telaClassificacoes.getTxtId().getText()));
            if (classificacoesDAO.alterarClassificacoes(classificacao)) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso !");
                carregarClassificacoes();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar !");
            }
            varAlterar = false;
        }
        limparVariaveis(telaClassificacoes);
    }

    /**
     * Método que carrega os dados dos autores no AbstractTableModel para
     * Classificacoes
     */
    public void carregarClassificacoes() {
        ModelClassificacoesDAO classificacoesDAO = new ModelClassificacoesDAO();
        tbModel = new ModelClassificacoesTableModel(classificacoesDAO.listarClassificacoes());
        telaClassificacoes.setTbClassificacoes(tbModel);
    }

    /**
     * Método que exclui um classificacao da tabela do AbstractTableModel para
     * Classificacoes
     */
    public void excluirClassificacoes() {
        if (telaClassificacoes.getTbClassificacoes().getSelectedRow() >= 0) {  //Só exclui se tiver uma linha selecionada
            ModelClassificacoesDAO classificacoesDAO = new ModelClassificacoesDAO();
            ModelClassificacoesVO classificacao = tbModel.getClassificacoes(telaClassificacoes.getTbClassificacoes().getSelectedRow());
            classificacoesDAO.excluirClassificacoes(classificacao);
            carregarClassificacoes();
        }
    }

    /**
     * Método que altera os dados de um classificacao na tabela do
     * AbstractTableModel para Classificacoes
     */
    public void alterarClassificacoes() {
        if (telaClassificacoes.getTbClassificacoes().getSelectedRow() >= 0) {  //Só altera se tiver uma linha selecionada
            ModelClassificacoesDAO classificacoesDAO = new ModelClassificacoesDAO();
            ModelClassificacoesVO classificacao = tbModel.getClassificacoes(telaClassificacoes.getTbClassificacoes().getSelectedRow());
            telaClassificacoes.getTxtId().setText(String.valueOf(classificacao.getId()));
            telaClassificacoes.getTxtNome().setText(classificacao.getNome());
            varAlterar = true;
        }
    }

    /**
     * Método que limpa as variaveis e campos na tela do formulário passado como
     * parametro ViewClassificacoes.java
     *
     * @param obj O JInternalFrame (tela) com seus campos a ser limpo por esta
     * classe.
     */
    public void limparVariaveis(Object obj) {

        JInternalFrame tela = (JInternalFrame) (Object) obj;

        for (int i = 0; i < tela.getContentPane().getComponentCount(); i++) {
            //varre todos os componentes
            Component c = tela.getContentPane().getComponent(i);
            if (c instanceof JTextField) {
                //apaga os valores
                JTextField field = (JTextField) c;
                field.setText("");
            }
        }
    }

}
