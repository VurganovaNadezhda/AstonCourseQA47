import org.example.FactorialCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialCalculatorTest {
    @ParameterizedTest
    @CsvSource({"0,1", "3,6", "5,120"})
    void testFactorial(int n, long expected) {
        assertEquals(expected, FactorialCalculator.factorial(n));
    }
}
