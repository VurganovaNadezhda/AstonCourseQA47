import org.example.FactorialCalculator;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class FactorialCalculatorTest {
    @DataProvider(name = "factorialData")
    public Object[][] factorialData() {
        return new Object[][] {{0,1L}, {3,6L}, {5,120L}};
    }

    @Test(dataProvider = "factorialData")
    public void testFactorial(int n, long expected) {
        assertEquals(FactorialCalculator.factorial(n), expected);
    }
}
