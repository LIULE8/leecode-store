// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
//
//
//
// 示例 1：
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
// 输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 限制：
//
//
// 0 <= matrix.length <= 100
// 0 <= matrix[i].length <= 100
//
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
// Related Topics 数组
// 剑指 Offer 29. 顺时针打印矩阵

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ShunShiZhenDaYinJuZhenLcof {
  public static void main(String[] args) {
    Printer.printArray(
        new Solution().spiralOrder(DataBuilder.buildDoubleArray("[[1,2,3],[4,5,6],[7,8,9]]")));
    Printer.printArray(
        new Solution()
            .spiralOrder(DataBuilder.buildDoubleArray("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.02% 的用户
     *
     * <p>内存消耗： 40.9 MB , 在所有 Java 提交中击败了 88.14% 的用户
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
      if (matrix.length == 0 || matrix[0].length == 0) return new int[0];
      int i = 0, j = 0, k = 0, length = matrix.length * matrix[0].length;
      int row = matrix.length - 1, column = matrix[0].length - 1;
      int[] res = new int[length];
      outer:
      while (k < length) {
        // 1. 左横
        for (int l = i; l <= column; l++) {
          res[k++] = matrix[i][l];
          if (k >= length) break outer;
        }
        // 2. 下竖
        for (int l = i + 1; l <= row; l++) {
          res[k++] = matrix[l][column];
          if (k >= length) break outer;
        }
        // 3. 右横
        for (int l = column - 1; l >= i; --l) {
          res[k++] = matrix[row][l];
          if (k >= length) break outer;
        }
        // 4. 上竖
        for (int l = row - 1; l >= i + 1; --l) {
          res[k++] = matrix[l][j];
          if (k >= length) break outer;
        }
        row--;
        column--;
        i++;
        j++;
      }
      return res;
    }
  }
}
