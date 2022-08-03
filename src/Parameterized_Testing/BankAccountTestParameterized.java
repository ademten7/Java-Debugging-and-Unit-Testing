package Parameterized_Testing;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;


@RunWith(Parameterized.class)//we need to say intelliJ this is a parameterized test
public class BankAccountTestParameterized {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParameterized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test..." );

    }

    //if we want to test a method with more than one different values.
    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {//it returns a collection
        return Arrays.asList(new Object[][] {
                //these are expected values
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
        });

    }

    @org.junit.Test
    public void deposit() throws Exception {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01);
        //delta ==> to prevent below situation:
       // Expected :1325.14
        //Actual   :1325.1399999999999
        System.out.println("The balance is= " + account.getBalance());
    }

}
