// 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值
// 至多为 k。
//
//
//
// 示例 1:
//
// 输入: nums = [1,2,3,1], k = 3
// 输出: true
//
// 示例 2:
//
// 输入: nums = [1,0,1,1], k = 1
// 输出: true
//
// 示例 3:
//
// 输入: nums = [1,2,3,1,2,3], k = 2
// 输出: false
// Related Topics 数组 哈希表
// 219. 存在重复元素 II

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateIi {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true, new Solution().containsNearbyDuplicate(DataBuilder.buildIntArray("1,2,3,1"), 3));
    Printer.printCorrectAnswer(
        false, new Solution().containsNearbyDuplicate(DataBuilder.buildIntArray("1,2,3,1,2,3"), 2));
    Printer.printCorrectAnswer(
        false, new Solution().containsNearbyDuplicate(DataBuilder.buildIntArray("1"), 1));
    Printer.printCorrectAnswer(
        false, new Solution().containsNearbyDuplicate(DataBuilder.buildIntArray("1,2"), 2));
    Printer.printCorrectAnswer(
        true, new Solution().containsNearbyDuplicate(DataBuilder.buildIntArray("1,0,1,1"), 1));
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .containsNearbyDuplicate(
                DataBuilder.buildIntArray("0,1,2,3,4,0,0,7,8,9,10,11,12,0"), 1));
  }

  static class Solution {
    /**
     * 只要找到一组 (i, j) 二者差的绝对值不超过 k 即可
     *
     * <p>执行用时： 9 ms , 在所有 Java 提交中击败了 91.64% 的用户
     *
     * <p>内存消耗： 45.6 MB , 在所有 Java 提交中击败了 5.72% 的用户
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
      if (nums == null || nums.length == 0) return false;
      Map<Integer, Integer> index = new HashMap<>();
      Map<Integer, Integer> diff = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int num = nums[i];
        if (index.containsKey(num)) {
          int dif = i - index.get(num);
          if (diff.containsKey(num)) {
            if (diff.get(num) > dif) {
              diff.put(num, dif);
            }
          } else {
            diff.put(num, dif);
          }
        }
        index.put(num, i);
      }
      Set<Map.Entry<Integer, Integer>> entries = diff.entrySet();
      for (Map.Entry<Integer, Integer> entry : entries) {
        if (entry.getValue() <= k) return true;
      }
      return false;
    }
  }
}
