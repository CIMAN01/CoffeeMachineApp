/******************** COFFEE MACHINE APP SOURCE CODE by Cameron Imanpour **********************************/
/********************** FINAL VERSION: April 5, 2020 ******************************************************/

import java.util.Scanner;

// CoffeeMachine class
public class CoffeeMachine {

    /** fields **/

    // a boolean condition that tells if it is possible to make coffee or not (set to false)
    boolean canMakeCoffee = false;

    // a boolean condition that tells if coffee machine has reached peak capacity
    boolean isCapacityValueValid = false;

    // create a new coffee object to be used across multiple methods while keeping track of its used data
    Coffee coffeeObj = new Coffee(); // coffee object

    /** methods **/

    // a method that prints each step of the coffee making process (latte/cappuccino only)
    public void processScreenForLatteOrCappuccino() {
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

    // a method that prints each step of the coffee making process (espresso only)
    public void processScreenForEspresso() {
        System.out.println();
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Coffee is ready!");
        System.out.println();
    }

    // a method that prints the status of the coffee machine
    public void getMachineStatus(Coffee status) {
        // print how many supplies and how much money the coffee machine currently has
        System.out.println();
        System.out.println("The Coffee machine has: ");
        System.out.println(status.getWater() + " of water");
        System.out.println(status.getMilk() + " of milk");
        System.out.println(status.getCoffeeBeans() + " of coffee beans");
        System.out.println(status.getDisposableCups() + " of disposable cups");
        System.out.println(status.getMoney() + " of money");
        System.out.println();
    }

    // a method that asks user for an action to be performed
    public void actionScreen() {
        // ask what user wants to do (i.e. buy, fill, status, or quit)
        System.out.println("buy, fill, take, or status? (or \"exit\" to quit.)");
        // create scanner object
        Scanner scanner = new Scanner(System.in);
        // process user input and store in a variable
        String option = scanner.nextLine().toLowerCase(); // make sure it's lowercase
        /** invoke the appropriate method based on user's choice **/
        // use a switch statement to process user options
        switch(option) {
            // if "buy" is chosen
            case "buy":
                buy(); // invoke this method to buy a cup of coffee
                actionScreen(); // return to main menu
                break;
            // if "fill" is chosen
            case "fill":
                fill(); // invoke this method to fill with supplies
                actionScreen(); // return to main menu
                break;
            // if "take" is chosen
            case "take":
                take(); // invoke this method to grab all the cash from the machine
                actionScreen(); // return to main menu
                break;
            // if status is chosen
            case "status":
                // invoke this method to get the status of available supplies
                getMachineStatus(this.coffeeObj);
                actionScreen(); // return to main menu
                break;
            // if "exit" is chosen
            case "exit":
                break; // switch off coffee machine (exit program) when user types "exit"
            // display an error by default if user types invalid options
            default:
                System.out.println("That is not a valid option, please try again!");
                System.out.println();
                actionScreen(); // and invoke the method again (restart menu) until user enters valid choice
        }
    }

    public void fill() {
        // fill machine with some cups
        fillCups();
        // fill machine with some water
        fillWater();
        // fill machine with some milk
        fillMilk();
        // fill the machine with some coffee beans
        fillCoffeeBeans();
    }

    // a method for filling the coffee machine with extra supplies
    public void fillCups() {
        // create boolean variable and set to false
        boolean isValueValid = false;
        // a variable to hold input value from scanner
        int scannerValue;
        // a do-while loop to keep asking user for input while input is non-integer or number too high to meet
        // capacity requirements
        do {
            // create a scanner object to process user input
            Scanner scanner = new Scanner(System.in);
            // ask user how many disposable cups to fill the machine with
            System.out.println("Write how many disposable cups of coffee do you want to add: ");
            // make sure the input is an integer, and if it it's not
            if (!scanner.hasNextInt()) {
                // print an error
                System.out.println("that is not an integer try again!");
                // input value becomes false
                isValueValid = false;
            }
            // if the input value is an integer we proceed with next steps
            else {
                // store the input in a variable
                scannerValue = scanner.nextInt();
                // check if existing supplies combined with input value does not exceed max capacity
                checkCapacity(this.coffeeObj.getDisposableCups() + scannerValue, "cups");
                // if there is room
                if (isCapacityValueValid) {
                    // process input and add cups to supplies
                    this.coffeeObj.setDisposableCups(this.coffeeObj.getDisposableCups() + scannerValue);
                    // set condition to true in order to exit loop
                    isValueValid = true;
                }
            }
            // while value is not valid keep asking user for an input
        } while (!isValueValid); // once true break out of the loop
    }

    // a method for filling the coffee machine with extra supplies
    public void fillWater() {
        // create boolean variable and set to false
        boolean isValueValid = false;
        // a variable to hold input value from scanner
        int scannerValue;
        // a do-while loop to keep asking user for input while input is non-integer or number too high to meet
        // capacity requirements
        do {
            // create a scanner object to process user input
            Scanner scanner = new Scanner(System.in);
            // ask user how much water to fill the machine with
            System.out.println("Write how many ml of water do you want to add: ");
            // make sure the input is an integer, and if it it's not
            if (!scanner.hasNextInt()) {
                // print an error
                System.out.println("that is not an integer try again!");
                // input value becomes false
                isValueValid = false;
            }
            // if the input value is an integer we proceed with next steps
            else {
                // store the input in a variable
                scannerValue = scanner.nextInt();
                // check if existing supplies combined with input value does not exceed max capacity
                checkCapacity(this.coffeeObj.getWater() + scannerValue, "water");
                // if there is room
                if (isCapacityValueValid) {
                    // process input and add water to supplies
                    this.coffeeObj.setWater(this.coffeeObj.getWater() + scannerValue);
                    // set condition to true in order to exit loop
                    isValueValid = true;
                }
            }
            // while value is not valid keep asking for the same input from user
        } while (!isValueValid); // once true break out of the loop
    }

    // a method for filling the coffee machine with extra supplies
    public void fillMilk() {
        // create boolean variable and set to false
        boolean isValueValid = false;

        // a variable to hold input value from scanner
        int scannerValue;
        // a do-while loop to keep asking user for input while input is non-integer or number too high to meet
        // capacity requirements
        do {
            // create a scanner object to process user input
            Scanner scanner = new Scanner(System.in);
            // ask user how much milk to fill the machine with
            System.out.println("Write how many ml of milk do you want to add: ");
            // make sure the input is an integer, and if it it's not
            if (!scanner.hasNextInt()) {
                // print an error
                System.out.println("that is not an integer try again!");
                // input value becomes false
                isValueValid = false;
            }
            // if the input value is an integer we proceed with next steps
            else {
                // store the input in a variable
                scannerValue = scanner.nextInt();
                // check if existing supplies combined with input value does not exceed max capacity
                checkCapacity(this.coffeeObj.getMilk() + scannerValue, "milk");
                // if there is room
                if (isCapacityValueValid) {
                    // process input and add milk to supplies
                    this.coffeeObj.setMilk(this.coffeeObj.getMilk() + scannerValue);
                    // set condition to true in order to exit loop
                    isValueValid = true;
                }
            }
            // while value is not valid keep asking for the same input from user
        } while (!isValueValid); // once true break out of the loop
    }

    // a method for filling the coffee machine with extra supplies
    public void fillCoffeeBeans() {
        // create boolean variable and set to false
        boolean isValueValid = false;

        // a variable to hold input value from scanner
        int scannerValue;
        // a do-while loop to keep asking user for input while input is non-integer or number too high to meet
        // capacity requirements
        do {
            // create a scanner object to process user input
            Scanner scanner = new Scanner(System.in);
            // ask user how many coffee beans to fill the machine with
            System.out.println("Write how many grams of coffee beans do you want to add: ");
            // make sure the input is an integer, and if it it's not
            if (!scanner.hasNextInt()) {
                // print an error
                System.out.println("that is not an integer try again!");
                // input value becomes false
                isValueValid = false;
            }
            // if the input value is an integer we proceed with next steps
            else {
                // store the input in a variable
                scannerValue = scanner.nextInt();
                // check if existing supplies combined with input value does not exceed max capacity
                checkCapacity(this.coffeeObj.getCoffeeBeans() + scannerValue, "coffeeBeans");
                // if there is room
                if (isCapacityValueValid) {
                    // process input and add coffee beans to supplies
                    this.coffeeObj.setCoffeeBeans(this.coffeeObj.getCoffeeBeans() + scannerValue);
                    // set condition to true in order to exit loop
                    isValueValid = true;
                }
            }
            // while value is not valid keep asking for the same input from user
        } while (!isValueValid); // once true break out of the loop
    }

    // a method that checks if there is enough space for each supply to be refilled
    public void checkCapacity(int value, String supply) {
        // check if String argument matches the given keyword
        if (supply.contains("cups")) {
            // if there is enough room for refill
            if (value <= 50) { // 50 cup capacity <- can be changed to some other value
                // boolean condition becomes true
                isCapacityValueValid = true;
            }
            // otherwise
            else {
                // inform user there is not enough space for refill
                System.out.println("Sorry, there is not enough room to store that many cups, try again.");
                // boolean condition becomes false
                isCapacityValueValid = false;
            }
        }
        // check if String argument matches the given keyword
        if (supply.contains("water")) {
            // if there is enough room for refill
            if (value <= 3500) { // 3500 ml water capacity <- can be changed to some other value
                // boolean condition becomes true
                isCapacityValueValid = true;
            }
            // otherwise
            else {
                // inform user there is not enough space for refill
                System.out.println("Sorry, there is not enough room to store that much water, try again.");
                // boolean condition becomes false
                isCapacityValueValid = false;
            }
        }
        // check if String argument matches the given keyword
        if (supply.contains("milk")) {
            // if there is enough room for refill
            if (value <= 1500) { // 1500 ml milk capacity <- can be changed to some other value
                // boolean condition becomes true
                isCapacityValueValid = true;
            }
            // otherwise
            else {
                // inform user there is not enough space for refill
                System.out.println("Sorry, there is not enough room to store that much milk, try again.");
                // boolean condition becomes true
                // boolean condition becomes false
                isCapacityValueValid = false;
            }
        }
        // check if String argument matches the given keyword
        if (supply.contains("coffeeBeans")) {
            // if there is enough room for refill
            if (value <= 900) { // 900 gram coffee beans capacity <- can be changed to some other value
                // boolean condition becomes true
                isCapacityValueValid = true;
            }
            // otherwise
            else {
                // inform user there is not enough space for refill
                System.out.println("Sorry, there is not enough room to store that many coffee beans, try again.");
                // boolean condition becomes false
                isCapacityValueValid = false;
            }
        }
    }

    // a method for withdrawing money from the coffee machine
    public void take() {
        // print the amount of cash withdrawn by user
        System.out.println("I gave you $" + this.coffeeObj.getMoney());
        System.out.println();
        // set the money amount to zero after cash withdrawal
        this.coffeeObj.setMoney(0);
    }

    // a method that buys coffee and uses existing supplies
    public void buy() {
        // create a scanner object to process user input
        Scanner scanner = new Scanner(System.in);
        // ask user for type of coffee or to go back to previous menu
        System.out.println("What do you want to buy? (type \"back\" to go back to main menu)");
        System.out.println("1 - espresso, 2 - latte, 3 - cappuccino: ");
        // store the choice made by user
        String coffeeChoice = scanner.next();
        // use switch statement to choose a coffee drink
        switch (coffeeChoice) {
            // 1 for espresso
            case "1":
                makeEspresso();
                break;
            // 2 for latte
            case "2":
                makeLatte();
                break;
            // 3 for cappuccino
            case "3":
                makeCappuccino();
                break;
            // go back to main menu
            case "back":
                return; // invoking actionScreen() will not work; must use return statement instead!!
            // default error message
            default:
                // if an invalid input is entered, tell user by print an error
                System.out.println("That is not a valid choice, please try again!");
                System.out.println();
                buy(); // and invoke the method again (restart menu) until user enters valid choice
        }
    }

    // a method that makes espressos
    public void makeEspresso() {
        // an espresso needs 250 ml of water, 0 ml of milk and 16 grams of coffee beans
        checkSupplies(250, 0, 16);
        // if we can make coffee
        if (canMakeCoffee) {
            // charge for coffee ($4 for espresso drinks)
            this.coffeeObj.setMoney(this.coffeeObj.getMoney() + 4);
            // add the amount of water needed for a one cup of coffee and update the water supply
            this.coffeeObj.setWater(this.coffeeObj.getWater() - 250);
            // add the amount of coffee beans needed for a one cup of coffee and update the coffee bean supply
            this.coffeeObj.setCoffeeBeans(this.coffeeObj.getCoffeeBeans() - 16);
            // remove one cup from supplies and update how many cups are left
            this.coffeeObj.setDisposableCups(this.coffeeObj.getDisposableCups() - 1); // cup per coffee
            // print the process for making some coffee
            processScreenForEspresso();
        }
        // let user know attempt at making coffee was not successful
        else {
            System.out.println("unable to make coffee.");
        }
    }

    // a method that makes lattes
    public void makeLatte() {
        // a latte needs 350 ml of water, 75 ml of milk and 20 grams of coffee beans
        checkSupplies(350, 75, 20);
        //
        if (canMakeCoffee) {
            // charge for coffee ($7 for latte drinks)
            this.coffeeObj.setMoney(this.coffeeObj.getMoney() + 7);
            // add the amount of water needed for a one cup of coffee and update the water supply
            this.coffeeObj.setWater(this.coffeeObj.getWater() - 350);
            // add the amount of milk needed for a one cup of coffee and update the milk supply
            this.coffeeObj.setMilk(this.coffeeObj.getMilk() - 75);
            // add the amount of coffee beans needed for a one cup of coffee and update the coffee bean supply
            this.coffeeObj.setCoffeeBeans(this.coffeeObj.getCoffeeBeans() - 20);
            // remove one cup from supplies and update how many cups are left
            this.coffeeObj.setDisposableCups(this.coffeeObj.getDisposableCups() - 1);
            // print the process for making some coffee
            processScreenForLatteOrCappuccino();
        }
        // let user know attempt at making coffee was not successful
        else {
            System.out.println("unable to make coffee.");
        }
    }

    // a method that makes cappuccinos
    public void makeCappuccino() {
        // a cappuccino needs 200 ml of water, 100 ml of milk and 12 grams of coffee beans
        checkSupplies(200, 100, 12);
        //
        if (canMakeCoffee) {
            System.out.println("I have enough resources, making you a coffee!");
            // charge for coffee ($6 for cappuccino drinks)
            this.coffeeObj.setMoney(this.coffeeObj.getMoney() + 6);
            // add the amount of water needed for a one cup of coffee and update the water supply
            this.coffeeObj.setWater(this.coffeeObj.getWater() - 200);
            // add the amount of milk needed for a one cup of coffee and update the milk supply
            this.coffeeObj.setMilk(this.coffeeObj.getMilk() - 100);
            // add the amount of coffee beans needed for a one cup of coffee and update the coffee bean supply
            this.coffeeObj.setCoffeeBeans(this.coffeeObj.getCoffeeBeans() - 12);
            // remove one cup from supplies and update how many cups are left
            this.coffeeObj.setDisposableCups(this.coffeeObj.getDisposableCups() - 1); // 1 cup per coffee
            // print the process for making some coffee
            processScreenForLatteOrCappuccino(); // make some coffee
        }
        // let user know attempt at making coffee was not successful
        else {
            System.out.println("unable to make coffee.");
        }
    }

    // a method that checks if there are enough supplies to make a cup of coffee for given coffee type
    public void checkSupplies(int water, int milk, int coffeeBeans) {
        // if there is enough cups, water, milk, and coffee beans
        if (hasEnoughCups() && hasEnoughWater(water) && hasEnoughMilk(milk) &&
                hasEnoughCoffeeBeans(coffeeBeans)) {
            // we can make some coffee
            canMakeCoffee = true;
            // inform user we can make coffee
            System.out.println("I have enough resources, making you a coffee!");
        }
        // otherwise
        else {
            // we cannot make coffee
            canMakeCoffee = false;
            // if we don't have enough cups
            if (!hasEnoughCups()) {
                // inform user there's a shortage of cups
                System.out.println("not enough disposable cups.");
            }
            // if we don't have enough water
            if (!hasEnoughWater(water)) {
                // inform user there's a shortage of water
                System.out.println("not enough water.");
            }
            // if we don't have enough milk
            if (!hasEnoughMilk(milk)) {
                // inform user there's a shortage of milk
                System.out.println("not enough milk.");
            }
            // if we don't have enough coffee beans
            if (!hasEnoughCoffeeBeans(coffeeBeans)) {
                // inform user there's a shortage of coffee beans
                System.out.println("not enough coffee beans.");
            }
        }
    }

    // a boolean method that returns true if there is enough water
    public boolean hasEnoughWater(int value) {
        return (this.coffeeObj.getWater() >= value);
    }

    // a boolean method that returns true if there is enough milk
    public boolean hasEnoughMilk(int value) {
        return (this.coffeeObj.getMilk() >= value);
    }

    // a boolean method that returns true if there are enough coffee beans
    public boolean hasEnoughCoffeeBeans(int value) {
        return (this.coffeeObj.getCoffeeBeans() >= value);
    }

    // a boolean method that returns true if there are enough disposable cups
    public boolean hasEnoughCups() {
        return (this.coffeeObj.getDisposableCups() > 0);
    }

}
