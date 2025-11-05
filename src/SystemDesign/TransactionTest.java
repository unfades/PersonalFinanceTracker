package SystemDesign;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class TransactionTest {

    @Test
    void testTransactionInitialization() {
        Transaction t = new Transaction(new BigDecimal("100"), "2025-11-04", "Test") {};
        assertEquals(new BigDecimal("100"), t.amount);
        assertEquals("Test", t.category);
    }

    @Test
    void testApplyDoesNothing() {
        Account acc = new Account();
        Transaction t = new Transaction(new BigDecimal("100"), "2025-11-04", "None") {};
        t.apply(acc);
        assertEquals(new BigDecimal("0.0"), acc.getBalance());
    }

    @Test
    void testTransactionDateStored() {
        Transaction t = new Transaction(new BigDecimal("50"), "2025-11-04", "Misc") {};
        assertEquals("2025-11-04", t.date);
    }

    @Test
    void testTransactionCategory() {
        Transaction t = new Transaction(new BigDecimal("75"), "2025-11-04", "Food") {};
        assertEquals("Food", t.category);
    }
}
