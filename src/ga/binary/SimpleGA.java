package ga.binary;

import java.util.logging.Logger;

public class SimpleGA {

    private static Logger logger = Logger.getLogger(SimpleGA.class.getName());

    public static void main(String[] args) {

        // Genetic Algorithm parameters
        int populationSize = 100;
        double crossoverRate = 0.95;
        double mutationRate = 0.001;
        int elitism = 2;

        BinaryGeneticAlgorithm binaryGA =
                new BinaryGeneticAlgorithm(populationSize, crossoverRate, mutationRate, elitism);

        Population population = binaryGA.createInitialPopulation(50);
        FitnessFunction fitnessFunction = new FitnessFunction();

        // Evaluate population (each individual's fitness value)
        binaryGA.evaluate(population, fitnessFunction);
        int generation = 1;

        while (!binaryGA.isTerminated(population)) {
            // Print fittest individual from population
            //System.out.println("Best solution: " + population.getFittestIndividual());

            // Apply crossover
            population = binaryGA.crossover(population, SelectionMethod.TOURNAMENT_SELECTION);

            // TODO Apply mutation

            // Evaluate the current generation
            binaryGA.evaluate(population, fitnessFunction);

            ++generation;
        }

        System.out.println("Found solution in " + generation + " generations!");
        System.out.println("---=== Best solution: " + population.getFittestIndividual());
    }

}
