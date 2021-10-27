package TestClasses;

import MainClasses.Accounts;
import MainClasses.Checking_Accounts;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Checking_AccountsTest {

    Accounts object;
    @Before
    public void createobject()
    {
        object = new Checking_Accounts((long)12345,10000);
    }

    @Test
    public void TestmakeDeposit1()
    {
        Assert.assertTrue(object.makeDeposit(200));
        double balance = object.getBalance();
        Assert.assertEquals(10200,balance,0.000001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestmakeDeposit2()
    {
        object.makeDeposit(-5);
    }

    @Test
    public void TestmakeWithdrawal1()
    {
        Assert.assertTrue(object.makeWithdrawal(500));
        double balance = object.getBalance();
        Assert.assertEquals(9500,balance,0.000001);
    }

    @Test
    public void TestmakeWithdrawal2()
    {
        Assert.assertFalse(object.makeWithdrawal(17000));
        double balance = object.getBalance();
        Assert.assertEquals(10000,balance,0.000001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestmakeWithdrawal3()
    {
        object.makeWithdrawal(-2000);
    }
}