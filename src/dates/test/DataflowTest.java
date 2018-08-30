package dates.test;

import dates.Dates;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * DataflowTest.java
 * Identifies a DU-Path for the year variable.
 * @Author Preet Patel
 */
public class DataflowTest {

    /**
     * This test covers the DU Path of the variable Year. The definition starts at line 46 on the method signature
     * for dates.Dates#dayofWeek. Due to the months and days being invalid, the code follows a path that eventually
     * throws an InvalidArgumentException which is the exit vertex and is also where the year variable is used to
     * construct the error message for the exception.
     *
     * This test additionally covers a path that would have otherwise not been tested by the other two
     * classes. That is the path (46,47,48,49,58,59,61,62,74,75). There is no other test in the other classes that
     * cover both lines 49 and 62 in the same path. This also adds to improving the quality of the test suite.
     */
    @Test
    public void TestInvalidDayAndMonthWithValidModulo400Year() {
        try{
            Dates.dayOfWeek(2000,0,3);
            fail("Test was expected to fail due to invalid day");
        } catch (IllegalArgumentException e) {
            //Do nothing as test has passed
        }
    }
}
