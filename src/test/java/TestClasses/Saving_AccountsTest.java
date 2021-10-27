package TestClasses;

import MainClasses.Accounts;
import MainClasses.Checking_Accounts;
import MainClasses.Saving_Accounts;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Saving_AccountsTest
{
    Accounts object;
    @Before
    public void createobject()
    {
        object = new Saving_Accounts((long)12345,10000);
    }
    @Test
    public void TestDeposit1()
    {
        Assert.assertTrue(object.makeDeposit(2000));
        double balance = object.getBalance();
        Assert.assertEquals(12000,balance,0.00001);
    }
    @Test(expected = IllegalArgumentException.class)
    public void TestDeposit2()
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
    @Test
    public void TestZakat()
    {
        Saving_Accounts object = new Saving_Accounts((long)12345,20000);
        object.calculateZakat();
        Assert.assertEquals(500,object.getZakat(),0.00001);
    }
    @Test
    public void TestInterest()
    {
        Saving_Accounts object = new Saving_Accounts((long)12345,20000);
        object.setInterestrate(5);
        Assert.assertTrue(object.CalculateInterest());
        Assert.assertEquals(1000,object.getInterestamount(),0.00001);
    }
}