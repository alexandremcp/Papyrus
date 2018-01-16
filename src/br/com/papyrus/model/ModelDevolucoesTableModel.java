package br.com.papyrus.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria e gerencia a AbstractTableModel para Emprestimos
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelDevolucoesTableModel extends AbstractTableModel {

    private List devolucoes;
    private String[] colunas = new String[]{"CÓDIGO", "TÍTULO", "SUBTÍTULO", "AUTOR", "EXEMPLAR","EDIÇÃO","VOLUME","LOCAL","DISPONÍVEL", "DIAS"};

    @Override
    public String getColumnName(int i) {    //getColumnName() -> Dá nome ao cabeçalho da tabela
        return colunas[i];
    }

    public ModelDevolucoesTableModel(List devolucoes) {
        this.devolucoes = devolucoes;
    }

    @Override
    public int getRowCount() {  //Retorna a quantidade de linhas da tabela
        if (devolucoes != null) {
            return devolucoes.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {   //Retorna a quantidade de colunas da tabela
        return colunas.length;
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        ModelDevolucoesVO devolucao = (ModelDevolucoesVO) devolucoes.get(indiceLinha);

        if (devolucao != null) {
            switch (indiceColuna) {
                case 0:
                    return devolucao.getIdAcervo();                    
                case 1:
                    return devolucao.getTituloAcervo();                    
                case 2:
                    return devolucao.getSubTituloAcervo();  
                case 3:
                    return devolucao.getAutorNome();                      
                case 4:
                    return devolucao.getExemplarAcervo();                    
                case 5:
                    return devolucao.getEdicaoAcervo();                    
                case 6:
                    return devolucao.getVolumeAcervo();                    
                case 7:
                    return devolucao.getLocalAcervo();                    
                case 8:
                    return devolucao.getDisponivelAcervo();    
                case 9:
                    return devolucao.getDiasTipos();    
            }
        }
        return null;
    }

    public ModelDevolucoesVO getEmprestimos(int linha) {
        if (linha >= 0) {
            return (ModelDevolucoesVO) this.devolucoes.get(linha);
        }
        return null;
    }
}
