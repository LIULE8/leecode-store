// 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被
// 0（代表水）包围着。
//
// 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
//
//
//
// 示例 1:
//
// [[0,0,1,0,0,0,0,1,0,0,0,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,1,1,0,1,0,0,0,0,0,0,0,0],
// [0,1,0,0,1,1,0,0,1,0,1,0,0],
// [0,1,0,0,1,1,0,0,1,1,1,0,0],
// [0,0,0,0,0,0,0,0,0,0,1,0,0],
// [0,0,0,0,0,0,0,1,1,1,0,0,0],
// [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//
//
// 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
//
// 示例 2:
//
// [[0,0,0,0,0,0,0,0]]
//
// 对于上面这个给定的矩阵, 返回 0。
//
//
//
// 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵
// 695. 岛屿的最大面积

package com.leo.algorithm.plan.introduction.t07;

public class MaxAreaOfIsland {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.9 MB , 在所有 Java 提交中击败了 68.36% 的用户
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
      int max = 0;
      for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
          max = Math.max(max, isIslandDFS(grid, i, j));
        }
      }
      return max;
    }

    private int isIslandDFS(int[][] grid, int i, int j) {
      if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length) {
        if (grid[i][j] == 0) return 0;
        // 遍历过设置为0，防止重复遍历
        grid[i][j] = 0;
        return 1
            + isIslandDFS(grid, i - 1, j)
            + isIslandDFS(grid, i + 1, j)
            + isIslandDFS(grid, i, j - 1)
            + isIslandDFS(grid, i, j + 1);
      }
      return 0;
    }
  }
}
