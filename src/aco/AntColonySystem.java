package aco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Eugene on 28.06.2017.
 */
public class AntColonySystem {

    /**
     * Parameters for the ACO algorithm:
     *
     * N - number of ants in the colony
     * alpha - pheromone importance
     * beta - heuristic information importance
     * Q - deposition of pheromone
     * evaporationRate - evaporation percent in every iteration
     * randomness - random of the simulation
     */
    private int N = 10;
    private double alpha;
    private double beta;
    private double Q;
    private double evaporationRate;

    private Random random = new Random(System.currentTimeMillis());
    private Graph graphTSP = new Graph();
    private List<Ant> ants = new ArrayList<>();
    private double[] probabilities;

    public AntColonySystem() {
        for (int i = 0; i < N; i++) {
            ants.add(new Ant());
        }
    }

    public AntColonySystem(int N, double alpha, double beta, double q, double evaporationRate) {
        this.N = N;
        this.alpha = alpha;
        this.beta = beta;
        Q = q;
        this.evaporationRate = evaporationRate;

        for (int i = 0; i < N; i++) {
            ants.add(new Ant());
        }
    }

    public Graph generateRandomEnvironment(int numberOfNodes) {
        for (int i = 0; i < numberOfNodes; i++) {
            Vertex vertex = new Vertex(String.valueOf(i + 1));
            graphTSP.addVertex(vertex);
        }

        for (int vertexIndex = 0; vertexIndex < graphTSP.getNumberOfVertices(); vertexIndex++) {
            Vertex startVertex = graphTSP.searchVertexByName(String.valueOf(vertexIndex + 1));

            for (int edgeIndex = vertexIndex; edgeIndex < graphTSP.getNumberOfVertices(); edgeIndex++) {
                if (edgeIndex != vertexIndex) {
                    Vertex endVertex = graphTSP.searchVertexByName(String.valueOf(edgeIndex + 1));

                    double randomEdgeWeight = random.nextDouble() * 500;
                    Edge vertexEdge = startVertex.addAdjacentVertex(endVertex, randomEdgeWeight);
                    endVertex.getVertexEdges().add(vertexEdge);
                }
            }
        }

        return graphTSP;
    }

    public void setAntsStartNodes() {
        for (Ant ant : ants) {
            ant.resetVisitedNodes();
            Vertex nextNode = graphTSP.getVertexList().get(random.nextInt(graphTSP.getNumberOfVertices()));
            ant.visitNode(nextNode);
        }

    }

    public Graph getGraphTSP() {
        return graphTSP;
    }

    public void setGraphTSP(Graph graphTSP) {
        this.graphTSP = graphTSP;
    }

    public void run() {

    }

}
