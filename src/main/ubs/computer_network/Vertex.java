package main.ubs.computer_network;

import java.util.List;
import java.util.Objects;

public final class Vertex {
    private final List<AdjacentVertex> adjVertices;
    private final String ip;

    public Vertex(List<AdjacentVertex> adjVertices, String ip) {
        this.adjVertices = adjVertices;
        this.ip = ip;
    }

    public List<AdjacentVertex> getAdjacentVertices() {
        return adjVertices;
    }

    public String getIp() {
        return ip;
    }

    public static final class AdjacentVertex {
        private final String ip;
        private final long ping;

        public AdjacentVertex(String ip, long ping) {
            this.ip = ip;
            this.ping = ping;
        }

        public String getIp() {
            return ip;
        }

        public long getPing() {
            return ping;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return ip.equals(vertex.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }
}