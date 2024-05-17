package Project_102873_125511_120441_aed2_lp2_202324;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AuthorWeightedGraph{
    EdgeWeightedGraph G = new EdgeWeightedGraph(6);

    ST<Integer, Author> AuthorsInGraph = new ST<>();

    public void addAuthorToGraph(Author a) {
        AuthorsInGraph.put(a.getCienciaID(), a);
    }

    public void searchAuthor(Author a) {
        if (AuthorsInGraph.contains(a.getCienciaID())) {
            System.out.println("Author found!");
            System.out.println("Author ID: " + a.getCienciaID());
            System.out.println("Author Name: " + a.getNomeCientifico());
            System.out.println("Author Email: " + a.getEmail());
            System.out.println();
        } else {
            System.out.println("Author not found");
        }
    }

    public void addEdge(Author a1, Author a2, double weight) {
        G.addEdge(new Edge(a1.getCienciaID(), a2.getCienciaID(), weight));
    }

    public void printVerticeConnections(Author a) {
        System.out.println("Author Name: " + a.getNomeCientifico());

        System.out.println("Articles written with other Authors:");

        for (Edge edge : G.adj(a.getCienciaID())) {
            System.out.println("- " + AuthorsInGraph.get(edge.other(a.getCienciaID())).getNomeCientifico() + " | Weight: " + (int)edge.weight());
        }

        System.out.println();
    }

    public void searchCitations(Article a, int startYear, int endYear) {
        if (a.getPub() instanceof PubJournal) {
            if (a.getPub().getAno() >= startYear && a.getPub().getAno() <= endYear) {
                System.out.println("Article Title: " + a.getTitulo());
                System.out.println("Authors: ");
                for (Author author : a.getAutores()) {
                    if (AuthorsInGraph.contains(author.getCienciaID())) {
                        System.out.println("- " + author.getNomeCientifico());
                    }
                }
                System.out.println();
            }
        }
    }
    
    public void searchAuthorsCited(List<Article> articles, int startYear, int endYear) {
        ST<Integer, Author> authorsCited = new ST<>();

        for (Article article : articles) {
            if (article.getPub() instanceof PubJournal) {
                if (article.getPub().getAno() >= startYear && article.getPub().getAno() <= endYear) {
                    for (Author author : article.getAutores()) {
                        if (AuthorsInGraph.contains(author.getCienciaID())) {
                            authorsCited.put(author.getCienciaID(), author);
                        }
                    }
                }
            }
        }

        System.out.println("Authors that cited the articles:");
        for (Integer key : authorsCited.keys()) {
            System.out.println("- " + authorsCited.get(key).getNomeCientifico());
        }
    }








}
