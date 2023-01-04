
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private final int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;

    private final String name;



    Customer(String name, int accountNumber, double checkBalance, double savingBalance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkBalance;
        this.savingBalance = savingBalance;
    }

    public double deposit(double amt, Date date, String account){
        if (account.equalsIgnoreCase("checking")) {
            checkBalance += amt;
            deposits.add(new Deposit(amt, date, account, checkBalance, savingBalance));
            return checkBalance;
        } else if (account.equalsIgnoreCase("saving")) {
            savingBalance+= amt;
            deposits.add(new Deposit(amt, date, account, checkBalance, savingBalance));
            return savingBalance;
        } else {
            throw new IllegalArgumentException("Invalid account type: " + account);
        }

    }

    public double withdraw(double amt, Date date, String account){
        checkOverdraft(amt,account);
        if (account.equalsIgnoreCase("checking")) {
            checkBalance -= amt;
            withdraws.add(new Withdraw(amt, date, account, checkBalance, savingBalance));
            return checkBalance;
        } else if (account.equalsIgnoreCase("saving")){
            savingBalance -=amt;
            withdraws.add(new Withdraw(amt, date, account, checkBalance, savingBalance));
            return savingBalance;
        } else {
            throw new IllegalArgumentException("Invalid account type: " + account);
        }
    }
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


    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }

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
