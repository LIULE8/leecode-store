// 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的
// 种类数。
//
// 示例 1:
//
//
// 输入: candies = [1,1,2,2,3,3]
// 输出: 3
// 解析: 一共有三种种类的糖果，每一种都有两个。
//     最优分配方案：妹妹获得[1,2,3],弟弟也获得[1,2,3]。这样使妹妹获得糖果的种类数最多。
//
//
// 示例 2 :
//
//
// 输入: candies = [1,1,2,3]
// 输出: 2
// 解析: 妹妹获得糖果[2,3],弟弟获得糖果[1,1]，妹妹有两种不同的糖果，弟弟只有一种。这样使得妹妹可以获得的糖果种类数最多。
//
//
// 注意:
//
//
// 数组的长度为[2, 10,000]，并且确定为偶数。
// 数组中数字的大小在范围[-100,000, 100,000]内。
//
//
//
// 575. 分糖果
// Related Topics 哈希表
// 👍 98 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        3, new Solution().distributeCandies(DataBuilder.buildIntArray("1,1,2,2,3,3")));
    Printer.printCorrectAnswer(
        2, new Solution().distributeCandies(DataBuilder.buildIntArray("1,1,2,3")));
    Printer.printCorrectAnswer(
        2, new Solution().distributeCandies(DataBuilder.buildIntArray("1000,1,1,1")));
  }

  static class Solution {
    public int distributeCandies(int[] candyType) {
      //      return method1(candyType);
      return method2(candyType);
    }

    /**
     * 执行用时： 40 ms , 在所有 Java 提交中击败了 46.93% 的用户
     *
     * <p>内存消耗： 40.3 MB , 在所有 Java 提交中击败了 83.72% 的用户
     *
     * @param candyType
     * @return
     */
    private int method2(int[] candyType) {
      Set<Integer> set = new HashSet<>();
      for (int candy : candyType) {
        set.add(candy);
      }
      return Math.min(set.size(), candyType.length >> 1);
    }

    /**
     * 执行用时： 42 ms , 在所有 Java 提交中击败了 36.50% 的用户
     *
     * <p>内存消耗： 40.6 MB , 在所有 Java 提交中击败了 42.70% 的用户
     *
     * @param candyType
     * @return
     */
    private int method1(int[] candyType) {
      Arrays.sort(candyType);
      int count = 1, half = candyType.length >> 1;
      for (int i = 1; i < candyType.length && count < half; i++)
        if (candyType[i] > candyType[i - 1]) count++;
      return count;
    }
  }
}
