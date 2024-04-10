package Project_102873_125511_120441_aed2_lp2_202324;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Artigo{
  private String titulo;
  private ArrayList<Autor> autores;
  private Integer keyWords;
  private String Abstract;
  private int ano;
  private int numDownloads;
  private int numViews;
  private int numLikes;
  private Publicacao pub;
  private ArrayList<Publicacao> referencias;
  private List<Autor> autor;

  public Artigo() {
  }

  public Artigo(String titulo, ArrayList<Autor> autores, Integer keyWords, String anAbstract, int ano, int numDownloads, int numViews, int numLikes, Publicacao pub, ArrayList<Publicacao> referencias, List<Autor> autor) {
    this.titulo = titulo;
    this.autores = autores;
    this.keyWords = keyWords;
    Abstract = anAbstract;
    this.ano = ano;
    this.numDownloads = numDownloads;
    this.numViews = numViews;
    this.numLikes = numLikes;
    this.pub = pub;
    this.referencias = referencias;
    this.autor = autor;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public ArrayList<Autor> getAutores() {
    return autores;
  }

  public void setAutores(ArrayList<Autor> autores) {
    this.autores = autores;
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

  public ArrayList<Publicacao> getReferencias() {
    return referencias;
  }

  public void setReferencias(ArrayList<Publicacao> referencias) {
    this.referencias = referencias;
  }

  public List<Autor> getAutor() {
    return autor;
  }

  public void setAutor(List<Autor> autor) {
    this.autor = autor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Artigo artigo)) return false;
      return ano == artigo.ano && numDownloads == artigo.numDownloads && numViews == artigo.numViews && numLikes == artigo.numLikes && Objects.equals(titulo, artigo.titulo) && Objects.equals(autores, artigo.autores) && Objects.equals(keyWords, artigo.keyWords) && Objects.equals(Abstract, artigo.Abstract) && Objects.equals(pub, artigo.pub) && Objects.equals(referencias, artigo.referencias) && Objects.equals(autor, artigo.autor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(titulo, autores, keyWords, Abstract, ano, numDownloads, numViews, numLikes, pub, referencias, autor);
  }

  @Override
  public String toString() {
    return "Artigo{" +
            "titulo='" + titulo + '\'' +
            ", autores=" + autores +
            ", keyWords=" + keyWords +
            ", Abstract='" + Abstract + '\'' +
            ", ano=" + ano +
            ", numDownloads=" + numDownloads +
            ", numViews=" + numViews +
            ", numLikes=" + numLikes +
            ", pub=" + pub +
            ", referencias=" + referencias +
            ", autor=" + autor +
            '}';
  }

  public void publicaConferencia(Artigo artigo, int ano, int numeroEdicao, String local) {
  }
  public void publicaJournal(Artigo artigo, int ano, String publisher) {
  }

}

