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
    //    int[] nums = DataBuilder.buildIntArray("0,1,0,3,12");
    //    int[] nums = DataBuilder.buildIntArray("1,0"); //1,0
    int[] nums = DataBuilder.buildIntArray("1,0,1");
    new Solution().moveZeroes(nums);
    Printer.printArray(nums);
  }

  static class Solution {
    public void moveZeroes(int[] nums) {
      //      method1(nums);
      //      method2(nums);
      method3(nums);
    }

    private void method3(int[] nums) {
      int j = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
          nums[j++] = nums[i];
        }
      }
      for (int i = j; i < nums.length; i++) {
        nums[i] = 0;
      }
    }

    private void method2(int[] nums) {
      int zero = 0, nozero = 0;
      while (nozero < nums.length && zero < nums.length) {
        if (nums[nozero] == 0 || nozero < zero) {
          nozero++;
          continue;
        }
        if (nums[zero] == 0) {
          int temp = nums[zero];
          nums[zero] = nums[nozero];
          nums[nozero] = temp;
          continue;
        }
        zero++;
      }
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
