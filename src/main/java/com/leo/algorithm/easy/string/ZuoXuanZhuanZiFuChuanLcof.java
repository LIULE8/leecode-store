// 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数
// 将返回左旋转两位得到的结果"cdefgab"。
//
//
//
// 示例 1：
//
// 输入: s = "abcdefg", k = 2
// 输出: "cdefgab"
//
//
// 示例 2：
//
// 输入: s = "lrloseumgh", k = 6
// 输出: "umghlrlose"
//
//
//
//
// 限制：
//
//
// 1 <= k < s.length <= 10000
//
// Related Topics 字符串
// 剑指 Offer 58 - II. 左旋转字符串

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ZuoXuanZhuanZiFuChuanLcof {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("cdefgab", new Solution().reverseLeftWords("abcdefg", 2));
    Printer.printCorrectAnswer("umghlrlose", new Solution().reverseLeftWords("lrloseumgh", 6));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.2 MB , 在所有 Java 提交中击败了 94.62% 的用户
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
      return s.substring(n) + s.substring(0, n);
    }
  }
}
