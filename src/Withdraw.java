import java.util.Date;

public class Withdraw {
    private final double amount;
    final Date date;
    private final String account;
    private double checkBalance;
    private double savingBalance;
    //requires: all above
    //modifies: this
    //effects: output to array list and output user sees

    //pretty much the same as the prior method in the customer class except this is just saving said amounts
    // to the array list
    Withdraw(double amount, Date date, String account, double checkBalance, double savingBalance) {
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
            return String.format("Withdraw: $%.2f on %s from %s. Current checking balance: $%.2f",
                    amount, date, account, checkBalance);
        } else if (account.equalsIgnoreCase("saving")) {
            return String.format("Withdraw: $%.2f on %s from %s. Current saving balance $%.2f",
                    amount, date, account, savingBalance);
        }
        return toString();
    }
}