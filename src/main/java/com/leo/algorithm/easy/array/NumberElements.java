package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.Set;

// 给你一个整数数组 arr， 对于元素 x ，只有当 x + 1 也在数组 arr 里时，才能记为 1 个数。
//
// 如果数组 arr 里有重复的数，每个重复的数单独计算。
//
//
//
// 示例 1：
//
// 输入：arr = [1,2,3]
// 输出：2
// 解释：1 和 2 被计算次数因为 2 和 3 在数组 arr 里。
// 示例 2：
//
// 输入：arr = [1,1,3,3,5,5,7,7]
// 输出：0
// 解释：所有的数都不算, 因为数组里没有 2、4、6、8。
// 示例 3：
//
// 输入：arr = [1,3,2,3,5,0]
// 输出：3
// 解释：0、1、2 被计算了因为 1、2、3 在数组里。
// 示例 4：
//
// 输入：arr = [1,1,2,2]
// 输出：2
// 解释：两个 1 被计算了因为有 2 在数组里。
//
//
// 提示：
//
// 1 <= arr.length <= 1000
// 0 <= arr[i] <= 1000
//
// 1426. 数元素
public class NumberElements {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(2, new Solution().countElements(DataBuilder.buildIntArray("1,2,3")));
    Printer.printCorrectAnswer(
        0, new Solution().countElements(DataBuilder.buildIntArray("1,1,3,3,5,5,7,7")));
    Printer.printCorrectAnswer(
        3, new Solution().countElements(DataBuilder.buildIntArray("1,3,2,3,5,0")));
    Printer.printCorrectAnswer(
        2, new Solution().countElements(DataBuilder.buildIntArray("1,1,2,2")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 89.41% 的用户
     *
     * <p>内存消耗： 37.6 MB , 在所有 Java 提交中击败了 22.22% 的用户
     *
     * @param arr
     * @return
     */
    public int countElements(int[] arr) {
      if (arr == null || arr.length <= 1) return 0;
      Set<Integer> set = new HashSet<>();
      for (int value : arr) {
        set.add(value);
      }
      int count = 0;
      for (int value : arr) {
        if (set.contains(value + 1)) {
          count++;
        }
      }
      return count;
    }
  }
}
