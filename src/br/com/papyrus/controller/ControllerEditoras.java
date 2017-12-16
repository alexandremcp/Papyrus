package br.com.papyrus.controller;

import br.com.papyrus.model.ModelEditorasDAO;
import br.com.papyrus.model.ModelEditorasTableModel;
import br.com.papyrus.model.ModelEditorasVO;
import br.com.papyrus.view.ViewEditoras;
import static br.com.papyrus.view.ViewPrincipal.DesktopPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 * Classe que cria e gerencia o AbstractTableModel para Editoras
 *
 * @author Alexandre Luiz dos Santos.
 *
 * varAlterar: Controla se é uma alteração ou uma inclusão no
 * AbstractTableModel, se True é para incluir um novo registro, se False é para
 * alterar Editoras um registro existente.
 *
 * telaEditoras: Recebe as informações da ViewEditoras.java que é a tela com os
 * dados da Editora.
 */
public final class ControllerEditoras {

    public ViewEditoras telaEditoras;
    private ModelEditorasTableModel tbModel;
    private boolean varAlterar = false;

    public ControllerEditoras() {

        telaEditoras = new ViewEditoras();
        DesktopPrincipal.add(telaEditoras);
        telaEditoras.show();

        carregarEditoras();

        telaEditoras.getBtnSalvar().addActionListener((ActionEvent ae) -> {
            salvarEditoras();
        });

        telaEditoras.getBtnExcluir().addActionListener((ActionEvent ae) -> {
            excluirEditoras();
        });

        telaEditoras.getBtnAlterar().addActionListener((ActionEvent ae) -> {
            alterarEditoras();
        });

    }

    public ControllerEditoras(JDesktopPane DesktopPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que salva os dados no AbstractTableModel para Editoras, utiliza a
     * variável varAlterar que se for True indica que é para gravar um novo
     * registro na tabela Editoras através do AbstractTableModel.
     */
    public void salvarEditoras() {

        if (!varAlterar) {
            if (telaEditoras.getTxtNome().getText().equals("")) { //Objeto novo
                JOptionPane.showMessageDialog(null, "Por favor preencha os dados !");
            } else {
                ModelEditorasVO editora = new ModelEditorasVO();
                editora.setNome(telaEditoras.getTxtNome().getText());
                editora.setLocalizacao(telaEditoras.getTxtLocalizacao().getText());
                ModelEditorasDAO editorasDAO = new ModelEditorasDAO();

                if (editorasDAO.inserirEditoras(editora)) {
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
                    carregarEditoras();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar gravar !");
                }
            }
        }

        if (varAlterar) {
            ModelEditorasVO editora = new ModelEditorasVO();
            editora.setNome(telaEditoras.getTxtNome().getText());
            editora.setLocalizacao(telaEditoras.getTxtLocalizacao().getText());
            ModelEditorasDAO editorasDAO = new ModelEditorasDAO();

            editora.setId(Integer.valueOf(telaEditoras.getTxtId().getText()));
            if (editorasDAO.alterarEditoras(editora)) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso !");
                carregarEditoras();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar !");
            }
            varAlterar = false;
        }
        limparVariaveisEditoras();
    }

    /**
     * Método que carrega os dados das editoras no AbstractTableModel para
     * Editoras
     */
    public void carregarEditoras() {
        ModelEditorasDAO editorasDAO = new ModelEditorasDAO();
        tbModel = new ModelEditorasTableModel(editorasDAO.listarEditoras());
        telaEditoras.setTbEditoras(tbModel);
    }

    /**
     * Método que exclui um editora da tabela do AbstractTableModel para
     * Editoras
     */
    public void excluirEditoras() {
        if (telaEditoras.getTbEditoras().getSelectedRow() >= 0) {  //Só exclui se tiver uma linha selecionada
            ModelEditorasDAO editorasDAO = new ModelEditorasDAO();
            ModelEditorasVO editora = tbModel.getEditoras(telaEditoras.getTbEditoras().getSelectedRow());
            editorasDAO.excluirEditoras(editora);
            carregarEditoras();
        }
    }

    /**
     * Método que altera os dados de uma editora na tabela do AbstractTableModel
     * para Editoras
     */
    public void alterarEditoras() {
        if (telaEditoras.getTbEditoras().getSelectedRow() >= 0) {  //Só altera se tiver uma linha selecionada
            ModelEditorasDAO editorasDAO = new ModelEditorasDAO();
            ModelEditorasVO editora = tbModel.getEditoras(telaEditoras.getTbEditoras().getSelectedRow());
            telaEditoras.getTxtId().setText(String.valueOf(editora.getId()));
            telaEditoras.getTxtNome().setText(editora.getNome());
            telaEditoras.getTxtLocalizacao().setText(editora.getLocalizacao());
            //ViewEditoras.cmbCidades.setSelectedItem(editora.getLocalizacao());
            varAlterar = true;
        }
    }

    /**
     * Método que limpa as variaveis e campos na tela do formulário
     * ViewEditoras.java
     */
    public void limparVariaveisEditoras() {
        telaEditoras.getTxtId().setText("");
        telaEditoras.getTxtNome().setText("");
        telaEditoras.getTxtLocalizacao().setText("");
    }
}
