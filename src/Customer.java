
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private final ArrayList<Deposit> deposits = new ArrayList<>();
    private final ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    private final String name;
    //requires: all above
    //modifies: this
    //effects: everything

//constructor for Customer object
    Customer(String name, int accountNumber, double checkBalance, double savingBalance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkBalance;
        this.savingBalance = savingBalance;
    }

    //deposit method calling on array list to then call on Deposit class
    //if user selects checking account type it deposits the amount into checking
    public double deposit(double amt, Date date, String account){
        if (account.equalsIgnoreCase("checking")) {
            checkBalance += amt;
            deposits.add(new Deposit(amt, date, account, checkBalance, savingBalance));
            return checkBalance;
            //if user selects saving account type it deposits the amount into savings
        } else if (account.equalsIgnoreCase("saving")) {
            savingBalance+= amt;
            deposits.add(new Deposit(amt, date, account, checkBalance, savingBalance));
            return savingBalance;
            //if user selects neither type it lets user know it is invalid
        } else {
            throw new IllegalArgumentException("Invalid account type: " + account);
        }

    }
    //withdraw method calling on array list to then call on Withdraw class
    public double withdraw(double amt, Date date, String account){
        //calling on checkOverdraft method
        checkOverdraft(amt,account);
        //if user selects checking account type it withdraws the amount from checking
        if (account.equalsIgnoreCase("checking")) {
            checkBalance -= amt;
            withdraws.add(new Withdraw(amt, date, account, checkBalance, savingBalance));
            return checkBalance;
            //if user selects saving account type it withdraws the amount from saving
        } else if (account.equalsIgnoreCase("saving")){
            savingBalance -=amt;
            withdraws.add(new Withdraw(amt, date, account, checkBalance, savingBalance));
            return savingBalance;
            //if user selects neither type it lets user know it is invalid
        } else {
            throw new IllegalArgumentException("Invalid account type: " + account);
        }
    }
    //very simple method, if account type balance - withdrawal amount is less than zero (negative)
    // then it prints out a message

    private boolean checkOverdraft(double amt, String account) {
        if (account.equalsIgnoreCase("checking")) {
            if (checkBalance - amt < 0) {
                System.out.println("Insufficient funds to make this withdrawal, overdraft fees will apply.");
                return true;
            } else {
                return false;
            }
        } else if (account.equalsIgnoreCase("saving")) {
            if (savingBalance - amt < 0) {
                System.out.println("Insufficient funds to make this withdrawal, overdraft fees will apply.");
                return true;
            } else {
                return false;
            }
        } else {
            throw new IllegalArgumentException("Invalid account type: " + account);
        }
    }

//for each loop, for every instance of d in deposits print out.
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //for each loop, for every instance of w in withdraws print out.
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }


}
