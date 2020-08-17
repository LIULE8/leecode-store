// 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
//
// 请你找到这个数组里第 k 个缺失的正整数。
//
//
//
// 示例 1：
//
// 输入：arr = [2,3,4,7,11], k = 5
// 输出：9
// 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
//
//
// 示例 2：
//
// 输入：arr = [1,2,3,4], k = 2
// 输出：6
// 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 1000
// 1 <= arr[i] <= 1000
// 1 <= k <= 1000
// 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j]
//
// Related Topics 数组 哈希表
// 1539. 第 k 个缺失的正整数

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class KthMissingPositiveNumber {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        9, new Solution().findKthPositive(DataBuilder.buildIntArray("2,3,4,7,11"), 5));
    Printer.printCorrectAnswer(
        6, new Solution().findKthPositive(DataBuilder.buildIntArray("1,2,3,4"), 2));
    Printer.printCorrectAnswer(
        5, new Solution().findKthPositive(DataBuilder.buildIntArray("1,2,4"), 2));
  }

  static class Solution {
    /**
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 5.15% 的用户
     *
     * <p>内存消耗： 39.9 MB , 在所有 Java 提交中击败了 5.19% 的用户
     *
     * @param arr
     * @param k
     * @return
     */
    public int findKthPositive(int[] arr, int k) {
      Map<Integer, Integer> map = new HashMap<>();
      for (int i = 0; i < arr[arr.length - 1]; i++) {
        map.put(i + 1, 0);
      }
      for (int value : arr) {
        if (map.containsKey(value)) map.put(value, 1);
      }
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 0) {
          k--;
          if (k == 0) return entry.getKey();
        }
      }
      return k > 0 ? arr[arr.length - 1] + k : 0;
    }
  }
}
