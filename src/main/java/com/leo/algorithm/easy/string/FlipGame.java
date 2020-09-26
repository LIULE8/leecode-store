// 你和朋友玩一个叫做「翻转游戏」的游戏，游戏规则：给定一个只有 + 和 - 的字符串。你和朋友轮流将 连续 的两个 "++" 反转成 "--"。 当一方无法进
// 行有效的翻转时便意味着游戏结束，则另一方获胜。
//
// 请你写出一个函数，来计算出第一次翻转后，字符串所有的可能状态。
//
//
//
// 示例：
//
// 输入: s = "++++"
// 输出:
// [
//  "--++",
//  "+--+",
//  "++--"
// ]
//
//
// 注意：如果不存在可能的有效操作，请返回一个空列表 []。
// Related Topics 字符串
// 293. 翻转游戏

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

import java.util.LinkedList;
import java.util.List;

public class FlipGame {
  public static void main(String[] args) {
    Printer.printStringList(new Solution().generatePossibleNextMoves("++++"));
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 68.10% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 62.12% 的用户
     *
     * @param s
     * @return
     */
    public List<String> generatePossibleNextMoves(String s) {
      LinkedList<String> strings = new LinkedList<>();
      if (s.length() < 2) {
        return strings;
      }
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i) == '+') {
          sb.append(s, 0, i - 1).append("--").append(s, i + 1, s.length());
          strings.add(sb.toString());
          sb.setLength(0);
        }
      }
      return strings;
    }
  }
}
