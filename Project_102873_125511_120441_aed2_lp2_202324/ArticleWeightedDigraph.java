package Project_102873_125511_120441_aed2_lp2_202324;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.ST;

public class ArticleWeightedDigraph {
    EdgeWeightedDigraph G = new EdgeWeightedDigraph(7);
    ST<Integer, Article> articlesInGraph = new ST<>();

    public void addArticleToGraph(Article a) {
        articlesInGraph.put(a.getArticleId(), a);
    }

    public void searchArticle(Article a) {
        if (articlesInGraph.contains(a.getArticleId())) {
            System.out.println("Article found!");
            System.out.println("Article ID: " + a.getArticleId());
            System.out.println("Article Title: " + a.getTitulo());
            System.out.println("Authors:");
            for (Author author : a.getAutores()) {
                System.out.println("- " + author.getNomeCientifico());
            }
            System.out.println("Key Words: " + a.getKeyWords());
            System.out.println("Abstract: " + a.getAbstract());
            System.out.println("Year: " + a.getAno());
            System.out.println("Number of Downloads: " + a.getNumDownloads());
            System.out.println("Number of Views: " + a.getNumViews());
            System.out.println("Number of Likes: " + a.getNumLikes());

            System.out.println();
        } else {
            System.out.println("Article not found");
        }
    }

    public void addEdge(Article a1, Article a2, double weight) {
        G.addEdge(new DirectedEdge(a1.getArticleId(), a2.getArticleId(), weight));
    }

    public void printVerticeConnections(Article a) {
        System.out.println("Article Title: " + a.getTitulo());

        System.out.println("References:");

        for (DirectedEdge edge : G.adj(a.getArticleId())) {
            System.out.println("- " + articlesInGraph.get(edge.to()).getTitulo() + " | References: " + (int)edge.weight());
        }

        System.out.println();
    }


}
