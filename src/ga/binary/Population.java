package ga.binary;

import java.util.ArrayList;
import java.util.logging.Logger;

public class Population {

    private static Logger logger = Logger.getLogger(Population.class.getName());

    ArrayList<Individual> population;
    private double populationFitness = -1;

    public Population(int populationSize) {
        this(populationSize, Individual.DEFAULT_LENGTH);
    }

    public Population(int populationSize, int chromosomeLength) {
        population = new ArrayList<>();

        for (int i = 0; i < populationSize; i++) {
            population.add(new Individual(chromosomeLength));
        }
    }

    public Population(ArrayList<Individual> population) {
        this.population = new ArrayList<>(population);
    }

    public ArrayList<Individual> getPopulation() {
        return population;
    }

    public void setIndividual(int index, Individual individual) {
        population.set(index, individual);
    }

    public Individual getIndividual(int index) {
        return population.get(index);
    }

    public void addIndividual(Individual individual) {
        population.add(individual);
    }

    public Individual getFittestIndividual() {
        population.sort((o1, o2) -> {
            if (o1.getFitness() > o2.getFitness()) {
                return -1;
            } else if (o1.getFitness() < o2.getFitness()) {
                return 1;
            }
            return 0;
        });

        return population.get(0);
    }

    public int getPopulationSize() {
        return population.size();
    }

    public double getPopulationFitness() {
        return populationFitness;
    }

    public void setPopulationFitness(double populationFitness) {
        this.populationFitness = populationFitness;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Population {");
        for (Individual individual : population) {
            sb.append(individual.toString() + '\n');
        }
        sb.append("}");

        return sb.toString();

//        return "Population {" +
//                "population = " + population +
//                '}';
    }
}
