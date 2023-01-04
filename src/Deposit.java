import java.util.Date;

public class Deposit {
    private final double amount;
    final Date date;
    private final String account;
    private double checkBalance;
    private double savingBalance;

    //pretty much the same as the prior method in the customer class except this is just saving said amounts
    // to the array list
    Deposit(double amount, Date date, String account, double checkBalance, double savingBalance){
        this.amount = amount;
        this.date = date;
        this.account = account;
        if (account.equalsIgnoreCase("checking")) {
            this.checkBalance = checkBalance;
            this.savingBalance = savingBalance;
        } else if (account.equalsIgnoreCase("saving")) {
            this.checkBalance = checkBalance;
            this.savingBalance = savingBalance;
        }
    }

    //formatting what the user will see as output, %.2f will be a float and %s a string.
    public String toString() {
        if (account.equalsIgnoreCase("checking")) {
            return String.format("Deposit: $%.2f on %s to %s. Current checking balance: $%.2f",
                    amount, date, account, checkBalance);
        } else if (account.equalsIgnoreCase("saving")) {
            return String.format("Deposit: $%.2f on %s to %s. Current saving balance $%.2f",
                    amount, date, account, savingBalance);
        }
        return toString();
    }

}