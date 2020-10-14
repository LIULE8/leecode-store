// 给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。
//
// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。
//
//
//
// 示例 1：
//
//
//
// 输入：text = "nlaebolko"
// 输出：1
//
//
// 示例 2：
//
//
//
// 输入：text = "loonbalxballpoon"
// 输出：2
//
//
// 示例 3：
//
// 输入：text = "leetcode"
// 输出：0
//
//
//
//
// 提示：
//
//
// 1 <= text.length <= 10^4
// text 全部由小写英文字母组成
//
// Related Topics 哈希表 字符串
// 1189. “气球” 的最大数量

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfBalloons {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(1, new Solution().maxNumberOfBalloons("nlaebolko"));
    Printer.printCorrectAnswer(2, new Solution().maxNumberOfBalloons("loonbalxballpoon"));
    Printer.printCorrectAnswer(0, new Solution().maxNumberOfBalloons("leetcode"));
  }

  static class Solution {
    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 37.40% 的用户
     *
     * <p>内存消耗： 38.3 MB , 在所有 Java 提交中击败了 53.74% 的用户
     *
     * @param text
     * @return
     */
    public int maxNumberOfBalloons(String text) {
      char[] chars = text.toCharArray();
      Map<Character, Integer> map = new HashMap<>();
      for (char aChar : chars) {
        if (aChar == 'b' || aChar == 'a' || aChar == 'l' || aChar == 'o' || aChar == 'n')
          map.put(aChar, map.getOrDefault(aChar, 0) + 1);
      }
      int dCount = Math.min(map.getOrDefault('l', 0), map.getOrDefault('o', 0));
      if (dCount < 2) return 0;
      int sDount =
          Math.min(
              Math.min(map.getOrDefault('b', 0), map.getOrDefault('a', 0)),
              map.getOrDefault('n', 0));
      if (sDount < 1) return 0;
      return Math.min(dCount >> 1, sDount);
    }
  }
}
