// 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
// 的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
// 满足要求的三元组集合为：
// [
//  [-1, 0, 1],
//  [-1, -1, 2]
// ]
//
// Related Topics 数组 双指针
// 15. 三数之和

package com.leo.algorithm.middle.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
  public static void main(String[] args) {
    Printer.printDoubleList(
        new Solution().threeSum(DataBuilder.buildIntArray("-1, 0, 1, 2, -1, -4")));
    Printer.printDoubleList(new Solution().threeSum(DataBuilder.buildIntArray("0,0,0,0")));
  }

  static class Solution {
    /**
     * 执行用时： 32 ms , 在所有 Java 提交中击败了 24.55% 的用户
     *
     * <p>内存消耗： 44.2 MB , 在所有 Java 提交中击败了 96.86% 的用户
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
      if (nums == null || nums.length == 0) return result;
      Arrays.sort(nums);
      for (int i = 0; i < nums.length; i++) {
        result.addAll(twoSum(nums, i + 1, -nums[i]));
        // 跳过第三个数字重复的内容。
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
      }
      return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
      List<List<Integer>> result = new ArrayList<>();
      int l = start;
      int r = nums.length - 1;
      while (l < r) {
        int left = nums[l];
        int right = nums[r];
        int sum = left + right;
        if (sum < target) {
          while (l < r && nums[l] == left) l++;
        } else if (sum > target) {
          while (l < r && nums[r] == right) r--;
        } else {
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[l]);
          temp.add(nums[r]);
          temp.add(-target);
          result.add(temp);
          while (l < r && nums[l] == left) l++;
          while (l < r && nums[r] == right) r--;
        }
      }
      return result;
    }
  }
}
