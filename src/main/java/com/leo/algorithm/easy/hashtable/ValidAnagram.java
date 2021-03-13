// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
// 示例 1:
//
// 输入: s = "anagram", t = "nagaram"
// 输出: true
//
//
// 示例 2:
//
// 输入: s = "rat", t = "car"
// 输出: false
//
// 说明:
// 你可以假设字符串只包含小写字母。
//
// 进阶:
// 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
// Related Topics 排序 哈希表
// 242. 有效的字母异位词

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.Printer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isAnagram("anagram", "nagaram"));
    Printer.printCorrectAnswer(false, new Solution().isAnagram("rat", "car"));
    Printer.printCorrectAnswer(false, new Solution().isAnagram("a", "ab"));
  }

  static class Solution {

    public boolean isAnagram(String s, String t) {
      //      return method1(s, t);
      return method2(s, t);
    }

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 86.53% 的用户
     *
     * <p>内存消耗： 38.5 MB , 在所有 Java 提交中击败了 89.62% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    private boolean method2(String s, String t) {
      if (s.length() != t.length()) return false;
      char[] sch = s.toCharArray();
      char[] tch = t.toCharArray();
      Arrays.sort(sch);
      Arrays.sort(tch);
      int k = 0;
      while (k < sch.length && sch[k] == tch[k]) k++;
      return k >= sch.length;
    }

    /**
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 24.62% 的用户
     *
     * <p>内存消耗： 39.4 MB , 在所有 Java 提交中击败了 7.78% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    private boolean method1(String s, String t) {
      if (s.length() != t.length()) return false;
      Map<Character, Integer> sMap = buildMap(s);
      Map<Character, Integer> tMap = buildMap(t);
      for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
        if (!tMap.containsKey(entry.getKey())
            || !tMap.get(entry.getKey()).equals(entry.getValue())) {
          return false;
        }
      }
      return true;
    }

    private Map<Character, Integer> buildMap(String s) {
      Map<Character, Integer> map = new HashMap<>();
      for (char ch : s.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      }
      return map;
    }
  }
}
