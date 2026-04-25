import org.example.IntegerComparator;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class IntegerComparatorTest {
    @DataProvider(name = "compareData")
    public Object[][] compareData() {
        return new Object[][] {{2,2,0}, {3,2,1}, {1,5,-1}};
    }

    @Test(dataProvider = "compareData")
    public void testCompare(int a, int b, int expected) {
        assertEquals(IntegerComparator.compare(a, b), expected);
    }
}
