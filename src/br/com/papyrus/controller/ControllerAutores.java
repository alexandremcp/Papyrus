package br.com.papyrus.controller;

import br.com.papyrus.model.ModelAutoresDAO;
import br.com.papyrus.model.ModelAutoresTableModel;
import br.com.papyrus.model.ModelAutoresVO;
import br.com.papyrus.view.ViewAutores;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import static br.com.papyrus.view.ViewPrincipal.DesktopPrincipal;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 * Classe que cria e gerencia o AbstractTableModel para Autores
 *
 * @author Alexandre Luiz dos Santos.
 *
 * varAlterar: Controla se é uma alteração ou uma inclusão no
 * AbstractTableModel, se True é para incluir um novo registro, se False é para
 * alterarAutores um registro existente.
 *
 * telaAutores: Recebe as informações da ViewAutores.java que é a tela com os
 * dados do Autor.
 */
public final class ControllerAutores {

    public ViewAutores telaAutores;
    private ModelAutoresTableModel tbModel;
    private boolean varAlterar = false;

    public ControllerAutores() {

        telaAutores = new ViewAutores();
        DesktopPrincipal.add(telaAutores);
        telaAutores.show();

        carregarAutores();

        telaAutores.getBtnSalvar().addActionListener((ActionEvent ae) -> {
            salvarAutores();
        });

        telaAutores.getBtnExcluir().addActionListener((ActionEvent ae) -> {
            excluirAutores();
        });

        telaAutores.getBtnAlterar().addActionListener((ActionEvent ae) -> {
            alterarAutores();
        });
    }

    public ControllerAutores(JDesktopPane DesktopPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que salva os dados no AbstractTableModel para Autores, utiliza a
     * variável varAlterar que se for True indica que é para gravar um novo
     * registro na tabela Autores através do AbstractTableModel.
     */
    public void salvarAutores() {

        if (!varAlterar) {
            if (telaAutores.getTxtNome().getText().equals("")) { //Objeto novo
                JOptionPane.showMessageDialog(null, "Por favor preencha os dados !");
            } else {
                ModelAutoresVO autor = new ModelAutoresVO();
                autor.setNome(telaAutores.getTxtNome().getText());
                ModelAutoresDAO autoresDAO = new ModelAutoresDAO();

                if (autoresDAO.inserirAutores(autor)) {
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
                    carregarAutores();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar gravar!\n" + "Algum campo tem valores inválidos.\n" + "Por favor corriga e tente novamente.");
                }
            }
        }

        if (varAlterar) {
            ModelAutoresVO autor = new ModelAutoresVO();
            autor.setNome(telaAutores.getTxtNome().getText());
            ModelAutoresDAO autoresDAO = new ModelAutoresDAO();

            autor.setId(Integer.valueOf(telaAutores.getTxtId().getText()));
            if (autoresDAO.alterarAutores(autor)) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso !");
                carregarAutores();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar!\n" + "Algum campo tem valores inválidos.\n" + "Por favor corriga e tente novamente.");
            }
            varAlterar = false;
        }

        limparVariaveis(telaAutores);
    }

    /**
     * Método que carrega os dados dos autores no AbstractTableModel para
     * Autores
     */
    public void carregarAutores() {
        ModelAutoresDAO autoresDAO = new ModelAutoresDAO();
        tbModel = new ModelAutoresTableModel(autoresDAO.listarAutores());
        telaAutores.setTbAutores(tbModel);
    }

    /**
     * Método que exclui um autor da tabela do AbstractTableModel para Autores
     */
    public void excluirAutores() {
        if (telaAutores.getTbAutores().getSelectedRow() >= 0) {  //Só exclui se tiver uma linha selecionada
            ModelAutoresDAO autoresDAO = new ModelAutoresDAO();
            ModelAutoresVO autor = tbModel.getAutores(telaAutores.getTbAutores().getSelectedRow());
            autoresDAO.excluirAutores(autor);
            carregarAutores();
        }
    }

    /**
     * Método que altera os dados de um autor na tabela do AbstractTableModel
     * para Autores
     */
    public void alterarAutores() {
        if (telaAutores.getTbAutores().getSelectedRow() >= 0) {  //Só altera se tiver uma linha selecionada
            ModelAutoresDAO autoresDAO = new ModelAutoresDAO();
            ModelAutoresVO autor = tbModel.getAutores(telaAutores.getTbAutores().getSelectedRow());
            telaAutores.getTxtId().setText(String.valueOf(autor.getId()));
            telaAutores.getTxtNome().setText(autor.getNome());
            varAlterar = true;
        }
    }

    /**
     * Método que limpa as variaveis e campos na tela do formulário passado como
     * parametro ViewAutores.java
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
