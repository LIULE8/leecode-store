package com.leo.algorithm.easy.dp;

import com.leo.algorithm.utils.Printer;

/**
 * 392. 判断子序列
 *
 * <p>给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * <p>你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * <p>字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * <p>示例 1: s = "abc", t = "ahbgdc"
 *
 * <p>返回 true.
 *
 * <p>示例 2: s = "axc", t = "ahbgdc"
 *
 * <p>返回 false.
 *
 * <p>后续挑战 :
 *
 * <p>如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
public class IsSubsequence {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isSubsequence("abc", "ahbgdc"));
    Printer.printCorrectAnswer(false, new Solution().isSubsequence("axc", "ahbgdc"));
    Printer.printCorrectAnswer(false, new Solution().isSubsequence("acb", "ahbgdc"));
    Printer.printCorrectAnswer(false, new Solution().isSubsequence("acb", ""));
  }

  static class Solution {
    public boolean isSubsequence(String s, String t) {
      //      return method1(s, t);
      //      return method2(s, t);
      return method3(s, t);
    }

    /**
     * 贪心？
     *
     * <p>执行用时： 2 ms , 在所有 Java 提交中击败了 44.11% 的用户
     *
     * <p>内存消耗： 35.9 MB , 在所有 Java 提交中击败了 99.74% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    private boolean method3(String s, String t) {
      int i = 0, j = 0;
      while (i < s.length() && j < t.length()) {
        if (s.charAt(i) == t.charAt(j)) {
          i++;
          j++;
        } else {
          j++;
        }
      }
      return i == s.length();
    }

    /**
     * for循环
     *
     * <p>执行用时 : 4 ms , 在所有 Java 提交中击败了 74.40% 的用户
     *
     * <p>内存消耗 : 49.6 MB , 在所有 Java 提交中击败了 95.23% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    private boolean method2(String s, String t) {
      for (int i = 0; i < s.length(); i++) {
        int a = t.indexOf(s.charAt(i));
        if (a < 0) return false;
        t = t.substring(a + 1);
      }
      return true;
    }

    /**
     * 递归
     *
     * <p>执行用时 : 9 ms , 在所有 java 提交中击败了 64.25% 的用户
     *
     * <p>内存消耗 : 96.1 MB , 在所有 java 提交中击败了 5.00% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    private boolean method1(String s, String t) {
      return dp(s.toCharArray(), 0, t);
    }

    private boolean dp(char[] chars, int index, String t) {
      if (index == chars.length) return true;
      int s = t.indexOf(chars[index]);
      if (s < 0) return false;
      return dp(chars, index + 1, t.substring(s + 1));
    }
  }
}
