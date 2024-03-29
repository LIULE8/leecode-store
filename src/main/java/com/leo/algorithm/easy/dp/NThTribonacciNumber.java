// 泰波那契序列 Tn 定义如下：
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
//
//
//
// 示例 1：
//
// 输入：n = 4
// 输出：4
// 解释：
// T_3 = 0 + 1 + 1 = 2
// T_4 = 1 + 1 + 2 = 4
//
//
// 示例 2：
//
// 输入：n = 25
// 输出：1389537
//
//
//
//
// 提示：
//
//
// 0 <= n <= 37
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。
//
// Related Topics 记忆化搜索 数学 动态规划
// 1137. 第 N 个泰波那契数

package com.leo.algorithm.easy.dp;

import com.leo.algorithm.utils.Printer;

public class NThTribonacciNumber {
  public static void main(String[] args) {
    int tribonacci = new Solution().tribonacci(4);
    Printer.printCorrectAnswer(4, tribonacci);
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.1 MB , 在所有 Java 提交中击败了 60.72% 的用户
     *
     * @param n
     * @return
     */
    public int tribonacci(int n) {
      if (n == 0) return 0;
      if (n <= 2) return 1;
      int sum = 0, a = 0, b = 1, c = 1;
      for (int i = 3; i <= n; i++) {
        sum = a + b + c;
        a = b;
        b = c;
        c = sum;
      }
      return sum;
    }
  }
}
