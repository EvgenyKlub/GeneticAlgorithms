package aco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Eugene on 03.07.2017.
 */
class GraphTest {

    Graph graph;

    @BeforeEach
    void setUp() {
        graph = new Graph();
        addVertex();
    }

    @Test
    void addVertex() {
        graph.addVertex(new Vertex("Vertex 1"));
        graph.addVertex(new Vertex("Vertex 2"));
        graph.addVertex(new Vertex("Vertex 3"));
    }

    @Test
    void searchVertexByName() {
        Vertex vertex = graph.searchVertexByName("Vertex 3");
        System.out.println(vertex);

        Vertex vertex1 = graph.searchVertexByName("Moscow");
        System.out.println(vertex1);
    }

    @Test
    void deleteVertex() {
        graph.deleteVertex("Vertex 1");
        System.out.println(graph);
    }

    @Test
    void getNumberOfVertices() {
    }

    @Test
    void toStringTest() {
        System.out.println(graph);
    }

}