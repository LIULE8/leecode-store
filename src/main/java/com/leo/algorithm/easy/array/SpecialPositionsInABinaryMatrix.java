// 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
//
// 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i,
// j) 被称为特殊位置。
//
//
//
// 示例 1：
//
// 输入：mat = [[1,0,0],
//             [0,0,1],
//             [1,0,0]]
// 输出：1
// 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
//
//
// 示例 2：
//
// 输入：mat = [[1,0,0],
//             [0,1,0],
//             [0,0,1]]
// 输出：3
// 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
//
//
// 示例 3：
//
// 输入：mat = [[0,0,0,1],
//             [1,0,0,0],
//             [0,1,1,0],
//             [0,0,0,0]]
// 输出：2
//
//
// 示例 4：
//
// 输入：mat = [[0,0,0,0,0],
//             [1,0,0,0,0],
//             [0,1,0,0,0],
//             [0,0,1,0,0],
//             [0,0,0,1,1]]
// 输出：3
//
//
//
//
// 提示：
//
//
// rows == mat.length
// cols == mat[i].length
// 1 <= rows, cols <= 100
// mat[i][j] 是 0 或 1
//
// Related Topics 数组
// 1582. 二进制矩阵中的特殊位置

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class SpecialPositionsInABinaryMatrix {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        1, new Solution().numSpecial(DataBuilder.buildDoubleArray("[[1,0,0],[0,0,1],[1,0,0]]")));
    Printer.printCorrectAnswer(
        3, new Solution().numSpecial(DataBuilder.buildDoubleArray("[[1,0,0],[0,1,0],[0,0,1]]")));
    Printer.printCorrectAnswer(
        2,
        new Solution()
            .numSpecial(DataBuilder.buildDoubleArray("[[0,0,0,1],[1,0,0,0],[0,1,1,0],[0,0,0,0]]")));
    Printer.printCorrectAnswer(
        3,
        new Solution()
            .numSpecial(
                DataBuilder.buildDoubleArray(
                    "[[0,0,0,0,0],[1,0,0,0,0],[0,1,0,0,0],[0,0,1,0,0],[0,0,0,1,1]]")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.7 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param mat
     * @return
     */
    public int numSpecial(int[][] mat) {
      int count = 0;
      for (int i = 0; i < mat.length; i++) {
        count += getSpecialNum(mat, i);
      }
      return count;
    }

    private int getSpecialNum(int[][] mat, int row) {
      int count = 0;
      int column = 0;
      for (int i = 0; i < mat[row].length; i++) {
        if (mat[row][i] == 1) {
          count++;
          column = i;
        }
      }
      if (count != 1) return 0;
      count = 0;
      for (int[] ints : mat) {
        if (ints[column] == 1) count++;
      }
      return count == 1 ? 1 : 0;
    }
  }
}
