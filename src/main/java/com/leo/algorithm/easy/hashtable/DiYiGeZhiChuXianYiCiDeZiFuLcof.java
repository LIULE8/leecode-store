// 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例:
//
// s = "abaccdeff"
// 返回 "b"
//
// s = ""
// 返回 " "
//
//
//
// 剑指 Offer 50. 第一个只出现一次的字符
// 限制：
//
// 0 <= s 的长度 <= 50000
// Related Topics 哈希表
// 👍 73 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.Printer;

import java.util.LinkedHashMap;
import java.util.Map;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("b", new Solution().firstUniqChar("abaccdeff"));
    Printer.printCorrectAnswer(" ", new Solution().firstUniqChar(""));
  }

  static class Solution {
    public char firstUniqChar(String s) {
      //      return method1(s);
      return method2(s);
    }

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 99.23% 的用户
     *
     * <p>内存消耗： 38.8 MB , 在所有 Java 提交中击败了 41.19% 的用户
     *
     * @param s
     * @return
     */
    private char method2(String s) {
      if (s.equals("")) return ' ';
      int[] result = new int[26];
      char[] chars = s.toCharArray();
      for (char ch : chars) {
        result[ch - 'a']++;
      }
      for (char ch : chars) {
        if (result[ch - 'a'] == 1) return ch;
      }
      return ' ';
    }

    /**
     * 执行用时： 34 ms , 在所有 Java 提交中击败了 22.68% 的用户
     *
     * <p>内存消耗： 39.2 MB , 在所有 Java 提交中击败了 5.09% 的用户
     *
     * @param s
     * @return
     */
    private char method1(String s) {
      if (s.equals("")) return ' ';
      Map<Character, Integer> map = new LinkedHashMap<>();
      for (char ch : s.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      }
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1) return entry.getKey();
      }
      return ' ';
    }
  }
}
