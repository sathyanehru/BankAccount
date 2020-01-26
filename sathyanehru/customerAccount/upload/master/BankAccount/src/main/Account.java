package main;

public class Account {
	
	private String acctNumber;
	private double amount;
	
	public Account(String acctNumber, double amount) {
		super();
		this.acctNumber = acctNumber;
		this.amount = amount;
	}
	public String getAcctNumber() {
		return acctNumber;
	}
	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
