package br.com.papyrus.model;

import br.com.papyrus.view.ViewEditoras;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria e gerencia a AbstractTableModel para Tipos
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelTiposTableModel extends AbstractTableModel {

    private List tipos;
    private String[] colunas = new String[]{"CÓDIGO", "DESCRIÇÃO DO TIPO", "DIAS EMPRESTADO"};

    //getColumnName() -> Dá nome ao cabeçalho da tabela
    @Override
    public String getColumnName(int i) {
        return colunas[i];
    }

    public ModelTiposTableModel(List tipos) {
        this.tipos = tipos;
    }

    @Override
    public int getRowCount() {  //Retorna a quantidade de linhas da tabela
        if (tipos != null) {
            return tipos.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {   //Retorna a quantidade de colunas da tabela
        return colunas.length;
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        ModelTiposVO editora = (ModelTiposVO) tipos.get(indiceLinha);

        if (editora != null) {
            switch (indiceColuna) {
                case 0:
                    return editora.getId();
                case 1:
                    return editora.getNome();
                case 2:
                    return editora.getDias();
            }
        }
        return null;
    }

    public ModelTiposVO getTipos(int linha) {
        if (linha >= 0) {
            return (ModelTiposVO) this.tipos.get(linha);
        }
        return null;
    }

}
