package com.techreturners;

import org.junit.jupiter.api.Test;

import static com.techreturners.IntegerToRomanConverter.*;
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
    public void shouldReturnCorrectRomanNumeralForNumberFour() {
        assertEquals("IV", convertIntegerToRoman(4));
    }

    @Test
    public void shouldReturnNothingForZero() {
        assertEquals("", convertIntegerToRoman(0));
    }

       @Test
    public void shouldReturnLowerBaseRomanNumeral() {
        assertEquals(1, getIntegerValueOfLowerBaseRomanNumeral(3));
        assertEquals(1, getIntegerValueOfLowerBaseRomanNumeral(4));
        assertEquals(5, getIntegerValueOfLowerBaseRomanNumeral(5));
        assertEquals(5, getIntegerValueOfLowerBaseRomanNumeral(8));
        assertEquals(10, getIntegerValueOfLowerBaseRomanNumeral(35));
    }

    @Test
    public void shouldReturnNextBaseRomanNumeral() {
        assertEquals(5, getIntegerValueOfNextBaseRomanNumeral(1));
        assertEquals(10, getIntegerValueOfNextBaseRomanNumeral(5));
        assertEquals(50, getIntegerValueOfNextBaseRomanNumeral(10));
        assertEquals(1000, getIntegerValueOfNextBaseRomanNumeral(500));
        assertEquals(1000, getIntegerValueOfNextBaseRomanNumeral(1000));
    }

    @Test
    public void shouldReturnCorrectRomanNumeralForNumbersLessThanTen() {
        assertEquals("IX", convertIntegerToRoman(9));
     //   assertEquals("VIII", convertIntegerToRoman(8));
       // assertEquals("VII", convertIntegerToRoman(7));
    }

    @Test
    public void shouldReturnCorrectRomanNumeralForNumbersLessThanThousandWithSimpleConversions() {
        assertEquals("DCCCL", convertIntegerToRoman(850));
        assertEquals("CCI", convertIntegerToRoman(201));
        assertEquals("CCCL", convertIntegerToRoman(350));
        assertEquals("DCCCLXXXV", convertIntegerToRoman(885));
    }

    @Test
    public void shouldReturnCorrectRomanNumeralForNumbersLessThanThousandWhereOrderOfConversionMatters() {
        assertEquals("CML", convertIntegerToRoman(950));
        assertEquals("XCV", convertIntegerToRoman(95));
        assertEquals("XCIX", convertIntegerToRoman(99));
        assertEquals("CMXCV", convertIntegerToRoman(995));
    }

    @Test
    public void shouldReturnCorrectRomanNumeralForNumbersGreaterThanThousand() {
        assertEquals("MDCCCL", convertIntegerToRoman(1850));
        assertEquals("MMCCI", convertIntegerToRoman(2201));
        assertEquals("MMCCCL", convertIntegerToRoman(2350));
    }

    @Test
    public void shouldThrowExceptionForNumbersGreaterThan3000() {
        var exception = assertThrows(IllegalArgumentException.class, () -> convertIntegerToRoman(3001));
        assertEquals("Cannot convert number greater than 3000 to roman numerals", exception.getMessage());
    }

    @Test
    public void shouldReturnExceptionForNegativeNumbers() {
        var exception = assertThrows(IllegalArgumentException.class, () -> convertIntegerToRoman(-11));
        assertEquals("Cannot convert number lesser than 0 to roman numerals", exception.getMessage());
    }

}