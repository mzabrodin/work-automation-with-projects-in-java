package com.lab5.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@Tag("param")
@DisplayName("Parameterized tests for 'isPalindrome' method")
public class IsPalindromeTest extends DevEnvironment {

    @ParameterizedTest(name = "palindrome: \"{0}\"")
    @DisplayName("valid palindromes")
    @ValueSource(strings = {"racecar", "A man a plan a canal Panama", "12321", ""})
    public void testIsPalindrome(String str) {
      assertTrue(StringExtensions.isPalindrome(str));
    }

    @ParameterizedTest(name = "non-palindrome: \"{0}\"")
    @DisplayName("invalid palindromes")
    @ValueSource(strings = {"world", "hello", "junit"})
    public void testIsNotPalindrome(String str) {
        assertFalse(StringExtensions.isPalindrome(str));
    }
}