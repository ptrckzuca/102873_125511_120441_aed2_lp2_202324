package Project_102873_125511_120441_aed2_lp2_202324;


import edu.princeton.cs.algs4.*;


import java.io.*;
import java.util.ArrayList;

public class ArticleWeightedDigraph {
    EdgeWeightedDigraph G;
    ST<Integer, Article> articlesInGraph = new ST<>();

    public ArticleWeightedDigraph(int vertices) {
        G = new EdgeWeightedDigraph(vertices);
    }

    public void addArticleToGraph(Article a) {
        articlesInGraph.put(a.getArticleId(), a);
    }
    public void addArticle(Article a, int id) {
        articlesInGraph.put(id, a);
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

    }public void add_Edge(int v, int w, double weight) {
        G.addEdge(new DirectedEdge(v, w, weight));
    }

    public void printVerticeConnections(Article a) {
        System.out.println("Article Title: " + a.getTitulo());

        System.out.println("References:");

        for (DirectedEdge edge : G.adj(a.getArticleId())) {
            System.out.println("- " + articlesInGraph.get(edge.to()).getTitulo() + " | References: " + (int)edge.weight());
        }

        System.out.println();
    }

    public void listTypeOfPubInAPeriod(String Pub, int Year1, int Year2) {
        boolean found = false;

        // Ciclo for para percorrer todos os artigos no grafo
        for (Integer idArticle : articlesInGraph.keys()) {
            Article article = articlesInGraph.get(idArticle);

            // Verifica com o instanceof se o artigo foi publicado num Journal ou numa Conferência
            if (article.getPub() instanceof PubJournal) {
                PubJournal pubJournal = (PubJournal) article.getPub();
                if (pubJournal.getNome().equals(Pub)) {
                    // Verifica se a publicação foi no intervalo esperado
                    if (article.getAno() >= Year1 && article.getAno() <= Year2) {
                        System.out.println("Article found: " + article.getTitulo());
                        found = true;
                    }
                }
            } else if (article.getPub() instanceof PubConference) {
                PubConference pubConference = (PubConference) article.getPub();
                if (pubConference.getNome().equals(Pub)) {
                    if (article.getAno() >= Year1 && article.getAno() <= Year2) {
                        System.out.println("Article found: " + article.getTitulo());
                        found = true;
                    }
                }
            }
        }

        // Verificação caso não tenha encontrado nenhum artigo
        if (!found) {
            System.out.println("No Article found in the specified period");
        }
    }

    public void searchSelfCitations(Article article) {
        System.out.println("Article Title: " + article.getTitulo());
        System.out.println("Authors:");
        for (Author author : article.getAutores()) {
            System.out.println("- " + author.getNomeCientifico());
        }
        System.out.println("Self Citations: ");

        // obtém autores de artigo de origem
        Iterable<Author> authorsOfOriginArticle = article.getAutores();

        // percorre as arestas que saem do artigo de origem
        for (DirectedEdge edge : G.adj(article.getArticleId())) {
            // obtem artigos referenciados
            Article referencedArticle = articlesInGraph.get(edge.to());

            // Obtém os autores do artigo referenciado
            Iterable<Author> authorsOfReferencedArticle = referencedArticle.getAutores();

            // Verifica se há autores em comum
            for (Author authorOfOrigin : authorsOfOriginArticle) {
                for (Author authorOfReferenced : authorsOfReferencedArticle) {
                    if (authorOfOrigin.equals(authorOfReferenced)) {
                        // Se houver autores em comum, imprime a self citation
                        System.out.println("- " + referencedArticle.getTitulo());
                        break; // Uma vez que detectamos uma self citation, não é necessário continuar a verificação.
                    }
                }
            }
        }
        System.out.println();
    }

