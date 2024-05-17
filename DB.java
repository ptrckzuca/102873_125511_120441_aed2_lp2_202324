package Project_102873_125511_120441_aed2_lp2_202324;

import java.util.*;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.ST;



import java.io.FileWriter;
import java.io.IOException;

import static edu.princeton.cs.algs4.StdOut.println;


public class DB implements DBManageAuthorsI, DBManageArticlesI, DBManagePublicationsI {
    private ST<Integer, Author> authors;
    private ST<String, Article> articles;
    private ArrayList<Publication> publications;
    private RedBlackBST<Integer, Article> articlesByYear;
    private ArticleWeightedDigraph awd;

    public DB() {
        articlesByYear = new RedBlackBST<>();
        authors = new ST<>();
        articles = new ST<>();
        publications = new ArrayList<>();
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
            System.out.println("ID number: " + authors.get(key).getIdNumber());
            System.out.println("Name: " + authors.get(key).getName());
            System.out.println("Address: " + authors.get(key).getAdress());
            System.out.println("Birth date: " + authors.get(key).getBirth());
            System.out.println("CienciaID: " + authors.get(key).getCienciaID());
            System.out.println("Short name: " + authors.get(key).getNomeCientifico());
            System.out.println("ORCID: " + authors.get(key).getOrcid());
            System.out.println("Filiation: " + authors.get(key).getFiliacao());
            System.out.println("Google Scholar ID: " + authors.get(key).getGoogleScholarID());
            System.out.println("Email: " + authors.get(key).getEmail());
            System.out.println();
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

    public void listArticles() {
        for (String key : articles.keys()) {
            Article article = articles.get(key);

            System.out.println("Article Title: " + article.getTitulo());
            System.out.println("Article ID: " + article.getArticleId());
            System.out.println("Authors:");

            for (Author author : article.getAutores()) {
                System.out.println("- " + author.getNomeCientifico());
            }

            System.out.println("Key Words: " + article.getKeyWords());
            System.out.println("Abstract: " + article.getAbstract());
            System.out.println("Year: " + article.getAno());

            System.out.println("Number of Downloads: " + article.getNumDownloads());
            System.out.println("Number of Views: " + article.getNumViews());
            System.out.println("Number of Likes: " + article.getNumLikes());

            System.out.println();
        }
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

    public void listPublications() {
        for (Publication publication : publications) {
            System.out.println("Publication Name: " + publication.getNome());
            System.out.println("Publisher: " + publication.getPublisher());
            System.out.println("Year: " + publication.getAno());

            if (publication instanceof PubJournal) {
                PubJournal journal = (PubJournal) publication;
                System.out.println("Type: Journal");
                System.out.println("JCR Impact Factor: " + journal.getJcrIF());
                System.out.println("Scopus Impact Factor: " + journal.getScopusIF());
                System.out.println("Periodicity: " + journal.getPeriodicidade());
                System.out.println("Volume: " + journal.getVolume());
                System.out.println("Series: " + journal.getSeries());
                return;
            } else if (publication instanceof PubConference) {
                PubConference conference = (PubConference) publication;
                System.out.println("Type: Conference");
                System.out.println("Start Date: " + conference.getDataInicio());
                System.out.println("End Date: " + conference.getDataFim());
                System.out.println("Location: " + conference.getLocal());
            }

            System.out.println();
        }
    }

    public void insertArticleByYear(Article article) {
        int key = article.getAno();
        this.articlesByYear.put(key, article);
        //put(key, article);
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
                if (article.getNumDownloads() > 0) {
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

        Collections.sort(articlesWithinPeriod, new Comparator<Article>() {
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

    static void initDB(DB db) {
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

        Publication conference1 = new PubConference("IEEE", 2023, "IEEE Computer Vision and Pattern Recognition", new Date((short) 18, (short) 6, 2023), new Date((short) 22, (short) 6, 2023), "Vancouver");
        Publication conference2 = new PubConference("Springer", 2024, "European Conference on Computer Vision", new Date((short) 29, (short) 9, 2024), new Date((short) 4, (short) 10, 2024), "Milan");
        Publication journal1 = new PubJournal("IEEE", 2024, "IEEE Transactions on Pattern Analysis and Machine Intelligence", 1.2, 1.3, "Monthly", 3, 8);
        Publication journal2 = new PubJournal("ELSEVIER", 2024, "Future Generation Computer Systems", 1.9, 1.6, "Bimonthly", 2, 5);

        db.addPublication(conference1);
        db.addPublication(conference2);
        db.addPublication(journal1);
        db.addPublication(journal2);

        ArrayList<Author> authorsArticle1 = new ArrayList<>();
        authorsArticle1.add(db.authors.get(1));
        authorsArticle1.add(db.authors.get(3));
        ArrayList<Author> authorsArticle2 = new ArrayList<>();
        authorsArticle2.add(db.authors.get(2));
        authorsArticle2.add(db.authors.get(5));
        ArrayList<Author> authorsArticle3 = new ArrayList<>();
        authorsArticle3.add(db.authors.get(3));
        authorsArticle3.add(db.authors.get(1));
        ArrayList<Author> authorsArticle4 = new ArrayList<>();
        authorsArticle4.add(db.authors.get(4));
        authorsArticle4.add(db.authors.get(2));
        authorsArticle4.add(db.authors.get(3));
        ArrayList<Author> authorsArticle5 = new ArrayList<>();
        authorsArticle5.add(db.authors.get(5));
        authorsArticle5.add(db.authors.get(4));
        authorsArticle5.add(db.authors.get(2));
        authorsArticle5.add(db.authors.get(1));
        ArrayList<Author> authorsArticle6 = new ArrayList<>();
        authorsArticle6.add(db.authors.get(4));
        authorsArticle6.add(db.authors.get(3));
        ArrayList<Author> authorsArticle7 = new ArrayList<>();
        authorsArticle7.add(db.authors.get(4));
        authorsArticle7.add(db.authors.get(3));
        authorsArticle7.add(db.authors.get(2));

        Article article1 = new Article(0, "Artigo 1", 45, "Abstract 1", 2018, 2355, 34553, 13897, journal1, authorsArticle1);
        Article article2 = new Article(1, "Artigo 2", 20, "Abstract 2", 2023, 5544, 67432, 19087, journal2, authorsArticle2);
        Article article3 = new Article(2, "Artigo 3", 33, "Abstract 3", 2009, 10008, 102234, 35648, conference1, authorsArticle3);
        Article article4 = new Article(3, "Artigo 4", 17, "Abstract 4", 2020, 456, 7895, 1263, conference2, authorsArticle4);
        Article article5 = new Article(4, "Artigo 5", 23, "Abstract 5", 2014, 7815, 40325, 12622, journal1, authorsArticle5);
        Article article6 = new Article(5, "Artigo 6", 11, "Abstract 6", 2003, 784, 11462, 3417, conference2, authorsArticle6);
        Article article7 = new Article(6, "Artigo 7", 51, "Abstract 7", 2024, 0, 0, 0, conference2, authorsArticle7);

        db.addArticle(article1);
        db.addArticle(article2);
        db.addArticle(article3);
        db.addArticle(article4);
        db.addArticle(article5);
        db.addArticle(article6);
        db.addArticle(article7);


        db.insertArticleByYear(db.articles.get("Artigo 1"));
        db.insertArticleByYear(db.articles.get("Artigo 2"));
        db.insertArticleByYear(db.articles.get("Artigo 3"));
        db.insertArticleByYear(db.articles.get("Artigo 4"));
        db.insertArticleByYear(db.articles.get("Artigo 5"));
        db.insertArticleByYear(db.articles.get("Artigo 6"));
        db.insertArticleByYear(db.articles.get("Artigo 7"));
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

        //db.removeArticle(db.articles.get("Artigo 1"));
        println("");
        //db.listArticles();

        db.listArticleStats(db.articles.get("Artigo 2"));
    }

    static void testSearchArticlePerPeriod(DB db) {
        /*
        db.insertArticleByYear(db.articles.get("Artigo 1"));
        db.insertArticleByYear(db.articles.get("Artigo 2"));
        db.insertArticleByYear(db.articles.get("Artigo 3"));
        db.insertArticleByYear(db.articles.get("Artigo 4"));
        db.insertArticleByYear(db.articles.get("Artigo 5"));
        db.insertArticleByYear(db.articles.get("Artigo 6"));
        db.insertArticleByYear(db.articles.get("Artigo 7"));

         */

        //db.listArticles();

        //db.getArticlesByAuthorAndYears(db.authors.get(2), 2000, 2025).forEach(System.out::println);
        db.getDownloadStatusByArticleAndYears(2000, 2024).forEach(System.out::println);
        db.getTop3ArticlesByLikes(2000, 2024);


    }

    static void testArticleWeightedDigraph(DB db){
        ArticleWeightedDigraph awd = new ArticleWeightedDigraph();
        awd.addArticleToGraph(db.articles.get("Artigo 1"));
        awd.addArticleToGraph(db.articles.get("Artigo 2"));
        awd.addArticleToGraph(db.articles.get("Artigo 3"));
        awd.addArticleToGraph(db.articles.get("Artigo 4"));
        awd.addArticleToGraph(db.articles.get("Artigo 5"));
        awd.addArticleToGraph(db.articles.get("Artigo 6"));
        awd.addArticleToGraph(db.articles.get("Artigo 7"));

        awd.addEdge(db.articles.get("Artigo 7"), db.articles.get("Artigo 1"), 3);
        awd.addEdge(db.articles.get("Artigo 7"), db.articles.get("Artigo 2"), 6);
        awd.addEdge(db.articles.get("Artigo 7"), db.articles.get("Artigo 6"), 4);

        awd.addEdge(db.articles.get("Artigo 5"), db.articles.get("Artigo 3"), 8);
        awd.addEdge(db.articles.get("Artigo 5"), db.articles.get("Artigo 6"), 5);

        awd.addEdge(db.articles.get("Artigo 3"), db.articles.get("Artigo 6"), 11);

        awd.addEdge(db.articles.get("Artigo 2"), db.articles.get("Artigo 1"), 5);
        awd.addEdge(db.articles.get("Artigo 2"), db.articles.get("Artigo 4"), 3);
        awd.addEdge(db.articles.get("Artigo 2"), db.articles.get("Artigo 5"), 7);

        awd.addEdge(db.articles.get("Artigo 1"), db.articles.get("Artigo 4"), 16);

        awd.addEdge(db.articles.get("Artigo 4"), db.articles.get("Artigo 5"), 7);
        awd.addEdge(db.articles.get("Artigo 4"), db.articles.get("Artigo 6"), 2);

        awd.printVerticeConnections(db.articles.get("Artigo 6"));



        //awd.searchArticle(db.articles.get("Artigo 7"));

        //awd.printVerticeConnections(db.articles.get("Artigo 7"));
    }



    static void testAuthorWeightedGraph(DB db){
        AuthorWeightedGraph awg = new AuthorWeightedGraph();
        awg.addAuthorToGraph(db.authors.get(1));
        awg.addAuthorToGraph(db.authors.get(2));
        awg.addAuthorToGraph(db.authors.get(3));
        awg.addAuthorToGraph(db.authors.get(4));
        awg.addAuthorToGraph(db.authors.get(5));

        awg.addEdge(db.authors.get(1), db.authors.get(2), 1);
        awg.addEdge(db.authors.get(1), db.authors.get(3), 2);
        awg.addEdge(db.authors.get(1), db.authors.get(4), 1);
        awg.addEdge(db.authors.get(1), db.authors.get(5), 1);
        awg.addEdge(db.authors.get(2), db.authors.get(3), 2);
        awg.addEdge(db.authors.get(2), db.authors.get(4), 3);
        awg.addEdge(db.authors.get(2), db.authors.get(5), 2);
        awg.addEdge(db.authors.get(3), db.authors.get(4), 3);
        awg.addEdge(db.authors.get(3), db.authors.get(5), 0);
        awg.addEdge(db.authors.get(4), db.authors.get(5), 1);

        //awg.printVerticeConnections(db.authors.get(1));

        //awg.searchAuthor(db.authors.get(1));

        //awg.searchCitations(db.articles.get("Artigo 1"), 2000, 2025);
        //awg.searchCitations(db.articles.get("Artigo 2"), 2000, 2025);
        //awg.searchCitations(db.articles.get("Artigo 3"), 2000, 2025);
        //awg.searchCitations(db.articles.get("Artigo 4"), 2000, 2025);
        //awg.searchCitations(db.articles.get("Artigo 5"), 2000, 2025);
        //awg.searchCitations(db.articles.get("Artigo 6"), 2000, 2025);
        //awg.searchCitations(db.articles.get("Artigo 7"), 2000, 2025);

         awg.searchAuthorsCited(Arrays.asList(db.articles.get("Artigo 2")),2000, 2025);


    }


    public static void main(String[] args) {
        DB db = new DB();
        initDB(db);
        //db.listAuthors();
        //db.listPublications();
        /*System.out.println("\nmain(): ============= listArticles()...");
        db.listArticles();
        System.out.println("\nmain(): ============= removeArticle()...");
        db.removeArticle(db.articles.get("Artigo 1"));
        System.out.println("\nmain(): ============= listArticles()...");
        db.listArticles();*/


        //testArticleWeightedDigraph(db);
        testAuthorWeightedGraph(db);

        //testAuthor(db);
        //testArticle(db);
        //testPublication(db);
        //testSearchArticlePerPeriod(db);


    }

}