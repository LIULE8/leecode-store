// 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
//
// 子字符串 是字符串中的一个连续字符序列。
//
//
//
// 示例 1：
//
// 输入：s = "aa"
// 输出：0
// 解释：最优的子字符串是两个 'a' 之间的空子字符串。
//
// 示例 2：
//
// 输入：s = "abca"
// 输出：2
// 解释：最优的子字符串是 "bc" 。
//
//
// 示例 3：
//
// 输入：s = "cbzxy"
// 输出：-1
// 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
//
//
// 示例 4：
//
// 输入：s = "cabbac"
// 输出：4
// 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 300
// s 只含小写英文字母
//
// Related Topics 字符串
// 1624. 两个相同字符之间的最长子字符串

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class LargestSubstringBetweenTwoEqualCharacters {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(0, new Solution().maxLengthBetweenEqualCharacters("aa"));
    Printer.printCorrectAnswer(2, new Solution().maxLengthBetweenEqualCharacters("abca"));
    Printer.printCorrectAnswer(-1, new Solution().maxLengthBetweenEqualCharacters("cbzxy"));
    Printer.printCorrectAnswer(4, new Solution().maxLengthBetweenEqualCharacters("cabbac"));
    Printer.printCorrectAnswer(4, new Solution().maxLengthBetweenEqualCharacters("ojdncpvyneq"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 83.12% 的用户
     *
     * <p>内存消耗： 36.5 MB , 在所有 Java 提交中击败了 35.39% 的用户
     *
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters(String s) {
      int max = -1;
      for (int i = 0; i < s.length(); i++) {
        int length = s.lastIndexOf(s.charAt(i));
        if (length == -1) continue;
        max = Math.max(max, length - i - 1);
      }
      return max;
    }
  }
}
