package br.com.papyrus.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria e gerencia a AbstractTableModel para Autores
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelAutoresTableModel extends AbstractTableModel {

    private List autores;
    private String[] colunas = new String[]{"CÓDIGO", "NOME DO AUTOR"};

    @Override
    public String getColumnName(int i) {    //getColumnName() -> Dá nome ao cabeçalho da tabela
        return colunas[i];
    }

    public ModelAutoresTableModel(List autores) {
        this.autores = autores;
    }

    @Override
    public int getRowCount() {  //Retorna a quantidade de linhas da tabela
        if (autores != null) {
            return autores.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {   //Retorna a quantidade de colunas da tabela
        return colunas.length;
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        ModelAutoresVO autor = (ModelAutoresVO) autores.get(indiceLinha);

        if (autor != null) {
            switch (indiceColuna) {
                case 0:
                    return autor.getId();
                case 1:
                    return autor.getNome();
            }
        }
        return null;
    }

    public ModelAutoresVO getAutores(int linha) {
        if (linha >= 0) {
            return (ModelAutoresVO) this.autores.get(linha);
        }
        return null;
    }

}
