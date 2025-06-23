package com.lab5.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("param")
@DisplayName("Parameterized tests for 'capitalizeWords' method")
public class CapitalizeWordsTest extends DevEnvironment {
    @ParameterizedTest(name = "capitalize: \"{0}\" -> \"{1}\"")
    @CsvSource({
            "купи слона, Купи Слона",
            "all You need is Programming, All You Need Is Programming",
            "one-word test, One-Word Test",
            "Already Capitalized, Already Capitalized",
            "'', ''"
    })
    public void testCapitalizeWords(String input, String expected) {
        assertEquals(expected, StringExtensions.capitalizeWords(input));
    }
}
