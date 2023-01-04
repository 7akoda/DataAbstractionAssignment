import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Date date = new Date();
        Customer a = new Customer("Boris X", 5312, 100.00, 1000.00);
        ArrayList<Deposit> deposits = a.getDeposits();
        ArrayList<Withdraw> withdraws = a.getWithdraws();
        a.deposit(23.45, date, "checking");
        a.deposit(23.45, date, "checking");
        a.deposit(234.56, date, "saving");
        a.displayDeposits();
        a.withdraw(1000.00, date, "checking");
        a.withdraw(1.00, date, "saving");
        a.displayWithdraws();





    }
}
