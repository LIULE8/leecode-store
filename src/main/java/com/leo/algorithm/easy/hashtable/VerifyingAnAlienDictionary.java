// 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
//
// 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 fals
// e。
//
//
//
// 示例 1：
//
// 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
// 输出：true
// 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
//
// 示例 2：
//
// 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
// 输出：false
// 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
//
// 示例 3：
//
// 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
// 输出：false
// 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅'
// 是空白字符，定义为比任何其他字符都小（更多信息）。
//
//
//
// 953. 验证外星语词典
// 提示：
//
//
// 1 <= words.length <= 100
// 1 <= words[i].length <= 20
// order.length == 26
// 在 words[i] 和 order 中的所有字符都是英文小写字母。
//
// Related Topics 哈希表
// 👍 70 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class VerifyingAnAlienDictionary {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        true,
        new Solution()
            .isAlienSorted(
                DataBuilder.buildStringArray("hello", "leetcode"), "hlabcdefgijkmnopqrstuvwxyz"));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .isAlienSorted(
                DataBuilder.buildStringArray("word", "world", "row"),
                "worldabcefghijkmnpqstuvxyz"));
    Printer.printCorrectAnswer(
        false,
        new Solution()
            .isAlienSorted(
                DataBuilder.buildStringArray("apple", "app"), "abcdefghijklmnopqrstuvwxyz"));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.4 MB , 在所有 Java 提交中击败了 52.23% 的用户
     *
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
      int[] orders = new int[26];
      char[] chars = order.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        orders[chars[i] - 'a'] = i;
      }
      for (int i = 1; i < words.length; i++) {
        int j = compareTo(words[i - 1].toCharArray(), words[i].toCharArray(), orders);
        if (j > 0) return false;
      }
      return true;
    }

    public static int compareTo(char[] value, char[] other, int[] orders) {
      int lim = Math.min(value.length, other.length);
      for (int k = 0; k < lim; k++) {
        if (value[k] != other[k]) {
          return getCharOrder(value[k], orders) - getCharOrder(other[k], orders);
        }
      }
      return value.length - other.length;
    }

    private static int getCharOrder(char ch, int[] orders) {
      return orders[ch - 'a'];
    }
  }
}
