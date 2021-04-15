// 给定一个Excel表格中的列名称，返回其相应的列序号。
//
// 例如，
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//
// 示例 1:
//
// 输入: "A"
// 输出: 1
//
//
// 示例 2:
//
// 输入: "AB"
// 输出: 28
//
//
// 示例 3:
//
// 输入: "ZY"
// 输出: 701
//
// 致谢：
// 特别感谢 @ts 添加此问题并创建所有测试用例。
// Related Topics 数学
// 171. Excel表列序号

package com.leo.algorithm.easy.math;

public class ExcelSheetColumnNumber {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.3 MB , 在所有 Java 提交中击败了 81.21% 的用户
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
      int sum = 0;
      for (int i = 0; i < columnTitle.length(); i++) {
        sum = sum * 26 + (columnTitle.charAt(i) - 'A' + 1);
      }
      return sum;
    }
  }
}
