package Project_102873_125511_120441_aed2_lp2_202324;


import java.util.Date;

public class PubConference extends Publication {

  private Date dataInicio;
  private Date dataFim;
  private String local;

  public PubConference(String publisher, int ano, String nome, Date dataInicio, Date dataFim, String local) {
    super(publisher, ano, nome);
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.local = local;
  }

  public Date getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public Date getDataFim() {
    return dataFim;
  }

  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public void publicarConferencia(Article article, int ano, int numeroEdicao, String local) {
  }
}