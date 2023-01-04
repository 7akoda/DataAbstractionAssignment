import java.util.ArrayList;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
        //getting date
        Date date = new Date();
        //creating customer
        Customer a = new Customer("Boris X", 5312, 100.00, 1000.00);
        //getting arraylists from customer class
        ArrayList<Deposit> deposits = a.getDeposits();
        ArrayList<Withdraw> withdraws = a.getWithdraws();
        //making deposits
        a.deposit(23.45, date, "checking");
        a.deposit(23.45, date, "checking");
        a.deposit(234.56, date, "saving");
        //displaying deposits
        a.displayDeposits();
        //making withdrawals
        a.withdraw(1000.00, date, "checking");
        a.withdraw(100.00, date, "saving");
        //displaying withdrawals
        a.displayWithdraws();





    }
}
