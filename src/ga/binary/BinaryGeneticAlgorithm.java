package ga.binary;

import java.util.Random;

public class BinaryGeneticAlgorithm implements GeneticAlgorithmInterface {

    private int populationSize;
    private double crossoverRate;
    private double mutationRate;
    private int elitism;
    private int generationCount;
    private Population initialPopulation;
    private SelectionMethod selectionMethod = SelectionMethod.ROULETTE_WHEEL_SELECTION;

    public BinaryGeneticAlgorithm(int populationSize, double crossoverRate, double mutationRate, int elitism) {
        this.populationSize = populationSize;
        this.crossoverRate = crossoverRate;
        this.mutationRate = mutationRate;
        this.elitism = elitism;
        this.initialPopulation = new Population(populationSize);
    }

    @Override
    public Population createInitialPopulation(int chromosomeLength) {
        return (new Population(populationSize, chromosomeLength));
    }

    @Override
    public void evaluate(Population population, FitnessFunctionInterface fitnessFunction) {
        double populationFitness = 0.0;

        for (Individual individual : population.getPopulation()) {
            populationFitness += fitnessFunction.run(individual);
        }

        population.setPopulationFitness(populationFitness);
    }

    public Individual selectParent(Population population) {
        Individual selectedParent;

        // Apply selection method
        switch (this.selectionMethod) {
            case ROULETTE_WHEEL_SELECTION:
                selectedParent = rouletteWheelSelection(population);
                break;
            case TOURNAMENT_SELECTION:
                selectedParent = tournamentSelection(population);
                break;
            default:
                selectedParent = rouletteWheelSelection(population);
        }

        return selectedParent;
    }

    // Roulette-wheel selection method
    public Individual rouletteWheelSelection(Population population) {
        double sumFitness = population.getPopulationFitness();
        double randomValue = Math.random() * sumFitness;

        for (int i = 0; i < population.getPopulationSize(); i++) {
            randomValue -= population.getIndividual(i).getFitness();

            if (randomValue <= 0) {
                return population.getIndividual(i);
            }
        }

        return population.getIndividual(population.getPopulationSize() - 1);
    }

    // Tournament selection method
    public Individual tournamentSelection(Population population) {
        Random random = new Random(System.currentTimeMillis());
        int tournamentSize = random.nextInt(population.getPopulationSize() - 2) + 2;

        // Create new tournament population with a random size
        Population tournamentPopulation = new Population(tournamentSize);

        for (int i = 0; i < tournamentPopulation.getPopulationSize(); i++) {
            Individual individual = population.getIndividual(random.nextInt(population.getPopulationSize()));
            tournamentPopulation.setIndividual(i, individual);
        }

        return tournamentPopulation.getFittestIndividual();
    }

    @Override
    public Population crossover(Population population, SelectionMethod selectionMethod) {
        Population nextGeneration = new Population(population.getPopulationSize());
        this.selectionMethod = selectionMethod;

        for (int i = 0; i < population.getPopulationSize(); i++) {
            Individual parent1 = population.getIndividual(i);

            if (crossoverRate > Math.random() && i > elitism) {
                Individual parent2;
                do {
                    parent2 = selectParent(population);
                } while (parent2.equals(parent1));

                // Apply one of crossover methods
                Individual offspring = uniformCrossover(parent1, parent2);
                nextGeneration.setIndividual(i, offspring);

            } else {
                nextGeneration.setIndividual(i, parent1);
            }
        }

        return nextGeneration;
    }

    public Individual uniformCrossover(Individual parent1, Individual parent2) {
        Individual offspring = new Individual(parent1.getChromosomeLength());

        // Loop over genome
        for (int geneIndex = 0; geneIndex < parent1.getChromosomeLength(); geneIndex++) {
            if (0.5 > Math.random()) {
                offspring.setGene(geneIndex, parent1.getGene(geneIndex));
            } else {
                offspring.setGene(geneIndex, parent2.getGene(geneIndex));
            }
        }

        return offspring;
    }

    @Override
    public Population mutate(Population population) {
        return null;
    }

    @Override
    public boolean isTerminated(Population population) {
        for (Individual individual : population.getPopulation()) {
            if (individual.getFitness() == 1) {
                return true;
            }
        }

        return false;
    }

    public int getGenerationCount() {
        return generationCount;
    }

    public void setGenerationCount(int generationCount) {
        this.generationCount = generationCount;
    }

    public SelectionMethod getSelectionMethod() {
        return selectionMethod;
    }

    public void setSelectionMethod(SelectionMethod selectionMethod) {
        this.selectionMethod = selectionMethod;
    }
}
