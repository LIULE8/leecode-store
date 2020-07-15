// 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
//
// 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
//
//
//
// 示例 1:
//
// 输入: nums = [4,2,3]
// 输出: true
// 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
//
//
// 示例 2:
//
// 输入: nums = [4,2,1]
// 输出: false
// 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
//
//
//
//
// 说明：
//
//
// 1 <= n <= 10 ^ 4
// - 10 ^ 5 <= nums[i] <= 10 ^ 5
//
// Related Topics 数组
// 665. 非递减数列

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class NonDecreasingArray {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true, new Solution().checkPossibility(DataBuilder.buildIntArray("4,2,3")));
    Printer.printCorrectAnswer(
        false, new Solution().checkPossibility(DataBuilder.buildIntArray("4,2,1")));
    Printer.printCorrectAnswer(
        false, new Solution().checkPossibility(DataBuilder.buildIntArray("3,4,2,3")));
    Printer.printCorrectAnswer(
        true, new Solution().checkPossibility(DataBuilder.buildIntArray("1,1,1")));
  }

  static class Solution {
    //  4，2，3
    //  -1，4，2，3
    //  2，3，3，2，4
    // [1]有时候需要修改前面较大的数字(比如前两个例子需要修改4)，
    // [2]有时候却要修改后面较小的那个数字(比如前第三个例子需要修改2)，
    // 那么有什么内在规律吗？是有的，判断修改那个数字(i)其实跟再前面一个数(i-2)的大小有关系，
    // 假设当前修改的数字是 2
    // 首先如果再前面的数(i-2)不存在，比如例子1，4前面没有数字了，我们直接修改前面的数字为当前的数字2即可。
    // 而当再前面的数字(i-2)存在，并且小于当前数(i)时，比如例子2，-1小于2，我们还是需要修改前面的数字4为当前数字2；
    // 如果再前面的数(i-2)大于当前数(i)，比如例子3，3大于2，我们需要修改当前数2为前面的数3。

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.90% 的用户
     *
     * <p>内存消耗： 40.7 MB , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
      if (nums == null || nums.length == 0) return false;
      int count = 0;
      for (int i = 1; i < nums.length && count < 2; i++) {
        if (nums[i - 1] <= nums[i]) {
          continue;
        }
        // nums[i-1] > nums[i]
        count++;
        if (i - 2 < 0 || nums[i - 2] < nums[i]) {
          nums[i - 1] = nums[i];
        } else {
          nums[i] = nums[i - 1];
        }
      }
      return count < 2;
    }
  }
}
