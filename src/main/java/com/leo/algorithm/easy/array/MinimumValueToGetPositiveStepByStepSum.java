// 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
//
// 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
//
// 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [-3,2,-3,4,2]
// 输出：5
// 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
//                累加求和
//                 startValue = 4 | startValue = 5 | nums
//                   (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
//                   (1 +2 ) = 3  | (2 +2 ) = 4    |   2
//                   (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
//                   (0 +4 ) = 4  | (1 +4 ) = 5    |   4
//                   (4 +2 ) = 6  | (5 +2 ) = 7    |   2
//
//
// 示例 2：
//
//
// 输入：nums = [1,2]
// 输出：1
// 解释：最小的 startValue 需要是正数。
//
//
// 示例 3：
//
//
// 输入：nums = [1,-2,-3]
// 输出：5
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// -100 <= nums[i] <= 100
//
// Related Topics 数组
// 1413. 逐步求和得到正数的最小值

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MinimumValueToGetPositiveStepByStepSum {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        5, new Solution().minStartValue(DataBuilder.buildIntArray("-3,2,-3,4,2")));
    Printer.printCorrectAnswer(1, new Solution().minStartValue(DataBuilder.buildIntArray("1,2")));
    Printer.printCorrectAnswer(
        8, new Solution().minStartValue(DataBuilder.buildIntArray("-5,-2,4,4,-2")));
    Printer.printCorrectAnswer(
        5, new Solution().minStartValue(DataBuilder.buildIntArray("1,-2,-3")));
    Printer.printCorrectAnswer(
        1, new Solution().minStartValue(DataBuilder.buildIntArray("2,3,5,-5,-1")));
  }

  static class Solution {

    public int minStartValue(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.3 MB , 在所有 Java 提交中击败了 13.71% 的用户
     *
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
      if (nums == null || nums.length == 0) return 1;
      int startValue = 1, sum = 0;
      for (int num : nums) {
        sum += num;
        if (sum + startValue < 1) {
          startValue = (1 - sum);
        }
      }
      return startValue;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.1 MB , 在所有 Java 提交中击败了 54.03% 的用户
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      if (nums == null || nums.length == 0) return 1;
      int result = 0, tempResult = result;
      for (int i = 0; i < nums.length; i++) {
        tempResult += nums[i];
        if (tempResult < 1) {
          result += (1 - tempResult);
          i = -1;
          tempResult = result;
        }
      }
      return Math.max(result, 1);
    }
  }
}
