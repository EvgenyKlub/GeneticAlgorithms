package aco;

/**
 * Created by Eugene on 03.07.2017.
 */
public class Edge {

    private Vertex startVertex;
    private Vertex endVertex;
    private double edgeWeight;
    private double edgePheromone;

    public Edge(Vertex startVertex, Vertex endVertex) {
        this(startVertex, endVertex, 0.0);
    }

    public Edge(Vertex startVertex, Vertex endVertex, double edgeWeight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.edgeWeight = edgeWeight;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public double getEdgeWeight() {
        return edgeWeight;
    }

    public void setEdgeWeight(double edgeWeight) {
        this.edgeWeight = edgeWeight;
    }

    public double getEdgePheromone() {
        return edgePheromone;
    }

    public void setEdgePheromone(double edgePheromone) {
        this.edgePheromone = edgePheromone;
    }

    @Override
    public String toString() {
        return "Edge {"  + startVertex.getVertexName() +
                ", " + endVertex.getVertexName() +
                ", edgeWeight = " + edgeWeight +
                '}';
    }
}
