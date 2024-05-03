package Project_102873_125511_120441_aed2_lp2_202324;

import edu.ufp.inf.lp2.p01_intro.Date;
import edu.ufp.inf.lp2.p01_intro.Person;

import java.util.Objects;

public class Author extends Person  {

  private String orcid;
  private int CienciaID;
  private String filiacao;
  private int GoogleScholarID;
  private String nomeCientifico;
  private String email;

  public Author() {
  }

  public Author(String idNumber, String name, String address, Date birth, String email, String orcid, String filiacao, int cienciaID, int googleScholarID, String nomeCientifico) {
    super(idNumber, name, address, birth);
    this.email = email;
    this.orcid = orcid;
    this.filiacao = filiacao;
    CienciaID = cienciaID;
    GoogleScholarID = googleScholarID;
    this.nomeCientifico = nomeCientifico;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
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
    return "Author{" + super.toString() +
            "orcid='" + orcid + '\'' +
            ", filiacao='" + filiacao + '\'' +
            ", CienciaID=" + CienciaID +
            ", GoogleScholarID=" + GoogleScholarID +
            ", nomeCientifico='" + nomeCientifico + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Author author)) return false;
    if (!super.equals(o)) return false;
      return CienciaID == author.CienciaID && GoogleScholarID == author.GoogleScholarID && Objects.equals(orcid, author.orcid) && Objects.equals(filiacao, author.filiacao) && Objects.equals(nomeCientifico, author.nomeCientifico) && Objects.equals(email, author.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), orcid, filiacao, CienciaID, GoogleScholarID, nomeCientifico, email);
  }
}