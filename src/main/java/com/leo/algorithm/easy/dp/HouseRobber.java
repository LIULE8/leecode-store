package com.leo.algorithm.easy.dp;

import com.leo.algorithm.utils.DataBuilder;

/**
 * 198. 打家劫舍
 *
 * <p>你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * <p>给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * <p>示例 1:
 *
 * <p>输入: [1,2,3,1] 输出: 4 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。   偷窃到的最高金额 = 1 + 3 = 4 。 示例 2:
 *
 * <p>输入: [2,7,9,3,1] 输出: 12 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。 偷窃到的最高金额
 * = 2 + 9 + 1 = 12 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HouseRobber {
  public static void main(String[] args) {
    //    int[] ints = DataBuilder.buildIntArray("2,7,9,3,1");
    //    int[] ints = DataBuilder.buildIntArray("1,2,3,1");
    int[] ints = DataBuilder.buildIntArray("2,1,1,2");
    int rob = new Solution().rob(ints);
    System.out.println(rob);
  }

  static class Solution {
    public int rob(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 奇偶法
     *
     * <p>执行用时 : 0 ms , 在所有 java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 34 MB , 在所有 java 提交中击败了 89.88% 的用户
     *
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
      int odd = 0;
      int even = 0;
      for (int i = 0; i < nums.length; i++) {
        if (i % 2 == 0) {
          odd += nums[i];
          odd = Math.max(odd, even);
        } else {
          even += nums[i];
          even = Math.max(odd, even);
        }
      }
      return Math.max(odd, even);
    }

    /**
     * 动态规划
     *
     * <p>执行用时 : 0 ms , 在所有 java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 34.3 MB , 在所有 java 提交中击败了 85.94% 的用户
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int prevMax = 0;
      int currMax = 0;
      for (int num : nums) {
        int temp = currMax;
        currMax = Math.max(prevMax + num, currMax);
        prevMax = temp;
      }
      return currMax;
    }
  }
}
