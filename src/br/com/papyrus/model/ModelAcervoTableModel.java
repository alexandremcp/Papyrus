package br.com.papyrus.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria e gerencia a AbstractTableModel para Autores
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelAcervoTableModel extends AbstractTableModel {

    private List acervo;
    private String[] colunas = new String[]{"ID", "TÍTULO", "SUBTITULO", "SERIE", "AUTOR", "IDIOMA", "EXEMPLAR", "EDICAO", "PAGINAS", "VOLUME", "ANO", "AQUISICAO", "LOCAL", "EDITORA", "CLASSIFICAÇÃO","TIPO","TOMBO", "CDU", "CDD", "CUTTER", "ISBN", "OBSERVAÇÕES", "DISPONIVEL", "EDITORA", "CLASSIFICAÇÃO", "TIPO"};

    @Override
    public String getColumnName(int i) {    //getColumnName() -> Dá nome ao cabeçalho da tabela
        return colunas[i];
    }

    public ModelAcervoTableModel(List acervo) {
        this.acervo = acervo;
    }

    @Override
    public int getRowCount() {  //Retorna a quantidade de linhas da tabela
        if (acervo != null) {
            return acervo.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {   //Retorna a quantidade de colunas da tabela
        return colunas.length;
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        ModelAcervoVO acervoVO = (ModelAcervoVO) acervo.get(indiceLinha);

        if (acervoVO != null) {
            switch (indiceColuna) {
                case 0:
                    return acervoVO.getId();
                case 1:
                    return acervoVO.getTitulo();
                case 2:
                    return acervoVO.getSubTitulo();
                case 3:
                    return acervoVO.getSerie();
                case 4:
                    return acervoVO.getAutoresNome();                    
                case 5:
                    return acervoVO.getIdioma();
                case 6:
                    return acervoVO.getExemplar();
                case 7:
                    return acervoVO.getEdicao();
                case 8:
                    return acervoVO.getPaginas();
                case 9:
                    return acervoVO.getVolume();
                case 10:
                    return acervoVO.getAno();
                case 11:
                    return acervoVO.getAquisicao();
                case 12:
                    return acervoVO.getLocal();
                case 13:
                    return acervoVO.getEditoras_Id();
                case 14:
                    return acervoVO.getClassificacao_Id();
                case 15:
                    return acervoVO.getTipos_Id();
                case 16:
                    return acervoVO.getTombo();
                case 17:
                    return acervoVO.getCDU();
                case 18:
                    return acervoVO.getCDD();
                case 19:
                    return acervoVO.getCUTTER();
                case 20:
                    return acervoVO.getISBN();
                case 21:
                    return acervoVO.getObservacoes();
                case 22:
                    return acervoVO.getDisponivel();
                case 23:
                    return acervoVO.getNomeEditoras();
                case 24:
                    return acervoVO.getNomeClassificacoes();
                case 25:
                    return acervoVO.getNomeTipos();
            }
        }
        return null;
    }

    public ModelAcervoVO getAcervo(int linha) {
        if (linha >= 0) {
            return (ModelAcervoVO) this.acervo.get(linha);
        }
        return null;
    }
}
