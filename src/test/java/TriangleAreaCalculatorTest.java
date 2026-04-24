import org.example.TriangleAreaCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleAreaCalculatorTest {
     @ParameterizedTest
     @CsvSource({"3,4,5,6.0", "6,8,10,24.0", "5,5,6,12.0"})
     void testArea(double a, double b, double c, double expected) {
         assertEquals(expected, TriangleAreaCalculator.area(a, b, c), 0.001);
     }
}
