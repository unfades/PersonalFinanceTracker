package SystemDesign;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class ConcreteReportGeneratorTest {

    @Test
    void testReportRunsWithoutError() {
        Account acc = new Account();
        acc.addTransaction(new Income(new BigDecimal("100"), "2025-11-04", "Salary"));
        acc.addTransaction(new Expense(new BigDecimal("40"), "2025-11-04", "Food"));
        ReportGenerator rg = new ConcreteReportGenerator();
        assertDoesNotThrow(() -> rg.generateReport(acc));
    }

    @Test
    void testReportAcceptsEmptyAccount() {
        Account acc = new Account();
        ReportGenerator rg = new ConcreteReportGenerator();
        assertDoesNotThrow(() -> rg.generateReport(acc));
    }

    @Test
    void testReportCalculatesBalanceCorrectly() {
        Account acc = new Account();
        acc.addTransaction(new Income(new BigDecimal("200"), "2025-11-04", "Job"));
        acc.addTransaction(new Expense(new BigDecimal("50"), "2025-11-04", "Fuel"));
        assertEquals(new BigDecimal("150.0"), acc.getBalance());
    }

    @Test
    void testReportGeneratorIsInstanceOfAbstractType() {
        ReportGenerator rg = new ConcreteReportGenerator();
        assertTrue(rg instanceof ReportGenerator);
    }
}
