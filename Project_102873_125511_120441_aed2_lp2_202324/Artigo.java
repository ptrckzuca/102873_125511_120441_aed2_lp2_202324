package Project_102873_125511_120441_aed2_lp2_202324;


import java.util.ArrayList;

public class Artigo {

    private String titulo;
    private Integer keyWords;
    private String Abstract;
    private int ano;
    private int numDownloads;
    private int numViews;
    private int numLikes;
    private Publicacao pub;
    private ArrayList<Artigo> referencias;
    private ArrayList<Author> autores;

    public Artigo() {
    }
    public Artigo(String titulo, Integer keyWords, String anAbstract, int ano, int numDownloads, int numViews, int numLikes, Publicacao pub, ArrayList<Artigo> referencias, ArrayList<Author> autores) {
        this.titulo = titulo;
        this.keyWords = keyWords;
        Abstract = anAbstract;
        this.ano = ano;
        this.numDownloads = numDownloads;
        this.numViews = numViews;
        this.numLikes = numLikes;
        this.pub = pub;
        this.referencias = referencias;
        this.autores = autores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(Integer keyWords) {
        this.keyWords = keyWords;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getNumDownloads() {
        return numDownloads;
    }

    public void setNumDownloads(int numDownloads) {
        this.numDownloads = numDownloads;
    }

    public int getNumViews() {
        return numViews;
    }

    public void setNumViews(int numViews) {
        this.numViews = numViews;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public Publicacao getPub() {
        return pub;
    }

    public void setPub(Publicacao pub) {
        this.pub = pub;
    }

    public ArrayList<Artigo> getReferencias() {
        return referencias;
    }

    public void setReferencias(ArrayList<Artigo> referencias) {
        this.referencias = referencias;
    }

    public ArrayList<Author> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Author> autores) {
        this.autores = autores;
    }
}