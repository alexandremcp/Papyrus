/*
 * Definindo Get e Set para "Editoras"
 */
package br.com.papyrus.model;

/**
 * Classe que cria os Values Objects, varáveis e métodos de acesso, além dos
 * construtores com seus Get e Set.
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelTiposVO {

    private int id;
    private String nome;
    private int dias;

    public ModelTiposVO() {
    }

    public ModelTiposVO(int id, String nome, int dias) {
        this.id = id;
        this.nome = nome;
        this.dias = dias;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }
}
