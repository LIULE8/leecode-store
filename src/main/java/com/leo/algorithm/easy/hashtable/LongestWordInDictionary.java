// 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
// 回答案中字典序最小的单词。
//
// 若无答案，则返回空字符串。
//
//
//
// 示例 1：
//
// 输入：
// words = ["w","wo","wor","worl", "world"]
// 输出："world"
// 解释：
// 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
//
//
// 示例 2：
//
// 输入：
// words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
// 输出："apple"
// 解释：
// "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
//
//
//
//
// 提示：
//
//
// 所有输入的字符串都只包含小写字母。
// words数组长度范围为[1,1000]。
// words[i]的长度范围为[1,30]。
//
// Related Topics 字典树 哈希表
// 720. 词典中最长的单词

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "world",
        new Solution()
            .longestWord(DataBuilder.buildStringArray("w", "wo", "wor", "worl", "world")));
    Printer.printCorrectAnswer(
        "apple",
        new Solution()
            .longestWord(
                DataBuilder.buildStringArray(
                    "a", "banana", "app", "appl", "ap", "apply", "apple")));
  }

  static class Solution {
    /**
     * 执行用时： 22 ms , 在所有 Java 提交中击败了 46.39% 的用户
     *
     * <p>内存消耗： 38.9 MB , 在所有 Java 提交中击败了 39.79% 的用户
     *
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
      Arrays.sort(words);
      Set<String> set = new HashSet<>();
      String result = "";
      for (String word : words) {
        if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
          result = word.length() > result.length() ? word : result;
          set.add(word);
        }
      }
      return result;
    }
  }
}
