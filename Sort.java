package com.company;

import java.lang.reflect.Array;

import static java.lang.Math.abs;

/*
@author Lee
 */


public class Sort {

    public static class bubblesort implements SortingAlg {

        @Override
        public int[] sort(int[] list) {
            for (int i = 0; i < list.length - 1; i++) {
                for (int j = 1; j < list.length - i; j++) {
                    if (list[j - 1] > list[j]) {
                        ArrayTools.swap(list, j - 1, j);
                    }
                }
            }
            return list;
        }
        @Override
        public String name(int[] list) {
            return "Lee.BubbleSort";
        }
    }


    public static class monkeysort implements SortingAlg {

        private static void mix (int[] list) {
            for (int i = 0; i < list.length; i++) {
                ArrayTools.int_swap(list, i, abs(ArrayTools.random_int(list.length - 1)));
            }
        }

        private static boolean sorted(int[] list) {
            for (int i = 1; i < list.length; i++) {
                if (list[i-1] > list[i])
                    return false;
            }
            return true;
        }

        @Override
        public int[] sort(int[] list) {
            while (!sorted(list))
                mix(list);
            ArrayTools.print(list);
            return list;
        }
        @Override
        public String name(int[] list) {
            return "Lee.MonkeySort";
        }

    }


    public static class selectionsort implements SortingAlg {

        @Override
        public int[] sort(int[] list) {
            for (int i = 0; i < list.length - 1; i++) {
                Integer indexmin = i;
                for (int j = i + 1; j < list.length; j++) {
                    if (list[j] < list[indexmin]) {
                        indexmin = j;
                    }
                }
                ArrayTools.swap(list, i, indexmin);
            }
            return list;
        }
        @Override
        public String name(int[] list) {
            return "Lee.SelectionSort";
        }
    }

    public static class cocktailsort implements SortingAlg{

        @Override
        public int[] sort(int[] list){
            int left = 0;
            int right = list.length - 1;

            while (left <= right){
                for (int i = left+1; i < right; i++){
                    if (list[i-1] > list[i]){
                        int tmp = list[i];
                        list[i] = list[i-1];
                        list[i-1] = tmp;
                    }
                }
                right --;
                for (int i = right; i > left; i--){
                    if (list[i] < list[i-1]){
                        int tmp = list[i-1];
                        list[i-1] = list[i];
                        list[i] = tmp;
                    }
                }
                left ++;
            }
            return list;
        }
        @Override
        public String name(int[] list) {
            return "Lee.Cocktailsort  ";
        }
    }

    public static class combsort implements SortingAlg {

        @Override
        public int[] sort(int[] list) {
            Integer gap = list.length;
            double factor = 1.247;
            while (gap > 1) {
                gap = (int) (gap / factor);
                for (int i = 0; i < list.length - gap; i++) {
                    if (list[i + gap] < list[i]) {
                        ArrayTools.swap(list, i, i + gap);
                    }
                }
            }
            return list;
        }
        @Override
        public String name(int[] list) {
            return "Lee.CombSort";
        }
    }
}