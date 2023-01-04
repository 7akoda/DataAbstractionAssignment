import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BankTest {
    //requires: string, int, double, and date.
    //modifies: this
    //effects: tests if the customer.deposit method works
    @Test
    public void deptest(){
        Customer a = new Customer("takoda godin", 111, 1000.00, 1000.00);
        double newBalance = a.deposit(100.00, new Date(), "checking");
        assertEquals(1100.00, newBalance, 0.001);
    }
    //requires: string, int, double, and date.
    //modifies: this
    //effects: tests if the customer.withdraw method works
    @Test
    public void witest(){
        Customer b = new Customer("takoda godin", 1111, 1000.00, 10000.00);
        double newBalance = b.withdraw(100.00, new Date(), "saving");
        assertEquals(9900.00, newBalance, 0.001);
    }
    //requires: string, double, and date.
    //modifies: this
    //effects: tests if withdraw.toString method works
    @Test
    public void witestString(){
        Withdraw w = new Withdraw(0.00, new Date(), "checking", 1000.00, 10000.00);
        String expectedString = "Withdraw: $0.00 on " + w.date + " from checking. Current checking balance: $1000.00";
        assertEquals(expectedString, w.toString());
        }
    //requires: string, double, and date.
    //modifies: this
    //effects: tests if deposit.toString method works
    @Test
    public void deptestString(){
        Deposit d = new Deposit(0.00, new Date(), "checking", 100.00, 100.00);
        String expectedString = "Deposit: $0.00 on " + d.date + " to checking. Current checking balance: $100.00";
        assertEquals(expectedString, d.toString());
        }
    }

