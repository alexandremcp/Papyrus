package br.com.papyrus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que acessa os dados, fazendo um CRUD para Leitores
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelLeitoresDAO {

    /**
     * Método responsável pelo acesso a dados, inserindo registros em Leitores,
     * chamado pelo AbstractTableModel
     *
     * @param leitor os dados a serem salvos no registro para Leitores
     * @return Retorna true se conseguiu inserir o registro e false caso dê
     * algum problema
     */
    public boolean inserirLeitores(ModelLeitoresVO leitor) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "INSERT INTO Leitores (Nome, NomeSocial, Sexo,"
                    + "Nascimento, Matricula, Turma, Turno, Cadastro, Pai, Mae,"
                    + " Identidade, CPF, Telefone, Email, Endereco, Bairro,"
                    + " Cidade, Estado, Referencia, Observacoes)"
                    + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, leitor.getNome());
            pstm.setString(2, leitor.getNomeSocial());            
            pstm.setString(3, leitor.getSexo());                        
            pstm.setString(4, leitor.getNascimento());            
            pstm.setString(5, leitor.getMatricula());                        
            pstm.setInt(6, leitor.getTurma());            
            pstm.setString(7, leitor.getTurno());                        
            pstm.setString(8, leitor.getCadastro());            
            pstm.setString(9, leitor.getPai());            
            pstm.setString(10, leitor.getMae());            
            pstm.setString(11, leitor.getIdentidade());                        
            pstm.setString(12, leitor.getCPF());            
            pstm.setString(13, leitor.getTelefone());            
            pstm.setString(14, leitor.getEmail());            
            pstm.setString(15, leitor.getEndereco());                        
            pstm.setString(16, leitor.getBairro());            
            pstm.setString(17, leitor.getCidade());            
            pstm.setString(18, leitor.getEstado());            
            pstm.setString(19, leitor.getReferencia());                        
            pstm.setString(20, leitor.getObservacoes());            
                     
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, alterando registros em Leitores,
     * chamado pelo AbstractTableModel
     *
     * @param leitor os dados a serem alterados no registro para Leitores
     * @return Retorna true se conseguiu alterar o registro e false caso dê
     * algum problema
     */
    public boolean alterarLeitores(ModelLeitoresVO leitor) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "UPDATE Leitores SET Nome=?, NomeSocial=?, Sexo=?, Nascimento=?, Matricula= ?,"
                    + "Turma=?, Turno=?, Cadastro=?, Pai=?, Mae=?, Identidade=?, CPF=?, Telefone=?,"
                    + "Email=?, Endereco=?, Bairro=?, Cidade=?, Estado=?, Referencia=?, Observacoes=? WHERE id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, leitor.getNome());
            pstm.setString(2, leitor.getNomeSocial());           
            pstm.setString(3, leitor.getSexo());           
            pstm.setString(4, leitor.getNascimento());           
            pstm.setString(5, leitor.getMatricula());           
            pstm.setInt(6, leitor.getTurma());           
            pstm.setString(7, leitor.getTurno());           
            pstm.setString(8, leitor.getCadastro());           
            pstm.setString(9, leitor.getPai());           
            pstm.setString(10, leitor.getMae());           
            pstm.setString(11, leitor.getIdentidade());           
            pstm.setString(12, leitor.getCPF());           
            pstm.setString(13, leitor.getTelefone());           
            pstm.setString(14, leitor.getEmail());           
            pstm.setString(15, leitor.getEndereco());           
            pstm.setString(16, leitor.getBairro());           
            pstm.setString(17, leitor.getCidade());           
            pstm.setString(18, leitor.getEstado());           
            pstm.setString(19, leitor.getReferencia());           
            pstm.setString(20, leitor.getObservacoes());                       
            pstm.setInt(21, leitor.getId());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, excluindo registros em Leitores,
     * chamado pelo AbstractTableModel
     *
     * @param leitor os dados a serem excluidos no registro para Leitores
     * @return Retorna true se conseguiu excluir o registro e false caso dê
     * algum problema
     */
    public boolean excluirLeitores(ModelLeitoresVO leitor) {
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "DELETE FROM Leitores WHERE Id = ?";
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, leitor.getId());
            pstm.execute();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Método responsável pelo acesso a dados, listando os registros de Leitores,
     * para um ArrayList para ser carregado no AbstractTableModel
     *
     * @return listaRetorno Retorna um ArrayList com os registros de Leitores.
     */
    public List<ModelLeitoresVO> listarLeitores() {
        List<ModelLeitoresVO> listaRetorno = new ArrayList<ModelLeitoresVO>();
        try {
            Connection conn = CriarConexao.abrirConexao();
            String SQL = "SELECT * FROM Leitores";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(SQL);
            while (rs.next()) {
                //Instancia um novo objeto
                ModelLeitoresVO mlvo = new ModelLeitoresVO();
                mlvo.setId(rs.getInt("Id"));
                mlvo.setNome(rs.getString("Nome"));
                mlvo.setNomeSocial(rs.getString("NomeSocial"));                
                mlvo.setSexo(rs.getString("Sexo"));                                
                mlvo.setNascimento(rs.getString("Nascimento"));                
                mlvo.setMatricula(rs.getString("Matricula"));                
                mlvo.setTurma(rs.getInt("Turma"));                
                mlvo.setTurno(rs.getString("Turno"));                
                mlvo.setCadastro(rs.getString("Cadastro"));                
                mlvo.setPai(rs.getString("Pai"));
                mlvo.setMae(rs.getString("Mae"));
                mlvo.setIdentidade(rs.getString("Identidade"));
                mlvo.setCPF(rs.getString("CPF"));
                mlvo.setTelefone(rs.getString("Telefone"));
                mlvo.setEmail(rs.getString("Email"));
                mlvo.setEndereco(rs.getString("Endereco"));    
                mlvo.setBairro(rs.getString("Bairro"));
                mlvo.setCidade(rs.getString("Cidade"));
                mlvo.setEstado(rs.getString("Estado"));
                mlvo.setReferencia(rs.getString("Referencia"));
                mlvo.setObservacoes(rs.getString("Observacoes"));
                listaRetorno.add(mlvo);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return listaRetorno;
    }
}
