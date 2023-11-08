package etsn20.programvarutestning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PredicateTests {

    private static NextDate nextDate;
    
    @BeforeAll
    static void setup() {
        nextDate = new NextDate(0, 0, 0);
    }

}
