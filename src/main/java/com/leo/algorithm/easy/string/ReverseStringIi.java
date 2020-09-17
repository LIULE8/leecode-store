// 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
//
//
// 如果剩余字符少于 k 个，则将剩余字符全部反转。
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//
//
// 示例:
//
// 输入: s = "abcdefg", k = 2
// 输出: "bacdfeg"
//
//
//
//
// 提示：
//
//
// 该字符串只包含小写英文字母。
// 给定字符串的长度和 k 在 [1, 10000] 范围内。
//
// Related Topics 字符串
// 541. 反转字符串 II

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ReverseStringIi {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("bacdfeg", new Solution().reverseStr("abcdefg", 2));
    Printer.printCorrectAnswer("a", new Solution().reverseStr("a", 2));
    Printer.printCorrectAnswer("bac", new Solution().reverseStr("abc", 2));
    Printer.printCorrectAnswer("cba", new Solution().reverseStr("abc", 3));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.1 MB , 在所有 Java 提交中击败了 26.55% 的用户
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
      StringBuilder sb = new StringBuilder();
      StringBuilder temp = new StringBuilder();
      int len = k << 1, index = 0;
      for (; index + len < s.length(); index += len) {
        sb.append(temp.append(s, index, index + k).reverse());
        sb.append(s, index + k, index + len);
        temp.setLength(0);
      }
      // 处理末尾剩余的情况
      if (s.length() - index > k) {
        sb.append(temp.append(s, index, index + k).reverse()).append(s, k + index, s.length());
      } else {
        sb.append(temp.append(s.substring(index)).reverse());
      }
      return sb.toString();
    }
  }
}
