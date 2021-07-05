package com.xsy.notebook.stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个正整数数组和 k，要求依次取出 k 个数，输出其中数组的一个子序列，需要满足：1. 长度为 k；2.字典序最小。
 *
 * 输入：nums = [3,5,2,6], k = 2
 * 输出：[2,6]
 *
 * 解释：在所有可能的解：{[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 字典序最小。
 */
public class MinDict {

    public static void main(String[] args) {
        int[] nums = {9, 2, 4, 5, 1, 2, 3, 0};
        System.out.println(Arrays.toString(minDict(nums, 3)));
    }

    public static int[] minDict(int[] nums, int count) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int leftCount = nums.length - i;
            while (!stack.isEmpty()
                    && ((stack.size() + leftCount) > count)
                    && stack.peek() > nums[i]) {
                stack.pop();
            }
            stack.push(nums[i]);
        }

        while (stack.size() > count) {
            stack.pop();
        }

        int[] results = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            results[i] = stack.pop();
        }

        return results;
    }

}
