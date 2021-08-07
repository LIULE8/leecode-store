// 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
//
//
//
// 示例 1：
//
// 输入：nums = [2,7,11,15], target = 9
// 输出：[2,7] 或者 [7,2]
//
//
// 示例 2：
//
// 输入：nums = [10,26,30,31,47,60], target = 40
// 输出：[10,30] 或者 [30,10]
//
//
//
//
// 限制：
//
//
// 1 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^6
//
// Related Topics 数组 双指针 二分查找
// 剑指 Offer 57. 和为s的两个数字

package com.leo.algorithm.easy.binarySearch;

public class HeWeiSdeLiangGeShuZiLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 90.91% 的用户
     *
     * <p>内存消耗： 55.1 MB , 在所有 Java 提交中击败了 79.59% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
        int tmp = target - nums[right];
        if (tmp < nums[left]) right--;
        else if (tmp > nums[left]) left++;
        else return new int[] {nums[left], nums[right]};
      }
      return new int[0];
    }
  }
}
