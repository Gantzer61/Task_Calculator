package com.m_zakharov.by;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // создаем объект для считывания ввода с консоли
        Scanner read = new Scanner(System.in);
        while (Boolean.TRUE) {
            System.out.print("Введите арифметическую операцию: ");
            String strOperation = read.nextLine();
            String res = Calculator.performCalc(strOperation);
            System.out.println("Результат операции: " + res);
        }
    }
}
