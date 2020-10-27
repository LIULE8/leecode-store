// 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
//
// 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
//
// 回文串不一定是字典当中的单词。
//
//
//
// 示例1：
//
// 输入："tactcoa"
// 输出：true（排列有"tacocat"、"atcocta"，等等）
//
//
//
// Related Topics 哈希表 字符串
// 面试题 01.04. 回文排列

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutationLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().canPermutePalindrome("tactcoa"));
    Printer.printCorrectAnswer(true, new Solution().canPermutePalindrome("tactca"));
    Printer.printCorrectAnswer(true, new Solution().canPermutePalindrome("tabbbctca"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 71.76% 的用户
     *
     * <p>内存消耗： 36.1 MB , 在所有 Java 提交中击败了 93.40% 的用户
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
      Map<Character, Integer> map = new HashMap<>();
      for (char c : s.toCharArray()) {
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      int odd = 0;
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        if (entry.getValue() % 2 == 0) continue;
        odd++;
        if (odd > 1) return false;
      }
      return true;
    }
  }
}
