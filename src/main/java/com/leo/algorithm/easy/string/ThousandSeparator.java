// 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
//
//
//
// 示例 1：
//
// 输入：n = 987
// 输出："987"
//
//
// 示例 2：
//
// 输入：n = 1234
// 输出："1.234"
//
//
// 示例 3：
//
// 输入：n = 123456789
// 输出："123.456.789"
//
//
// 示例 4：
//
// 输入：n = 0
// 输出："0"
//
//
//
//
// 提示：
//
//
// 0 <= n < 2^31
//
// Related Topics 字符串
// 1556. 千位分隔数

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ThousandSeparator {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("987", new Solution().thousandSeparator(987));
    Printer.printCorrectAnswer("1.234", new Solution().thousandSeparator(1234));
    Printer.printCorrectAnswer("123.456.789", new Solution().thousandSeparator(123456789));
    Printer.printCorrectAnswer("12.345.678", new Solution().thousandSeparator(12345678));
    Printer.printCorrectAnswer("0", new Solution().thousandSeparator(0));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.4 MB , 在所有 Java 提交中击败了 99.70% 的用户
     *
     * @param n
     * @return
     */
    public String thousandSeparator(int n) {
      String s = String.valueOf(n);
      if (s.length() < 3) return s;
      StringBuilder sb = new StringBuilder();
      int i = s.length() - 1;
      for (; i - 2 >= 0; i--) {
        sb.append(s.charAt(i--)).append(s.charAt(i--)).append(s.charAt(i));
        if (i != 0) {
          sb.append(".");
        }
      }
      int index = i - 2;
      if (index == -1) return sb.append(s.charAt(1)).append(s.charAt(0)).reverse().toString();
      else if (index == -2) return sb.append(s.charAt(0)).reverse().toString();
      return sb.reverse().toString();
    }
  }
}
