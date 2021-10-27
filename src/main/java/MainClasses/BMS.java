package MainClasses;

import java.util.ArrayList;
import java.util.Scanner;

public class BMS 
{
	ArrayList<Customers> CustomersList;
	ArrayList<Accounts> AccountsList;
	
	public BMS()
	{
		CustomersList = new ArrayList<Customers>();
		AccountsList = new ArrayList<Accounts>();
	}
	public int searchcustomers(String name)
	{
		int counter = -1;
		if(!CustomersList.isEmpty())
		{
			for	(int i=0;i<CustomersList.size();i++)
			{
				if(CustomersList.get(i).getName().equals(name))
				{
					counter = i;
					break;
				}
			}
		}
		return counter;
	}
	public int searchcustomers(Long accountnumber)
	{
		int counter = -1;
		if(!CustomersList.isEmpty())
		{
			for	(int i=0;i<CustomersList.size();i++)
			{
				if(CustomersList.get(i).Accountnumber.get(0).equals(accountnumber))
				{
					counter = i;
					break;
				}
				if(CustomersList.get(i).Accountnumber.size() > 1)
				{
					if(CustomersList.get(i).Accountnumber.get(1).equals(accountnumber))
					{
						counter = i;
						break;
					}
				}
			}
		}
		return counter;
	}
	public int searchaccounts(Long accountnumber)
	{
		int counter = -1;
		if(!AccountsList.isEmpty())
		{
			for	(int i=0;i<AccountsList.size();i++)
			{
				if(AccountsList.get(i).getAccountnumber().equals(accountnumber))
				{
					counter = i;
					break;
				}
			}
		}
		return counter;
	}
	@SuppressWarnings("resource")
	public void openanaccount(String name,String Address,String Accounttype,Long phone,Long accountnumberr,double balance,int loginpinkk)
	{
		long accountnumber = accountnumberr;
		int loginpin = loginpinkk;

		int index = searchcustomers(name);
		if(index == -1)
		{
			if(Accounttype.toLowerCase().equals("checking"))
			{
				Accounts newaccount = new Checking_Accounts(accountnumber,balance);
				Customers newcustomer = new Customers(name,Address,phone,accountnumber);
				newcustomer.setLoginpin(loginpin);
				CustomersList.add(newcustomer);
				AccountsList.add(newaccount);
			}
			else if(Accounttype.toLowerCase().equals("saving"))
			{
				Accounts newaccount = new Saving_Accounts(accountnumber,balance);
				Customers newcustomer = new Customers(name,Address,phone,accountnumber);
				newcustomer.setLoginpin(loginpin);
				CustomersList.add(newcustomer);
				AccountsList.add(newaccount);
			}
			System.out.print("\nYou have successfully registered your account!!!\n");
			System.out.print("Please remember your assigned account number and pin for login!!!\nAccount Details are as follows : \n");
			System.out.print("\t\tName : "+name+"\tAddress : "+Address+"\tAccount Type : "+Accounttype+"\n");
			System.out.print("\t\tAccount Number : "+accountnumber+"\tLogin Pin : "+loginpin+"\tPhone : "+phone+"\tBalance : "+balance+"\n\n");
		}
		else if(index != -1)
		{
			if(CustomersList.get(index).checktwoaccounts() == true)
			{
				System.out.println("\nSir you have already two accounts registered!!!\n\n");
			}
			else if(CustomersList.get(index).checktwoaccounts() == false && Accounttype.toLowerCase().equals("checking"))
			{
				Accounts newaccount = new Checking_Accounts(accountnumber,balance);
				CustomersList.get(index).Accountnumber.add(accountnumber);
				AccountsList.add(newaccount);
				
			}
			else if(CustomersList.get(index).checktwoaccounts() == false && Accounttype.toLowerCase().equals("saving"))
			{
				Accounts newaccount = new Saving_Accounts(accountnumber,balance);
				CustomersList.get(index).Accountnumber.add(accountnumber);
				AccountsList.add(newaccount);	
			}
			System.out.print("\nYou have successfully registered your second account!!!\n");
			System.out.print("Please remember your assigned account number!!!\nAccount Details are as follows : \n");
			System.out.print("\t\tName : "+name+"\tAddress : "+Address+"\tAccount Type : "+Accounttype+"\n");
			System.out.print("\t\tAccount Number : "+accountnumber+"\tPhone : "+phone+"\tBalance : "+balance+"\n\n");
		}
		
	}
	@SuppressWarnings("resource")
	public boolean closeanaccount(Long accountnumber)
	{
		//Scanner input = new Scanner(System.in);
		//Long accountnumber;
		//System.out.print("Enter the account number : ");
		//accountnumber = input.nextLong();
		
		int index2 = searchcustomers(accountnumber);
		if(index2 != -1)
		{
			if(CustomersList.get(index2).Accountnumber.size() > 1)
			{
				CustomersList.get(index2).Accountnumber.remove(accountnumber);
			}
			else if(CustomersList.get(index2).Accountnumber.size() == 1)
			{
				CustomersList.remove(index2);
			}
			int index = searchaccounts(accountnumber);
			AccountsList.remove(index);
			System.out.print("Account "+accountnumber+" Successfully removed\n\n");
		}
		else if(index2 == -1)
		{
			System.out.print("Account "+accountnumber+" Not present\n\n");
			return false;
		}
		return true;
	}
}

