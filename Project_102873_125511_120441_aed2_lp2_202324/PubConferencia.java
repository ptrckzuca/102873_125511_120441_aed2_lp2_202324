package Project_102873_125511_120441_aed2_lp2_202324;

import java.util.Objects;

public class PubConferencia extends Publicacao {

  private String nome;

  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }


  public PubConferencia(String nome, String publisher, int ano, String periodicidade, double jcrIF, double scopusIF) {
    super(nome, publisher, ano, periodicidade, jcrIF, scopusIF);
  }


  @Override
  public String toString() {
    return "PubConferencia{" +
            "nome='" + nome + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PubConferencia that)) return false;
    if (!super.equals(o)) return false;
      return Objects.equals(nome, that.nome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), nome);
  }

  public void publicarConferencia(Artigo artigo, int ano, int numeroEdicao, String local) {

  }
}