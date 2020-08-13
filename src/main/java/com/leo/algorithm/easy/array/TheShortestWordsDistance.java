package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.List;

// 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
//
// 示例:
// 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
//
// 输入: word1 = “coding”, word2 = “practice”
// 输出: 3
// 输入: word1 = "makes", word2 = "coding"
// 输出: 1
// 注意:
// 你可以假设 word1 不等于 word2, 并且 word1 和 word2 都在列表里。
//
// 243. 最短单词距离
public class TheShortestWordsDistance {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] words = DataBuilder.buildStringArray("practice,makes,perfect,coding,makes");
    Printer.printCorrectAnswer(3, solution.shortestDistance(words, "coding", "practice"));
    Printer.printCorrectAnswer(1, solution.shortestDistance(words, "makes", "coding"));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 61.64% 的用户
     *
     * <p>内存消耗： 39.9 MB , 在所有 Java 提交中击败了 72.41% 的用户
     *
     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] words, String word1, String word2) {
      if (words == null || words.length == 0) return 0;
      List<Integer> index1 = new ArrayList<>(words.length);
      List<Integer> index2 = new ArrayList<>(words.length);
      for (int i = 0; i < words.length; i++) {
        if (words[i].equalsIgnoreCase(word1)) index1.add(i);
        else if (words[i].equalsIgnoreCase(word2)) index2.add(i);
      }
      int min = Integer.MAX_VALUE;
      for (Integer integer : index1) {
        for (Integer value : index2) {
          min = Math.min(min, Math.abs(integer - value));
        }
      }
      return min;
    }
  }
}
