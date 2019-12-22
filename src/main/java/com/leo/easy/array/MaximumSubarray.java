package com.leo.easy.array;

import com.leo.utils.DataBuilder;

/**
 * 53. 最大子序和
 *
 * <p>给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * <p>示例:
 *
 * <p>输入: [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。 进阶:
 *
 * <p>如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumSubarray {
  public static void main(String[] args) {
    int[] ints = DataBuilder.buildIntArray("-2,1,-3,4,-1,2,1,-5,4");
    //    int[] ints = DataBuilder.buildIntArray("1,2");
    //            int[] ints = DataBuilder.buildIntArray("-2,1");
    int i = new Solution().maxSubArray(ints);
    System.out.println(i);
  }

  static class Solution {
    public int maxSubArray(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 执行用时 : 66 ms , 在所有 java 提交中击败了 7.61% 的用户
     *
     * <p>内存消耗 : 40.9 MB , 在所有 java 提交中击败了 63.92% 的用户
     *
     * @param nums
     * @return 更慢了
     */
    private int method2(int[] nums) {
      if (nums == null) {
        return 0;
      }
      int[] sums = new int[nums.length];
      sums[0] = nums[0];
      for (int i = 1; i < nums.length; i++) {
        sums[i] = sums[i - 1] + nums[i];
      }
      int max = sums[0];
      for (int i = 0; i < sums.length; i++) {
        if (max < sums[i]) {
          max = sums[i];
        }
        for (int j = 0; j < i; j++) {
          int sub = sums[i] - sums[j];
          if (sub > max) {
            max = sub;
          }
        }
      }
      return max;
    }

    /**
     * O(n^2)
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      if (nums == null) {
        return 0;
      }
      int max = nums[0];
      for (int i = 0; i < nums.length; i++) {
        int sum = 0;
        for (int j = i; j < nums.length; j++) {
          sum += nums[j];
          if (sum > max) {
            max = sum;
          }
        }
      }
      return max;
    }
  }
}
