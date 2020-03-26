/*

- Create a Sharetea class with an ArrayList of branches.
- Create a Branch class with a branch name and an ArrayList of customers.
- Create a Customer class with name, number, and an ArrayList of doubles to
  represent their transactions.

 */

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        /** testing Customer class **/

        // create an arrayList of transactions and add some values to it
        ArrayList<Double> trans1 = new ArrayList<>(5);
        trans1.add(5.45);
        trans1.add(3.75);
        trans1.add(4.10);
        trans1.add(2.50);
        trans1.add(3.50);

        // create a customer object and give it some data
        Customer customer1 = new Customer("John Wick", "505-502-3567", trans1);

        // create another arrayList of transactions and add some values to it
        ArrayList<Double> trans2 = new ArrayList<>(5);
        trans2.add(3.45);
        trans2.add(4.75);
        trans2.add(5.10);
        trans2.add(4.50);
        trans2.add(6.50);

        // create another customer object and give it some data
        Customer customer2 = new Customer("Joseph Bell", "501-437-4577", trans2);

        // create another arrayList of transactions and add some values to it
        ArrayList<Double> trans3 = new ArrayList<>(5);
        trans3.add(4.45);
        trans3.add(5.75);
        trans3.add(5.10);
        trans3.add(4.50);
        trans3.add(3.50);

        // create another customer object and give it some data
        Customer customer3 = new Customer("Nikola Tesla", "502-425-5019", trans3);

        // create an arrayList of customers and add some buyers to it
        ArrayList<Customer> buyers = new ArrayList<>(3);
        buyers.add(customer1);
        buyers.add(customer2);
        buyers.add(customer3);

        /** testing Branch class **/

        // create a branch object and some data to it
        Branch branches = new Branch("redmondBranch", buyers);

        // check if phone numbers are valid --> uncomment to use
        //System.out.println(branches.isNumberValid("505-502-3567")); // true
        //System.out.println(branches.isNumberValid("505502375")); // false

        // check if phone number exists --> uncomment to use
        //System.out.println(branches.hasNumber("501-437-4577")); // true
        //System.out.println(branches.hasNumber("501-437-4000")); // false

        // check if customer exists --> uncomment to use
        //System.out.println(branches.hasCustomer("Nikola Tesla")); // true
        //System.out.println(branches.hasCustomer("James Bond")); // false

        System.out.println();

        // print all the customers
        branches.getAllCustomerNames();
        System.out.println();

        // add a customer to the branch
        branches.addCustomer("James Bond", "007-007-0007");
        System.out.println();

        // create another arrayList of transactions and add some values to it
        ArrayList<Double> trans4 = new ArrayList<>(5);
        trans4.add(7.45);
        trans4.add(8.75);
        trans4.add(9.10);
        trans4.add(10.50);
        trans4.add(11.50);

        // add a transaction to the branch
        branches.addTransaction("James Bond", trans4);
        System.out.println();


        // print all transactions for the selected customer
        branches.getAllCustomerTransactions("James Bond");
        branches.getAllCustomerTransactions("Nikola Tesla");
        System.out.println();

        // remove the customer from the branch
        branches.removeCustomer("007-007-0007");

        // print all the customers
        branches.getAllCustomerNames();
        System.out.println();


        // print all transactions for the selected customer
        branches.getAllCustomerTransactions("Nikola Tesla");
        System.out.println();

        // remove a transaction
        branches.removeTransaction("Nikola Tesla", trans3);
        System.out.println();

        // print all transactions for the selected customer
        branches.getAllCustomerTransactions("Nikola Tesla");

        // create another arrayList of transactions and add some values to it
        ArrayList<Double> trans5 = new ArrayList<>(5);
        trans5.add(4.45);
        trans5.add(2.75);
        trans5.add(7.10);
        trans5.add(1.50);
        trans5.add(8.50);

        // add new transaction to selected customer
        branches.addTransaction("Nikola Tesla", trans5);
        System.out.println();

        // print all transactions for the selected customer
        branches.getAllCustomerTransactions("Nikola Tesla");
        System.out.println();

        // edit a customer's name for the branch
        branches.editCustomerName("Nikola Tesla", "Elon Musk");
        System.out.println();

        // create another arrayList of transactions and add some values to it
        ArrayList<Double> trans6 = new ArrayList<>(5);
        trans6.add(6.45);
        trans6.add(5.75);
        trans6.add(5.10);
        trans6.add(4.50);
        trans6.add(3.50);

        // edit a transaction for the branch
        branches.editTransaction(trans5, trans6);
        System.out.println();

        // print all the customers
        branches.getAllCustomerNames();
        System.out.println();

        // print all transactions for the selected customer
        branches.getAllCustomerTransactions("Elon Musk");
        System.out.println();

        /** testing Sharetea class **/

        // create some stores (ArrayList of stores)
        ArrayList<Branch> stores = new ArrayList<>();

        // create a branch object and give it some data
        Sharetea sharetea = new Sharetea(stores);

        // add a new store
        sharetea.addBranches("Redmond Store");
        sharetea.addBranches("Kirkland store");
        sharetea.addBranches("Issaquah store");
        System.out.println();

        // see if store exists (should return true if it does)
        sharetea.hasBranch("Redmond store");
        System.out.println();

        // edit the name of a store
        sharetea.editBranch("Kirkland store", "Bellevue store");

        // remove a store
        sharetea.removeBranch("Issaquah store");
        System.out.println();

        // print all stores
        sharetea.getAllBranches();

    }
}
