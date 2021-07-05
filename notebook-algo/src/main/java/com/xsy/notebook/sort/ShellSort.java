package com.xsy.notebook.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] array = {1, 3, -4, 0, 12, 2, 4, 8, 9, 23, 13, 7, 98, -8};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array) {
        int d = array.length;
        int temp = 0;
        for ( ; d >= 1; d /= 2) {
            for (int i = d; i < array.length; i++) {
                temp = array[i];
                for (int j = i - d; j >= 0; j -= d) {
                    if (array[j] > temp) {
                        array[j + d] = array[j];
                        array[j] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

}
