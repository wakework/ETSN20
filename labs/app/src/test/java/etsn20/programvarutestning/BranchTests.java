package etsn20.programvarutestning;

import org.junit.jupiter.api.BeforeAll;

class BranchTests {
    private static NextDate nextDate;

    private static String INVALID_INPUT = "Invalid Input Date",
                          INVALID_YEAR  = "Invalid Next Year";

    @BeforeAll
    static void setup() {
        nextDate = new NextDate(0, 0, 0);
    }
}
