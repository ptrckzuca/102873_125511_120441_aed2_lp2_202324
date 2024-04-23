package Project_102873_125511_120441_aed2_lp2_202324;

public class PubJournal extends Publication {

  private double jcrIF;
  private double scopusIF;
  private String periodicidade;
  private int volume;
  private int series;


  public PubJournal(String publisher, int ano, String nome, double jcrIF, double scopusIF, String periodicidade, int volume, int series) {
    super(publisher, ano, nome);
    this.jcrIF = jcrIF;
    this.scopusIF = scopusIF;
    this.periodicidade = periodicidade;
    this.volume = volume;
    this.series = series;
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

  public String getPeriodicidade() {
    return periodicidade;
  }

  public void setPeriodicidade(String periodicidade) {
    this.periodicidade = periodicidade;
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  public int getSeries() {
    return series;
  }

  public void setSeries(int series) {
    this.series = series;
  }

  public void publicarJournal(Article article, int ano, String publisher) {
  }
}