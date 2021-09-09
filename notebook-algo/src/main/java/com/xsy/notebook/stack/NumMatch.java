package com.xsy.notebook.stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 单调栈需要一直保持单调性，单调递增栈（小数消除大数）、单调递减栈（大数消除小数）
 * https://s0.lgstatic.com/i/image6/M01/0B/7F/Cgp9HWA4qrWAR4cuAADTLTA3i8c099.png
 */
public class NumMatch {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 0, 8, 1, 7};
        System.out.println(Arrays.toString(matchRightSmaller(nums)));
        System.out.println(Arrays.toString(matchRightBigger(nums)));
        System.out.println(Arrays.toString(matchLeftSmaller(nums)));
        System.out.println(Arrays.toString(matchLeftBigger(nums)));
    }

    // 单调递增栈，小的数消除大的数字
    public static int[] matchRightSmaller(int[] nums) {

        int[] results= new int[nums.length];
        LinkedList<Integer> idxStack = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!idxStack.isEmpty()
                    && nums[idxStack.peek()] > nums[i]) {
                results[idxStack.pop()] = i;
            }
            idxStack.push(i);
        }

        while (!idxStack.isEmpty()) {
            results[idxStack.pop()] = -1;
        }

        return results;
    }

    // 单调递减栈，大的数消除小的数字
    // 数组中右边第一个比我大的元素的位置
    public static int[] matchRightBigger(int[] nums) {

        int[] results= new int[nums.length];
        LinkedList<Integer> idxStack = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (!idxStack.isEmpty()
                    && nums[idxStack.peek()] < nums[i]) {
                results[idxStack.pop()] = i;
            }
            idxStack.push(i);
        }

        while (!idxStack.isEmpty()) {
            results[idxStack.pop()] = -1;
        }

        return results;
    }

    // 单调递增栈，小的数消除大的数字
    // 判断左边第一个比自己小的数的下标
    public static int[] matchLeftSmaller(int[] nums) {

        int[] results= new int[nums.length];
        LinkedList<Integer> idxStack = new LinkedList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!idxStack.isEmpty()
                    && nums[idxStack.peek()] > nums[i]) {
                results[idxStack.pop()] = i;
            }
            idxStack.push(i);
        }

        while (!idxStack.isEmpty()) {
            results[idxStack.pop()] = -1;
        }

        return results;
    }

    // 单调递减栈，大的数消除小的数字
    // 判断左边第一个比自己大的数的下标
    public static int[] matchLeftBigger(int[] nums) {

        int[] results= new int[nums.length];
        LinkedList<Integer> idxStack = new LinkedList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!idxStack.isEmpty()
                    && nums[idxStack.peek()] < nums[i]) {
                results[idxStack.pop()] = i;
            }
            idxStack.push(i);
        }

        while (!idxStack.isEmpty()) {
            results[idxStack.pop()] = -1;
        }

        return results;
    }

}
