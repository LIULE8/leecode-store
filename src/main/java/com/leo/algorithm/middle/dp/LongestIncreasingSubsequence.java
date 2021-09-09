// 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
// 列。
//
//
// 示例 1：
//
//
// 输入：nums = [10,9,2,5,3,7,101,18]
// 输出：4
// 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
//
//
// 示例 2：
//
//
// 输入：nums = [0,1,0,3,2,3]
// 输出：4
//
//
// 示例 3：
//
//
// 输入：nums = [7,7,7,7,7,7,7]
// 输出：1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2500
// -10⁴ <= nums[i] <= 10⁴
//
//
//
//
// 进阶：
//
//
// 你可以设计时间复杂度为 O(n²) 的解决方案吗？
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
//
// Related Topics 数组 二分查找 动态规划
// 300. 最长递增子序列

package com.leo.algorithm.middle.dp;

public class LongestIncreasingSubsequence {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 61 ms , 在所有 Java 提交中击败了 63.68% 的用户
     *
     * <p>内存消耗： 38.1 MB , 在所有 Java 提交中击败了 33.33% 的用户
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      int max = 1;
      for (int i = 0; i < nums.length; i++) {
        dp[i] = 1;
        for (int j = 0; j < i; j++) {
          if (nums[i] > nums[j]) dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
        max = Math.max(max, dp[i]);
      }
      return max;
    }
  }
}
