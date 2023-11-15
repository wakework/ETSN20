package lab2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * TriangleTest for testing the Triangle class.
 * This template is used in the exercise phase 1.
 * Students should add relevant unit test cases related to the Triangle
 * class to this class.
 */
public class EPtests {
    private static Triangle triangle;

    @BeforeClass
    /*
     * The method run once before any of the test methods in the class.
     */
    public static void setUpBeforeClass() throws Exception {
        System.out.println("Initiating test phase.");
    }

    @AfterClass
    /*
     * The method will be run after all the tests in the class have been run
     */
    public static void tearDownAfterClass() throws Exception {
        System.out.println("Test phase finishing up.");
    }

    @Before
    /*
     * Initialises common objects. The method will be run before the Test method.
     */
    public void setUp() throws Exception {
        triangle = new Triangle(0, 0, 0);
    }

    @After
    /*
     * Cleanup method. This method will be run after the Test method is completed
     */
    public void tearDown() throws Exception {
        triangle = null;
    }

    /*
     * TC1: Equal sides. EC1 under test.
     */
    @Test
    public void testEquilateral_whenAllSidesAreEqual_thenReturnValid() {
        triangle.setSideLengths(10, 10, 10);

        getSideLengthsOfTriangle("10,10,10");
        getAreaOfTriangle(43.3);
        getPerimeterOfTriangle(30);
        classifyTriangle("equilateral");

        assertTrue(triangle.isEquilateral());
    }

    /*
     * TC2: Two equal sides. EC2 under test.
     * Note: Isosceles may be spelled wrong.
     */
    @Test
    public void testIsosceles_whenTwoSidesAreEqual_thenReturnValid() {
        triangle.setSideLengths(10, 10, 12);

        getSideLengthsOfTriangle("10,10,12");
        getAreaOfTriangle(48);
        getPerimeterOfTriangle(32);
        classifyTriangle("isosceles");

        assertTrue(triangle.isIsosceles());
    }

    /*
     * TC3: Right-angled triangle. EC3 under test.
     */
    @Test
    public void testRightAngled_whenOneAngleIs90_thenReturnValid() {
        triangle.setSideLengths(3, 4, 5);

        getSideLengthsOfTriangle("3,4,5");
        getAreaOfTriangle(6);
        getPerimeterOfTriangle(12);
        classifyTriangle("right-angled");

        assertTrue(triangle.isRightAngled());
    }

    /*
     * TC4: Scalene triangle. EC4 under test.
     * Note: Could not calculate area when no sides are equal.
     * (3,4,6) should return an area.
     */
    @Test
    public void testScalene_whenNoSidesAreEqual_thenReturnValid() {
        triangle.setSideLengths(3, 4, 6);

        getSideLengthsOfTriangle("3,4,6");
        getAreaOfTriangle(5.3);
        getPerimeterOfTriangle(13);
        classifyTriangle("scalene");

        assertTrue(triangle.isScalene());
    }

    /*
     * TC5: Not a triangle. EC5 under test.
     * Note: Area returned as NaN, not -1.0.
     */
    @Test
    public void testNotTriangle_whenSumOfTwoSidesIsLessThanThird_thenReturnInvalid() {
        triangle.setSideLengths(3, 4, 8);

        getSideLengthsOfTriangle("3,4,8");
        getAreaOfTriangle(-1.0);
        getPerimeterOfTriangle(15);
        classifyTriangle("impossible");

        assertTrue(triangle.isImpossible());
    }

    /*
     * TC6: Sides are 0. EC6 under test.
     */
    @Test
    public void testImpossible_whenSidesAre0_thenReturnInvalid() {
        triangle.setSideLengths(0, 0, 0);

        getSideLengthsOfTriangle("0,0,0");
        getAreaOfTriangle(-1.0);
        getPerimeterOfTriangle(0);
        classifyTriangle("impossible");

        assertTrue(triangle.isImpossible());
    }

    /*
     * TC7: Sides are negative. EC7 under test.
     */
    @Test
    public void testImpossible_whenSidesAreNegative_thenReturnInvalid() {
        triangle.setSideLengths(-1, -1, -1);

        getSideLengthsOfTriangle("-1,-1,-1");
        getAreaOfTriangle(-1.0);
        getPerimeterOfTriangle(-3);
        classifyTriangle("impossible");

        assertTrue(triangle.isImpossible());
    }

    /*---------------------------------HELPER METHODS---------------------------------*/
    void classifyTriangle(String expected) {
        assertEquals(expected, triangle.classify());
    }

    void getAreaOfTriangle(double expected) {
        assertEquals(expected, triangle.getArea(), 0.1);
    }

    void getPerimeterOfTriangle(int expected) {
        assertEquals(expected, triangle.getPerimeter());
    }

    void getSideLengthsOfTriangle(String expected) {
        assertEquals(expected, triangle.getSideLengths());
    }
}
