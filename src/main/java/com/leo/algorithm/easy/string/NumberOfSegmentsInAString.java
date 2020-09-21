// 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。
//
// 示例:
//
// 输入: "Hello, my name is John"
// 输出: 5
// 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
//
// Related Topics 字符串
// 434. 字符串中的单词数

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class NumberOfSegmentsInAString {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(5, new Solution().countSegments("Hello, my name is John"));
    Printer.printCorrectAnswer(5, new Solution().countSegments("Hello, my name is John    "));
  }

  static class Solution {
    public int countSegments(String s) {
      return method1(s);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.5 MB , 在所有 Java 提交中击败了 66.14% 的用户
     *
     * @param s
     * @return
     */
    private int method1(String s) {
      int count = 0;
      int charCount = 0;
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') {
          if (charCount != 0) {
            count++;
            charCount = 0;
          }
        } else {
          charCount++;
        }
      }
      return charCount > 0 ? count + 1 : count;
    }
  }
}
