package SystemDesign;

import java.math.BigDecimal;

public class Expense extends Transaction{
    BigDecimal expense;
    public Expense(BigDecimal amount, String date, String category){
        super(amount,date,category);
    }
    
    @Override
    public void apply(Account account){
    	//the negate method in BigDecimal makes positives negative and vice versa
        this.amount = this.amount.abs().negate();
        account.setBalance(this.amount);
    }
}
