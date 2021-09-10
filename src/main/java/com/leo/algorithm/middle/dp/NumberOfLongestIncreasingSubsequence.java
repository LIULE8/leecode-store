// 给定一个未排序的整数数组，找到最长递增子序列的个数。
//
// 示例 1:
//
//
// 输入: [1,3,5,4,7]
// 输出: 2
// 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
//
//
// 示例 2:
//
//
// 输入: [2,2,2,2,2]
// 输出: 5
// 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
//
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
// Related Topics 树状数组 线段树 数组 动态规划
// 673. 最长递增子序列的个数

package com.leo.algorithm.middle.dp;

import com.leo.algorithm.utils.DataBuilder;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
  public static void main(String[] args) {
    new Solution().findNumberOfLIS(DataBuilder.buildIntArray("1,3,5,4,7"));
    new Solution().findNumberOfLIS(DataBuilder.buildIntArray("2,2,2,2,2"));
    new Solution().findNumberOfLIS(DataBuilder.buildIntArray("1,2,4,3,5,4,7,2"));
  }

  static class Solution {
    /**
     * 执行用时： 21 ms , 在所有 Java 提交中击败了 58.98% 的用户
     *
     * <p>内存消耗： 38 MB , 在所有 Java 提交中击败了 64.16% 的用户
     *
     * @param nums
     * @return
     */
    public int findNumberOfLIS(int[] nums) {
      int[] dp = new int[nums.length];
      int[] count = new int[nums.length];
      Arrays.fill(dp, 1); // 到 nums[i]为止的子序列最大长度
      Arrays.fill(count, 1); // 在 nums 中，（到 nums[i]为止的子序列最大长度）的个数
      int max = dp[0];
      for (int i = 1; i < nums.length; i++) {
        for (int j = 0; j < i; j++) {
          if (nums[i] > nums[j]) { // 满足递增序列
            if (dp[i] < dp[j] + 1) { // 子序列长度增加了
              dp[i] = dp[j] + 1;
              count[i] = count[j]; // 但是个数没增加，所以还是 （到 nums[j] 为止的自序列最大长度）的个数
            } else if (dp[i] == dp[j] + 1) { // 自序列长度没增加，证明多了一个序列数量
              count[i] += count[j]; // 所以 （到 nums[i] 为止的自序列最大长度）个数 需要加上（到 nums[j] 为止的自序列最大长度）的个数
            }
          }
        }
        max = Math.max(max, dp[i]);
      }

      // 查找子序列最大长度，对应的序列个数
      int res = 0;
      for (int i = 0; i < dp.length; i++) {
        if (max == dp[i]) {
          res += count[i];
        }
      }
      return res;
    }
  }
}
