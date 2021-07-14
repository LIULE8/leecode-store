package com.leo.algorithm.easy.dp;

import com.leo.algorithm.utils.DataBuilder;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * <p>给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * <p>示例：
 *
 * <p>给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * <p>sumRange(0, 2) -> 1 sumRange(2, 5) -> -1 sumRange(0, 5) -> -3 说明:
 *
 * <p>你可以假设数组不可变。 会多次调用 sumRange 方法。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RangeSumQueryImmutable {
  public static void main(String[] args) {
    int[] ints = DataBuilder.buildIntArray("-2,0,3,-5,2,-1");
    NumArray numArray = new NumArray(ints);
    int i1 = numArray.sumRange(0, 2); // 1
    int i2 = numArray.sumRange(2, 5); // -1
    int i3 = numArray.sumRange(0, 5); // -3
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i3);
  }

  /**
   * 缓存法，使用dp table 缓存之前的和。
   *
   * <p>执行用时 : 12 ms , 在所有 java 提交中击败了 99.62% 的用户
   *
   * <p>内存消耗 : 40.1 MB , 在所有 java 提交中击败了 98.70% 的用户
   */
  static class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
      sums = new int[nums.length + 1];
      for (int i = 0; i < nums.length; i++) {
        sums[i + 1] = sums[i] + nums[i];
      }
    }

    public int sumRange(int i, int j) {
      return sums[j + 1] - sums[i];
    }
  }
}
