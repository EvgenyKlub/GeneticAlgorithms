package ga.binary;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

class PopulationTest {

    private static Logger logger = Logger.getLogger(PopulationTest.class.getName());
    Population population;

    @BeforeEach
    void setUp() {
        population = new Population(50);
        logger.info("Population successfully created!");
    }

    @Test
    void getPopulation() {
        logger.info("Current population: " + population.getPopulation());
    }

    @Test
    void setIndividual() {
        int index = 15;
        population.setIndividual(index, new Individual());
        logger.info("Set [" + index + "] individual: " + population.getIndividual(index));
    }

    @Test
    void getIndividual() {
        int index = 7;
        logger.info("Get [" + index + "] individual: " + population.getIndividual(index));
    }

    @Test
    void addIndividual() {
        population.addIndividual(new Individual());
        logger.info("Test addition of an individual to population");
    }

    @Test
    void getFittestIndividual() {
        logger.info("Get the fittest individual: " + population.getFittestIndividual());
    }

    @Test
    void populationSize() {
        logger.info("Population size: " + population.getPopulationSize());
    }

}