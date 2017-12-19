package br.com.papyrus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que acessa os dados, fazendo um CRUD para Autores
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelAutoresDAO {

    /**
     * Método responsável pelo acesso a dados, inserindo registros em Autores,
     * chamado pelo AbstractTableModel
     *
     * @param autor os dados a serem salvos no registro para Autores
     * @return Retorna true se conseguiu inserir o registro e false caso dê
     * algum problema
     */
    public boolean inserirAutores(ModelAutoresVO autor) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "INSERT INTO Autores (Nome) VALUES (?)";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, autor.getNome());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, alterando registros em Autores,
     * chamado pelo AbstractTableModel
     *
     * @param autor os dados a serem alterados no registro para Autores
     * @return Retorna true se conseguiu alterar o registro e false caso dê
     * algum problema
     */
    public boolean alterarAutores(ModelAutoresVO autor) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "UPDATE Autores SET Nome = ? WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, autor.getNome());
            pstm.setInt(2, autor.getId());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, excluindo registros em Autores,
     * chamado pelo AbstractTableModel
     *
     * @param autor os dados a serem excluidos no registro para Autores
     * @return Retorna true se conseguiu excluir o registro e false caso dê
     * algum problema
     */
    public boolean excluirAutores(ModelAutoresVO autor) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "DELETE FROM Autores WHERE Id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, autor.getId());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, listando os registros de Autores,
     * para um ArrayList para ser carregado no AbstractTableModel
     *
     * @return listaRetorno Retorna um ArrayList com os registros de Autores.
     */
    public List<ModelAutoresVO> listarAutores() {
        List<ModelAutoresVO> listaRetorno = new ArrayList<ModelAutoresVO>();
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT * FROM Autores";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                //Instancia um novo objeto
                ModelAutoresVO vo = new ModelAutoresVO();
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
