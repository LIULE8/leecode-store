// 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
//
// 示例 1:
//
//
// 输入: "abab"
//
// 输出: True
//
// 解释: 可由子字符串 "ab" 重复两次构成。
//
//
// 示例 2:
//
//
// 输入: "aba"
//
// 输出: False
//
//
// 示例 3:
//
//
// 输入: "abcabcabcabc"
//
// 输出: True
//
// 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
//
// Related Topics 字符串
// 459. 重复的子字符串

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class RepeatedSubstringPattern {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().repeatedSubstringPattern("abab"));
  }

  static class Solution {
    public boolean repeatedSubstringPattern(String s) {
      return method1(s);
    }

    /**
     * 如果s有重复串， 那么 s + s 去掉首字符和尾字符，s是新字符串的子串，那么就是有重复串的
     *
     * <p>执行用时： 96 ms , 在所有 Java 提交中击败了 35.32% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 90.81% 的用户
     *
     * @param s
     * @return
     */
    private boolean method1(String s) {
      // 如果索引超过了一个s的长度，证明没有字串
      return (s + s).indexOf(s, 1) != s.length();
    }
  }
}
