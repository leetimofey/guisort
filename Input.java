package com.company;

import java.util.Scanner;
import java.util.Random;


public class Input {


    public static String invalidInput = "Invalid input. Try again:";


    //input string
    public static String getStr() {
        Scanner read = new Scanner(System.in);
        return read.nextLine();
    }


    //по типу input('введите строку:')
    public static String getStr(String alert) {
        System.out.print(alert);
        return getStr();
    }


    //input int
    public static int getInt() {
        Scanner read = new Scanner(System.in);
        if (read.hasNextInt()) return read.nextInt();
        else return getInt(invalidInput);
    }


    //int(input('string'))
    public static int getInt(String alert) {
        System.out.println(alert);
        return getInt();
    }

    //boolean
    public static Boolean getBool() {
        int choice = getInt("0 for False, 1 for True");
        while ((choice != 0) && (choice != 1)) {
            choice = getInt(invalidInput);
        }
        return (choice == 1);
    }


    //bool (string)
    public static Boolean getBool(String alert) {
        System.out.println(alert);
        return getBool();
    }

    //positive int or wronginput
    public static int getPositiveInt(String alert) {
        int n = Input.getInt(alert);
        while (n < 1) {
            n = Input.getInt(Input.invalidInput);
        }
        return n;
    }
    public static Integer getRandomInt(Integer range) {
        Random rand = new Random();
        return rand.nextInt(range);
    }
}