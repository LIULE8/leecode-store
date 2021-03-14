// 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
//
// 示例1:
//
// 输入: pattern = "abba", str = "dog cat cat dog"
// 输出: true
//
// 示例 2:
//
// 输入:pattern = "abba", str = "dog cat cat fish"
// 输出: false
//
// 示例 3:
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
// 输出: false
//
// 示例 4:
//
// 输入: pattern = "abba", str = "dog dog dog dog"
// 输出: false
//
// 说明:
// 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
// Related Topics 哈希表
// 290. 单词规律

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().wordPattern("abba", "dog cat cat dog"));
    Printer.printCorrectAnswer(false, new Solution().wordPattern("abba", "dog cat cat fish"));
    Printer.printCorrectAnswer(false, new Solution().wordPattern("aaaa", "dog cat cat dog"));
    Printer.printCorrectAnswer(false, new Solution().wordPattern("abba", "dog dog dog dog"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.77% 的用户
     *
     * <p>内存消耗： 36.8 MB , 在所有 Java 提交中击败了 5.03% 的用户
     *
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
      Map<Character, String> map = new HashMap<>();
      Map<String, Character> map1 = new HashMap<>();
      String[] s1 = s.split(" ");
      if (s1.length != pattern.length()) return false;
      for (int i = 0; i < pattern.length(); i++) {
        if (map.containsKey(pattern.charAt(i))) {
          String s2 = map.get(pattern.charAt(i));
          if (!s2.equals(s1[i])) return false;
        } else {
          if (map1.containsKey(s1[i])) {
            Character ch = map1.get(s1[i]);
            if (ch != pattern.charAt(i)) return false;
          } else {
            map1.put(s1[i], pattern.charAt(i));
          }
          map.put(pattern.charAt(i), s1[i]);
        }
      }
      return true;
    }
  }
}
