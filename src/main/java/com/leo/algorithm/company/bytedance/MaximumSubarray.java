package com.leo.algorithm.company.bytedance;

import com.leo.algorithm.utils.DataBuilder;

/**
 * 53. 最大子序和
 *
 * <p>给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * <p>示例:
 *
 * <p>输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶:
 *
 * <p>如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 */
public class MaximumSubarray {
  public static void main(String[] args) {
        int[] ints = DataBuilder.buildIntArray("-2,1,-3,4,-1,2,1,-5,4");
//    int[] ints = DataBuilder.buildIntArray("1");
//        int[] ints = DataBuilder.buildIntArray("1,2");
//                int[] ints = DataBuilder.buildIntArray("-2,1");
    int i = new Solution().maxSubArray(ints);
    System.out.println(i);
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
