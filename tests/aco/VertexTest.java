package aco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Eugene on 03.07.2017.
 */
class VertexTest {

    Vertex vertex;

    @BeforeEach
    void setUp() {
        vertex = new Vertex("Vertex 1");
    }

    @Test
    void getVertexName() {
        String vertexName = vertex.getVertexName();
        System.out.println(vertexName);
    }

    @Test
    void setVertexName() {
        vertex.setVertexName("New vertex Name");
        System.out.println(vertex.getVertexName());
    }

    @Test
    void addAdjacentVertex() {
        vertex.addAdjacentVertex(new Vertex("Vertex 2"), 0);
        System.out.println(vertex);
    }

    @Test
    void toStringTest() {
        System.out.println(vertex);
    }

}