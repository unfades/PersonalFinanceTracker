package SystemDesign;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class IncomeTest {

	@Test
    void testIncomeInitialization() {
        Income income = new Income(new BigDecimal("500"), "2025-11-04", "Salary");
        assertEquals(new BigDecimal("500"), income.amount);
    }

    @Test
    void testIncomeApplyAddsToBalance() {
        Account acc = new Account();
        Income income = new Income(new BigDecimal("200"), "2025-11-04", "Bonus");
        income.apply(acc);
        assertEquals(new BigDecimal("200.0"), acc.getBalance());
    }

    @Test
    void testIncomeApplyMakesAmountPositive() {
        Account acc = new Account();
        Income income = new Income(new BigDecimal("-150"), "2025-11-04", "Refund");
        income.apply(acc);
        assertEquals(new BigDecimal("150"), income.amount);
    }

    @Test
    void testIncomeCategoryStored() {
        Income income = new Income(new BigDecimal("300"), "2025-11-04", "Investment");
        assertEquals("Investment", income.category);
    }
}
