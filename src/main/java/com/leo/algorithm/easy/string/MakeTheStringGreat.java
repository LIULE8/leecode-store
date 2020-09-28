// 给你一个由大小写英文字母组成的字符串 s 。
//
// 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件：
//
//
// 0 <= i <= s.length - 2
// s[i] 是小写字符，但 s[i + 1] 是相同的大写字符；反之亦然 。
//
//
// 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
//
// 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
//
// 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
//
//
//
// 示例 1：
//
// 输入：s = "leEeetcode"
// 输出："leetcode"
// 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
//
//
// 示例 2：
//
// 输入：s = "abBAcC"
// 输出：""
// 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
// "abBAcC" --> "aAcC" --> "cC" --> ""
// "abBAcC" --> "abBA" --> "aA" --> ""
//
//
// 示例 3：
//
// 输入：s = "s"
// 输出："s"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 只包含小写和大写英文字母
//
// Related Topics 栈 字符串
// 1544. 整理字符串

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class MakeTheStringGreat {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("leetcode", new Solution().makeGood("leEeetcode"));
    Printer.printCorrectAnswer("", new Solution().makeGood("abBAcC"));
    Printer.printCorrectAnswer("s", new Solution().makeGood("s"));
    Printer.printCorrectAnswer("mC", new Solution().makeGood("mC"));
  }

  static class Solution {
    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 45.13% 的用户
     *
     * <p>内存消耗： 38.9 MB , 在所有 Java 提交中击败了 42.40% 的用户
     *
     * @param s
     * @return
     */
    public String makeGood(String s) {
      if (s.equals("")) return s;
      while (true) {
        int index = 1;
        while (index < s.length() && !validate(s, index)) {
          index++;
        }
        if (index >= s.length()) break;
        s = s.substring(0, index - 1) + s.substring(index + 1);
      }
      return s;
    }

    private boolean validate(String s, int index) {
      return Character.isLowerCase(s.charAt(index - 1))
              && Character.isUpperCase(s.charAt(index))
              && s.charAt(index - 1) - 'a' == s.charAt(index) - 'A'
          || Character.isUpperCase(s.charAt(index - 1))
              && Character.isLowerCase(s.charAt(index))
              && s.charAt(index - 1) - 'A' == s.charAt(index) - 'a';
    }
  }
}
