// 给定一个由空格分割单词的句子 S。每个单词只包含大写或小写字母。
//
// 我们要将句子转换为 “Goat Latin”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。
//
// 山羊拉丁文的规则如下：
//
//
// 如果单词以元音开头（a, e, i, o, u），在单词后添加"ma"。
// 例如，单词"apple"变为"applema"。
//
// 如果单词以辅音字母开头（即非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
// 例如，单词"goat"变为"oatgma"。
//
// 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从1开始。
// 例如，在第一个单词后添加"a"，在第二个单词后添加"aa"，以此类推。
//
//
// 返回将 S 转换为山羊拉丁文后的句子。
//
// 示例 1:
//
//
// 输入: "I speak Goat Latin"
// 输出: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
//
//
// 示例 2:
//
//
// 输入: "The quick brown fox jumped over the lazy dog"
// 输出: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaa
// aaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
//
//
// 说明:
//
//
// S 中仅包含大小写字母和空格。单词间有且仅有一个空格。
// 1 <= S.length <= 150。
//
// Related Topics 字符串
// 824. 山羊拉丁文

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "Imaa peaksmaaa oatGmaaaa atinLmaaaaa", new Solution().toGoatLatin("I speak Goat Latin"));
    Printer.printCorrectAnswer(
        "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa",
        new Solution().toGoatLatin("The quick brown fox jumped over the lazy dog"));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 70.66% 的用户
     *
     * <p>内存消耗： 37 MB , 在所有 Java 提交中击败了 88.98% 的用户
     *
     * @param S
     * @return
     */
    public String toGoatLatin(String S) {
      StringBuilder sb = new StringBuilder();
      String[] s = S.split(" ");
      Set<Character> set =
          new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
      for (int i = 0; i < s.length; i++) {
        char c = s[i].charAt(0);
        if (set.contains(c)) sb.append(s[i]);
        else sb.append(s[i].substring(1)).append(c);
        sb.append("ma");
        for (int j = 0; j < i + 1; j++) {
          sb.append("a");
        }
        if (i != s.length - 1) sb.append(" ");
      }
      return sb.toString();
    }
  }
}
