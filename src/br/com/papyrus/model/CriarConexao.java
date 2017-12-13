package br.com.papyrus.model;

import br.com.papyrus.view.ViewAcervo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que cria e fecha as conexões com o banco de dados
 *
 * @author Alexandre Luiz dos Santos
 */
public class CriarConexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/papyrus?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "als250170";

    //Devolve a Excption para a função que chamar caso aconteça
    public static Connection abrirConexao() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER);
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        return conn;  //Retorna a conexão para a função que chamou
    }

    public static void fecharConexao(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CriarConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement stmt) {
        fecharConexao(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CriarConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void fecharConexao(Connection con, PreparedStatement stmt, ResultSet rs) {
        fecharConexao(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CriarConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Este método carrega um Combobox com dados da editora vindo da tabela
     * Editoras
     *
     * @return mapEditoras A lista com os nomes das editoras para o combobox
     */
    public HashMap<String, Integer> CarregarEditoras() {
        HashMap<String, Integer> mapEditoras = new HashMap<String, Integer>();
        try {

            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT ID, NOME, LOCALIZACAO FROM editoras";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            ModelEditorasComboVO cec;

            while (rs.next()) {
                cec = new ModelEditorasComboVO(rs.getInt(1), rs.getString(2), rs.getString(3));
                mapEditoras.put(cec.getNomeCombo(), cec.getIdCombo());
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ViewAcervo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapEditoras;
    }

    /**
     * Este método carrega um Combobox com dados da Classificação vindo da
     * tabela Classificacoes
     *
     * @return mapClassificacoes A lista com os nomes das classificacoes
     * literarias para o combobox
     */
    public HashMap<String, Integer> CarregarClassificacoes() {
        HashMap<String, Integer> mapClassificacoes = new HashMap<String, Integer>();
        try {

            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT ID, NOME FROM classificacoes filtro";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            ModelClassificacoesComboVO mcc;

            while (rs.next()) {
                mcc = new ModelClassificacoesComboVO(rs.getInt(1), rs.getString(2));
                mapClassificacoes.put(mcc.getNomeCombo(), mcc.getIdCombo());
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ViewAcervo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapClassificacoes;
    }

    /**
     * Este método carrega um Combobox com dados vindos da tabela Tipos
     *
     * @return mapTipos A lista com os nomes dos Tipos de midias para o combobox
     */
    public HashMap<String, Integer> CarregarTipos() {
        HashMap<String, Integer> mapTipos = new HashMap<String, Integer>();
        try {

            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT ID, NOME, DIAS FROM tipos";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            ModelTiposComboVO mtc;

            while (rs.next()) {
                mtc = new ModelTiposComboVO(rs.getInt(1), rs.getString(2));
                mapTipos.put(mtc.getNomeCombo(), mtc.getIdCombo());
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ViewAcervo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapTipos;
    }

}
