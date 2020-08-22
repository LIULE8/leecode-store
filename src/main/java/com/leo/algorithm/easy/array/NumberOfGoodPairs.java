// 给你一个整数数组 nums 。
//
// 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
//
// 返回好数对的数目。
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,3,1,1,3]
// 输出：4
// 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
//
//
// 示例 2：
//
// 输入：nums = [1,1,1,1]
// 输出：6
// 解释：数组中的每组数字都是好数对
//
// 示例 3：
//
// 输入：nums = [1,2,3]
// 输出：0
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// 1 <= nums[i] <= 100
//
// Related Topics 数组 哈希表 数学
// 1512. 好数对的数目

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        4, new Solution().numIdenticalPairs(DataBuilder.buildIntArray("1,2,3,1,1,3")));
    Printer.printCorrectAnswer(
        6, new Solution().numIdenticalPairs(DataBuilder.buildIntArray("1,1,1,1")));
    Printer.printCorrectAnswer(
        0, new Solution().numIdenticalPairs(DataBuilder.buildIntArray("1,2,3")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 83.10% 的用户
     *
     * <p>内存消耗： 37.1 MB , 在所有 Java 提交中击败了 57.78% 的用户
     *
     * @param nums
     * @return
     */
    public int numIdenticalPairs(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
      int count = 0;
      for (Integer value : map.values()) {
        if (value == 1) continue;
        int n = value - 1;
        count += (1 + n) * (value - 1) >> 1;
      }
      return count;
    }
  }
}
