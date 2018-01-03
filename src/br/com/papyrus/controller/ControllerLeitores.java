package br.com.papyrus.controller;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.papyrus.model.ModelLeitoresDAO;
import br.com.papyrus.model.ModelLeitoresTableModel;
import br.com.papyrus.model.ModelLeitoresVO;
import br.com.papyrus.view.ViewLeitores;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import static br.com.papyrus.view.ViewPrincipal.DesktopPrincipal;
import java.awt.Component;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 * Classe que cria e gerencia o AbstractTableModel para Leitores
 *
 * @author Alexandre Luiz dos Santos.
 *
 * varAlterar: Controla se é uma alteração ou uma inclusão no
 * AbstractTableModel, se True é para incluir um novo registro, se False é para
 * alterarLeitores um registro existente.
 *
 * telaLeitores: Recebe as informações da ViewLeitores.java que é a tela com os
 * dados do Autor.
 */
public final class ControllerLeitores {

    public ViewLeitores telaLeitores;
    private ModelLeitoresTableModel tbModel;
    private boolean varAlterar = false;

    public ControllerLeitores() {

        telaLeitores = new ViewLeitores();
        DesktopPrincipal.add(telaLeitores);
        telaLeitores.show();

        carregarLeitores();

        telaLeitores.getBtnSalvar().addActionListener((ActionEvent ae) -> {
            salvarLeitores();
        });

        telaLeitores.getBtnExcluir().addActionListener((ActionEvent ae) -> {
            excluirLeitores();
        });

        telaLeitores.getBtnAlterar().addActionListener((ActionEvent ae) -> {
            alterarLeitores();
        });
    }

