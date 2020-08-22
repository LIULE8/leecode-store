// 如果数组是单调递增或单调递减的，那么它是单调的。
//
// 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是
// 单调递减的。
//
// 当给定的数组 A 是单调数组时返回 true，否则返回 false。
//
//
//
//
//
//
// 示例 1：
//
// 输入：[1,2,2,3]
// 输出：true
//
//
// 示例 2：
//
// 输入：[6,5,4,4]
// 输出：true
//
//
// 示例 3：
//
// 输入：[1,3,2]
// 输出：false
//
//
// 示例 4：
//
// 输入：[1,2,4,5]
// 输出：true
//
//
// 示例 5：
//
// 输入：[1,1,1]
// 输出：true
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 50000
// -100000 <= A[i] <= 100000
//
// Related Topics 数组
// 896. 单调数列

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MonotonicArray {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true, new Solution().isMonotonic(DataBuilder.buildIntArray("1,2,2,3")));
    Printer.printCorrectAnswer(
        true, new Solution().isMonotonic(DataBuilder.buildIntArray("6,5,4,4")));
    Printer.printCorrectAnswer(
        false, new Solution().isMonotonic(DataBuilder.buildIntArray("1,3,2")));
    Printer.printCorrectAnswer(
        true, new Solution().isMonotonic(DataBuilder.buildIntArray("1,2,4,5")));
    Printer.printCorrectAnswer(
        true, new Solution().isMonotonic(DataBuilder.buildIntArray("1,1,1")));
    Printer.printCorrectAnswer(
        true, new Solution().isMonotonic(DataBuilder.buildIntArray("1,1,0")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 47.6 MB , 在所有 Java 提交中击败了 68.42% 的用户
     *
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A) {
      return increase(A) || decrease(A);
    }

    private boolean decrease(int[] A) {
      if (A.length == 1) return true;
      for (int i = 0; i < A.length - 1; i++) {
        if (A[i] < A[i + 1]) return false;
      }
      return true;
    }

    private boolean increase(int[] A) {
      if (A.length == 1) return true;
      for (int i = 0; i < A.length - 1; i++) {
        if (A[i] > A[i + 1]) return false;
      }
      return true;
    }
  }
}
