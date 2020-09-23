// 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
// ]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划
// 120. 三角形最小路径和

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.List;

public class Triangle {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "11",
        new Solution().minimumTotal(DataBuilder.buildDoubleIntegerList("[[2],[3,4],[6,5,7],[4,1,8,3]]")));
    Printer.printCorrectAnswer(
        "-1", new Solution().minimumTotal(DataBuilder.buildDoubleIntegerList("[[-1],[2,3],[1,-1,-3]]")));
    Printer.printCorrectAnswer(
        "12", new Solution().minimumTotal(DataBuilder.buildDoubleIntegerList("[[2],[3,4],[6,7,5],[4,1,8,3]]")));
  }

  static class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
      return method1(triangle);
    }

    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 21.34% 的用户
     *
     * <p>内存消耗： 40 MB , 在所有 Java 提交中击败了 8.70% 的用户
     *
     * @param triangle
     * @return
     */
    private int method1(List<List<Integer>> triangle) {
      for (int i = triangle.size() - 2; i >= 0; i--) {
        List<Integer> lastRows = triangle.get(i);
        for (int j = 0; j < lastRows.size(); j++) {
          List<Integer> currentRows = triangle.get(i + 1);
          lastRows.set(j, lastRows.get(j) + Math.min(currentRows.get(j), currentRows.get(j + 1)));
        }
      }
      return triangle.get(0).get(0);
    }
  }
}
