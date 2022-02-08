package com.expoundlabs.thushan.employeemanagementplatform.util;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@DisplayName("When running MathUtils")
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter) {
        this.testInfo = testInfo;
        this.testReporter = testReporter;
        mathUtils = new MathUtils();
        this.testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }

    @AfterEach
    void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Test
    @DisplayName("Testing add method")
    @Tag("Math")
    void add() {
//        MathUtils mathUtils = new MathUtils();
        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual, "This is the add method should add two numbers");
    }

    @Test
    void divide() {
        boolean isServerUp = false;
        assumeTrue(isServerUp);

//        MathUtils mathUtils = new MathUtils();
        mathUtils.divide(1, 0);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "divide by 0 should throw");
    }

    @Test
    @Tag("Circle")
    void computeCircleArea() {
//        MathUtils mathUtils = new MathUtils();
        assertEquals(314.15926535898, mathUtils.computeCircleArea(100), "Should return the right circle area");
    }

    @Test
    @Disabled
    @DisplayName("TDD Should not run")
    void testDisabled() {
        fail("This test should be disabled");
    }

    @Test
    @DisplayName("multiply method")
    void testMultiply() {
//        System.out.println("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
//        this.testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());

//        assertEquals(4, mathUtils.multiply(2,2), "should returns the right product");
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2,2)),
                () -> assertEquals(0, mathUtils.multiply(2,0)),
                () -> assertEquals(-2, mathUtils.multiply(2,-1))
        );
    }

    @Nested
    @DisplayName("add method")
    class AddTest {
        @Test
        @DisplayName("when adding two positive numbers")
        void addPositive() {
            assertEquals(2, mathUtils.add(1,1), "should returns the right sum");
        }

        @Test
        @DisplayName("when adding two negative numbers")
        void addNegative() {
            assertEquals(-2, mathUtils.add(-3,1), "should returns the right sum");
        }
    }

    @RepeatedTest(3)
    @DisplayName("repeated test")
    void repeatedTest(RepetitionInfo repetitionInfo) {
        assertEquals(-2, mathUtils.add(-3,1), "should returns the right sum");
    }

}