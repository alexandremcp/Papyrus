package br.com.papyrus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que acessa os dados, fazendo um CRUD para Editoras
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelEditorasDAO {

    /**
     * Método responsável pelo acesso a dados, inserindo registros em Editoras,
     * chamado pelo AbstractTableModel
     *
     * @param editora os dados a serem salvos no registro para Editoras
     * @return Retorna true se conseguiu inserir o registro e false caso dê
     * algum problema
     */
    public boolean inserirEditoras(ModelEditorasVO editora) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "INSERT INTO Editoras (Nome, Localizacao) VALUES (?,?)";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, editora.getNome());
            pstm.setString(2, editora.getLocalizacao());
            pstm.execute();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, alterando registros em Editoras,
     * chamado pelo AbstractTableModel
     *
     * @param editora os dados a serem alterados no registro para Editoras
     * @return Retorna true se conseguiu alterar o registro e false caso dê
     * algum problema
     */
    public boolean alterarEditoras(ModelEditorasVO editora) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "UPDATE Editoras SET Nome = ?, Localizacao = ? WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, editora.getNome());
            pstm.setString(2, editora.getLocalizacao());
            pstm.setInt(3, editora.getId());
            pstm.execute();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    

    /**
     * Método responsável pelo acesso a dados, excluindo registros em Editoras,
     * chamado pelo AbstractTableModel
     *
     * @param editora os dados a serem excluidos no registro para Editoras
     * @return Retorna true se conseguiu excluir o registro e false caso dê
     * algum problema
     */
    public boolean excluirEditoras(ModelEditorasVO editora) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "DELETE FROM Editoras WHERE Id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, editora.getId());
            pstm.execute();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, listando os registros de
     * Editoras, para um ArrayList para ser carregado no AbstractTableModel
     *
     * @return listaRetorno Retorna um ArrayList com os registros de Editoras.
     */
    public List<ModelEditorasVO> listarEditoras() {
        List<ModelEditorasVO> listaRetorno = new ArrayList<ModelEditorasVO>();
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT * FROM Editoras";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                //Instancia um novo objeto
                ModelEditorasVO vo = new ModelEditorasVO();
                vo.setId(rs.getInt("Id"));
                vo.setNome(rs.getString("Nome"));
                vo.setLocalizacao(rs.getString("Localizacao"));
                listaRetorno.add(vo);
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return listaRetorno;
    }
}
