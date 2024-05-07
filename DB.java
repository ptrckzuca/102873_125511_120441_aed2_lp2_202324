package Project_102873_125511_120441_aed2_lp2_202324;

import Project_102873_125511_120441_aed2_lp2_202324.*;
import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;
import java.util.Date;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

import static edu.princeton.cs.algs4.StdOut.println;


public class DB implements DBManageAuthorsI, DBManageArticlesI, DBManagePublicationsI {
    private ST<Integer, Author> authors;
    private ArrayList<Author> authorsArticle1 = new ArrayList<>();
    private ArrayList<Author> authorsArticle2 = new ArrayList<>();
    private ArrayList<Author> authorsArticle3 = new ArrayList<>();
    private ArrayList<Author> authorsArticle4 = new ArrayList<>();
    private ArrayList<Author> authorsArticle5 = new ArrayList<>();
    private ArrayList<Author> authorsArticle6 = new ArrayList<>();
    private ArrayList<Author> authorsArticle7 = new ArrayList<>();
    private ST<String, Article> articles;
    private ArrayList<Publication> publications;
    private RedBlackBST<Integer, Article> articlesByYear;


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

        Article article1 = new Article("Artigo 1", 45, "Abstract 1", 2018, 2355, 34553, 13897, journal1,null , authorsArticle1);
        Article article2 = new Article("Artigo 2", 20, "Abstract 2", 2024, 5544, 67432, 19087, journal2, null, authorsArticle2);
        Article article3 = new Article("Artigo 3", 33, "Abstract 3", 2009, 10008, 102234, 35648, conference1, null, authorsArticle3);
        Article article4 = new Article("Artigo 4", 17, "Abstract 4", 2020, 456, 7895, 1263, conference2, null, authorsArticle4);
        Article article5 = new Article("Artigo 5", 23, "Abstract 5", 2014, 7815, 40325, 12622, journal1, null, authorsArticle5);
        Article article6 = new Article("Artigo 6", 11, "Abstract 6", 2003, 784, 11462, 3417, conference2, null, authorsArticle6);
        Article article7 = new Article("Artigo 7", 51, "Abstract 7", 2024, 0, 0, 0, conference2, null, authorsArticle7);

        addArticle(article1);
        addArticle(article2);
        addArticle(article3);
        addArticle(article4);
        addArticle(article5);
        addArticle(article6);
        addArticle(article7);

        authorsArticle1.add(authors.get(1));
        authorsArticle1.add(authors.get(0));
        authorsArticle2.add(authors.get(2));
        authorsArticle2.add(authors.get(0));

        authorsArticle3.add(authors.get(3));
        authorsArticle3.add(authors.get(1));

        authorsArticle4.add(authors.get(4));
        authorsArticle4.add(authors.get(2));
        authorsArticle4.add(authors.get(3));

        authorsArticle5.add(authors.get(1));

        authorsArticle6.add(authors.get(4));
        authorsArticle6.add(authors.get(3));

        authorsArticle7.add(authors.get(4));
        authorsArticle7.add(authors.get(3));
        authorsArticle7.add(authors.get(2));
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


    public ArrayList<Article> getArticlesByAuthorAndYears(Author author, int startYear, int endYear) {
        ArrayList<Article> authorArticles = new ArrayList<>();

        for (String title : this.articles.keys()) {
            Article article = this.articles.get(title);
            if (article.getAutores().contains(author) && article.getAno() >= startYear && article.getAno() <= endYear) {
                authorArticles.add(article);
            }
        }
        System.out.println("Articles by author " + author.getNomeCientifico() + " between " + startYear + " and " + endYear + ": " + authorArticles.size());
        return authorArticles;
    }

