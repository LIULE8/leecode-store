// 有一个数组，其中的值符合等差数列的数值规律，也就是说：
//
//
// 在 0 <= i < arr.length - 1 的前提下，arr[i+1] - arr[i] 的值都相等。
//
//
// 我们会从该数组中删除一个 既不是第一个 也 不是最后一个的值，得到一个新的数组 arr。
//
// 给你这个缺值的数组 arr，请你帮忙找出被删除的那个数。
//
//
//
// 示例 1：
//
// 输入：arr = [5,7,11,13]
// 输出：9
// 解释：原来的数组是 [5,7,9,11,13]。
//
//
// 示例 2：
//
// 输入：arr = [15,13,12]
// 输出：14
// 解释：原来的数组是 [15,14,13,12]。
//
//
//
// 提示：
//
//
// 3 <= arr.length <= 1000
// 0 <= arr[i] <= 10^5
//
// Related Topics 数学
// 1228. 等差数列中缺失的数字

package com.leo.algorithm.easy.math;

import com.leo.algorithm.utils.DataBuilder;

public class MissingNumberInArithmeticProgression {
  public static void main(String[] args) {
    int i = new Solution().missingNumber(DataBuilder.buildIntArray("15,13,12"));
    System.out.println(i);
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.3 MB , 在所有 Java 提交中击败了 8.22% 的用户
     *
     * @param arr
     * @return
     */
    public int missingNumber(int[] arr) {
      int a = arr[1] - arr[0];
      int b = arr[arr.length - 1] - arr[arr.length - 2];
      int min = a > 0 ? Math.min(a, b) : Math.max(a, b);
      for (int i = 1; i < arr.length; i++) {
        if (arr[i - 1] + min != arr[i]) {
          return arr[i - 1] + min;
        }
      }
      return -1;
    }
  }
}
