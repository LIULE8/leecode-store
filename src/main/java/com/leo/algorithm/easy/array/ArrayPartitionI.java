package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;

import java.util.Arrays;

/**
 * 561. 数组拆分 I
 *
 * <p>给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi)
 * 总和最大。
 *
 * <p>示例 1:
 *
 * <p>输入: [1,4,3,2]
 *
 * <p>输出: 4 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4). 提示:
 *
 * <p>n 是正整数,范围在 [1, 10000]. 数组中的元素范围在 [-10000, 10000].
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/array-partition-i
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayPartitionI {
  public static void main(String[] args) {
    int[] ints = DataBuilder.buildIntArray("1,4,3,2");
    int i = new Solution().arrayPairSum(ints);
    System.out.println(i);
  }

  static class Solution {
    public int arrayPairSum(int[] nums) {
      return method1(nums);
    }

    /**
     * 执行用时 : 18 ms , 在所有 java 提交中击败了 90.91% 的用户
     *
     * <p>内存消耗 : 39.3 MB , 在所有 java 提交中击败了 97.47% 的用户
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
      Arrays.sort(nums);
      int sum = 0;
      for (int i = 0; i < nums.length; i += 2) {
        sum += nums[i];
      }
      return sum;
    }
  }
}
