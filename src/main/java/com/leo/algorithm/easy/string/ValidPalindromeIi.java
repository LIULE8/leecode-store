// 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
//
// 示例 1:
//
//
// 输入: "aba"
// 输出: True
//
//
// 示例 2:
//
//
// 输入: "abca"
// 输出: True
// 解释: 你可以删除c字符。
//
//
// 注意:
//
//
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
//
// Related Topics 字符串
// 680. 验证回文字符串 Ⅱ

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ValidPalindromeIi {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().validPalindrome("aba"));
    Printer.printCorrectAnswer(true, new Solution().validPalindrome("abca"));
    Printer.printCorrectAnswer(true, new Solution().validPalindrome("deeee"));
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .validPalindrome(
                "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
  }

  static class Solution {
    /**
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 80.33% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 96.31% 的用户
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
      boolean validate = validate(s, true);
      return validate ? validate : validate(s, false);
    }

    private boolean validate(String s, boolean left) {
      int l = 0;
      int r = s.length() - 1;
      boolean flag = true;
      while (l < r) {
        if (s.charAt(l) != s.charAt(r)) {
          if (flag) {
            flag = false;
            if (left) l++;
            else r--;
            continue;
          }
          return false;
        }
        l++;
        r--;
      }
      return true;
    }
  }
}
