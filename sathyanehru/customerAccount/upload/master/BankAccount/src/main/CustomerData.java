package main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerData extends CustomerAccounts{
	
	private int custId;

	private String firstName;
	private String lastName;
	private String acctNumber;
	
	private double amount;
	
	private Map<String,Double> accounts;
	
	public CustomerData(String firstName, String lastName, String acctNumber,double amount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.acctNumber = acctNumber;
		this.amount = amount;
	}

	
	public CustomerData(int custId, String firstName, String lastName, String acctNumber,double amount) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.acctNumber = acctNumber;
		this.amount = amount;
		if(accounts == null){
			accounts = new HashMap<String, Double>();
		}
		
		accounts.put(acctNumber, amount);
		
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAcctNumber() {
		return acctNumber;
	}
	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}
	public Map<String,Double> getAccounts() {
		return accounts;
	}
	public void setAccounts(Map<String,Double>  accounts) {
		this.accounts = accounts;
	}
	@Override
	public String toString() {
		return "CustomerData [firstName=" + firstName + ", lastName=" + lastName + ", acctNumber=" + acctNumber
				+ ", accounts=" + accounts + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
		result = prime * result + ((acctNumber == null) ? 0 : acctNumber.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerData other = (CustomerData) obj;
		if (accounts == null) {
			if (other.accounts != null)
				return false;
		} else if (!accounts.equals(other.accounts))
			return false;
		if (acctNumber == null) {
			if (other.acctNumber != null)
				return false;
		} else if (!acctNumber.equals(other.acctNumber))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}


	public void setBalance(CustomerData customer2, String acctnum,double newBalance) {
		
		// TODO Auto-generated method stub
		if(customer2.getAcctNumber().equalsIgnoreCase(acctnum)){
			customer2.setAmount(newBalance);
		}
		
	}

}
