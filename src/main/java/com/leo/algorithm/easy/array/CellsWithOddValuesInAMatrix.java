// 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
//
// 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
//
// 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
//
// 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
//
//
//
// 示例 1：
//
//
//
// 输入：n = 2, m = 3, indices = [[0,1],[1,1]]
// 输出：6
// 解释：最开始的矩阵是 [[0,0,0],[0,0,0]]。
// 第一次增量操作后得到 [[1,2,1],[0,1,0]]。
// 最后的矩阵是 [[1,3,1],[1,3,1]]，里面有 6 个奇数。
//
//
// 示例 2：
//
//
//
// 输入：n = 2, m = 2, indices = [[1,1],[0,0]]
// 输出：0
// 解释：最后的矩阵是 [[2,2],[2,2]]，里面没有奇数。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 50
// 1 <= m <= 50
// 1 <= indices.length <= 100
// 0 <= indices[i][0] < n
// 0 <= indices[i][1] < m
//
// Related Topics 数组
// 1252. 奇数值单元格的数目

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class CellsWithOddValuesInAMatrix {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        6, new Solution().oddCells(2, 3, DataBuilder.buildDoubleArray("[[0,1],[1,1]]")));
    Printer.printCorrectAnswer(
        0, new Solution().oddCells(2, 2, DataBuilder.buildDoubleArray("[[1,1],[0,0]]")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 78.15% 的用户
     *
     * <p>内存消耗： 37.4 MB , 在所有 Java 提交中击败了 96.70% 的用户
     *
     * @param n
     * @param m
     * @param indices
     * @return
     */
    public int oddCells(int n, int m, int[][] indices) {
      int[][] res = new int[n][m];
      for (int[] target : indices) {
        initRes(res, target);
      }
      int count = 0;
      for (int[] re : res) {
        for (int i : re) {
          if (i % 2 == 1) count++;
        }
      }
      return count;
    }

    private void initRes(int[][] res, int[] target) {
      int row = target[0];
      int column = target[1];
      for (int i = 0; i < res[row].length; i++) {
        res[row][i]++;
      }
      for (int i = 0; i < res.length; i++) {
        res[i][column]++;
      }
    }
  }
}
