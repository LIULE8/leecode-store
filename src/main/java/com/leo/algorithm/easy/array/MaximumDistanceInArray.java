package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.List;

// 给定 m 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b|
//  。你的任务就是去找到最大距离
//
// 示例 1：
//
// 输入：
// [[1,2,3],
// [4,5],
// [1,2,3]]
// 输出： 4
// 解释：
// 一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
//
//
// 注意：
//
// 每个给定数组至少会有 1 个数字。列表中至少有两个非空数组。
// 所有 m 个数组中的数字总数目在范围 [2, 10000] 内。
// m 个数组中所有整数的范围在 [-10000, 10000] 内。
// 624. 数组列表中的最大距离

public class MaximumDistanceInArray {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        4, new Solution().maxDistance(DataBuilder.buildDoubleList("[[1,2,3],[4,5],[1,2,3]]")));
    Printer.printCorrectAnswer(
        1, new Solution().maxDistance(DataBuilder.buildDoubleList("[[1],[2]]")));
    Printer.printCorrectAnswer(
        14,
        new Solution()
            .maxDistance(
                DataBuilder.buildDoubleList(
                    "[[-8,-7,-7,-5,1,1,3,4],[-2],[-10,-10,-7,0,1,3],[2]]")));
  }

  static class Solution {
    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 22.30% 的用户
     *
     * <p>内存消耗： 41.2 MB , 在所有 Java 提交中击败了 73.91% 的用户
     *
     * @param arrays
     * @return
     */
    public int maxDistance(List<List<Integer>> arrays) {
      int min = arrays.get(0).get(0);
      int max = arrays.get(0).get(arrays.get(0).size() - 1);
      int result = 0;
      for (int i = 1; i < arrays.size(); i++) {
        List<Integer> array = arrays.get(i);
        if (array == null || array.size() == 0) continue;
        result = Math.max(result, Math.abs(min - array.get(0)));
        result = Math.max(result, Math.abs(min - array.get(array.size() - 1)));
        result = Math.max(result, Math.abs(max - array.get(array.size() - 1)));
        result = Math.max(result, Math.abs(max - array.get(0)));
        min = Math.min(array.get(0), min);
        max = Math.max(array.get(array.size() - 1), max);
      }
      return result;
    }
  }
}
