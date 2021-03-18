// 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
//
// 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
//
// 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
//
//
//
// 示例 1：
//
//
// 输入：time = "2?:?0"
// 输出："23:50"
// 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
//
//
// 示例 2：
//
//
// 输入：time = "0?:3?"
// 输出："09:39"
//
//
// 示例 3：
//
//
// 输入：time = "1?:22"
// 输出："19:22"
//
//
//
//
// 提示：
//
//
// time 的格式为 hh:mm
// 题目数据保证你可以由输入的字符串生成有效的时间
//
// Related Topics 贪心算法 字符串
// 1736. 替换隐藏数字得到的最晚时间

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class LatestTimeByReplacingHiddenDigits {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("23:59", new Solution().maximumTime("??:??"));
    Printer.printCorrectAnswer("23:50", new Solution().maximumTime("2?:?0"));
    Printer.printCorrectAnswer("09:39", new Solution().maximumTime("0?:3?"));
    Printer.printCorrectAnswer("19:22", new Solution().maximumTime("1?:22"));
  }

  static class Solution {
    public String maximumTime(String time) {
      return method1(time);
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 49.11% 的用户
     *
     * <p>内存消耗： 36.5 MB , 在所有 Java 提交中击败了 98.23% 的用户
     *
     * @param time
     * @return
     */
    private String method1(String time) {
      char[] chars = time.toCharArray();
      for (int i = 0; i < chars.length; i++) {
        char ch = chars[i];
        if (Character.isDigit(ch) || ch == ':') {
          continue;
        }
        if (i == 0) {
          if (chars[i + 1] == '?' || chars[i + 1] < '4') chars[i] = '2';
          else chars[i] = '1';
        } else if (i == 1) {
          if (chars[i - 1] == '2') chars[i] = '3';
          else chars[i] = '9';
        } else if (i == chars.length - 2) {
          chars[i] = '5';
        } else if (i == chars.length - 1) {
          if (chars[i - 1] <= '5') chars[i] = '9';
          else chars[i] = '0';
        }
      }
      return new String(chars);
    }
  }
}
