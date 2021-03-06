// 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出
// 这个数字。
//
//
//
// 示例 1:
//
// 输入: [0,1,3]
// 输出: 2
//
//
// 示例 2:
//
// 输入: [0,1,2,3,4,5,6,7,9]
// 输出: 8
//
//
//
// 限制：
//
// 1 <= 数组长度 <= 10000
// Related Topics 数组 二分查找
// 剑指 Offer 53 - II. 0～n-1中缺失的数字

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class QueShiDeShuZiLcof {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        8, new Solution().missingNumber(DataBuilder.buildIntArray("0,1,2,3,4,5,6,7,9")));
    Printer.printCorrectAnswer(2, new Solution().missingNumber(DataBuilder.buildIntArray("0,1,3")));
    Printer.printCorrectAnswer(0, new Solution().missingNumber(DataBuilder.buildIntArray("1")));
    Printer.printCorrectAnswer(0, new Solution().missingNumber(DataBuilder.buildIntArray("1,2")));
    Printer.printCorrectAnswer(1, new Solution().missingNumber(DataBuilder.buildIntArray("0")));
    Printer.printCorrectAnswer(2, new Solution().missingNumber(DataBuilder.buildIntArray("0,1")));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 40.6 MB , 在所有 Java 提交中击败了 17.14% 的用户
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.1 MB , 在所有 Java 提交中击败了 12.55% 的用户
     *
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
      int l = 0, r = nums.length - 1;
      while (l <= r) {
        int mid = l + ((r - l) >> 1);
        if (nums[mid] <= mid) l = mid + 1;
        else r = mid - 1;
      }
      return l;
    }

    private int method1(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i) return i;
      }
      return nums.length;
    }
  }
}
