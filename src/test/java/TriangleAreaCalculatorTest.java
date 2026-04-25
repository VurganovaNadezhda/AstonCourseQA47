
import org.example.TriangleAreaCalculator;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.*;



public class TriangleAreaCalculatorTest {
    @DataProvider(name = "areaData")
    public Object[][] areaData() {
        return new Object[][] {
                {3,4,5,6.0},
                {6,8,10,24.0},
                {5,5,6,12.0}
        };
    }

    @Test(dataProvider = "areaData")
    public void testArea(double a, double b, double c, double expected) {
        assertEquals(TriangleAreaCalculator.area(a,b,c), expected, 0.001);
    }
}
