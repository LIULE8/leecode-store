// 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和（每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
//
// 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
//
//
//
// 示例 1：
//
// 输入：n = 13
// 输出：4
// 解释：总共有 9 个组，将 1 到 13 按数位求和后这些组分别是：
// [1,10]，[2,11]，[3,12]，[4,13]，[5]，[6]，[7]，[8]，[9]。总共有 4 个组拥有的数字并列最多。
//
//
// 示例 2：
//
// 输入：n = 2
// 输出：2
// 解释：总共有 2 个大小为 1 的组 [1]，[2]。
//
//
// 示例 3：
//
// 输入：n = 15
// 输出：6
//
//
// 示例 4：
//
// 输入：n = 24
// 输出：5
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10^4
//
// Related Topics 数组
// 1399. 统计最大组的数目

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.Printer;

public class CountLargestGroup {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(4, new Solution().countLargestGroup(13));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 98.00% 的用户
     *
     * <p>内存消耗： 37.1 MB , 在所有 Java 提交中击败了 52.86% 的用户
     *
     * @param n
     * @return
     */
    public int countLargestGroup(int n) {
      int res = 0, max = 0;
      int[] count = new int[n + 1]; // 统计数位和
      int[] sum = new int[n + 1]; // 计算1-n各个元素的数位和，例如数字i的数位和是sum[i / 10] + i % 10
      for (int i = 1; i <= n; i++) {
        sum[i] = sum[i / 10] + i % 10;
        count[sum[i]]++;
        if (count[sum[i]] > max) max = count[sum[i]];
      }
      for (int num : count) {
        if (num == max) res++;
      }
      return res;
    }
  }
}
