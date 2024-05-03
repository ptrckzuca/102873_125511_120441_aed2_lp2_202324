package Project_102873_125511_120441_aed2_lp2_202324;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;
import Project_102873_125511_120441_aed2_lp2_202324.Author;
import edu.ufp.inf.lp2.p01_intro.Date;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;



public class DB implements DBManageAuthorsI, DBManageArticlesI, DBManagePublicationsI{
    private ST<Integer, Author> authors;
    private ArrayList<Author> authorsList = new ArrayList<>();
    private ST<String, Article> articles;
    private ArrayList<Publication> publications;
    private RedBlackBST <Integer, Article> articlesByYear;



    public DB() {
        articlesByYear = new RedBlackBST<>();

        authors = new ST<>();
        Author author = new Author();

        articles = new ST<>();
        Article article = new Article();

        publications = new ArrayList<>();

        Author a1 = new Author("12", "Joao Castro Silva", "Rua Santo Antonio", new Date((short) 12, (short) 6, 1973), "  joaosilva@gmail.com  ", "10", "EXECX", 1, 1, "Joao Silva");
        Author a2 = new Author("27", "Jose Fernandes Tomas", "Praça dos Combatentes", new Date((short) 9, (short) 12, 1994), "  josefernandes@gmail.com  ", "20", "LAB33", 2, 1, "Jose Fernandes");
        Author a3 = new Author("35", "Diogo da Costa Cunha", "Avenida dos Naufragos", new Date((short) 3, (short) 3, 1985), "  diogocunha32@gmail.com  ", "30", "FL45", 3, 1, "Diogo Cunha");
        Author a4 = new Author("42", "Filipe Moreira Santos", "Rua das Pedrinhas ", new Date((short) 4, (short) 7, 1964), "  filipesantos2@gmail.com  ", "40", "AR14", 4, 1, "Filipe Santos");
        Author a5 = new Author("56", "Lucas Alberto Cardoso", "Praceta dos Pescadores do Ultramar", new Date((short) 30, (short) 5, 1980), "  lucasalberto@hotmail.com  ", "50", "JJUR", 5, 1, "Lucas Alberto");

        addAuthor(a1);
        addAuthor(a2);
        addAuthor(a3);
        addAuthor(a4);
        addAuthor(a5);

        Publication conference1 = new PubConference("IEEE", 2023, "IEEE Computer Vision and Pattern Recognition", new Date((short) 18, (short) 6, 2023), new Date((short) 22, (short) 6, 2023), "Vancouver");
        Publication conference2 = new PubConference("Springer", 2024, "European Conference on Computer Vision", new Date((short) 29, (short) 9, 2024), new Date((short) 4, (short) 10, 2024), "Milan");
        Publication journal1 = new PubJournal("IEEE", 2024, "IEEE Transactions on Pattern Analysis and Machine Intelligence", 1.2, 1.3, "Monthly", 3, 8);
        Publication journal2 = new PubJournal("ELSEVIER", 2024, "Future Generation Computer Systems", 1.9, 1.6, "Bimonthly", 2, 5);

        addPublication(conference1);
        addPublication(conference2);
        addPublication(journal1);
        addPublication(journal2);

        Article article1 = new Article("Artigo 1", 45, "Abstract 1", 2018, 2355, 34553, 13897, journal1, null, null);
        Article article2 = new Article("Artigo 2", 20, "Abstract 2", 2024, 5544, 67432, 19087, journal2, null, null);
        Article article3 = new Article("Artigo 3", 33, "Abstract 3", 2009, 10008, 102234, 35648, conference1, null, null);
        Article article4 = new Article("Artigo 4", 17, "Abstract 4", 2020, 456, 7895, 1263, conference2, null, null);
        Article article5 = new Article("Artigo 5", 23, "Abstract 5", 2014, 7815, 40325, 12622, journal1, null, null);
        Article article6 = new Article("Artigo 6", 11, "Abstract 6", 2003, 784, 11462, 3417, conference2, null, null);

        addArticle(article1);
        addArticle(article2);
        addArticle(article3);
        addArticle(article4);
        addArticle(article5);
        addArticle(article6);

    }

