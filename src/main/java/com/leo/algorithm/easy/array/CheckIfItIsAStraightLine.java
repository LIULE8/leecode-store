// 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为
// x、纵坐标为 y 的点。
//
// 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
//
//
//
// 示例 1：
//
//
//
// 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
// 输出：true
//
//
// 示例 2：
//
//
//
// 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
// 输出：false
//
//
//
//
// 提示：
//
//
// 2 <= coordinates.length <= 1000
// coordinates[i].length == 2
// -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
// coordinates 中不含重复的点
//
// Related Topics 几何 数组 数学
// 1232. 缀点成线

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class CheckIfItIsAStraightLine {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .checkStraightLine(
                DataBuilder.buildDoubleArray("[[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]")));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .checkStraightLine(
                DataBuilder.buildDoubleArray("[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]")));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .checkStraightLine(
                DataBuilder.buildDoubleArray("[[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]")));
    Printer.printCorrectAnswer(
        true,
        new Solution().checkStraightLine(DataBuilder.buildDoubleArray("[[0,0],[0,1],[0,-1]]")));
    Printer.printCorrectAnswer(
        false,
        new Solution().checkStraightLine(DataBuilder.buildDoubleArray("[[1,-8],[2,-3],[1,2]]")));
  }

  static class Solution {
    /**
     * 叉积为0共线: x1y2 - x2y1 == 0
     *
     * <p>执行用时： 1 ms , 在所有 Java 提交中击败了 8.65% 的用户
     *
     * <p>内存消耗： 39.8 MB , 在所有 Java 提交中击败了 5.00% 的用户
     *
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
      if (coordinates.length <= 2 && coordinates.length > 0) return true;
      int[][] vectors = new int[coordinates.length - 1][2];
      for (int i = 1; i < coordinates.length; i++) {
        vectors[i - 1][0] = coordinates[i][0] - coordinates[i - 1][0];
        vectors[i - 1][1] = coordinates[i][1] - coordinates[i - 1][1];
      }
      int i = 1;
      while (i < vectors.length
          && vectors[i][0] * vectors[i - 1][1] == vectors[i][1] * vectors[i - 1][0]) i++;
      return i >= vectors.length;
    }
  }
}
