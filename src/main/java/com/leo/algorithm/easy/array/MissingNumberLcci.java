// 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
//
// 注意：本题相对书上原题稍作改动
//
// 示例 1：
//
// 输入：[3,0,1]
// 输出：2
//
//
//
// 示例 2：
//
// 输入：[9,6,4,2,3,5,7,0,1]
// 输出：8
//
// Related Topics 位运算 数组 数学
// 面试题 17.04. 消失的数字

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MissingNumberLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(2, new Solution().missingNumber(DataBuilder.buildIntArray("3,0,1")));
    Printer.printCorrectAnswer(
        8, new Solution().missingNumber(DataBuilder.buildIntArray("9,6,4,2,3,5,7,0,1")));
    Printer.printCorrectAnswer(
        0, new Solution().missingNumber(DataBuilder.buildIntArray("9,6,4,2,3,5,7,8,1")));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 40.4 MB , 在所有 Java 提交中击败了 48.70% 的用户
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
      int sum = (1 + nums.length) * nums.length >> 1;
      for (int num : nums) {
        sum -= num;
      }
      return sum;
    }
  }
}
