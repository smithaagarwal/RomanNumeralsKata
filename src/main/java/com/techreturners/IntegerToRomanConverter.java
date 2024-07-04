package com.techreturners;

import java.util.Map;

public class IntegerToRomanConverter {


        public static int getIntegerValueOfLowerBaseRomanNumeral(int number) {
            int lowerBaseRomanNumeral = 1;
            for(Integer i: RomanNumerals.ROMAN_NUMERALS_MAP.keySet()) {
                if (i>number)
                    break;
                else
                    lowerBaseRomanNumeral = i;
            }
            return lowerBaseRomanNumeral;
        }

        public static int getIntegerValueOfNextBaseRomanNumeral(int lowerBase) {
            Map.Entry<Integer,String> nextEntry = RomanNumerals.ROMAN_NUMERALS_MAP.higherEntry(lowerBase);
            if(nextEntry!=null)
                return nextEntry.getKey();
            return lowerBase;
        }


    static String convertIntegerToRoman(int number) {
        if (number== 0)
            return "";
        if (number>0 && number<4)
            return RomanNumerals.ROMAN_NUMERALS_MAP.get(1) + convertIntegerToRoman(number-1);
        if (number>=4 & number<5)
            return RomanNumerals.ROMAN_NUMERALS_MAP.get(5-number) + convertIntegerToRoman(5);
        else
            return RomanNumerals.ROMAN_NUMERALS_MAP.get(number);


    }
}
