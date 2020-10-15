// 给定一个关键词集合 words 和一个字符串 S，将所有 S 中出现的关键词加粗。所有在标签 <b> 和 </b> 中的字母都会加粗。
//
// 返回的字符串需要使用尽可能少的标签，当然标签应形成有效的组合。
//
// 例如，给定 words = ["ab", "bc"] 和 S = "aabcd"，需要返回 "a<b>abc</b>d"。注意返回 "a<b>a<b>b<
/// b>c</b>d" 会使用更多的标签，因此是错误的。
//
//
//
// 注：
//
//
// words 长度的范围为 [0, 50]。
// words[i] 长度的范围为 [1, 10]。
// S 长度的范围为 [0, 500]。
// 所有 words[i] 和 S 中的字符都为小写字母。
//
//
//
// Related Topics 字符串
// 758. 字符串中的加粗单词

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class BoldWordsInString {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "a<b>abc</b>d",
        new Solution().boldWords(DataBuilder.buildStringArray("ab", "bc"), "aabcd"));
  }

  static class Solution {
    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 84.62% 的用户
     *
     * <p>内存消耗： 36.9 MB , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * @param words
     * @param S
     * @return
     */
    public String boldWords(String[] words, String S) {
      boolean[] isBold = new boolean[S.length()];
      for (String word : words) {
        int n = S.indexOf(word);
        while (n != -1) {
          for (int i = n; i < n + word.length(); i++) isBold[i] = true;
          n = S.indexOf(word, n + 1);
        }
      }
      StringBuilder sb = new StringBuilder();
      if (isBold[0]) sb.append("<b>");
      for (int i = 0; i < isBold.length; i++) {
        sb.append(S.charAt(i));
        if (i == isBold.length - 1) {
          if (isBold[i]) {
            sb.append("</b>");
          }
          break;
        }
        if (isBold[i] && !isBold[i + 1]) sb.append("</b>");
        if (!isBold[i] && isBold[i + 1]) sb.append("<b>");
      }
      return sb.toString();
    }
  }
}
