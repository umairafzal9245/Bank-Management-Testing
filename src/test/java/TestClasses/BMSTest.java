package TestClasses;

import MainClasses.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BMSTest {

    BMS object;
    @Before
    public void createobject()
    {
         object = new BMS();
         object.openanaccount("Umair","dab no 2","saving",(long)1234,(long)223344,20000,1234);
         object.openanaccount("Umair","dab no 2","checking",(long)1234,(long)11223344,15000,2244);
    }
    @Test
    public void TestSearchAccounts()
    {
        Assert.assertEquals(-1,object.searchaccounts((long)1234));
        Assert.assertEquals(0,object.searchaccounts((long)223344));
    }
    @Test
    public void TestSearchCustomers1()
    {
        Assert.assertEquals(-1,object.searchcustomers("checkingstring"));
    }
    @Test
    public void TestSearchCustomers2()
    {
        Assert.assertEquals(0,object.searchcustomers((long)223344));
    }
    @Test
    public void TestCloseanaccount()
    {
        Assert.assertFalse(object.closeanaccount((long)1234));
    }
    @Test
    public void TestCloseanaccount2()
    {
        Assert.assertTrue(object.closeanaccount((long)223344));
    }
}