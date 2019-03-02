package part1;

import java.util.Objects;

public class Edge {

    private int dest;

    private int source;

    private double weight;

    public int getDest() {
        return dest;
    }

    public int getSource() {
        return source;
    }

    public double getWeight() {
        return weight;
    }

    public Edge(int source,int dest){
        this.dest=dest;
        this.source=source;
        this.weight=1.0;
    }
    public Edge(int source,int dest,double w){
        this.dest=dest;
        this.source=source;
        this.weight=w;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return dest == edge.dest &&
                source == edge.source &&
                Double.compare(edge.weight, weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dest, source, weight);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "dest=" + dest +
                ", source=" + source +
                ", weight=" + weight +
                '}';
    }
}
