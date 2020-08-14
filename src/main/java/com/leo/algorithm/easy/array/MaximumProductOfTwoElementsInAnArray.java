// 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
//
// 请你计算并返回该式的最大值。
//
//
//
// 示例 1：
//
// 输入：nums = [3,4,5,2]
// 输出：12
// 解释：如果选择下标 i=1 和 j=2（下标从 0 开始），则可以获得最大值，(nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) =
// 3*4 = 12 。
//
//
// 示例 2：
//
// 输入：nums = [1,5,4,5]
// 输出：16
// 解释：选择下标 i=1 和 j=3（下标从 0 开始），则可以获得最大值 (5-1)*(5-1) = 16 。
//
//
// 示例 3：
//
// 输入：nums = [3,7]
// 输出：12
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 500
// 1 <= nums[i] <= 10^3
//
// Related Topics 数组
// 1464. 数组中两元素的最大乘积

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class MaximumProductOfTwoElementsInAnArray {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(12, new Solution().maxProduct(DataBuilder.buildIntArray("3,4,5,2")));
    Printer.printCorrectAnswer(16, new Solution().maxProduct(DataBuilder.buildIntArray("1,5,4,5")));
    Printer.printCorrectAnswer(12, new Solution().maxProduct(DataBuilder.buildIntArray("3,7")));
  }

  static class Solution {
    public int maxProduct(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 65.08% 的用户
     *
     * <p>内存消耗： 39.3 MB , 在所有 Java 提交中击败了 69.40% 的用户
     *
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
      Arrays.sort(nums);
      return Math.max(
          (nums[0] - 1) * (nums[1] - 1), (nums[nums.length - 2] - 1) * (nums[nums.length - 1] - 1));
    }

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 16.81% 的用户
     *
     * <p>内存消耗： 39.3 MB , 在所有 Java 提交中击败了 77.83% 的用户
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < nums.length - 1; i++) {
        int a = nums[i] - 1;
        for (int j = i + 1; j < nums.length; j++) {
          int b = nums[j] - 1;
          int multi = a * b;
          max = Math.max(max, multi);
        }
      }
      return max;
    }
  }
}
