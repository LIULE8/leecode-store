// 给定一个整数 n，返回 n! 结果尾数中零的数量。
//
// 示例 1:
//
// 输入: 3
// 输出: 0
// 解释: 3! = 6, 尾数中没有零。
//
// 示例 2:
//
// 输入: 5
// 输出: 1
// 解释: 5! = 120, 尾数中有 1 个零.
//
// 说明: 你算法的时间复杂度应为 O(log n) 。
// Related Topics 数学
// 172. 阶乘后的零

package com.leo.algorithm.easy.math;

import com.leo.algorithm.utils.Printer;

public class FactorialTrailingZeroes {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(0, new Solution().trailingZeroes(3));
    Printer.printCorrectAnswer(1, new Solution().trailingZeroes(5));
    Printer.printCorrectAnswer(6, new Solution().trailingZeroes(25));
    Printer.printCorrectAnswer(452137076, new Solution().trailingZeroes(1808548329));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 94.14% 的用户
     *
     * <p>内存消耗： 35.2 MB , 在所有 Java 提交中击败了 86.20% 的用户
     *
     * @param n 452137076
     * @return 有 bug，参考 FactorialZerosLcci
     */
    public int trailingZeroes(int n) {
      int res = 0;
      for (int i = 5; i <= n; i *= 5) res += n / i;
      return res;
    }
  }
}
