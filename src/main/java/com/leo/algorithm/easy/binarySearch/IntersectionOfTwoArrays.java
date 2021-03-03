// 给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
// 输出：[2]
//
//
// 示例 2：
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// 输出：[9,4]
//
//
//
// 说明：
//
//
// 输出结果中的每个元素一定是唯一的。
// 我们可以不考虑输出结果的顺序。
//
// Related Topics 排序 哈希表 双指针 二分查找
// 349. 两个数组的交集

package com.leo.algorithm.easy.binarySearch;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.*;

public class IntersectionOfTwoArrays {
  public static void main(String[] args) {
    Printer.printArray(
        new Solution()
            .intersection(DataBuilder.buildIntArray("1,2,2,1"), DataBuilder.buildIntArray("2,2")));
    Printer.printArray(
        new Solution()
            .intersection(
                DataBuilder.buildIntArray("4,9,5"), DataBuilder.buildIntArray("9,4,9,8,4")));
  }

  static class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      //      return method1(nums1, nums2);
      return method2(nums1, nums2);
    }

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 35.68% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 65.67% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] method2(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Set<Integer> sets = new HashSet<>(nums1.length);
      for (int num : nums2) {
        int index = binarySearch(nums1, num);
        if (index != -1) {
          sets.add(num);
        }
      }
      int[] res = new int[sets.size()];
      int k = 0;
      for (Integer num : sets) {
        res[k++] = num;
      }
      return res;
    }

    private int binarySearch(int[] nums, int target) {
      int low = 0;
      int high = nums.length - 1;
      while (low <= high) {
        int mid = low + ((high - low) >> 1);
        if (nums[mid] == target) {
          return mid;
        } else if (nums[mid] < target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      return -1;
    }

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] method1(int[] nums1, int[] nums2) {
      Set<Integer> set1 = new HashSet<>();
      for (int i : nums1) {
        set1.add(i);
      }
      Set<Integer> list = new HashSet<>();
      for (int i : nums2) {
        if (set1.contains(i)) {
          list.add(i);
        }
      }
      int[] res = new int[list.size()];
      int k = 0;
      for (Integer i : list) {
        res[k++] = i;
      }
      return res;
    }
  }
}
