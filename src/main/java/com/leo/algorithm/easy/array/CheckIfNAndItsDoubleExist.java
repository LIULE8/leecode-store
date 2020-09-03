// 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
//
// 更正式地，检查是否存在两个下标 i 和 j 满足：
//
//
// i != j
// 0 <= i, j < arr.length
// arr[i] == 2 * arr[j]
//
//
//
//
// 示例 1：
//
// 输入：arr = [10,2,5,3]
// 输出：true
// 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
//
//
// 示例 2：
//
// 输入：arr = [7,1,14,11]
// 输出：true
// 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
//
//
// 示例 3：
//
// 输入：arr = [3,1,7,11]
// 输出：false
// 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 500
// -10^3 <= arr[i] <= 10^3
//
// Related Topics 数组
// 1346. 检查整数及其两倍数是否存在

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true, new Solution().checkIfExist(DataBuilder.buildIntArray("10,2,5,3")));
    Printer.printCorrectAnswer(
        true, new Solution().checkIfExist(DataBuilder.buildIntArray("7,1,14,11")));
    Printer.printCorrectAnswer(
        false, new Solution().checkIfExist(DataBuilder.buildIntArray("3,1,7,11")));
    Printer.printCorrectAnswer(
        true, new Solution().checkIfExist(DataBuilder.buildIntArray("-10,12,-20,-8,15")));
    Printer.printCorrectAnswer(
        true, new Solution().checkIfExist(DataBuilder.buildIntArray("-20,8,-6,-14,0,-19,14,4")));
    Printer.printCorrectAnswer(
        false, new Solution().checkIfExist(DataBuilder.buildIntArray("-2,0,10,-19,4,6,-8")));
    Printer.printCorrectAnswer(true, new Solution().checkIfExist(DataBuilder.buildIntArray("0,0")));
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 80.42% 的用户
     *
     * <p>内存消耗： 39.6 MB , 在所有 Java 提交中击败了 25.16% 的用户
     *
     * @param arr
     * @return
     */
    public boolean checkIfExist(int[] arr) {
      Set<Integer> set = new HashSet<>();
      for (int i : arr) {
        if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i >> 1))) return true;
        set.add(i);
      }
      return false;
    }
  }
}
