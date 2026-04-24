import org.example.ArithmeticOperations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticOperationsTest {
    @ParameterizedTest
    @CsvSource({"1,2,3", "0,5,5", "-2,4,2"})
    void testAdd(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.add(a, b));
    }

    @ParameterizedTest
    @CsvSource({"5,2,3", "4,5,-1", "-8,-4,-4"})
    void testSubtract(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.subtract(a, b));
    }

    @ParameterizedTest
    @CsvSource({"6,2,3", "20,4,5", "-12,-3,4"})
    void testDivide(int a, int b, int expected) {
        assertEquals(expected, ArithmeticOperations.divide(a, b));
    }
}
