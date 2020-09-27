// 给一个 非空 字符串 s 和一个单词缩写 abbr ，判断这个缩写是否可以是给定单词的缩写。
//
// 字符串 "word" 的所有有效缩写为：
//
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
// "w1r1", "1o2", "2r1", "3d", "w3", "4"]
//
// 注意单词 "word" 的所有有效缩写仅包含以上这些。任何其他的字符串都不是 "word" 的有效缩写。
//
// 注意:
// 假设字符串 s 仅包含小写字母且 abbr 只包含小写字母和数字。
//
// 示例 1:
//
// 给定 s = "internationalization", abbr = "i12iz4n":
//
// 函数返回 true.
//
//
//
//
// 示例 2:
//
// 给定 s = "apple", abbr = "a2e":
//
// 函数返回 false.
//
//
//
// Related Topics 字符串
// 408. 有效单词缩写

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ValidWordAbbreviation {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().validWordAbbreviation("abbreviation", "a10n"));
    Printer.printCorrectAnswer(false, new Solution().validWordAbbreviation("a", "01"));
    Printer.printCorrectAnswer(
        true, new Solution().validWordAbbreviation("internationalization", "i5a11o1"));
    Printer.printCorrectAnswer(
        true, new Solution().validWordAbbreviation("internationalization", "i12iz4n"));
    Printer.printCorrectAnswer(false, new Solution().validWordAbbreviation("apple", "a2e"));
    Printer.printCorrectAnswer(false, new Solution().validWordAbbreviation("a", "2"));
    Printer.printCorrectAnswer(false, new Solution().validWordAbbreviation("hi", "1"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.4 MB , 在所有 Java 提交中击败了 15.31% 的用户
     *
     * @param word
     * @param abbr
     * @return
     */
    public boolean validWordAbbreviation(String word, String abbr) {
      int k = 0, sum = 0;
      for (int i = 0; i < abbr.length(); i++) {
        char ch = abbr.charAt(i);
        if (ch >= '0' && ch <= '9') {
          if (sum == 0 && ch == '0') return false;
          sum = sum * 10 + ch - '0';
          continue;
        }
        k += sum;
        if (k < word.length() && word.charAt(k++) == ch) sum = 0;
        else return false;
      }
      return sum == 0 || k + sum == word.length();
    }
  }
}
