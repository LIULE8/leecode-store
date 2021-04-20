// 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
// 示例：
// 输入： a = 1, b = 2
// 输出： 2
//
// Related Topics 位运算 数学
// 面试题 16.07. 最大数值

package com.leo.algorithm.easy.math;

public class MaximumLcci {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.1 MB , 在所有 Java 提交中击败了 82.72% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public int maximum(int a, int b) {
      long c = (long) a - (long) b;
      int k = (int) (c >> 63);
      return (k + 1) * a - k * b;
    }
  }
}
