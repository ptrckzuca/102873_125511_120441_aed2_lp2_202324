package Project_102873_125511_120441_aed2_lp2_202324;


import java.util.ArrayList;

public class Article{

    private int ArticleID;
    private String titulo;
    private int keyWords;
    private String Abstract;
    private int ano;
    private int numDownloads;
    private int numViews;
    private int numLikes;
    private Publication pub;
    private ArrayList<Author> autores;

    public Article() {

    }
    public Article(int articleID, String titulo, Integer keyWords, String anAbstract, int ano, int numDownloads, int numViews, int numLikes, Publication pub, ArrayList<Author> autores) {
        this.ArticleID = articleID;
        this.titulo = titulo;
        this.keyWords = keyWords;
        this.Abstract = anAbstract;
        this.ano = ano;
        this.numDownloads = numDownloads;
        this.numViews = numViews;
        this.numLikes = numLikes;
        this.pub = pub;
        //this.referencias = referencias;
        this.autores = autores;
    }

    public Article(int id, String title) {
        this.ArticleID = id;
        this.titulo = title;
    }

    public int getArticleId() {
        return ArticleID;
    }

    public void setArticleID(int articleID) {
        this.ArticleID = ArticleID;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(int keyWords) {
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

    public Publication getPub() {
        return pub;
    }

    public void setPub(Publication pub) {
        this.pub = pub;
    }

    public ArrayList<Author> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Author> autores) {
        this.autores = autores;
    }

    public void addAutor(Author a){
        this.autores.add(a);
    }

    public void removeAutor(Author a){
        this.autores.remove(a);
    }
    public void searchAutor(Author a){
        this.autores.contains(a);
    }


    @Override
    public String toString() {
        return "Article{" +
                "titulo='" + titulo + '\'' +
                ", keyWords=" + keyWords +
                ", Abstract='" + Abstract + '\'' +
                ", ano=" + ano +
                ", numDownloads=" + numDownloads +
                ", numViews=" + numViews +
                ", numLikes=" + numLikes +
                ", pub=" + pub +
                //", referencias=" + referencias +
                ", autores=" + autores +
                '}';
    }
}