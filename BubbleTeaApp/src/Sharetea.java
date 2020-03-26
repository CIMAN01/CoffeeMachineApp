/*

Sharetea should be able to:
- add branches
- edit branch
- remove branch
- retrieve names of all branches

 */

import java.util.ArrayList;

public class Sharetea {

    // fields
    private ArrayList<Branch> branches = new ArrayList<>();

    // constructors
    public Sharetea(ArrayList<Branch> branches) {
        setBranches(branches);
    }

    // getters and setters
    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public void setBranches(ArrayList<Branch> branches) {
        this.branches = branches;
    }

    /** methods **/

    // a method that adds a branch
    public void addBranches(String store) {
        // check if branch doesn't already exists
        if (!hasBranch(store)) { // should return false
            // create a new branch
            Branch branch = new Branch(store);
            // add new branch to the chain and display the branch added
            this.branches.add(branch);
            System.out.println(store + " added to branch.");
        }
        // if branch already exists display an error
        else {
            System.out.println("Error. " + store + " already exists.");
        }
    }

    // a method that checks if a branch already exists
    public boolean hasBranch(String branch) {
        // for each branch in branches
        for (Branch store : getBranches()) {
            // if branch argument matches an existing branch
            if (branch.equals(store.getBranchName())) {
                return true; // the condition becomes true
            }
        }
        return false; // otherwise condition is false
    }

    // a method that edits a branch
    public void editBranch(String existingBranch, String newBranch) {
        // loop through each branch
        for (Branch branch : getBranches()) {
            // make sure the branch to be changed actually exists
            if (branch.getBranchName().equals(existingBranch)) {
                // change or the edit the name of that branch
                branch.setBranchName(newBranch);
                // print the change
                System.out.println(existingBranch + " changed to " + branch.getBranchName() + ".");
                // once done we return from the method
                return;
            }
        } // display an error if existing branch argument does not exist
        System.out.println("Error. " + existingBranch + " doesn't exist.");
    }

    // a method that removes a customer
    public void removeBranch(String branch) {
        // use removeIf and lambda for ArrayList of other class objects
        this.branches.removeIf(store -> store.getBranchName().equals(branch));
    }

    // a method that retrieves names of all branches
    public void getAllBranches() {
        System.out.println("Branches: ");
        // for each store in stores
        for (Branch store : getBranches()) {
            // print the stores
            System.out.println(store.getBranchName());
        }
    }
}


