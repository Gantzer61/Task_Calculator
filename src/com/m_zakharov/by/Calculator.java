package com.m_zakharov.by;

import static com.m_zakharov.by.NumberRoman.*;

public class Calculator {

    private enum tNumber {
        Arab,
        Rom
    }

    // проверка строки на валидность (Арабские числа)
    private static boolean isValidArab(String val) {
        // шаблон сравнения строки
        // Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами
        // Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более
        // Калькулятор умеет работать только с целыми числами
        String reg = "\\d0?(\\+|\\-|\\/|\\*)\\d0?";
        return val.matches(reg);
    }

    // проверка строки на валидность (Римские числа)
    private static boolean isValidRom(String val) {
        // шаблон сравнения строки
        // теже условия только для римских чисел
        String reg = "(I{1,3}|IV|V|VI{1,3}|IX|X)(\\+|\\-|\\/|\\*)(I{1,3}|IV|V|VI{1,3}|IX|X)";
        return val.matches(reg);
    }

    // возвращает String т.к. результат может быть в арабских цифрах
    public static String performCalc(String val) {
        // из ничего получаем ничего
        if (val.length() == 0) {
            return val;
        }
        // уберем все пробелы
        val = val.replaceAll("\\s","");
        tNumber typeNumber = null;
        // проверяем валидность (Арабские числа)
        if (isValidArab(val)) {
            typeNumber = tNumber.Arab;
        }
        // проверяем на валидность (Римские числа)
        if (isValidRom(val)) {
            typeNumber = tNumber.Rom;
        }
        // если валидность не пройдена, то выходим
        if (typeNumber == null) {
            return "Не верный формат ввода данных!";
        }
        // определяем какую операцию выполняем
        Integer operPos = -1;
        // операция сложения
        String strNum1;
        String strNum2;
        long intResult = 0;
        operPos = val.indexOf('+');
        if (operPos > -1) {
            strNum1 = val.substring(0, operPos);
            strNum2 = val.substring(operPos+1,val.length());
            return sumCalc(strNum1, strNum2, typeNumber);
        }
        // операция вычетания
        operPos = val.indexOf('-');
        if (operPos > -1) {
            strNum1 = val.substring(0, operPos);
            strNum2 = val.substring(operPos+1,val.length());
            return  subCalc(strNum1, strNum2, typeNumber);
        }
        // операция умнажения
        operPos = val.indexOf('*');
        if (operPos > -1) {
            strNum1 = val.substring(0, operPos);
            strNum2 = val.substring(operPos+1,val.length());
            return  multiCalc(strNum1, strNum2, typeNumber);
        }
        // операция деления
        operPos = val.indexOf('/');
        if (operPos > -1) {
            strNum1 = val.substring(0, operPos);
            strNum2 = val.substring(operPos+1,val.length());
            return divCalc(strNum1, strNum2, typeNumber);
        }
        return val;
    }

    public static String divCalc(String strNum1, String strNum2) {
        return divCalc(strNum1, strNum2, tNumber.Arab);
    }

    // опаерация деления, умеет складывать арабские и римские числа
    public static String divCalc(String strNum1, String strNum2, tNumber tNumberRes) {
        // требуется определить что эта за числа
        Integer num1 = strNum1.matches("\\d+") ? Integer.parseInt(strNum1): toInteger(strNum1);
        Integer num2 = strNum2.matches("\\d+") ? Integer.parseInt(strNum2): toInteger(strNum2);
        if (tNumberRes == tNumber.Rom) {
            // округлим т.к. у нас могут быть римские цифры
            return (NumberRoman.toRoman((int) num1 / num2));
        }
        else
            return Double.toString(num1 / num2);
    }

    public static String multiCalc(String strNum1, String strNum2) {
        return multiCalc(strNum1, strNum2, tNumber.Arab);
    }

    // опаерация умножения, умеет складывать арабские и римские числа
    public static String multiCalc(String strNum1, String strNum2, tNumber tNumberRes) {
        // требуется определить что эта за числа
        Integer num1 = strNum1.matches("\\d+") ? Integer.parseInt(strNum1): toInteger(strNum1);
        Integer num2 = strNum2.matches("\\d+") ? Integer.parseInt(strNum2): toInteger(strNum2);
        if (tNumberRes == tNumber.Rom) {
            return (NumberRoman.toRoman(num1 * num2));
        }
        else
            return Integer.toString(num1 * num2);
    }

    public static String subCalc(String strNum1, String strNum2) {
        return subCalc(strNum1, strNum2, tNumber.Arab);
    }

    // опаерация вычетания, умеет складывать арабские и римские числа
    public static String subCalc(String strNum1, String strNum2, tNumber tNumberRes) {
        // требуется определить что эта за числа
        Integer num1 = strNum1.matches("\\d+") ? Integer.parseInt(strNum1): toInteger(strNum1);
        Integer num2 = strNum2.matches("\\d+") ? Integer.parseInt(strNum2): toInteger(strNum2);
        if (tNumberRes == tNumber.Rom) {
            return (NumberRoman.toRoman(num1 + num2));
        }
        else
            return Integer.toString(num1 + num2);
    }

    public static String sumCalc(String strNum1, String strNum2) {
        return sumCalc(strNum1, strNum2, tNumber.Arab);
    }

    // опаерация сложения, умеет складывать арабские и римские числа
    public static String sumCalc(String strNum1, String strNum2, tNumber tNumberRes) {
        // требуется определить что эта за числа
        Integer num1 = strNum1.matches("\\d+") ? Integer.parseInt(strNum1): toInteger(strNum1);
        Integer num2 = strNum2.matches("\\d+") ? Integer.parseInt(strNum2): toInteger(strNum2);
        if (tNumberRes == tNumber.Rom) {
            return (NumberRoman.toRoman( num1 + num2));
        }
        else
            return Integer.toString(num1 + num2);
    }

}
