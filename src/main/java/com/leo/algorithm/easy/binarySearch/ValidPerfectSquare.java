// 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
//
// 说明：不要使用任何内置的库函数，如 sqrt。
//
// 示例 1：
//
// 输入：16
// 输出：True
//
// 示例 2：
//
// 输入：14
// 输出：False
//
// Related Topics 数学 二分查找
// 367. 有效的完全平方数

package com.leo.algorithm.easy.binarySearch;

import com.leo.algorithm.utils.Printer;

public class ValidPerfectSquare {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(false, new Solution().isPerfectSquare(2147483647));
    Printer.printCorrectAnswer(true, new Solution().isPerfectSquare(9));
    Printer.printCorrectAnswer(true, new Solution().isPerfectSquare(1));
    Printer.printCorrectAnswer(false, new Solution().isPerfectSquare(2));
    Printer.printCorrectAnswer(true, new Solution().isPerfectSquare(0));
    Printer.printCorrectAnswer(true, new Solution().isPerfectSquare(16));
    Printer.printCorrectAnswer(false, new Solution().isPerfectSquare(14));
  }

  static class Solution {
    public boolean isPerfectSquare(int num) {
      return method1(num);
    }

    /**
     * 牛頓迭代法
     * @param num
     * @return
     */
    private boolean method1(int num) {
      long r = num;
      while (r * r > num) {
        r = (r + num /r) /2;
      }
      return r * r == num;
    }
  }
}
