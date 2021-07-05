package com.xsy.notebook.demo.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        numGroup();

        int[] nums = {1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 7, 3, 5, 2};
        int[] movedNums = numMove(nums, 2);
        System.out.println(Arrays.toString(movedNums));
    }

    private static int[] numMove(int[] nums, int movedNum) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == movedNum) {
                System.arraycopy(nums, i + 1, nums, i, nums.length - i - 1);
                nums[nums.length - 1] = movedNum;
            }
        }
        return nums;
    }

    private static void numGroup() {
        ArrayList<Integer> intArr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Map<Boolean, List<Integer>> numMap = intArr.stream()
                .collect(Collectors.groupingBy(num -> num % 2 == 0 ? Boolean.TRUE : Boolean.FALSE));
        System.out.println(numMap);
    }

}
