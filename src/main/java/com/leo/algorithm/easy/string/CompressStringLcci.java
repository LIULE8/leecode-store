// 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
// 有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
//
// 示例1:
//
//
// 输入："aabcccccaaa"
// 输出："a2b1c5a3"
//
//
// 示例2:
//
//
// 输入："abbccd"
// 输出："abbccd"
// 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
//
//
// 提示：
//
//
// 字符串长度在[0, 50000]范围内。
//
// Related Topics 字符串
// 面试题 01.06. 字符串压缩

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class CompressStringLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("a2b1c5a3", new Solution().compressString("aabcccccaaa"));
    Printer.printCorrectAnswer("abbccd", new Solution().compressString("abbccd"));
  }

  static class Solution {
    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 75.50% 的用户
     *
     * <p>内存消耗： 39.1 MB , 在所有 Java 提交中击败了 28.68% 的用户
     *
     * @param S
     * @return
     */
    public String compressString(String S) {
      StringBuilder sb = new StringBuilder();
      int index = 0;
      while (index < S.length()) {
        int count = 0;
        char ch = S.charAt(index);
        while (index < S.length() && ch == S.charAt(index)) {
          count++;
          index++;
        }
        sb.append(ch);
        if (count > 0) {
          sb.append(count);
        }
      }
      return sb.length() >= S.length() ? S : sb.toString();
    }
  }
}