    public ArrayList<Article> getDownloadStatusByArticleAndYears(int startYear, int endYear) {
        ArrayList<Article> downloadedArticles = new ArrayList<>();

        for (String title : this.articles.keys()) {
            Article article = this.articles.get(title);
            if (article.getAno() >= startYear && article.getAno() <= endYear) {
                if (article.getNumDownloads() == 0) {
                    downloadedArticles.add(article);
                }
            }
        }
        System.out.println("Download status of articles between " + startYear + " and " + endYear + ": " + downloadedArticles.size());
        return downloadedArticles;
    }

    public ArrayList<Article> getTop3ArticlesByLikes(int startYear, int endYear) {
        ArrayList<Article> articlesWithinPeriod = new ArrayList<>();

        for (Integer year : this.articlesByYear.keys(startYear, endYear)) {
            articlesWithinPeriod.add(this.articlesByYear.get(year));
        }

        Collections.sort(articlesWithinPeriod, new Comparator<Article>(){
            @Override
            public int compare(Article a1, Article a2) {
                return Integer.compare(a2.getNumLikes(), a1.getNumLikes());
            }
        });

        System.out.println("Number of articles within the period: " + articlesWithinPeriod.size());

        int topCount = Math.min(3, articlesWithinPeriod.size());
        ArrayList<Article> top3Articles = new ArrayList<>(articlesWithinPeriod.subList(0, topCount));

        System.out.println("Number of top 3 articles: " + top3Articles.size());
        for (Article article : top3Articles) {
            System.out.println("Title: " + article.getTitulo() + ", Likes: " + article.getNumLikes());
        }
        return top3Articles;
    }

public ArrayList<Author> getAuthorsByCitedArticleAndYears(Author author, int startYear, int endYear) {
        ArrayList<Author> authorsByCitedArticle = new ArrayList<>();

         for (String title : this.articles.keys()) {
            Article article = this.articles.get(title);
            if (article.getReferencias().contains(author) && article.getAno() >= startYear && article.getAno() <= endYear) {
                for (Author a : article.getAutores()) {
                    if (!authorsByCitedArticle.contains(a)) {
                        authorsByCitedArticle.add(a);
                    }
                }
            }
        }
        System.out.println("Authors by cited article and years: " + authorsByCitedArticle.size());
        return authorsByCitedArticle;
    }

    static void testAuthor(DB db) {
        db.listAuthors();
        println("");
        db.removeAuthor(db.getAuthor(1));
        db.listAuthors();
    }

    static void testPublication(DB db) {

        db.listPublications();
        db.removePublication(db.publications.get(0));
        println("");
        db.listPublications();
    }

    static void testArticle(DB db) {
        db.listArticles();
        db.removeArticle(db.articles.get("Artigo 1"));
        println("");
        db.listArticles();

        db.listArticleStats(db.articles.get("Artigo 2"));
    }

    static void testSearchArticlePerPeriod(DB db) {

        db.insertArticleByYear(db.articles.get("Artigo 1"));
        db.insertArticleByYear(db.articles.get("Artigo 2"));
        db.insertArticleByYear(db.articles.get("Artigo 3"));
        db.insertArticleByYear(db.articles.get("Artigo 4"));
        db.insertArticleByYear(db.articles.get("Artigo 5"));
        db.insertArticleByYear(db.articles.get("Artigo 6"));
        db.insertArticleByYear(db.articles.get("Artigo 7"));



        //db.getArticlesByAuthorAndYears(db.authors.get(2), 2000, 2025).forEach(System.out::println);
        //db.getDownloadStatusByArticleAndYears(2000, 2024).forEach(System.out::println);
        //db.getTop3ArticlesByLikes(2000, 2024);

        db.articles.get("Artigo 2").getReferencias().add(db.articles.get("Artigo 1"));
        db.getAuthorsByCitedArticleAndYears(db.authors.get(1), 2000, 2025).forEach(System.out::println);




    }


    public static void main(String[] args) {
        DB db = new DB();

        //testAuthor(db);
        //testArticle(db);
        //testPublication(db);
        testSearchArticlePerPeriod(db);
    }

}