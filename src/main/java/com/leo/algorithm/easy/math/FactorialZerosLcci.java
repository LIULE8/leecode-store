// 设计一个算法，算出 n 阶乘有多少个尾随零。
//
// 示例 1:
//
// 输入: 3
// 输出: 0
// 解释: 3! = 6, 尾数中没有零。
//
// 示例 2:
//
// 输入: 5
// 输出: 1
// 解释: 5! = 120, 尾数中有 1 个零.
//
// 说明: 你算法的时间复杂度应为 O(log n) 。
// Related Topics 数学
// 面试题 16.05. 阶乘尾数

package com.leo.algorithm.easy.math;

import com.leo.algorithm.utils.Printer;

public class FactorialZerosLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(452137076, new Solution().trailingZeroes(1808548329));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 94.74% 的用户
     *
     * <p>内存消耗： 35.5 MB , 在所有 Java 提交中击败了 21.23% 的用户
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
      int count = 0;
      while (n >= 5) {
        n /= 5;
        count += n;
      }
      return count;
    }
  }
}
