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
public class ModelEditorasVO {

    private int id;
    private String nome;
    private String localizacao;

    public ModelEditorasVO() {
    }

    public ModelEditorasVO(int id, String nome) {
        this.id = id;
        this.nome = nome;
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

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
