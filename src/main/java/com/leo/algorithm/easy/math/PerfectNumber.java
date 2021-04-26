// 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
//
// 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
//
//
//
// 示例 1：
//
// 输入：28
// 输出：True
// 解释：28 = 1 + 2 + 4 + 7 + 14
// 1, 2, 4, 7, 和 14 是 28 的所有正因子。
//
// 示例 2：
//
// 输入：num = 6
// 输出：true
//
//
// 示例 3：
//
// 输入：num = 496
// 输出：true
//
//
// 示例 4：
//
// 输入：num = 8128
// 输出：true
//
//
// 示例 5：
//
// 输入：num = 2
// 输出：false
//
//
//
//
// 提示：
//
//
// 1 <= num <= 108
//
// Related Topics 数学
// 507. 完美数

package com.leo.algorithm.easy.math;

public class PerfectNumber {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public int pn(int p) {
      return (1 << (p - 1)) * ((1 << p) - 1);
    }

    public boolean checkPerfectNumber(int num) {
      return method1(num);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35 MB , 在所有 Java 提交中击败了 87.81% 的用户
     *
     * @param num
     * @return
     */
    private boolean method1(int num) {
      int[] primes = new int[] {2, 3, 5, 7, 13, 17, 19, 31};
      for (int prime : primes) {
        if (pn(prime) == num) return true;
      }
      return false;
    }
  }
}
