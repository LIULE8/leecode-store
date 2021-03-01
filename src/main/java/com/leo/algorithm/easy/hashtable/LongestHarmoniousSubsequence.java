// 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
//
// 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。
//
// 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,3,2,2,5,2,3,7]
// 输出：5
// 解释：最长的和谐子序列是 [3,2,2,2,3]
//
//
// 示例 2：
//
//
// 输入：nums = [1,2,3,4]
// 输出：2
//
//
// 示例 3：
//
//
// 输入：nums = [1,1,1,1]
// 输出：0
//
//
//  594. 最长和谐子序列
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 104
// -109 <= nums[i] <= 109
//
// Related Topics 哈希表
// 👍 153 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        5, new Solution().findLHS(DataBuilder.buildIntArray("1,3,2,2,5,2,3,7")));
    Printer.printCorrectAnswer(2, new Solution().findLHS(DataBuilder.buildIntArray("1,2,3,4")));
    Printer.printCorrectAnswer(0, new Solution().findLHS(DataBuilder.buildIntArray("1,1,1,1")));
    Printer.printCorrectAnswer(
        0, new Solution().findLHS(DataBuilder.buildIntArray("1,3,5,7,9,11,13,15,17")));
    Printer.printCorrectAnswer(2, new Solution().findLHS(DataBuilder.buildIntArray("1,2,3,4")));
  }

  static class Solution {
    /**
     * 执行用时： 19 ms , 在所有 Java 提交中击败了 85.14% 的用户
     *
     * <p>内存消耗： 39.7 MB , 在所有 Java 提交中击败了 36.03% 的用户
     *
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
      int max = 0;
      for (Integer key : map.keySet()) {
        if (map.containsKey(key + 1)) {
          max = Math.max(max, map.get(key) + map.get(key + 1));
        }
      }
      return max;
    }
  }
}
