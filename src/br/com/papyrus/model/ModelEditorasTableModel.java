package br.com.papyrus.model;

import br.com.papyrus.view.ViewEditoras;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria e gerencia a AbstractTableModel para Editoras
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelEditorasTableModel extends AbstractTableModel {

    private List editoras;
    private String[] colunas = new String[]{"CÓDIGO", "NOME DA EDITORA", "LOCALIZAÇÃO DA EDITORA"};

    //getColumnName() -> Dá nome ao cabeçalho da tabela
    @Override
    public String getColumnName(int i) {
        return colunas[i];
    }

    public ModelEditorasTableModel(List editoras) {
        this.editoras = editoras;
    }

    @Override
    public int getRowCount() {  //Retorna a quantidade de linhas da tabela
        if (editoras != null) {
            return editoras.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {   //Retorna a quantidade de colunas da tabela
        return colunas.length;
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        ModelEditorasVO editora = (ModelEditorasVO) editoras.get(indiceLinha);

        if (editora != null) {
            switch (indiceColuna) {
                case 0:
                    return editora.getId();
                case 1:
                    return editora.getNome();
                case 2:
                    return editora.getLocalizacao();
            }
        }
        return null;
    }

    public ModelEditorasVO getEditoras(int linha) {
        if (linha >= 0) {
            return (ModelEditorasVO) this.editoras.get(linha);
        }
        return null;
    }

}
