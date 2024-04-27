package Project_102873_125511_120441_aed2_lp2_202324;
import edu.princeton.cs.algs4.ST;
import Project_102873_125511_120441_aed2_lp2_202324.Author;
import edu.ufp.inf.lp2.p01_intro.Date;

import java.io.FileWriter;
import java.io.IOException;

import static edu.princeton.cs.algs4.StdOut.print;
import static edu.princeton.cs.algs4.StdOut.println;


public class DB implements DBManageAuthorsI, DBManageArticlesI {
    private ST<Integer, Author> authors;
    private ST<String, Article> articles;



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
    public Article listArticles() {
        for (String key : articles.keys()) {
            System.out.println(articles.get(key));
        }
        return null;
    }




    public static void main(String[] args) {
        DB db = new DB();

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


         /*
        Article article1 = new Article("Artigo 1", 1, "Abstract 1", 2021, 1, 1, 1, new Publication(), null, null);
        Article article2 = new Article("Artigo 2", 2, "Abstract 2", 2022, 2, 2, 2, new Publication(), null, null);
        Article article3 = new Article("Artigo 3", 3, "Abstract 3", 2023, 3, 3, 3, new Publication(), null, null);

        db.addArticle(article1);
        db.addArticle(article2);
        db.addArticle(article3);


        db.removeArticle(article1);

        db.listArticles();
        */
    }

}