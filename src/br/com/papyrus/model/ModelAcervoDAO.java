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

    public static String edVO;

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
            String SQL = "INSERT INTO Acervo (Titulo,SubTitulo,Serie,Idioma,"
                    + "Exemplar,Edicao,Paginas,Volume,Ano,Aquisicao,Local,"
                    + "Editoras_Id,Classificacao_Id,Tipos_Id,Tombo,CDU,CDD,"
                    + "CUTTER,ISBN,Observacoes,Disponivel, Autores_Id) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            pstm.setInt(22, Acervo.getAutores_Id());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
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
            String SQL = "UPDATE Acervo SET Titulo=?,SubTitulo=?,Serie=?,"
                    + "Idioma=?,Exemplar=?,Edicao=?,Paginas=?,Volume=?,Ano=?,"
                    + "Aquisicao=?,Local=?,Editoras_Id=?,Classificacao_Id=?,"
                    + "Tipos_Id=?,Tombo=?,CDU=?,CDD=?,CUTTER=?,ISBN=?,"
                    + "Observacoes=?,Disponivel=?, Autores_Id=? WHERE id = ?";
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
            pstm.setInt(22, Acervo.getAutores_Id());            
            pstm.setInt(23, Acervo.getId());


            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
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
        } catch (ClassNotFoundException | SQLException ex) {
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
            String SQL = "SELECT a.Id, a.Titulo, a.Subtitulo, a.Serie, a.Idioma,"
                    + " a.Exemplar, a.Edicao, a.Paginas, a.Volume, a.Ano, a.Aquisicao,"
                    + " a.Local, a.Editoras_Id, a.Classificacao_Id, a.Tipos_Id,"
                    + " a.Tombo, a.CDU, a.CDD, a.CUTTER, a.ISBN, a.Observacoes,"
                    + " a.Disponivel, a.Autores_Id, e.Nome AS NomeEditoras,"
                    + " c.Nome AS NomeClassificacoes, t.Nome AS NomeTipos,"
                    + " au.Id, au.Nome AS AutoresNome "
                    + " FROM acervo a"
                    + " JOIN editoras e ON e.Id = a.Editoras_Id"
                    + " JOIN tipos t ON t.Id = a.Tipos_Id"
                    + " JOIN classificacoes c ON c.Id = a.Classificacao_Id"
                    + " JOIN autores au ON au.Id = a.Autores_Id;";

            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                ModelAcervoVO acervoVO = new ModelAcervoVO();   //Instancia um novo objeto
                acervoVO.setId(rs.getInt("Id"));
                acervoVO.setTitulo(rs.getString("Titulo"));
                acervoVO.setSubTitulo(rs.getString("SubTitulo"));
                acervoVO.setSerie(rs.getString("Serie"));
                acervoVO.setIdioma(rs.getString("Idioma"));
                acervoVO.setExemplar(rs.getInt("Exemplar"));
                acervoVO.setEdicao(rs.getString("Edicao"));
                acervoVO.setPaginas(rs.getInt("Paginas"));
                acervoVO.setVolume(rs.getInt("Volume"));
                acervoVO.setAno(rs.getInt("Ano"));
                acervoVO.setAquisicao(rs.getString("Aquisicao"));
                acervoVO.setLocal(rs.getString("Local"));
                acervoVO.setEditoras_Id(rs.getInt("Editoras_Id"));
                acervoVO.setClassificacao_Id(rs.getInt("Classificacao_Id"));
                acervoVO.setTipos_Id(rs.getInt("Tipos_Id"));
                acervoVO.setTombo(rs.getString("Tombo"));
                acervoVO.setCDU(rs.getString("CDU"));
                acervoVO.setCDD(rs.getString("CDD"));
                acervoVO.setCUTTER(rs.getString("CUTTER"));
                acervoVO.setISBN(rs.getString("ISBN"));
                acervoVO.setObservacoes(rs.getString("Observacoes"));
                acervoVO.setDisponivel(rs.getString("Disponivel"));

                acervoVO.setNomeEditoras(rs.getString("NomeEditoras"));
                acervoVO.setNomeClassificacoes(rs.getString("NomeClassificacoes"));
                acervoVO.setNomeTipos(rs.getString("NomeTipos"));
                acervoVO.setAutores_Id(rs.getInt("Autores_Id"));
                acervoVO.setAutoresNome(rs.getString("AutoresNome"));

                listaRetorno.add(acervoVO);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return listaRetorno;
    }
}
