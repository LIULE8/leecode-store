// 给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
//
// 两个相邻元素间的距离为 1 。
//
//
//
// 示例 1：
//
//
//
//
// 输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
// 输出：[[0,0,0],[0,1,0],[0,0,0]]
//
//
// 示例 2：
//
//
//
//
// 输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
// 输出：[[0,0,0],[0,1,0],[1,2,1]]
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// mat[i][j] is either 0 or 1.
// mat 中至少有一个 0
//
// Related Topics 广度优先搜索 数组 动态规划 矩阵
// 542. 01 矩阵

package com.leo.algorithm.plan.introduction.t09;

public class Zero1Matrix {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {

    public int[][] updateMatrix(int[][] mat) {
      return method1(mat);
    }

    /**
     * 动态规划
     *
     * <p>1 到 0 的距离 一定是从邻居那里获得的
     *
     * <p>从左上往下遍历 dist[i][j] = min(dist[i][j], min(dist[i-1][j], dist[i][j-1]) + 1)
     *
     * <p>从右下往上遍历 dist[i][j] = min(dist[i][j], min(dist[i+1][j], dist[i][j+1]) + 1)
     *
     * <p>执行用时： 7 ms , 在所有 Java 提交中击败了 94.72% 的用户
     *
     * <p>内存消耗： 41.9 MB , 在所有 Java 提交中击败了 45.40% 的用户
     *
     * @param mat
     * @return
     */
    private int[][] method1(int[][] mat) {
      if (mat == null || mat.length == 0) return mat;
      int row = mat.length;
      int col = mat[0].length;
      int[][] dist = new int[row][col];
      // 初始化 dist
      int initData = Integer.MAX_VALUE - 100000; // 防止越界 （减去一个较大数）
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          dist[i][j] = initData;
        }
      }

      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          if (mat[i][j] == 0) {
            dist[i][j] = 0;
          } else {
            if (i > 0) dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
            if (j > 0) dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
          }
        }
      }

      for (int i = row - 1; i >= 0; i--) {
        for (int j = col - 1; j >= 0; j--) {
          if (i < row - 1) dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
          if (j < col - 1) dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
        }
      }
      return dist;
    }
  }
}
