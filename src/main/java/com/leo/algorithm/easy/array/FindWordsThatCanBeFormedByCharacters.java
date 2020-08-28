// 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
//
// 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
//
// 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
//
// 返回词汇表 words 中你掌握的所有单词的 长度之和。
//
//
//
// 示例 1：
//
// 输入：words = ["cat","bt","hat","tree"], chars = "atach"
// 输出：6
// 解释：
// 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
//
//
// 示例 2：
//
// 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
// 输出：10
// 解释：
// 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
//
//
//
//
// 提示：
//
//
// 1 <= words.length <= 1000
// 1 <= words[i].length, chars.length <= 100
// 所有字符串中都仅包含小写英文字母
//
// Related Topics 数组 哈希表
// 1160. 拼写单词

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        6,
        new Solution()
            .countCharacters(DataBuilder.buildStringArray("cat", "bt", "hat", "tree"), "atach"));
    Printer.printCorrectAnswer(
        10,
        new Solution()
            .countCharacters(
                DataBuilder.buildStringArray("hello", "world", "leetcode"), "welldonehoneyr"));
  }

  static class Solution {
    /**
     * 执行用时： 91 ms , 在所有 Java 提交中击败了 9.15% 的用户
     *
     * <p>内存消耗： 40.6 MB , 在所有 Java 提交中击败了 6.47% 的用户
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
      int count = 0;
      Map<String, Integer> charsMap = buildWordMap(chars);
      for (String word : words) {
        boolean flag = true;
        Map<String, Integer> wordMap = buildWordMap(word);
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
          if (!charsMap.containsKey(entry.getKey())
              || charsMap.get(entry.getKey()) < entry.getValue()) {
            flag = false;
            break;
          }
        }
        if (flag) {
          count += word.length();
        }
      }
      return count;
    }

    private Map<String, Integer> buildWordMap(String chars) {
      Map<String, Integer> map = new HashMap<>();
      for (int i = 0; i < chars.length(); i++) {
        String c = String.valueOf(chars.charAt(i));
        map.put(c, map.getOrDefault(c, 0) + 1);
      }
      return map;
    }
  }
}
