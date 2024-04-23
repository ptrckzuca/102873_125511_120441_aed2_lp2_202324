package Project_102873_125511_120441_aed2_lp2_202324;


public class Publication {

  private String publisher;
  private int ano;
  private String nome;

  public Publication() {

  }
  public Publication(String publisher, int ano, String nome) {
    this.publisher = publisher;
    this.ano = ano;
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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}