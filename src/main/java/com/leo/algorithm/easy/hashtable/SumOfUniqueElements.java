// 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
//
// 请你返回 nums 中唯一元素的 和 。
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,3,2]
// 输出：4
// 解释：唯一元素为 [1,3] ，和为 4 。
//
//
// 示例 2：
//
// 输入：nums = [1,1,1,1,1]
// 输出：0
// 解释：没有唯一元素，和为 0 。
//
//
// 示例 3 ：
//
// 输入：nums = [1,2,3,4,5]
// 输出：15
// 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
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
// 1748. 唯一元素的和
// Related Topics 数组 哈希表
// 👍 2 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class SumOfUniqueElements {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(4, new Solution().sumOfUnique(DataBuilder.buildIntArray("1,2,3,2")));
    Printer.printCorrectAnswer(
        0, new Solution().sumOfUnique(DataBuilder.buildIntArray("1,1,1,1,1")));
    Printer.printCorrectAnswer(
        15, new Solution().sumOfUnique(DataBuilder.buildIntArray("1,2,3,4,5")));
  }

  static class Solution {
    public int sumOfUnique(int[] nums) {
      return method1(nums);
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 35.58% 的用户
     *
     * <p>内存消耗： 36 MB , 在所有 Java 提交中击败了 65.08% 的用户
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
      int sum = 0;
      for (Integer key : map.keySet()) {
        if (map.get(key) == 1) sum += key;
      }
      return sum;
    }
  }
}
