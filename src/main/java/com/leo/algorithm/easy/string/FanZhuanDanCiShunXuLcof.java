// 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
// 则输出"student. a am I"。
//
//
//
// 示例 1：
//
// 输入: "the sky is blue"
// 输出: "blue is sky the"
//
//
// 示例 2：
//
// 输入: "  hello world!  "
// 输出: "world! hello"
// 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
//
//
// 示例 3：
//
// 输入: "a good   example"
// 输出: "example good a"
// 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
//
//
// 说明：
//
//
// 无空格字符构成一个单词。
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
//
//
// 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
//
//
// 注意：此题对比原题有改动
// Related Topics 字符串
// 剑指 Offer 58 - I. 翻转单词顺序

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class FanZhuanDanCiShunXuLcof {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("blue is sky the", new Solution().reverseWords("the sky is blue"));
    Printer.printCorrectAnswer("world! hello", new Solution().reverseWords("  hello world!  "));
    Printer.printCorrectAnswer("example good a", new Solution().reverseWords("a good   example"));
  }

  static class Solution {
    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 14.73% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 88.71% 的用户
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
      StringBuilder sb = new StringBuilder();
      StringBuilder word = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if (!Character.isSpaceChar(ch)) {
          word.append(ch);
          continue;
        }
        if (word.length() == 0) continue;
        sb.append(word.reverse()).append(" ");
        word.setLength(0);
      }
      if (word.length() > 0) {
        sb.append(word.reverse());
      }
      return sb.reverse().toString().trim();
    }
  }
}
