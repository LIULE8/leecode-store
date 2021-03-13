// 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
//
// 如果不能形成任何面积不为零的三角形，返回 0。
//
//
//
//
//
//
// 示例 1：
//
// 输入：[2,1,2]
// 输出：5
//
//
// 示例 2：
//
// 输入：[1,2,1]
// 输出：0
//
//
// 示例 3：
//
// 输入：[3,2,3,4]
// 输出：10
//
//
// 示例 4：
//
// 输入：[3,6,2,3]
// 输出：8
//
//
//
//
// 提示：
//
//
// 3 <= A.length <= 10000
// 1 <= A[i] <= 10^6
//
// Related Topics 排序 数学
// 976. 三角形的最大周长

package com.leo.algorithm.easy.order;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class LargestPerimeterTriangle {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        5, new Solution().largestPerimeter(DataBuilder.buildIntArray("2,1,2")));
    Printer.printCorrectAnswer(
        0, new Solution().largestPerimeter(DataBuilder.buildIntArray("1,2,1")));
    Printer.printCorrectAnswer(
        10, new Solution().largestPerimeter(DataBuilder.buildIntArray("3,2,3,4")));
    Printer.printCorrectAnswer(
        8, new Solution().largestPerimeter(DataBuilder.buildIntArray("3,6,2,3")));
  }

  static class Solution {
    /**
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 95.75% 的用户
     *
     * <p>内存消耗： 38.9 MB , 在所有 Java 提交中击败了 78.59% 的用户
     *
     * @param nums
     * @return
     */
    public int largestPerimeter(int[] nums) {
      Arrays.sort(nums);
      int third = nums[nums.length - 1];
      for (int i = nums.length - 2; i > 0; i--) {
        int sum = nums[i] + nums[i - 1];
        if (third < sum) return sum + third;
        else third = nums[i];
      }
      return 0;
    }
  }
}
