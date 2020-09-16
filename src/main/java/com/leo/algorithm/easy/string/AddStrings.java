// 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
//
//
//
// 提示：
//
//
// num1 和num2 的长度都小于 5100
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
//
// Related Topics 字符串
// 415. 字符串相加

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class AddStrings {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("168", new Solution().addStrings("123", "45"));
    Printer.printCorrectAnswer("50", new Solution().addStrings("3", "47"));
    Printer.printCorrectAnswer("47", new Solution().addStrings("0", "47"));
    Printer.printCorrectAnswer("10", new Solution().addStrings("1", "9"));
    Printer.printCorrectAnswer("100", new Solution().addStrings("1", "99"));
    Printer.printCorrectAnswer("200", new Solution().addStrings("1", "199"));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 79.68% 的用户
     *
     * <p>内存消耗： 38.7 MB , 在所有 Java 提交中击败了 87.67% 的用户
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
      StringBuilder sb = new StringBuilder();
      int c = 0, i = num1.toCharArray().length - 1, j = num2.toCharArray().length - 1;
      for (; i >= 0 & j >= 0; i--, j--) {
        int sum = (num1.charAt(i) - '0' + num2.charAt(j) - '0') + c;
        if (sum >= 10) {
          c = 1;
          sum %= 10;
        } else {
          c = 0;
        }
        sb.append(sum);
      }
      c = buildRestNum(num1, sb, c, i);
      c = buildRestNum(num2, sb, c, j);
      return sb.append(c == 1 ? c : "").reverse().toString();
    }

    private int buildRestNum(String a, StringBuilder sb, int c, int i) {
      while (i >= 0) {
        int sum = c + a.charAt(i--) - '0';
        if (sum >= 10) {
          c = 1;
          sum %= 10;
        } else {
          c = 0;
        }
        sb.append(sum);
      }
      return c;
    }
  }
}
