package dates.test;

import dates.Dates;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * DataflowTest.java
 * Identifies a DU-Path for the variable, 'year'.
 * @Author Preet Patel
 */
public class DataflowTest {

    /**
     * This test covers the DU Path of the variable Year. The definition starts at line 46 on the method signature
     * for dates.Dates#dayofWeek. Due to the months and days being invalid, the code follows a path that eventually
     * throws an InvalidArgumentException which is the exit vertex and is also where the year variable is used to
     * construct the error message for the exception.
     * The path contains no repeated vertex which makes it a simple path and has no definitions for the variable
     * 'year' except for the method signature where it was initially defined. There are only p-uses of the variable
     * in the path on lines 48 and 59 which is acceptable for such a path. This satisfies the definition of a
     * DU-Path.
     * This test additionally covers a path that would have otherwise not been tested by the other two
     * classes. That is the path (46,47,48,49,58,59,61,63,64,74,75). There is no other test in the other classes that
     * cover both lines 49 and 64 in the same path. This adds to improving the quality of the test suite as a new
     * path has been covered via the test case. This new path is useful as some definitions on different branches
     * may have caused a fault in the code that is executed later on in the path.
     *
     * To explain the path, lines 46 and 47 are executed following the entry point. On line 48, the conditional
     * evaluates to true because the year has a value 2000 which is a multiple of 400. This true evaluation leads to
     * line 49 being executed. The rest of the if block is skipped due to one of the conditionals evaluating to true.
     * Line 58 is executed leading into line 59 which evaluates to false since the year has a value greater than 1753.
     * The next 'else if' conditional on line 61 is also evaluated as false since neither the month or day variables
     * have values less than or equal to zero. Following that, the conditional on line 63 is evaluated as true since
     * the variable month has a value greater than 12. Due to this, line 64 is executed assigning the value false to
     * the 'valid' variable. The rest of the if block conditionals are skipped due to a conditional already successfully
     * evaluated as true. Line 74 is evaluated as true due to the assignment in line 64 and the IllegalArgumentException
     * is thrown due to line 75 being executed where the year variable is used to construct the error string.
     */
    @Test
    public void testInvalidMonthWithValidModulo400Year() {
        try{
            Dates.dayOfWeek(2000,13,3);
            fail("Test was expected to fail due to invalid day");
        } catch (IllegalArgumentException e) {
            //Do nothing as test has passed
        }
    }
}
