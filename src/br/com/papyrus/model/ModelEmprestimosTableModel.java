package br.com.papyrus.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria e gerencia a AbstractTableModel para Emprestimos
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelEmprestimosTableModel extends AbstractTableModel {

    private List emprestimos;
    private String[] colunas = new String[]{"CÓDIGO", "TÍTULO", "SUBTÍTULO", "AUTOR", "EXEMPLAR","EDIÇÃO","VOLUME","LOCAL","DISPONÍVEL", "DIAS"};

    @Override
    public String getColumnName(int i) {    //getColumnName() -> Dá nome ao cabeçalho da tabela
        return colunas[i];
    }

    public ModelEmprestimosTableModel(List emprestimos) {
        this.emprestimos = emprestimos;
    }

    @Override
    public int getRowCount() {  //Retorna a quantidade de linhas da tabela
        if (emprestimos != null) {
            return emprestimos.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {   //Retorna a quantidade de colunas da tabela
        return colunas.length;
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        ModelEmprestimosVO emprestimo = (ModelEmprestimosVO) emprestimos.get(indiceLinha);

        if (emprestimo != null) {
            switch (indiceColuna) {
                case 0:
                    return emprestimo.getIdAcervo();                    
                case 1:
                    return emprestimo.getTituloAcervo();                    
                case 2:
                    return emprestimo.getSubTituloAcervo();  
                case 3:
                    return emprestimo.getAutorNome();                      
                case 4:
                    return emprestimo.getExemplarAcervo();                    
                case 5:
                    return emprestimo.getEdicaoAcervo();                    
                case 6:
                    return emprestimo.getVolumeAcervo();                    
                case 7:
                    return emprestimo.getLocalAcervo();                    
                case 8:
                    return emprestimo.getDisponivelAcervo();    
                case 9:
                    return emprestimo.getDiasTipos();    
            }
        }
        return null;
    }

    public ModelEmprestimosVO getEmprestimos(int linha) {
        if (linha >= 0) {
            return (ModelEmprestimosVO) this.emprestimos.get(linha);
        }
        return null;
    }
}
