// 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
//
// 示例 1：
//
// 输入：[1,2,5,9,5,9,5,5,5]
// 输出：5
//
//
//
// 示例 2：
//
// 输入：[3,2]
// 输出：-1
//
//
//
// 示例 3：
//
// 输入：[2,2,1,1,1,2,2]
// 输出：2
//
//
//
// 说明：
// 你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？
// Related Topics 位运算 数组 分治算法
// 面试题 17.10. 主要元素
// 和 169 题一样

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class FindMajorityElementLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        -1, new Solution().majorityElement(DataBuilder.buildIntArray("3,2")));
    Printer.printCorrectAnswer(
        5, new Solution().majorityElement(DataBuilder.buildIntArray("1,2,5,9,5,9,5,5,5")));
    Printer.printCorrectAnswer(
        2, new Solution().majorityElement(DataBuilder.buildIntArray("2,2,1,1,1,2,2")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 42.8 MB , 在所有 Java 提交中击败了 87.30% 的用户
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
      int count = 1;
      int num = nums[0];
      for (int i = 1; i < nums.length; i++) {
        if (num == nums[i]) {
          count++;
        } else {
          count--;
          if (count == 0 && i + 1 < nums.length) {
            num = nums[i + 1];
          }
        }
      }
      return count == 0 ? -1 : num;
    }
  }
}
