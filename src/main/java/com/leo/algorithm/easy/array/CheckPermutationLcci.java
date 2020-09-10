// 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
//
// 示例 1：
//
// 输入: s1 = "abc", s2 = "bca"
// 输出: true
//
//
// 示例 2：
//
// 输入: s1 = "abc", s2 = "bad"
// 输出: false
//
//
// 说明：
//
//
// 0 <= len(s1) <= 100
// 0 <= len(s2) <= 100
//
// Related Topics 数组 字符串
// 面试题 01.02. 判定是否互为字符重排

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.Set;

public class CheckPermutationLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().CheckPermutation("abc", "bca"));
    Printer.printCorrectAnswer(false, new Solution().CheckPermutation("abc", "bad"));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.3 MB , 在所有 Java 提交中击败了 64.11% 的用户
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
      Set<Character> se1 = new HashSet<>();
      Set<Character> se2 = new HashSet<>();
      for (char c : s1.toCharArray()) {
        se1.add(c);
      }
      for (char c : s2.toCharArray()) {
        se2.add(c);
      }
      return se1.containsAll(se2) && se2.containsAll(se1);
    }
  }
}
