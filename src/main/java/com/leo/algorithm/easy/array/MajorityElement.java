package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;

import java.util.Arrays;

/**
 * 169. 多数元素
 *
 * <p>给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * <p>你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * <p>示例 1:
 *
 * <p>输入: [3,2,3] 输出: 3 示例 2:
 *
 * <p>输入: [2,2,1,1,1,2,2] 输出: 2
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MajorityElement {
  public static void main(String[] args) {
    int[] ints = DataBuilder.buildIntArray("3,2,3");
    //    int[] ints = DataBuilder.buildIntArray("2,2,1,1,1,2,2");
    int i = new Solution().majorityElement(ints);
    System.out.println(i);
  }

  static class Solution {
    public int majorityElement(int[] nums) {
      //        return method1(nums);
      //      return method2(nums);
      return method3(nums);
    }

    private int method3(int[] nums) {
      int count = 1;
      int num = nums[0];
      for (int i = 1; i < nums.length; i++) {
        if (num == nums[i]) {
          count++;
        } else {
          count--;
          if (count == 0) {
            num = nums[i + 1];
          }
        }
      }
      return num;
    }

    private int method2(int[] nums) {
      Arrays.sort(nums);
      return nums[nums.length >> 1];
    }

    private int method1(int[] nums) {
      Arrays.sort(nums);
      int maxCount = 0;
      int maxNum = nums[0];
      for (int i = 0, count = 0; i < nums.length; i++) {
        if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
          count++;
          continue;
        }
        if (++count > maxCount) {
          maxCount = count;
          maxNum = nums[i];
          count = 0;
        }
      }
      return maxNum;
    }
  }
}
