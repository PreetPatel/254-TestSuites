package dates.test;

import dates.Dates;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * BranchTests.java
 * Tests each possible path deviating from a conditional statement.
 * @Author Preet Patel
 *
 * The tests in this class perform branch coverage testing on the class dates.Dates. 100% branch coverage is not
 * possible on the class due to the final array 'doomsdaysByMonth' declared in the class. Due to this, the for loop
 * on line 92 never evaluates to false. This is because there are items inside the array so the first item is
 * always retrieved. Due to this, the edge from line 92 to line 102 is never likely to be taken in any path.
 * This proves it impossible to have 100% branch coverage.
 *
 * Lines 61,65, and 96 are indicated as partial tests by EMMA due to the BranchTests class not satisfying conditional
 * coverage. Because of short-circuit boolean evaluation, there is no need to cover all four conditions for those if
 * statements. Hence, only the minimal amount of tests that evaluate the entire conditional to true and false have been
 * created since they are sufficient to provide branch coverage originating from those if-block statements.
 */
public class BranchTests {

    //Evaluates the conditional on line 96 to false
    @Test
    public void testValidDateWithMonthGreaterThanFebruary() {
        Assert.assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(2001,3,1));
    }

    //Evaluates the conditional on line 96 to true
    @Test
    public void testValidDateWithMonthBeingFebruary() {
        assertEquals(Dates.Day.Monday, Dates.dayOfWeek(2016,2,29));
    }

    //Evaluates the conditional on line 59 to true
    @Test
    public void testInvalidYear() {
        try {
            Dates.dayOfWeek(1000,8,30);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }
    //Evaluates the conditional on line 61 to true
    @Test
    public void testInvalidUnderflowMonth() {
        try {
            Dates.dayOfWeek(2000,0,31);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    //Evaluates the conditional on line 63 to true
    @Test
    public void testInvalidOverflowMonth() {
        try {
            Dates.dayOfWeek(2018,13,30);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    //Evaluates the conditionals on lines 65 and 66 to true
    @Test
    public void testLeapYearWithInvalidDayInFebruary() {
        try {
            Dates.dayOfWeek(2016,2,30);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    //Evaluates the conditional on line 70 to true
    @Test
    public void testInvalidOverflowDay() {
        try {
            Dates.dayOfWeek(2015,8,32);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }
}