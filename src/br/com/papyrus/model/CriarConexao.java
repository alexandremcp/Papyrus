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
     * Este método carrega um HashMap com dados da tabela passada como parametro
     *
     * @param s Contém a condição SQL da tabela que será carregada.
     * @return mapComboBox A lista com os nomes das campos da tabela passada
     * pelo parametro s e retorna para ser utilizada por um combobox.
     */
    public HashMap<String, Integer> CarregarComboBox(String s) {
        String SQL = s;
        HashMap<String, Integer> mapComboBox = new HashMap<String, Integer>();
        try {

            Connection conn = CriarConexao.abrirConexao();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            ModelEditorasVO mcmb;

            while (rs.next()) {
                mcmb = new ModelEditorasVO(rs.getInt(1), rs.getString(2));
                mapComboBox.put(mcmb.getNome(), mcmb.getId());
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ViewAcervo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapComboBox;
    }
}
