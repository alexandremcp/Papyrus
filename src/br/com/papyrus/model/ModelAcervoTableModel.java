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
    private String[] colunas = new String[]{"ID", "TÍTULO", "SUBTITULO", "SERIE", "EXEMPLAR", "EDICAO", "PAGINAS", "VOLUME", "ANO", "AQUISICAO", "LOCAL", "TOMBO", "CDU", "CDD", "CUTTER", "ISBN", "IDIOMA", "OBSERVAÇÕES", "DISPONIVEL", "TIPO", "EDITORA", "CLASSIFICAÇÃO"};

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
                    return acervoVO.getIdioma();
                case 5:
                    return acervoVO.getExemplar();
                case 6:
                    return acervoVO.getEdicao();
                case 7:
                    return acervoVO.getPaginas();
                case 8:
                    return acervoVO.getVolume();
                case 9:
                    return acervoVO.getAno();
                case 10:
                    return acervoVO.getAquisicao();
                case 11:
                    return acervoVO.getLocal();
                case 12:
                    return acervoVO.getEditoras_Id();
                case 13:
                    return acervoVO.getClassificacao_Id();
                case 14:
                    return acervoVO.getTipos_Id();
                case 15:
                    return acervoVO.getTombo();
                case 16:
                    return acervoVO.getCDU();
                case 17:
                    return acervoVO.getCDD();
                case 18:
                    return acervoVO.getCUTTER();
                case 19:
                    return acervoVO.getISBN();
                case 20:
                    return acervoVO.getObservacoes();
                case 21:
                    return acervoVO.getDisponivel();
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
