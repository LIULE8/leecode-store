// 实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
//
//
//
// 示例 1：
//
//
// 输入: "Hello"
// 输出: "hello"
//
// 示例 2：
//
//
// 输入: "here"
// 输出: "here"
//
// 示例 3：
//
//
// 输入: "LOVELY"
// 输出: "lovely"
//
// Related Topics 字符串
// 709. 转换成小写字母

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ToLowerCase {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("hello", new Solution().toLowerCase("Hello"));
    Printer.printCorrectAnswer("here", new Solution().toLowerCase("here"));
    Printer.printCorrectAnswer("lovely", new Solution().toLowerCase("LOVELY"));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.5 MB , 在所有 Java 提交中击败了 71.69% 的用户
     *
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
      //      return str.toLowerCase();
      char[] chars = str.toCharArray();
      StringBuilder sb = new StringBuilder();
      for (char aChar : chars) {
        char ch = aChar;
        if (aChar >= 'A' && aChar <= 'Z') {
          ch = (char) (aChar + 32);
        }
        sb.append(ch);
      }
      return sb.toString();
    }
  }
}
