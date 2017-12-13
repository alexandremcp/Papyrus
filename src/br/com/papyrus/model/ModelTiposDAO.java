package br.com.papyrus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que acessa os dados, fazendo um CRUD para Tipos
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelTiposDAO {

    /**
     * Método responsável pelo acesso a dados, inserindo registros em Tipos,
     * chamado pelo AbstractTableModel
     *
     * @param tipo os dados a serem salvos no registro para Tipos
     * @return Retorna true se conseguiu inserir o registro e false caso dê
     * algum problema
     */
    public boolean inserirTipos(ModelTiposVO tipo) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "INSERT INTO Tipos (Nome, Dias) VALUES (?,?)";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, tipo.getNome());
            pstm.setInt(2, tipo.getDias());
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
     * Método responsável pelo acesso a dados, alterando registros em Tipos,
     * chamado pelo AbstractTableModel
     *
     * @param tipo os dados a serem alterados no registro para Tipos
     * @return Retorna true se conseguiu alterar o registro e false caso dê
     * algum problema
     */
    public boolean alterarTipos(ModelTiposVO tipo) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "UPDATE Tipos SET Nome = ?, Dias = ? WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, tipo.getNome());
            pstm.setInt(2, tipo.getDias());
            pstm.setInt(3, tipo.getId());
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
     * Método responsável pelo acesso a dados, excluindo registros em Tipos,
     * chamado pelo AbstractTableModel
     *
     * @param tipo os dados a serem excluidos no registro para Tipos
     * @return Retorna true se conseguiu excluir o registro e false caso dê
     * algum problema
     */
    public boolean excluirTipos(ModelTiposVO tipo) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "DELETE FROM Tipos WHERE Id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, tipo.getId());
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
     * Tipos, para um ArrayList para ser carregado no AbstractTableModel
     *
     * @return listaRetorno Retorna um ArrayList com os registros de Tipos.
     */
    public List<ModelTiposVO> listarTipos() {
        List<ModelTiposVO> listaRetorno = new ArrayList<ModelTiposVO>();
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT * FROM Tipos";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                //Instancia um novo objeto
                ModelTiposVO vo = new ModelTiposVO();
                vo.setId(rs.getInt("Id"));
                vo.setNome(rs.getString("Nome"));
                vo.setDias(rs.getInt("Dias"));
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
