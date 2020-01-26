package main;
import java.util.List;

public interface BankAccountManagement {
	
	    public  double deposit(double amount,List<CustomerData>  customer,String acctNum,String currency); 

	    public double withdraw(double amount,List<CustomerData>  customer,String acctNum,String currency);

	    //public double getBalance();

	    public double transfer(double amount,List<CustomerData>  customer,String acctNum1,String acctNum2,String currency); 

}
