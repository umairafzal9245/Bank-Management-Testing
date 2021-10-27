package MainClasses;

import java.text.SimpleDateFormat;  
import java.util.Date;  
public class Checking_Accounts extends Accounts
{
	private int transactionfee = 10;
	private int totaltransactionfee;
	private int freetransactions = 2;
	public String accounttype = "checking";
	
	public Checking_Accounts(Long Accountnumber,double Balance)
	{
		super(Accountnumber,Balance);
		totaltransactionfee = 0;
	}
	@Override
	public boolean makeDeposit(double amount)
	{
		if(amount < 0)
		{
			throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    String dateandtime = formatter.format(date).toString();
	    
		if(freetransactions == 0)
		{
			Balance = Balance + amount;
			Balance -= 10;
			totaltransactionfee += 10;
			System.out.print("\nBalance "+amount+" Rs has been succesfully deposited in your saving account\n");
			System.out.print("Transaction fee : 10 Rs\n\n");
		    Transactions.add("Deposited "+amount+" Rs | Date : "+dateandtime+" | Transaction Fee : 10 Rs");
		}
		else if(freetransactions > 0)
		{
			Balance = Balance + amount;
			System.out.print("\nBalance "+amount+" Rs has been succesfully deposited in your saving account\n");
			freetransactions--;
			System.out.print("Transaction fee : 0 Rs \tFree transactions remaining : "+freetransactions+"\n\n");
			Transactions.add("Deposited "+amount+" Rs | Date : "+dateandtime+" | Transaction Fee : 0 Rs | Free Transaction");
		}
		return true;
	}
	@Override
	public boolean makeWithdrawal(double amount)
	{
		if(amount < 0)
		{
			throw new IllegalArgumentException("Only Positive Numbers & no Letters Please!");
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
	    String dateandtime = formatter.format(date).toString();
	    
		if(amount < Balance + 5000)
		{
			Balance = Balance - amount;
			System.out.print("\nAmount "+amount+" Rs has been withdrawal from your account\n");
			System.out.print("Transaction fee : 10 Rs\n\n");
			if(freetransactions == 0)
			{
				Balance -= 10;
				totaltransactionfee += 10;
				Transactions.add("Withdrawal "+amount+" Rs | Date : "+dateandtime+" | Transaction Fee : 10 Rs");
			}
			else if(freetransactions > 0)
			{
				freetransactions--;
				Transactions.add("Withdrawal "+amount+" Rs | Date : "+dateandtime+" | Transaction Fee : 0 Rs | Free Transaction");
			}
		}
		else 
		{
			System.out.print("\nNot enough balance\n");
			return false;
		}
		return true;
	}
}

