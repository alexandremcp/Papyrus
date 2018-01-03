package br.com.papyrus.controller;

import br.com.papyrus.model.ModelTiposDAO;
import br.com.papyrus.model.ModelTiposTableModel;
import br.com.papyrus.model.ModelTiposVO;
import br.com.papyrus.view.ViewTipos;
import static br.com.papyrus.view.ViewPrincipal.DesktopPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 * Classe que cria e gerencia o AbstractTableModel para Tipos
 *
 * @author Alexandre Luiz dos Santos.
 *
 * varAlterar: Controla se é uma alteração ou uma inclusão no
 * AbstractTableModel, se True é para incluir um novo registro, se False é para
 * alterar Tipos um registro existente.
 *
 * telaTipos: Recebe as informações da ViewTipos.java que é a tela com os
 * dados da Tipo.
 */
public final class ControllerTipos {

    public ViewTipos telaTipos;
    private ModelTiposTableModel tbModel;
    private boolean varAlterar = false;

    public ControllerTipos() {

        telaTipos = new ViewTipos();
        DesktopPrincipal.add(telaTipos);
        telaTipos.show();

        carregarTipos();

        telaTipos.getBtnSalvar().addActionListener((ActionEvent ae) -> {
            salvarTipos();
        });

        telaTipos.getBtnExcluir().addActionListener((ActionEvent ae) -> {
            excluirTipos();
        });

        telaTipos.getBtnAlterar().addActionListener((ActionEvent ae) -> {
            alterarTipos();
        });
         
    }

    public ControllerTipos(JDesktopPane DesktopPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que salva os dados no AbstractTableModel para Tipos, utiliza a
     * variável varAlterar que se for True indica que é para gravar um novo
     * registro na tabela Tipos através do AbstractTableModel.
     */
    public void salvarTipos() {

        if (!varAlterar) {
            if (telaTipos.getTxtNome().getText().equals("")) { //Objeto novo
                JOptionPane.showMessageDialog(null, "Por favor preencha os dados !");
            } else {
                ModelTiposVO tipo = new ModelTiposVO();
                tipo.setNome(telaTipos.getTxtNome().getText());
                tipo.setDias(Integer.valueOf(telaTipos.getTxtDias().getText()));
                ModelTiposDAO tiposDAO = new ModelTiposDAO();

                if (tiposDAO.inserirTipos(tipo)) {
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
                    carregarTipos();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar gravar!\n" + "Algum campo tem valores inválidos.\n" + "Por favor corriga e tente novamente.");
                }
            }
        }

        if (varAlterar) {
            ModelTiposVO tipo = new ModelTiposVO();
            tipo.setNome(telaTipos.getTxtNome().getText());
            tipo.setDias(Integer.valueOf(telaTipos.getTxtDias().getText()));
            ModelTiposDAO tiposDAO = new ModelTiposDAO();

            tipo.setId(Integer.valueOf(telaTipos.getTxtId().getText()));
            if (tiposDAO.alterarTipos(tipo)) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso !");
                carregarTipos();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar!\n" + "Algum campo tem valores inválidos.\n" + "Por favor corriga e tente novamente.");
            }
            varAlterar = false;
        }
        limparVariaveisTipos();
    }

    /**
     * Método que carrega os dados das editoras no AbstractTableModel para
     * Tipos
     */
    public void carregarTipos() {
        ModelTiposDAO tiposDAO = new ModelTiposDAO();
        tbModel = new ModelTiposTableModel(tiposDAO.listarTipos());
        telaTipos.setTbTipos(tbModel);
    }

    /**
     * Método que exclui um tipo da tabela do AbstractTableModel para
     * Tipos
     */
    public void excluirTipos() {
        if (telaTipos.getTbTipos().getSelectedRow() >= 0) {  //Só exclui se tiver uma linha selecionada
            ModelTiposDAO tiposDAO = new ModelTiposDAO();
            ModelTiposVO tipo = tbModel.getTipos(telaTipos.getTbTipos().getSelectedRow());
            tiposDAO.excluirTipos(tipo);
            carregarTipos();
        }
    }

    /**
     * Método que altera os dados de uma tipo na tabela do AbstractTableModel
     * para Tipos
     */
    public void alterarTipos() {
        if (telaTipos.getTbTipos().getSelectedRow() >= 0) {  //Só altera se tiver uma linha selecionada
            ModelTiposDAO tiposDAO = new ModelTiposDAO();
            ModelTiposVO tipo = tbModel.getTipos(telaTipos.getTbTipos().getSelectedRow());
            telaTipos.getTxtId().setText(String.valueOf(tipo.getId()));
            telaTipos.getTxtNome().setText(tipo.getNome());
            telaTipos.getTxtDias().setText(String.valueOf(tipo.getDias()));
            varAlterar = true;
        }
    }

   
    /**
     * Método que limpa as variaveis e campos na tela do formulário
     * ViewTipos.java
     */
    public void limparVariaveisTipos() {
        telaTipos.getTxtId().setText("");
        telaTipos.getTxtNome().setText("");
        telaTipos.getTxtDias().setText("");
    }

}
