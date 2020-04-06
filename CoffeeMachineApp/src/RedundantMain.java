/********************* ORIGINAL SIMULATION FOR EARLIER SECTIONS (NOT PART OF FINAL APP) ****************/

// Main class
public class RedundantMain { // change class name to simulate later
    // main method
    public static void main(String[] args) {

        // create new coffee object
        final Redundant coffeeObj = new Redundant();

        // prints process screen/
        coffeeObj.processScreen();

        // calculates the ingredients needed to make x number of cups
        coffeeObj.calculateIngredientsPerCups("latte");

        // tells you how many cups can be made given the available ingredients
        coffeeObj.calculateCupsPerIngredients("espresso");
    }
}

