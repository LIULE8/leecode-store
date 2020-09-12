// 给你一个数字数组 arr 。
//
// 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
//
// 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
// 输入：arr = [3,5,1]
// 输出：true
// 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
//
//
// 示例 2：
//
// 输入：arr = [1,2,4]
// 输出：false
// 解释：无法通过重新排序得到等差数列。
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 1000
// -10^6 <= arr[i] <= 10^6
//
// Related Topics 排序 数组
// 1502. 判断能否形成等差数列

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class CanMakeArithmeticProgressionFromSequence {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true, new Solution().canMakeArithmeticProgression(DataBuilder.buildIntArray("3,5,1")));
    Printer.printCorrectAnswer(
        false, new Solution().canMakeArithmeticProgression(DataBuilder.buildIntArray("1,2,4")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.26% 的用户
     *
     * <p>内存消耗： 39.5 MB , 在所有 Java 提交中击败了 16.10% 的用户
     *
     * @param arr
     * @return
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
      if (arr.length == 2) return true;
      Arrays.sort(arr);
      int diff = arr[1] - arr[0];
      for (int i = 1; i < arr.length - 1; i++) {
        if (arr[i + 1] - arr[i] != diff) return false;
      }
      return true;
    }
  }
}
