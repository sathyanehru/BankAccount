package main;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainApplication{

	
	public static void main(String[] args){
		//case1
		List<CustomerData> case1List = new ArrayList<>();
		CustomerData customer1 = new CustomerData(777,"Stewie","Griffin","1234",100);
		case1List.add(customer1);
		customer1.deposit(300,case1List,"1234","USD");
		
		System.out.println("Account Number: "+customer1.getAcctNumber()+"Balance: "+customer1.getAmount());
		
		//case2
		List<CustomerData> case2List = new ArrayList<>();
		CustomerData customer2 = new CustomerData(504,"Glenn","Quagmire","2001",35000);
		case2List.add(customer2);
		customer2.withdraw(5000, case2List, "2001", "MXN");
		//customer2.setBalance(customer2,"2001",afterWitdrawBal);
		 customer2.withdraw(12500, case2List, "2001", "USD");
		//customer2.setBalance(customer2,"2001",afterWithNewBal);
		customer2.deposit(300, case2List, "2001", "CAD");
		System.out.println("Account Number: "+customer2.getAcctNumber()+"Balance: "+customer2.getAmount());
		//case3
		CustomerData customer3 = new CustomerData(002,"Joe","Swanson","1010",7425);
		CustomerData customer4 = new CustomerData(002,"Joe","Swanson","5500",15000);
		List<CustomerData> case3List = new ArrayList<>();
		case3List.add(customer3);
		case3List.add(customer4);
		
		customer3.withdraw(5000, case3List, "5500", "CAD");
		customer3.transfer(7300, case3List, "1010", "5500", "CAD");
		customer3.deposit(13726, case3List, "1010", "MXN");
		System.out.println("Account Number: "+customer3.getAcctNumber()+"Balance: "+customer3.getAmount());
		System.out.println("Account Number: "+customer4.getAcctNumber()+"Balance: "+customer4.getAmount());
		//case4
		List<CustomerData> case4List = new ArrayList<>();
		CustomerData customer5 = new CustomerData(123,"Peter","Griffin","0123",150);
		CustomerData customer6 = new CustomerData(456,"Lois","Griffin","0456",65000);
		case4List.add(customer5);
		case4List.add(customer6);
		customer5.withdraw(70, case4List, "0123", "USD");
		customer6.deposit(23789, case4List, "0456", "USD");
		customer5.transfer(23.75, case4List, "0456", "0123", "CAD");
	
		System.out.println("Account Number: "+customer5.getAcctNumber()+"Balance: "+customer5.getAmount());
		System.out.println("Account Number: "+customer6.getAcctNumber()+"Balance: "+customer6.getAmount());
		
		
	
		
	}

}
