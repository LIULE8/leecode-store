// 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
//
// 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
// 输入：s1 = "bank", s2 = "kanb"
// 输出：true
// 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
//
//
// 示例 2：
//
// 输入：s1 = "attack", s2 = "defend"
// 输出：false
// 解释：一次字符串交换无法使两个字符串相等
//
//
// 示例 3：
//
// 输入：s1 = "kelb", s2 = "kelb"
// 输出：true
// 解释：两个字符串已经相等，所以不需要进行字符串交换
//
//
// 示例 4：
//
// 输入：s1 = "abcd", s2 = "dcba"
// 输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s1.length, s2.length <= 100
// s1.length == s2.length
// s1 和 s2 仅由小写英文字母组成
//
// Related Topics 字符串
// 1790. 仅执行一次字符串交换能否使两个字符串相等

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class CheckIfOneStringSwapCanMakeStringsEqual {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().areAlmostEqual("xtttf", "ftttx"));
    Printer.printCorrectAnswer(true, new Solution().areAlmostEqual("bank", "kanb"));
    Printer.printCorrectAnswer(false, new Solution().areAlmostEqual("aa", "bb"));
    Printer.printCorrectAnswer(false, new Solution().areAlmostEqual("x", "z"));
    Printer.printCorrectAnswer(false, new Solution().areAlmostEqual("attack", "defend"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 51.22% 的用户
     *
     * <p>内存消耗： 36.7 MB , 在所有 Java 提交中击败了 44.91% 的用户
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean areAlmostEqual(String s1, String s2) {
      if (s1.length() == 1) return s1.equals(s2);
      int count = 0, k = 0;
      int[] res = new int[4];
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          count++;
          if (count > 2) return false;
          res[k++] = s1.charAt(i);
          res[k++] = s2.charAt(i);
        }
      }
      return res[0] == res[3] && res[1] == res[2];
    }
  }
}
