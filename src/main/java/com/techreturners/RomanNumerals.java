package com.techreturners;

import java.util.TreeMap;

public class RomanNumerals {
    public static final TreeMap<Integer, String> ROMAN_NUMERALS_MAP;

    static {
        // Initialize the map with the integer-Roman numeral pairs
        ROMAN_NUMERALS_MAP = new TreeMap<>();
        ROMAN_NUMERALS_MAP.put(1, "I");
        ROMAN_NUMERALS_MAP.put(5, "V");
        ROMAN_NUMERALS_MAP.put(10, "X");
        ROMAN_NUMERALS_MAP.put(50, "L");
        ROMAN_NUMERALS_MAP.put(100, "C");
        ROMAN_NUMERALS_MAP.put(500, "D");
        ROMAN_NUMERALS_MAP.put(1000, "M");
    }

    private static final TreeMap<Integer, Integer> SPLIT_OF_RANGE = new TreeMap<>();
    static {
        SPLIT_OF_RANGE.put(5,4);
        SPLIT_OF_RANGE.put(10,4);
        SPLIT_OF_RANGE.put(50,4);
        SPLIT_OF_RANGE.put(100,4);
        SPLIT_OF_RANGE.put(500,400);
        SPLIT_OF_RANGE.put(1000,900);
    }
}
