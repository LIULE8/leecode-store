// 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//
//
// F(0) = 0,   F(1) = 1
// F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
//
//
// 示例 1：
//
//
// 输入：n = 2
// 输出：1
//
//
// 示例 2：
//
//
// 输入：n = 5
// 输出：5
//
//
//
//
// 提示：
//
//
// 0 <= n <= 100
//
// Related Topics 记忆化搜索 数学 动态规划
// 剑指 Offer 10- I. 斐波那契数列

package com.leo.algorithm.easy.math;

import com.leo.algorithm.utils.Printer;

public class FeiBoNaQiShuLieLcof {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(134903163, new Solution().fib(45));
    Printer.printCorrectAnswer(701408733, new Solution().fib(44));
    Printer.printCorrectAnswer(832040, new Solution().fib(30));
    Printer.printCorrectAnswer(1, new Solution().fib(1));
    Printer.printCorrectAnswer(0, new Solution().fib(0));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.4 MB , 在所有 Java 提交中击败了 16.61% 的用户
     *
     * @param n
     * @return
     */
    public int fib(int n) {
      if (n <= 1) return n;
      int a = 1, b = 1, sum = 0;
      for (int i = 1; i < n; i++) {
        sum = (a + b) % 1000000007;
        b = a;
        a = sum;
      }
      return b;
    }
  }
}
