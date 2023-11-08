package etsn20.programvarutestning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PredicateTests {

    private static NextDate nextDate;

    private static String INVALID_INPUT = "Invalid Input Date",
                          INVALID_YEAR  = "Invalid Next Year";

    @BeforeAll
    static void setup() {
        nextDate = new NextDate(0, 0, 0);
    }

    //First if-statment
    @Test
    void testFFFFF() {
        assertEquals("1/21/2020", nextDate.run(1, 20, 2020));
    }
    @Test
    void testTFFFF() {
        assertEquals(INVALID_INPUT, nextDate.run(1, -20, 2020));
    }
    @Test
    void testFTFFF() {
        assertEquals(INVALID_INPUT, nextDate.run(-1, 20, 2020));
    }
    @Test
    void testFFTFF() {
        assertEquals(INVALID_INPUT, nextDate.run(100, 20, 2020));
    }
    @Test
    void testFFFTF() {
        assertEquals(INVALID_INPUT, nextDate.run(1, 20, 20));
    }
    @Test
    void testFFFFT() {
        assertEquals(INVALID_INPUT, nextDate.run(1, 20, 12020));
    }

    // Branch and Statement tests

    /**
     * Test branch for invalid input date.
     */
    @Test
    void testInvalidInput_whenNextDay_thenInvalidInput() {
        assertEquals(INVALID_INPUT, nextDate.run(1, 1, 1800));
    }

    /**
     * Test statements for a month with 31 days.
     */
    @Test
    void testNextDay_when31Month_thenNextDay() {
        assertEquals("1/21/2020", nextDate.run(1, 20, 2020));
    }


    /**
     * Test branch for new month after 31 Month.
     * Note: Should not be January.
     */
    @Test
    void testNextMonth_when31stIn31Month_thenNewMonth() {
        assertEquals("6/1/2020", nextDate.run(5, 31, 2020));
    }

    /**
     * Test statements for a month with 30 days.
     */
    @Test
    void testNextDay_when30Month_thenNextDay() {
        assertEquals("4/21/2020", nextDate.run(4, 20, 2020));
    }

    /**
     * Test branch for new month after 30 Month.
     */
    @Test
    void testNextMonth_when30thIn30Month_thenNewMonth() {
        assertEquals("5/1/2020", nextDate.run(4, 30, 2020));
    }
    
    /**
     * Test for invalid input date on 31st in 30 Month.
     */
    @Test
    void testNextMonth_when31stIn30Month_thenInvalidInputDate() {
        assertEquals(INVALID_INPUT, nextDate.run(4, 31, 2020));
    }

    /**
     * Test branch for new day in Decemeber.
     */
    @Test
    void testNextDay_whenDecember_thenNewDay() {
        assertEquals("12/13/2020", nextDate.run(12, 12, 2020));
    }

    /**
     * Test branch for new year.
     */
    @Test
    void testNextYear_when31stInDecember_thenNewYear() {
        assertEquals("1/1/2021", nextDate.run(12, 31, 2020));
    }

    /**
     * Test statements for a new year.
     * Note: Not successful due to bug in statement (<= should be changed to less than).
     */
    @Test
    void testNextYear_whenNewYear_thenInvalidNextYear() {
        assertEquals(INVALID_YEAR, nextDate.run(12, 31, 2021));
    }
    
    /**
     * Test branch for new day in February.
     */
    @Test
    void testNextDay_whenFebruary_thenNextDay() {
        assertEquals("2/13/2020", nextDate.run(2, 12, 2020));
    }

    /**
     * Test statements for the 28th of February on a Leap Year.
     */
    @Test
    void testNextDay_when28thLeapYear_thenNextDay() {
        assertEquals("2/29/2020", nextDate.run(2, 28, 2020));
    }

    /**
     * Test branch for new month after 28th in February non Leap Year.
     */
    @Test
    void testNextMonth_when28thNonLeapYear_thenNextDay() {
        assertEquals("3/1/2019", nextDate.run(2, 28, 2019));
    }

    /**
     * Test statements for the 29th of February on a Leap Year.
     */
    @Test
    void testNextMonth_when29thLeapYear_thenNewMonth() {
        assertEquals("3/1/2020", nextDate.run(2, 29, 2020));
    }

    /**
     * Test branch for new month after 29th in February non Leap Year.
     */
    @Test
    void testNextMonth_when29thNonLeapYear_thenInvalidInputDate() {
        assertEquals(INVALID_INPUT, nextDate.run(2, 29, 2019));
    }

    /**
     * Test statements for invalid input on a Leap Year.
     */
    @Test
    void testNextMonth_when30thFeb_thenInvalidInputDate() {
        assertEquals(INVALID_INPUT, nextDate.run(2, 30, 2020));
    }

    

}
