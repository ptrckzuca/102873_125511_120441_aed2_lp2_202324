package Project_102873_125511_120441_aed2_lp2_202324;

import java.util.Objects;

public class Autor {

  private String nome;
  private String orcid;
  private String filiacao;
  private int CienciaID;
  private int GoogleScholarID;
  private String nomeCientifico;

  public Autor() {
  }

  public Autor(String nome, String orcid, String filiacao, int cienciaID, int googleScholarID, String nomeCientifico) {
    this.nome = nome;
    this.orcid = orcid;
    this.filiacao = filiacao;
    CienciaID = cienciaID;
    GoogleScholarID = googleScholarID;
    this.nomeCientifico = nomeCientifico;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getOrcid() {
    return orcid;
  }

  public void setOrcid(String orcid) {
    this.orcid = orcid;
  }

  public String getFiliacao() {
    return filiacao;
  }

  public void setFiliacao(String filiacao) {
    this.filiacao = filiacao;
  }

  public int getCienciaID() {
    return CienciaID;
  }

  public void setCienciaID(int cienciaID) {
    CienciaID = cienciaID;
  }

  public int getGoogleScholarID() {
    return GoogleScholarID;
  }

  public void setGoogleScholarID(int googleScholarID) {
    GoogleScholarID = googleScholarID;
  }

  public String getNomeCientifico() {
    return nomeCientifico;
  }

  public void setNomeCientifico(String nomeCientifico) {
    this.nomeCientifico = nomeCientifico;
  }

  @Override
  public String toString() {
    return "Autor{" +
            "nome='" + nome + '\'' +
            ", orcid='" + orcid + '\'' +
            ", filiacao='" + filiacao + '\'' +
            ", CienciaID=" + CienciaID +
            ", GoogleScholarID=" + GoogleScholarID +
            ", nomeCientifico='" + nomeCientifico + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Autor autor)) return false;
      return CienciaID == autor.CienciaID && GoogleScholarID == autor.GoogleScholarID && Objects.equals(nome, autor.nome) && Objects.equals(orcid, autor.orcid) && Objects.equals(filiacao, autor.filiacao) && Objects.equals(nomeCientifico, autor.nomeCientifico);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, orcid, filiacao, CienciaID, GoogleScholarID, nomeCientifico);
  }
}



