// 给定一个单词，你需要判断单词的大写使用是否正确。
//
// 我们定义，在以下情况时，单词的大写用法是正确的：
//
//
// 全部字母都是大写，比如"USA"。
// 单词中所有字母都不是大写，比如"leetcode"。
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
//
//
// 否则，我们定义这个单词没有正确使用大写字母。
//
// 示例 1:
//
//
// 输入: "USA"
// 输出: True
//
//
// 示例 2:
//
//
// 输入: "FlaG"
// 输出: False
//
//
// 注意: 输入是由大写和小写拉丁字母组成的非空单词。
// Related Topics 字符串
// 520. 检测大写字母

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class DetectCapital {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().detectCapitalUse("USA"));
    Printer.printCorrectAnswer(false, new Solution().detectCapitalUse("FlaG"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37 MB , 在所有 Java 提交中击败了 81.92% 的用户
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
      if (word.length() == 1) return true;
      int l = 0;
      int r = word.length() - 1;
      boolean isUpperCase = word.charAt(r) >= 65 & word.charAt(r) <= 90;
      if (isUpperCase) {
        while (l <= r) {
          if (word.charAt(l) < 65 || word.charAt(l) > 90) return false;
          if (word.charAt(r) < 65 || word.charAt(r) > 90) return false;
          l++;
          r--;
        }
      } else {
        l++;
        while (l <= r) {
          if (word.charAt(l) < 97 || word.charAt(l) > 122) return false;
          if (word.charAt(r) < 97 || word.charAt(r) > 122) return false;
          l++;
          r--;
        }
      }
      return true;
    }
  }
}
