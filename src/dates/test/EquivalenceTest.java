package dates.test;

import dates.Dates;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * EquivalenceTest.java
 * Tests the equivalence partition of the last day of the last month of a valid year
 * @Author Preet Patel
 */
public class EquivalenceTest {

    /**
     * @TODO Finish this gabage
     */
    @Test
    public void InvalidNegativeMonth() {
        try {
            Dates.dayOfWeek(2000,6,0);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }
}
