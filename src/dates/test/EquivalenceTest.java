package dates.test;

import dates.Dates;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * EquivalenceTest.java
 * Tests the equivalence partition for an invalid day <= 0 for a valid month and year.
 * @Author Preet Patel
 */
public class EquivalenceTest {

    /**
     * The equivalence class for the variable 'day' can be classified into three classes: day <= 0,
     * day = 1 - 28,29,30,31, (depending on the month) and day > 28/29/30/31 (depending on the month).
     * Some variations from the latter two classes have been mostly tested in the other classes. The
     * value of day being greater than the max value of a month has been tested and so has a valid day
     * between 1-(max. day of month). Most variations are still left to be tested but the assumption
     * being made is that the array contains the correct information about the maximum days for a month.
     *
     * The only equivalence class that had not been tested was the value of 'day' being less than or equal
     * to 0. This test tests that equivalence class by assigning the value of day to 0. The test, combined with
     * the other two test classes make up the equivalence class for the variable day. This test adds value as
     * it is testing an equivalence partition that has not been tested in any other classes. It also completes
     * the conditional testing for line 61 which further adds value to the quality of the test.
     */
    @Test
    public void testInvalidZeroDay() {
        try {
            Dates.dayOfWeek(2000,6,0);
            fail("Expected to fail due to an invalid day parameter being passed");
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }
}
