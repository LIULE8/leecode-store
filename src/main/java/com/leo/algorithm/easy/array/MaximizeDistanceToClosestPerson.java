// 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
//
// 至少有一个空座位，且至少有一人坐在座位上。
//
// 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
//
// 返回他到离他最近的人的最大距离。
//
//
//
// 示例 1：
//
// 输入：[1,0,0,0,1,0,1]
// 输出：2
// 解释：
// 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
// 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
// 因此，他到离他最近的人的最大距离是 2 。
//
//
// 示例 2：
//
// 输入：[1,0,0,0]
// 输出：3
// 解释：
// 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
// 这是可能的最大距离，所以答案是 3 。
//
//
//
//
// 提示：
//
//
// 2 <= seats.length <= 20000
// seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
//
// Related Topics 数组
// 849. 到最近的人的最大距离

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MaximizeDistanceToClosestPerson {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        2, new Solution().maxDistToClosest(DataBuilder.buildIntArray("1,0,0,0,1,0,1")));
    Printer.printCorrectAnswer(
        3, new Solution().maxDistToClosest(DataBuilder.buildIntArray("1,0,0,0")));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 51.67% 的用户
     *
     * <p>内存消耗： 41.8 MB , 在所有 Java 提交中击败了 55.43% 的用户
     *
     * @param seats
     * @return
     */
    public int maxDistToClosest(int[] seats) {
      int prev = -1; // 上一个1的下标
      int max = 1; // 最大距离, 也是0的最大个数
      for (int i = 0; i < seats.length; i++) {
        // 遇到 1
        if (seats[i] == 1) {
          if (prev >= 0) max = Math.max((i - prev) >> 1, max); // 之前已经遇到1了， 需要除以2
          else max = i; // 没遇到1，不需要除2
          prev = i;
        }
      }
      return Math.max(seats.length - 1 - prev, max);
    }
  }
}
