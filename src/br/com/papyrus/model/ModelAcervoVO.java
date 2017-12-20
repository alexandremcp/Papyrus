/*
 * Definindo Get e Set para "Autores"
 */
package br.com.papyrus.model;

/**
 * Classe que cria os Values Objects, varáveis e métodos de acesso, além dos
 * construtores com seus Get e Set.
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelAcervoVO {

    private int Id;
    private String Titulo;
    private String SubTitulo;
    private String Serie;
    private String Idioma;
    private int Exemplar;
    private String Edicao;
    private int Paginas;
    private int Volume;
    private int Ano;
    private String Aquisicao;
    private String Local;
    private int Editoras_Id;
    private int Classificacao_Id;
    private int Tipos_Id;
    private String Tombo;
    private String CDU;
    private String CDD;
    private String CUTTER;
    private String ISBN;
    private String Observacoes;
    private String Disponivel;

    private String NomeEditoras;        //Vem da tabela editoras
    private String NomeClassificacoes;  //Vem da tabela classificacoes
    private String NomeTipos;           //Vem da tabela tipos

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getSubTitulo() {
        return SubTitulo;
    }

    public void setSubTitulo(String SubTitulo) {
        this.SubTitulo = SubTitulo;
    }

    public String getSerie() {
        return Serie;
    }

    public void setSerie(String Serie) {
        this.Serie = Serie;
    }

    public int getExemplar() {
        return Exemplar;
    }

    public void setExemplar(int Exemplar) {
        this.Exemplar = Exemplar;
    }

    public String getEdicao() {
        return Edicao;
    }

    public void setEdicao(String Edicao) {
        this.Edicao = Edicao;
    }

    public int getPaginas() {
        return Paginas;
    }

    public void setPaginas(int Paginas) {
        this.Paginas = Paginas;
    }

    public int getVolume() {
        return Volume;
    }

    public void setVolume(int Volume) {
        this.Volume = Volume;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int Ano) {
        this.Ano = Ano;
    }

    public String getAquisicao() {
        return Aquisicao;
    }

    public void setAquisicao(String Aquisicao) {
        this.Aquisicao = Aquisicao;
    }

    public String getLocal() {
        return Local;
    }

    public void setLocal(String Local) {
        this.Local = Local;
    }

    public String getTombo() {
        return Tombo;
    }

    public void setTombo(String Tombo) {
        this.Tombo = Tombo;
    }

    public String getCDU() {
        return CDU;
    }

    public void setCDU(String CDU) {
        this.CDU = CDU;
    }

    public String getCDD() {
        return CDD;
    }

    public void setCDD(String CDD) {
        this.CDD = CDD;
    }

    public String getCUTTER() {
        return CUTTER;
    }

    public void setCUTTER(String CUTTER) {
        this.CUTTER = CUTTER;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getIdioma() {
        return Idioma;
    }

    public void setIdioma(String Idioma) {
        this.Idioma = Idioma;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }

    public String getDisponivel() {
        return Disponivel;
    }

    public void setDisponivel(String Disponivel) {
        this.Disponivel = Disponivel;
    }

    public int getTipos_Id() {
        return Tipos_Id;
    }

    public void setTipos_Id(int Tipos_Id) {
        this.Tipos_Id = Tipos_Id;
    }

    public int getEditoras_Id() {
        return Editoras_Id;
    }

    public void setEditoras_Id(int Editoras_Id) {
        this.Editoras_Id = Editoras_Id;
    }

    public int getClassificacao_Id() {
        return Classificacao_Id;
    }

    public void setClassificacao_Id(int Classificacao_Id) {
        this.Classificacao_Id = Classificacao_Id;
    }

    public String getNomeClassificacoes() {
        return NomeClassificacoes;
    }

    public void setNomeClassificacoes(String NomeClassificacoes) {
        this.NomeClassificacoes = NomeClassificacoes;
    }

    public String getNomeTipos() {
        return NomeTipos;
    }

    public void setNomeTipos(String NomeTipos) {
        this.NomeTipos = NomeTipos;
    }

    public String getNomeEditoras() {
        return NomeEditoras;
    }

    public void setNomeEditoras(String NomeEditoras) {
        this.NomeEditoras = NomeEditoras;
    }

}
