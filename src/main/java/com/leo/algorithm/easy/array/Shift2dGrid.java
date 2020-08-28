// 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
//
// 每次「迁移」操作将会引发下述活动：
//
//
// 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
// 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
// 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
//
//
// 请你返回 k 次迁移操作后最终得到的 二维网格。
//
//
//
// 示例 1：
//
//
//
// 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
// 输出：[[9,1,2],[3,4,5],[6,7,8]]
//
//
// 示例 2：
//
//
//
// 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
// 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
//
//
// 示例 3：
//
// 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
// 输出：[[1,2,3],[4,5,6],[7,8,9]]
//
//
//
//
// 提示：
//
//
// 1 <= grid.length <= 50
// 1 <= grid[i].length <= 50
// -1000 <= grid[i][j] <= 1000
// 0 <= k <= 100
//
// Related Topics 数组
// 1260. 二维网格迁移

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class Shift2dGrid {
  public static void main(String[] args) {
    Printer.printDoubleList(
        new Solution().shiftGrid(DataBuilder.buildDoubleArray("[[1,2,3],[4,5,6],[7,8,9]]"), 1));
    Printer.printDoubleList(
        new Solution()
            .shiftGrid(
                DataBuilder.buildDoubleArray("[[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]]"),
                4));
    Printer.printDoubleList(
        new Solution().shiftGrid(DataBuilder.buildDoubleArray("[[1,2,3],[4,5,6],[7,8,9]]"), 9));
  }

  static class Solution {
    /**
     * 执行用时： 41 ms , 在所有 Java 提交中击败了 5.26% 的用户
     *
     * <p>内存消耗： 40.5 MB , 在所有 Java 提交中击败了 46.72% 的用户
     *
     * @param grid
     * @param k
     * @return
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
      List<List<Integer>> result = new ArrayList<>(grid.length);
      for (int[] ints : grid) {
        List<Integer> row = new ArrayList<>(ints.length);
        for (int anInt : ints) {
          row.add(anInt);
        }
        result.add(row);
      }
      for (int h = 0; h < k; h++) {
        int end = result.get(result.size() - 1).get(result.get(result.size() - 1).size() - 1);
        for (int i = result.size() - 1; i >= 0; i--) {
          List<Integer> row = result.get(i);
          for (int j = row.size() - 1; j > 0; j--) {
            row.set(j, row.get(j - 1));
          }
          if (i > 0) {
            List<Integer> lastRow = result.get(i - 1);
            row.set(0, lastRow.get(lastRow.size() - 1));
          }
        }
        result.get(0).set(0, end);
      }
      return result;
    }
  }
}
