// 你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
//
// 给定一个数字 n，找出可形成完整阶梯行的总行数。
//
// n 是一个非负整数，并且在32位有符号整型的范围内。
//
// 示例 1:
//
//
// n = 5
//
// 硬币可排列成以下几行:
// ¤
// ¤ ¤
// ¤ ¤
//
// 因为第三行不完整，所以返回2.
//
//
// 示例 2:
//
//
// n = 8
//
// 硬币可排列成以下几行:
// ¤
// ¤ ¤
// ¤ ¤ ¤
// ¤ ¤
//
// 因为第四行不完整，所以返回3.
//
// Related Topics 数学 二分查找
// 441. 排列硬币

package com.leo.algorithm.easy.binarySearch;

import com.leo.algorithm.utils.Printer;

public class ArrangingCoins {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(3, new Solution().arrangeCoins(8));
    Printer.printCorrectAnswer(2, new Solution().arrangeCoins(5));
    Printer.printCorrectAnswer(1, new Solution().arrangeCoins(1));
    Printer.printCorrectAnswer(2, new Solution().arrangeCoins(3));
    Printer.printCorrectAnswer(0, new Solution().arrangeCoins(0));
  }

  static class Solution {
    public int arrangeCoins(int n) {
      return method1(n);
    }

    /**
     * 暴力破解
     *
     * <p>执行用时： 19 ms , 在所有 Java 提交中击败了 5.49% 的用户
     *
     * <p>内存消耗： 35.6 MB , 在所有 Java 提交中击败了 53.78% 的用户
     *
     * @param n
     * @return
     */
    private int method1(int n) {
      long result = 0;
      for (int i = 1; i <= n; i++) {
        result += i;
        if (result > n) {
          return i - 1;
        } else if (result == n) {
          return i;
        }
      }
      return 0;
    }
  }
}
