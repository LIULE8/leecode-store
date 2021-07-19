// 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
//
//
//
// 示例 1：
//
//
// 输入: s1 = "ab" s2 = "eidbaooo"
// 输出: True
// 解释: s2 包含 s1 的排列之一 ("ba").
//
//
// 示例 2：
//
//
// 输入: s1= "ab" s2 = "eidboaoo"
// 输出: False
//
//
//
//
// 提示：
//
//
// 1 <= s1.length, s2.length <= 104
// s1 和 s2 仅包含小写字母
//
// Related Topics 哈希表 双指针 字符串 滑动窗口
// 567. 字符串的排列

package com.leo.algorithm.plan.introduction.t06;

public class PermutationInString {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 99.33% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 33.06% 的用户
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
      char[] pattern = s1.toCharArray();
      char[] text = s2.toCharArray();

      int pLen = s1.length();
      int tLen = s2.length();

      int[] pFran = new int[26];
      int[] winFran = new int[26];

      int pCount = 0;
      for (char ch : pattern) {
        pFran[ch - 'a']++;
        if (pFran[ch - 'a'] == 1) pCount++;
      }
      // 当窗口的字符数量和种类，与模式串的一致，才加1
      int winCount = 0;

      // 滑动窗口左右边界
      int left = 0;
      int right = 0;
      while (right < tLen) {
        int rIndex = text[right] - 'a';
        if (pFran[rIndex] > 0) {
          winFran[rIndex]++;
          if (winFran[rIndex] == pFran[rIndex]) winCount++;
        }
        right++;
        while (winCount == pCount) {
          if (right - left == pLen) return true;
          int lIndex = text[left] - 'a';
          if (pFran[lIndex] > 0) {
            winFran[lIndex]--;
            if (winFran[lIndex] < pFran[lIndex]) winCount--;
          }
          left++;
        }
      }
      return false;
    }
  }
}
