package main.ubs.computer_network;

import java.util.Objects;

public final class Edge {
    private final long ping;
    private final Vertex firstServer;
    private final Vertex secondServer;

    public Edge(long ping, Vertex firstServer, Vertex secondServer) {
        this.ping = ping;
        this.firstServer = firstServer;
        this.secondServer = secondServer;
    }

    public long getPing() {
        return ping;
    }

    public Vertex getFirstServer() {
        return firstServer;
    }

    public Vertex getSecondServer() {
        return secondServer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        int minServerIp = Math.min(Integer.parseInt(firstServer.getIp()),
                Integer.parseInt(secondServer.getIp()));
        String minServerIp1 =Integer.toString(minServerIp);

        int maxServerIp = Math.max(Integer.parseInt(firstServer.getIp()),
                Integer.parseInt(secondServer.getIp()));
        String maxServerIp1 = Integer.toString(maxServerIp);

        int edgeMinServerIp = Math.min(Integer.parseInt(edge.firstServer.getIp()),
                Integer.parseInt(edge.secondServer.getIp()));
        String edgeMinServerIp1 = Integer.toString(edgeMinServerIp);

        int edgeMaxServerIp = Math.max(Integer.parseInt(edge.firstServer.getIp()),
                Integer.parseInt(edge.secondServer.getIp()));
        String edgeMaxServerIp1 = Integer.toString(edgeMaxServerIp);

        return ping == edge.ping && Objects.equals(minServerIp1, edgeMinServerIp1) &&
                Objects.equals(maxServerIp1, edgeMaxServerIp1);
    }

    @Override
    public int hashCode() {
        int minIp = Math.min(Integer.parseInt(firstServer.getIp()), Integer.parseInt(secondServer.getIp()));
        String minIpString = Integer.toString(minIp);
        int maxIp = Math.max(Integer.parseInt(firstServer.getIp()), Integer.parseInt(secondServer.getIp()));
        String maxIpString = Integer.toString(maxIp);
        return Objects.hash(ping, minIpString, maxIpString);
    }
}