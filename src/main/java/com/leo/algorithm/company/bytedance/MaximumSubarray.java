package com.leo.algorithm.company.bytedance;

import com.leo.algorithm.easy.dp.LianXuZiShuZuDeZuiDaHeLcof;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

// 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//
//
// 示例 1：
//
//
// 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出：6
// 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
// 输入：nums = [1]
// 输出：1
//
//
// 示例 3：
//
//
// 输入：nums = [0]
// 输出：0
//
//
// 示例 4：
//
//
// 输入：nums = [-1]
// 输出：-1
//
//
// 示例 5：
//
//
// 输入：nums = [-100000]
// 输出：-100000
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// -105 <= nums[i] <= 105
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治 动态规划
// 53. 最大子序和

public class MaximumSubarray {
  public static void main(String[] args) {
    Solution solution = new Solution();
    Printer.printCorrectAnswer(6, solution.maxSubArray(DataBuilder.buildIntArray("-2,1,-3,4,-1,2,1,-5,4")));
    Printer.printCorrectAnswer(1, solution.maxSubArray(DataBuilder.buildIntArray("1")));
    Printer.printCorrectAnswer(3, solution.maxSubArray(DataBuilder.buildIntArray("1,2")));
    Printer.printCorrectAnswer(1, solution.maxSubArray(DataBuilder.buildIntArray("-2,1")));
  }

  static class Solution {
    public int maxSubArray(int[] nums) {
      //      return method1(nums);
      //      return method2(nums);
      //      return method3(nums);
      //      return method4(nums);
      return method5(nums);
    }

    private int method5(int[] nums) {
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

    /**
     * 动态规划：
     *
     * <p>实际上只需要使用到 dp[i-1]的空间，所有可以减少空间复杂度
     *
     * @param nums
     * @return
     */
    private int method4(int[] nums) {
      if (nums == null) return 0;
      int dp = nums[0];
      long maxSum = dp;
      for (int i = 1; i < nums.length; i++) {
        dp = Math.max(nums[i], dp + nums[i]);
        maxSum = Math.max(maxSum, dp);
      }
      return (int) maxSum;
    }

    /**
     * 执行用时 : 2 ms , 在所有 java 提交中击败了 30.73% 的用户
     *
     * <p>内存消耗 : 37.7 MB , 在所有 java 提交中击败了 89.05% 的用户
     *
     * <p>动态规划
     *
     * <p>使用 dp[i] 存储， 已下标i结束的子序列的最大和
     *
     * <p>空间复杂度为O(n)
     *
     * <p>时间复杂度为O(n)
     *
     * @param nums
     * @return
     */
    private int method3(int[] nums) {
      if (nums == null) return 0;
      int[] dp = new int[nums.length];
      dp[0] = nums[0];
      long maxSum = dp[0];
      for (int i = 1; i < nums.length; i++) {
        dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        maxSum = Math.max(maxSum, dp[i]);
      }
      return (int) maxSum;
    }

    /**
     * 执行用时 : 66 ms , 在所有 java 提交中击败了 7.61% 的用户
     *
     * <p>内存消耗 : 40.9 MB , 在所有 java 提交中击败了 63.92% 的用户
     *
     * @param nums
     * @return 更慢了
     */
    private int method2(int[] nums) {
      if (nums == null) {
        return 0;
      }
      int[] sums = new int[nums.length];
      sums[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        sums[i] = sums[i - 1] + nums[i];
      }
      int max = sums[0];
      for (int i = 0; i < sums.length; i++) {
        if (max < sums[i]) {
          max = sums[i];
        }
        for (int j = 0; j < i; j++) {
          int sub = sums[i] - sums[j];
          if (sub > max) {
            max = sub;
          }
        }
      }
      return max;
    }

    /**
     * O(n^2)
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      if (nums == null) {
        return 0;
      }
      int max = nums[0];
      for (int i = 0; i < nums.length; i++) {
        int sum = 0;
        for (int j = i; j < nums.length; j++) {
          sum += nums[j];
          if (sum > max) {
            max = sum;
          }
        }
      }
      return max;
    }
  }
}
