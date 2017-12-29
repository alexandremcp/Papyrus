package br.com.papyrus.controller;

import br.com.papyrus.model.ModelAcervoDAO;
import br.com.papyrus.model.ModelAcervoTableModel;
import br.com.papyrus.model.ModelAcervoVO;
import br.com.papyrus.view.ViewAcervo;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import static br.com.papyrus.view.ViewPrincipal.DesktopPrincipal;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;

/**
 * Classe que cria e gerencia o AbstractTableModel para Acervo
 *
 * @author Alexandre Luiz dos Santos.
 *
 * varAlterar: Controla se é uma alteração ou uma inclusão no
 * AbstractTableModel, se True é para incluir um novo registro, se False é para
 * alterarAcervo um registro existente.
 *
 * telaAcervo: Recebe as informações da ViewAcervo.java que é a tela com os
 * dados do Acervo.
 */
public final class ControllerAcervo {

    public ViewAcervo telaAcervo;
    private ModelAcervoTableModel tbModel;
    private boolean varAlterar = false;

    public ControllerAcervo() {

        telaAcervo = new ViewAcervo();
        DesktopPrincipal.add(telaAcervo);
        telaAcervo.show();

        carregarAcervo();

        telaAcervo.getBtnDuplicar().addActionListener((ActionEvent ae) -> {
            duplicarAcervo();
        });

        telaAcervo.getBtnSalvar().addActionListener((ActionEvent ae) -> {
            salvarAcervo();
        });

        telaAcervo.getBtnExcluir().addActionListener((ActionEvent ae) -> {
            excluirAcervo();
        });

        telaAcervo.getBtnAlterar().addActionListener((ActionEvent ae) -> {
            alterarAcervo();
        });
    }

