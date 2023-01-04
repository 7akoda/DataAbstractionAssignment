import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class BankTest {

    //requires: string, double, and date.
    //modifies: this
    //effects: tests if withdraw.toString method works
    @Test
    public void witestString(){
        Withdraw w = new Withdraw(5.00, new Date(), "checking", 1000.00, 10000.00);
        String expectedString = "Withdraw: $5.00 on " + w.date + " from checking. Current checking balance: $995.00";
        assertEquals(expectedString, w.toString());
        }
    //requires: string, double, and date.
    //modifies: this
    //effects: tests if deposit.toString method works
    @Test
    public void deptestString(){
        Deposit d = new Deposit(500.00, new Date(), "checking", 100.00, 100.00);
        String expectedString = "Deposit: $500.00 on " + d.date + " to checking. Current checking balance: $600.00";
        assertEquals(expectedString, d.toString());
        }
    }

