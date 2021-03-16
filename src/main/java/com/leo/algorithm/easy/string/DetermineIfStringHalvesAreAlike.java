// 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
//
// 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含
// 有大写和小写字母。
//
// 如果 a 和 b 相似，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
// 输入：s = "book"
// 输出：true
// 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
//
//
// 示例 2：
//
// 输入：s = "textbook"
// 输出：false
// 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
// 注意，元音 o 在 b 中出现两次，记为 2 个。
//
//
// 示例 3：
//
// 输入：s = "MerryChristmas"
// 输出：false
//
//
// 示例 4：
//
// 输入：s = "AbCdEfGh"
// 输出：true
//
//
//
//
// 提示：
//
//
// 2 <= s.length <= 1000
// s.length 是偶数
// s 由 大写和小写 字母组成
//
// Related Topics 字符串
// 1704. 判断字符串的两半是否相似

package com.leo.algorithm.easy.string;

import java.util.HashSet;
import java.util.Set;

public class DetermineIfStringHalvesAreAlike {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public boolean halvesAreAlike(String s) {
      //      return method1(s);
      return method2(s);
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 95.99% 的用户
     *
     * <p>内存消耗： 36.7 MB , 在所有 Java 提交中击败了 86.19% 的用户
     *
     * @param s
     * @return
     */
    private boolean method2(String s) {
      int length = s.length() >> 1;
      int count1 = 0, count2 = 0;
      for (int i = 0; i < length; i++) {
        if (isOriginCharacter(s.charAt(i))) count1++;
        if (isOriginCharacter(s.charAt(length + i))) count2++;
      }
      return count1 == count2;
    }

    private boolean isOriginCharacter(char ch) {
      return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E'
          || ch == 'I' || ch == 'O' || ch == 'U';
    }

    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 54.94% 的用户
     *
     * <p>内存消耗： 37.1 MB , 在所有 Java 提交中击败了 17.89% 的用户
     *
     * @param s
     * @return
     */
    private boolean method1(String s) {
      Set<Character> set = new HashSet<>(10);
      set.add('a');
      set.add('e');
      set.add('i');
      set.add('o');
      set.add('u');
      set.add('A');
      set.add('E');
      set.add('I');
      set.add('O');
      set.add('U');
      int length = s.length() >> 1;
      int count1 = 0, count2 = 0;
      for (int i = 0; i < length; i++) {
        if (set.contains(s.charAt(i))) count1++;
        if (set.contains(s.charAt(length + i))) count2++;
      }
      return count1 == count2;
    }
  }
}
