// 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
//
// 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
//
// 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
//
// 如果有多个答案，你可以返回其中任何一个。保证答案存在。
//
//
//
// 示例 1：
//
// 输入：A = [1,1], B = [2,2]
// 输出：[1,2]
//
//
// 示例 2：
//
// 输入：A = [1,2], B = [2,3]
// 输出：[1,2]
//
//
// 示例 3：
//
// 输入：A = [2], B = [1,3]
// 输出：[2,3]
//
//
// 示例 4：
//
// 输入：A = [1,2,5], B = [2,4]
// 输出：[5,4]
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 10000
// 1 <= B.length <= 10000
// 1 <= A[i] <= 100000
// 1 <= B[i] <= 100000
// 保证爱丽丝与鲍勃的糖果总量不同。
// 答案肯定存在。
//
// Related Topics 数组
// 888. 公平的糖果交换

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.Set;

public class FairCandySwap {
  public static void main(String[] args) {
    Printer.printArray(
        new Solution()
            .fairCandySwap(DataBuilder.buildIntArray("1,1"), DataBuilder.buildIntArray("2,2")));
    Printer.printArray(
        new Solution()
            .fairCandySwap(DataBuilder.buildIntArray("1,2"), DataBuilder.buildIntArray("2,3")));
    Printer.printArray(
        new Solution()
            .fairCandySwap(DataBuilder.buildIntArray("2"), DataBuilder.buildIntArray("1,3")));
    Printer.printArray(
        new Solution()
            .fairCandySwap(DataBuilder.buildIntArray("1,2,5"), DataBuilder.buildIntArray("2,4")));
  }

  static class Solution {
    /**
     * SA - y + x = SB + y - x
     *
     * <p>=> y = x + (SA - SB) >> 1
     *
     * <p>执行用时： 13 ms , 在所有 Java 提交中击败了 59.10% 的用户
     *
     * <p>内存消耗： 41.1 MB , 在所有 Java 提交中击败了 92.79% 的用户
     *
     * @param A
     * @param B
     * @return
     */
    public int[] fairCandySwap(int[] A, int[] B) {
      int sa = 0, sb = 0;
      Set<Integer> set = new HashSet<>();
      for (int j : A) {
        sa += j;
        set.add(j);
      }
      for (int j : B) sb += j;
      int res = (sa - sb) >> 1;
      for (int j : B) {
        int o = res + j;
        if (set.contains(o)) {
          return new int[] {o, j};
        }
      }
      return new int[0];
    }
  }
}
