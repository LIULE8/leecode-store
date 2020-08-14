// 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
//
// 请你找到并返回这个整数
//
//
//
// 示例：
//
//
// 输入：arr = [1,2,2,6,6,6,6,7,10]
// 输出：6
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10^4
// 0 <= arr[i] <= 10^5
//
// Related Topics 数组
// 1287. 有序数组中出现次数超过25%的元素

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class ElementAppearingMoreThan25InSortedArray {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        6, new Solution().findSpecialInteger(DataBuilder.buildIntArray("1,2,2,6,6,6,6,7,10")));
  }

  static class Solution {
    public int findSpecialInteger(int[] arr) {
      return method1(arr);
    }

    /**
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 10.08% 的用户
     *
     * <p>内存消耗： 40.4 MB , 在所有 Java 提交中击败了 11.02% 的用户
     *
     * @param arr
     * @return
     */
    private int method1(int[] arr) {
      int a = (int) (arr.length * 0.25);
      Map<Integer, Integer> map = new HashMap<>();
      for (int value : arr) {
        map.put(value, map.getOrDefault(value, 0) + 1);
      }
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() > a) return entry.getKey();
      }
      return -1;
    }
  }
}
