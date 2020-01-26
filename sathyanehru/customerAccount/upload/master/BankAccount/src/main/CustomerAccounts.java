package main;
import java.math.BigDecimal;
import java.util.List;

public abstract class CustomerAccounts implements BankAccountManagement{

	@Override
	public  double deposit(double amount,List<CustomerData> customer,String acctNum,String currency) {
	
		BigDecimal amtTobeDeposited = BigDecimal.valueOf(getExchangeRate(amount, currency));
		 validateAcct(acctNum,customer);
		for(CustomerData obj : customer){
			if(obj.getAcctNumber().equalsIgnoreCase(acctNum)){
				
				BigDecimal inital = BigDecimal.valueOf(obj.getAmount());
				if(inital.compareTo(BigDecimal.ZERO) >=0){
					amtTobeDeposited = amtTobeDeposited.add(inital);
				}
				//System.out.println("Amount deposited"+amtTobeDeposited);
				obj.setAmount(amtTobeDeposited.doubleValue());
				obj.getAccounts().put(acctNum,amtTobeDeposited.doubleValue() );
			}
		}
		
		return amtTobeDeposited.doubleValue();
	}

	@Override
	public double withdraw(double amount,List<CustomerData> customer,String acctNum,String currency) {
		BigDecimal amountTobeWith = BigDecimal.valueOf(getExchangeRate(amount, currency));
		BigDecimal existingAmount=BigDecimal.ZERO;
		BigDecimal newBalance=BigDecimal.ZERO;
		 validateAcct(acctNum,customer);
		//get the existing amount for the acct
		for(CustomerData obj : customer){
			if(obj.getAcctNumber().equalsIgnoreCase(acctNum)){
				if(obj.getAccounts().containsKey(acctNum)){
					existingAmount = BigDecimal.valueOf(obj.getAccounts().get(acctNum).doubleValue());
					 newBalance =(existingAmount).subtract(amountTobeWith);
					obj.setAmount(newBalance.intValue());
					obj.getAccounts().put(acctNum, newBalance.doubleValue());
				}
			}
		}
		

		return newBalance.doubleValue();
	}

	@Override
	public double transfer(double amount,List<CustomerData> customer,String acctNum1,String acctNum2,String currency)  {
		// TODO Auto-generated method stub
		double finalBalance = 0;
		String fromAccount = acctNum1;
		String toAccount = acctNum2;
		//validate acctNumber
	     validateAcct(acctNum1,customer);
		//get appropriate amounts
		for(CustomerData obj : customer){
			if(obj.getAcctNumber().equalsIgnoreCase(acctNum1)){
				finalBalance = withdraw(amount,customer,fromAccount,"CAD");
				obj.setAmount(finalBalance);
			}else if(obj.getAcctNumber().equalsIgnoreCase(acctNum2)){
				finalBalance = deposit(amount,customer,toAccount,"CAD");
			}
		}
	
		return finalBalance;
	}
	
	private void validateAcct(String acctNum1, List<CustomerData> customer) {
		// TODO Auto-generated method stub
		boolean res=false;
		for(CustomerData obj: customer){
			if(obj.getAccounts().containsKey(acctNum1)){
				res = true;
			}
		}
		
		if(!res){
			System.err.println("account number is not associated with any account");
		}
		
	}

	public static double getExchangeRate(double amount,String currency) {
		// TODO Auto-generated method stub
		BigDecimal b = BigDecimal.valueOf(amount);
		if(currency.equalsIgnoreCase("USD")){
			
			amount = b.divide(BigDecimal.valueOf(0.50)).doubleValue();
		}else if(currency.equalsIgnoreCase("MXN")){
			amount = b.divide(BigDecimal.valueOf(10)).doubleValue();
		}else if(currency.equalsIgnoreCase("CAD")){
			return amount;
		}else{
			System.err.println("Invalid Currency value");
		}
		return amount;
	}

}
