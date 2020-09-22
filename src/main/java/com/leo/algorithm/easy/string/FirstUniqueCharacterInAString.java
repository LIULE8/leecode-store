// 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
// 返回 0
//
// s = "loveleetcode"
// 返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 387. 字符串中的第一个唯一字符

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class FirstUniqueCharacterInAString {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(0, new Solution().firstUniqChar("leetcode"));
    Printer.printCorrectAnswer(2, new Solution().firstUniqChar("loveleetcode"));
  }

  static class Solution {
    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 82.20% 的用户
     *
     * <p>内存消耗： 39.5 MB , 在所有 Java 提交中击败了 33.75% 的用户
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
      if (s.length() == 1) return 0;
      int[] chars = new int[26];
      for (int i = 0; i < s.length(); i++) {
        chars[s.charAt(i) - 'a']++;
      }
      for (int i = 0; i < s.length(); i++) {
        if (chars[s.charAt(i) - 'a'] == 1) return i;
      }
      return -1;
    }
  }
}
