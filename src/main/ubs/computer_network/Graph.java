package main.ubs.computer_network;

import java.util.*;
import java.util.stream.Collectors;

public class Graph implements IGraph{

    private final Map<String, Map<String, Long>> adjVertices = new LinkedHashMap<>();

    @Override
    public void addVertex(String ip) {
        adjVertices.putIfAbsent(ip, new LinkedHashMap<>());
    }

    @Override
    public void addEdge(String firstServer, String secondServer, long ping) {
        if (adjVertices.containsKey(firstServer) && adjVertices.containsKey(secondServer)) {
            adjVertices.get(firstServer).put(secondServer, ping);
            adjVertices.get(secondServer).put(firstServer, ping);
        }
    }

    @Override
    public Vertex getVertex(String ip) {
        var adjacentVertices = adjVertices.get(ip).entrySet().stream()
                .map(entry -> new Vertex.AdjacentVertex(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        return new Vertex(adjacentVertices, ip);
    }


    @Override
    public List<Edge> getEdge(long ping) {
        return adjVertices.entrySet().stream().flatMap(firstNode ->
                firstNode.getValue().entrySet().stream()
                .map(secondNode ->
                        new Edge(secondNode.getValue(),
                        getVertex(firstNode.getKey()),
                        getVertex(secondNode.getKey()))))
                .filter(edge -> edge.getPing() == ping).distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Path getPath(String firstServer, String secondServer) {

        IpPath shortestPath = findShortestPath(firstServer, firstServer, secondServer, new IpPath(0, new ArrayList<>()));

        List<Vertex> route = shortestPath.neighboresRoute.stream()
                .map(this::getVertex)
                .collect(Collectors.toList());
        return new Path(shortestPath.maxPing, route);
    }

    private IpPath findShortestPath(String last, String start, String end, IpPath path) {
        long pingHere = path.maxPing + ((last.equals(start)) ? 0 : adjVertices.get(last).get(start));
        var routeHere = new ArrayList<>(path.neighboresRoute);
        routeHere.add(start);
        IpPath pathHere = new IpPath(pingHere, routeHere);

        if (start.equals(end)) {
            return pathHere;
        }

        return adjVertices.get(start).keySet().stream()
                .filter(midServer -> !path.neighboresRoute.contains(midServer))
                .map(ip -> findShortestPath(start, ip, end, pathHere))
                .filter(Objects::nonNull)
                .min(Comparator.comparingLong(IpPath::getmaxPing))
                .orElse(null);
    }
    private static final class IpPath {
        private final long maxPing;
        private final List<String> neighboresRoute;

        IpPath(long maxPing, List<String> neighboresRoute) {
            this.maxPing = maxPing;
            this.neighboresRoute = neighboresRoute;
        }

        long getmaxPing() {
            return maxPing;
        }
    }
}
