// 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
//
// 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
//
// 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈
// 顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
//
//
//
// 示例 1：
//
// 输入：R = 1, C = 2, r0 = 0, c0 = 0
// 输出：[[0,0],[0,1]]
// 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
//
//
// 示例 2：
//
// 输入：R = 2, C = 2, r0 = 0, c0 = 1
// 输出：[[0,1],[0,0],[1,1],[1,0]]
// 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
// [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
//
//
// 示例 3：
//
// 输入：R = 2, C = 3, r0 = 1, c0 = 2
// 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
// 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
// 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
//
//
//
//
// 提示：
//
//
// 1 <= R <= 100
// 1 <= C <= 100
// 0 <= r0 < R
// 0 <= c0 < C
//
// Related Topics 排序
// 1030. 距离顺序排列矩阵单元格

package com.leo.algorithm.easy.order;

import com.leo.algorithm.utils.Printer;

import java.util.*;

public class MatrixCellsInDistanceOrder {
  public static void main(String[] args) {
    Printer.printDoubleArray(new Solution().allCellsDistOrder(80, 57, 19, 38));
    Printer.printDoubleArray(new Solution().allCellsDistOrder(1, 2, 0, 0));
    Printer.printDoubleArray(new Solution().allCellsDistOrder(2, 2, 0, 1));
    Printer.printDoubleArray(new Solution().allCellsDistOrder(2, 3, 1, 2));
  }

  static class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
      return method1(R, C, r0, c0);
    }

    /**
     * 执行用时： 29 ms , 在所有 Java 提交中击败了 6.16% 的用户
     *
     * <p>内存消耗： 41 MB , 在所有 Java 提交中击败了 12.81% 的用户
     *
     * @param r
     * @param c
     * @param r0
     * @param c0
     * @return
     */
    private int[][] method1(int r, int c, int r0, int c0) {
      Map<Integer, List<Integer>> dist = new TreeMap<>(Comparator.comparingInt(o -> o));
      for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
          int key = Math.abs(r0 - i) + Math.abs(c0 - j);
          if (dist.containsKey(key)) {
            dist.get(key).add(i * 1000 + j);
            continue;
          }
          List<Integer> list = new ArrayList<>();
          list.add(i * 1000 + j);
          dist.put(key, list);
        }
      }
      int[][] res = new int[r * c][2];
      int k = 0;
      for (Map.Entry<Integer, List<Integer>> entry : dist.entrySet()) {
        for (Integer num : entry.getValue()) {
          res[k++] = new int[] {num / 1000, num % 1000};
        }
      }
      return res;
    }
  }
}
