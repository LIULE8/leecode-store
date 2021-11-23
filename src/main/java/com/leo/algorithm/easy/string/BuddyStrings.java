// 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
//
//
//
// 示例 1：
//
// 输入： A = "ab", B = "ba"
// 输出： true
//
//
// 示例 2：
//
// 输入： A = "ab", B = "ab"
// 输出： false
//
//
// 示例 3:
//
// 输入： A = "aa", B = "aa"
// 输出： true
//
//
// 示例 4：
//
// 输入： A = "aaaaaaabc", B = "aaaaaaacb"
// 输出： true
//
//
// 示例 5：
//
// 输入： A = "", B = "aa"
// 输出： false
//
//
//
//
// 提示：
//
//
// 0 <= A.length <= 20000
// 0 <= B.length <= 20000
// A 和 B 仅由小写字母构成。
//
// Related Topics 字符串
// 859. 亲密字符串

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.Set;

public class BuddyStrings {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().buddyStrings("ab", "ba"));
    Printer.printCorrectAnswer(false, new Solution().buddyStrings("ab", "ab"));
    Printer.printCorrectAnswer(true, new Solution().buddyStrings("aa", "aa"));
    Printer.printCorrectAnswer(true, new Solution().buddyStrings("aaaaaaabc", "aaaaaaacb"));
    Printer.printCorrectAnswer(false, new Solution().buddyStrings("", "aa"));
    Printer.printCorrectAnswer(false, new Solution().buddyStrings("abcd", "badc"));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 53.27% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 71.93% 的用户
     *
     * @param s
     * @param goal
     * @return
     */
    public boolean buddyStrings(String s, String goal) {
      return method1(s, goal);
    }

    private boolean method1(String A, String B) {
      if ("".equals(A) || "".equals(B) || A.length() != B.length()) return false;
      if (A.equals(B)) {
        Set<Character> set = new HashSet<>();
        for (char c : A.toCharArray()) {
          set.add(c);
        }
        return set.size() < A.length();
      }
      int count = 0, index = -1;
      boolean flag = false;
      for (int i = 0; i < A.length(); i++) {
        if (A.charAt(i) != B.charAt(i)) {
          count++;
          if (count > 2) return false;
          if (index == -1) {
            index = i;
          } else if (A.charAt(index) == B.charAt(i) && B.charAt(index) == A.charAt(i)) {
            flag = true;
          }
        }
      }
      return flag;
    }
  }
}
