package com.techreturners;

import org.junit.jupiter.api.Test;

import static com.techreturners.IntegerToRomanConverter.convertIntegerToRoman;
import static org.junit.jupiter.api.Assertions.*;

class IntegerToRomanConverterTest {
    @Test
    public void shouldReturnIforInputIntegerOne() {
        assertEquals("I", convertIntegerToRoman(1));
    }

    @Test
    public void shouldReturnValidRomanForIntegersThatResultInSingleCharacterRomans() {
        assertEquals("V", convertIntegerToRoman(5));
        assertEquals("X", convertIntegerToRoman(10));
        assertEquals("L", convertIntegerToRoman(50));
        assertEquals("C", convertIntegerToRoman(100));
        assertEquals("D", convertIntegerToRoman(500));
        assertEquals("M", convertIntegerToRoman(1000));

    }

    @Test
    public void shouldReturnCorrectRomanNumeralForNumbersLessThanFour() {
        assertEquals("I", convertIntegerToRoman(1));
        assertEquals("II", convertIntegerToRoman(2));
        assertEquals("III", convertIntegerToRoman(3));
    }

    @Test
    public void shouldReturnNothingForZero() {
        assertEquals("", convertIntegerToRoman(0));
    }

}