// 给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
// 输入：s = "cbbd"
// 输出："bb"
//
//
// 示例 3：
//
//
// 输入：s = "a"
// 输出："a"
//
//
// 示例 4：
//
//
// 输入：s = "ac"
// 输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//

// 5. 最长回文子串
// Related Topics 字符串 动态规划

package com.leo.algorithm.middle.dp;

public class LongestPalindromicSubstring {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 261 ms , 在所有 Java 提交中击败了 16.13% 的用户
     *
     * <p>内存消耗： 42.4 MB , 在所有 Java 提交中击败了 31.76% 的用户
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
      if (s.length() < 2) return s;
      boolean[][] dp = new boolean[s.length()][s.length()];
      for (int i = 0; i < s.length(); i++) {
        dp[i][i] = true;
      }
      // 记录最长字串的左下标和右下标
      int leftIndex = 0;
      int rightIndex = 0;
      // 从后面往前面比较，时间复杂度时O(n^2)
      for (int i = s.length() - 1; i >= 0; i--) {
        for (int j = i + 1; j < s.length(); j++) {
          boolean b = s.charAt(i) == s.charAt(j);
          // 长度是2时 (j-i<3) 直接看字符是否相等
          dp[i][j] = j - i < 3 ? b : b && dp[i + 1][j - 1];
          if (dp[i][j] && rightIndex - leftIndex < j - i) {
            leftIndex = i;
            rightIndex = j;
          }
        }
      }
      return s.substring(leftIndex, rightIndex + 1);
    }
  }
}
