package ga.binary;

public interface GeneticAlgorithmInterface {

    Population createInitialPopulation(int chromosomeLength);
    void evaluate(Population population, FitnessFunctionInterface fitnessFunction);
    public Individual selectParent(Population population);
    Population crossover(Population population, SelectionMethod selectionMethod);
    Population mutate(Population population);
    boolean isTerminated(Population population);

}
