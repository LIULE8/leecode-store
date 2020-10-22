// 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
//
//
// 字符（'a' - 'i'）分别用（'1' - '9'）表示。
// 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
//
//
// 返回映射之后形成的新字符串。
//
// 题目数据保证映射始终唯一。
//
//
//
// 示例 1：
//
// 输入：s = "10#11#12"
// 输出："jkab"
// 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//
//
// 示例 2：
//
// 输入：s = "1326#"
// 输出："acz"
//
//
// 示例 3：
//
// 输入：s = "25#"
// 输出："y"
//
//
// 示例 4：
//
// 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
// 输出："abcdefghijklmnopqrstuvwxyz"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s[i] 只包含数字（'0'-'9'）和 '#' 字符。
// s 是映射始终存在的有效字符串。
//
// Related Topics 字符串
// 1309. 解码字母到整数映射

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class DecryptStringFromAlphabetToIntegerMapping {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("jkab", new Solution().freqAlphabets("10#11#12"));
    Printer.printCorrectAnswer("acz", new Solution().freqAlphabets("1326#"));
    Printer.printCorrectAnswer("y", new Solution().freqAlphabets("25#"));
    Printer.printCorrectAnswer(
        "abcdefghijklmnopqrstuvwxyz",
        new Solution()
            .freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
  }

  static class Solution {
    /**
     * 执行用时： 21 ms , 在所有 Java 提交中击败了 5.12% 的用户
     *
     * <p>内存消耗： 39.5 MB , 在所有 Java 提交中击败了 5.12% 的用户
     *
     * @param s
     * @return
     */
    public String freqAlphabets(String s) {
      Map<String, Character> map = new HashMap<>();
      map.put("1", 'a');
      map.put("2", 'b');
      map.put("3", 'c');
      map.put("4", 'd');
      map.put("5", 'e');
      map.put("6", 'f');
      map.put("7", 'g');
      map.put("8", 'h');
      map.put("9", 'i');
      map.put("10#", 'j');
      map.put("11#", 'k');
      map.put("12#", 'l');
      map.put("13#", 'm');
      map.put("14#", 'n');
      map.put("15#", 'o');
      map.put("16#", 'p');
      map.put("17#", 'q');
      map.put("18#", 'r');
      map.put("19#", 's');
      map.put("20#", 't');
      map.put("21#", 'u');
      map.put("22#", 'v');
      map.put("23#", 'w');
      map.put("24#", 'x');
      map.put("25#", 'y');
      map.put("26#", 'z');
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < s.length(); i++) {
        if (i + 2 < s.length() && s.charAt(i + 2) == '#')
          sb.append(map.get(String.format("%c%c%c", s.charAt(i++), s.charAt(i++), s.charAt(i))));
        else sb.append(map.get(String.format("%c", s.charAt(i))));
      }
      return sb.toString();
    }
  }
}
