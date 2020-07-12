// 包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值
// 求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
//
// 示例 1:
//
//
// 输入:
// [[1,1,1],
// [1,0,1],
// [1,1,1]]
// 输出:
// [[0, 0, 0],
// [0, 0, 0],
// [0, 0, 0]]
// 解释:
// 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
// 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
// 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
//
//
// 注意:
//
//
// 给定矩阵中的整数范围为 [0, 255]。
// 矩阵的长和宽的范围均为 [1, 150]。
//
// Related Topics 数组
// 661. 图片平滑器

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ImageSmoother {
  public static void main(String[] args) {
    Printer.printDoubleArray(
        new Solution().imageSmoother(DataBuilder.buildDoubleArray("[[1,1,1],[1,0,1],[1,1,1]]")));
  }

  static class Solution {
    /**
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 61.09% 的用户
     *
     * <p>内存消耗： 40.4 MB , 在所有 Java 提交中击败了 71.43% 的用户
     *
     * @param M
     * @return
     */
    public int[][] imageSmoother(int[][] M) {
      if (M == null || M.length == 0) return new int[][] {};
      int R = M.length;
      int C = M[0].length;
      int[][] result = new int[R][C];
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          int count = 0;
          for (int nr = i - 1; nr <= i + 1; nr++) {
            for (int nc = j - 1; nc <= j + 1; nc++) {
              if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                result[i][j] += M[nr][nc];
                count++;
              }
            }
          }
          result[i][j] /= count;
        }
      }
      return result;
    }
  }
}
