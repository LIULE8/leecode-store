// 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
//
// 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
//
// 以数组形式返回答案。
//
//
//
// 示例 1：
//
// 输入：nums = [8,1,2,2,3]
// 输出：[4,0,1,1,3]
// 解释：
// 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
// 对于 nums[1]=1 不存在比它小的数字。
// 对于 nums[2]=2 存在一个比它小的数字：（1）。
// 对于 nums[3]=2 存在一个比它小的数字：（1）。
// 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
//
//
// 示例 2：
//
// 输入：nums = [6,5,4,8]
// 输出：[2,1,0,3]
//
//
// 示例 3：
//
// 输入：nums = [7,7,7,7]
// 输出：[0,0,0,0]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 500
// 0 <= nums[i] <= 100
//
// Related Topics 数组 哈希表
// 1365. 有多少小于当前数字的数字

package com.leo.algorithm.easy;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
  public static void main(String[] args) {
    Printer.printArray(
        new Solution().smallerNumbersThanCurrent(DataBuilder.buildIntArray("8,1,2,2,3")));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.4 MB , 在所有 Java 提交中击败了 96.85% 的用户
     *
     * <p>计数排序
     *
     * <p>注意到数组元素的值域为 [0,100]，所以可以考虑建立一个频次数组 cnt ，
     *
     * <p>cnt[i] 表示数字 i 出现的次数。那么对于数字 i 而言，小于它的数目就为 cnt[0...i-1] 的总和。
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
      int[] cut = new int[101];
      for (int num : nums) {
        cut[num]++;
      }
      for (int i = 1; i < 101; i++) {
        cut[i] += cut[i - 1];
      }
      int[] res = new int[nums.length];
      for (int i = 0; i < nums.length; i++) {
        res[i] = nums[i] == 0 ? 0 : cut[nums[i] - 1];
      }
      return res;
    }
  }
}
