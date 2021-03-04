// 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找
// 出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
//
// 示例1:
//
//  输入：nums = [0, 2, 3, 4, 5]
// 输出：0
// 说明: 0下标的元素为0
//
//
// 示例2:
//
//  输入：nums = [1, 1, 1]
// 输出：1
//
//
// 说明:
//
//
// nums长度在[1, 1000000]之间
// 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
//
// Related Topics 数组 二分查找
// 面试题 08.03. 魔术索引

package com.leo.algorithm.easy.binarySearch;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MagicIndexLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        0, new Solution().findMagicIndex(DataBuilder.buildIntArray("0,2,3,4,5")));
    Printer.printCorrectAnswer(
        0, new Solution().findMagicIndex(DataBuilder.buildIntArray("0,0,2")));
  }

  static class Solution {
    public int findMagicIndex(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 用不了二分查找，只能用跳跃遍历
     *
     * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.1 MB , 在所有 Java 提交中击败了 53.97% 的用户
     *
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
      if (nums == null || nums.length == 0) return -1;
      int i = 0;
      while (i < nums.length) {
        if (nums[i] == i) {
          return i;
        } else if (nums[i] > i) {
          i = nums[i];
        } else {
          i++;
        }
      }
      return -1;
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 34.03% 的用户
     *
     * <p>内存消耗： 39.1 MB , 在所有 Java 提交中击败了 53.73% 的用户
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        if (i == nums[i]) return i;
      }
      return -1;
    }
  }
}
