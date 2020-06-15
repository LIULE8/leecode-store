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

package com.leo.easy.array;

import com.leo.utils.DataBuilder;

public class MaximumProductOfThreeNumbers {
  public static void main(String[] args) {
    System.out.println(new Solution().maximumProduct(DataBuilder.buildIntArray("1,2,3,4"))); // 24
    System.out.println(new Solution().maximumProduct(DataBuilder.buildIntArray("1,2,3"))); // 6
    System.out.println(new Solution().maximumProduct(DataBuilder.buildIntArray("-1,-2,-3"))); // -6
    System.out.println(
        new Solution().maximumProduct(DataBuilder.buildIntArray("-4,-3,-2,-1,60"))); // 720
    System.out.println(
        new Solution().maximumProduct(DataBuilder.buildIntArray("-4,-3,-2,-1"))); // -6
  }

  static class Solution {
    public int maximumProduct(int[] nums) {
      return method1(nums);
    }

    /**
     * 冒泡前N个
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < nums.length - 1 - i; j++) {
          int absNums = Math.abs(nums[j]);
          int absNextNums = Math.abs(nums[j + 1]);
          if (absNums > absNextNums) {
            int temp = nums[j];
            nums[j] = nums[j + 1];
            nums[j + 1] = temp;
          }
        }
      }
      return nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
    }
  }
}
