// 给定两个字符串 s 和 t，它们只包含小写字母。
//
// 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
//
// 请找出在 t 中被添加的字母。
//
//
//
// 示例 1：
//
// 输入：s = "abcd", t = "abcde"
// 输出："e"
// 解释：'e' 是那个被添加的字母。
//
//
// 示例 2：
//
// 输入：s = "", t = "y"
// 输出："y"
//
//
// 示例 3：
//
// 输入：s = "a", t = "aa"
// 输出："a"
//
//
// 示例 4：
//
// 输入：s = "ae", t = "aea"
// 输出："a"
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 1000
// t.length == s.length + 1
// s 和 t 只包含小写字母
// 389. 找不同
// Related Topics 位运算 哈希表
// 👍 235 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
  public static void main(String[] args) {
    Printer.printCorrectAnswer('e', new Solution().findTheDifference("abcd", "abcde"));
    Printer.printCorrectAnswer('y', new Solution().findTheDifference("", "y"));
    Printer.printCorrectAnswer('a', new Solution().findTheDifference("a", "aa"));
    Printer.printCorrectAnswer('a', new Solution().findTheDifference("ae", "aea"));
  }

  static class Solution {
    public char findTheDifference(String s, String t) {
      //      return method1(s, t);
      //      return method2(s, t);
      return method3(s, t);
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.2 MB , 在所有 Java 提交中击败了 5.26% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    private char method3(String s, String t) {
      char res = 0;
      for (char ch : (s + t).toCharArray()) {
        res ^= ch;
      }
      return res;
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.6 MB , 在所有 Java 提交中击败了 93.20% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    private char method2(String s, String t) {
      int[] re = new int[26];
      for (char ch : s.toCharArray()) {
        re[ch - 'a']++;
      }
      for (char ch : t.toCharArray()) {
        re[ch - 'a']--;
        if (re[ch - 'a'] < 0) return ch;
      }
      return ' ';
    }

    /**
     * 执行用时： 14 ms , 在所有 Java 提交中击败了 7.78% 的用户
     *
     * <p>内存消耗： 37.1 MB , 在所有 Java 提交中击败了 14.04% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    private char method1(String s, String t) {
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
        char key = s.charAt(i);
        map.put(key, map.getOrDefault(key, 0) + 1);
      }
      for (int i = 0; i < t.length(); i++) {
        char key = t.charAt(i);
        if (map.getOrDefault(key, 0) > 0) {
          map.put(key, map.get(key) - 1);
          continue;
        }
        return key;
      }
      return ' ';
    }
  }
}
