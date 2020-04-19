import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.RPNCalculator;

public class RPNTest {
    private RPNCalculator calculator;
    private static final String CHECK_SUCCESS = "DDODDOO";
    private static final String CHECK_FAILURE = "DDODDOODDO";
    private static final String CALCULATE_SUCCESS = "34+62+*";
    private static final String CALCULATE_FAILURE = "34+*";
    private static final String CALCULATE_ZERO_DIVISION = "30+33-/";

    @Test
    void testCheckPositive() {
        calculator = new RPNCalculator(CHECK_SUCCESS);
        Assertions.assertDoesNotThrow(() -> calculator.check());
    }

    @Test
    void testCheckNegative() {
        calculator = new RPNCalculator(CHECK_FAILURE);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.check());
    }

    //Test a:
    @Test
    void testCalculatePositive() {
        calculator = new RPNCalculator(CALCULATE_SUCCESS);
        Assertions.assertDoesNotThrow(() -> calculator.calculate());
    }

    //Test b:
    @Test
    void testCalculateNegative() {
        calculator = new RPNCalculator(CALCULATE_FAILURE);
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.calculate());
    }

    //Test c:
    @Test
    void testCalculateZeroDivision() {
        calculator = new RPNCalculator(CALCULATE_ZERO_DIVISION);
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.calculate());
    }
}