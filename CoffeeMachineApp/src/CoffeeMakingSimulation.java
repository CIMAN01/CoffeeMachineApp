
/***************** Use a CoffeeMachine Class object to Simulate making some coffee ********************/

// Main class
public class CoffeeMakingSimulation { // change class name to simulate later
    // main method
    public static void main(String[] args) {

        // create new coffee object
        final CoffeeMachine coffee = new CoffeeMachine();

        // ask what user wants to do (buy, fill, or take)
        coffee.actionScreen();
    }
}
