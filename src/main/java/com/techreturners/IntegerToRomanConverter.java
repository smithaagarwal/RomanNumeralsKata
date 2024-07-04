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


    static String convertIntegerToRoman(int number) {
        if (number == 0)
            return "";
        int fromRange = getIntegerValueOfLowerBaseRomanNumeral(number);
        int toRange = getIntegerValueOfNextBaseRomanNumeral(fromRange);
        int split = RomanNumerals.SPLIT_OF_RANGE.get(toRange);
        if (number == fromRange || number == toRange)
            return RomanNumerals.ROMAN_NUMERALS_MAP.get(number);
        if (number < split)
            return RomanNumerals.ROMAN_NUMERALS_MAP.get(fromRange) +
                    convertIntegerToRoman(number - fromRange);
        else
            return convertIntegerToRoman(toRange - split) +
                    RomanNumerals.ROMAN_NUMERALS_MAP.get(toRange) +
                    convertIntegerToRoman(number - split);
    }
}
