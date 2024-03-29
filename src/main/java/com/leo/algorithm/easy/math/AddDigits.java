// 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
//
// 示例:
//
// 输入: 38
// 输出: 2
// 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
//
//
// 进阶:
// 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
// Related Topics 数学
// 258. 各位相加

package com.leo.algorithm.easy.math;

public class AddDigits {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.7 MB , 在所有 Java 提交中击败了 29.21% 的用户
     *
     * @param num
     * @return
     */
    public int addDigits(int num) {
      if (num < 10) return num;
      int sum = 0;
      while (num > 0) {
        sum += num % 10;
        num /= 10;
      }
      return addDigits(sum);
    }
  }
}
