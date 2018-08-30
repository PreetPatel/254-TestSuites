package dates.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class BranchTests {

    @Test
    public void dayOfWeek() {
        assertEquals(Dates.Day.Monday, Dates.dayOfWeek(2018,1,1));
    }

//    @Test
//    public void TestLeapYearAndJanuary() {
//        assertEquals(Dates.Day.Tuesday, Dates.dayOfWeek(2016,1,12));
//    }

//    @Test
//    public void TestLeapYearModulo400() {
//        assertEquals(Dates.Day.Wednesday, Dates.dayOfWeek(2000,1,12));
//    }

//    @Test
//    public void TestDoomsDay() {
//        assertEquals(Dates.Day.Tuesday, Dates.dayOfWeek(2000,1,4));
//    }

    @Test
    public void InvalidNegativeMonth() {
        try {
            Dates.dayOfWeek(2018,0,12);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    @Test
    public void InvalidNegativeDay() {
        try {
            Dates.dayOfWeek(2018,8,0);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    @Test
    public void InvalidMonth() {
        try {
            Dates.dayOfWeek(2018,13,12);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    @Test
    public void InvalidDay() {
        try {
            Dates.dayOfWeek(2018,8,32);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    @Test
    public void InvalidYearModulo100() {
        try {
            Dates.dayOfWeek(1000,8,32);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    @Test
    public void LeapYearWithInvalidMonth() {
        try {
            Dates.dayOfWeek(2016,2,30);
            fail();
        } catch (IllegalArgumentException e) {
            //do nothing and pass
        }
    }

    @Test
    public void TestFinalCalendarDate() {
        assertEquals(Dates.Day.Sunday, Dates.dayOfWeek(2000,12,31));
    }

    @Test
    public void TestCalendarDate() {
        assertEquals(Dates.Day.Tuesday, Dates.dayOfWeek(2016,2,16));
    }

}