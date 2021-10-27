package MainClasses;

import java.util.ArrayList;


public class Accounts 
{
	protected Long Accountnumber;
	protected double Balance;
	private String datecreated;
	public ArrayList<String> Transactions = new ArrayList<String>();

	public Accounts(Long Accountnumber,double Balance)
	{
		this.Accountnumber = Accountnumber;
		this.Balance = Balance;
		this.datecreated = java.time.LocalDate.now().toString();
	}


	public void specifyinterestrate(double interestrate){}
	public boolean makeDeposit(double amount)
	{
		return true;
	}
	public boolean makeWithdrawal(double amount){return true;}

	public String getaccounttype(){
		return "";
	}
	public Long getAccountnumber() {
		return Accountnumber;
	}

	public double getBalance() {
		return Balance;
	}


	public String getDatecreated() {
		return datecreated;
	}

}

