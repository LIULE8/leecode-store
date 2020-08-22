// 给定一个矩阵 A， 返回 A 的转置矩阵。
//
// 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
//
//
//
// 示例 1：
//
// 输入：[[1,2,3],[4,5,6],[7,8,9]]
// 输出：[[1,4,7],[2,5,8],[3,6,9]]
//
//
// 示例 2：
//
// 输入：[[1,2,3],[4,5,6]]
// 输出：[[1,4],[2,5],[3,6]]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 1000
// 1 <= A[0].length <= 1000
//
// Related Topics 数组
// 867. 转置矩阵

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class TransposeMatrix {
  public static void main(String[] args) {
    Printer.printDoubleArray(
        new Solution().transpose(DataBuilder.buildDoubleArray("[[1,2,3],[4,5,6],[7,8,9]]")));
    Printer.printDoubleArray(
        new Solution().transpose(DataBuilder.buildDoubleArray("[[1,2,3],[4,5,6]]")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 52.28% 的用户
     *
     * <p>内存消耗： 40.8 MB , 在所有 Java 提交中击败了 25.20% 的用户
     *
     * @param A
     * @return
     */
    public int[][] transpose(int[][] A) {
      int[][] a = new int[A[0].length][A.length];
      for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A[i].length; j++) {
          a[j][i] = A[i][j];
        }
      }
      return a;
    }
  }
}
