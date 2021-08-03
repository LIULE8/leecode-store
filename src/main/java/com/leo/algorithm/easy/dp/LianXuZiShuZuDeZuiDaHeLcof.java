// 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
//
// 要求时间复杂度为O(n)。
//
//
//
// 示例1:
//
// 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出: 6
// 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10^5
// -100 <= arr[i] <= 100
//
//
// 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
//
//
// Related Topics 数组 分治 动态规划
// 剑指 Offer 42. 连续子数组的最大和

package com.leo.algorithm.easy.dp;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class LianXuZiShuZuDeZuiDaHeLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
    Printer.printCorrectAnswer(6, solution.maxSubArray(DataBuilder.buildIntArray("-2,1,-3,4,-1,2,1,-5,4")));
    Printer.printCorrectAnswer(1, solution.maxSubArray(DataBuilder.buildIntArray("1")));
    Printer.printCorrectAnswer(3, solution.maxSubArray(DataBuilder.buildIntArray("1,2")));
    Printer.printCorrectAnswer(1, solution.maxSubArray(DataBuilder.buildIntArray("-2,1")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.38% 的用户
     *
     * <p>内存消耗： 44.8 MB , 在所有 Java 提交中击败了 76.07% 的用户
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
      if (nums == null) return 0;
      long maxSum = Long.MIN_VALUE;
      long sum = 0;
      for (int num : nums) {
        if (sum <= 0) {
          sum = num;
        } else {
          sum += num;
        }
        maxSum = Math.max(maxSum, sum);
      }
      return (int) maxSum;
    }
  }
}
