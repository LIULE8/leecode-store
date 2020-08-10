// 给定一个未经排序的整数数组，找到最长且连续的的递增序列，并返回该序列的长度。
//
//
//
// 示例 1:
//
// 输入: [1,3,5,4,7]
// 输出: 3
// 解释: 最长连续递增序列是 [1,3,5], 长度为3。
// 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
//
//
// 示例 2:
//
// 输入: [2,2,2,2,2]
// 输出: 1
// 解释: 最长连续递增序列是 [2], 长度为1。
//
//
//
//
// 注意：数组长度不会超过10000。
// Related Topics 数组
// 674. 最长连续递增序列

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class LongestContinuousIncreasingSubsequence {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        3, new Solution().findLengthOfLCIS(DataBuilder.buildIntArray("1,3,5,4,7")));
    Printer.printCorrectAnswer(
        2, new Solution().findLengthOfLCIS(DataBuilder.buildIntArray("3,2,2,2,3")));
    Printer.printCorrectAnswer(
        1, new Solution().findLengthOfLCIS(DataBuilder.buildIntArray("2,2,2,2,2")));
    Printer.printCorrectAnswer(
        2, new Solution().findLengthOfLCIS(DataBuilder.buildIntArray("1,2,2,3,3")));
    Printer.printCorrectAnswer(
        3, new Solution().findLengthOfLCIS(DataBuilder.buildIntArray("1,3,5,5,7")));
    Printer.printCorrectAnswer(1, new Solution().findLengthOfLCIS(DataBuilder.buildIntArray("1")));
  }

  static class Solution {

    public int findLengthOfLCIS(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.80% 的用户
     *
     * <p>内存消耗： 40.1 MB , 在所有 Java 提交中击败了 97.44% 的用户
     *
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
      if (nums.length <= 1) return nums.length;
      int index = 0, max = 0, i = 0;
      for (; i < nums.length; i++) {
        if (i > 0 && nums[i - 1] < nums[i]) continue;
        max = Math.max(max, i - index);
        index = i;
      }
      return Math.max(max, i - index);
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 48.00% 的用户
     *
     * <p>内存消耗： 40.2 MB , 在所有 Java 提交中击败了 94.73% 的用户
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      if (nums.length <= 1) return nums.length;
      int count = 1, max = 1;
      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i + 1] > nums[i]) count++;
        else count = 1;
        max = Math.max(max, count);
      }
      return max;
    }
  }
}
