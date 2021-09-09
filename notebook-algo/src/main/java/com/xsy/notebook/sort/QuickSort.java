package com.xsy.notebook.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序（基于比较），时间复杂度O(nLogn)
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] array = {1, 2, 51, 0, 14, 7, 8, 3};
//        quickSort.quickSort(array);
        quickSort.quickSort2(array);
        System.out.println(Arrays.toString(array));
        System.out.println(Long.MAX_VALUE);
    }

    public void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort2(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSort2(array, 0, array.length - 1);
    }

    private void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        Random random = new Random();
        int strandIndex = startIndex + random.nextInt(endIndex - startIndex + 1);
        swap(array, strandIndex, endIndex);

        int i = startIndex;
        int j = endIndex - 1;
        while (i <= j) {
            if (array[i] <= array[endIndex]) {
                i++;
            } else {
                swap(array, i, j);
                j--;
            }
        }
        swap(array, i, endIndex);
        System.out.println(Arrays.toString(array));

        quickSort(array, startIndex, i - 1);
        quickSort(array, i + 1, endIndex);
    }

    public static void quickSort2(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int low = startIndex;
        int high = endIndex;
        int k = array[low]; // 选取最左边为基准
        while (low < high) {
            while (low < high && array[high] >= k) { //右侧找到第一个小于k的停止
                high--;
            }
            array[low] = array[high];

            while (low < high && array[low] <= k) { //在low往右找到第一个大于k的，放到右侧array[high]位置
                low++;
            }
            array[high] = array[low];
        }
        array[low] = k;

        quickSort2(array, startIndex, low - 1);
        quickSort2(array, low + 1, endIndex);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

}
