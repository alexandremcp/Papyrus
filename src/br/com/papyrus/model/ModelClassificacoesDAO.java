package br.com.papyrus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que acessa os dados, fazendo um CRUD para Classificacoes
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelClassificacoesDAO {

    /**
     * Método responsável pelo acesso a dados, inserindo registros em Classificacoes,
     * chamado pelo AbstractTableModel
     *
     * @param classificacao os dados a serem salvos no registro para Classificacoes
     * @return Retorna true se conseguiu inserir o registro e false caso dê
     * algum problema
     */
    public boolean inserirClassificacoes(ModelClassificacoesVO classificacao) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "INSERT INTO Classificacoes (Nome) VALUES (?)";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, classificacao.getNome());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, alterando registros em Classificacoes,
     * chamado pelo AbstractTableModel
     *
     * @param classificacao os dados a serem alterados no registro para Classificacoes
     * @return Retorna true se conseguiu alterar o registro e false caso dê
     * algum problema
     */
    public boolean alterarClassificacoes(ModelClassificacoesVO classificacao) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "UPDATE Classificacoes SET Nome = ? WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, classificacao.getNome());
            pstm.setInt(2, classificacao.getId());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, excluindo registros em Classificacoes,
     * chamado pelo AbstractTableModel
     *
     * @param classificacao os dados a serem excluidos no registro para Classificacoes
     * @return Retorna true se conseguiu excluir o registro e false caso dê
     * algum problema
     */
    public boolean excluirClassificacoes(ModelClassificacoesVO classificacao) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "DELETE FROM Classificacoes WHERE Id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, classificacao.getId());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, listando os registros de Classificacoes,
     * para um ArrayList para ser carregado no AbstractTableModel
     *
     * @return listaRetorno Retorna um ArrayList com os registros de Classificacoes.
     */
    public List<ModelClassificacoesVO> listarClassificacoes() {
        List<ModelClassificacoesVO> listaRetorno = new ArrayList<ModelClassificacoesVO>();
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT * FROM Classificacoes";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                //Instancia um novo objeto
                ModelClassificacoesVO vo = new ModelClassificacoesVO();
                vo.setId(rs.getInt("Id"));
                vo.setNome(rs.getString("Nome"));
                listaRetorno.add(vo);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return listaRetorno;
    }
}
