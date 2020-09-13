// 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
//
// 请你统计并返回 grid 中 负数 的数目。
//
//
//
// 示例 1：
//
// 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
// 输出：8
// 解释：矩阵中共有 8 个负数。
//
//
// 示例 2：
//
// 输入：grid = [[3,2],[1,0]]
// 输出：0
//
//
// 示例 3：
//
// 输入：grid = [[1,-1],[-1,-1]]
// 输出：3
//
//
// 示例 4：
//
// 输入：grid = [[-1]]
// 输出：1
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 100
// -100 <= grid[i][j] <= 100
//
// Related Topics 数组 二分查找
// 1351. 统计有序矩阵中的负数

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class CountNegativeNumbersInASortedMatrix {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        8,
        new Solution()
            .countNegatives(
                DataBuilder.buildDoubleArray("[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]")));
    Printer.printCorrectAnswer(
        0, new Solution().countNegatives(DataBuilder.buildDoubleArray("[[3,2],[1,0]]")));
    Printer.printCorrectAnswer(
        3, new Solution().countNegatives(DataBuilder.buildDoubleArray("[[1,-1],[-1,-1]]")));
    Printer.printCorrectAnswer(
        1, new Solution().countNegatives(DataBuilder.buildDoubleArray("[[-1]]")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 45.70% 的用户
     *
     * <p>内存消耗： 40 MB , 在所有 Java 提交中击败了 94.19% 的用户
     *
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
      int count = 0;
      for (int i = grid.length - 1; i >= 0; i--) {
        for (int j = grid[i].length - 1; j >= 0; j--) {
          if (grid[i][j] < 0) count++;
          else break;
        }
      }
      return count;
    }
  }
}
