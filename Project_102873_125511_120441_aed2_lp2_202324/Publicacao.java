package Project_102873_125511_120441_aed2_lp2_202324;

import java.util.Objects;

public class Publicacao {

  private String nome;

  private String publisher;

  private int ano;

  private String periodicidade;

  private double jcrIF;

  private double scopusIF;

  public Publicacao() {
  }

  public Publicacao(String nome, String publisher, int ano, String periodicidade, double jcrIF, double scopusIF) {
    this.nome = nome;
    this.publisher = publisher;
    this.ano = ano;
    this.periodicidade = periodicidade;
    this.jcrIF = jcrIF;
    this.scopusIF = scopusIF;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public int getAno() {
    return ano;
  }

  public void setAno(int ano) {
    this.ano = ano;
  }

  public String getPeriodicidade() {
    return periodicidade;
  }

  public void setPeriodicidade(String periodicidade) {
    this.periodicidade = periodicidade;
  }

  public double getJcrIF() {
    return jcrIF;
  }

  public void setJcrIF(double jcrIF) {
    this.jcrIF = jcrIF;
  }

  public double getScopusIF() {
    return scopusIF;
  }

  public void setScopusIF(double scopusIF) {
    this.scopusIF = scopusIF;
  }

  @Override
  public String toString() {
    return "Publicacao{" +
            "nome='" + nome + '\'' +
            ", publisher='" + publisher + '\'' +
            ", ano=" + ano +
            ", periodicidade='" + periodicidade + '\'' +
            ", jcrIF=" + jcrIF +
            ", scopusIF=" + scopusIF +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Publicacao that)) return false;
      return ano == that.ano && Double.compare(jcrIF, that.jcrIF) == 0 && Double.compare(scopusIF, that.scopusIF) == 0 && Objects.equals(nome, that.nome) && Objects.equals(publisher, that.publisher) && Objects.equals(periodicidade, that.periodicidade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, publisher, ano, periodicidade, jcrIF, scopusIF);
  }
}