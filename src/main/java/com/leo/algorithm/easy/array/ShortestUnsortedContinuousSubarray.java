// 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
// 你找到的子数组应是最短的，请输出它的长度。
//
// 示例 1:
//
//
// 输入: [2, 6, 4, 8, 10, 9, 15]
// 输出: 5
// 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
//
//
// 说明 :
//
//
// 输入的数组长度范围在 [1, 10,000]。
// 输入的数组可能包含重复元素 ，所以升序的意思是<=。
//
// Related Topics 数组
// 581. 最短无序连续子数组

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ShortestUnsortedContinuousSubarray {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        5, new Solution().findUnsortedSubarray(DataBuilder.buildIntArray("2,6,4,8,10,9,15")));
    Printer.printCorrectAnswer(
        0, new Solution().findUnsortedSubarray(DataBuilder.buildIntArray("1,2,3,4")));
  }

  static class Solution {
    public int findUnsortedSubarray(int[] nums) {
      return method(nums);
    }

    /**
     * 执行用时： 1027 ms , 在所有 Java 提交中击败了 5.93% 的用户
     *
     * <p>内存消耗： 40.7 MB , 在所有 Java 提交中击败了 19.05% 的用户
     *
     * @param nums
     * @return
     */
    private int method(int[] nums) {
      if (nums == null || nums.length == 0) return 0;
      int minIndex = nums.length - 1;
      int maxIndex = 0;
      for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[i] > nums[j]) {
            minIndex = Math.min(minIndex, i);
            maxIndex = Math.max(maxIndex, j);
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
          }
        }
      }
      return maxIndex > minIndex ? maxIndex - minIndex + 1 : 0;
    }
  }
}
