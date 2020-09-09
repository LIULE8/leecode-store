// 给你一个正方形矩阵 mat，请你返回矩阵对角线元素的和。
//
// 请你返回在矩阵主对角线上的元素和副对角线上且不在主对角线上元素的和。
//
//
//
// 示例 1：
//
//
//
//
// 输入：mat = [[1,2,3],
//             [4,5,6],
//             [7,8,9]]
// 输出：25
// 解释：对角线的和为：1 + 5 + 9 + 3 + 7 = 25
// 请注意，元素 mat[1][1] = 5 只会被计算一次。
//
//
// 示例 2：
//
//
// 输入：mat = [[1,1,1,1],
//             [1,1,1,1],
//             [1,1,1,1],
//             [1,1,1,1]]
// 输出：8
//
//
// 示例 3：
//
//
// 输入：mat = [[5]]
// 输出：5
//
//
//
//
// 提示：
//
//
// n == mat.length == mat[i].length
// 1 <= n <= 100
// 1 <= mat[i][j] <= 100
//
// Related Topics 数组
// 1572. 矩阵对角线元素的和

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MatrixDiagonalSum {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        25, new Solution().diagonalSum(DataBuilder.buildDoubleArray("[[1,2,3],[4,5,6],[7,8,9]]")));
    Printer.printCorrectAnswer(
        55,
        new Solution()
            .diagonalSum(
                DataBuilder.buildDoubleArray("[[7,3,1,9],[3,4,6,9],[6,9,6,6],[9,5,8,5]]")));
    Printer.printCorrectAnswer(
        8,
        new Solution()
            .diagonalSum(
                DataBuilder.buildDoubleArray("[[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1]]")));
    int[][] a = new int[1][1];
    a[0][0] = 5;
    Printer.printCorrectAnswer(5, new Solution().diagonalSum(a));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.7 MB , 在所有 Java 提交中击败了 82.44% 的用户
     *
     * @param mat
     * @return
     */
    public int diagonalSum(int[][] mat) {
      int rowLength = mat.length;
      int columnLength = mat[0].length;
      int row = 0, column = 0;
      int sum = 0;
      while (row < rowLength && column < columnLength) {
        sum += mat[row++][column++];
      }
      row = 0;
      column = columnLength - 1;
      while (row < rowLength && column >= 0) {
        sum += mat[row++][column--];
      }
      if (rowLength % 2 != 0) sum -= mat[rowLength >> 1][columnLength >> 1];
      return sum;
    }
  }
}
