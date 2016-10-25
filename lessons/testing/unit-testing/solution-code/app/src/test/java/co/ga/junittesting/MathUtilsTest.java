package co.ga.junittesting;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * James Davis (General Assembly NYC)
 * Created on 4/28/16.
 */
public class MathUtilsTest {

    // MathUtils.multiply(number1, number2, number3, etc.) correctly multiplies the numbers you provide it
    // Test for both integer and decimal point numbers

    @Test
    public void testMultiply() throws Exception {
        int expectedInt, actualInt;
        double expectedDouble, actualDouble;

        expectedInt = 60;
        actualInt = MathUtils.multiply(1, 30, 2);

        assertEquals("multiply() | Multiplying ints did not work as expected.", expectedInt, actualInt);

        expectedInt = 75;
        actualInt = MathUtils.multiply(15, 5);

        assertEquals("multiply() | Multiplying ints did not work as expected.", expectedInt, actualInt);

        expectedInt = 9;
        actualInt = MathUtils.multiply(9);

        assertEquals("multiply() | Multiplying ints did not work as expected.", expectedInt, actualInt);

        expectedDouble = 752.4;
        actualDouble = roundDoubleToNearestHundredth(MathUtils.multiply(34.2, 22));

        assertEquals("multiply() | Multiplying doubles did not work as expected.", expectedDouble, actualDouble);

        expectedDouble = 4.8;
        actualDouble = MathUtils.multiply(2, 2.4);

        assertEquals("multiply() | Multiplying doubles did not work as expected.", expectedDouble, actualDouble);

        expectedDouble = 2244.0;
        actualDouble = MathUtils.multiply(2, 5.5, 12, 17);

        assertEquals("multiply() | Multiplying doubles did not work as expected.", expectedDouble, actualDouble);


    }


    // MathUtils.add(number1, number2, number3, etc.) correctly adds the numbers you provide it.
    // Test for both integer and decimal point numbers

    @Test
    public void testAddition() throws Exception {
        int expectedInt, actualInt;
        double expectedDouble, actualDouble;

        expectedInt = 33;
        actualInt = MathUtils.add(11, 21, 0, 1);

        assertEquals("add() | Adding ints did not work as expected.", expectedInt, actualInt);

        expectedInt = 3;
        actualInt = MathUtils.add(1, 2);

        assertEquals("add() | Adding ints did not work as expected.", expectedInt, actualInt);

        expectedInt = 95;
        actualInt = MathUtils.add(35, 35, 10, 5, 7, 3);

        assertEquals("add() | Adding ints did not work as expected.", expectedInt, actualInt);

        expectedDouble = 90.7;
        actualDouble = roundDoubleToNearestHundredth(MathUtils.add(35.2, 35, 10.3, 5.1, 5.1));

        assertEquals("add() | Adding doubles did not work as expected.", expectedDouble, actualDouble);

        expectedDouble = 12.5;
        actualDouble = MathUtils.add(12.5);

        assertEquals("add() | Adding doubles did not work as expected.", expectedDouble, actualDouble);

        expectedDouble = 99.9;
        actualDouble = MathUtils.add(90.5, 5.2, 4, 0.2);

        assertEquals("add() | Adding doubles did not work as expected.", expectedDouble, actualDouble);
    }


    // MathUtils.square(number) correctly squares the numbers you provide it.
    // Test for both integer and decimal point numbers
    @Test
    public void testSquare() throws Exception {
        int expectedInt, actualInt;
        double expectedDouble, actualDouble;

        expectedInt = 25;
        actualInt = MathUtils.square(5);
        assertEquals("square() | Squaring ints did not work as expected.", expectedInt, actualInt);

        expectedInt = 0;
        actualInt = MathUtils.square(0);
        assertEquals("square() | Squaring ints did not work as expected.", expectedInt, actualInt);

        expectedDouble = 1697.44;
        actualDouble = roundDoubleToNearestHundredth(MathUtils.square(41.2));
        assertEquals("square() | Squaring doubles did not work as expected.", expectedDouble, actualDouble);

        expectedDouble = 10.24;
        actualDouble = roundDoubleToNearestHundredth(MathUtils.square(3.2));
        assertEquals("square() | Squaring doubles did not work as expected.", expectedDouble, actualDouble);

    }


    // MathUtils.square(a, b) correctly calculates the results of using a and b in Pythagorean theorem.
    // Test for both integer and decimal point numbers
    @Test
    public void testPythagorean() throws Exception {
        int expectedInt, actualInt;
        double expectedDouble, actualDouble;

        expectedInt = 5;
        actualInt = MathUtils.pythagorean(3, 4);
        assertEquals("pythagorean() | Pythagoring ints did not work as expected", expectedInt, actualInt);

        expectedInt = 41;
        actualInt = MathUtils.pythagorean(9, 40);
        assertEquals("pythagorean() | Pythagoring ints did not work as expected", expectedInt, actualInt);

        expectedDouble = 5.96;
        actualDouble = roundDoubleToNearestHundredth(MathUtils.pythagorean(2.3, 5.5));
        assertEquals("pythagorean() | Pythagoring doubles did not work as expected", expectedDouble, actualDouble);

    }

    public double roundDoubleToNearestHundredth(double num) {
        return Math.round(num * 100d) / 100d;
    }
}
