// 给定一个正整数，返回它在 Excel 表中相对应的列名称。
//
// 例如，
//
//     1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//
//
// 示例 1:
//
// 输入: 1
// 输出: "A"
//
//
// 示例 2:
//
// 输入: 28
// 输出: "AB"
//
//
// 示例 3:
//
// 输入: 701
// 输出: "ZY"
//
// Related Topics 数学
// 168. Excel表列名称

package com.leo.algorithm.easy.math;

import com.leo.algorithm.utils.Printer;

public class ExcelSheetColumnTitle {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("AC", new Solution().convertToTitle(29));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.8 MB , 在所有 Java 提交中击败了 35.84% 的用户
     *
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
      StringBuilder sb = new StringBuilder();
      while (columnNumber > 0) {
        sb.append((char) ('A' + --columnNumber % 26));
        columnNumber /= 26;
      }
      return sb.reverse().toString();
    }
  }
}
