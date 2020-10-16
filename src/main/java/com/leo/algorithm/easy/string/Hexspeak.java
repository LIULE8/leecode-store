// 你有一个十进制数字，请按照此规则将它变成「十六进制魔术数字」：首先将它变成字母大写的十六进制字符串，然后将所有的数字 0 变成字母 O ，将数字 1 变成字
// 母 I 。
//
// 如果一个数字在转换后只包含 {"A", "B", "C", "D", "E", "F", "I", "O"} ，那么我们就认为这个转换是有效的。
//
// 给你一个字符串 num ，它表示一个十进制数 N，如果它的十六进制魔术数字转换是有效的，请返回转换后的结果，否则返回 "ERROR" 。
//
//
//
// 示例 1：
//
// 输入：num = "257"
// 输出："IOI"
// 解释：257 的十六进制表示是 101 。
//
//
// 示例 2：
//
// 输入：num = "3"
// 输出："ERROR"
//
//
//
//
// 提示：
//
//
// 1 <= N <= 10^12
// 给定字符串不会有前导 0 。
// 结果中的所有字母都应该是大写字母。
//
// Related Topics 数学 字符串
// 1271. 十六进制魔术数字

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class Hexspeak {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("IOI", new Solution().toHexspeak("257"));
    Printer.printCorrectAnswer("ERROR", new Solution().toHexspeak("3"));
  }

  static class Solution {
    public String toHexspeak(String num) {
      return method1(num);
    }

    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 68.83% 的用户
     *
     * <p>内存消耗： 38.5 MB , 在所有 Java 提交中击败了 32.73% 的用户
     *
     * @param num
     * @return
     */
    private String method1(String num) {
      long numInt = Long.parseLong(num);
      Map<Long, Character> map = new HashMap<>();
      map.put(10L, 'A');
      map.put(11L, 'B');
      map.put(12L, 'C');
      map.put(13L, 'D');
      map.put(14L, 'E');
      map.put(15L, 'F');
      map.put(0L, 'O');
      map.put(1L, 'I');
      StringBuilder sb = new StringBuilder();
      while (numInt != 0) {
        long i = numInt % 16;
        if (i < 10 && i > 1) return "ERROR";
        else sb.append(map.get(i));
        numInt /= 16;
      }
      return sb.reverse().toString();
    }
  }
}
