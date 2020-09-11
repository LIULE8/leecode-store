// 找出数组中重复的数字。
//
//
// 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
// 找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
// [2, 3, 1, 0, 2, 5, 3]
// 输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表
// 剑指 Offer 03. 数组中重复的数字

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.Set;

public class ShuZuZhongZhongFuDeShuZiLcof {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        2, new Solution().findRepeatNumber(DataBuilder.buildIntArray("2, 3, 1, 0, 2, 5, 3")));
  }

  static class Solution {
    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 25.20% 的用户
     *
     * <p>内存消耗： 48.6 MB , 在所有 Java 提交中击败了 38.94% 的用户
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
      Set<Integer> s = new HashSet<>();
      for (int num : nums) {
        if (s.contains(num)) return num;
        s.add(num);
      }
      return -1;
    }
  }
}
