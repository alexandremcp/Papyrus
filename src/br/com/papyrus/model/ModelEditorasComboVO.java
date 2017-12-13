/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.papyrus.model;

/**
 * Classe que cria os Values Objects, varáveis e métodos de acesso, além dos
 * construtores com seus Get e Set.
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelEditorasComboVO {

    private int idCombo;
    private String nomeCombo;
    private String localizacaoCombo;

    public ModelEditorasComboVO(int id, String nome, String localizacao) {
        this.idCombo = id;
        this.nomeCombo = nome;
        this.localizacaoCombo = localizacao;
    }

    public ModelEditorasComboVO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }

    public String getNomeCombo() {
        return nomeCombo;
    }

    public void setNomeCombo(String nomeCombo) {
        this.nomeCombo = nomeCombo;
    }

    public String getLocalizacaoCombo() {
        return localizacaoCombo;
    }

    public void setLocalizacaoCombo(String localizacaoCombo) {
        this.localizacaoCombo = localizacaoCombo;
    }

   
}
