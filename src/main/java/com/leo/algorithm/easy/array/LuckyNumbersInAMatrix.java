// 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
//
// 幸运数是指矩阵中满足同时下列两个条件的元素：
//
//
// 在同一行的所有元素中最小
// 在同一列的所有元素中最大
//
//
//
//
// 示例 1：
//
// 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
// 输出：[15]
// 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
//
//
// 示例 2：
//
// 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
// 输出：[12]
// 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
//
//
// 示例 3：
//
// 输入：matrix = [[7,8],[1,2]]
// 输出：[7]
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= n, m <= 50
// 1 <= matrix[i][j] <= 10^5
// 矩阵中的所有元素都是不同的
//
// Related Topics 数组
// 1380. 矩阵中的幸运数

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {
  public static void main(String[] args) {
    Printer.printIntegerList(
        new Solution()
            .luckyNumbers(DataBuilder.buildDoubleArray("[[3,7,8],[9,11,13],[15,16,17]]")));
    Printer.printIntegerList(
        new Solution()
            .luckyNumbers(DataBuilder.buildDoubleArray("[[1,10,4,2],[9,3,8,7],[15,16,17,12]]")));
    Printer.printIntegerList(
        new Solution().luckyNumbers(DataBuilder.buildDoubleArray("[[7,8],[1,2]]")));
    Printer.printIntegerList(
        new Solution()
            .luckyNumbers(DataBuilder.buildDoubleArray("[[76618,42558,65788,20503,29400,54116]]")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.88% 的用户
     *
     * <p>内存消耗： 40.4 MB , 在所有 Java 提交中击败了 39.83% 的用户
     *
     * @param matrix
     * @return
     */
    public List<Integer> luckyNumbers(int[][] matrix) {
      List<Integer> list = new ArrayList<>();
      if (matrix.length == 1) {
        int number = getLuckNumber(matrix, matrix[0]);
        if (number != -1) list.add(number);
        return list;
      }
      for (int[] row : matrix) {
        int number = getLuckNumber(matrix, row);
        if (number != -1) list.add(number);
      }
      return list;
    }

    private int getLuckNumber(int[][] matrix, int[] row) {
      int column = 0;
      int min = row[0];
      for (int j = 1; j < row.length; j++) {
        if (min > row[j]) {
          min = row[j];
          column = j;
        }
      }
      for (int[] r : matrix) {
        if (min < r[column]) return -1;
      }
      return min;
    }
  }
}
