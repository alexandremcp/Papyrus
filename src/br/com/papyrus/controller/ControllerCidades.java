package br.com.papyrus.controller;

import br.com.papyrus.model.ModelCidadesDAO;
import br.com.papyrus.model.ModelCidadesTableModel;
import br.com.papyrus.model.ModelCidadesVO;
import br.com.papyrus.view.ViewCidades;
import static br.com.papyrus.view.ViewPrincipal.DesktopPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 * Classe que cria e gerencia o AbstractTableModel para Cidades
 *
 * @author Alexandre Luiz dos Santos.
 *
 * varAlterar: Controla se é uma alteração ou uma inclusão no
 * AbstractTableModel, se True é para incluir um novo registro, se False é para
 * alterar Cidades um registro existente.
 *
 * telaCidades: Recebe as informações da ViewCidades.java que é a tela com os
 * dados da Cidade.
 */
public final class ControllerCidades {

    public ViewCidades telaCidades;
    private ModelCidadesTableModel tbModel;
    private boolean varAlterar = false;

    public ControllerCidades() {

        telaCidades = new ViewCidades();
        DesktopPrincipal.add(telaCidades);
        telaCidades.show();

        carregarCidades();

        telaCidades.getBtnSalvar().addActionListener((ActionEvent ae) -> {
            salvarCidades();
        });

        telaCidades.getBtnExcluir().addActionListener((ActionEvent ae) -> {
            excluirCidades();
        });

        telaCidades.getBtnAlterar().addActionListener((ActionEvent ae) -> {
            alterarCidades();
        });
         
    }

    public ControllerCidades(JDesktopPane DesktopPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que salva os dados no AbstractTableModel para Cidades, utiliza a
     * variável varAlterar que se for True indica que é para gravar um novo
     * registro na tabela Cidades através do AbstractTableModel.
     */
    public void salvarCidades() {

        if (!varAlterar) {
            if (telaCidades.getTxtPais().getText().equals("") || telaCidades.getTxtEstado().getText().equals("")) { //Objeto novo
                JOptionPane.showMessageDialog(null, "Por favor preencha os dados !");
            } else {
                ModelCidadesVO cidade = new ModelCidadesVO();
                cidade.setPais(telaCidades.getTxtPais().getText());
                cidade.setEstado(telaCidades.getTxtEstado().getText());
                cidade.setCidade(telaCidades.getTxtCidade().getText());
                
                ModelCidadesDAO cidadesDAO = new ModelCidadesDAO();

                if (cidadesDAO.inserirCidades(cidade)) {
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
                    carregarCidades();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar gravar !");
                }
            }
        }

        if (varAlterar) {
            ModelCidadesVO cidade = new ModelCidadesVO();
            cidade.setPais(telaCidades.getTxtPais().getText());
            cidade.setEstado(telaCidades.getTxtEstado().getText());
            cidade.setCidade(telaCidades.getTxtCidade().getText());
            ModelCidadesDAO cidadesDAO = new ModelCidadesDAO();

            cidade.setId(Integer.valueOf(telaCidades.getTxtId().getText()));
            if (cidadesDAO.alterarCidades(cidade)) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso !");
                carregarCidades();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar !");
            }
            varAlterar = false;
        }
        limparVariaveisCidades();
    }

    /**
     * Método que carrega os dados das cidades no AbstractTableModel para
     * Cidades
     */
    public void carregarCidades() {
        ModelCidadesDAO cidadesDAO = new ModelCidadesDAO();
        tbModel = new ModelCidadesTableModel(cidadesDAO.listarCidades());
        telaCidades.setTbCidades(tbModel);
    }

    /**
     * Método que exclui um cidade da tabela do AbstractTableModel para
     * Cidade
     */
    public void excluirCidades() {
        if (telaCidades.getTbCidades().getSelectedRow() >= 0) {  //Só exclui se tiver uma linha selecionada
            ModelCidadesDAO cidadesDAO = new ModelCidadesDAO();
            ModelCidadesVO cidade = tbModel.getCidades(telaCidades.getTbCidades().getSelectedRow());
            cidadesDAO.excluirCidades(cidade);
            carregarCidades();
        }
    }

    /**
     * Método que altera os dados de uma cidade na tabela do AbstractTableModel
     * para Cidades
     */
    public void alterarCidades() {
        if (telaCidades.getTbCidades().getSelectedRow() >= 0) {  //Só altera se tiver uma linha selecionada
            ModelCidadesDAO cidadesDAO = new ModelCidadesDAO();
            ModelCidadesVO cidade = tbModel.getCidades(telaCidades.getTbCidades().getSelectedRow());
            telaCidades.getTxtId().setText(String.valueOf(cidade.getId()));
            telaCidades.getTxtPais().setText(cidade.getPais());
            telaCidades.getTxtEstado().setText(cidade.getEstado());
            telaCidades.getTxtCidade().setText(cidade.getCidade());
            varAlterar = true;
        }
    }

   
    /**
     * Método que limpa as variaveis e campos na tela do formulário
     * ViewCidades.java
     */
    public void limparVariaveisCidades() {
        telaCidades.getTxtId().setText("");
        telaCidades.getTxtPais().setText("");
        telaCidades.getTxtEstado().setText("");
        telaCidades.getTxtCidade().setText("");
    }

}
