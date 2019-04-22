package main.ubs.computer_network;

import java.util.List;
import java.util.Objects;

public final class Path {
    private final long totalCombinedPing;
    private final List<Vertex> neighborsRoute;

    public Path(long totalCombinedPing, List<Vertex> neighborsRoute) {
        this.totalCombinedPing = totalCombinedPing;
        this.neighborsRoute = neighborsRoute;
    }

    public long getTotalCombinedPing() {
        return totalCombinedPing;
    }

    public List<Vertex> getNeighborsRoute() {
        return neighborsRoute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path path = (Path) o;
        return totalCombinedPing == path.totalCombinedPing && Objects.equals(neighborsRoute, path.neighborsRoute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCombinedPing, neighborsRoute);
    }
}