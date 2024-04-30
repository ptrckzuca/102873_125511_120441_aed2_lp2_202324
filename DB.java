package Project_102873_125511_120441_aed2_lp2_202324;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;

import static java.sql.DriverManager.println;
import static java.util.Collections.min;

public class DB implements DBManageAuthorsI, DBManageArticlesI {
    private ST<Integer, Author> authors;
    private ST<String, Article> articles;

    private ArrayList<Publication> publications = new ArrayList<>();


    public DB() {
        authors = new ST<>();
        Author author = new Author();

        articles = new ST<>();
        Article article = new Article();


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
    public Article removeArticle(Article article) {
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


    public void addPublication(Publication publication) {
        publications.add(publication);
    }


    public void removePublication(Publication publication) {
        publications.remove(publication);
    }

    public void listPublications() {
        for (Publication publication : publications) {
            System.out.println(publication.toString());
        }
    }
    public void searchArticlesByAuthor(Author author, Date startDate, Date endDate) {
        for (String key : articles.keys()) {
            Article article = articles.get(key);
            if (article.getAno() >= startDate.getYear() && article.getAno() <= endDate.getYear()) {
                for (Author a : article.getAutores()) {
                    if (a.equals(author)) {
                        System.out.println(article);
                    }
                }
            }
        }
    }

    public void searchArticlesByDownloadsViews(Date startDate, Date endDate) {
        for (String key : articles.keys()) {
            Article article = articles.get(key);
            if (article.getAno() >= startDate.getYear() && article.getAno() <= endDate.getYear()) {
                if (article.getNumDownloads() == 0 || article.getNumViews() == 0) {
                    System.out.println(article);
                }
            }
        }
    }

    public void searchAuthorsByCitedArticles(ArrayList<Article> articles, Date startDate, Date endDate) {
        for (Integer key : authors.keys()) {
            Author author = authors.get(key);
            for (Article article : articles) {
                if (article.getAno() >= startDate.getYear() && article.getAno() <= endDate.getYear()) {
                    if (author.getNomeCientifico().contains(article.getTitulo()) || author.getNomeCientifico().contains(article.getAbstract())){
                        System.out.println(author);
                    }
                }
            }
        }
    }

    public void searchTop3Articles(Date startDate, Date endDate) {
        ArrayList<Article> top3 = new ArrayList<>();
        for (String key : articles.keys()) {
            Article article = articles.get(key);
            if (article.getAno() >= startDate.getYear() && article.getAno() <= endDate.getYear()) {
                if (top3.size() < 3) {
                    top3.add(article);
                } else {
                    for (Article a : top3) {
                        if (article.getNumDownloads() > a.getNumDownloads()) {
                            top3.remove(a);
                            top3.add(article);
                            break;
                        }
                    }
                }
            }
        }
        for (Article article : top3) {
            System.out.println(article);
        }
    }

    public void searchCitationsByJournal(PubJournal journal, Date startDate, Date endDate) {
        for (String key : articles.keys()) {
            Article article = articles.get(key);
            if (article.getAno() >= startDate.getYear() && article.getAno() <= endDate.getYear()) {
                if (article.getPub().equals(journal)) {
                    System.out.println(article.getReferencias());
                }
            }
        }
    }


    static void testAuthor (DB db){

        Author a1 = new Author("12", "Joao Castro Silva", "Rua Santo Antonio", new Date((short) 12, (short) 6, 1973), "  joaosilva@gmail.com  ", "10", "EXECX", 1, 1, "Joao Silva");
        Author a2 = new Author("27", "Jose Fernandes Tomas", "Praça dos Combatentes", new Date((short) 9, (short) 12, 1994), "  josefernandes@gmail.com  ", "20", "LAB33", 2, 1, "Jose Fernandes");
        Author a3 = new Author("35", "Diogo da Costa Cunha", "Avenida dos Naufragos", new Date((short) 3, (short) 3, 1985), "  diogocunha32@gmail.com  ", "30", "FL45", 3, 1, "Diogo Cunha");
        Author a4 = new Author("42", "Filipe Moreira Santos", "Rua das Pedrinhas ", new Date((short) 4, (short) 7, 1964), "  filipesantos2@gmail.com  ", "40", "AR14", 4, 1, "Filipe Santos");
        Author a5 = new Author("56", "Lucas Alberto Cardoso", "Praceta dos Pescadores do Ultramar", new Date((short) 30, (short) 5, 1980), "  lucasalberto@hotmail.com  ", "50", "JJUR", 5, 1, "Lucas Alberto");

        db.addAuthor(a1);
        db.addAuthor(a2);
        db.addAuthor(a3);
        db.addAuthor(a4);
        db.addAuthor(a5);
        println("");
        db.listAuthors();
        println("");
        db.removeAuthor(a1);
        db.listAuthors();

    }

    static void testPublication (DB db){
        Publication conference1 = new PubConference("IEEE", 2023, "IEEE Computer Vision and Pattern Recognition", new Date((short) 18, (short) 6, 2023), new Date((short) 22, (short) 6, 2023), "Vancouver");
        Publication conference2 = new PubConference("Springer", 2024, "European Conference on Computer Vision", new Date((short) 29, (short) 9, 2024), new Date((short) 4, (short) 10, 2024), "Milan");
        Publication journal1 = new PubJournal("IEEE", 2024, "IEEE Transactions on Pattern Analysis and Machine Intelligence", 1.2, 1.3, "Monthly", 3, 8);
        Publication journal2 = new PubJournal("ELSEVIER", 2024, "Future Generation Computer Systems", 1.9, 1.6, "Bimonthly", 2, 5);

        db.addPublication(conference1);
        db.addPublication(conference2);
        db.addPublication(journal1);
        db.addPublication(journal2);

        db.listPublications();

        db.removePublication(conference1);

        println("");

        db.listPublications();
    }

    static void testArticle (DB db){

        Publication conference1 = new PubConference("IEEE", 2023, "IEEE Computer Vision and Pattern Recognition", new Date((short) 18, (short) 6, 2023), new Date((short) 22, (short) 6, 2023), "Vancouver");
        Publication conference2 = new PubConference("Springer", 2024, "European Conference on Computer Vision", new Date((short) 29, (short) 9, 2024), new Date((short) 4, (short) 10, 2024), "Milan");
        Publication journal1 = new PubJournal("IEEE", 2024, "IEEE Transactions on Pattern Analysis and Machine Intelligence", 1.2, 1.3, "Monthly", 3, 8);
        Publication journal2 = new PubJournal("ELSEVIER", 2024, "Future Generation Computer Systems", 1.9, 1.6, "Bimonthly", 2, 5);

        db.addPublication(conference1);
        db.addPublication(conference2);
        db.addPublication(journal1);
        db.addPublication(journal2);

        Article article1 = new Article("Artigo 1", 45, "Abstract 1", 2021, 2355, 34553, 13897, journal1, null, null);
        Article article2 = new Article("Artigo 2", 20, "Abstract 2", 2022, 5544, 67432, 19087, conference2, null, null);
        Article article3 = new Article("Artigo 3", 33, "Abstract 3", 2023, 10008, 102234, 35648, conference1, null, null);
        Article article4 = new Article("Artigo 3", 17, "Abstract 4", 2023, 456, 7895, 1263, journal2, null, null);

        db.addArticle(article1);
        db.addArticle(article2);
        db.addArticle(article3);
        db.addArticle(article4);

        db.listArticles();

        println("");

        db.listArticleStats(article1);
    }

    static void testRedBlackBST(DB db){
      RedBlackBST<Double,String> devices = new RedBlackBST<>();
        devices.put(1.0,"Smartphone");
        devices.put(2.0,"Tablet");
        devices.put(3.0,"Laptop");
        devices.put(4.0,"Desktop");
        devices.put(5.0,"Smartwatch");


        for (Double key : devices.keys()) {
            System.out.println(key + " " + devices.get(key));
        }
        System.out.println("Min: " + devices.min());
        System.out.println("Max: " + devices.max());
        System.out.println("Floor: " + devices.floor(3.5));
        System.out.println("Ceiling: " + devices.ceiling(3.5));
        System.out.println("Rank: " + devices.rank(3.0));
        System.out.println("Select: " + devices.select(2));

        //

    }

    static void testeRequisito4(DB db){
        Author a1 = new Author("12", "Joao Castro Silva", "Rua Santo Antonio", new Date((short) 12, (short) 6, 1973), "  joaosilva@gmail.com  ", "10", "EXECX", 1, 1, "Joao Silva");
        db.addAuthor(a1);

        //publique um artigo do author a1
        Publication journal1 = new PubJournal("IEEE", 2024, "IEEE Transactions on Pattern Analysis and Machine Intelligence", 1.2, 1.3, "Monthly", 3, 8);
        Publication journal2 = new PubJournal("ELSEVIER", 2024, "Future Generation Computer Systems", 1.9, 1.6, "Bimonthly", 2, 5);

        Article article1 = new Article("Artigo 1", 45, "Abstract 1", 2021, 2355, 34553, 13897, journal1, null, new ArrayList<Author>());
        Article article2 = new Article("Artigo 2", 20, "Abstract 2", 2022, 5544, 67432, 19087, journal2, null, new ArrayList<Author>());
        article1.getAutores().add(a1);
        article2.getAutores().add(a1);
        db.addArticle(article1);
        db.addArticle(article2);



        db.searchArticlesByAuthor(a1, new Date((short) 1, (short) 1, 2021), new Date((short) 1, (short) 1, 2022));
        //db.searchArticlesByDownloadsViews(new Date((short) 1, (short) 1, 2021), new Date((short) 1, (short) 1, 2023));
        //db.searchAuthorsByCitedArticles(new ArrayList<Article>(), new Date((short) 1, (short) 1, 2021), new Date((short) 1, (short) 1, 2023));
        //db.searchTop3Articles(new Date((short) 1, (short) 1, 2021), new Date((short) 1, (short) 1, 2023));
        //db.searchCitationsByJournal(new PubJournal("IEEE", 2024, "IEEE Transactions on Pattern Analysis and Machine Intelligence", 1.2, 1.3, "Monthly", 3, 8), new Date((short) 1, (short) 1, 2021), new Date((short) 1, (short) 1, 2023));

    }

    public static void main(String[] args) {
        DB db = new DB();

        //testAuthor(db);
        //testArticle(db);
        //testPublication(db);
        //testRedBlackBST(db);
        //testeRequisito4(db);






    }

}