// 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
//
// 注意:
// 假设字符串的长度不会超过 1010。
//
// 示例 1:
//
//
// 输入:
// "abccccdd"
//
// 输出:
// 7
//
// 解释:
// 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 409. 最长回文串
// Related Topics 哈希表
// 👍 275 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(7, new Solution().longestPalindrome("abccccdd"));
  }

  static class Solution {
    /**
     * 执行用时： 11 ms , 在所有 Java 提交中击败了 8.76% 的用户
     *
     * <p>内存消耗： 37 MB , 在所有 Java 提交中击败了 18.68% 的用户
     *
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
      Map<Character, Integer> map = new HashMap<>();
      for (char ch : s.toCharArray()) {
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      }
      int result = 0;
      boolean flag = false;
      for (Character key : map.keySet()) {
        if (map.get(key) % 2 == 0) {
          result += map.get(key);
          continue;
        }
        if (map.get(key) > 1) result += (map.get(key) - 1);
        flag = true;
      }
      return flag ? result + 1 : result;
    }
  }
}
