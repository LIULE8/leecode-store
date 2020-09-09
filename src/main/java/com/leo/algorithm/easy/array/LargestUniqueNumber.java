// 给你一个整数数组 A，请找出并返回在该数组中仅出现一次的最大整数。
//
// 如果不存在这个只出现一次的整数，则返回 -1。
//
//
//
// 示例 1：
//
// 输入：[5,7,3,9,4,9,8,3,1]
// 输出：8
// 解释：
// 数组中最大的整数是 9，但它在数组中重复出现了。而第二大的整数是 8，它只出现了一次，所以答案是 8。
//
//
// 示例 2：
//
// 输入：[9,9,8,8]
// 输出：-1
// 解释：
// 数组中不存在仅出现一次的整数。
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 2000
// 0 <= A[i] <= 1000
//
// Related Topics 数组 哈希表
// 1133. 最大唯一数

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class LargestUniqueNumber {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        8, new Solution().largestUniqueNumber(DataBuilder.buildIntArray("5,7,3,9,4,9,8,3,1")));
    Printer.printCorrectAnswer(
        -1, new Solution().largestUniqueNumber(DataBuilder.buildIntArray("9,9,8,8")));
    Printer.printCorrectAnswer(
        10, new Solution().largestUniqueNumber(DataBuilder.buildIntArray("11,10,11")));
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 53.09% 的用户
     *
     * <p>内存消耗： 39.2 MB , 在所有 Java 提交中击败了 87.10% 的用户
     *
     * @param A
     * @return
     */
    public int largestUniqueNumber(int[] A) {
      if (A.length == 1) return A[0];
      Arrays.sort(A);
      int count = 1;
      for (int i = A.length - 1; i >= 0; --i) {
        if (i - 1 >= 0 && A[i] == A[i - 1]) count++;
        else if (count == 1) return A[i];
        else count = 1;
      }
      return -1;
    }
  }
}
