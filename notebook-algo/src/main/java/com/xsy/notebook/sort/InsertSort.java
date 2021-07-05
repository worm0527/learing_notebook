package com.xsy.notebook.sort;

import java.util.Arrays;

/**
 * 插入排序，时间复杂度O(n^2)
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] array = {0, 2, -1, 12, 7, 23, 11, -5};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) { // i之后的为无序
            System.out.println(Arrays.toString(array));
            int temp = array[i];
            for (int j = i - 1; j >= 0; j--) { // j及其之前数值有序，从后向前进行比较
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                    array[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

}
