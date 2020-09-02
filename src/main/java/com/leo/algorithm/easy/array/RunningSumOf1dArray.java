// 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
//
// 请返回 nums 的动态和。
//
//
//
// 示例 1：
//
// 输入：nums = [1,2,3,4]
// 输出：[1,3,6,10]
// 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
//
// 示例 2：
//
// 输入：nums = [1,1,1,1,1]
// 输出：[1,2,3,4,5]
// 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
//
// 示例 3：
//
// 输入：nums = [3,1,2,10,1]
// 输出：[3,4,6,16,17]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// -10^6 <= nums[i] <= 10^6
//
// Related Topics 数组
// 1480. 一维数组的动态和

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class RunningSumOf1dArray {
  public static void main(String[] args) {
    Printer.printArray(new Solution().runningSum(DataBuilder.buildIntArray("1,2,3,4")));
    Printer.printArray(new Solution().runningSum(DataBuilder.buildIntArray("1,1,1,1,1")));
    Printer.printArray(new Solution().runningSum(DataBuilder.buildIntArray("3,1,2,10,1")));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.8 MB , 在所有 Java 提交中击败了 80.07% 的用户
     *
     * @param nums
     * @return
     */
    public int[] runningSum(int[] nums) {
      int[] result = new int[nums.length];
      int sum = 0;
      for (int i = 0; i < nums.length; i++) {
        sum += nums[i];
        result[i] = sum;
      }
      return result;
    }
  }
}
