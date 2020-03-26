/*

Branch should be able to:
- check if a phone number already exists
- add customers (validate the data to make sure you're not adding customers if the phone-number already exists.)
- add transactions on a customer
- validate input to make sure it's a valid number
- remove a customer
- edit a customer name
- remove a transaction
- edit a transaction
- retrieve names of all customers
- retrieve all transactions for a given customer

 */

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Create a Branch class with a branch name and an ArrayList of customers.
public class Branch {

    /** fields **/

    // a branch name
    private String branchName;

    // an ArrayList of customers
    private ArrayList<Customer> buyers = new ArrayList<>();

    /** Constructors **/

    public Branch(String branchName, ArrayList<Customer> buyers) {
        setBranchName(branchName);
        setBuyers(buyers);
    }

    public Branch(String branchName) {
        setBranchName(branchName);
    }

    /** getters and setters **/

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public ArrayList<Customer> getBuyers() {
        return buyers;
    }

    public void setBuyers(ArrayList<Customer> buyers) {
        this.buyers = buyers;
    }

    /** methods **/

    // a method that validates an input to make sure the number doesn't already exist.
    public boolean isNumberValid(String number) {
        // create and use java regex to validate North American phone numbers
        String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        // create a pattern and give it the desired format using above regex
        Pattern pattern = Pattern.compile(regex);
        // create a match between the number and the desired pattern
        Matcher match = pattern.matcher(number);
        // return true if the number matches the pattern or a false if it does not
        return (match.find() && match.group().equals(number));
    }

    // a method that checks if a customer already exists
    public boolean hasNumber(String number) {
        // check if number is valid first
        if (isNumberValid(number)) {
            // loop through buyers to find a matching number
            for (Customer buyer : getBuyers()) {
                // return true if a match is found
                if (number.equals(buyer.getPhoneNumber())) {
                    return true;
                }
            }
        } // if no match is found we return false
        return false;
    }

    // a method that checks if a customer already exists
    public boolean hasCustomer(String name) {
        // for each buyer in buyers
        for (Customer buyer : getBuyers()) {
            // if the name already exists
            if (name.equals(buyer.getCustomerName())) {
                return true; // the condition becomes true
            }
        }
        return false; // otherwise the condition is false
    }

    // a method that adds customers
    public void addCustomer(String name, String number) {
        // check if number is valid first
        if (isNumberValid(number)) { // should return true
            // then check if customer name and phone number do not already exist
            if (!hasCustomer(name) && !hasNumber(number)) { // should return false
                // create a new customer/buyer
                Customer buyer = new Customer(name, number, null);
                // add new buyer to the list and display the name added
                this.buyers.add(buyer);
                System.out.println(name + " added to buyers.");
            }
            // if name or number already exists display an error
            else {
                System.out.println("Error. " + name + " and/or " + number + " already exists.");
            }
        } else { // if number is not valid we display an error
            System.out.println("Error. The phone number you have entered: " + number +
                    " is not a valid number or is in a wrong format. Please try again!");
        }
    }

    // a method that adds transaction on customer
    public void addTransaction(String name, ArrayList<Double> payment) {
        // check for existing customer name
        if (hasCustomer(name)) { // should return true
            // if there's a name match we loop through customers
            for (Customer buyer : getBuyers()) {
                // to find an exact match
                if (name.equals(buyer.getCustomerName())) {
                    // and a payment to that buyer
                    buyer.setTransactions(payment);
                    // print the transaction
                    System.out.println("transactions added to buyer " + name + ".");
                }
            }
        }
        // if name already exists display an error
        else {
            System.out.println("Error. " + name + " does not exists.");
        }
    }

    // a method that edits a customer name
    public void editCustomerName(String existingName, String newName) {
        // loop through each customer name
        for (Customer buyer : getBuyers()) {
            // make sure the customer name to be changed actually exists
            if (buyer.getCustomerName().equals(existingName)) {
                // change or the edit the customer name
                buyer.setCustomerName(newName);
                // print the change
                System.out.println(existingName + " changed to " + buyer.getCustomerName() + ".");
                // when done return from the method
                return;
            }
        }
        // display an error if existing customer name argument does not exist
        System.out.println("Error. " + existingName + " doesn't exist.");
    }

    // a method that edits a transaction
    public void editTransaction(ArrayList<Double> existingTransaction, ArrayList<Double> newTransaction) {
        // loop through each transaction
        for (Customer buyer : getBuyers()) {
            // make sure the transaction to be changed exists
            if (buyer.getTransactions().equals(existingTransaction)) {
                // change or the edit the transaction
                buyer.setTransactions(newTransaction);
                // print the change
                System.out.println("existing transaction " + existingTransaction + " changed to new transaction "
                        + buyer.getTransactions() + ".");
                // when done return from the method
                return;
            }
        }
        // display an error if existing transaction argument does not exist
        System.out.println("Error. " + existingTransaction + " doesn't exist.");
    }

    // a method that removes a customer
    public void removeCustomer(String number) {
        /** --> only works for ArrayList of strings and primitive data types <-- **/
        //this.buyers.remove(number); // uncomment to use

        // check number that is valid and that it exists
        if (isNumberValid(number) && hasNumber(number)) {
            // use removeIf and lambda for ArrayList of other class objects to remove buyer
            this.buyers.removeIf(buyer -> buyer.getPhoneNumber().equals(number));
        }
        // if number is not valid we display an error
        else {
            System.out.println("Error. The phone number you have entered: " + number +
                    " is not a valid number or does not exist. Please try again!");
        }
    }

    // a method that adds transaction on customer
    public void removeTransaction(String name, ArrayList<Double> payment) {
        // check for existing customer name
        if (hasCustomer(name)) { // should return true
            // if there's a name match we loop through customers
            for (Customer buyer : getBuyers()) {
                // to find an exact match
                if (name.equals(buyer.getCustomerName())) {
                    // set transactions to empty/null
                    buyer.setTransactions(null);
                    // print the transaction
                    System.out.println("transactions have been removed from " + name + ".");
                }
            }
        }
        // if name already exists display an error
        else {
            System.out.println("Error. " + name + " does not exists.");
        }
    }

    // a method that retrieves names of all customers
    public void getAllCustomerNames() {
        // for each customer in the customers
        for (Customer buyer : getBuyers()) {
            // print their names and phone numbers
            System.out.println("Name: " + buyer.getCustomerName() + " | Number: " + buyer.getPhoneNumber());
        }
    }

    // a method that retrieves all transactions for a given customer
    public void getAllCustomerTransactions(String name) {
        // check if buyer exists first
        if (hasCustomer(name)) {
            // for each customer in the customers
            for (Customer buyer : getBuyers()) {
                // if we find a match
                if (buyer.getCustomerName().equals(name)) {
                    // print the matching buyer's transactions
                    System.out.println("All transactions for " + name + ": " + buyer.getTransactions());
                }
            }
        }
        // if there is no match
        else {
            System.out.println("No records available for " + name + ". That name doesn't exist.");
        }
    }
}
