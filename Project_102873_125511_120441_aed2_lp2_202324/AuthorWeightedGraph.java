package Project_102873_125511_120441_aed2_lp2_202324;

import edu.princeton.cs.algs4.*;


import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.ufp.inf.lp2.p01_intro.Date;
import edu.ufp.inf.lp2.p07inputoutput.FileBinOutputStreamApp;


public class AuthorWeightedGraph {
    EdgeWeightedGraph G;
    ST<Integer, Author> AuthorsInGraph = new ST<>();

    public AuthorWeightedGraph(int vertices) {
        G = new EdgeWeightedGraph(vertices);
    }

    public void addAuthorToGraph(Author a) {
        AuthorsInGraph.put(a.getCienciaID(), a);
    }

    public void addAuthor(Author a, int id) {
        AuthorsInGraph.put(id, a);
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

    public void add_Edge(int v, int w, double weight) {
        G.addEdge(new Edge(v, w, weight));
    }

    public void printVerticeConnections(Author a) {
        System.out.println("Author Name: " + a.getNomeCientifico());

        System.out.println("Articles written with other Authors:");

        for (Edge edge : G.adj(a.getCienciaID())) {
            System.out.println("- " + AuthorsInGraph.get(edge.other(a.getCienciaID())).getNomeCientifico() + " | Weight: " + (int)edge.weight());
        }

        System.out.println();
    }

    /**
     * Retrieves authors belonging to a specific affiliation.
     *
     * @param filiacao The affiliation to search for authors.
     */
    public void getAuthorsByAffiliation(String filiacao) {
        boolean found = false;

        System.out.println("Authors in filiation " + filiacao + ":");

        for (Integer id : AuthorsInGraph.keys()) {
            Author author = AuthorsInGraph.get(id);
            if (author.getFiliacao().equalsIgnoreCase(filiacao)) {
                System.out.println("- " + author.getName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Impossible to find any author: " + filiacao);
        }
    }


    /**
     * Counts the number of collaborators for a given author in the graph.
     *
     * @param author The author for whom collaborators are counted.
     * @return The number of collaborators for the given author.
     */
    public int countCollaborators(Author author) {
        int collaboratorCount = 0;

        // verificar se o autor está presente no grafo
        if (!AuthorsInGraph.contains(author.getCienciaID())) {
            System.out.println("O autor não está presente no grafo.");
            return collaboratorCount;
        }

        // obter o índice do autor no grafo
        int authorIndex = author.getCienciaID();

        // imprimir o nome do autor
        System.out.println("Colaboradores do autor: " + author.getName());

        // percorrer todas as arestas conectadas ao autor
        for (Edge edge : G.adj(authorIndex)) {
            // obter o índice do autor colaborador
            int collaboratorIndex = edge.other(authorIndex);

            // obter o autor colaborador a partir do índice
            Author collaborator = AuthorsInGraph.get(collaboratorIndex);

            // incrementar o contador de colaboradores
            collaboratorCount++;

            // imprimir o nome do colaborador
            System.out.println("Nome do colaborador: " + collaborator.getName());
        }

        return collaboratorCount;
    }

    /**
     * Finds the shortest path between two authors in the graph.
     *
     * @param a1 The first author.
     * @param a2 The second author.
     */
    public void shortestPathBetweenAuthors(Author a1, Author a2) {
        int s = a1.getCienciaID();
        int t = a2.getCienciaID();
        Graph unweightedGraph = convertToUnweightedGraph(G);
        BreadthFirstPaths bfs = new BreadthFirstPaths(unweightedGraph, s);
        if (bfs.hasPathTo(t)) {
            System.out.println("Shortest path between " + a1.getName() + " and " + a2.getName() + ":");
            for (int v : bfs.pathTo(t)) {
                System.out.print(AuthorsInGraph.get(v).getName() + " -> ");
            }
            System.out.println(a2.getName());
        } else {
            System.out.println("No path found");
        }
    }
    /**
     * Checks if the graph is connected.
     *
     * @return True if the graph is connected, false otherwise.
     */
    public boolean isConnected() {
        Graph unweightedGraph = convertToUnweightedGraph(G);
        DepthFirstPaths dfs = new DepthFirstPaths(unweightedGraph, 0);
        for (int v = 0; v < unweightedGraph.V(); v++) {
            if (!dfs.hasPathTo(v)) {
                return false; // se nao aceder a vertice, nao esta conectado
            }
        }
        return true;
    }

    /**
     * Converts an EdgeWeightedGraph to an unweighted Graph.
     *
     * @param G The EdgeWeightedGraph to be converted.
     * @return An unweighted Graph containing the same vertices and connections as the original EdgeWeightedGraph.
     */
    private Graph convertToUnweightedGraph(EdgeWeightedGraph G) {
        Graph unweightedGraph = new Graph(G.V());
        for (Edge e : G.edges()) {
            unweightedGraph.addEdge(e.either(), e.other(e.either()));
        }
        return unweightedGraph;
    }
    /**
     * Saves the author graph to a file.
     * <p>
     * This method writes the details of each author node and the edges representing collaborations
     * between authors to the specified file. The output includes the ID and details of each author,
     * followed by the collaboration information between authors.
     * </p>
     *
     * <pre>
     * Node:1, Author1 Details
     * Node:2, Author2 Details
     * ...
     * Author 1 worked with Author 2, 5 times
     * Author 1 worked with Author 3, 3 times
     * ...
     * </pre>
     *
     * @param filename the name of the file to save the author graph to
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public void saveAuthorGraphToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // guarda autores
            for (int id : AuthorsInGraph.keys()) {
                Author author = AuthorsInGraph.get(id);
                writer.write(String.format("Node:%d, %s\n", id, author.toString()));
            }
            // guaeda arestas
            for (Edge e : G.edges()) {
                writer.write(String.format("Author %d worked with Author %d, %d times\n", e.either(), e.other(e.either()), (int)e.weight()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds authors and their collaborations to the graph from an input file.
     * <p>
     * This method reads the details of authors (nodes) and their collaborations (edges)
     * from the specified file and adds them to the author graph. The file format is expected
     * to have the number of vertices (V) and edges (E) on the first line, followed by V lines
     * of author details, and then E lines of edge details.
     * </p>
     * <p>
     * File format:
     * <pre>
     * V,E
     * id,idNumber,name,address,birth,orcid,CienciaID,filiacao,GoogleScholarID,nomeCientifico,email
     * ...
     * v,w,weight
     * ...
     * </pre>
     * </p>
     *
     * @param filename the name of the file containing the author and edge data
     * @throws IOException if an I/O error occurs while reading the file
     */
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
                for (int j = 0; j < V; j++) {
                    line = br.readLine();
                    if (line != null) {
                        parts = line.split(",");
                        for (int i = 0; i < parts.length; i++) {
                            System.out.println("Part[" + i + "]: " + parts[i]);
                        }
                        int id = Integer.parseInt(parts[0]);
                        String idNumber = parts[1];
                        String name = parts[2];
                        String address = parts[3];
                        String[] dateParts = parts[4].split("-");
                        short day = Short.parseShort(dateParts[2]);
                        short month = Short.parseShort(dateParts[1]);
                        int year = Integer.parseInt(dateParts[0]);
                        Date birth = new Date(day, month, year);
                        String orcid = parts[5];
                        int CienciaID = Integer.parseInt(parts[6]);
                        String filiacao = parts[7];
                        int GoogleScholarID = Integer.parseInt(parts[8]);
                        String nomeCientifico = parts[9];
                        String email = parts[10];

                        System.out.println("id: " + id);
                        System.out.println("idNumber: " + idNumber);
                        System.out.println("name: " + name);
                        System.out.println("address: " + address);
                        System.out.println("birth: " + birth);
                        System.out.println("orcid: " + orcid);
                        System.out.println("CienciaID: " + CienciaID);
                        System.out.println("filiacao: " + filiacao);
                        System.out.println("GoogleScholarID: " + GoogleScholarID);
                        System.out.println("nomeCientifico: " + nomeCientifico);
                        System.out.println("email: " + email);

                        Author author = new Author(idNumber, name, address, birth, email, orcid, filiacao, CienciaID, GoogleScholarID, nomeCientifico);
                        addAuthor(author, id);

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
                        add_Edge(v, w, weight);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("AuthorsInGraph size: " + AuthorsInGraph.size());
    }

    /**
     * Writes the author data from the graph to a binary file.
     *
     * @param filepath The filepath where the binary file will be written.
     */
    public void readBinFromAuthorGraph(String filepath) {
        Logger.getLogger(AuthorWeightedGraph.class.getName()).log(Level.INFO, "readBinFromAuthorGraph(): write to text file " + filepath);
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filepath)))) {
            for (Integer id : AuthorsInGraph.keys()) {
                Author author = AuthorsInGraph.get(id);
                dos.writeBytes(author.toString());
            }
        } catch (IOException e) {
            Logger.getLogger(AuthorWeightedGraph.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Reads author data from a binary file and inputs it into the author graph.
     *
     * @param filepath The filepath of the binary file to be read.
     */
    public static void inputBinToAuthorGraph(String filepath) {
        Logger.getLogger(AuthorWeightedGraph.class.getName()).log(Level.INFO, "inputBinToAuthorGraph(): read from bin file " + filepath);
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filepath)))) {

            int size = dis.readInt();
            System.out.println("FileBinOutputStreamApp - inputBinToAuthorGraph(): size = " + size);
            for (int i = 0; i < size; i++) {
                double d = dis.readDouble();
                System.out.println("FileBinOutputStreamApp - inputBinToAuthorGraph(): data[" + i + "] = " + d);
            }
        } catch (Exception e) {
            Logger.getLogger(Thread.currentThread().getName()).log(Level.INFO, e.toString());
        }
    }

    /*public static void inputBinToAuthorGraph(String filepath) {
        Logger.getLogger(AuthorWeightedGraph.class.getName()).log(Level.INFO, "inputBinToAuthorGraph(): read from bin file " + filepath);
        try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(filepath)))) {
            // Assuming the file starts with an integer size indicating the length of the text
            int size = dis.readInt();
            System.out.println("FileBinOutputStreamApp - inputBinToAuthorGraph(): size = " + size);

            // Read the following bytes as UTF-8 encoded text
            byte[] bytes = new byte[size];
            dis.readFully(bytes);
            String text = new String(bytes, StandardCharsets.UTF_8);
            System.out.println("FileBinOutputStreamApp - inputBinToAuthorGraph(): text = " + text);
        } catch (IOException e) {
            Logger.getLogger(AuthorWeightedGraph.class.getName()).log(Level.SEVERE, e.toString());
        }
    }*/

}



