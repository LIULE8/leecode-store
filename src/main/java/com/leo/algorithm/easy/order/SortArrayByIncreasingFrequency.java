// 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
//
// 请你返回排序后的数组。
//
//
//
// 示例 1：
//
// 输入：nums = [1,1,2,2,2,3]
// 输出：[3,1,1,2,2,2]
// 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
//
//
// 示例 2：
//
// 输入：nums = [2,3,1,3,2]
// 输出：[1,3,3,2,2]
// 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
//
//
// 示例 3：
//
// 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
// 输出：[5,-1,4,4,-6,-6,1,1,1]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// -100 <= nums[i] <= 100
//
// Related Topics 排序 数组
// 1636. 按照频率将数组升序排序

package com.leo.algorithm.easy.order;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByIncreasingFrequency {
  public static void main(String[] args) {
    Printer.printArray(new Solution().frequencySort(DataBuilder.buildIntArray("1,1,2,2,2,3")));
    Printer.printArray(new Solution().frequencySort(DataBuilder.buildIntArray("2,3,1,3,2")));
    Printer.printArray(
        new Solution().frequencySort(DataBuilder.buildIntArray("-1,1,-6,4,5,-6,1,4,1")));
  }

  static class Solution {
    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 63.86% 的用户
     *
     * <p>内存消耗： 38.7 MB , 在所有 Java 提交中击败了 50.36% 的用户
     *
     * @param nums
     * @return
     */
    public int[] frequencySort(int[] nums) {
      int[] frequency = new int[201];
      List<Integer> list = new ArrayList<>(nums.length);
      for (int num : nums) {
        frequency[num + 100]++;
        list.add(num);
      }
      list.sort(
          (o1, o2) -> {
            if (frequency[o1 + 100] != frequency[o2 + 100]) {
              return frequency[o1 + 100] - frequency[o2 + 100];
            }
            return o2 - o1;
          });
      int[] res = new int[nums.length];
      for (int i = 0; i < list.size(); i++) {
        res[i] = list.get(i);
      }
      return res;
    }
  }
}
