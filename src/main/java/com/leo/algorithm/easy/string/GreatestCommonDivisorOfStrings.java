// 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
//
// 返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
//
//
//
// 示例 1：
//
// 输入：str1 = "ABCABC", str2 = "ABC"
// 输出："ABC"
//
//
// 示例 2：
//
// 输入：str1 = "ABABAB", str2 = "ABAB"
// 输出："AB"
//
//
// 示例 3：
//
// 输入：str1 = "LEET", str2 = "CODE"
// 输出：""
//
//
//
//
// 提示：
//
//
// 1 <= str1.length <= 1000
// 1 <= str2.length <= 1000
// str1[i] 和 str2[i] 为大写英文字母
//
// Related Topics 字符串
// 1071. 字符串的最大公因子

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class GreatestCommonDivisorOfStrings {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("ABC", new Solution().gcdOfStrings("ABCABC", "ABC"));
    Printer.printCorrectAnswer("AB", new Solution().gcdOfStrings("ABABAB", "ABAB"));
    Printer.printCorrectAnswer("", new Solution().gcdOfStrings("LEET", "CODE"));
  }

  static class Solution {
    /**
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 9.31% 的用户
     *
     * <p>内存消耗： 38.9 MB , 在所有 Java 提交中击败了 36.89% 的用户
     *
     * @param str1
     * @param str2
     * @return
     */
    public String gcdOfStrings(String str1, String str2) {
      if (str1.equals(str2)) return str1;
      int length = Math.min(str1.length(), str2.length());
      String result = "";
      for (int i = 1; i <= length; i++) {
        String target = getTarget(i, str1, str2);
        if (target.length() > result.length()) result = target;
      }
      return result;
    }

    private String getTarget(int end, String str1, String str2) {
      String substring = str1.substring(0, end);
      String sub1 = getTargetString(substring, str1, end);
      if (sub1.equals("")) return sub1;
      String sub2 = getTargetString(substring, str2, end);
      return sub2.equals(sub1) ? sub2 : "";
    }

    private String getTargetString(String substring, String str, int end) {
      int j = 0;
      for (; j < str.length(); j += end) {
        if (end + j <= str.length() && !substring.equals(str.substring(j, end + j))) {
          return "";
        }
      }
      return j > str.length() ? "" : substring;
    }
  }
}
