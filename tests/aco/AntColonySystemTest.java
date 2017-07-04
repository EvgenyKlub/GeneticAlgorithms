package aco;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Eugene on 04.07.2017.
 */
class AntColonySystemTest {

    AntColonySystem aco;

    @BeforeEach
    void setUp() {
        aco = new AntColonySystem();
    }

    @Test
    void generateRandomEnvironment() {
        aco.generateRandomEnvironment(5);
        //System.out.println(aco.getGraphTSP());

    }

    @Test
    void setAntsStartNodes() {
        aco.generateRandomEnvironment(5);
        aco.setAntsStartNodes();

    }

    @Test
    void getGraphTSP() {
    }

    @Test
    void setGraphTSP() {
    }

}