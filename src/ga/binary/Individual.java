package ga.binary;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Individual {

    private static Logger logger = Logger.getLogger(Individual.class.getName());

    private int[] chromosome;
    public static final int DEFAULT_LENGTH = 64;
    private double fitness = -1;

    public Individual() {
        this(DEFAULT_LENGTH);
    }

    public Individual(int[] chromosome) {
        // Create individual chromosome
        this.chromosome = chromosome;
    }

    public Individual(Individual individual) {
        this.chromosome = individual.getChromosome();
        this.fitness = individual.getFitness();
    }

    public Individual(int chromosomeLength) {
        this.chromosome = new int[chromosomeLength];

        for (int geneIndex = 0; geneIndex < chromosomeLength; geneIndex++) {
            if (0.5 < Math.random()) {
                this.setGene(geneIndex, 1);
            } else {
                this.setGene(geneIndex, 0);
            }
        }
    }

    public Individual(String strChromosome) {
        Pattern pattern = Pattern.compile("[01]+");
        Matcher matcher = pattern.matcher(strChromosome);

        if (matcher.matches()) {
            chromosome = new int[strChromosome.length()];

            for (int index = 0; index < strChromosome.length(); index++) {
                chromosome[index] = Character.getNumericValue(strChromosome.charAt(index));
            }

        } else {
            logger.info("Incorrect chromosome representation! Expected binary format!\n");
            System.exit(-1);
        }
    }

    public int[] getChromosome() {
        return chromosome;
    }

    public int getChromosomeLength() {
        return chromosome.length;
    }

    public void setGene(int geneIndex, int gene) {
        chromosome[geneIndex] = gene;
    }

    public int getGene(int geneIndex) {
        return chromosome[geneIndex];
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public double getFitness() {
        return fitness;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Individual {");
        for (int gene : chromosome) {
            sb.append(gene);
        }
        sb.append(", fitness = ");
        sb.append(fitness);
        sb.append("}");

        return sb.toString();

//        return "Individual {" +
//                "chromosome = " + Arrays.toString(chromosome) +
//                ", fitness = " + fitness +
//                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Individual that = (Individual) o;

        if (Double.compare(that.fitness, fitness) != 0) return false;
        return Arrays.equals(chromosome, that.chromosome);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Arrays.hashCode(chromosome);
        temp = Double.doubleToLongBits(fitness);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
