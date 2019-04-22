package main.ubs.computer_network;

import java.util.Collections;
import java.util.LinkedList;

public class NetworkMain {

    public static void main(String[] args) {

        final String ADDRESS_1 = "127.0.0.0";
        final String ADDRESS_2 = "192.168.0.0";

        Graph graph = new Graph();
        graph.addVertex(ADDRESS_1);
        graph.addVertex(ADDRESS_2);
        graph.addEdge(ADDRESS_1, ADDRESS_2,10);
        graph.getPath(ADDRESS_1, ADDRESS_2);
        System.out.println(graph.getPath(ADDRESS_1, ADDRESS_2));
        System.out.println(graph.getVertex(ADDRESS_1));
    }
}
