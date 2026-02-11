package com.rosokha.task2;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator = null;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void shouldAddPositiveNumbers() {
        assertEquals(9, calculator.add(3, 6));
    }

    @Test
    void shouldAddNegativeNumbers() {
        assertEquals(-19, calculator.add(-13, -6));
    }

    @Test
    void shouldDividePositiveNumbers() {
        assertEquals(4.5, calculator.divide(9, 2));
    }

    @Test
    void shouldDivideNegativeNumbers() {
        assertEquals(5.5, calculator.divide(-11, -2));
    }

    @Test
    void shouldDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(1, 0);
        });
    }

    @Test
    void number4ShouldBeEvenAndReturnTrue(){
        assertTrue(calculator.isEven(0));
    }
}
