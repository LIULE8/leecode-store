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
    Printer.printCorrectAnswer(true, new Solution().isPerfectSquare(808201));
  }

  static class Solution {
    public boolean isPerfectSquare(int num) {
      //      return method1(num);
      return method2(num);
    }

    /**
     * 記得用long 和 num 需要先 除以 2 否則精度丟失以及超時
     *
     * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.3 MB , 在所有 Java 提交中击败了 32.55% 的用户
     *
     * @param num
     * @return
     */
    private boolean method2(int num) {
      if (num == 1) return true;
      long l = 0, r = num >> 1;
      while (l <= r) {
        long mid = l + ((r - l) >> 1);
        long res = mid * mid;
        if (res == num) {
          return true;
        } else if (res < num) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      return false;
    }

    /**
     * 牛頓迭代法
     *
     * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.2 MB , 在所有 Java 提交中击败了 32.55% 的用户
     *
     * @param num
     * @return
     */
    private boolean method1(int num) {
      long r = num;
      while (r * r > num) {
        r = (r + num / r) / 2;
      }
      return r * r == num;
    }
  }
}
