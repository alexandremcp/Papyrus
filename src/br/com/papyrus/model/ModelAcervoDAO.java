package br.com.papyrus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que acessa os dados, fazendo um CRUD para Acervo
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelAcervoDAO {

    /**
     * Método responsável pelo acesso a dados, inserindo registros em Acervo,
     * chamado pelo AbstractTableModel
     *
     * @param Acervo os dados a serem salvos no registro para Acervo
     * @return Retorna true se conseguiu inserir o registro e false caso dê
     * algum problema
     */
    public boolean inserirAcervo(ModelAcervoVO Acervo) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "INSERT INTO Acervo (Titulo,SubTitulo,Serie,Idioma,Exemplar,Edicao,Paginas,Volume,Ano,Aquisicao,Local,Editoras_Id,Classificacao_Id,Tipos_Id,Tombo,CDU,CDD,CUTTER,ISBN,Observacoes,Disponivel) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, Acervo.getTitulo());
            pstm.setString(2, Acervo.getSubTitulo());
            pstm.setString(3, Acervo.getSerie());
            pstm.setString(4, Acervo.getIdioma());
            pstm.setInt(5, Acervo.getExemplar());
            pstm.setString(6, Acervo.getEdicao());
            pstm.setInt(7, Acervo.getPaginas());
            pstm.setInt(8, Acervo.getVolume());
            pstm.setInt(9, Acervo.getAno());
            pstm.setString(10, Acervo.getAquisicao());
            pstm.setString(11, Acervo.getLocal());
            pstm.setInt(12, Acervo.getEditoras_Id());
            pstm.setInt(13, Acervo.getClassificacao_Id());          
            pstm.setInt(14, Acervo.getTipos_Id());
            pstm.setString(15, Acervo.getTombo());
            pstm.setString(16, Acervo.getCDU());
            pstm.setString(17, Acervo.getCDD());
            pstm.setString(18, Acervo.getCUTTER());
            pstm.setString(19, Acervo.getISBN());
            pstm.setString(20, Acervo.getObservacoes());
            pstm.setString(21, Acervo.getDisponivel());
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
     * Método responsável pelo acesso a dados, alterando registros em Acervo,
     * chamado pelo AbstractTableModel
     *
     * @param Acervo os dados a serem alterados no registro para Acervo
     * @return Retorna true se conseguiu alterar o registro e false caso dê
     * algum problema
     */
    public boolean alterarAcervo(ModelAcervoVO Acervo) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "UPDATE Acervo SET Titulo=?,SubTitulo=?,Serie=?,Exemplar=?,Edicao=?,Paginas=?,Volume=?,Ano=?,Aquisicao=?,Local=?,Tombo=?,CDU=?,CDD=?,CUTT=?, ER=?,ISBN=?,Idioma=?,Observacoes=?,Disponivel=?,Tipos_Id=?,Editoras_Id=?,Classificacao_Id=? WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, Acervo.getTitulo());
            pstm.setString(2, Acervo.getSubTitulo());
            pstm.setString(3, Acervo.getSerie());
            pstm.setString(4, Acervo.getIdioma());
            pstm.setInt(5, Acervo.getExemplar());
            pstm.setString(6, Acervo.getEdicao());
            pstm.setInt(7, Acervo.getPaginas());
            pstm.setInt(8, Acervo.getVolume());
            pstm.setInt(9, Acervo.getAno());
            pstm.setString(10, Acervo.getAquisicao());
            pstm.setString(11, Acervo.getLocal());
            pstm.setInt(12, Acervo.getEditoras_Id());
            pstm.setInt(13, Acervo.getClassificacao_Id());          
            pstm.setInt(14, Acervo.getTipos_Id());
            pstm.setString(15, Acervo.getTombo());
            pstm.setString(16, Acervo.getCDU());
            pstm.setString(17, Acervo.getCDD());
            pstm.setString(18, Acervo.getCUTTER());
            pstm.setString(19, Acervo.getISBN());
            pstm.setString(20, Acervo.getObservacoes());
            pstm.setString(21, Acervo.getDisponivel());
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
     * Método responsável pelo acesso a dados, excluindo registros em Acervo,
     * chamado pelo AbstractTableModel
     *
     * @param Acervo os dados a serem excluidos no registro para Acervo
     * @return Retorna true se conseguiu excluir o registro e false caso dê
     * algum problema
     */
    public boolean excluirAcervo(ModelAcervoVO Acervo) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "DELETE FROM Acervo WHERE Id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, Acervo.getId());
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
     * Método responsável pelo acesso a dados, listando os registros de Acervo,
     * para um ArrayList para ser carregado no AbstractTableModel
     *
     * @return listaRetorno Retorna um ArrayList com os registros de Acervo.
     */
    public List<ModelAcervoVO> listarAcervo() {
        List<ModelAcervoVO> listaRetorno = new ArrayList<ModelAcervoVO>();
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT * FROM Acervo";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                //Instancia um novo objeto
                ModelAcervoVO vo = new ModelAcervoVO();
                vo.setId(rs.getInt("Id"));
                vo.setTitulo(rs.getString("Titulo"));
                vo.setSubTitulo(rs.getString("SubTitulo"));
                vo.setSerie(rs.getString("Serie"));
                vo.setExemplar(rs.getInt("Exemplar"));
                vo.setEdicao(rs.getString("Edicao"));
                vo.setPaginas(rs.getInt("Paginas"));
                vo.setVolume(rs.getInt("Volume"));
                vo.setAno(rs.getInt("Ano"));
                vo.setAquisicao(rs.getString("Aquisicao"));
                vo.setLocal(rs.getString("Local"));
                vo.setTombo(rs.getString("Tombo"));
                vo.setCDU(rs.getString("CDU"));
                vo.setCDD(rs.getString("CDD"));
                vo.setCUTTER(rs.getString("CUTTER"));
                vo.setISBN(rs.getString("ISBN"));
                vo.setIdioma(rs.getString("Idioma"));
                vo.setObservacoes(rs.getString("Observacoes"));
                vo.setDisponivel(rs.getString("Disponivel"));
                vo.setTipos_Id(rs.getInt("Tipos_Id"));
                vo.setEditoras_Id(rs.getInt("Editoras_Id"));
                vo.setClassificacao_Id(rs.getInt("Classificacao_Id"));
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
