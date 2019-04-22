package main.ubs.computer_network;

import java.util.List;

public interface IGraph {

    void addVertex(String ip);

    void addEdge(String firstServer, String secondServer, long ping);

    Vertex getVertex(String ip);

    List<Edge> getEdge(long ping);

    Path getPath(String firstServer, String secondServer);
}
