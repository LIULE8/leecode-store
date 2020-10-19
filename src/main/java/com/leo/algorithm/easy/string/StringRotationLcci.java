// 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
//
// 示例1:
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
//
//
// 示例2:
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
//
//
//
//
//
// 提示：
//
//
// 字符串长度在[0, 100000]范围内。
//
//
// 说明:
//
//
// 你能只调用一次检查子串的方法吗？
//
// Related Topics 字符串
// 面试题 01.09. 字符串轮转

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class StringRotationLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isFlipedString("waterbottle", "erbottlewat"));
    Printer.printCorrectAnswer(false, new Solution().isFlipedString("aa", "aba"));
    Printer.printCorrectAnswer(true, new Solution().isFlipedString("", ""));
  }

  static class Solution {
    /**
     * 执行用时： 40 ms , 在所有 Java 提交中击败了 5.34% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 25.14% 的用户
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {
      if (s1.length() != s2.length()) return false;
      if (s1.equals(s2)) return true;
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < s1.length(); i++) {
        sb.setLength(0);
        String prefix = s1.substring(0, i);
        String subfix = s1.substring(i);
        sb.append(subfix).append(prefix);
        if (sb.toString().equals(s2)) return true;
      }
      return false;
    }
  }
}
