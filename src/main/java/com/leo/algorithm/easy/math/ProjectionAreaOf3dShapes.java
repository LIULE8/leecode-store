// 在 N * N 的网格中，我们放置了一些与 x，y，z 三轴对齐的 1 * 1 * 1 立方体。
//
// 每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
//
// 现在，我们查看这些立方体在 xy、yz 和 zx 平面上的投影。
//
// 投影就像影子，将三维形体映射到一个二维平面上。
//
// 在这里，从顶部、前面和侧面看立方体时，我们会看到“影子”。
//
// 返回所有三个投影的总面积。
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
// 示例 1：
//
// 输入：[[2]]
// 输出：5
//
//
// 示例 2：
//
// 输入：[[1,2],[3,4]]
// 输出：17
// 解释：
// 这里有该形体在三个轴对齐平面上的三个投影(“阴影部分”)。
//
//
//
// 示例 3：
//
// 输入：[[1,0],[0,2]]
// 输出：8
//
//
// 示例 4：
//
// 输入：[[1,1,1],[1,0,1],[1,1,1]]
// 输出：14
//
//
// 示例 5：
//
// 输入：[[2,2,2],[2,1,2],[2,2,2]]
// 输出：21
//
//
//
//
// 提示：
//
//
// 1 <= grid.length = grid[0].length <= 50
// 0 <= grid[i][j] <= 50
//
// Related Topics 数学
// 883. 三维形体投影面积

package com.leo.algorithm.easy.math;

public class ProjectionAreaOf3dShapes {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 92.86% 的用户
     *
     * <p>内存消耗： 38.3 MB , 在所有 Java 提交中击败了 45.24% 的用户 方法：数学 思路和算法
     *
     * <p>从顶部看，由该形状生成的阴影将是网格中非零值的数目。
     *
     * <p>从侧面看，由该形状生成的阴影将是网格中每一行的最大值。
     *
     * <p>从前面看，由该形状生成的阴影将是网格中每一列的最大值。
     *
     * <p>示例
     *
     * <p>例如 [[1,2],[3,4]]：
     *
     * <p>顶部的阴影将为 4，因为网格中有四个非零值;
     *
     * <p>侧面的阴影为 2 + 4，因为第一行的最大值为 2，第二行的最大值为 4;
     *
     * <p>前面的阴影是 3 + 4，因为第一列的最大值是 3，第二列的最大值是 4。
     *
     * @param grid
     * @return
     */
    public int projectionArea(int[][] grid) {
      int N = grid.length;
      int ans = 0;
      for (int i = 0; i < N; ++i) {
        int bestRow = 0; // largest of grid[i][j]
        int bestCol = 0; // largest of grid[j][i]
        for (int j = 0; j < N; ++j) {
          if (grid[i][j] > 0) ans++; // top shadow
          bestRow = Math.max(bestRow, grid[i][j]);
          bestCol = Math.max(bestCol, grid[j][i]);
        }
        ans += bestRow + bestCol;
      }
      return ans;
    }
  }
}