    public ControllerAcervo(JDesktopPane DesktopPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Valida os campos verificando se estão em branco, se algum estiver retorna verdadeiro
    private boolean validaCampos() {
        return telaAcervo.getTxtTitulo().getText().isEmpty() || telaAcervo.getTxtEditoras_Id().getText().isEmpty() || telaAcervo.getTxtClassificacao_Id().getText().isEmpty() || telaAcervo.getTxtTipos_Id().getText().isEmpty() || telaAcervo.getTxtIdioma().getText().isEmpty() || telaAcervo.getTxtDisponivel().getText().isEmpty();
    }

    public void duplicarAcervo() {
        alterarAcervo();    //Chama alterar para carregar os campos da tabela
        if (validaCampos()) {    //Validação dos campos para não gravar em branco
            JOptionPane.showMessageDialog(null, "Primeiro selecione um item da tabela");
        } else {
            varAlterar = false; //Torna a variavel falsa para indicar que é para incluir os dados e não atualizar.
            salvarAcervo();
            JOptionPane.showMessageDialog(null, "Não esqueça de alterar as informações no registro que foi duplicado.");
        }

    }

    /**
     * Método que salva os dados no AbstractTableModel para Acervo, utiliza a
     * variável varAlterar que se for True indica que é para gravar um novo
     * registro na tabela Acervo através do AbstractTableModel.
     */
    public void salvarAcervo() {

        if (!varAlterar) {
            if (validaCampos()) {    //Validação dos campos para não gravar em branco
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatorios");
            } else {
                ModelAcervoVO acervo = new ModelAcervoVO();
                acervo.setTitulo(telaAcervo.getTxtTitulo().getText());
                acervo.setSubTitulo(telaAcervo.getTxtSubTitulo().getText());
                acervo.setSerie(telaAcervo.getTxtSerie().getText());
                acervo.setIdioma(telaAcervo.getTxtIdioma().getText());
                acervo.setExemplar(Integer.valueOf(telaAcervo.getTxtExemplar().getText()));
                acervo.setEdicao(telaAcervo.getTxtEdicao().getText());
                acervo.setPaginas(Integer.valueOf(telaAcervo.getTxtPaginas().getText()));
                acervo.setVolume(Integer.valueOf(telaAcervo.getTxtVolume().getText()));
                acervo.setAno(Integer.valueOf(telaAcervo.getTxtAno().getText()));
                acervo.setAquisicao(telaAcervo.getTxtAquisicao().getText());
                acervo.setLocal(telaAcervo.getTxtLocal().getText());
                acervo.setEditoras_Id(Integer.valueOf(telaAcervo.getTxtEditoras_Id().getText()));
                acervo.setClassificacao_Id(Integer.valueOf(telaAcervo.getTxtClassificacao_Id().getText()));
                acervo.setTipos_Id(Integer.valueOf(telaAcervo.getTxtTipos_Id().getText()));
                acervo.setTombo(telaAcervo.getTxtTombo().getText());
                acervo.setCDU(telaAcervo.getTxtCDU().getText());
                acervo.setCDD(telaAcervo.getTxtCDD().getText());
                acervo.setCUTTER(telaAcervo.getTxtCUTTER().getText());
                acervo.setISBN(telaAcervo.getTxtISBN().getText());
                acervo.setObservacoes(telaAcervo.getTxtObservacoes().getText());
                acervo.setDisponivel(telaAcervo.getTxtDisponivel().getText());
                ModelAcervoDAO acervoDAO = new ModelAcervoDAO();

                if (acervoDAO.inserirAcervo(acervo)) {
                    JOptionPane.showMessageDialog(null, "Gravado com sucesso !");
                    carregarAcervo();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao tentar gravar !");
                }
            }
        }

        if (varAlterar) {
            ModelAcervoVO acervo = new ModelAcervoVO();
            acervo.setTitulo(telaAcervo.getTxtTitulo().getText());
            acervo.setSubTitulo(telaAcervo.getTxtSubTitulo().getText());
            acervo.setSerie(telaAcervo.getTxtSerie().getText());
            acervo.setIdioma(telaAcervo.getTxtIdioma().getText());
            acervo.setExemplar(Integer.parseInt(telaAcervo.getTxtExemplar().getText()));
            acervo.setEdicao(telaAcervo.getTxtEdicao().getText());
            acervo.setPaginas(Integer.parseInt(telaAcervo.getTxtPaginas().getText()));
            acervo.setVolume(Integer.parseInt(telaAcervo.getTxtVolume().getText()));
            acervo.setAno(Integer.parseInt(telaAcervo.getTxtAno().getText()));
            acervo.setAquisicao(telaAcervo.getTxtAquisicao().getText());
            acervo.setLocal(telaAcervo.getTxtLocal().getText());
            acervo.setEditoras_Id(Integer.parseInt(telaAcervo.getTxtEditoras_Id().getText()));
            acervo.setClassificacao_Id(Integer.parseInt(telaAcervo.getTxtClassificacao_Id().getText()));
            acervo.setTipos_Id(Integer.parseInt(telaAcervo.getTxtTipos_Id().getText()));
            acervo.setTombo(telaAcervo.getTxtTombo().getText());
            acervo.setCDU(telaAcervo.getTxtCDU().getText());
            acervo.setCDD(telaAcervo.getTxtCDD().getText());
            acervo.setCUTTER(telaAcervo.getTxtCUTTER().getText());
            acervo.setISBN(telaAcervo.getTxtISBN().getText());
            acervo.setObservacoes(telaAcervo.getTxtObservacoes().getText());
            acervo.setDisponivel(telaAcervo.getTxtDisponivel().getText());
            ModelAcervoDAO acervoDAO = new ModelAcervoDAO();

            acervo.setId(Integer.valueOf(telaAcervo.getTxtId().getText()));
            if (acervoDAO.alterarAcervo(acervo)) {
                JOptionPane.showMessageDialog(null, "Alterado com sucesso !");
                carregarAcervo();
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao tentar gravar !");
            }
            varAlterar = false;
        }

        limparVariaveis(telaAcervo);
    }

    /**
     * Método que carrega os dados do acervo no AbstractTableModel para Acervo
     */
    public void carregarAcervo() {
        ModelAcervoDAO acervoDAO = new ModelAcervoDAO();
        tbModel = new ModelAcervoTableModel(acervoDAO.listarAcervo());
        telaAcervo.setTbAcervo(tbModel);
    }

    /**
     * Método que exclui um acervo da tabela do AbstractTableModel para Acervo
     */
    public void excluirAcervo() {
        if (telaAcervo.getTbAcervo().getSelectedRow() >= 0) {  //Só exclui se tiver uma linha selecionada
            ModelAcervoDAO acervoDAO = new ModelAcervoDAO();
            ModelAcervoVO acervo = tbModel.getAcervo(telaAcervo.getTbAcervo().getSelectedRow());
            acervoDAO.excluirAcervo(acervo);
            carregarAcervo();
        }
    }

    /**
     * Método que altera os dados de um acervo na tabela do AbstractTableModel
     * para Acervo
     */
    public void alterarAcervo() {
        if (telaAcervo.getTbAcervo().getSelectedRow() >= 0) {  //Só altera se tiver uma linha selecionada
            //ModelAcervoDAO acervoDAO = new ModelAcervoDAO();
            ModelAcervoVO acervo = tbModel.getAcervo(telaAcervo.getTbAcervo().getSelectedRow());
            telaAcervo.getTxtId().setText(String.valueOf(acervo.getId()));
            telaAcervo.getTxtTitulo().setText(acervo.getTitulo());
            telaAcervo.getTxtSubTitulo().setText(acervo.getSubTitulo());
            telaAcervo.getTxtSerie().setText(acervo.getSerie());
            telaAcervo.getTxtExemplar().setText(String.valueOf(acervo.getExemplar()));
            telaAcervo.getTxtEdicao().setText(acervo.getEdicao());
            telaAcervo.getTxtPaginas().setText(String.valueOf(acervo.getPaginas()));
            telaAcervo.getTxtVolume().setText(String.valueOf(acervo.getVolume()));
            telaAcervo.getTxtAno().setText(String.valueOf(acervo.getAno()));
            telaAcervo.getTxtAquisicao().setText(acervo.getAquisicao());
            telaAcervo.getTxtLocal().setText(acervo.getLocal());
            telaAcervo.getTxtTombo().setText(acervo.getTombo());
            telaAcervo.getTxtCDU().setText(acervo.getCDU());
            telaAcervo.getTxtCDD().setText(acervo.getCDD());
            telaAcervo.getTxtCUTTER().setText(acervo.getCUTTER());
            telaAcervo.getTxtISBN().setText(acervo.getISBN());
            telaAcervo.getTxtIdioma().setText(acervo.getIdioma());
            telaAcervo.getTxtObservacoes().setText(acervo.getObservacoes());
            telaAcervo.getTxtDisponivel().setText(acervo.getDisponivel());
            telaAcervo.getTxtTipos_Id().setText(String.valueOf(acervo.getTipos_Id()));
            telaAcervo.getTxtEditoras_Id().setText(String.valueOf(acervo.getEditoras_Id()));
            telaAcervo.getTxtClassificacao_Id().setText(String.valueOf(acervo.getClassificacao_Id()));

            telaAcervo.getTxtNomeEditora().setText(acervo.getNomeEditoras());
            telaAcervo.getTxtNomeClassificacao().setText(acervo.getNomeClassificacoes());
            telaAcervo.getTxtNomeTipo().setText(acervo.getNomeTipos());

            varAlterar = true;
        }

    }

    /**
     * Método que limpa as variaveis e campos na tela do formulário passado como
     * parametro ViewAcervo.java
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
