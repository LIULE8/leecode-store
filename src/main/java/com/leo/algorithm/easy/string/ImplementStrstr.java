// 实现 strStr() 函数。
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
// 果不存在，则返回 -1。
//
// 示例 1:
//
// 输入: haystack = "hello", needle = "ll"
// 输出: 2
//
//
// 示例 2:
//
// 输入: haystack = "aaaaa", needle = "bba"
// 输出: -1
//
//
// 说明:
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
// Related Topics 双指针 字符串
// 28. 实现 strStr()

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ImplementStrstr {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(2, new Solution().strStr("hello", "ll"));
    Printer.printCorrectAnswer(-1, new Solution().strStr("aaaaa", "bba"));
    Printer.printCorrectAnswer(0, new Solution().strStr("", ""));
    Printer.printCorrectAnswer(0, new Solution().strStr("a", "a"));
  }

  static class Solution {

    public int strStr(String haystack, String needle) {
      //      return method1(haystack, needle);
      return method2(haystack, needle);
    }

    /**
     * KMP算法
     *
     * <p>执行用时： 6 ms , 在所有 Java 提交中击败了 18.13% 的用户
     *
     * <p>内存消耗： 39.1 MB , 在所有 Java 提交中击败了 11.52% 的用户
     *
     * @param haystack
     * @param needle
     * @return
     */
    private int method2(String haystack, String needle) {
      if (needle.length() == 0) return 0;
      int i = 0, j = 0;
      int[] next = getNext(needle);
      while (j < needle.length() && i < haystack.length()) {
        if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
          i++;
          j++;
        } else {
          j = next[j];
        }
      }
      if (j == needle.length()) {
        return i - j;
      }
      return -1;
    }

    private int[] getNext(String needle) {
      int[] next = new int[needle.length()];
      next[0] = -1;
      int i = 0, j = -1;
      while (i < needle.length() - 1) {
        if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
          i++;
          j++;
          next[i] = j;
        } else {
          j = next[j];
        }
      }
      return next;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.2 MB , 在所有 Java 提交中击败了 89.02% 的用户
     *
     * @param haystack
     * @param needle
     * @return
     */
    private int method1(String haystack, String needle) {
      return haystack.indexOf(needle);
    }
  }
}
