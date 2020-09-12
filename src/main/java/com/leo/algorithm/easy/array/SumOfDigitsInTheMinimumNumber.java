// 给你一个正整数的数组 A。
//
// 然后计算 S，使其等于数组 A 当中最小的那个元素各个数位上数字之和。
//
// 最后，假如 S 所得计算结果是 奇数 的请你返回 0，否则请返回 1。
//
//
//
// 示例 1:
//
// 输入：[34,23,1,24,75,33,54,8]
// 输出：0
// 解释：
// 最小元素为 1，该元素各个数位上的数字之和 S = 1，是奇数所以答案为 0。
//
//
// 示例 2：
//
// 输入：[99,77,33,66,55]
// 输出：1
// 解释：
// 最小元素为 33，该元素各个数位上的数字之和 S = 3 + 3 = 6，是偶数所以答案为 1。
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 100
// 1 <= A[i].length <= 100
//
// Related Topics 数组
// 1085. 最小元素各数位之和

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class SumOfDigitsInTheMinimumNumber {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        0, new Solution().sumOfDigits(DataBuilder.buildIntArray("34,23,1,24,75,33,54,8")));
    Printer.printCorrectAnswer(
        1, new Solution().sumOfDigits(DataBuilder.buildIntArray("99,77,33,66,55")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 25.19% 的用户
     *
     * <p>内存消耗： 37.6 MB , 在所有 Java 提交中击败了 37.14% 的用户
     *
     * @param A
     * @return
     */
    public int sumOfDigits(int[] A) {
      Arrays.sort(A);
      int k = A[0];
      int sum = 0;
      while (k != 0) {
        sum += k % 10;
        k /= 10;
      }
      return sum % 2 == 0 ? 1 : 0;
    }
  }
}
