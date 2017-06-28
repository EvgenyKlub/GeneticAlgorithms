package ga.binary;

import java.util.Arrays;
import java.util.Collections;

public class FitnessFunction implements FitnessFunctionInterface {

    @Override
    public double run(Individual individual) {

        int correctGenes = 0;
        for (int gene : individual.getChromosome()) {
            if (gene == 1) {
                ++correctGenes;
            }
        }

        double fitnessValue = (double) correctGenes / individual.getChromosomeLength();
        individual.setFitness(fitnessValue);

        return fitnessValue;

    }

}
