package Project_102873_125511_120441_aed2_lp2_202324;

import java.util.Objects;

public class PubJournal extends Publicacao {

  private String nome;

  public PubJournal(String nome, String publisher, int ano, String periodicidade, double jcrIF, double scopusIF) {
    super(nome, publisher, ano, periodicidade, jcrIF, scopusIF);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String toString() {
    return "PubJournal{" +
            "nome='" + nome + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PubJournal that)) return false;
    if (!super.equals(o)) return false;
      return Objects.equals(nome, that.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), nome);
  }

  public void publicarJournal(Artigo artigo, int ano, String publisher) {
  }

}