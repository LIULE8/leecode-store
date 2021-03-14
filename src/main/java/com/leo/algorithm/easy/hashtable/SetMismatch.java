// 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
// 一个数字重复 。
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。
//
// 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
//
//
//
// 示例 1：
//
//
// 输入：nums = [1,2,2,4]
// 输出：[2,3]
//
//
// 示例 2：
//
//
// 输入：nums = [1,1]
// 输出：[1,2]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 104
// 1 <= nums[i] <= 104
//
// Related Topics 哈希表 数学
// 645. 错误的集合

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class SetMismatch {
  public static void main(String[] args) {
    Printer.printArray(new Solution().findErrorNums(DataBuilder.buildIntArray("1,3,3")));
    Printer.printArray(new Solution().findErrorNums(DataBuilder.buildIntArray("2,2")));
    Printer.printArray(new Solution().findErrorNums(DataBuilder.buildIntArray("1,2,2,4")));
    Printer.printArray(new Solution().findErrorNums(DataBuilder.buildIntArray("1,1")));
    Printer.printArray(new Solution().findErrorNums(DataBuilder.buildIntArray("3,2,3,4,6,5")));
  }

  static class Solution {
    /**
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 41.32% 的用户
     *
     * <p>内存消耗： 40.2 MB , 在所有 Java 提交中击败了 31.10% 的用户
     *
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
      Arrays.sort(nums);
      int[] result = new int[nums.length + 1];
      for (int num : nums) {
        result[num]++;
      }
      int first = 0, error = 0;
      for (int i = 1; i < result.length; i++) {
        if (result[i] == 0) first = i;
        if (result[i] > 1) error = i;
        if (first != 0 && error != 0) break;
      }
      return new int[] {error, first};
    }
  }
}
