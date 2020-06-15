// 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。
//
// 示例 1:
//
// 输入: [1,2,3]
// 输出: [1,2,4]
// 解释: 输入数组表示数字 123。
//
//
// 示例 2:
//
// 输入: [4,3,2,1]
// 输出: [4,3,2,2]
// 解释: 输入数组表示数字 4321。
//
// Related Topics 数组

package com.leo.easy.array;

import com.leo.utils.DataBuilder;
import com.leo.utils.Printer;

public class PlusOne {
  public static void main(String[] args) {
    Printer.printArray(new Solution().plusOne(DataBuilder.buildIntArray("9"))); // 1, 0
    Printer.printArray(new Solution().plusOne(DataBuilder.buildIntArray("1, 9"))); // 2, 0
    Printer.printArray(new Solution().plusOne(DataBuilder.buildIntArray("9, 1"))); // 9, 2
    Printer.printArray(new Solution().plusOne(DataBuilder.buildIntArray("9, 9"))); // 1, 0, 0
  }

  static class Solution {
    /**
     * 执行用时 :0 ms, 在所有 Java 提交中击败了100.00%的用户
     *
     * <p>内存消耗 :38.1 MB, 在所有 Java 提交中击败了5.63%的用户
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
      if (digits == null || digits.length == 0) {
        return new int[] {};
      }
      int index = digits.length - 1;
      if (digits[index] != 9) {
        digits[index] += 1;
        return digits;
      }
      int crr = 1;
      int[] res = new int[digits.length + 1];
      for (int i = digits.length - 1; i >= 0; i--) {
        digits[i] = digits[i] + crr;
        if (digits[i] >= 10) {
          digits[i] = 0;
          res[i + 1] = digits[i];
          if (i == 0) res[i] = 1;
          continue;
        }
        res[i + 1] = digits[i];
        break;
      }
      return res[0] == 1 ? res : digits;
    }
  }
}
