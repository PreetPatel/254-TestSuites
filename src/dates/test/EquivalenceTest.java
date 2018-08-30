package dates.test;

import dates.Dates;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * EquivalenceTest.java
 * Tests the equivalence partition of the last day of the last month of a valid year
 * @Author Preet Patel
 */
public class EquivalenceTest {

    @Test
    public void TestFinalCalendarDate() {
        assertEquals(Dates.Day.Sunday, Dates.dayOfWeek(2000,12,31));
    }
}
