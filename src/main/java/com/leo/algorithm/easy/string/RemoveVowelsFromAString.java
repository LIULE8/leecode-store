// 给你一个字符串 S，请你删去其中的所有元音字母（ 'a'，'e'，'i'，'o'，'u'），并返回这个新字符串。
//
//
//
// 示例 1：
//
// 输入："leetcodeisacommunityforcoders"
// 输出："ltcdscmmntyfrcdrs"
//
//
// 示例 2：
//
// 输入："aeiou"
// 输出：""
//
//
//
//
// 提示：
//
//
// S 仅由小写英文字母组成。
// 1 <= S.length <= 1000
//
// Related Topics 字符串
// 1119. 删去字符串中的元音

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class RemoveVowelsFromAString {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "ltcdscmmntyfrcdrs", new Solution().removeVowels("leetcodeisacommunityforcoders"));
    Printer.printCorrectAnswer("", new Solution().removeVowels("aeiou"));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.6 MB , 在所有 Java 提交中击败了 75.63% 的用户
     *
     * @param S
     * @return
     */
    public String removeVowels(String S) {
      StringBuilder sb = new StringBuilder();
      for (char c : S.toCharArray()) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') continue;
        sb.append(c);
      }
      return sb.toString();
    }
  }
}
