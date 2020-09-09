// 环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号
// 为 (i + 1) % n 的车站之间的距离。
//
// 环线上的公交车都可以按顺时针和逆时针的方向行驶。
//
// 返回乘客从出发点 start 到目的地 destination 之间的最短距离。
//
//
//
// 示例 1：
//
//
//
// 输入：distance = [1,2,3,4], start = 0, destination = 1
// 输出：1
// 解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
//
//
//
// 示例 2：
//
//
//
// 输入：distance = [1,2,3,4], start = 0, destination = 2
// 输出：3
// 解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。
//
//
//
//
// 示例 3：
//
//
//
// 输入：distance = [1,2,3,4], start = 0, destination = 3
// 输出：4
// 解释：公交站 0 和 3 之间的距离是 6 或 4，最小值是 4。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10^4
// distance.length == n
// 0 <= start, destination < n
// 0 <= distance[i] <= 10^4
//
// Related Topics 数组
// 1184. 公交站间的距离

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class DistanceBetweenBusStops {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        1, new Solution().distanceBetweenBusStops(DataBuilder.buildIntArray("1,2,3,4"), 0, 1));
    Printer.printCorrectAnswer(
        3, new Solution().distanceBetweenBusStops(DataBuilder.buildIntArray("1,2,3,4"), 0, 2));
    Printer.printCorrectAnswer(
        4, new Solution().distanceBetweenBusStops(DataBuilder.buildIntArray("1,2,3,4"), 0, 3));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.5 MB , 在所有 Java 提交中击败了 70.29% 的用户
     *
     * @param distance
     * @param start
     * @param destination
     * @return
     */
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
      if (start < destination) {
        int a = firstDistance(distance, start, destination); // start -> destination
        int b = secondDistance(distance, start, destination); // 0 -> start   destination <- length
        return Math.min(a, b);
      }
      int a = firstDistance(distance, destination, start); // destination -> start
      int b = secondDistance(distance, destination, start); // 0 -> destination   start <- length
      return Math.min(a, b);
    }

    private int firstDistance(int[] distance, int start, int destination) {
      int sum = 0;
      for (int i = start; i < destination; i++) {
        sum += distance[i];
      }
      return sum;
    }

    private int secondDistance(int[] distance, int start, int destination) {
      int sum = 0;
      for (int i = 0; i < start; i++) {
        sum += distance[i];
      }
      for (int i = destination; i < distance.length; i++) {
        sum += distance[i];
      }
      return sum;
    }
  }
}
