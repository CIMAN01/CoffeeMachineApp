
// Coffee class
public class Coffee {

    // fields for costs
    private int espressoCost = 4;   // espresso costs $4
    private int latteCost = 7;      // latte costs $7
    private int cappuccinoCost = 6; // cappuccino costs $6


    // fields for supplies
    private int disposableCups;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int money;

    // constructor
    public Coffee() {               // The coffee machine initially has:
        setDisposableCups(9);       // 9 of disposable cups
        setWater(1200);             // 1200 ml of water
        setMilk(540);               // 540 ml of milk
        setCoffeeBeans(120);        // 120 ml of coffee beans
        setMoney(550);              // $550 of money
    }

    /** getters and setters for non-fixed fields **/

    public int getEspressoCost() {
        return espressoCost;
    }

    public void setEspressoCost(int espressoCost) {
        this.espressoCost = espressoCost;
    }

    public int getLatteCost() {
        return latteCost;
    }

    public void setLatteCost(int latteCost) {
        this.latteCost = latteCost;
    }

    public int getCappuccinoCost() {
        return cappuccinoCost;
    }

    public void setCappuccinoCost(int cappuccinoCost) {
        this.cappuccinoCost = cappuccinoCost;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public void setCoffeeBeans(int coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

}
