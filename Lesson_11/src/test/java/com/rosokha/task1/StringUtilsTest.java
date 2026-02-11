package com.rosokha.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringUtilsTest {
    private StringUtils stringUtils = null;

    @BeforeEach
    void setUp(){
        stringUtils = new StringUtils();
    }

    @Test
    void shouldReturnTrueForPalindrome(){
        assertTrue(stringUtils.isPalindrome("qwerewq"));
    }

    @Test
    void shouldReturnFalseForPalindrome(){
        assertFalse(stringUtils.isPalindrome("Hello"));
    }

    @Test
    void shouldReverseMAXOnXAM(){
        assertEquals("XAM", stringUtils.reverse("MAX"));
    }

    @Test
    void shouldReturnNullForReversingNull(){
        assertEquals(null, stringUtils.reverse(null));
    }
}
