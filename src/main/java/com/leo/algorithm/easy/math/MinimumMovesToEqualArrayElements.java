// 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。
//
//
//
// 示例：
//
//
// 输入：
// [1,2,3]
// 输出：
// 3
// 解释：
// 只需要3次操作（注意每次操作会增加两个元素的值）：
// [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
//
// Related Topics 数学
// 453. 最小操作次数使数组元素相等

package com.leo.algorithm.easy.math;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        1, new Solution().minMoves(DataBuilder.buildIntArray("1,1000000000")));
  }

  static class Solution {
    public int minMoves(int[] nums) {
      //      return method1(nums);
      return method2(nums);
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 80.28% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 49.51% 的用户
     *
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
      int min = Integer.MAX_VALUE;
      for (int num : nums) {
        min = Math.min(num, min);
      }
      int sum = 0;
      for (int num : nums) {
        sum += (num - min);
      }
      return sum;
    }

    /**
     * 超出时间限制
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      Arrays.sort(nums);
      int max = nums[nums.length - 1], count = 0;
      for (int i = nums.length - 2; i >= 0; i--) {
        if (max != nums[i]) {
          for (int j = nums.length - 2; j >= 0; j--) {
            nums[j]++;
          }
          count++;
          i = nums.length - 1;
        }
      }
      return count;
    }
  }
}
