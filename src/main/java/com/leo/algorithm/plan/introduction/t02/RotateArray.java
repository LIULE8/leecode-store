// 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
//
//
// 进阶：
//
//
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
// 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
//
//
//
//
// 示例 1:
//
//
// 输入: nums = [1,2,3,4,5,6,7], k = 3
// 输出: [5,6,7,1,2,3,4]
// 解释:
// 向右旋转 1 步: [7,1,2,3,4,5,6]
// 向右旋转 2 步: [6,7,1,2,3,4,5]
// 向右旋转 3 步: [5,6,7,1,2,3,4]
//
//
// 示例 2:
//
//
// 输入：nums = [-1,-100,3,99], k = 2
// 输出：[3,99,-1,-100]
// 解释:
// 向右旋转 1 步: [99,-1,-100,3]
// 向右旋转 2 步: [3,99,-1,-100]
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 104
// -231 <= nums[i] <= 231 - 1
// 0 <= k <= 105
//
//
//
//
// Related Topics 数组 数学 双指针
// 189. 旋转数组

package com.leo.algorithm.plan.introduction.t02;

public class RotateArray {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 55 MB , 在所有 Java 提交中击败了 83.68% 的用户
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
      if (nums == null || nums.length == 0) return;
      int offset = k % nums.length;
      int mid = nums.length - offset;
      reverse(nums, 0, mid - 1);
      reverse(nums, mid, nums.length - 1);
      reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int l, int r) {
      while (l < r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
        l++;
        r--;
      }
    }
  }
}
