// 统计一个数字在排序数组中出现的次数。
//
//
//
// 示例 1:
//
// 输入: nums = [5,7,7,8,8,10], target = 8
// 输出: 2
//
// 示例 2:
//
// 输入: nums = [5,7,7,8,8,10], target = 6
// 输出: 0
//
//
//
// 限制：
//
// 0 <= 数组长度 <= 50000
//
//
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
// position-of-element-in-sorted-array/
// Related Topics 数组 二分查找
// 剑指 Offer 53 - I. 在排序数组中查找数字 I

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        2, new Solution().search(DataBuilder.buildIntArray("5,7,7,8,8,10"), 8));
    Printer.printCorrectAnswer(
        0, new Solution().search(DataBuilder.buildIntArray("5,7,7,8,8,10"), 6));
  }

  static class Solution {
    public int search(int[] nums, int target) {
      //      return method1(nums, target);
      //      return method2(nums, target);
      //      return method3(nums, target);
      return method4(nums, target);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 41.3 MB , 在所有 Java 提交中击败了 71.22% 的用户 相比较方法三，可读性更高
     *
     * @param nums
     * @param target
     * @return
     */
    private int method4(int[] nums, int target) {
      int l = 0, mid = 0, r = nums.length - 1;
      while (l <= r) {
        mid = l + ((r - l) >> 1);
        if (nums[mid] > target) {
          r = mid - 1;
        } else if (nums[mid] < target) {
          l = mid + 1;
        } else {
          if ((mid == 0) || nums[mid - 1] != nums[mid]) break;
          else r = mid - 1;
        }
      }
      int count = 0;
      while (mid < nums.length && nums[mid++] == target) count++;
      return count;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 42.5 MB , 在所有 Java 提交中击败了 72.88% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    private int method3(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;
      while (l <= r) {
        int mid = (l + r) >> 1;
        if (nums[mid] >= target) r = mid - 1;
        else if (nums[mid] < target) l = mid + 1;
      }
      int count = 0;
      while (l < nums.length && nums[l++] == target) count++;
      return count;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 42.4 MB , 在所有 Java 提交中击败了 93.07% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    private int method2(int[] nums, int target) {
      int l = 0;
      int r = nums.length - 1;
      int index = -1;
      while (l <= r) {
        int mid = (l + r) >> 1;
        if (nums[mid] == target) {
          index = mid;
          break;
        } else if (nums[mid] < target) l = mid + 1;
        else r = mid - 1;
      }
      if (index == -1) return 0;
      int count = 1, lIndex = index - 1, rIndex = index + 1;
      while (lIndex >= 0) {
        if (nums[lIndex] == target) {
          count++;
          lIndex--;
        } else break;
      }
      while (rIndex < nums.length) {
        if (nums[rIndex] == target) {
          count++;
          rIndex++;
        } else break;
      }
      return count;
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 29.50% 的用户
     *
     * <p>内存消耗： 42.4 MB , 在所有 Java 提交中击败了 92.77% 的用户
     *
     * @param nums
     * @param target
     * @return
     */
    private int method1(int[] nums, int target) {
      if (nums.length == 0) return 0;
      int count = 0;
      for (int num : nums) {
        if (target == num) count++;
      }
      return count;
    }
  }
}
