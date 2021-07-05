package com.xsy.notebook.notebook;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author shuyuan.xu
 * @date 2020-09-03.
 */
public class Test {

  public int[] twoSum(int[] nums, int target) {

    Map<Integer, Integer> numIndexMap = new LinkedHashMap<>();

    for (int i = 0; i < nums.length; i++) {
      if (numIndexMap.containsKey(nums[i])
          && nums[i] * 2 == target) {
        return new int[]{numIndexMap.get(nums[i]), i};
      } else {
        numIndexMap.put(nums[i], i);
      }
    }

    for (Integer num : numIndexMap.keySet()) {
      int value = target - num;
      if (numIndexMap.containsKey(value)
          && numIndexMap.get(value) != numIndexMap.get(num)) {
        return new int[]{numIndexMap.get(num), numIndexMap.get(value)};
      }
    }

    return null;
  }

  public static void main(String[] args) {
    Test test = new Test();
    int[] results = test.twoSum(new int[]{3, 2, 4}, 6);
    if (results != null) {
      for (int i : results) {
        System.out.println(i);
      }
    }
  }

}
