package Project_102873_125511_120441_aed2_lp2_202324;

public interface DBManageArticlesI {
    public Article addArticle(Article article);
    public Article getArticle(String titulo);
    public Article removeArticle(Article article);
    public void archiveArticle(String data);
    public void listArticleStats(Article article);
    public void listArticles();

}
