package com.company;

import java.util.concurrent.ThreadLocalRandom;


public class ArrayTools {


    public static int random_int(int range) {
        range = Math.abs(range);
        int randomNum = ThreadLocalRandom.current().nextInt(-range, range + 1);
        return randomNum;
    }


    public static class fill {


        public static void random(int[] list, int range) {
            for (int i = 0; i < list.length; i++) {
                list[i] = random_int(range);
            }
        }


        public static void from_input(int[] list) {
            System.out.println("Вводите массив из "+ list.length +" чисел");

            for (int i = 0; i < list.length; i++)
                list[i] = Input.getInt("Введите "+ i +" элемент массива");
        }
    }


    public static void int_swap(int[] list, int ind1, int ind2) {
        int t = list[ind1];
        list[ind1] = list[ind2];
        list[ind2] = t;
    }


    public static void print(int[] list) {
        for (int i: list) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }


    public static void fillrandom(int[] list) {
        fill.random(list, 1000);
        //print(list);

    }
    public static int[] getRandomArray(Integer lenght, Integer range) {
        int[] list = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            list[i] = Input.getRandomInt(range);
        }
        return list;
    }
    public static void swap(int [] array, int a, int b){
        int c = array[a];
        array[a] = array[b];
        array[b] = c;
    }
}
