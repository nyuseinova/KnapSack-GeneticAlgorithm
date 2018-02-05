public class Individual {
    int weight;
    int value;
    String itemName;
    int isIncluded;

    public Individual() {
        itemName = "";
        weight = 0;
        value = 0;
    }

    public Individual(String name, int weight, int value) {
        itemName = name;
        this.weight = weight;
        this.value = value;
    }

    public void printIndividual() {
        System.out.println("Item, included in the Knapsack : " + itemName + " " + weight + " " + value);
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
         return value;
    }

}

