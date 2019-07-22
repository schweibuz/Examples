package com.from4.junit;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

final class MathTest {
    private Math math;

    @BeforeEach
    public void setUp() {
        math = new Math();
        System.out.println("Create");
    }

    @AfterEach
    public void tearDown() {
        math = null;
        System.out.println("Tear down");
    }

    @Test
    void add_TwoPlusTwo_ReturnsFour() {

        final int expected = 4;

        final int actual = math.add(2, 2);

        Assert.assertEquals(actual, expected);
        Assert.assertTrue(Math.add(2,2) == expected);
        Assert.assertFalse(Math.add(3,2) == expected);
    }

    @Test
    void multiply_TwoMultiplyZero_ReturnZero() {
        final int expected = 0;

        final int actual = math.multiply(2, 0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void divide_ThirtyDividedBySix_ReturnsFive() {
        final int expected = 5;

        final int actual = (int) math.divide(30, 6);

        Assert.assertEquals(expected, actual);
    }


    @Test
    void divide_TenDivideByZero_ThrowsIllegalArgumentException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Math.divide(10, 0);
        });

    }
}