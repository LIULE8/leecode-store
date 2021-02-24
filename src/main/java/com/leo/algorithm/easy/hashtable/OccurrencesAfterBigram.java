// 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 se
// cond 紧随 first 出现，third 紧随 second 出现。
//
// 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
//
//
//
// 示例 1：
//
// 输入：text = "alice is a good girl she is a good student", first = "a", second =
// "good"
// 输出：["girl","student"]
//
//
// 示例 2：
//
// 输入：text = "we will we will rock you", first = "we", second = "will"
// 输出：["we","rock"]
//
//
//
//
// 提示：
//
//
// 1 <= text.length <= 1000
// text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
// 1 <= first.length, second.length <= 10
// first 和 second 由小写英文字母组成
// 1078. Bigram 分词
// Related Topics 哈希表
// 👍 19 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.Printer;

import java.util.LinkedList;
import java.util.List;

public class OccurrencesAfterBigram {
  public static void main(String[] args) {
    Printer.printStringArray(
        new Solution().findOcurrences("alice is a good girl she is a good student", "a", "good"));
    Printer.printStringArray(
        new Solution().findOcurrences("we will we will rock you", "we", "will"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 95.96% 的用户
     *
     * <p>内存消耗： 36.8 MB , 在所有 Java 提交中击败了 28.88% 的用户
     *
     * @param text
     * @param first
     * @param second
     * @return
     */
    public String[] findOcurrences(String text, String first, String second) {
      String[] s = text.split(" ");
      List<String> result = new LinkedList<>();
      for (int i = 1; i < s.length; i++) {
        if (s[i - 1].equals(first) && s[i].equals(second) && i + 1 < s.length) {
          result.add(s[i + 1]);
        }
      }
      return result.toArray(new String[0]);
    }
  }
}
