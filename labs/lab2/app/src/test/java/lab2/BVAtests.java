package lab2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * TriangleTest for testing the Triangle class.
 * This template is used in the exercise phase 1.
 * Students should add relevant unit test cases related to the Triangle 
 * class to this class.
 */
public class BVAtests {
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
	 * Initializes common objects. The method will be run before the Test method.
	 */
	public void setUp() throws Exception {
		triangle = new Triangle(0, 0, 0);
	}

	@After
	/*
	 *   Cleanup method. This method will be run after the Test method is completed
	 */
	public void tearDown() throws Exception {
		triangle = null;
	}

    /*---------------------------------Equal Sides---------------------------------*/

	@Test
    public void testBVA_whenAllSidesAreEqual_thenReturnValid() {
        triangle.setSideLengths(80, 80, 80);

        getSideLengthsOfTriangle("80,80,80");
        getAreaOfTriangle(2771.3);
        getPerimeterOfTriangle(240);
        classifyTriangle("equilateral");

        assertTrue(triangle.isEquilateral());
    }

	@Test
    public void testBVA_whenAllSidesAreEqual_thenReturnInvalid() {
        triangle.setSideLengths(80, 80, 79);

        getSideLengthsOfTriangle("80,80,79");

        assertFalse(triangle.isEquilateral());
    }


	@Test
    public void testBVA_whenTwoSidesAreEqual_thenReturnValid() {
        triangle.setSideLengths(80, 80, 79);

        getSideLengthsOfTriangle("80,80,79");
        getAreaOfTriangle(2747.9);
        getPerimeterOfTriangle(239);
        classifyTriangle("isosceles");

        assertTrue(triangle.isIsosceles());
    }

	@Test
    public void testBVA_whenTwoSidesAreEqual_thenReturnInvalid() {
        triangle.setSideLengths(79, 80, 81);

        getSideLengthsOfTriangle("79,80,81");

        assertFalse(triangle.isIsosceles());
    }


    /*---------------------------------Right Angle---------------------------------*/


	@Test
    public void testBVA_whenRightAngle_thenReturnValid() {
        triangle.setSideLengths(30, 40,	50);

        getSideLengthsOfTriangle("30,40,50");
        getAreaOfTriangle(600);
        getPerimeterOfTriangle(120);
        classifyTriangle("right-angled");

        assertTrue(triangle.isRightAngled());
    }

	@Test
    public void testBVA_whenRightAngle_thenReturnInvalid() {
        triangle.setSideLengths(30, 40, 51);

        getSideLengthsOfTriangle("30,40,51");

        assertFalse(triangle.isRightAngled());
	}

    /*---------------------------------Scalene---------------------------------*/


	@Test
    public void testBVA_whenAllRandomSides_thenReturnValid() {
        triangle.setSideLengths(112, 102, 140);

        getSideLengthsOfTriangle("124,102,140");
        getAreaOfTriangle(6132.4);
        getPerimeterOfTriangle(366);
        classifyTriangle("scalene");

        assertTrue(triangle.isScalene());
    }

	@Test
    public void testBVA_whenAllRandomSides_thenReturnInvalid() {
        triangle.setSideLengths(112, 112, 189);

        getSideLengthsOfTriangle("112,112,189");

        assertFalse(triangle.isScalene());
    }

    /*---------------------------------Impossible---------------------------------*/


	@Test
    public void testBVA_whenImpossible_thenReturnValid() {
        triangle.setSideLengths(100, 101, 200);

        getSideLengthsOfTriangle("100,101,200");
        getAreaOfTriangle(1001.2);
        getPerimeterOfTriangle(401);
        classifyTriangle("scalene");

        assertFalse(triangle.isImpossible());
    }

	@Test
    public void testBVA_whenAllRandomSides_thenReturnInvalid() {
        triangle.setSideLengths(112, 112, 189);

        getSideLengthsOfTriangle("112,112,189");

        assertFalse(triangle.isImpossible());
    }

	/* 
	 * Tests whether the triangle specified in the fixture (setUp) 
	 * is right-angled. 	
	 *
	 * A public void method that is attached to be run as a test case. 
	 * To run the method, JUnit first constructs a fresh instance of the class then 
	 * invokes the annotated method. Any exceptions thrown by the test will be reported
	 * by JUnit as a failure. If no exceptions are thrown, the test is assumed to have 
	 * succeeded. 
	*/
    void dummyTest() {
        assertTrue("This is a dummy test", false);
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
