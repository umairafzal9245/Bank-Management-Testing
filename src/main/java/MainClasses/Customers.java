package MainClasses;

import java.util.ArrayList;

public class Customers 
{
	private String Name;
	private String Address;
	private Long Phone;
	public ArrayList<Long> Accountnumber = new ArrayList<Long>();
	private int loginpin;
	public boolean logincheck;
	

	public Customers(String Name,String Address,Long Phone,Long Accountnumber)
	{
		this.Name = Name;
		this.Address = Address;
		this.Phone = Phone;
		this.setLoginpin(0);
		this.logincheck = false;
		this.Accountnumber.add(Accountnumber);
	}
	public boolean checktwoaccounts()
	{
		if(Accountnumber.size() >= 2)
			return true;
		
		return false;
	}
	public void setLoginpin(int loginpin) {
		this.loginpin = loginpin;
	}

	public String getName() {
		return Name;
	}
}

