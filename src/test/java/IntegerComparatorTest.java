import org.example.IntegerComparator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerComparatorTest {
    @ParameterizedTest
    @CsvSource({"2,2,0", "3,2,1", "1,5,-1"})
    void testCompare(int a, int b, int expected) {
        assertEquals(expected, IntegerComparator.compare(a, b));
    }
}
