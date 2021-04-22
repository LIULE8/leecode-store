// 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
//
//
//
// 示例 1：
//
//
// 输入：n = 27
// 输出：true
//
//
// 示例 2：
//
//
// 输入：n = 0
// 输出：false
//
//
// 示例 3：
//
//
// 输入：n = 9
// 输出：true
//
//
// 示例 4：
//
//
// 输入：n = 45
// 输出：false
//
//
//
//
// 提示：
//
//
// -231 <= n <= 231 - 1
//
//
//
//
// 进阶：
//
//
// 你能不使用循环或者递归来完成本题吗？
//
// Related Topics 数学
// 326. 3的幂

package com.leo.algorithm.easy.math;

import com.leo.algorithm.utils.Printer;

public class PowerOfThree {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isPowerOfThree(27));
    Printer.printCorrectAnswer(true, new Solution().isPowerOfThree(9));
    Printer.printCorrectAnswer(true, new Solution().isPowerOfThree(1));
    Printer.printCorrectAnswer(false, new Solution().isPowerOfThree(165));
    Printer.printCorrectAnswer(false, new Solution().isPowerOfThree(0));
    Printer.printCorrectAnswer(false, new Solution().isPowerOfThree(2));
  }

  static class Solution {
    /**
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 99.03% 的用户
     *
     * <p>内存消耗： 38.2 MB , 在所有 Java 提交中击败了 72.99% 的用户
     *
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
      if (n == 1) return true;
      while (n > 2) {
        if (n == 3) return true;
        else if (n % 3 != 0) return false;
        n /= 3;
      }
      return false;
    }
  }
}
