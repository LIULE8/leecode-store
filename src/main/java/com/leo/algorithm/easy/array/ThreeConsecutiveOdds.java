// 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
// 输入：arr = [2,6,4,1]
// 输出：false
// 解释：不存在连续三个元素都是奇数的情况。
//
//
// 示例 2：
//
// 输入：arr = [1,2,34,3,4,5,7,23,12]
// 输出：true
// 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 1000
// 1 <= arr[i] <= 1000
//
// Related Topics 数组
// 1550. 存在连续三个奇数的数组

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ThreeConsecutiveOdds {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        false, new Solution().threeConsecutiveOdds(DataBuilder.buildIntArray("2,6,4,1")));
    Printer.printCorrectAnswer(
        true,
        new Solution().threeConsecutiveOdds(DataBuilder.buildIntArray("1,2,34,3,4,5,7,23,12")));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.7 MB , 在所有 Java 提交中击败了 5.22% 的用户
     *
     * @param arr
     * @return
     */
    public boolean threeConsecutiveOdds(int[] arr) {
      for (int i = 0; i < arr.length - 2; i++) {
        if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
          return true;
        }
      }
      return false;
    }
  }
}
