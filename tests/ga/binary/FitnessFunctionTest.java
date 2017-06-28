package ga.binary;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

class FitnessFunctionTest {

    private static Logger logger = Logger.getLogger(FitnessFunctionTest.class.getName());

    @Test
    void run() {
        FitnessFunction fitnessFunction = new FitnessFunction();
        Individual individual = new Individual();
        double fitness = fitnessFunction.run(individual);

        logger.info("Fitness value of individual [" + individual +"]: " + fitness);
        logger.info("Individual's fitness: " + individual.getFitness());
    }

}