// 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
//
// 示例 1:
//
// 输入: n = 1
// 输出: [1,2,3,4,5,6,7,8,9]
//
//
//
//
// 说明：
//
//
// 用返回一个整数列表来代替打印
// n 为正整数
//
// Related Topics 数学
// 剑指 Offer 17. 打印从1到最大的n位数

package com.leo.algorithm.easy.math;

import com.leo.algorithm.utils.Printer;

public class DaYinCong1daoZuiDaDeNweiShuLcof {
  public static void main(String[] args) {
    Printer.printArray(new Solution().printNumbers(1));
    Printer.printArray(new Solution().printNumbers(2));
    Printer.printArray(new Solution().printNumbers(3));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.99% 的用户
     *
     * <p>内存消耗： 46.7 MB , 在所有 Java 提交中击败了 47.62% 的用户
     *
     * @param n
     * @return
     */
    public int[] printNumbers(int n) {
      int num = 1;
      for (int i = 1; i <= n; i++) {
        num *= 10;
      }
      int[] nums = new int[num - 1];
      for (int i = 1; i < num; i++) {
        nums[i - 1] = i;
      }
      return nums;
    }
  }
}
