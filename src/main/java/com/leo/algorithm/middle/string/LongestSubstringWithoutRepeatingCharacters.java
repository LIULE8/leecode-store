// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
// 输入: s = "abcabcbb"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
// 输入: s = "bbbbb"
// 输出: 1
// 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
// 输入: s = "pwwkew"
// 输出: 3
// 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
// 输入: s = ""
// 输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口
// 3. 无重复字符的最长子串

package com.leo.algorithm.middle.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public int lengthOfLongestSubstring(String s) {
      return method1(s);
    }

    /**
     * 暴力破解
     *
     * <p>执行用时： 71 ms , 在所有 Java 提交中击败了 14.95% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 14.09% 的用户
     *
     * @param s
     * @return
     */
    private int method1(String s) {
      if (s == null || s.equals("")) return 0;
      Map<Character, Integer> map = new HashMap<>();
      int max = 1;
      for (int i = 0; i < s.length(); i++) {
        if (map.containsKey(s.charAt(i))) {
          max = Math.max(max, map.size());
          i = map.get(s.charAt(i)) + 1;
          map.clear();
        }
        map.put(s.charAt(i), i);
      }
      return Math.max(max, map.size());
    }
  }
}
