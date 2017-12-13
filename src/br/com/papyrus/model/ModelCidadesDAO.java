package br.com.papyrus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que acessa os dados, fazendo um CRUD para Cidades
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelCidadesDAO {

    /**
     * Método responsável pelo acesso a dados, inserindo registros em Cidades,
     * chamado pelo AbstractTableModel
     *
     * @param cidade os dados a serem salvos no registro para Cidades
     * @return Retorna true se conseguiu inserir o registro e false caso dê
     * algum problema
     */
    public boolean inserirCidades(ModelCidadesVO cidade) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "INSERT INTO Cidades (Pais, Estado, Cidade) VALUES (?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, cidade.getPais());
            pstm.setString(2, cidade.getEstado());
            pstm.setString(3, cidade.getCidade());
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
     * Método responsável pelo acesso a dados, alterando registros em Cidades,
     * chamado pelo AbstractTableModel
     *
     * @param cidade os dados a serem alterados no registro para Cidades
     * @return Retorna true se conseguiu alterar o registro e false caso dê
     * algum problema
     */
    public boolean alterarCidades(ModelCidadesVO cidade) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "UPDATE Cidades SET Pais = ?, Estado = ?, Cidade = ? WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, cidade.getPais());
            pstm.setString(2, cidade.getEstado());
            pstm.setString(3, cidade.getCidade());
            pstm.setInt(4, cidade.getId());
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
     * Método responsável pelo acesso a dados, excluindo registros em Cidades,
     * chamado pelo AbstractTableModel
     *
     * @param cidade os dados a serem excluidos no registro para Cidades
     * @return Retorna true se conseguiu excluir o registro e false caso dê
     * algum problema
     */
    public boolean excluirCidades(ModelCidadesVO cidade) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "DELETE FROM Cidades WHERE Id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, cidade.getId());
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
     * Cidades, para um ArrayList para ser carregado no AbstractTableModel
     *
     * @return listaRetorno Retorna um ArrayList com os registros de Cidades.
     */
    public List<ModelCidadesVO> listarCidades() {
        List<ModelCidadesVO> listaRetorno = new ArrayList<ModelCidadesVO>();
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT * FROM Cidades";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                //Instancia um novo objeto
                ModelCidadesVO vo = new ModelCidadesVO();
                vo.setId(rs.getInt("Id"));
                vo.setPais(rs.getString("Pais"));
                vo.setEstado(rs.getString("Estado"));
                vo.setCidade(rs.getString("Cidade"));
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
