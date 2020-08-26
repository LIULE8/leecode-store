// 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
//
// 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
//
//
//
// 示例：
//
// 输入: [[4,3,8,4],
//      [9,5,1,9],
//      [2,7,6,2]]
// 输出: 1
// 解释:
// 下面的子矩阵是一个 3 x 3 的幻方：
// 438
// 951
// 276
//
// 而这一个不是：
// 384
// 519
// 762
//
// 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
//
//
// 提示:
//
//
// 1 <= grid.length <= 10
// 1 <= grid[0].length <= 10
// 0 <= grid[i][j] <= 15
//
// Related Topics 数组
// 840. 矩阵中的幻方

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MagicSquaresInGrid {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        1,
        new Solution()
            .numMagicSquaresInside(
                DataBuilder.buildDoubleArray("[[4,3,8,4],[9,5,1,9],[2,7,6,2]]")));
    Printer.printCorrectAnswer(
        0,
        new Solution()
            .numMagicSquaresInside(DataBuilder.buildDoubleArray("[[5,5,5],[5,5,5],[5,5,5]]")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 41.99% 的用户
     *
     * <p>内存消耗： 37.6 MB , 在所有 Java 提交中击败了 50.48% 的用户
     *
     * @param grid
     * @return
     */
    public int numMagicSquaresInside(int[][] grid) {
      int count = 0;
      for (int i = 0; i < grid.length - 2; i++) {
        for (int j = 0; j < grid[0].length - 2; j++) {
          if (grid[i + 1][j + 1] != 5) continue;
          if (isMagicSquares(
              grid[i][j],
              grid[i][j + 1],
              grid[i][j + 2],
              grid[i + 1][j],
              grid[i + 1][j + 1],
              grid[i + 1][j + 2],
              grid[i + 2][j],
              grid[i + 2][j + 1],
              grid[i + 2][j + 2])) count++;
        }
      }
      return count;
    }

    private boolean isMagicSquares(int... vals) {
      // 判断没有数字相等
      int[] count = new int[16];
      for (int val : vals) count[val]++;
      for (int i = 1; i <= 9; i++) {
        if (count[i] != 1) return false;
      }
      return vals[0] + vals[1] + vals[2] == 15
          && vals[3] + vals[4] + vals[5] == 15
          && vals[6] + vals[7] + vals[8] == 15
          && vals[0] + vals[3] + vals[6] == 15
          && vals[1] + vals[4] + vals[7] == 15
          && vals[2] + vals[5] + vals[8] == 15
          && vals[0] + vals[4] + vals[8] == 15
          && vals[2] + vals[4] + vals[6] == 15;
    }
  }
}
