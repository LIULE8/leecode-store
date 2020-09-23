// 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
//
// 注意：你 不能 修改非 '?' 字符。
//
// 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
//
// 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
//
//
//
// 示例 1：
//
// 输入：s = "?zs"
// 输出："azs"
// 解释：该示例共有 25 种解决方案，从 "azs" 到 "yzs" 都是符合题目要求的。只有 "z" 是无效的修改，因为字符串 "zzs" 中有连续重复的两
// 个 'z' 。
//
// 示例 2：
//
// 输入：s = "ubv?w"
// 输出："ubvaw"
// 解释：该示例共有 24 种解决方案，只有替换成 "v" 和 "w" 不符合题目要求。因为 "ubvvw" 和 "ubvww" 都包含连续重复的字符。
//
//
// 示例 3：
//
// 输入：s = "j?qg??b"
// 输出："jaqgacb"
//
//
// 示例 4：
//
// 输入：s = "??yw?ipkj?"
// 输出："acywaipkja"
//
//
//
//
// 提示：
//
//
//
// 1 <= s.length <= 100
//
//
// s 仅包含小写英文字母和 '?' 字符
//
//
// Related Topics 字符串
// 1576. 替换所有的问号

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("azs", new Solution().modifyString("?zs"));
    Printer.printCorrectAnswer("ubvaw", new Solution().modifyString("ubv?w"));
    Printer.printCorrectAnswer("jaqgacb", new Solution().modifyString("j?qg??b"));
    Printer.printCorrectAnswer("acywaipkja", new Solution().modifyString("??yw?ipkj?"));
    Printer.printCorrectAnswer("acacaca", new Solution().modifyString("???????"));
    Printer.printCorrectAnswer("a", new Solution().modifyString("?"));
  }

  static class Solution {
    public String modifyString(String s) {
      return method1(s);
    }

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 13.10% 的用户
     *
     * <p>内存消耗： 38.8 MB , 在所有 Java 提交中击败了 15.87% 的用户
     *
     * @param s
     * @return
     */
    private String method1(String s) {
      if (s.length() == 1 && s.charAt(0) == '?') return "a";
      StringBuilder sb = new StringBuilder(s);
      for (int i = 0; i < s.length(); i++) {
        if (sb.charAt(i) == '?') {
          sb.setCharAt(i, getReplaceChar(sb, i));
        }
      }
      return sb.toString();
    }

    private char getReplaceChar(StringBuilder sb, int index) {
      if (index == 0) {
        char c = sb.charAt(index + 1);
        if (c == '?') return 'a';
        else if (c == 'z') return (char) (c - 1);
        else return (char) (c + 1);
      }
      if (index == sb.length() - 1) {
        char c = sb.charAt(index - 1);
        if (c == '?') return 'a';
        if (c == 'z') return (char) (c - 1);
        else return (char) (c + 1);
      }
      char lc = sb.charAt(index - 1);
      char rc = sb.charAt(index + 1);
      if (lc == '?' && rc == '?') return 'a';
      else if (lc == '?') {
        int[] count = new int[26];
        count[rc - 'a']++;
        for (int i = 0; i < count.length; i++) {
          if (count[i] == 0) return (char) (i + 'a');
        }
      } else if (rc == '?') {
        int[] count = new int[26];
        count[lc - 'a']++;
        for (int i = 0; i < count.length; i++) {
          if (count[i] == 0) return (char) (i + 'a');
        }
      } else {
        int[] count = new int[26];
        count[rc - 'a']++;
        count[lc - 'a']++;
        for (int i = 0; i < count.length; i++) {
          if (count[i] == 0) return (char) (i + 'a');
        }
      }
      return 'a';
    }
  }
}
