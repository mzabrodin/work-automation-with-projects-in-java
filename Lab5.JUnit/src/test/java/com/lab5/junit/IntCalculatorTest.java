package com.lab5.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("simple")
@DisplayName("Simple Tests for IntCalculator methods")
public class IntCalculatorTest extends DevEnvironment {

    private final IntCalculator intCalculator = new IntCalculator();

    @Test()
    @DisplayName("5 + 3 = 8")
    public void testAdd() {
        int a = 5;
        int b = 3;

        int expected = 8;

        int actual = intCalculator.plus(a, b);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("5 - 3 = 2")
    public void testSubtract() {
        int a = 5;
        int b = 3;

        int expected = 2;

        int actual = intCalculator.minus(a, b);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("5 * 3 = 15")
    public void testMultiply() {
        int a = 5;
        int b = 3;

        int expected = 15;

        int actual = intCalculator.multiply(a, b);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("5 / 3 = 1")
    public void testDivide() {
        int a = 5;
        int b = 3;

        int expected = 1;

        int actual = intCalculator.divide(a, b);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("5 / 0 -> ArithmeticException")
    public void testDivideByZero() {
        int a = 5;
        int b = 0;

        String expected = "Divide by zero";

        String actual = assertThrows(ArithmeticException.class, () -> intCalculator.divide(a, b)).getMessage();

        assertEquals(expected, actual);
    }
}
