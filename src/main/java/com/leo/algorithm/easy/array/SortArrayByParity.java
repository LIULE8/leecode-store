// 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
//
// 你可以返回满足此条件的任何数组作为答案。
//
//
//
// 示例：
//
// 输入：[3,1,2,4]
// 输出：[2,4,3,1]
// 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 5000
// 0 <= A[i] <= 5000
//
// Related Topics 数组
// 905. 按奇偶排序数组

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class SortArrayByParity {
  public static void main(String[] args) {
    Printer.printArray(new Solution().sortArrayByParity(DataBuilder.buildIntArray("3,1,2,4")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 40.5 MB , 在所有 Java 提交中击败了 71.43% 的用户
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
      if (A == null || A.length == 0) return A;
      int start = 0;
      int end = A.length - 1;
      while (start < end) {
        while (start < end && A[start] % 2 == 0) start++;
        if (start >= end) break;
        while (start < end && A[end] % 2 == 1) end--;
        int temp = A[start];
        A[start] = A[end];
        A[end] = temp;
      }
      return A;
    }
  }
}
