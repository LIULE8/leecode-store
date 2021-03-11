// 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
//
// 你可以返回任何满足上述条件的数组作为答案。
//
//
//
// 示例：
//
// 输入：[4,2,5,7]
// 输出：[4,5,2,7]
// 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
//
//
//
//
// 提示：
//
//
// 2 <= A.length <= 20000
// A.length % 2 == 0
// 0 <= A[i] <= 1000
//
//
//
// Related Topics 排序 数组
// 922. 按奇偶排序数组 II

package com.leo.algorithm.easy.order;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class SortArrayByParityIi {
  public static void main(String[] args) {
    Printer.printArray(new Solution().sortArrayByParityII(DataBuilder.buildIntArray("4,2,5,7")));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 78.45% 的用户
     *
     * <p>内存消耗： 41.3 MB , 在所有 Java 提交中击败了 24.40% 的用户
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParityII(int[] nums) {
      int[] B = new int[nums.length];
      int odd = 1, even = 0;
      for (int value : nums) {
        if ((value & 1) == 0) {
          B[even] = value;
          even += 2;
        } else {
          B[odd] = value;
          odd += 2;
        }
      }
      return B;
    }
  }
}
