package TestClasses;

import MainClasses.Customers;
import org.junit.*;


public class CustomersTest {

    private Customers object;
    @Before
    public void createobject()
    {
        object = new Customers("Umair","Dab no 2",(long)1234,(long)1234567);
    }
    @Test
    public void Testchecktwoaccounts()
    {
        Assert.assertFalse(object.checktwoaccounts());
    }
    @Test
    public void Test2checktwoaccounts()
    {
        object.Accountnumber.add((long)223344);
        Assert.assertTrue(object.checktwoaccounts());
    }
}