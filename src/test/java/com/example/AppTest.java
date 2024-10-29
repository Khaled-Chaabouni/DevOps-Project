package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(15, calculator.add(5, 10), "Addition test failed");
    }

    @Test
    public void testSubtraction() {
        assertEquals(5, calculator.subtract(10, 5), "Subtraction test failed");
    }

    @Test
    public void testMultiplication() {
        assertEquals(12, calculator.multiply(4, 3), "Multiplication test failed");
    }

    @Test
    public void testDivision() {
        assertEquals(5, calculator.divide(10, 2), "Division test failed");
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}

