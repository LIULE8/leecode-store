package com.leo.algorithm.easy.array;
// 给你一个整数数组 A 和一个整数 K，请在该数组中找出两个元素，使它们的和小于 K 但尽可能地接近 K，返回这两个元素的和。
//
// 如不存在这样的两个元素，请返回 -1。
//
//
//
// 示例 1：
//
// 输入：A = [34,23,1,24,75,33,54,8], K = 60
// 输出：58
// 解释：
// 34 和 24 相加得到 58，58 小于 60，满足题意。
// 示例 2：
//
// 输入：A = [10,20,30], K = 15
// 输出：-1
// 解释：
// 我们无法找到和小于 15 的两个元素。
//
//
// 提示：
//
// 1 <= A.length <= 100
// 1 <= A[i] <= 1000
// 1 <= K <= 2000
//
// 1099. 小于 K 的两数之和

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class SumOfTwoNumbersLessThanK {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        58, new Solution().twoSumLessThanK(DataBuilder.buildIntArray("34,23,1,24,75,33,54,8"), 60));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param A
     * @param K
     * @return
     */
    public int twoSumLessThanK(int[] A, int K) {
      if (A == null || A.length == 0) return -1;
      Arrays.sort(A);
      int l = 0, r = A.length - 1, max = Integer.MIN_VALUE;
      while (l < r) {
        if (A[l] + A[r] >= K) {
          r--;
        } else {
          max = Math.max(max, A[l] + A[r]);
          l++;
        }
      }
      return max == Integer.MIN_VALUE ? -1 : max;
    }
  }
}
