package com.company;

import static java.lang.Math.abs;

/**
 * @author Yulia
 */
public class JuliaSort {

    public static void main(String[] args) {
        Integer length = InputPrint.getInteger();
        int[] list = InputPrint.getList(length);
    }

    public static class Gnome implements SortingAlg {
        /**
         * Array sort
         * @param list int[] array
         * @return Sorted array
         */
        @Override
        public int[] sort(int[] list) {
            for (int i = 1; i < list.length; i++) {
                while ((i > 0) && (list[i] < list[i - 1])) {
                    swap(list, i, i - 1);
                    i = i - 1;
                }
            }
            return list;
        }
        @Override
        public String name(int[] list) {
            return "Yulia.GnomeSort";
        }
    }


    public static class Insertion implements SortingAlg {
        /**
         * Array sort
         * @param list int[] array
         * @return sorted array
         */
        @Override
        public int[] sort(int[] list) {
            for (int i = 0; i < list.length; i++) {
                Integer elem = list[i];
                int j = i;
                while (j > 0 && elem < list[j - 1]) {
                    list[j] = list[j - 1];
                    --j;
                }
                list[j] = elem;
            }
            return list;
        }
        @Override
        public String name(int[] list) {
            return "Yulia.InsertionSort";
        }
    }


    public static class Bubble implements SortingAlg {
        /**
         * Array sort
         * @param list int[] array
         * @return sorted array
         */
        @Override
        public int[] sort(int[] list) {
            for (int i = 0; i < list.length - 1; i++) {
                for (int j = 1; j < list.length - i; j++) {
                    if (list[j - 1] > list[j]) {
                        swap(list, j - 1, j);
                    }
                }
            }
            return list;
        }
        @Override
        public String name(int[] list) {
            return "Yulia.BubbleSort";
        }
    }

    public static class Selection implements SortingAlg {
        /**
         * Array sort
         *
         * @param list int[] array
         * @return sorted array
         */
        @Override
        public int[] sort(int[] list) {
            for (int i = 0; i < list.length - 1; i++) {
                Integer indexmin = i;
                for (int j = i + 1; j < list.length; j++) {
                    if (list[j] < list[indexmin]) {
                        indexmin = j;
                    }
                }
                swap(list, i, indexmin);
            }
            return list;
        }
        @Override
        public String name(int[] list) {
            return "Yulia.SelectionSort";
        }
    }

    public static class Comb implements SortingAlg {
        /**
         * Array sort
         *
         * @param list int[] array
         * @return sorted array
         */
        @Override
        public int[] sort(int[] list) {
            Integer gap = list.length;
            double factor = 1.247;
            while (gap > 1) {
                gap = (int) (gap / factor);
                for (int i = 0; i < list.length - gap; i++) {
                    if (list[i + gap] < list[i]) {
                        swap(list, i, i + gap);
                    }
                }
            }
            return list;
        }
        @Override
        public String name(int[] list) {
            return "Yulia.CombSort";
        }
    }

    public static class Stupid implements SortingAlg {
        /**
         * Array sort
         *
         * @param list int[] array
         * @return sorted array
         */
        @Override
        public int[] sort(int[] list) {
            while (!isSorted(list)) {
                mixArray(list);
            }
            return list;
        }
        @Override
        public String name(int[] list) { return "Yulia.StupidSort"; }
    }

    /**
     * Swap two elements in array
     * @param list int[] array
     * @param i index
     * @param j index
     */
    public static void swap(int[] list, Integer i, Integer j) {
        Integer k = list[i];
        list[i] = list[j];
        list[j] = k;
    }

    /**
     * Randomly mix array
     * @param list int[] array
     */
    public static void mixArray(int[] list) {
        for (int i = 0; i < list.length; i++) {
            swap(list, i, abs(InputPrint.getRandomInt((list.length))));
        }
    }

    /**
     * Check if array is sorted
     * @param list int[] array
     * @return is array sorted?
     */
    public static boolean isSorted(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] > list[i+1]) {
                return false;
            }
        }
        return true;
    }
}