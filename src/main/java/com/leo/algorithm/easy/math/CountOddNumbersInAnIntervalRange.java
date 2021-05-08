// 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
//
//
//
// 示例 1：
//
// 输入：low = 3, high = 7
// 输出：3
// 解释：3 到 7 之间奇数数字为 [3,5,7] 。
//
// 示例 2：
//
// 输入：low = 8, high = 10
// 输出：1
// 解释：8 到 10 之间奇数数字为 [9] 。
//
//
//
// 提示：
//
//
// 0 <= low <= high <= 10^9
//
// Related Topics 数学
// 1523. 在区间范围内统计奇数数目

package com.leo.algorithm.easy.math;

public class CountOddNumbersInAnIntervalRange {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {

    public int countOdds(int low, int high) {
      //      return method1(low, high);
      return method2(low, high);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.2 MB , 在所有 Java 提交中击败了 52.73% 的用户
     *
     * @param low
     * @param high
     * @return
     */
    private int method2(int low, int high) {
      return (high + 1) >> 1 - low >> 1;
    }

    /**
     * 执行用时： 659 ms , 在所有 Java 提交中击败了 5.00% 的用户
     *
     * <p>内存消耗： 35 MB , 在所有 Java 提交中击败了 91.82% 的用户
     *
     * @param low
     * @param high
     * @return
     */
    private int method1(int low, int high) {
      int count = 0, i = low % 2 == 0 ? low + 1 : low;
      for (; i <= high; i += 2) count++;
      return count;
    }
  }
}
