// 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
//
// 请你返回字符串的能量。
//
//
//
// 示例 1：
//
// 输入：s = "leetcode"
// 输出：2
// 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
//
//
// 示例 2：
//
// 输入：s = "abbcccddddeeeeedcba"
// 输出：5
// 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
//
//
// 示例 3：
//
// 输入：s = "triplepillooooow"
// 输出：5
//
//
// 示例 4：
//
// 输入：s = "hooraaaaaaaaaaay"
// 输出：11
//
//
// 示例 5：
//
// 输入：s = "tourist"
// 输出：1
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 500
// s 只包含小写英文字母。
//
// Related Topics 字符串
// 1446. 连续字符

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ConsecutiveCharacters {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(2, new Solution().maxPower("leetcode"));
    Printer.printCorrectAnswer(5, new Solution().maxPower("abbcccddddeeeeedcba"));
    Printer.printCorrectAnswer(5, new Solution().maxPower("triplepillooooow"));
    Printer.printCorrectAnswer(11, new Solution().maxPower("hooraaaaaaaaaaay"));
    Printer.printCorrectAnswer(1, new Solution().maxPower("tourist"));
    Printer.printCorrectAnswer(1, new Solution().maxPower("j"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.4 MB , 在所有 Java 提交中击败了 44.89% 的用户
     *
     * @param s
     * @return
     */
    public int maxPower(String s) {
      int max = 0;
      char[] chars = s.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char ch = chars[i];
        int k = 1;
        while (i + 1 < chars.length && ch == chars[i + 1]) {
          k++;
          i++;
        }
        max = Math.max(k, max);
      }
      return max;
    }
  }
}
