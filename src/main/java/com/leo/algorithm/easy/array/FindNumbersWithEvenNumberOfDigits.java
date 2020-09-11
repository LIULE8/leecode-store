// 给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
//
//
//
// 示例 1：
//
// 输入：nums = [12,345,2,6,7896]
// 输出：2
// 解释：
// 12 是 2 位数字（位数为偶数）
// 345 是 3 位数字（位数为奇数）
// 2 是 1 位数字（位数为奇数）
// 6 是 1 位数字 位数为奇数）
// 7896 是 4 位数字（位数为偶数）
// 因此只有 12 和 7896 是位数为偶数的数字
//
//
// 示例 2：
//
// 输入：nums = [555,901,482,1771]
// 输出：1
// 解释：
// 只有 1771 是位数为偶数的数字。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 500
// 1 <= nums[i] <= 10^5
//
// Related Topics 数组
// 1295. 统计位数为偶数的数字

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class FindNumbersWithEvenNumberOfDigits {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        2, new Solution().findNumbers(DataBuilder.buildIntArray("12,345,2,6,7896")));
    Printer.printCorrectAnswer(
        1, new Solution().findNumbers(DataBuilder.buildIntArray("555,901,482,1771")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.6 MB , 在所有 Java 提交中击败了 15.16% 的用户
     *
     * @param nums
     * @return
     */
    public int findNumbers(int[] nums) {
      int count = 0;
      for (int num : nums) {
        count += getEvenNumberOfDigits(num);
      }
      return count;
    }

    private int getEvenNumberOfDigits(int num) {
      if (num < 10) return 0;
      int count = 0;
      while (num > 0) {
        count++;
        num /= 10;
      }
      return count % 2 == 0 ? 1 : 0;
    }
  }
}
