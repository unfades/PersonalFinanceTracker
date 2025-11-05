package SystemDesign;
import java.math.BigDecimal;

public class Transaction{

    protected BigDecimal amount;
    protected String date;
    protected String category;

    public Transaction(BigDecimal amount, String date, String category){
        this.amount = amount;
        this.date = date;
        this.category = category;
    }
    //overridden in Income/Expense
    public void apply(Account account) {
    	
    }
}
