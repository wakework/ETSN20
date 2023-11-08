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

}
