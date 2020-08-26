// Given an integer n and an integer array rounds. We have a circular track which
// consists of n sectors labeled from 1 to n. A marathon will be held on this trac
// k, the marathon consists of m rounds. The ith round starts at sector rounds[i -
// 1] and ends at sector rounds[i]. For example, round 1 starts at sector rounds[0]
// and ends at sector rounds[1]
//
// Return an array of the most visited sectors sorted in ascending order.
//
// Notice that you circulate the track in ascending order of sector numbers in t
// he counter-clockwise direction (See the first example).
//
//
// Example 1:
//
//
// Input: n = 4, rounds = [1,3,1,2]
// Output: [1,2]
// Explanation: The marathon starts at sector 1. The order of the visited sectors
// is as follows:
// 1 --> 2 --> 3 (end of round 1) --> 4 --> 1 (end of round 2) --> 2 (end of roun
// d 3 and the marathon)
// We can see that both sectors 1 and 2 are visited twice and they are the most v
// isited sectors. Sectors 3 and 4 are visited only once.
//
// Example 2:
//
//
// Input: n = 2, rounds = [2,1,2,1,2,1,2,1,2]
// Output: [2]
//
//
// Example 3:
//
//
// Input: n = 7, rounds = [1,3,5,7]
// Output: [1,2,3,4,5,6,7]
//
//
//
// Constraints:
//
//
// 2 <= n <= 100
// 1 <= m <= 100
// rounds.length == m + 1
// 1 <= rounds[i] <= n
// rounds[i] != rounds[i + 1] for 0 <= i < m
//
// Related Topics Array
// 1560. 圆形赛道上经过次数最多的扇区

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorInACircularTrack {
  public static void main(String[] args) {
    Printer.printIntegerList(new Solution().mostVisited(4, DataBuilder.buildIntArray("1,3,1,2")));
    Printer.printIntegerList(
        new Solution().mostVisited(2, DataBuilder.buildIntArray("2,1,2,1,2,1,2,1,2")));
  }

  static class Solution {
    /**
     * 题目 仔细分析可以发现, 中间部分对结果完全没影响, 中间不管有多少个值多少圈, 对于每个扇区增加的次数都是相同的 所以我们可以只考虑起点和终点, 简化为一圈的情况,
     * 这一圈经过的扇区是额外的部分, 最终结果只需要考虑起点和终点途径的扇区即可 注意终点可能小于起点, 这时候就要先从 1 到终点, 再从起点遍历到 n 即可(因为最终结果要按顺序)
     *
     * <p>执行用时： 1 ms , 在所有 Java 提交中击败了 99.92% 的用户
     *
     * <p>内存消耗： 39.7 MB , 在所有 Java 提交中击败了 96.05% 的用户
     *
     * @param n
     * @param rounds
     * @return
     */
    public List<Integer> mostVisited(int n, int[] rounds) {
      int start = rounds[0];
      int end = rounds[rounds.length - 1];
      List<Integer> list = new ArrayList<>();
      if (start <= end) { // [起点， 终点]
        for (int i = start; i <= end; i++) list.add(i);
      } else { // [1, 终点] [起点, n]
        for (int i = 1; i <= end; i++) list.add(i);
        for (int i = start; i <= n; i++) list.add(i);
      }
      return list;
    }
  }
}
