// 给定已经按升序排列、由不同整数组成的数组 A，返回满足 A[i] == i 的最小索引 i。如果不存在这样的 i，返回 -1。
//
//
//
// 示例 1：
//
// 输入：[-10,-5,0,3,7]
// 输出：3
// 解释：
// 对于给定的数组，A[0] = -10，A[1] = -5，A[2] = 0，A[3] = 3，因此输出为 3 。
//
//
// 示例 2：
//
// 输入：[0,2,5,8,17]
// 输出：0
// 示例：
// A[0] = 0，因此输出为 0 。
//
//
// 示例 3：
//
// 输入：[-10,-5,3,4,7,9]
// 输出：-1
// 解释：
// 不存在这样的 i 满足 A[i] = i，因此输出为 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= A.length < 10^4
// -10^9 <= A[i] <= 10^9
//
// Related Topics 数组 二分查找
// 1064. 不动点

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class FixedPoint {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        3, new Solution().fixedPoint(DataBuilder.buildIntArray("-10,-5,0,3,7")));
    Printer.printCorrectAnswer(
        0, new Solution().fixedPoint(DataBuilder.buildIntArray("0,2,5,8,17")));
    Printer.printCorrectAnswer(
        -1, new Solution().fixedPoint(DataBuilder.buildIntArray("-10,-5,3,4,7,9")));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param A
     * @return
     */
    public int fixedPoint(int[] A) {
      for (int i = 0; i < A.length; i++) {
        if (A[i] == i) return i;
      }
      return -1;
    }
  }
}