// 给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词。键盘如下图所示。
//
//
//
//
//
//
//
// 示例：
//
// 输入: ["Hello", "Alaska", "Dad", "Peace"]
// 输出: ["Alaska", "Dad"]
//
//
//
//
// 注意：
//
//
// 你可以重复使用键盘上同一字符。
// 你可以假设输入的字符串将只包含字母。
// Related Topics 哈希表
// 500. 键盘行

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.LinkedList;
import java.util.List;

public class KeyboardRow {
  public static void main(String[] args) {
    Printer.printStringArray(
        new Solution().findWords(DataBuilder.buildStringArray("Hello", "Alaska", "Dad", "Peace")));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.7 MB , 在所有 Java 提交中击败了 60.66% 的用户
     *
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
      int[] a = {2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3};
      List<String> list = new LinkedList<>();
      out:
      for (String word : words) {
        char[] chars = word.toLowerCase().toCharArray();
        int index = a[chars[0] - 'a'];
        for (int i = 1; i < chars.length; i++) {
          if (index != a[chars[i] - 'a']) {
            continue out;
          }
        }
        list.add(word);
      }
      return list.toArray(new String[0]);
    }
  }
}
