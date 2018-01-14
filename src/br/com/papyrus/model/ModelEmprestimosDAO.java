package br.com.papyrus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que acessa os dados, fazendo um CRUD para Emprestimos
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelEmprestimosDAO {

    /**
     * Método responsável pelo acesso a dados, inserindo registros em
     * Emprestimos, chamado pelo AbstractTableModel
     *
     * @param Emprestimo os dados a serem salvos no registro para Emprestimos
     * @return Retorna true se conseguiu inserir o registro e false caso dê
     * algum problema
     */
    public boolean inserirEmprestimos(ModelEmprestimosVO Emprestimo) {
        try {
            LocalDate dt = LocalDate.now();
            DateTimeFormatter formatoUN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String dataEmprestimo = null;
            dataEmprestimo = dt.format(formatoUN);

            Connection conn = CriarConexao.abrirConexao();
            String SQL = "INSERT INTO Emprestimos (Leitores_Id,Acervo_Id,Emprestimo) VALUES (?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, Emprestimo.getLeitores_Id());
            pstm.setInt(2, Emprestimo.getAcervo_Id());
            pstm.setString(3, dataEmprestimo);
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "UPDATE acervo SET Disponivel=? WHERE Id=?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, "não");
            pstm.setInt(2, Emprestimo.getAcervo_Id());
            System.out.println(Emprestimo.getDisponivelAcervo());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Método responsável pelo acesso a dados, alterando registros em
     * Emprestimo, chamado pelo AbstractTableModel
     *
     * @param Emprestimo os dados a serem alterados no registro para Emprestimo
     * @return Retorna true se conseguiu alterar o registro e false caso dê
     * algum problema
     */

    /**
     * Método responsável pelo acesso a dados, listando os registros de
     * Emprestimos, para um ArrayList para ser carregado no AbstractTableModel
     *
     * @return listaRetorno Retorna um ArrayList com os registros de
     * Emprestimos.
     */
    public List<ModelEmprestimosVO> listarEmprestimos() {
        List<ModelEmprestimosVO> listaRetorno = new ArrayList<ModelEmprestimosVO>();
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT ace.Id AS IdAcervo, ace.Titulo AS TituloAcervo,"
                    + " ace.SubTitulo AS SubTituloAcervo, ace.Exemplar AS ExemplarAcervo,"
                    + " ace.Edicao AS EdicaoAcervo, ace.Volume AS VolumeAcervo,"
                    + " ace.Local AS LocalAcervo, ace.Disponivel AS DisponivelAcervo,"
                    + " tip.Id AS IdTipos, tip.Dias AS DiasTipos FROM acervo ace"
                    + " JOIN tipos tip ON tip.Id = ace.Tipos_Id"
                    + " WHERE ace.Disponivel = 'sim'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);

            while (rs.next()) {
                ModelEmprestimosVO EmprestimosVO = new ModelEmprestimosVO();
                EmprestimosVO.setIdAcervo(rs.getInt("IdAcervo"));
                EmprestimosVO.setTituloAcervo(rs.getString("TituloAcervo"));
                EmprestimosVO.setSubTituloAcervo(rs.getString("SubTituloAcervo"));
                EmprestimosVO.setExemplarAcervo(rs.getInt("ExemplarAcervo"));
                EmprestimosVO.setEdicaoAcervo(rs.getString("EdicaoAcervo"));
                EmprestimosVO.setVolumeAcervo(rs.getInt("VolumeAcervo"));
                EmprestimosVO.setLocalAcervo(rs.getString("LocalAcervo"));
                EmprestimosVO.setDisponivelAcervo(rs.getString("DisponivelAcervo"));
                EmprestimosVO.setIdTipos(rs.getInt("IdTipos"));
                EmprestimosVO.setDiasTipos(rs.getInt("DiasTipos"));
                listaRetorno.add(EmprestimosVO);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return listaRetorno;
    }
}
