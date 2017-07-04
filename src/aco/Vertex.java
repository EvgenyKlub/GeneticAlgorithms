package aco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene on 03.07.2017.
 */
public class Vertex {

    private String vertexName;
    private List<Edge> vertexEdges = new ArrayList<>();

    public Vertex(String vertexName) {
        this.vertexName = vertexName;
    }

    public Vertex(String vertexName, ArrayList<Edge> edges) {
        this.vertexName = vertexName;
        this.vertexEdges = edges;
    }

    public String getVertexName() {
        return vertexName;
    }

    public void setVertexName(String vertexName) {
        this.vertexName = vertexName;
    }

    public Edge addAdjacentVertex(Vertex adjVertex, double edgeWeight) {
        Edge edge = new Edge(this, adjVertex, edgeWeight);
        vertexEdges.add(edge);

        return edge;
    }

    public boolean isAdjacent(Vertex adjVertex) {
        for (Edge edge : vertexEdges) {
            if (edge.getEndVertex().getVertexName().equals(adjVertex)) {
                return true;
            }
        }

        return false;
    }

    public List<Edge> getVertexEdges() {
        return vertexEdges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Vertex {\n" +
                "vertexName = '" + vertexName + "\',\n" +
                "vertexEdges: \n");
        for (Edge edge : vertexEdges) {
            sb.append(edge.toString() + '\n');
        }
        sb.append("}");

        return sb.toString();
    }
}
