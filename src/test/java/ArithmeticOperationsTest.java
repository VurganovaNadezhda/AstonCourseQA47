import org.example.ArithmeticOperations;
import org.junit.jupiter.api.Test;
import org.testng.annotations.DataProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticOperationsTest {
    @DataProvider(name = "addData")
    public Object[][] addData() {
        return new Object[][] {{1,2,3}, {0,5,5}, {-2,4,2}};
    }

    @Test(dataProvider = "addData")
    public void testAdd(int a, int b, int expected) {
        assertEquals(ArithmeticOperations.add(a, b), expected);
    }

    @DataProvider(name = "subtractData")
    public Object[][] subtractData() {
        return new Object[][] {{5,2,3}, {4,5,-1}, {-8,-4,-4}};
    }

    @Test(dataProvider = "subtractData")
    public void testSubtract(int a, int b, int expected) {
        assertEquals(ArithmeticOperations.subtract(a, b), expected);
    }

    @DataProvider(name = "divideData")
    public Object[][] divideData() {
        return new Object[][] {{6,2,3}, {20,4,5}, {-12,-3,4}};
    }

    @Test(dataProvider = "divideData")
    public void testDivide(int a, int b, int expected) {
        assertEquals(ArithmeticOperations.divide(a, b), expected);
    }
}
