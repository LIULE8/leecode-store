// 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
//
// 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
//
// 示例 1:
//
//
// 输入: [1, 2, 2, 3, 1]
// 输出: 2
// 解释:
// 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
// 连续子数组里面拥有相同度的有如下所示:
// [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
// 最短连续子数组[2, 2]的长度为2，所以返回2.
//
//
// 示例 2:
//
//
// 输入: [1,2,2,3,1,4,2]
// 输出: 6
//
//
// 注意:
//
//
// nums.length 在1到50,000区间范围内。
// nums[i] 是一个在0到49,999范围内的整数。
//
// Related Topics 数组
// 697. 数组的度

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DegreeOfAnArray {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "2", new Solution().findShortestSubArray(DataBuilder.buildIntArray("1,2,2,3,1")));
    Printer.printCorrectAnswer(
        "6", new Solution().findShortestSubArray(DataBuilder.buildIntArray("1,2,2,3,1,4,2")));
    Printer.printCorrectAnswer(
        "1", new Solution().findShortestSubArray(DataBuilder.buildIntArray("1")));
    Printer.printCorrectAnswer(
        "7",
        new Solution()
            .findShortestSubArray(DataBuilder.buildIntArray("2,1,1,2,1,3,3,3,1,3,1,3,2")));
  }

  static class Solution {
    /**
     * 执行用时： 29 ms , 在所有 Java 提交中击败了 64.13% 的用户
     *
     * <p>内存消耗： 43.7 MB , 在所有 Java 提交中击败了 6.25% 的用户
     *
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
      if (nums == null || nums.length == 0) {
        return 0;
      }
      Map<Integer, Integer> left = new HashMap<>(),
          right = new HashMap<>(),
          count = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        if (!left.containsKey(nums[i])) left.put(nums[i], i);
        right.put(nums[i], i);
        count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
      }
      // 子数组度相同的情况，取最小长度的子数组
      Integer max = Collections.max(count.values());
      int length = nums.length;
      Set<Map.Entry<Integer, Integer>> entries = count.entrySet();
      for (Map.Entry<Integer, Integer> entry : entries) {
        if (entry.getValue().equals(max)) {
          length = Math.min(length, right.get(entry.getKey()) - left.get(entry.getKey()) + 1);
        }
      }
      return length;
    }
  }
}
