package com.techreturners;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRomanConverter {

    public enum RomanNumeral {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
        private  final int value;
        private static final Map<Integer, String> map = new HashMap<>();
        static {
            for(RomanNumeral numeral: RomanNumeral.values()) {
                map.put(numeral.value, String.valueOf(numeral));
            }
        }
        RomanNumeral(int value)  {
            this.value=value;
        }

        public static String getRomanNumeral(int number) {
             return map.get(number);
        }
    }

    static String convertIntegerToRoman(int number) {
        if (number>0 && number<4)
            return RomanNumeral.getRomanNumeral(1) + convertIntegerToRoman(number-1);
        return "";

    }
}
