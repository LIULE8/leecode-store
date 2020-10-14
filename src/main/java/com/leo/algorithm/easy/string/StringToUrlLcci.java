// URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，
// 请使用字符数组实现，以便直接在数组上操作。）
//
// 示例1:
//
//  输入："Mr John Smith    ", 13
// 输出："Mr%20John%20Smith"
//
//
// 示例2:
//
//  输入："               ", 5
// 输出："%20%20%20%20%20"
//
//
// 提示：
//
//
// 字符串长度在[0, 500000]范围内。
//
// Related Topics 字符串
// 面试题 01.03. URL化

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class StringToUrlLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "Mr%20John%20Smith", new Solution().replaceSpaces("Mr John Smith    ", 13));
    Printer.printCorrectAnswer(
        "%20%20%20%20%20", new Solution().replaceSpaces("               ", 5));
  }

  static class Solution {
    /**
     * 执行用时： 22 ms , 在所有 Java 提交中击败了 31.20% 的用户
     *
     * <p>内存消耗： 46.6 MB , 在所有 Java 提交中击败了 86.34% 的用户
     *
     * @param S
     * @param length
     * @return
     */
    public String replaceSpaces(String S, int length) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < length; i++) {
        if (i >= S.length() || S.charAt(i) == ' ') sb.append("%20");
        else sb.append(S.charAt(i));
      }
      return sb.toString();
    }
  }
}
