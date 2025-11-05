package SystemDesign;

import java.math.BigDecimal;

public class ConcreteReportGenerator extends ReportGenerator{
	
	@Override
	public void generateReport(Account account){
        BigDecimal income = new BigDecimal("0.0");
        BigDecimal expenses = new BigDecimal("0.0"); 
        
        System.out.println("Transaction History:");
        for(Transaction t : account.getTransactions()){
        	//instanceof to check if the object is of Income or Expense
            if(t instanceof Income){
            	System.out.println("Amount: $" + t.amount + " | Category: " + t.category + " | Date: " + t.date + " | Type: Income");
                income = income.add(t.amount);
            }else if(t instanceof Expense){
            	System.out.println("Amount: $" + t.amount.abs() + " | Category: " + t.category + " | Date: " + t.date + " | Type: Expense");
                expenses = expenses.add(t.amount);
            }
        }
        System.out.println();
        System.out.println("Account Summary:");
        System.out.println("Total Income $" + income);
        System.out.println("Total Expense $" + expenses.abs());
        System.out.println("Net Savings $" + account.getBalance());
    }
}
