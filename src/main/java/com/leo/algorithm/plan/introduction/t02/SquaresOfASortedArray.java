// 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//
//
//
// 示例 1：
//
//
// 输入：nums = [-4,-1,0,3,10]
// 输出：[0,1,9,16,100]
// 解释：平方后，数组变为 [16,1,0,9,100]
// 排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//
// 输入：nums = [-7,-3,2,3,11]
// 输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums 已按 非递减顺序 排序
//
//
//
//
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
// Related Topics 数组 双指针 排序
// 977. 有序数组的平方

package com.leo.algorithm.plan.introduction.t02;

import java.util.Arrays;

public class SquaresOfASortedArray {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public int[] sortedSquares(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 40.3 MB , 在所有 Java 提交中击败了 27.56% 的用户
     *
     * @param nums
     * @return
     */
    private int[] method2(int[] nums) {
      if (nums == null || nums.length == 0) return nums;
      // 定义nums数组前后双指针
      int l = 0;
      int r = nums.length - 1;
      // 定义新数组接收结果，i为下标
      int[] result = new int[nums.length];
      int i = nums.length - 1;
      while (l <= r) {
        if (Math.abs(nums[l]) < Math.abs(nums[r])) {
          result[i] = nums[r] * nums[r];
          r--;
        } else {
          result[i] = nums[l] * nums[l];
          l++;
        }
        i--;
      }
      return result;
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 48.81% 的用户
     *
     * <p>内存消耗： 40.3 MB , 在所有 Java 提交中击败了 33.63% 的用户
     *
     * @param nums
     * @return
     */
    private int[] method1(int[] nums) {
      if (nums == null || nums.length == 0) return nums;
      int[] a = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        a[i] = nums[i] * nums[i];
      }
      Arrays.sort(a);
      return a;
    }
  }
}
