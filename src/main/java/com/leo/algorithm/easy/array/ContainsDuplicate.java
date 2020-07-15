// 给定一个整数数组，判断是否存在重复元素。
//
// 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
//
//
//
// 示例 1:
//
// 输入: [1,2,3,1]
// 输出: true
//
// 示例 2:
//
// 输入: [1,2,3,4]
// 输出: false
//
// 示例 3:
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
// 输出: true
// Related Topics 数组 哈希表
// 217. 存在重复元素

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true, new Solution().containsDuplicate(DataBuilder.buildIntArray("1,2,3,1")));
    Printer.printCorrectAnswer(
        false, new Solution().containsDuplicate(DataBuilder.buildIntArray("1,2,3,4")));
    Printer.printCorrectAnswer(
        true, new Solution().containsDuplicate(DataBuilder.buildIntArray("1,1,1,3,3,4,3,2,4,2")));
  }

  static class Solution {
    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 52.35% 的用户
     *
     * <p>内存消耗： 46 MB , 在所有 Java 提交中击败了 6.98% 的用户
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
      if (nums == null || nums.length == 0) return false;
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
        if (set.contains(num)) {
          return true;
        }
        set.add(num);
      }
      return false;
    }
  }
}
