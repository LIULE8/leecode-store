// 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
//
// 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
//
// 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿
// 的周长。
//
//
//
// 示例 :
//
// 输入:
// [[0,1,0,0],
// [1,1,1,0],
// [0,1,0,0],
// [1,1,0,0]]
//
// 输出: 16
//
// 解释: 它的周长是下面图片中的 16 个黄色的边：
//
//
//
// Related Topics 哈希表
// 463. 岛屿的周长

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class IslandPerimeter {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        16,
        new Solution()
            .islandPerimeter(
                DataBuilder.buildDoubleArray("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]")));
    Printer.printCorrectAnswer(
        4, new Solution().islandPerimeter(DataBuilder.buildDoubleArray("[[1]]")));
  }

  static class Solution {
    /**
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 75.69% 的用户
     *
     * <p>内存消耗： 39.7 MB , 在所有 Java 提交中击败了 47.04% 的用户
     *
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
      int sum = 0;
      for (int i = 0; i < grid.length; i++) {
        // 第一行
        if (i == 0) {
          for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == 0) continue;
            sum += 4;
            if (i + 1 < grid.length && grid[i + 1][j] == 1) sum--;
            if (j > 0 && grid[i][j - 1] == 1) sum--;
            if (j < grid[i].length - 1 && grid[i][j + 1] == 1) sum--;
          }
          continue;
        }
        // 最后一行
        if (i == grid.length - 1) {
          for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == 0) continue;
            sum += 4;
            if (grid[i - 1][j] == 1) sum--;
            if (j > 0 && grid[i][j - 1] == 1) sum--;
            if (j < grid[i].length - 1 && grid[i][j + 1] == 1) sum--;
          }
          continue;
        }
        // 中间行
        for (int j = 0; j < grid[i].length; j++) {
          if (grid[i][j] == 0) continue;
          sum += 4;
          if (grid[i + 1][j] == 1) sum--;
          if (grid[i - 1][j] == 1) sum--;
          if (j > 0 && grid[i][j - 1] == 1) sum--;
          if (j < grid[i].length - 1 && grid[i][j + 1] == 1) sum--;
        }
      }
      return sum;
    }
  }
}
