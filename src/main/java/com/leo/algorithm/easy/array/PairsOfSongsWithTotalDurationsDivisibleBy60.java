// 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
//
// 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足 i < j 且有 (time[i] + tim
// e[j]) % 60 == 0。
//
//
//
// 示例 1：
//
// 输入：[30,20,150,100,40]
// 输出：3
// 解释：这三对的总持续时间可被 60 整数：
// (time[0] = 30, time[2] = 150): 总持续时间 180
// (time[1] = 20, time[3] = 100): 总持续时间 120
// (time[1] = 20, time[4] = 40): 总持续时间 60
//
//
// 示例 2：
//
// 输入：[60,60,60]
// 输出：3
// 解释：所有三对的总持续时间都是 120，可以被 60 整数。
//
//
//
//
// 提示：
//
//
// 1 <= time.length <= 60000
// 1 <= time[i] <= 500
//
// Related Topics 数组
// 1010. 总持续时间可被 60 整除的歌曲

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        3, new Solution().numPairsDivisibleBy60(DataBuilder.buildIntArray("30,20,150,100,40")));
    Printer.printCorrectAnswer(
        3, new Solution().numPairsDivisibleBy60(DataBuilder.buildIntArray("60,60,60")));
  }

  static class Solution {
    /**
     * 整数对60取模，可能有60种余数。故初始化一个长度为60的数组，统计各余数出现的次数。
     * 遍历time数组，每个值对60取模，并统计每个余数值（0-59）出现的个数。因为余数部分需要找到合适的cp组合起来能被60整除。
     * 余数为0的情况，只能同余数为0的情况组合（如60s、120s等等）。0的情况出现k次，则只能在k中任选两次进行两两组合。用k * (k - 1) / 2表示。 余数为30的情况同上。
     * 其余1与59组合，2与58组合，故使用双指针分别从1和59两头向中间遍历。1的情况出现m次，59的情况出现n次，则总共有m*n种组合。
     *
     * <p>执行用时： 2 ms , 在所有 Java 提交中击败了 99.88% 的用户
     *
     * <p>内存消耗： 45.5 MB , 在所有 Java 提交中击败了 32.72% 的用户
     *
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
      int[] res = new int[60];
      for (int num : time) {
        res[num % 60] += 1;
      }
      int count = res[0] * (res[0] - 1) >> 1;
      count += res[30] * (res[30] - 1) >> 1;
      int i = 1, j = 59;
      while (i < j) {
        count += res[i++] * res[j--];
      }
      return count;
    }
  }
}
