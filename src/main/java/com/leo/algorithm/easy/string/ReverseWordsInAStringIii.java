// 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例：
//
// 输入："Let's take LeetCode contest"
// 输出："s'teL ekat edoCteeL tsetnoc"
//
//
//
//
// 提示：
//
//
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
//
// Related Topics 字符串
// 557. 反转字符串中的单词 III

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class ReverseWordsInAStringIii {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "s'teL ekat edoCteeL tsetnoc", new Solution().reverseWords("Let's take LeetCode contest"));
  }

  static class Solution {
    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 89.57% 的用户
     *
     * <p>内存消耗： 39.1 MB , 在所有 Java 提交中击败了 96.36% 的用户
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
      StringBuilder sb = new StringBuilder();
      StringBuilder temp = new StringBuilder();
      String[] split = s.split(" ");
      for (int i = 0; i < split.length - 1; i++) {
        sb.append(temp.append(split[i]).reverse()).append(" ");
        temp.setLength(0);
      }
      return sb.append(temp.append(split[split.length - 1]).reverse()).toString();
    }
  }
}
