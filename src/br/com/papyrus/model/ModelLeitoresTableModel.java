package br.com.papyrus.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Classe que cria e gerencia a AbstractTableModel para Autores
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelLeitoresTableModel extends AbstractTableModel {

    private List leitores;
    private String[] colunas = new String[]{"CÓDIGO", "NOME", "NOME SOCIAL", "SEXO", "NASCIMENTO", "MATRICULA", "TURMA", "TURNO", "CADASTRO", "PAI", "MAE", "IDENTIDADE", "CPF", "TELEFONE", "EMAIL", "ENDERECO", "BAIRRO", "CIDADE", "ESTADO", "REFERENCIA", "OBSERVACOES"};

    @Override
    public String getColumnName(int i) {    //getColumnName() -> Dá nome ao cabeçalho da tabela
        return colunas[i];
    }

    public ModelLeitoresTableModel(List leitores) {
        this.leitores = leitores;
    }

    @Override
    public int getRowCount() {  //Retorna a quantidade de linhas da tabela
        if (leitores != null) {
            return leitores.size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {   //Retorna a quantidade de colunas da tabela
        return colunas.length;
    }

    @Override
    public Object getValueAt(int indiceLinha, int indiceColuna) {
        ModelLeitoresVO leitor = (ModelLeitoresVO) leitores.get(indiceLinha);

        if (leitor != null) {
            switch (indiceColuna) {
                case 0:
                    return leitor.getId();
                case 1:
                    return leitor.getNome();
                case 2:
                    return leitor.getNomeSocial();
                case 3:
                    return leitor.getSexo();
                case 4:
                    return leitor.getNascimento();
                case 5:
                    return leitor.getMatricula();
                case 6:
                    return leitor.getTurma();
                case 7:
                    return leitor.getTurno();
                case 8:
                    return leitor.getCadastro();
                case 9:
                    return leitor.getPai();
                case 10:
                    return leitor.getMae();
                case 11:
                    return leitor.getIdentidade();
                case 12:
                    return leitor.getCPF();
                case 13:
                    return leitor.getTelefone();
                case 14:
                    return leitor.getEmail();
                case 15:
                    return leitor.getEndereco();
                case 16:
                    return leitor.getBairro();
                case 17:
                    return leitor.getCidade();
                case 18:
                    return leitor.getEstado();
                case 19:
                    return leitor.getReferencia();
                case 20:
                    return leitor.getObservacoes();
            }
        }
        return null;
    }

    public ModelLeitoresVO getLeitores(int linha) {
        if (linha >= 0) {
            return (ModelLeitoresVO) this.leitores.get(linha);
        }
        return null;
    }

}
