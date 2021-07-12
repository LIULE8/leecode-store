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

package com.leo.algorithm.plan.introduction.t01;

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

    public int searchInsert(int[] nums, int target) {
      if (nums == null || nums.length == 0) return -1;
      int l = 0;
      int r = nums.length - 1;
      while (l <= r) {
        int mid = l + ((r - l) >> 1);
        if (target <= nums[mid]) {
          if (mid == 0 || target > nums[mid - 1]) return mid;
          else r = mid - 1;
        } else l = mid + 1;
      }
      return l;
    }
  }
}
