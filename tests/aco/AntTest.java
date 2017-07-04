package aco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Eugene on 04.07.2017.
 */
class AntTest {

    Ant ant;

    @BeforeEach
    void setUp() {
        ant = new Ant();
    }

    @Test
    void visitNode() {
        ant.visitNode(new Vertex("Moscow"));
        ant.visitNode(new Vertex("Uzlowaya"));
        ant.visitNode(new Vertex("Vidnoe"));
    }

    @Test
    void visited() {
    }

    @Test
    void calculateTourLength() {
    }

    @Test
    void resetVisitedNodes() {
    }

}