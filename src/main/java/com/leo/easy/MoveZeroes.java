package com.leo.easy;

import com.leo.utils.DataBuilder;
import com.leo.utils.Printer;

/**
 * 283. 移动零
 *
 * <p>给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * <p>示例:
 *
 * <p>输入: [0,1,0,3,12] 输出: [1,3,12,0,0] 说明:
 *
 * <p>必须在原数组上操作，不能拷贝额外的数组。 尽量减少操作次数。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes {
  public static void main(String[] args) {
    int[] nums = DataBuilder.buildIntArray("0,1,0,3,12");
    new Solution().moveZeroes(nums);
    Printer.printArray(nums);
  }

  static class Solution {
    public void moveZeroes(int[] nums) {
//      method1(nums);

    }

    private void method1(int[] nums) {
      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] != 0) {
          continue;
        }
        for (int j = i + 1; j < nums.length; j++) {
          if (nums[j] != 0) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            break;
          }
        }
      }
    }
  }
}
