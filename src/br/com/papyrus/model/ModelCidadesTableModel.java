package br.com.papyrus.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria e gerencia a AbstractTableModel para Cidades
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelCidadesTableModel extends AbstractTableModel {

    private List cidades;
    private String[] colunas = new String[]{"CÓDIGO", "PAÍS", "ESTADO", "CIDADE"};

    //getColumnName() -> Dá nome ao cabeçalho da tabela
    @Override
    public String getColumnName(int i) {
        return colunas[i];
    }

    public ModelCidadesTableModel(List cidades) {
        this.cidades = cidades;
    }

    @Override
    public int getRowCount() {  //Retorna a quantidade de linhas da tabela
        if (cidades != null) {
            return cidades.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {   //Retorna a quantidade de colunas da tabela
        return colunas.length;
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        ModelCidadesVO cidade = (ModelCidadesVO) cidades.get(indiceLinha);

        if (cidade != null) {
            switch (indiceColuna) {
                case 0:
                    return cidade.getId();
                case 1:
                    return cidade.getPais();
                case 2:
                    return cidade.getEstado();
                case 3:
                    return cidade.getCidade();    
            }
        }
        return null;
    }

    public ModelCidadesVO getCidades(int linha) {
        if (linha >= 0) {
            return (ModelCidadesVO) this.cidades.get(linha);
        }
        return null;
    }

}