    public ControllerLeitores(JDesktopPane DesktopPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean validaCampos() {
        return telaLeitores.getTxtNome().getText().isEmpty() || telaLeitores.getTxtSexo().getText().isEmpty() || telaLeitores.getTxtMatricula().getText().isEmpty() || telaLeitores.getTxtTurma().getText().isEmpty() || telaLeitores.getTxtTurno().getText().isEmpty();
    }

    /**
     * Método que salva os dados no AbstractTableModel para Leitores, utiliza a
     * variável varAlterar que se for True indica que é para gravar um novo
     * registro na tabela Leitores através do AbstractTableModel.
     */
    public void salvarLeitores() {

        if (!varAlterar) {
            if (validaCampos()) {    //Validação dos campos para não gravar em branco
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {
                ModelLeitoresVO leitor = new ModelLeitoresVO();
                CPFFormatter formatadorCPF = new CPFFormatter();
                leitor.setNome(telaLeitores.getTxtNome().getText());
                leitor.setNomeSocial(telaLeitores.getTxtNomeSocial().getText());
                leitor.setSexo(telaLeitores.getTxtSexo().getText());
                leitor.setNascimento(telaLeitores.getTxtNascimento().getText());
                leitor.setMatricula(telaLeitores.getTxtMatricula().getText());
                leitor.setTurma(Integer.valueOf(telaLeitores.getTxtTurma().getText()));
                leitor.setTurno(telaLeitores.getTxtTurno().getText());
                leitor.setCadastro(telaLeitores.getTxtCadastro().getText());
                leitor.setPai(telaLeitores.getTxtPai().getText());
                leitor.setMae(telaLeitores.getTxtMae().getText());
                leitor.setIdentidade(telaLeitores.getTxtIdentidade().getText());
                leitor.setCPF(formatadorCPF.unformat(telaLeitores.getTxtCPF().getText()));
                leitor.setTelefone(telaLeitores.getTxtTelefone().getText());
                leitor.setEmail(telaLeitores.getTxtEmail().getText());
                leitor.setEndereco(telaLeitores.getTxtEndereco().getText());
                leitor.setBairro(telaLeitores.getTxtBairro().getText());
                leitor.setCidade(telaLeitores.getTxtCidade().getText());
                leitor.setEstado(telaLeitores.getTxtEstado().getText());
                leitor.setReferencia(telaLeitores.getTxtReferencia().getText());
                leitor.setObservacoes(telaLeitores.getTxtObservacoes().getText());

                ModelLeitoresDAO leitoresDAO = new ModelLeitoresDAO();

                if (leitoresDAO.inserirLeitores(leitor)) {
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
                    carregarLeitores();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar gravar!\n" + "Algum campo tem valores inválidos.\n" + "Por favor corriga e tente novamente.");
                }
            }
        }

        if (varAlterar) {
            ModelLeitoresVO leitor = new ModelLeitoresVO();
            leitor.setNome(telaLeitores.getTxtNome().getText());
            leitor.setNomeSocial(telaLeitores.getTxtNomeSocial().getText());
            leitor.setSexo(telaLeitores.getTxtSexo().getText());
            leitor.setNascimento(telaLeitores.getTxtNascimento().getText());
            leitor.setMatricula(telaLeitores.getTxtMatricula().getText());
            leitor.setTurma(Integer.valueOf(telaLeitores.getTxtTurma().getText()));
            leitor.setTurno(telaLeitores.getTxtTurno().getText());
            leitor.setCadastro(telaLeitores.getTxtCadastro().getText());
            leitor.setPai(telaLeitores.getTxtPai().getText());
            leitor.setMae(telaLeitores.getTxtMae().getText());
            leitor.setIdentidade(telaLeitores.getTxtIdentidade().getText());
            leitor.setCPF(telaLeitores.getTxtCPF().getText());
            leitor.setTelefone(telaLeitores.getTxtTelefone().getText());
            leitor.setEmail(telaLeitores.getTxtEmail().getText());
            leitor.setEndereco(telaLeitores.getTxtEndereco().getText());
            leitor.setBairro(telaLeitores.getTxtBairro().getText());
            leitor.setCidade(telaLeitores.getTxtCidade().getText());
            leitor.setEstado(telaLeitores.getTxtEstado().getText());
            leitor.setReferencia(telaLeitores.getTxtReferencia().getText());
            leitor.setObservacoes(telaLeitores.getTxtObservacoes().getText());
            ModelLeitoresDAO leitoresDAO = new ModelLeitoresDAO();

            leitor.setId(Integer.valueOf(telaLeitores.getTxtId().getText()));
            if (leitoresDAO.alterarLeitores(leitor)) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso !");
                carregarLeitores();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar!\n" + "Algum campo tem valores inválidos.\n" + "Por favor corriga e tente novamente.");
            }
            varAlterar = false;
        }

        limparVariaveis(telaLeitores);
    }

    /**
     * Método que carrega os dados dos autores no AbstractTableModel para
     * Leitores
     */
    public void carregarLeitores() {
        ModelLeitoresDAO leitoresDAO = new ModelLeitoresDAO();
        tbModel = new ModelLeitoresTableModel(leitoresDAO.listarLeitores());
        telaLeitores.setTbLeitores(tbModel);
    }

    /**
     * Método que exclui um leitor da tabela do AbstractTableModel para Leitores
     */
    public void excluirLeitores() {
        if (telaLeitores.getTbLeitores().getSelectedRow() >= 0) {  //Só exclui se tiver uma linha selecionada
            ModelLeitoresDAO leitoresDAO = new ModelLeitoresDAO();
            ModelLeitoresVO leitor = tbModel.getLeitores(telaLeitores.getTbLeitores().getSelectedRow());
            leitoresDAO.excluirLeitores(leitor);
            carregarLeitores();
        }
    }

    /**
     * Método que altera os dados de um leitor na tabela do AbstractTableModel
     * para Leitores
     */
    public void alterarLeitores() {
        if (telaLeitores.getTbLeitores().getSelectedRow() >= 0) {  //Só altera se tiver uma linha selecionada
            ModelLeitoresDAO leitoresDAO = new ModelLeitoresDAO();
            ModelLeitoresVO leitor = tbModel.getLeitores(telaLeitores.getTbLeitores().getSelectedRow());
            telaLeitores.getTxtId().setText(String.valueOf(leitor.getId()));
            telaLeitores.getTxtNome().setText(leitor.getNome());
            telaLeitores.getTxtNomeSocial().setText(leitor.getNomeSocial());
            telaLeitores.getTxtSexo().setText(leitor.getSexo());
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            telaLeitores.getTxtNascimento().setText(leitor.getNascimento());
            telaLeitores.getTxtMatricula().setText(leitor.getMatricula());
            telaLeitores.getTxtTurma().setText(String.valueOf(leitor.getTurma()));
            telaLeitores.getTxtTurno().setText(leitor.getTurno());
            telaLeitores.getTxtCadastro().setText(leitor.getCadastro());
            telaLeitores.getTxtPai().setText(leitor.getPai());
            telaLeitores.getTxtMae().setText(leitor.getMae());
            telaLeitores.getTxtIdentidade().setText(leitor.getIdentidade());
            telaLeitores.getTxtCPF().setText(leitor.getCPF());
            telaLeitores.getTxtTelefone().setText(leitor.getTelefone());
            telaLeitores.getTxtEmail().setText(leitor.getEmail());
            telaLeitores.getTxtEndereco().setText(leitor.getEndereco());
            telaLeitores.getTxtBairro().setText(leitor.getBairro());
            telaLeitores.getTxtCidade().setText(leitor.getCidade());
            telaLeitores.getTxtEstado().setText(leitor.getEstado());
            telaLeitores.getTxtReferencia().setText(leitor.getReferencia());
            telaLeitores.getTxtObservacoes().setText(leitor.getObservacoes());
            varAlterar = true;
        }
    }

    /**
     * Método que limpa as variaveis e campos na tela do formulário passado como
     * parametro ViewLeitores.java
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
