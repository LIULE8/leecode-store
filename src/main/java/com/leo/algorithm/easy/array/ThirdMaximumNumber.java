// 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
//
// 示例 1:
//
//
// 输入: [3, 2, 1]
//
// 输出: 1
//
// 解释: 第三大的数是 1.
//
//
// 示例 2:
//
//
// 输入: [1, 2]
//
// 输出: 2
//
// 解释: 第三大的数不存在, 所以返回最大的数 2 .
//
//
// 示例 3:
//
//
// 输入: [2, 2, 3, 1]
//
// 输出: 1
//
// 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
// 存在两个值为2的数，它们都排第二。
//
// Related Topics 数组
// 414. 第三大的数

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class ThirdMaximumNumber {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(1, new Solution().thirdMax(DataBuilder.buildIntArray("3, 2, 1")));
    Printer.printCorrectAnswer(2, new Solution().thirdMax(DataBuilder.buildIntArray("1, 2")));
    Printer.printCorrectAnswer(1, new Solution().thirdMax(DataBuilder.buildIntArray("2, 2, 3, 1")));
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 65.44% 的用户
     *
     * <p>内存消耗： 39.6 MB , 在所有 Java 提交中击败了 69.01% 的用户
     *
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      Arrays.sort(nums);
      int count = 0;
      for (int i = nums.length - 1; i > 0; i--) {
        if (nums[i] > nums[i - 1]) {
          count++;
          if (count == 2) {
            return nums[i - 1];
          }
        }
      }
      return nums[nums.length - 1];
    }
  }
}
