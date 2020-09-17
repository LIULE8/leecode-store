// 给你两个字符串，请你从这两个字符串中找出最长的特殊序列。
//
// 「最长特殊序列」定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
//
// 子序列 可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
//
// 输入为两个字符串，输出最长特殊序列的长度。如果不存在，则返回 -1。
//
//
//
// 示例 1：
//
// 输入: "aba", "cdc"
// 输出: 3
// 解释: 最长特殊序列可为 "aba" (或 "cdc")，两者均为自身的子序列且不是对方的子序列。
//
// 示例 2：
//
// 输入：a = "aaa", b = "bbb"
// 输出：3
//
//
// 示例 3：
//
// 输入：a = "aaa", b = "aaa"
// 输出：-1
//
//
//
//
// 提示：
//
//
// 两个字符串长度均处于区间 [1 - 100] 。
// 字符串中的字符仅含有 'a'~'z' 。
//
// Related Topics 脑筋急转弯 字符串
// 521. 最长特殊序列 Ⅰ

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class LongestUncommonSubsequenceI {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(3, new Solution().findLUSlength("aba", "cdc"));
    Printer.printCorrectAnswer(3, new Solution().findLUSlength("aaa", "bbb"));
    Printer.printCorrectAnswer(-1, new Solution().findLUSlength("aaa", "aaa"));
    Printer.printCorrectAnswer(
        17, new Solution().findLUSlength("aefawfawfawfaw", "aefawfeawfwafwaef"));
  }

  static class Solution {
    /**
     * 字符串 aa 和 bb 共有 3 种情况：
     *
     * <p>a=b。如果两个字符串相同，则没有特殊子序列，返回 -1。
     *
     * <p>length(a) = length(b) 且 a ≠ b。例如：abc 和 abd。
     *
     * <p>这种情况下，一个字符串一定不会是另外一个字符串的子序列，因此可以将任意一个字符串看作是特殊子序列，返回 length(a) 或 length(b)。
     *
     * <p>length(a) ≠ length(b)。例如：abcd 和 abc。
     *
     * <p>这种情况下，长的字符串一定不会是短字符串的子序列，因此可以将长字符串看作是特殊子序列，返回 max(length(a),length(b))。
     *
     * <p>执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.4 MB , 在所有 Java 提交中击败了 84.38% 的用户
     *
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
      if (a.equals(b)) return -1;
      return Math.max(a.length(), b.length());
    }
  }
}
