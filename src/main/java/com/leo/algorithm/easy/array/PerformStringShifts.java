// 给定一个包含小写英文字母的字符串 s 以及一个矩阵 shift，其中 shift[i] = [direction, amount]：
//
//
// direction 可以为 0 （表示左移）或 1 （表示右移）。
// amount 表示 s 左右移的位数。
// 左移 1 位表示移除 s 的第一个字符，并将该字符插入到 s 的结尾。
// 类似地，右移 1 位表示移除 s 的最后一个字符，并将该字符插入到 s 的开头。
//
//
// 对这个字符串进行所有操作后，返回最终结果。
//
//
//
// 示例 1：
//
//
// 输入：s = "abc", shift = [[0,1],[1,2]]
// 输出："cab"
// 解释：
// [0,1] 表示左移 1 位。 "abc" -> "bca"
// [1,2] 表示右移 2 位。 "bca" -> "cab"
//
// 示例 2：
//
//
// 输入：s = "abcdefg", shift = [[1,1],[1,1],[0,2],[1,3]]
// 输出："efgabcd"
// 解释：
// [1,1] 表示右移 1 位。 "abcdefg" -> "gabcdef"
// [1,1] 表示右移 1 位。 "gabcdef" -> "fgabcde"
// [0,2] 表示左移 2 位。 "fgabcde" -> "abcdefg"
// [1,3] 表示右移 3 位。 "abcdefg" -> "efgabcd"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 只包含小写英文字母
// 1 <= shift.length <= 100
// shift[i].length == 2
// 0 <= shift[i][0] <= 1
// 0 <= shift[i][1] <= 100
//
// Related Topics 数组 数学
// 1427. 字符串的左右移

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class PerformStringShifts {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "cab", new Solution().stringShift("abc", DataBuilder.buildDoubleArray("[[0,1],[1,2]]")));
    Printer.printCorrectAnswer(
        "efgabcd",
        new Solution()
            .stringShift("abcdefg", DataBuilder.buildDoubleArray("[[1,1],[1,1],[0,2],[1,3]]")));
    Printer.printCorrectAnswer(
        "yisxjwry",
        new Solution()
            .stringShift(
                "yisxjwry",
                DataBuilder.buildDoubleArray("[[1,8],[1,4],[1,3],[1,6],[0,6],[1,4],[0,2],[0,1]]")));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.7 MB , 在所有 Java 提交中击败了 61.54% 的用户
     *
     * @param s
     * @param shift
     * @return
     */
    public String stringShift(String s, int[][] shift) {
      int left = 0, right = 0;
      for (int[] ints : shift) {
        if (ints[0] == 0) left += ints[1];
        else right += ints[1];
      }
      int amount = (left - right) % s.length();
      if (amount < 0) {
        return s.substring(s.length() + amount + 1) + s.substring(0, s.length() - 1 + amount + 1);
      } else if (amount > 0) {
        return s.substring(amount) + s.substring(0, amount);
      }
      return s;
    }
  }
}
