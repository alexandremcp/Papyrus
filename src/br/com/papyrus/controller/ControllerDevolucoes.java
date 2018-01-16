package br.com.papyrus.controller;

import br.com.papyrus.model.ModelDevolucoesDAO;
import br.com.papyrus.model.ModelDevolucoesTableModel;
import br.com.papyrus.model.ModelDevolucoesVO;
import br.com.papyrus.view.ViewDevolucoes;
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
 * telaDevolucoes: Recebe as informações da ViewDevolucoes.java que é a tela
 * com os dados do Autor.
 */
public final class ControllerDevolucoes {

    public ViewDevolucoes telaDevolucoes;
    private ModelDevolucoesTableModel tbModel;
    private boolean varAlterar = false;

    public ControllerDevolucoes() {

        telaDevolucoes = new ViewDevolucoes();
        DesktopPrincipal.add(telaDevolucoes);
        telaDevolucoes.show();

        carregarDevolucoes();

        telaDevolucoes.getBtnSalvar().addActionListener((ActionEvent ae) -> {
            salvarDevolucoes();
        });
    }

    public ControllerDevolucoes(JDesktopPane DesktopPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean validaCampos() {
        return telaDevolucoes.getTxtLeitores_Id().getText().isEmpty() || telaDevolucoes.getTxtAcervo_Id().getText().isEmpty() || telaDevolucoes.getTxtDevolucao().getText().isEmpty();
    }

    /**
     * Método que salva os dados no AbstractTableModel para Emprestimos, utiliza
     * a variável varAlterar que se for True indica que é para gravar um novo
     * registro na tabela Emprestimos através do AbstractTableModel.
     */
    public void salvarDevolucoes() {

        if (validaCampos()) {    //Validação dos campos para não gravar em branco
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
        } else {
            ModelDevolucoesVO devolucao = new ModelDevolucoesVO();
            devolucao.setLeitores_Id(Integer.valueOf(telaDevolucoes.getTxtLeitores_Id().getText()));
            devolucao.setAcervo_Id(Integer.valueOf(telaDevolucoes.getTxtAcervo_Id().getText()));
            devolucao.setDevolucao(telaDevolucoes.getTxtDevolucao().getText());
            ModelDevolucoesDAO devolucoesDAO = new ModelDevolucoesDAO();

            if (devolucoesDAO.inserirDevolucoes(devolucao)) {
                JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
                carregarDevolucoes();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar!\n" + "Algum campo tem valores inválidos.\n" + "Por favor corriga e tente novamente.");
            }
        }
        limparVariaveis(telaDevolucoes);
    }

    /**
     * Método que carrega os dados das devolucoes no AbstractTableModel para
     * Emprestimos
     */
    public void carregarDevolucoes() {
        ModelDevolucoesDAO devolucoesDAO = new ModelDevolucoesDAO();
        tbModel = new ModelDevolucoesTableModel(devolucoesDAO.listarDevolucoes());
        telaDevolucoes.setTbEmprestimos(tbModel);
    }

    /**
     * Método que limpa as variaveis e campos na tela do formulário passado como
     * parametro ViewDevolucoes.java
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