    public void put(int key, Article article) {
        articlesByYear.put(key, article);
    }

    public Author addAuthor(Author author) {
        authors.put(author.getCienciaID(), author);
        return author;
    }

    public Author getAuthor(int cienciaID) {
        return authors.get(cienciaID);
    }
    public void archiveAuthor(String data) {

        try (FileWriter writer = new FileWriter("authorArchive.txt", true)) {
            writer.write(data + "\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing author name to file ");
        }
    }
    public Author removeAuthor(Author author) {
        archiveAuthor(author.toString());
        authors.delete(author.getCienciaID());
        return author;
    }


    public Author listAuthors() {
        for (Integer key : authors.keys()) {
            System.out.println(authors.get(key));
        }
        return null;
    }

    public Article addArticle(Article article) {
        articles.put(article.getTitulo(), article);
        return article;
    }
    public Article getArticle(String titulo) {
        return articles.get(titulo);
    }

    public void archiveArticle(String data) {

        try (FileWriter writer = new FileWriter("articleArchive.txt", true)) {
            writer.write(data + "\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing article name to file ");
        }
    }
    public Article removeArticle(Article article) {
        archiveArticle(article.toString());
        articles.delete(article.getTitulo());
        return article;
    }

    public void listArticleStats(Article article) {
        System.out.println("Article: " + article.getTitulo());
        System.out.println("Number of Downloads: " + article.getNumDownloads());
        System.out.println("Number of Views: " + article.getNumViews());
        System.out.println("Number of Likes: " + article.getNumLikes());
    }
    public Article listArticles() {
        for (String key : articles.keys()) {
            System.out.println(articles.get(key));
        }
        return null;
    }


    public Publication addPublication(Publication publication) {
        publications.add(publication);
        return publication;
    }

    public void archivePublication(String data) {

        try (FileWriter writer = new FileWriter("publicationArchive.txt", true)) {
            writer.write(data + "\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Error writing publication name to file ");
        }
    }
    public Publication removePublication(Publication publication) {
        archivePublication(publication.toString());
        publications.remove(publication);
        return publication;
    }

    public Publication listPublications() {
        for (Publication publication : publications) {
            System.out.println(publication.toString());
        }
        return null;
    }

    public void insertArticleByYear(Article article) {
        int key = article.getAno();
        put(key, article);
    }
    static void testAuthor (DB db){
        db.listAuthors();
        println("");
        db.removeAuthor(db.getAuthor(1));
        db.listAuthors();

    }

    static void testPublication (DB db){

        db.listPublications();
        db.removePublication(db.publications.get(0));
        println("");
        db.listPublications();
    }

    static void testArticle (DB db){
        db.listArticles();
        db.removeArticle(db.articles.get("Artigo 1"));
        println("");
        db.listArticles();

        db.listArticleStats(db.articles.get("Artigo 2"));

    }

    static void testSearchArticlePerPeriod(DB db){

        db.insertArticleByYear(db.articles.get("Artigo 1"));
        db.insertArticleByYear(db.articles.get("Artigo 2"));
        db.insertArticleByYear(db.articles.get("Artigo 3"));
        db.insertArticleByYear(db.articles.get("Artigo 4"));
        db.insertArticleByYear(db.articles.get("Artigo 5"));
        db.insertArticleByYear(db.articles.get("Artigo 6"));

        for (Integer key : db.articlesByYear.keys()) {
            System.out.println(key + " " + db.articlesByYear.get(key));
        }


    }



    public static void main(String[] args) {
        DB db = new DB();

        //testAuthor(db);
        //testArticle(db);
        //testPublication(db);
        testSearchArticlePerPeriod(db);
    }

}