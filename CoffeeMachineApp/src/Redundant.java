import java.util.Scanner;

/************************* BELOW NOT BE USED FOR FINAL APP ************************************/

public class Redundant {

    // a method that prints each step of the coffee making process (latte/cappuccino only)
    public void processScreen() {
        System.out.println();
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
        System.out.println();
    }


    // a method that calculates how much ingredients is needed based on how many cups user wants
    public void calculateIngredientsPerCups(String type) {
        // ask user for input
        System.out.println("Write how many cups of coffee you will need: ");
        // create scanner object to process input(s)
        Scanner scanner = new Scanner(System.in);
        // process the input
        int cupsNeeded = scanner.nextInt();
        //int cups = Integer.parseInt(input); // alternate way to process integers
        // scanner.close() // close scanner?

        // create and initialize variables for each type of coffee
        int water = 0;
        int milk = 0;
        int coffeeBeans = 0;

        // switch statement
        switch (type.toLowerCase()) { // use toLowerCase() to avoid upper-cases
            case "espresso":
                // calculate each ingredient based on how many cups are needed (for espressos)
                water = 250 * cupsNeeded;  // 250 ml of water (1 cup)
                milk = 0;   //  0 ml of milk (1 cup)
                coffeeBeans = 16 * cupsNeeded;  //  16 g of coffee beans (1 cup)
                break;
            case "latte":
                // calculate each ingredient based on how many cups are needed (for lattes)
                water = 200 * cupsNeeded; // 200 ml of water (1 cup)
                milk = 75 * cupsNeeded;   //  75 ml of milk (1 cup)
                coffeeBeans = 20 * cupsNeeded;  //  20 g of coffee beans (1 cup)
                break;
            case "cappuccino":
                // calculate each ingredient based on how many cups are needed (for cappuccinos)
                water = 200 * cupsNeeded; // 200 ml of water (1 cup)
                milk = 100 * cupsNeeded;   //  100 ml of milk (1 cup)
                coffeeBeans = 12 * cupsNeeded;  //  12 g of coffee beans (1 cup)
                break;
            default:
                // display an error if user input is invalid
                System.out.println("Error, that is invalid coffee type.");
                // restart the method until user enters correct choice
                calculateIngredientsPerCups(type);
        }

        /* *** used only when one coffee type is used (section 1-3) ***
        // calculate each ingredient based on cup amount
        int water = 200 * cupsNeeded; // 200 ml of water (1 cup)
        int milk = 50 * cupsNeeded;   //  50 ml of milk (1 cup)
        int coffeeBeans = 15 * cupsNeeded;  //  15 g of coffee beans (1 cup) */

        // print the amount of ingredients needed for x amount of cups entered by user
        System.out.println("For " + cupsNeeded + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
    }

    // a method that calculates how many cups the coffee machine can make based on available ingredients
    public void calculateCupsPerIngredients(String type) {
        // create scanner object to process input(s)
        Scanner scanner = new Scanner(System.in);
        /** ask user for input regarding ingredients and process each input **/
        // ask user for water amount
        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterSupply = scanner.nextInt(); // process input
        // ask user for milk amount
        System.out.println("Write how many ml of milk the coffee machine has:  ");
        int milkSupply = scanner.nextInt(); // process input
        // ask user for coffee beans amount
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeanSupply = scanner.nextInt(); // process input
        // ask user how many cups of coffee is wanted
        System.out.println("Write how many cups of coffee you will need: ");
        int cupsDesired = scanner.nextInt(); // process input

        //scanner.close(); // close scanner?

        // create a count variable and initialize
        int cupCount = 0;

        // create variables and initialize
        int waterPerCup = 0;
        int milkPerCup = 0;
        int coffeeBeansPerCup = 0;

        // switch statement
        switch (type.toLowerCase()) {
            case "espresso":
                // ingredients for espresso
                waterPerCup = 250;
                milkPerCup = 0;
                coffeeBeansPerCup = 16;
                break;
            case "latte":
                // ingredients for latte
                waterPerCup = 200;
                milkPerCup = 75;
                coffeeBeansPerCup = 20;
                break;
            case "cappuccino":
                // ingredients for cappuccino
                waterPerCup = 200;
                milkPerCup = 100;
                coffeeBeansPerCup = 12;
                break;
            default:
                // display an error if user input is invalid
                System.out.println("Error, that is invalid coffee type.");
                // restart the method until user enters correct choice
                calculateCupsPerIngredients(type);
        }

        /** a loop that keeps track of how many cups of coffee can be made based on available ingredients:
         while there is enough ingredients to make one cup of coffee **/
        while ((waterSupply >= waterPerCup) && (milkSupply >= milkPerCup) && (coffeeBeanSupply >= coffeeBeansPerCup)) {
            // keep decrementing respective ingredient values by the amount each can make 1 cup of coffee of
            waterSupply -= waterPerCup;
            milkSupply -= milkPerCup;
            coffeeBeanSupply -= coffeeBeansPerCup;
            // keep track of number of cups created each time the above gets decrement by the appropriate amount
            cupCount++; // increment count
        }
        // let the user know if the amount of cups the machine can make exceeds the what the user asks for
        // (in the case there is a surplus of coffee)
        if (cupCount > cupsDesired) {
            // print how many extra cups the machine can make based on available ingredients
            System.out.println("Yes, I can make that amount of coffee (and even "
                    + (cupCount - cupsDesired) + " more than that)");
        }
        // let the user know if the amount of cups wanted matches exactly the amount of cups available
        else if (cupsDesired == cupCount) {
            System.out.println("Yes, I can make that amount of coffee");
        }
        // otherwise let the user know how many cups the machine can only make
        else {
            System.out.println("No, I can make only " + cupCount + " cup(s) of coffee");
        }
    }

    /************************* ABOVE NOT BE USED FOR FINAL APP ************************************/


}
