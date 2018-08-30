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

    @Test
    public void TestInvalidDayAndMonthWithValidModulo400Year() {
        try{
            Dates.dayOfWeek(2000,0,0);
            fail("Test was expected to fail due to invalid day");
        } catch (IllegalArgumentException e) {
            //Do nothing as test has passed
        }
    }
}
