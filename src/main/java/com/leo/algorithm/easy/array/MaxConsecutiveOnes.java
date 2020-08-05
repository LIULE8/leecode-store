// 给定一个二进制数组， 计算其中最大连续1的个数。
//
// 示例 1:
//
//
// 输入: [1,1,0,1,1,1]
// 输出: 3
// 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
//
//
// 注意：
//
//
// 输入的数组只包含 0 和1。
// 输入数组的长度是正整数，且不超过 10,000。
//
// Related Topics 数组
// 485. 最大连续1的个数

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;

public class MaxConsecutiveOnes {
  public static void main(String[] args) {
    System.out.println(
        new Solution().findMaxConsecutiveOnes(DataBuilder.buildIntArray("1,1,0,1,1,1")));
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 93.98% 的用户
     *
     * <p>内存消耗： 41.5 MB , 在所有 Java 提交中击败了 40.76% 的用户
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int max = 0;
      int count = 0;
      for (int num : nums) {
        if (num == 1) {
          count++;
        } else {
          max = Math.max(max, count);
          count = 0;
        }
      }
      return Math.max(max, count);
    }
  }
}
