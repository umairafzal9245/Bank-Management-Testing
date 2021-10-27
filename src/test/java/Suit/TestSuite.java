package Suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import TestClasses.CustomersTest;
import TestClasses.Checking_AccountsTest;
import TestClasses.Saving_AccountsTest;
import TestClasses.BMSTest;
@RunWith(Suite.class)
@SuiteClasses({CustomersTest.class,Checking_AccountsTest.class,Saving_AccountsTest.class,BMSTest.class})
public class TestSuite{

}
