package Project_102873_125511_120441_aed2_lp2_202324;

import edu.princeton.cs.algs4.*;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AuthorWeightedGraph {
    EdgeWeightedGraph G;
    ST<Integer, Author> AuthorsInGraph = new ST<>();

    public AuthorWeightedGraph(int vertices) {
        G = new EdgeWeightedGraph(vertices);
    }

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
    public int countCollaborators(Author author) {
        int collaboratorCount = 0;

        // Verificar se o autor está presente no grafo
        if (!AuthorsInGraph.contains(author.getCienciaID())) {
            System.out.println("O autor não está presente no grafo.");
            return collaboratorCount;
        }

        // Obter o índice do autor no grafo
        int authorIndex = author.getCienciaID();

        // Imprimir o nome do autor
        System.out.println("Colaboradores do autor: " + author.getName());

        // Percorrer todas as arestas conectadas ao autor
        for (Edge edge : G.adj(authorIndex)) {
            // Obter o índice do autor colaborador
            int collaboratorIndex = edge.other(authorIndex);

            // Obter o autor colaborador a partir do índice
            Author collaborator = AuthorsInGraph.get(collaboratorIndex);

            // Incrementar o contador de colaboradores
            collaboratorCount++;

            // Imprimir o nome do colaborador
            System.out.println("Nome do colaborador: " + collaborator.getName());
        }

        return collaboratorCount;
    }
    public void saveAuthorGraphToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Save authors
            for (int id : AuthorsInGraph.keys()) {
                Author author = AuthorsInGraph.get(id);
                writer.write(String.format("Node:%d, %s\n", id, author.toString()));
            }
            // Save edges
            for (Edge e : G.edges()) {
                writer.write(String.format("Author %d worked with Author %d, %d times\n", e.either(), e.other(e.either()), (int)e.weight()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addInputToAuthorGraph(String filename) {
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

                // lê os autores (vertices)
                for (int i = 0; i < V; i++) {
                    line = br.readLine();
                    if (line != null) {
                        parts = line.split(",");
                        for (String part : parts) {
                            System.out.println("Part: " + part); // debug
                        }
                        int id = Integer.parseInt(parts[0]);
                        String idNumber = parts[1];
                        String name = parts[2];
                        String address = parts[3];
                        Date birth = null;
                        try {
                            birth = new SimpleDateFormat("yyyy-MM-dd").parse(parts[4]);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        String orcid = parts[5];
                        int CienciaID = Integer.parseInt(parts[6]);
                        String filiacao = parts[7];
                        int GoogleScholarID = Integer.parseInt(parts[8]);
                        String nomeCientifico = parts[9];
                        String email = parts[10];

                        Author author = new Author(id, idNumber, name, address, birth, orcid, CienciaID, filiacao, GoogleScholarID, nomeCientifico, email);

                        System.out.println("Author before adding: " + author); // debug author
                        AuthorsInGraph.put(id, author);
                        System.out.println("Author after adding: " + AuthorsInGraph.get(id)); // debug author
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
                        Edge edge = new Edge(v, w, weight);

                        G.addEdge(edge);

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("AuthorsInGraph size: " + AuthorsInGraph.size());
    }


}

