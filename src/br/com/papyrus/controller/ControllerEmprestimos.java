package br.com.papyrus.controller;

import br.com.papyrus.model.ModelEmprestimosDAO;
import br.com.papyrus.model.ModelEmprestimosTableModel;
import br.com.papyrus.model.ModelEmprestimosVO;
import br.com.papyrus.view.ViewEmprestimos;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import static br.com.papyrus.view.ViewPrincipal.DesktopPrincipal;
import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 * Classe que cria e gerencia o AbstractTableModel para Emprestimos
 *
 * @author Alexandre Luiz dos Santos.
 *
 * varAlterar: Controla se é uma alteração ou uma inclusão no
 * AbstractTableModel, se True é para incluir um novo registro, se False é para
 * alterar um registro existente.
 *
 * telaEmprestimos: Recebe as informações da ViewEmprestimos.java que é a tela
 * com os dados do Autor.
 */
public final class ControllerEmprestimos {

    public ViewEmprestimos telaEmprestimos;
    private ModelEmprestimosTableModel tbModel;
    private boolean varAlterar = false;

    public ControllerEmprestimos() {

        telaEmprestimos = new ViewEmprestimos();
        DesktopPrincipal.add(telaEmprestimos);
        telaEmprestimos.show();

        carregarEmprestimos();

        telaEmprestimos.getBtnSalvar().addActionListener((ActionEvent ae) -> {
            salvarAutores();
        });
    }

    public ControllerEmprestimos(JDesktopPane DesktopPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean validaCampos() {
        return telaEmprestimos.getTxtLeitores_Id().getText().isEmpty() || telaEmprestimos.getTxtAcervo_Id().getText().isEmpty() || telaEmprestimos.getTxtEmprestimo().getText().isEmpty();
    }

    /**
     * Método que salva os dados no AbstractTableModel para Emprestimos, utiliza
     * a variável varAlterar que se for True indica que é para gravar um novo
     * registro na tabela Emprestimos através do AbstractTableModel.
     */
    public void salvarAutores() {

        if (validaCampos()) {    //Validação dos campos para não gravar em branco
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
        } else {
            ModelEmprestimosVO emprestimo = new ModelEmprestimosVO();
            emprestimo.setLeitores_Id(Integer.valueOf(telaEmprestimos.getTxtLeitores_Id().getText()));
            emprestimo.setAcervo_Id(Integer.valueOf(telaEmprestimos.getTxtAcervo_Id().getText()));
            emprestimo.setEmprestimo(telaEmprestimos.getTxtEmprestimo().getText());
            ModelEmprestimosDAO emprestimosDAO = new ModelEmprestimosDAO();

            if (emprestimosDAO.inserirEmprestimos(emprestimo)) {
                JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
                carregarEmprestimos();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar!\n" + "Algum campo tem valores inválidos.\n" + "Por favor corriga e tente novamente.");
            }
        }
        limparVariaveis(telaEmprestimos);
    }

    /**
     * Método que carrega os dados dos autores no AbstractTableModel para
     * Emprestimos
     */
    public void carregarEmprestimos() {
        ModelEmprestimosDAO emprestimosDAO = new ModelEmprestimosDAO();
        tbModel = new ModelEmprestimosTableModel(emprestimosDAO.listarEmprestimos());
        telaEmprestimos.setTbEmprestimos(tbModel);
    }

    /**
     * Método que limpa as variaveis e campos na tela do formulário passado como
     * parametro ViewEmprestimos.java
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
