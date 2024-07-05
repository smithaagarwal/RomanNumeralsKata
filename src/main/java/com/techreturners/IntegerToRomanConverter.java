package com.techreturners;

import java.util.Map;

public class IntegerToRomanConverter {


    public static int getIntegerValueOfLowerBaseRomanNumeral(int number) {
        int lowerBaseRomanNumeral = 1;
        for (Integer i : RomanNumerals.ROMAN_NUMERALS_MAP.keySet()) {
            if (i > number)
                break;
            else
                lowerBaseRomanNumeral = i;
        }
        return lowerBaseRomanNumeral;
    }

    public static int getIntegerValueOfNextBaseRomanNumeral(int lowerBase) {
        Map.Entry<Integer, String> nextEntry = RomanNumerals.ROMAN_NUMERALS_MAP.higherEntry(lowerBase);
        if (nextEntry != null)
            return nextEntry.getKey();
        return lowerBase;
    }

    /**
     *  Converts numbers from 1-3000 to roman numerals
     *  if the number is equal to base roman numerals then return the base numeral from the mapping
     *  find the range the number falls into, eg is it between 1-5, 5-10,10-50,50-100,100-500,500-1000
     *  if the number is less than the split point then get the roman numeral for the fromRange and call this method for number - fromRange
     *  else call this method for torange - split - concatenate torange roman numeral - concatenate result got by calling the method number - split
     *  find the split point of the range deduced i.e 4,9,40,90,400,900 respectively for the above ranges
     *
     * @param number integer to convert
     * @return roman numeral for number passed
     */
    static String convertIntegerToRoman(int number) {
        if (number > 3000)
            throw new IllegalArgumentException("Cannot convert number greater than 3000 to roman numerals");
        if (number < 0)
            throw new IllegalArgumentException("Cannot convert number lesser than 0 to roman numerals");
        if (number == 0)
            return "";
        int fromRange = getIntegerValueOfLowerBaseRomanNumeral(number);
        int toRange = getIntegerValueOfNextBaseRomanNumeral(fromRange);
        int split = RomanNumerals.SPLIT_OF_RANGE.get(toRange);
        if (number == fromRange || number == toRange)
            return RomanNumerals.ROMAN_NUMERALS_MAP.get(number);
        //fromRange == toRange when the number is greater than 1000
        //Hence checking this condition to handle numbers greater than thousand
        if (number < split || fromRange == toRange)
            return RomanNumerals.ROMAN_NUMERALS_MAP.get(fromRange) +
                    convertIntegerToRoman(number - fromRange);
        else
            return convertIntegerToRoman(toRange - split) +
                    RomanNumerals.ROMAN_NUMERALS_MAP.get(toRange) +
                    convertIntegerToRoman(number - split);
    }
}
