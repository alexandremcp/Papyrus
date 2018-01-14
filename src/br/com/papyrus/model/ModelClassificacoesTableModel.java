package br.com.papyrus.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria e gerencia a AbstractTableModel para Classificacoes
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelClassificacoesTableModel extends AbstractTableModel {

    private List classificacoes;
    private String[] colunas = new String[]{"CÓDIGO", "NOME DA CLASSIFICAÇÃO"};

    @Override
    public String getColumnName(int i) {    //getColumnName() -> Dá nome ao cabeçalho da tabela
        return colunas[i];
    }

    public ModelClassificacoesTableModel(List classificacoes) {
        this.classificacoes = classificacoes;
    }

    @Override
    public int getRowCount() {  //Retorna a quantidade de linhas da tabela
        if (classificacoes != null) {
            return classificacoes.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {   //Retorna a quantidade de colunas da tabela
        return colunas.length;
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        ModelClassificacoesVO classificacao = (ModelClassificacoesVO) classificacoes.get(indiceLinha);

        if (classificacao != null) {
            switch (indiceColuna) {
                case 0:
                    return classificacao.getId();
                case 1:
                    return classificacao.getNome();
            }
        }
        return null;
    }

    public ModelClassificacoesVO getClassificacoes(int linha) {
        if (linha >= 0) {
            return (ModelClassificacoesVO) this.classificacoes.get(linha);
        }
        return null;
    }
}
