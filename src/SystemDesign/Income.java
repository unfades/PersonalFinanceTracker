package SystemDesign;

import java.math.BigDecimal;

public class Income extends Transaction{
    BigDecimal income;
    public Income(BigDecimal amount, String date, String category){
        super(amount,date,category);
    }

    @Override
    public void apply(Account account){
        this.amount = this.amount.abs();
        account.setBalance(this.amount);
    }
}