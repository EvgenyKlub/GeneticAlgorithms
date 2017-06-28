package ga.binary;

import org.junit.jupiter.api.Test;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class IndividualTest {

    private static Logger logger = Logger.getLogger(IndividualTest.class.getName());

    @Test
    void testIndividual() {
        Individual individual = new Individual();
        logger.info("Chromosome length: " + individual.getChromosomeLength());

        int[] chromosome = { 1, 0, 1, 1, 0, 1, 0, 0 };
        Individual individual1 = new Individual(chromosome);
        logger.info("Size: " + individual1.getChromosomeLength());
        logger.info("Gene: " + individual1.getGene(6));

        Individual individual2 = new Individual(individual);
        logger.info(individual2.toString());
        individual2.setFitness(15);
        logger.info("Individual2 fitness: " + individual2.getFitness());

        Individual strIndividual = new Individual("001100110");
        logger.info("Constructor with string representation: " + strIndividual);
    }
}