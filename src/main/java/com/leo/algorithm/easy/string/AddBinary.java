// 给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
// 输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
// 输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 数学 字符串
// 67. 二进制求和

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class AddBinary {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("100", new Solution().addBinary("11", "1"));
    Printer.printCorrectAnswer("10101", new Solution().addBinary("1010", "1011"));
    Printer.printCorrectAnswer("0", new Solution().addBinary("0", "0"));
    Printer.printCorrectAnswer("1000", new Solution().addBinary("1", "111"));
    Printer.printCorrectAnswer("11110", new Solution().addBinary("1111", "1111"));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 61.52% 的用户
     *
     * <p>内存消耗： 37.5 MB , 在所有 Java 提交中击败了 62.98% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
      StringBuilder sb = new StringBuilder();
      int c = 0, i = a.toCharArray().length - 1, j = b.toCharArray().length - 1;
      for (; i >= 0 && j >= 0; i--, j--) {
        int sum = a.charAt(i) - '0' + b.charAt(j) - '0' + c;
        if (sum >= 2) {
          sum %= 2;
          c = 1;
        } else {
          c = 0;
        }
        sb.append(sum);
      }
      c = buildRestNum(a, c, i, sb);
      c = buildRestNum(b, c, j, sb);
      if (c == 1) {
        sb.append(1);
      }
      return sb.reverse().toString();
    }

    private int buildRestNum(String a, int c, int i, StringBuilder sb) {
      while (i >= 0) {
        int sum = a.charAt(i--) - '0' + c;
        if (sum == 2) {
          sum = 0;
          c = 1;
        } else {
          c = 0;
        }
        sb.append(sum);
      }
      return c;
    }
  }
}
