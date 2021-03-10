// 整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
// k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
// ,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回 -1 。
//
//
//
// 示例 1：
//
//
// 输入：nums = [4,5,6,7,0,1,2], target = 0
// 输出：4
//
//
// 示例 2：
//
//
// 输入：nums = [4,5,6,7,0,1,2], target = 3
// 输出：-1
//
// 示例 3：
//
//
// 输入：nums = [1], target = 0
// 输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// nums 中的每个值都 独一无二
// nums 肯定会在某个点上旋转
// -10^4 <= target <= 10^4
//
//
//
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
// Related Topics 数组 二分查找
// 33. 搜索旋转排序数组

package com.leo.algorithm.middle.binarySearch;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class SearchInRotatedSortedArray {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        4, new Solution().search(DataBuilder.buildIntArray("4,5,6,7,0,1,2"), 0));
    Printer.printCorrectAnswer(
        -1, new Solution().search(DataBuilder.buildIntArray("4,5,6,7,0,1,2"), 3));
    Printer.printCorrectAnswer(-1, new Solution().search(DataBuilder.buildIntArray("1"), 0));
    Printer.printCorrectAnswer(-1, new Solution().search(DataBuilder.buildIntArray("1,3"), 2));
    Printer.printCorrectAnswer(1, new Solution().search(DataBuilder.buildIntArray("1,3"), 3));
    Printer.printCorrectAnswer(1, new Solution().search(DataBuilder.buildIntArray("3,1"), 1));
    Printer.printCorrectAnswer(0, new Solution().search(DataBuilder.buildIntArray("5,1,3"), 5));
  }

  static class Solution {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.7 MB , 在所有 Java 提交中击败了 77.45% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
      int startIndex = getMinNumsIndex(nums);
      int index = binarySearch(nums, startIndex, nums.length - 1, target);
      if (index == -1) {
        index = binarySearch(nums, 0, startIndex, target);
      }
      return index;
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
      while (l <= r) {
        int mid = l + ((r - l) >> 1);
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) l = mid + 1;
        else r = mid - 1;
      }
      return -1;
    }

    private int getMinNumsIndex(int[] nums) {
      int l = 0, r = nums.length - 1;
      while (l <= r) {
        int mid = l + ((r - l) >> 1);
        if (nums[mid] > nums[r]) l = mid + 1;
        else if (nums[mid] < nums[r]) r = mid;
        else r--;
      }
      return l;
    }
  }
}
