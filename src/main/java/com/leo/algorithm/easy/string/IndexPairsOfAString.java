// 给出 字符串 text 和 字符串列表 words, 返回所有的索引对 [i, j] 使得在索引对范围内的子字符串 text[i]...text[j]（包括
// i 和 j）属于字符串列表 words。
//
//
//
// 示例 1:
//
// 输入: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
// 输出: [[3,7],[9,13],[10,17]]
//
//
// 示例 2:
//
// 输入: text = "ababa", words = ["aba","ab"]
// 输出: [[0,1],[0,2],[2,3],[2,4]]
// 解释:
// 注意，返回的配对可以有交叉，比如，"aba" 既在 [0,2] 中也在 [2,4] 中
//
//
//
//
// 提示:
//
//
// 所有字符串都只包含小写字母。
// 保证 words 中的字符串无重复。
// 1 <= text.length <= 100
// 1 <= words.length <= 20
// 1 <= words[i].length <= 50
// 按序返回索引对 [i,j]（即，按照索引对的第一个索引进行排序，当第一个索引对相同时按照第二个索引对排序）。
//
// Related Topics 字典树 字符串
// 1065. 字符串的索引对

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.*;

public class IndexPairsOfAString {
  public static void main(String[] args) {
    Printer.printDoubleArray(
        new Solution()
            .indexPairs(
                "thestoryofleetcodeandme",
                DataBuilder.buildStringArray("story", "fleet", "leetcode")));
    Printer.printDoubleArray(
        new Solution().indexPairs("ababa", DataBuilder.buildStringArray("aba", "ab")));
  }

  static class Solution {
    /**
     * 执行用时： 16 ms , 在所有 Java 提交中击败了 6.31% 的用户
     *
     * <p>内存消耗： 39.7 MB , 在所有 Java 提交中击败了 5.80% 的用户
     *
     * @param text
     * @param words
     * @return
     */
    public int[][] indexPairs(String text, String[] words) {
      Set<String> wordSet = new HashSet<>();
      Collections.addAll(wordSet, words);
      List<int[]> list = new LinkedList<>();
      for (int i = 0; i < text.length(); i++) {
        for (int j = i; j < text.length(); j++) {
          if (wordSet.contains(text.substring(i, j + 1))) {
            list.add(new int[] {i, j});
          }
        }
      }
      int[][] result = new int[list.size()][2];
      for (int i = 0; i < list.size(); i++) {
        System.arraycopy(list.get(i), 0, result[i], 0, 2);
      }
      return result;
    }
  }
}
