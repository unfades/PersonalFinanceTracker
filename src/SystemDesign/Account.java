package SystemDesign;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account{
    private BigDecimal balance;
    private List<Transaction> transactionsList;

    public Account(){
        this.balance = new BigDecimal("0.0");
        this.transactionsList = new ArrayList<>();
    }

    public void addTransaction(Transaction t){
        t.apply(this);
        transactionsList.add(t);
    }

    public BigDecimal getBalance(){
        return this.balance;
    }

    public void setBalance(BigDecimal amount){
        this.balance = this.balance.add(amount);
    }

    public List<Transaction> getTransactions(){
        return transactionsList;
    }
}