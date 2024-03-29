// 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
//
//
//
// 示例 1：
//
//
// 输入：n = 6
// 输出：true
// 解释：6 = 2 × 3
//
// 示例 2：
//
//
// 输入：n = 8
// 输出：true
// 解释：8 = 2 × 2 × 2
//
//
// 示例 3：
//
//
// 输入：n = 14
// 输出：false
// 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
//
//
// 示例 4：
//
//
// 输入：n = 1
// 输出：true
// 解释：1 通常被视为丑数。
//
//
//
//
// 提示：
//
//
// -231 <= n <= 231 - 1
//
// Related Topics 数学
// 263. 丑数

package com.leo.algorithm.easy.math;

import com.leo.algorithm.utils.Printer;

public class UglyNumber {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isUgly(6));
    Printer.printCorrectAnswer(true, new Solution().isUgly(8));
    Printer.printCorrectAnswer(false, new Solution().isUgly(14));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.3 MB , 在所有 Java 提交中击败了 85.51% 的用户
     *
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
      if (n == 1) return true;
      while (n > 0) {
        if (n == 2 || n == 3 || n == 5) return true;
        else if (n % 2 == 0) n /= 2;
        else if (n % 3 == 0) n /= 3;
        else if (n % 5 == 0) n /= 5;
        else return false;
      }
      return false;
    }
  }
}
