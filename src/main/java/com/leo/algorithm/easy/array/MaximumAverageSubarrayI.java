// 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
//
// 示例 1:
//
// 输入: [1,12,-5,-6,50,3], k = 4
// 输出: 12.75
// 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
//
//
//
//
// 注意:
//
//
// 1 <= k <= n <= 30,000。
// 所给数据范围 [-10,000，10,000]。
//
// Related Topics 数组
// 643. 子数组最大平均数 I

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MaximumAverageSubarrayI {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        12.75, new Solution().findMaxAverage(DataBuilder.buildIntArray("1,12,-5,-6,50,3"), 4));
    Printer.printCorrectAnswer(
        4.0, new Solution().findMaxAverage(DataBuilder.buildIntArray("0,4,0,3,2"), 1));
  }

  static class Solution {
    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 43.68% 的用户
     *
     * <p>内存消耗： 43.7 MB , 在所有 Java 提交中击败了 30.97% 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
      if (nums == null || nums.length == 0 || k < 1 || k > nums.length) return 0;
      double lastSum = 0;
      for (int i = 0; i < k; i++) {
        lastSum += nums[i];
      }
      double maxSum = lastSum;
      for (int i = k; i < nums.length; i++) {
        double sum = lastSum - nums[i - k] + nums[i];
        maxSum = Math.max(sum, maxSum);
        lastSum = sum;
      }
      return maxSum / k;
    }
  }
}
