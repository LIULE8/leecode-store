// 给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
//
// 模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。
//
// 如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回 false 。
//
//
//
// 示例 1：
//
// 输入：arr = [1,2,4,4,4,4], m = 1, k = 3
// 输出：true
// 解释：模式 (4) 的长度为 1 ，且连续重复 4 次。注意，模式可以重复 k 次或更多次，但不能少于 k 次。
//
//
// 示例 2：
//
// 输入：arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
// 输出：true
// 解释：模式 (1,2) 长度为 2 ，且连续重复 2 次。另一个符合题意的模式是 (2,1) ，同样重复 2 次。
//
//
// 示例 3：
//
// 输入：arr = [1,2,1,2,1,3], m = 2, k = 3
// 输出：false
// 解释：模式 (1,2) 长度为 2 ，但是只连续重复 2 次。不存在长度为 2 且至少重复 3 次的模式。
//
//
// 示例 4：
//
// 输入：arr = [1,2,3,1,2], m = 2, k = 2
// 输出：false
// 解释：模式 (1,2) 出现 2 次但并不连续，所以不能算作连续重复 2 次。
//
//
// 示例 5：
//
// 输入：arr = [2,2,2,2], m = 2, k = 3
// 输出：false
// 解释：长度为 2 的模式只有 (2,2) ，但是只连续重复 2 次。注意，不能计算重叠的重复次数。
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 100
// 1 <= arr[i] <= 100
// 1 <= m <= 100
// 2 <= k <= 100
//
// Related Topics 数组
// 1566. 重复至少 K 次且长度为 M 的模式

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class DetectPatternOfLengthMRepeatedKOrMoreTimes {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .containsPattern(DataBuilder.buildIntArray("3,2,2,1,2,2,1,1,1,2,3,2,2"), 3, 2));
    Printer.printCorrectAnswer(
        true, new Solution().containsPattern(DataBuilder.buildIntArray("1,2,4,4,4,4"), 1, 3));
    Printer.printCorrectAnswer(
        false, new Solution().containsPattern(DataBuilder.buildIntArray("1,2,3,1,2"), 2, 2));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .containsPattern(
                DataBuilder.buildIntArray("6,3,5,5,5,5,1,5,6,2,5,1,2,5,3,5,1,3,5,5,6,4,1,2"),
                1,
                5));
    Printer.printCorrectAnswer(
        true, new Solution().containsPattern(DataBuilder.buildIntArray("1,2,1,2,1,1,1,3"), 2, 2));
    Printer.printCorrectAnswer(
        false, new Solution().containsPattern(DataBuilder.buildIntArray("1,2,1,2,1,3"), 2, 3));
    Printer.printCorrectAnswer(
        false, new Solution().containsPattern(DataBuilder.buildIntArray("2,2,2,2"), 2, 3));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .containsPattern(
                DataBuilder.buildIntArray("3,6,6,6,5,1,5,2,2,3,1,5,2,6,1,5,1,2,6,3,3,5,3,6,3,4"),
                6,
                2));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 44.84% 的用户
     *
     * <p>内存消耗： 39.5 MB , 在所有 Java 提交中击败了 8.33% 的用户
     *
     * @param arr
     * @param m
     * @param k
     * @return
     */
    public boolean containsPattern(int[] arr, int m, int k) {
      int count = 1;
      String s = getString(arr, m, 0);
      for (int i = m; i + m - 1 < arr.length; i += m) {
        String tempS = getString(arr, m, i);
        if (s.equals(tempS)) {
          count++;
          if (count >= k) return true;
        } else {
          count = 1;
          i = i + 1 - m;
          s = getString(arr, m, i);
        }
      }
      return count >= k;
    }

    private String getString(int[] arr, int m, int start) {
      StringBuilder sb = new StringBuilder();
      for (int i = start; i < m + start && i < arr.length; i++) {
        sb.append(arr[i]);
      }
      return sb.toString();
    }
  }
}
