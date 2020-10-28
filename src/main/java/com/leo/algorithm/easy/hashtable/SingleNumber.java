// 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
// 输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
// 输出: 4
// Related Topics 位运算 哈希表
// 136. 只出现一次的数字

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(1, new Solution().singleNumber(DataBuilder.buildIntArray("2,2,1")));
    Printer.printCorrectAnswer(
        4, new Solution().singleNumber(DataBuilder.buildIntArray("4,1,2,1,2")));
  }

  static class Solution {
    public int singleNumber(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 所有数异或，剩下的那个就是唯一出现的数字
     *
     * <p>执行用时： 1 ms , 在所有 Java 提交中击败了 99.82% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 92.29% 的用户
     *
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
      int single = 0;
      for (int num : nums) {
        single ^= num;
      }
      return single;
    }

    /**
     * 执行用时： 16 ms , 在所有 Java 提交中击败了 7.85% 的用户
     *
     * <p>内存消耗： 39.4 MB , 在所有 Java 提交中击败了 74.72% 的用户
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
      }
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1) return entry.getKey();
      }
      return -1;
    }
  }
}
