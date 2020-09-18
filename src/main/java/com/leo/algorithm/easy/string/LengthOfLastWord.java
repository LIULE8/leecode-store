// 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//
// 如果不存在最后一个单词，请返回 0 。
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
//
//
//
// 示例:
//
// 输入: "Hello World"
// 输出: 5
//
// Related Topics 字符串
// 58. 最后一个单词的长度

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class LengthOfLastWord {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(5, new Solution().lengthOfLastWord("Hello World"));
    Printer.printCorrectAnswer(5, new Solution().lengthOfLastWord("Hello"));
    Printer.printCorrectAnswer(5, new Solution().lengthOfLastWord("Hello "));
    Printer.printCorrectAnswer(0, new Solution().lengthOfLastWord(" "));
    Printer.printCorrectAnswer(0, new Solution().lengthOfLastWord("  "));
    Printer.printCorrectAnswer(1, new Solution().lengthOfLastWord(" H "));
    Printer.printCorrectAnswer(1, new Solution().lengthOfLastWord("H  "));
  }

  static class Solution {

    public int lengthOfLastWord(String s) {
      //      return method1(s);
      return method2(s);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.8 MB , 在所有 Java 提交中击败了 73.38% 的用户
     *
     * @param s
     * @return
     */
    private int method2(String s) {
      if (s.length() == 0) return 0;
      int count = 0;
      for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == ' ') {
          if (count != 0) break;
          continue;
        }
        count++;
      }
      return count;
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 41.44% 的用户
     *
     * <p>内存消耗： 37.5 MB , 在所有 Java 提交中击败了 5.11% 的用户
     *
     * @param s
     * @return
     */
    private int method1(String s) {
      String[] sh = s.split(" ");
      return sh.length != 0 ? sh[sh.length - 1].length() : 0;
    }
  }
}
