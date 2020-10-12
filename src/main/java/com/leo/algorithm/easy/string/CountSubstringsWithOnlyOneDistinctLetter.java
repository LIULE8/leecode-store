// 给你一个字符串 S，返回只含 单一字母 的子串个数。
//
// 示例 1：
//
// 输入： "aaaba"
// 输出： 8
// 解释：
// 只含单一字母的子串分别是 "aaa"， "aa"， "a"， "b"。
// "aaa" 出现 1 次。
// "aa" 出现 2 次。
// "a" 出现 4 次。
// "b" 出现 1 次。
// 所以答案是 1 + 2 + 4 + 1 = 8。
//
//
// 示例 2:
//
// 输入： "aaaaaaaaaa"
// 输出： 55
//
//
//
//
// 提示：
//
//
// 1 <= S.length <= 1000
// S[i] 仅由小写英文字母组成。
//
// Related Topics 数学 字符串
// 1180. 统计只含单一字母的子串

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class CountSubstringsWithOnlyOneDistinctLetter {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(8, new Solution().countLetters("aaaba"));
    Printer.printCorrectAnswer(55, new Solution().countLetters("aaaaaaaaaa"));
    Printer.printCorrectAnswer(22, new Solution().countLetters("jjjjxttttn"));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.8 MB , 在所有 Java 提交中击败了 21.21% 的用户
     *
     * @param S
     * @return
     */
    public int countLetters(String S) {
      char[] chars = S.toCharArray();
      int count = 0, index = 1;
      for (; index < chars.length; index++) {
        int k = index - 1;
        while (index < chars.length && chars[k] == chars[index]) {
          index++;
        }
        count += (index - k) * (1 + index - k) >> 1;
        if (index >= chars.length) return count;
      }
      return ++count;
    }
  }
}
