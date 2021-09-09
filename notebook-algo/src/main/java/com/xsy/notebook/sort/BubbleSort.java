package com.xsy.notebook.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {1, -2, 4, 12, 4, 5, 9, 0};
        System.out.println("final result:" + Arrays.toString(bubbleSort(nums)));
    }

    public static int[] bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
            System.out.println(Arrays.toString(nums));
        }
        return nums;
    }

}
