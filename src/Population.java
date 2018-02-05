import java.util.Random;

public class Population {
    Individual[] individuals = new Individual[Constants.N];
    Individual[][] itemsMatrix = new Individual[Constants.maxPopulationSize][Constants.N];
    int[] populationFitnesses = new int[Constants.N];
    int individualFitness;
    int totalCapacity;
    int maxFitIndex;

    public Population(Individual[] ind) {
        individuals = ind;
        individualFitness = 0;
        totalCapacity = 0;
        maxFitIndex = 0;
    }

    void generatePopulation() {
        Random random = new Random();
        for (int i = 0; i < Constants.maxPopulationSize; i++) {
            for (int j = 0; j < individuals.length; j++) {
                individuals[j].isIncluded = Math.abs(random.nextInt() % 2);
                itemsMatrix[i][j] = individuals[j];
            }
        }
    }

    void computeFitness() {
        for (int i = 0; i < Constants.maxPopulationSize; i++) {
            for (int j = 0; j < Constants.N; j++) {
                if (itemsMatrix[i][j].isIncluded == 1) {
                    individualFitness += itemsMatrix[i][j].getValue();
                    totalCapacity += itemsMatrix[i][j].getWeight();
                }
                if (totalCapacity > Constants.W) {
                    individualFitness = 0;
                }
            }
            populationFitnesses[i] = individualFitness;
            individualFitness = 0;
        }
    }

    int maxFitness() {
        int maxFit = populationFitnesses[0];

        for (int i = 0; i < populationFitnesses.length; i++) {
            if (maxFit < populationFitnesses[i]) {
                maxFit = populationFitnesses[i];
                maxFitIndex = i;
            }
        }
        return maxFit;
    }

    void crossover() {
        Random random = new Random();

        int crossOverPoint = random.nextInt(Constants.N);
        for (int i = 0; i < Constants.maxPopulationSize - 1; i += 2) {
            for (int j =0; j < crossOverPoint; j++) {
                int temp = itemsMatrix[i][j].isIncluded;
                itemsMatrix[i][j].isIncluded = itemsMatrix[i + 1][j].isIncluded;
                itemsMatrix[i + 1][j].isIncluded =  temp;
            }
        }
    }

    void mutation() {
        Random random = new Random();

        for (int i = 0; i < Constants.maxPopulationSize; i++) {
            int mutationPoint = random.nextInt(Constants.N);
            if (itemsMatrix[i][mutationPoint].isIncluded == 0) {
                itemsMatrix[i][mutationPoint].isIncluded = 1;
            } else {
                itemsMatrix[i][mutationPoint].isIncluded = 0;
            }
        }
    }

}
