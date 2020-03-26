/*

Customer should contain:
- constructor
- getters
- setters

 */


import java.util.ArrayList;

// Create a Customer class with name, number, and an ArrayList of doubles
// to represent their transactions.
public class Customer {

    /** fields **/

    private String customerName;
    private String phoneNumber;
    private ArrayList<Double> transactions;

    /** Constructors **/

    // constructor
    public Customer(String customerName, String phoneNumber, ArrayList<Double> transactions) {
        setCustomerName(customerName);
        setPhoneNumber(phoneNumber);
        setTransactions(transactions);
    }

    // overloaded constructor
    public Customer(String customerName, String phoneNumber) {
        setCustomerName(customerName);
        setPhoneNumber(phoneNumber);
    }

    // overloaded constructor
    public Customer(ArrayList<Double> transactions) {
        setTransactions(transactions);
    }


    /** getters and setters **/

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public ArrayList<Double> getTransactions() { return transactions; }

    public void setTransactions(ArrayList<Double> transactions) {
        this.transactions = transactions;
    }

}
