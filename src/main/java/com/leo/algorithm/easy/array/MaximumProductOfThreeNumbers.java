// 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
// 示例 1:
//
//
// 输入: [1,2,3]
// 输出: 6
//
//
// 示例 2:
//
//
// 输入: [1,2,3,4]
// 输出: 24
//
//
// 注意:
//
//
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
//
// Related Topics 数组 数学
// 628. 三个数的最大乘积

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "24", new Solution().maximumProduct(DataBuilder.buildIntArray("1,2,3,4")));
    Printer.printCorrectAnswer(
        "6", new Solution().maximumProduct(DataBuilder.buildIntArray("1,2,3")));
    Printer.printCorrectAnswer(
        "-6", new Solution().maximumProduct(DataBuilder.buildIntArray("-1,-2,-3")));
    Printer.printCorrectAnswer(
        "-6", new Solution().maximumProduct(DataBuilder.buildIntArray("-4,-3,-2,-1")));
    Printer.printCorrectAnswer(
        "720", new Solution().maximumProduct(DataBuilder.buildIntArray("-4,-3,-2,-1,60")));
  }

  static class Solution {

    public int maximumProduct(int[] nums) {
      return method1(nums);
    }


    /**
     * 超时
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      Arrays.sort(nums);
      int maxMulti = nums[0] * maximumProductOfTwoNumbers(nums, 1, nums[0] < 0);
      for (int i = 1; i < nums.length - 2; i++) {
        int temp = nums[i] * maximumProductOfTwoNumbers(nums, i + 1, nums[i] < 0);
        if (maxMulti < temp) {
          maxMulti = temp;
        }
        // 排除第三个数字重复
        while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
      }
      return maxMulti;
    }

    private int maximumProductOfTwoNumbers(int[] nums, int start, boolean sign) {
      int multi = nums[start] * nums[start + 1];
      for (int i = start; i < nums.length - 1; i++) {
        for (int j = start + 1; j < nums.length; j++) {
          int temp = nums[i] * nums[j];
          if (!sign && multi < temp) {
            multi = temp;
          } else if (sign && multi > temp) {
            multi = temp;
          }
        }
      }
      return multi;
    }
  }
}
