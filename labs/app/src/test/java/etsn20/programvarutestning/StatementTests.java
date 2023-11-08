package etsn20.programvarutestning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Statement tests testing statement execution.
 */
class StatementTests {
    
    private static NextDate nextDate;
    
    private static String INVALID_INPUT = "Invalid Input Date", 
                          INVALID_YEAR  = "Invalid Next Year";
    
    @BeforeAll
    static void setup() {
        nextDate = new NextDate(0, 0, 0);
    }

    /**
     * Test statements for a month with 31 days.
     */
    @Test
    void testNextDay_when31Month_thenNextDay() {
        assertEquals("1/21/2020", nextDate.run(1, 20, 2020));
    }

    /**
     * Test statements for a month with 30 days.
     */
    @Test
    void testNextDay_when30Month_thenNextDay() {
        assertEquals("4/21/2020", nextDate.run(4, 20, 2020));
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
     * Test statements for the 28th of February on a Leap Year.
     */
    @Test
    void testNextDay_when28thLeapYear_thenNextDay() {
        assertEquals("2/29/2020", nextDate.run(2, 28, 2020));
    }

    /**
     * Test statements for the 29th of February on a Leap Year.
     */
    @Test
    void testNextMonth_when29thLeapYear_thenNewMonth() {
        assertEquals("3/1/2020", nextDate.run(2, 29, 2020));
    }

    /**
     * Test statements for invalid input on a Leap Year.
     */
    @Test
    void testNextMonth_when30thFeb_thenInvalidInputDate() {
        assertEquals(INVALID_INPUT, nextDate.run(2, 30, 2020));
    }
}
