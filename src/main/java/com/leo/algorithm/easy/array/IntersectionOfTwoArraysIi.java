// 给定两个数组，编写一个函数来计算它们的交集。
//
//
//
// 示例 1：
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
// 输出：[2,2]
//
//
// 示例 2:
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// 输出：[4,9]
//
//
//
// 说明：
//
//
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
// 我们可以不考虑输出结果的顺序。
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 排序 哈希表 双指针 二分查找
// 350. 两个数组的交集 II

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.*;

public class IntersectionOfTwoArraysIi {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "2,2",
        new Solution()
            .intersect(DataBuilder.buildIntArray("1,2,2,1"), DataBuilder.buildIntArray("2,2")));
    Printer.printCorrectAnswer(
        "4,9",
        new Solution()
            .intersect(DataBuilder.buildIntArray("4,9,5"), DataBuilder.buildIntArray("9,4,9,8,4")));
    Printer.printCorrectAnswer(
        "1",
        new Solution()
            .intersect(DataBuilder.buildIntArray("3,1,2"), DataBuilder.buildIntArray("1,1")));
    Printer.printCorrectAnswer(
        "2,83,3,41,84,13,9",
        new Solution()
            .intersect(
                DataBuilder.buildIntArray(
                    "43,85,49,2,83,2,39,99,15,70,39,27,71,3,88,5,19,5,68,34,7,41,84,2,13,85,12,54,7,9,13,19,92"),
                DataBuilder.buildIntArray(
                    "10,8,53,63,58,83,26,10,58,3,61,56,55,38,81,29,69,55,86,23,91,44,9,98,41,48,41,16,42,72,6,4,2,81,42,84,4,13")));
    Printer.printCorrectAnswer(
        "18,68,31,36,11,82,3,91,21,26,15,89,40,87,24,8,80,11,51,70,19",
        new Solution()
            .intersect(
                DataBuilder.buildIntArray(
                    "93,57,18,68,93,31,36,11,27,82,3,91,58,36,21,26,72,53,15,9,56,68,89,37,54,40,87,61,82,24,8,68,80,36,31,11,51,45,66,78,70,93,44,45,19,23"),
                DataBuilder.buildIntArray(
                    "24,30,85,26,19,82,20,92,34,31,15,43,83,40,15,0,87,60,11,2,0,26,49,14,19,18,55,21,96,68,30,50,11,59,8,89,51,59,76,16,59,28,88,3,87,94,0,36,70,80,8,65,84,88,28,91,96")));
  }

  static class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
      //      return method1(nums1, nums2);
      //      return method2(nums1, nums2);
      return method3(nums1, nums2);
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 86.43% 的用户
     *
     * <p>内存消耗： 38.5 MB , 在所有 Java 提交中击败了 80.68% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] method3(int[] nums1, int[] nums2) {
      Arrays.sort(nums1);
      Arrays.sort(nums2);
      int i = 0, j = 0;
      List<Integer> list = new LinkedList<>();
      while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
          i++;
        } else if (nums1[i] > nums2[j]) {
          j++;
        } else {
          list.add(nums1[i]);
          i++;
          j++;
        }
      }
      int k = 0;
      int[] res = new int[list.size()];
      for (Integer num : list) {
        res[k++] = num;
      }
      return res;
    }

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 57.14% 的用户
     *
     * <p>内存消耗： 40 MB , 在所有 Java 提交中击败了 5.13% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] method2(int[] nums1, int[] nums2) {
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> list = new ArrayList<>();
      for (int value : nums1) {
        map.put(value, map.getOrDefault(value, 0) + 1);
      }
      for (int value : nums2) {
        Integer integer = map.get(value);
        if (integer != null && integer > 0) {
          list.add(value);
          map.put(value, map.get(value) - 1);
        }
      }
      int[] result = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        result[i] = list.get(i);
      }
      return result;
    }

    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 17.77% 的用户
     *
     * <p>内存消耗： 39.5 MB , 在所有 Java 提交中击败了 5.13% 的用户
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] method1(int[] nums1, int[] nums2) {
      List<Integer> list = new ArrayList<>();

      Arrays.sort(nums1);
      Arrays.sort(nums2);

      if (nums1.length > nums2.length) {
        int[] temp = nums1;
        nums1 = nums2;
        nums2 = temp;
      }

      for (int i = 0; i < nums1.length; i++) {
        int a = 1;
        while (i < nums1.length - 1 && nums1[i] == nums1[i + 1]) {
          i++;
          a++;
        }
        int b = 0;
        for (int j = 0; j < nums2.length; j++) {
          while (j < nums2.length && nums1[i] == nums2[j]) {
            j++;
            b++;
          }
        }
        if (b > 0) {
          int min = Math.min(a, b);
          for (int j = 0; j < min; j++) {
            list.add(nums1[i]);
          }
        }
      }

      int[] result = new int[list.size()];
      for (int i = 0; i < list.size(); i++) {
        result[i] = list.get(i);
      }
      return result;
    }
  }
}
