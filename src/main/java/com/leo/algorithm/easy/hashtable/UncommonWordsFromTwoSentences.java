// 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
//
// 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
//
// 返回所有不常用单词的列表。
//
// 您可以按任何顺序返回列表。
//
//
//
//
//
//
// 示例 1：
//
// 输入：A = "this apple is sweet", B = "this apple is sour"
// 输出：["sweet","sour"]
//
//
// 示例 2：
//
// 输入：A = "apple apple", B = "banana"
// 输出：["banana"]
//
//
//
//
// 提示：
//
//
// 0 <= A.length <= 200
// 0 <= B.length <= 200
// A 和 B 都只包含空格和小写字母。
// 884. 两句话中的不常见单词
// Related Topics 哈希表
// 👍 77 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UncommonWordsFromTwoSentences {
  public static void main(String[] args) {
    Printer.printStringArray(
        new Solution().uncommonFromSentences("this apple is sweet", "this apple is sour"));
    Printer.printStringArray(new Solution().uncommonFromSentences("apple apple", "banana"));
    Printer.printStringArray(new Solution().uncommonFromSentences("s z z z s", "s z ejt"));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 48.59% 的用户
     *
     * <p>内存消耗： 38.8 MB , 在所有 Java 提交中击败了 5.31% 的用户
     *
     * @param A
     * @param B
     * @return
     */
    public String[] uncommonFromSentences(String A, String B) {
      Map<String, Integer> map = new HashMap<>();
      buildMap(map, A);
      buildMap(map, B);
      Set<String> result = new HashSet<>();
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        if (entry.getValue() == 1) {
          result.add(entry.getKey());
        }
      }
      return result.toArray(new String[0]);
    }

    private void buildMap(Map<String, Integer> map, String a) {
      for (String s : a.split(" ")) {
        map.put(s, map.getOrDefault(s, 0) + 1);
      }
    }
  }
}
