// 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//
//
//
// 示例 1：
//
// 输入："hello"
// 输出："holle"
//
//
// 示例 2：
//
// 输入："leetcode"
// 输出："leotcede"
//
//
//
// 提示：
//
//
// 元音字母不包含字母 "y" 。
//
// Related Topics 双指针 字符串
// 345. 反转字符串中的元音字母

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ReverseVowelsOfAString {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("holle", new Solution().reverseVowels("hello"));
    Printer.printCorrectAnswer("leotcede", new Solution().reverseVowels("leetcode"));
    Printer.printCorrectAnswer("a.", new Solution().reverseVowels("a."));
    Printer.printCorrectAnswer(".a", new Solution().reverseVowels(".a"));
    Printer.printCorrectAnswer("ea", new Solution().reverseVowels("ae"));
    Printer.printCorrectAnswer("Aa", new Solution().reverseVowels("aA"));
  }

  static class Solution {
    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 49.66% 的用户
     *
     * <p>内存消耗： 38.9 MB , 在所有 Java 提交中击败了 63.73% 的用户
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
      int l = 0;
      int r = s.length() - 1;
      StringBuilder lsb = new StringBuilder();
      StringBuilder rsb = new StringBuilder();
      while (l <= r) {
        while (validate(l, r, s.charAt(l))) {
          lsb.append(s.charAt(l));
          l++;
        }
        while (validate(l, r, s.charAt(r))) {
          rsb.append(s.charAt(r));
          r--;
        }
        if (l > r) break;
        else if (l == r) {
          lsb.append(s.charAt(r));
        } else {
          lsb.append(s.charAt(r));
          rsb.append(s.charAt(l));
        }
        l++;
        r--;
      }
      return lsb.toString() + rsb.reverse().toString();
    }

    private boolean validate(int l, int r, char c) {
      return l < r && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u' && c != 'A'
          && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }
  }
}
