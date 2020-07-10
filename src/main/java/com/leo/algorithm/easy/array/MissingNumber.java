// 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//
//
//
// 示例 1:
//
// 输入: [3,0,1]
// 输出: 2
//
//
// 示例 2:
//
// 输入: [9,6,4,2,3,5,7,0,1]
// 输出: 8
//
//
//
//
// 说明:
// 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
// Related Topics 位运算 数组 数学
// 268. 缺失数字
package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class MissingNumber {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("1", new Solution().missingNumber(DataBuilder.buildIntArray("0")));
    Printer.printCorrectAnswer(
        "8", new Solution().missingNumber(DataBuilder.buildIntArray("9,6,4,2,3,5,7,0,1")));
    Printer.printCorrectAnswer(
        "9", new Solution().missingNumber(DataBuilder.buildIntArray("8,6,4,2,3,5,7,0,1")));
    Printer.printCorrectAnswer(
        "2", new Solution().missingNumber(DataBuilder.buildIntArray("3,0,1")));
  }

  static class Solution {
    public int missingNumber(int[] nums) {
      return method1(nums);
    }

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 11.29% 的用户
     *
     * <p>内存消耗： 40.5 MB , 在所有 Java 提交中击败了 6.67% 的用户
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      if (nums == null || nums.length == 0) return -1;
      Arrays.sort(nums);
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i) {
          return i;
        }
      }
      return nums.length;
    }
  }
}
