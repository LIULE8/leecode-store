// 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
// 则返回 -1。
//
//
// 示例 1:
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
// 输出: 4
// 解释: 9 出现在 nums 中并且下标为 4
//
//
// 示例 2:
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
// 输出: -1
// 解释: 2 不存在 nums 中因此返回 -1
//
//
//
//
// 提示：
//
//
// 你可以假设 nums 中的所有元素是不重复的。
// n 将在 [1, 10000]之间。
// nums 的每个元素都将在 [-9999, 9999]之间。
//
// Related Topics 二分查找
// 704. 二分查找

package com.leo.algorithm.easy.binarySearch;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class BinarySearch {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        4, new Solution().search(DataBuilder.buildIntArray("-1,0,3,5,9,12"), 9));
    Printer.printCorrectAnswer(
        -1, new Solution().search(DataBuilder.buildIntArray("-1,0,3,5,9,12"), 2));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.3 MB , 在所有 Java 提交中击败了 76.13% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
      int l = 0, r = nums.length - 1;
      while (l <= r) {
        int mid = l + ((r - l) >> 1);
        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] < target) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      return -1;
    }

    /**
     * 查找第一个等于给定值的元素
     *
     * @param nums [1,3,4,5,6,8,8,8,11,18]
     * @param target 8
     * @return 5
     */
    public int findFirstEqualsTargetValue(int[] nums, int target) {
      int l = 0, r = nums.length - 1;
      while (l <= r) {
        int mid = l + ((r - l) >> 1);
        if (nums[mid] < target) {
          l = mid + 1;
        } else if (nums[mid] > target) {
          r = mid - 1;
        } else {
          if (mid == 0 || nums[mid - 1] != target) return mid;
          else r = mid - 1;
        }
      }
      return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param nums [1,3,4,5,6,8,8,8,11,18]
     * @param target 8
     * @return 7
     */
    public int findLastEqualsTargetValue(int[] nums, int target) {
      int l = 0, r = nums.length - 1;
      while (l <= r) {
        int mid = l + ((r - l) >> 1);
        if (nums[mid] > target) {
          r = mid - 1;
        } else if (nums[mid] < target) {
          l = mid + 1;
        } else {
          if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
          else l = mid + 1;
        }
      }
      return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param nums [3,4,6,7,10]
     * @param target 5
     * @return 8
     */
    public int findFirstLargeOrEqualsTargetValue(int[] nums, int target) {
      int l = 0, r = nums.length - 1;
      while (l <= r) {
        int mid = l + ((r - l) >> 1);
        if (nums[mid] >= target) {
          if (mid == 0 || nums[mid - 1] < target) return nums[mid];
          else r = mid - 1;
        } else l = mid + 1;
      }
      return -1;
    }

    /**
     * 查找最后一个大于等于给定值的元素
     *
     * @param nums [3,4,6,7,10]
     * @param target 5
     * @return 8
     */
    public int findLastLargeOrEqualsTargetValue(int[] nums, int target) {
      int l = 0, r = nums.length - 1;
      while (l <= r) {
        int mid = l + ((r - l) >> 1);
        if (nums[mid] <= target) {
          if (mid == nums.length - 1 || nums[mid + 1] > target) return nums[mid];
          else l = mid + 1;
        } else r = mid - 1;
      }
      return -1;
    }
  }
}
