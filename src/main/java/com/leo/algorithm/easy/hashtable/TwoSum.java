// 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
// 因为 nums[0] + nums[1] = 2 + 7 = 9
// 所以返回 [0, 1]
//
// Related Topics 数组 哈希表
// 1. 两数之和

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "0,1", new Solution().twoSum(DataBuilder.buildIntArray("2,7,11,15"), 9));
    Printer.printCorrectAnswer("1,2", new Solution().twoSum(DataBuilder.buildIntArray("3,2,4"), 6));
  }

  static class Solution {
    public int[] twoSum(int[] nums, int target) {
      // return method1(nums, target);
      return method2(nums, target);
    }

    private int[] method2(int[] nums, int target) {
      for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[i] + nums[j] == target) {
            return new int[] {i, j};
          }
        }
      }
      return new int[0];
    }

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了99.59%的用户
     *
     * <p>内存消耗：40.3 MB, 在所有 Java 提交中击败了5.06%的用户
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] method1(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      int[] result = new int[2];
      for (int i = 0; i < nums.length; i++) {
        int dif = target - nums[i];
        if (map.containsKey(dif)) {
          result[0] = map.get(dif);
          result[1] = i;
          return result;
        }
        map.put(nums[i], i);
      }
      return result;
    }
  }
}
