package ga.binary;

import org.junit.jupiter.api.Test;

class BinaryGeneticAlgorithmTest {
    @Test
    void testSelection() {
        BinaryGeneticAlgorithm bga = new BinaryGeneticAlgorithm(
                6, 0.95, 0.01, 0);
        Population population = bga.createInitialPopulation(10);

        FitnessFunction fitnessFunction = new FitnessFunction();

        bga.evaluate(population, fitnessFunction);
        System.out.println("Eval Population: " + population);

        Individual fittest = bga.selectParent(population);
        System.out.println("-> Fittest individual: " + fittest);
    }

    @Test
    void testGA() {
        BinaryGeneticAlgorithm bga = new BinaryGeneticAlgorithm(
                100, 0.95, 0.001, 2);
        Population population = bga.createInitialPopulation(50);

        FitnessFunction fitnessFunction = new FitnessFunction();

        bga.evaluate(population, fitnessFunction);
        int generation = 1;

//        System.out.println(population);
//
//        population = bga.crossover(population, SelectionMethod.TOURNAMENT_SELECTION);
//        bga.evaluate(population, fitnessFunction);
//        System.out.println(population);


        while (!bga.isTerminated(population)) {
            System.out.println("Best solution: " + population.getFittestIndividual());

            // Apply crossover
            population = bga.crossover(population, SelectionMethod.ROULETTE_WHEEL_SELECTION);

            // Evaluate population
            bga.evaluate(population, fitnessFunction);

            ++generation;
        }

        System.out.println("Found solution in " + generation + " generations!");
        System.out.println("---=== Best solution: " + population.getFittestIndividual());
    }
}