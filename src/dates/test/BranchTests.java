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
 *
 * Lines 61,65, and 96 are indicated as partial tests by EMMA due to the BranchTests class not satisfying conditional
 * coverage. Because of short-circuit boolean evaluation, there is no need to cover all four conditions for those if
 * statements. Hence, only the minimal amount of tests that evaluate the if statements to true and false have been
 * created since they are sufficient to provide branch coverage originating from those lines.
 */
public class BranchTests {

    @Test
    public void dayOfWeek() {
        Assert.assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(2001,3,1));
    }

    //Don't need this one too as it doesn't add to branch coverage
//    @Test
//    public void TestFinalCalendarDate() {
//        assertEquals(Dates.Day.Sunday, Dates.dayOfWeek(2000,12,31));
//    }
//    @Test
//    public void TestFinalCalendarDate() {
//        assertEquals(Dates.Day.Saturday, Dates.dayOfWeek(2016,12,31));
//    }

    @Test
    public void TestCalendarDate() {
        assertEquals(Dates.Day.Monday, Dates.dayOfWeek(2016,2,29));
    }

//    @Test
//    public void TestLeapYearAndJanuary() {
//        assertEquals(dates.Dates.Day.Tuesday, dates.Dates.dayOfWeek(2016,1,12));
//    }

//    @Test
//    public void TestLeapYearModulo400() {
//        assertEquals(dates.Dates.Day.Wednesday, dates.Dates.dayOfWeek(2000,1,12));
//    }

//    @Test
//    public void TestDoomsDay() {
//        assertEquals(dates.Dates.Day.Tuesday, dates.Dates.dayOfWeek(2000,1,4));
//    }

    @Test
    public void InvalidYear() {
        try {
            Dates.dayOfWeek(1000,8,30);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    //This test is not needed as it adds to conditional coverage and not branch coverage
//    @Test
//    public void InvalidNegativeDay() {
//        try {
//            Dates.dayOfWeek(2018,8,-1);
//            fail();
//        } catch (IllegalArgumentException e) {
//            //do nothing and pass
//        }
//    }

    @Test
    public void InvalidOverflowMonth() {
        try {
            Dates.dayOfWeek(2000,13,12);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    @Test
    public void InvalidMonth() {
        try {
            Dates.dayOfWeek(2000,0,12);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    @Test
    public void InvalidOverflowDay() {
        try {
            Dates.dayOfWeek(2018,8,32);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    @Test
    public void LeapYearWithInvalidDayInFebruary() {
        try {
            Dates.dayOfWeek(2016,2,30);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }
}