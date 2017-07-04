package aco;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eugene on 28.06.2017.
 */
public class Ant {

    private int trailSize;
    private List<Vertex> visitedNodes = new ArrayList<>();

    public Ant() {
    }

    public Ant(int tourSize) {
        this.trailSize = trailSize;
    }

    public void visitNode(Vertex node) {
        visitedNodes.add(node);
    }

    public boolean visited(Vertex node) {
        return visitedNodes.contains(node);
    }

    public double calculateTourLength() {
        double tourLength = 0.0;

        if (visitedNodes.isEmpty() || visitedNodes.size() == 1) {
            return tourLength;
        }

        for (int vertexIndex = 1; vertexIndex < visitedNodes.size(); vertexIndex++) {
            List<Edge> vertexEdges = visitedNodes.get(vertexIndex).getVertexEdges();
            Vertex prevVertex = visitedNodes.get(vertexIndex - 1);

            for (int edgeIndex = 0; edgeIndex < vertexEdges.size(); edgeIndex++) {
                Edge currentEdge = vertexEdges.get(edgeIndex);

                if ( prevVertex.getVertexName().equals(currentEdge.getStartVertex().getVertexName()) ||
                        prevVertex.getVertexName().equals(currentEdge.getEndVertex().getVertexName())) {
                    tourLength += currentEdge.getEdgeWeight();
                }
            }
        }

        return tourLength;
    }

    public List<Vertex> getVisitedNodes() {
        return visitedNodes;
    }

    public void resetVisitedNodes() {
        visitedNodes.clear();
    }

}
