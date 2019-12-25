package com.leo.easy.array;

import com.leo.utils.DataBuilder;
import com.leo.utils.Printer;

import java.awt.print.Pageable;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * <p>给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * <p>函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * <p>说明:
 *
 * <p>返回的下标值（index1 和 index2）不是从零开始的。 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 示例:
 *
 * <p>输入: numbers = [2, 7, 11, 15], target = 9 输出: [1,2] 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2
 * = 2 。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSumIiInputArrayIsSorted {
  public static void main(String[] args) {
    int[] nums = DataBuilder.buildIntArray("2,7,11,15");
    int[] result = new Solution().twoSum(nums, 9);
    Printer.printArray(result);
  }

  static class Solution {
    public int[] twoSum(int[] numbers, int target) {
      return method1(numbers, target);
    }

    /**
     * 执行用时 : 1 ms , 在所有 java 提交中击败了 99.12% 的用户
     *
     * <p>内存消耗 : 37.9 MB , 在所有 java 提交中击败了 54.55% 的用户
     *
     * <p>双指针法： 首尾指针
     *
     * @param numbers
     * @param target
     * @return
     */
    private int[] method1(int[] numbers, int target) {
      if (numbers == null || numbers.length == 0) return new int[0];
      int l = 0;
      int r = numbers.length - 1;
      while (l <= r) {
        if (numbers[l] + numbers[r] == target) {
          return new int[] {l + 1, r + 1};
        } else if (numbers[l] + numbers[r] > target) {
          r--;
        } else {
          l++;
        }
      }
      return new int[0];
    }
  }
}
