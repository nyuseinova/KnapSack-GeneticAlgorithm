public class Main {

    public static void main(String[] args) {
        Individual[] items = new Individual[Constants.N];
        items[0] = new Individual("map", 90, 150);
        items[1] = new Individual("compass", 130, 35);
        items[2] = new Individual("water" ,1530, 200);
        items[3] = new Individual("sandwich", 500, 160);
        items[4] = new Individual("glucose", 150, 60);
        items[5] = new Individual("tin", 680, 45);
        items[6] = new Individual("banana", 270, 60);
        items[7] = new Individual("apple", 390, 40);
        items[8] = new Individual("cheese", 230, 30);
        items[9] = new Individual("beer", 520, 10);
        items[10] = new Individual("suntanCream", 110, 70);
        items[11] = new Individual("camera", 320, 30);
        items[12] = new Individual("tShirt", 240, 15);
        items[13] = new Individual("trousers", 480, 10);
        items[14] = new Individual("umbrella", 730, 40);
        items[15] = new Individual("waterproofTrousers", 420, 70);
        items[16] = new Individual("waterproofOverclothes", 430, 75);
        items[17] = new Individual("noteCase", 220, 80);
        items[18] = new Individual("sunglasses", 70, 20);
        items[19] = new Individual("towel", 180, 12);
        items[20] = new Individual("socks", 40, 50);
        items[21] = new Individual("book", 300, 10);
        items[22] = new Individual("notebook", 900, 1);
        items[23] = new Individual("tent", 200, 150);
        items[0].itemName = "A";


        Population population = new Population(items);
        population.generatePopulation();
        population.computeFitness();
        //population.printPopulationMatrix();
        int result1 = population.maxFitness();
        //System.out.println(result1);
        int result2 = 0;
        do {
            population.crossover();
            //population.printPopulationMatrix();
            population.mutation();
            //population.printPopulationMatrix();
            population.computeFitness();
            result2 = population.maxFitness();
        } while (Math.abs(result1 - result2) > Constants.epsilon);

        //population.printPopulationMatrix();
        //System.out.println(population.maxFitIndex);

        System.out.println("");
        System.out.println("Result after applying Genetic algorithm is: ");
        for (int i = 0; i < population.individuals.length; i++) {
            if(population.itemsMatrix[population.maxFitIndex][i].isIncluded == 1) {
                population.itemsMatrix[population.maxFitIndex][i].printIndividual();
            }
        }
    }
}
