// 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
// 判断数组中是否含有该整数。
//
//
//
// 示例:
//
// 现有矩阵 matrix 如下：
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
// ]
//
//
// 给定 target = 5，返回 true。
//
// 给定 target = 20，返回 false。
//
//
//
// 限制：
//
// 0 <= n <= 1000
//
// 0 <= m <= 1000
//
//
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
// Related Topics 数组 双指针
// 剑指 Offer 04. 二维数组中的查找

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ErWeiShuZuZhongDeChaZhaoLcof {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .findNumberIn2DArray(
                DataBuilder.buildDoubleArray(
                    "[[1,4,7, 11, 15], [2,   5,  8, 12, 19],[3,   6,  9, 16, 22],[10, 13, 14,17, 24],[18, 21, 23, 26, 30]]"),
                20));
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .findNumberIn2DArray(
                DataBuilder.buildDoubleArray(
                    "[[1,4,7, 11, 15], [2,   5,  8, 12, 19],[3,   6,  9, 16, 22],[10, 13, 14, 17, 24],[18, 21, 23, 26, 30]]"),
                5));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 45.5 MB , 在所有 Java 提交中击败了 71.31% 的用户
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
      for (int[] nums : matrix) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
          int mid = l + ((r - l) >> 1);
          if (nums[mid] == target) return true;
          else if (target < nums[mid]) r = mid - 1;
          else l = mid + 1;
        }
      }
      return false;
    }
  }
}
