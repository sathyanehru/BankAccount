package main;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestMain {

	@Test
	public void case1Test() {
		//case1
				List<CustomerData> case1List = new ArrayList<>();
				CustomerData customer1 = new CustomerData(777,"Stewie","Griffin","1234",100);
				case1List.add(customer1);
				customer1.deposit(300,case1List,"1234","USD");
				  assertEquals
				   (700, customer1.getAmount(),0.0001); //delta is provided to deal wit floating point
	}
	
	@Test
	public void case2Test(){
		List<CustomerData> case2List = new ArrayList<>();
		CustomerData customer2 = new CustomerData(504,"Glenn","Quagmire","2001",35000);
		case2List.add(customer2);
		customer2.withdraw(5000, case2List, "2001", "MXN");
		//customer2.setBalance(customer2,"2001",afterWitdrawBal);
		 customer2.withdraw(12500, case2List, "2001", "USD");
		//customer2.setBalance(customer2,"2001",afterWithNewBal);
		customer2.deposit(300, case2List, "2001", "CAD");
		assertEquals(9800,customer2.getAmount(),0.0001);
		}
	
	@Test
	public void case3And4Test(){
		CustomerData customer3 = new CustomerData(002,"Joe","Swanson","1010",7425);
		CustomerData customer4 = new CustomerData(002,"Joe","Swanson","5500",15000);
		List<CustomerData> case3List = new ArrayList<>();
		case3List.add(customer3);
		case3List.add(customer4);
		
		customer3.withdraw(5000, case3List, "5500", "CAD");
		customer3.transfer(7300, case3List, "1010", "5500", "CAD");
		customer3.deposit(13726, case3List, "1010", "MXN");
		assertEquals(1497.6,customer3.getAmount(),0.0001);
		assertEquals(17300,customer4.getAmount(),0.0001);
		}
	
	@Test
	public void case5And6Test(){
		List<CustomerData> case4List = new ArrayList<>();
		CustomerData customer5 = new CustomerData(123,"Peter","Griffin","0123",150);
		CustomerData customer6 = new CustomerData(456,"Lois","Griffin","0456",65000);
		case4List.add(customer5);
		case4List.add(customer6);
		customer5.withdraw(70, case4List, "0123", "USD");
		customer6.deposit(23789, case4List, "0456", "USD");
		customer5.transfer(23.75, case4List, "0456", "0123", "CAD");
		assertEquals(33.75,customer5.getAmount(),0.0001);
		assertEquals(112554.25,customer6.getAmount(),0.0001);
	}
	
	
}
