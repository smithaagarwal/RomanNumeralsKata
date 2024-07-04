package com.techreturners;

import java.util.Map;
import java.util.TreeMap;

public class IntegerToRomanConverter {

    public enum RomanNumeral {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
        private  final int value;
        private static final TreeMap<Integer, String> map = new TreeMap<>();
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

        public static int getIntegerValueOfLowerBaseRomanNumeral(int number) {
            int lowerBaseRomanNumeral = 1;
            for(Integer i: map.keySet()) {
                if (i>number)
                    break;
                else
                    lowerBaseRomanNumeral = i;
            }
            return lowerBaseRomanNumeral;
        }

        public static int getIntegerValueOfNextBaseRomanNumeral(int lowerBase) {
            Map.Entry<Integer,String> nextEntry = map.higherEntry(lowerBase);
            if(nextEntry!=null)
                return nextEntry.getKey();
            return lowerBase;
        }
    }

    static String convertIntegerToRoman(int number) {
        if (number== 0)
            return "";
        if (number>0 && number<4)
            return RomanNumeral.getRomanNumeral(1) + convertIntegerToRoman(number-1);
        if (number>=4 & number<5)
            return RomanNumeral.getRomanNumeral(5-number) + convertIntegerToRoman(5);
        else
            return RomanNumeral.getRomanNumeral(number);

    }
}
