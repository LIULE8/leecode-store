// 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
// 示例 1：
//
// 输入: s = "leetcode"
// 输出: false
//
//
// 示例 2：
//
// 输入: s = "abc"
// 输出: true
//
//
// 限制：
//
// 0 <= len(s) <= 100
// 如果你不使用额外的数据结构，会很加分。
//
// Related Topics 数组
// 面试题 01.01. 判定字符是否唯一

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.Set;

public class IsUniqueLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(false, new Solution().isUnique("leetcode"));
    Printer.printCorrectAnswer(true, new Solution().isUnique("abc"));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.6 MB , 在所有 Java 提交中击败了 5.62% 的用户
     *
     * @param astr
     * @return
     */
    public boolean isUnique(String astr) {
      Set<Character> set = new HashSet<>();
      for (char c : astr.toCharArray()) {
        if (set.contains(c)) return false;
        set.add(c);
      }
      return true;
    }
  }
}
