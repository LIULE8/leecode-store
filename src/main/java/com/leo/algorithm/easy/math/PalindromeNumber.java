// 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
//
//
//
// 示例 1：
//
//
// 输入：x = 121
// 输出：true
//
//
// 示例 2：
//
//
// 输入：x = -121
// 输出：false
// 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3：
//
//
// 输入：x = 10
// 输出：false
// 解释：从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 示例 4：
//
//
// 输入：x = -101
// 输出：false
//
//
//
//
// 提示：
//
//
// -231 <= x <= 231 - 1
//
//
//
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学
// 9. 回文数

package com.leo.algorithm.easy.math;

public class PalindromeNumber {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 99.03% 的用户
     *
     * <p>内存消耗： 37.6 MB , 在所有 Java 提交中击败了 94.33% 的用户
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
      if (x < 0) return false;
      if (x < 10) return true;
      int num = 0, tmp = x;
      while (tmp > 0) {
        num = num * 10 + tmp % 10;
        tmp /= 10;
      }
      return x == num;
    }
  }
}
