// 给定一个整数数组，找出总和最大的连续数列，并返回总和。
//
// 示例：
//
// 输入： [-2,1,-3,4,-1,2,1,-5,4]
// 输出： 6
// 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶：
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划
// 面试题 16.17. 连续数列

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ContiguousSequenceLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        6, new Solution().maxSubArray(DataBuilder.buildIntArray("-2,1,-3,4,-1,2,1,-5,4")));
    Printer.printCorrectAnswer(
        8, new Solution().maxSubArray(DataBuilder.buildIntArray("-2,1,1,4,-1,2,1,-5,4")));
    Printer.printCorrectAnswer(1, new Solution().maxSubArray(DataBuilder.buildIntArray("1")));
    Printer.printCorrectAnswer(3, new Solution().maxSubArray(DataBuilder.buildIntArray("1,2")));
    Printer.printCorrectAnswer(1, new Solution().maxSubArray(DataBuilder.buildIntArray("-2,1")));
    Printer.printCorrectAnswer(-1, new Solution().maxSubArray(DataBuilder.buildIntArray("-1")));
    Printer.printCorrectAnswer(-2, new Solution().maxSubArray(DataBuilder.buildIntArray("-2")));
    Printer.printCorrectAnswer(-1, new Solution().maxSubArray(DataBuilder.buildIntArray("-2, -1")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 95.89% 的用户
     *
     * <p>内存消耗： 39.5 MB , 在所有 Java 提交中击败了 88.99% 的用户
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
      int sum = 0, max = Integer.MIN_VALUE;
      for (int num : nums) {
        if (sum <= 0) {
          sum = num;
        } else {
          sum += num;
        }
        max = Math.max(max, sum);
      }
      return max;
    }
  }
}
