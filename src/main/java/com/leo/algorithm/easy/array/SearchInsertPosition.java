// 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
// 输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
// 输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
// 输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
// 输出: 0
//
// Related Topics 数组 二分查找
// 35. 搜索插入位置

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class SearchInsertPosition {
  public static void main(String[] args) {
    int[] nums = DataBuilder.buildIntArray("1,3,5,6");
    Printer.printCorrectAnswer("2", new Solution().searchInsert(nums, 5));
    Printer.printCorrectAnswer("1", new Solution().searchInsert(nums, 2));
    Printer.printCorrectAnswer("4", new Solution().searchInsert(nums, 7));
    Printer.printCorrectAnswer("0", new Solution().searchInsert(nums, 0));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.5 MB , 在所有 Java 提交中击败了 5.55% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
      if (nums == null || nums.length == 0) return -1;
      int start = 0;
      int end = nums.length - 1;
      while (start <= end) {
        int mid = (start + end) >> 1;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) start = mid + 1;
        else end = mid - 1;
      }
      return start;
    }
  }
}
