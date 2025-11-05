package SystemDesign;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    void testInitialBalanceIsZero() {
        Account acc = new Account();
        assertEquals(new BigDecimal("0.0"), acc.getBalance());
    }

    @Test
    void testAddTransactionIncreasesBalance() {
        Account acc = new Account();
        acc.addTransaction(new Income(new BigDecimal("100"), "2025-11-04", "Test"));
        assertEquals(new BigDecimal("100.0"), acc.getBalance());
    }

    @Test
    void testAddTransactionDecreasesBalance() {
        Account acc = new Account();
        acc.addTransaction(new Expense(new BigDecimal("50"), "2025-11-04", "Test"));
        assertEquals(new BigDecimal("-50.0"), acc.getBalance());
    }

    @Test
    void testTransactionsListUpdates() {
        Account acc = new Account();
        acc.addTransaction(new Income(new BigDecimal("20"), "2025-11-04", "Test"));
        assertEquals(1, acc.getTransactions().size());
    }
}
