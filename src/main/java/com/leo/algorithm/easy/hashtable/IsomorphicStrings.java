// 给定两个字符串 s 和 t，判断它们是否是同构的。
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
//
//
//
// 示例 1:
//
//
// 输入：s = "egg", t = "add"
// 输出：true
//
//
// 示例 2：
//
//
// 输入：s = "foo", t = "bar"
// 输出：false
//
// 示例 3：
//
//
// 输入：s = "paper", t = "title"
// 输出：true
//
//
// 205. 同构字符串
// 提示：
//
//
// 可以假设 s 和 t 长度相同。
//
// Related Topics 哈希表
// 👍 333 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isIsomorphic("egg", "add"));
    Printer.printCorrectAnswer(false, new Solution().isIsomorphic("foo", "bar"));
    Printer.printCorrectAnswer(true, new Solution().isIsomorphic("paper", "title"));
    Printer.printCorrectAnswer(false, new Solution().isIsomorphic("aaabbbba", "bbbaaaba"));
    Printer.printCorrectAnswer(false, new Solution().isIsomorphic("badc", "baba"));
  }

  static class Solution {
    /**
     * 执行用时： 30 ms , 在所有 Java 提交中击败了 20.88% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 19.89% 的用户
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
      Map<Character, Integer> sMap = new HashMap<>();
      Map<Character, Integer> tMap = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
        if (!sMap.containsKey(s.charAt(i))) {
          sMap.put(s.charAt(i), i);
        }
        if (!tMap.containsKey(t.charAt(i))) {
          tMap.put(t.charAt(i), i);
        }
        if (!sMap.get(s.charAt(i)).equals(tMap.get(t.charAt(i)))) {
          return false;
        }
      }
      return true;
    }
  }
}
