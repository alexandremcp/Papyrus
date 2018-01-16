package br.com.papyrus.model;

/**
 * Classe que cria os Values Objects, varáveis e métodos de acesso, além dos
 * construtores com seus Get e Set.
 *
 * @author Alexandre Luiz dos Santos
 */
public class ModelDevolucoesVO {

    private int Leitores_Id;
    private int Acervo_Id;
    private String Emprestimo;
    private int IdLeitores;
    private String NomeLeitores;
    private int IdAcervo;
    private String TituloAcervo;
    private String SubTituloAcervo;
    private int ExemplarAcervo;
    private String EdicaoAcervo;
    private int VolumeAcervo;
    private String LocalAcervo;
    private String DisponivelAcervo;
    private int IdTipos;
    private int DiasTipos;
    private String Devolucao;       //Campo calculado (emprestimos.Emprestimo + tipos.Dias)
    private int Autores_Id;
    private String AutorNome;

    public int getAutores_Id() {
        return Autores_Id;
    }

    public void setAutores_Id(int Autores_Id) {
        this.Autores_Id = Autores_Id;
    }

    public String getAutorNome() {
        return AutorNome;
    }

    public void setAutorNome(String AutorNome) {
        this.AutorNome = AutorNome;
    }

    public int getLeitores_Id() {
        return Leitores_Id;
    }

    public void setLeitores_Id(int Leitores_Id) {
        this.Leitores_Id = Leitores_Id;
    }

    public int getAcervo_Id() {
        return Acervo_Id;
    }

    public void setAcervo_Id(int Acervo_Id) {
        this.Acervo_Id = Acervo_Id;
    }

    public String getEmprestimo() {
        return Emprestimo;
    }

    public void setEmprestimo(String Emprestimo) {
        this.Emprestimo = Emprestimo;
    }

    public int getIdLeitores() {
        return IdLeitores;
    }

    public void setIdLeitores(int IdLeitores) {
        this.IdLeitores = IdLeitores;
    }

    public String getNomeLeitores() {
        return NomeLeitores;
    }

    public void setNomeLeitores(String NomeLeitores) {
        this.NomeLeitores = NomeLeitores;
    }

    public int getIdAcervo() {
        return IdAcervo;
    }

    public void setIdAcervo(int IdAcervo) {
        this.IdAcervo = IdAcervo;
    }

    public String getTituloAcervo() {
        return TituloAcervo;
    }

    public void setTituloAcervo(String TituloAcervo) {
        this.TituloAcervo = TituloAcervo;
    }

    public String getSubTituloAcervo() {
        return SubTituloAcervo;
    }

    public void setSubTituloAcervo(String SubTituloAcervo) {
        this.SubTituloAcervo = SubTituloAcervo;
    }

    public int getExemplarAcervo() {
        return ExemplarAcervo;
    }

    public void setExemplarAcervo(int ExemplarAcervo) {
        this.ExemplarAcervo = ExemplarAcervo;
    }

    public String getEdicaoAcervo() {
        return EdicaoAcervo;
    }

    public void setEdicaoAcervo(String EdicaoAcervo) {
        this.EdicaoAcervo = EdicaoAcervo;
    }

    public int getVolumeAcervo() {
        return VolumeAcervo;
    }

    public void setVolumeAcervo(int VolumeAcervo) {
        this.VolumeAcervo = VolumeAcervo;
    }

    public String getLocalAcervo() {
        return LocalAcervo;
    }

    public void setLocalAcervo(String LocalAcervo) {
        this.LocalAcervo = LocalAcervo;
    }

    public String getDisponivelAcervo() {
        return DisponivelAcervo;
    }

    public void setDisponivelAcervo(String DisponivelAcervo) {
        this.DisponivelAcervo = DisponivelAcervo;
    }

    public int getIdTipos() {
        return IdTipos;
    }

    public void setIdTipos(int IdTipos) {
        this.IdTipos = IdTipos;
    }

    public int getDiasTipos() {
        return DiasTipos;
    }

    public void setDiasTipos(int DiasTipos) {
        this.DiasTipos = DiasTipos;
    }

    public String getDevolucao() {
        return Devolucao;
    }

    public void setDevolucao(String Devolucao) {
        this.Devolucao = Devolucao;
    }
}
