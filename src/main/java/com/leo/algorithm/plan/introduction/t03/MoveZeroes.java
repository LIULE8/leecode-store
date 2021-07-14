// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
// 输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针
// 283. 移动零

package com.leo.algorithm.plan.introduction.t03;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MoveZeroes {
  public static void main(String[] args) {
    //    int[] nums = DataBuilder.buildIntArray("0,1,0,3,12");
    //            int[] nums = DataBuilder.buildIntArray("1,0"); //1,0
    int[] nums = DataBuilder.buildIntArray("1,0,1");
    new Solution().moveZeroes(nums);
    Printer.printArray(nums);
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.8 MB , 在所有 Java 提交中击败了 31.40% 的用户
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
      if (nums == null || nums.length == 0) return;
      int j = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          nums[j++] = nums[i];
        }
      }
      for (int i = j; i < nums.length; i++) {
        nums[j++] = 0;
      }
    }
  }
}
