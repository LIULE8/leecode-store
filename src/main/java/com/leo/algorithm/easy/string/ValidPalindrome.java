// 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
// 输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
// 输出: false
//
// Related Topics 双指针 字符串
// 125. 验证回文串

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ValidPalindrome {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    Printer.printCorrectAnswer(false, new Solution().isPalindrome("race a car"));
    Printer.printCorrectAnswer(true, new Solution().isPalindrome("a."));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 93.14% 的用户
     *
     * <p>内存消耗： 39.1 MB , 在所有 Java 提交中击败了 29.33% 的用户
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
      int l = 0;
      int r = s.length() - 1;
      s = s.toLowerCase();
      while (l <= r) {
        char lch = s.charAt(l);
        char rch = s.charAt(r);
        if (lch < '0' || lch > '9' && lch < 'a' || lch > 'z') l++;
        else if (rch < '0' || rch > '9' && rch < 'a' || rch > 'z') r--;
        else {
          if (lch != rch) return false;
          l++;
          r--;
        }
      }
      return true;
    }
  }
}
