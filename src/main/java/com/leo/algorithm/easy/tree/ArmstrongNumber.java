// 假设存在一个 k 位数 N，其每一位上的数字的 k 次幂的总和也是 N，那么这个数是阿姆斯特朗数。
//
// 给你一个正整数 N，让你来判定他是否是阿姆斯特朗数，是则返回 true，不是则返回 false。
//
//
//
// 示例 1：
//
// 输入：153
// 输出：true
// 示例：
// 153 是一个 3 位数，且 153 = 1^3 + 5^3 + 3^3。
//
//
// 示例 2：
//
// 输入：123
// 输出：false
// 解释：
// 123 是一个 3 位数，且 123 != 1^3 + 2^3 + 3^3 = 36。
//
//
//
//
// 提示：
//
//
// 1 <= N <= 10^8
//
// Related Topics 数学
// 1134. 阿姆斯特朗数

package com.leo.algorithm.easy.tree;

import com.leo.algorithm.utils.Printer;

public class ArmstrongNumber {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isArmstrong(153));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 34.9 MB , 在所有 Java 提交中击败了 93.33% 的用户
     *
     * @param n
     * @return
     */
    public boolean isArmstrong(int n) {
      String s = String.valueOf(n);
      int num = s.length();
      int tmp = n, sum = 0;
      while (tmp > 0) {
        int a = tmp % 10;
        sum += Math.pow(a, num);
        tmp /= 10;
      }
      return n == sum;
    }
  }
}
