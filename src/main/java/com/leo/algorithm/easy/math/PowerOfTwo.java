// 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
//
// 示例 1:
//
// 输入: 1
// 输出: true
// 解释: 20 = 1
//
// 示例 2:
//
// 输入: 16
// 输出: true
// 解释: 24 = 16
//
// 示例 3:
//
// 输入: 218
// 输出: false
// Related Topics 位运算 数学
// 231. 2的幂

package com.leo.algorithm.easy.math;

public class PowerOfTwo {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.6 MB , 在所有 Java 提交中击败了 28.55% 的用户
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
      while (n > 0) {
        if (n == 2 || n == 1) return true;
        else if (n % 2 == 1) return false;
        n = (n >> 1);
      }
      return false;
    }
  }
}
