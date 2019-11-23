package com.m_zakharov.by;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumberRoman {

    public static int toInteger(String number) {
        if (number.length() == 0) return 0;
        if (number.startsWith("M")) return 1000 + toInteger(number.substring(1, number.length()));
        if (number.startsWith("CM")) return 900 + toInteger(number.substring(2, number.length()));
        if (number.startsWith("D")) return 500 + toInteger(number.substring(1, number.length()));
        if (number.startsWith("CD")) return 400 + toInteger(number.substring(2, number.length()));
        if (number.startsWith("C")) return 100 + toInteger(number.substring(1, number.length()));
        if (number.startsWith("XC")) return 90 + toInteger(number.substring(2, number.length()));
        if (number.startsWith("L")) return 50 + toInteger(number.substring(1, number.length()));
        if (number.startsWith("XL")) return 40 + toInteger(number.substring(2, number.length()));
        if (number.startsWith("X")) return 10 + toInteger(number.substring(1, number.length()));
        if (number.startsWith("IX")) return 9 + toInteger(number.substring(2, number.length()));
        if (number.startsWith("V")) return 5 + toInteger(number.substring(1, number.length()));
        if (number.startsWith("IV")) return 4 + toInteger(number.substring(2, number.length()));
        if (number.startsWith("I")) return 1 + toInteger(number.substring(1, number.length()));
        return 0;
    }

    public static String toRoman(int Int) {
        LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
        roman_numerals.put("M", 1000);
        roman_numerals.put("CM", 900);
        roman_numerals.put("D", 500);
        roman_numerals.put("CD", 400);
        roman_numerals.put("C", 100);
        roman_numerals.put("XC", 90);
        roman_numerals.put("L", 50);
        roman_numerals.put("XL", 40);
        roman_numerals.put("X", 10);
        roman_numerals.put("IX", 9);
        roman_numerals.put("V", 5);
        roman_numerals.put("IV", 4);
        roman_numerals.put("I", 1);
        String res = "";
        for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
            int matches = Int/entry.getValue();
            res += repeat(entry.getKey(), matches);
            Int = Int % entry.getValue();
        }
        return res;
    }
    public static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
