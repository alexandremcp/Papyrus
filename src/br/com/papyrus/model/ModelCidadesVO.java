package br.com.papyrus.model;

/**
 *
 * @author Alexandre
 */
public class ModelCidadesVO {

    private int Id;
    private String Pais;
    private String Estado;
    private String Cidade;

    public ModelCidadesVO(int Id, String Pais, String Estado, String Cidade) {
        this.Id = Id;
        this.Pais = Pais;
        this.Estado = Estado;
        this.Cidade = Cidade;
    }

    public ModelCidadesVO() {
    }
    
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }
}