    //código que calcula o shortest path usando o algoritmo de Dijkstra
    public void shortestPathBetweenArticles(Article a1, Article a2) {
        int s = a1.getArticleId();
        int t = a2.getArticleId();
        DijkstraSP sp = new DijkstraSP(G, s);
        if (sp.hasPathTo(t)) {
            System.out.println("Shortest path between " + a1.getTitulo() + " and " + a2.getTitulo() + ":");
            for (DirectedEdge e : sp.pathTo(t)) {
                System.out.println(articlesInGraph.get(e.from()).getTitulo() + " -> " + articlesInGraph.get(e.to()).getTitulo());
            }
        } else {
            System.out.println("No path found");
        }
    }
    public void listCitationsbyJournalAndPeriod(String Journal, int Year1, int Year2) {
        boolean found = false;

        // Percorre artigos do grafo
        for (Integer ArticleID : articlesInGraph.keys()) {
            Article article = articlesInGraph.get(ArticleID);

            // Verifica se artigo pertence a journal
            if (article.getPub() instanceof PubJournal) {
                PubJournal pubJournal = (PubJournal) article.getPub();
                if (pubJournal.getNome().equals(Journal)) {
                    // Percorre as arestas que saem do artigo (citações feitas por ele)
                    for (DirectedEdge edge : G.adj(ArticleID)) {
                        int citedArticleId = edge.to();
                        Article citedArticle = articlesInGraph.get(citedArticleId);

                        // Verifica se a citação está no intervalo temporal
                        if (citedArticle.getAno() >= Year1 && citedArticle.getAno() <= Year2) {
                            System.out.println("Citation found:");
                            System.out.println("Article that cites: " + article.getTitulo());
                            System.out.println("Article cited: " + citedArticle.getTitulo());
                            System.out.println("Year of citation: " + citedArticle.getAno());
                            System.out.println("Number of references: " + edge.weight());
                            found = true;
                        }
                    }
                }
            }
        }

        // Verifica se encontrou citações que correspondam aos critérios
        if (!found) {
            System.out.println("Nenhuma citação encontrada para o Journal especificado no período temporal fornecido.");
        }
    }

    public void saveArticleGraphToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Guardar artigos no ficheiro
            for (int id : articlesInGraph.keys()) {
                Article article = articlesInGraph.get(id);
                writer.write(String.format("Node:%d,%s\n", id, article.toString()));
            }
            // Guardar arestas no ficheiro
            for (DirectedEdge e : G.edges()) {
                writer.write(String.format("Article %d references Article %d Nº of references: %d\n", e.from(), e.to(), (int)e.weight()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addInputToArticleGraph(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            // lê vertices e arestas
            line = br.readLine();
            if (line != null) {
                String[] parts = line.split(",");
                int V = Integer.parseInt(parts[0]);
                int E = Integer.parseInt(parts[1]);

                System.out.println("V: " + V); // debug V
                System.out.println("E: " + E); // debug E

                // lê os artigos (vertices)
                for (int j = 0; j < V; j++) {
                    line = br.readLine();
                    if (line != null) {
                        parts = line.split(",");
                        int articleID = Integer.parseInt(parts[0]);
                        String titulo = parts[1];
                        int keyWords = Integer.parseInt(parts[2]);
                        String anAbstract = parts[3];
                        int ano = Integer.parseInt(parts[4]);
                        int numDownloads = Integer.parseInt(parts[5]);
                        int numViews = Integer.parseInt(parts[6]);
                        int numLikes = Integer.parseInt(parts[7]);


                        Article article = new Article(articleID, titulo, keyWords, anAbstract, ano, numDownloads, numViews, numLikes, null, null);
                        addArticle(article, articleID);

                        System.out.println("Article after adding: " + articlesInGraph.get(articleID)); // debug article
                    }
                }

                // lê as arestas e pesos
                for (int i = 0; i < E; i++) {
                    line = br.readLine();
                    if (line != null) {
                        parts = line.split(",");
                        int v = Integer.parseInt(parts[0]);
                        int w = Integer.parseInt(parts[1]);
                        double weight = Double.parseDouble(parts[2]);
                        add_Edge(v, w, weight);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("articlesInGraph size: " + articlesInGraph.size());
    }
    public boolean isStronglyConnected() {
        Digraph digraph = convertToDigraph(G);
        KosarajuSharirSCC scc = new KosarajuSharirSCC(digraph);
        return scc.count() == 1;
    }

    private Digraph convertToDigraph(EdgeWeightedDigraph G) {
        Digraph digraph = new Digraph(G.V());
        for (int v = 0; v < G.V(); v++) {
            for (DirectedEdge e : G.adj(v)) {
                digraph.addEdge(e.from(), e.to());
            }
        }
        return digraph;
    }

}

