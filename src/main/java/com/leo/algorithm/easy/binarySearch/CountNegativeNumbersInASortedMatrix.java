// 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
//
// 请你统计并返回 grid 中 负数 的数目。
//
//
//
// 示例 1：
//
//
// 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
// 输出：8
// 解释：矩阵中共有 8 个负数。
//
//
// 示例 2：
//
//
// 输入：grid = [[3,2],[1,0]]
// 输出：0
//
//
// 示例 3：
//
//
// 输入：grid = [[1,-1],[-1,-1]]
// 输出：3
//
//
// 示例 4：
//
//
// 输入：grid = [[-1]]
// 输出：1
//
//
//
// 1351. 统计有序矩阵中的负数
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 100
// -100 <= grid[i][j] <= 100
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？
//
//
// Related Topics 数组 二分查找
// 👍 59 👎 0

package com.leo.algorithm.easy.binarySearch;

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

    public int countNegatives(int[][] grid) {
      //      return method1(grid);
      return method2(grid);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 29.40% 的用户
     *
     * @param grid
     * @return
     */
    private int method2(int[][] grid) {
      int count = 0;
      for (int[] ints : grid) {
        int low = 0, high = ints.length - 1, pos = -1;
        while (low <= high) {
          int mid = low + ((high - low) >> 1);
          if (ints[mid] < 0) {
            pos = mid;
            high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
        if (pos != -1) {
          count += (ints.length - pos);
        }
      }
      return count;
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 39.56% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 31.92% 的用户
     *
     * @param grid
     * @return
     */
    private int method1(int[][] grid) {
      int count = 0;
      for (int[] ints : grid) {
        int low = 0;
        int high = ints.length - 1;
        while (low <= high) {
          int mid = low + ((high - low) >> 1);
          if (ints[mid] < 0) {
            int temp = mid;
            while (temp <= high && ints[temp++] < 0) count++;
            while (mid - 1 >= low && ints[--mid] < 0) count++;
            break;
          } else if (mid + 1 < high && ints[mid] < ints[mid + 1]) {
            high = mid - 1;
          } else {
            low = mid + 1;
          }
        }
      }
      return count;
    }
  }
}
