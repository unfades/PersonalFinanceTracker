package SystemDesign;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class ExpenseTest {

    @Test
    void testExpenseInitialization() {
        Expense e = new Expense(new BigDecimal("100"), "2025-11-04", "Groceries");
        assertEquals(new BigDecimal("100"), e.amount);
    }

    @Test
    void testExpenseApplySubtractsFromBalance() {
        Account acc = new Account();
        Expense e = new Expense(new BigDecimal("50"), "2025-11-04", "Food");
        e.apply(acc);
        assertEquals(new BigDecimal("-50.0"), acc.getBalance());
    }

    @Test
    void testExpenseAmountBecomesNegative() {
        Account acc = new Account();
        Expense e = new Expense(new BigDecimal("80"), "2025-11-04", "Travel");
        e.apply(acc);
        assertEquals(new BigDecimal("-80"), e.amount);
    }

    @Test
    void testExpenseCategoryStored() {
        Expense e = new Expense(new BigDecimal("25"), "2025-11-04", "Snacks");
        assertEquals("Snacks", e.category);
    }
}

