// 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
//
// 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
//
//
//
//
//
//
// 示例 1：
//
// 输入：A = [1,2,0,0], K = 34
// 输出：[1,2,3,4]
// 解释：1200 + 34 = 1234
//
//
// 示例 2：
//
// 输入：A = [2,7,4], K = 181
// 输出：[4,5,5]
// 解释：274 + 181 = 455
//
//
// 示例 3：
//
// 输入：A = [2,1,5], K = 806
// 输出：[1,0,2,1]
// 解释：215 + 806 = 1021
//
//
// 示例 4：
//
// 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
// 输出：[1,0,0,0,0,0,0,0,0,0,0]
// 解释：9999999999 + 1 = 10000000000
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 10000
// 0 <= A[i] <= 9
// 0 <= K <= 10000
// 如果 A.length > 1，那么 A[0] != 0
//
// Related Topics 数组
// 和 加一 那题类似
// 989. 数组形式的整数加法

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
  public static void main(String[] args) {
    Printer.printIntegerList(
        new Solution().addToArrayForm(DataBuilder.buildIntArray("1,2,0,0"), 34));
    Printer.printIntegerList(
        new Solution().addToArrayForm(DataBuilder.buildIntArray("2,7,4"), 181));
    Printer.printIntegerList(
        new Solution().addToArrayForm(DataBuilder.buildIntArray("2,1,5"), 806));
    Printer.printIntegerList(
        new Solution().addToArrayForm(DataBuilder.buildIntArray("9,9,9,9,9,9,9,9,9,9"), 1));
    Printer.printIntegerList(
        new Solution().addToArrayForm(DataBuilder.buildIntArray("9,9,9,9,9,9,9,9,9,9"), 0));
    Printer.printIntegerList(new Solution().addToArrayForm(DataBuilder.buildIntArray("0"), 34));
    Printer.printIntegerList(new Solution().addToArrayForm(DataBuilder.buildIntArray("6"), 809));
    Printer.printIntegerList(new Solution().addToArrayForm(DataBuilder.buildIntArray("7"), 993));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 99.54% 的用户
     *
     * <p>内存消耗： 42.3 MB , 在所有 Java 提交中击败了 5.25% 的用户
     *
     * @param A
     * @param K
     * @return
     */
    public List<Integer> addToArrayForm(int[] A, int K) {
      int i = A.length - 1;
      int c = 0;
      LinkedList<Integer> list = new LinkedList<>();
      for (; i >= 0; --i) {
        int a = K % 10;
        if (a == 0 && K == 0) break;
        K /= 10;
        if (a + A[i] + c >= 10) {
          list.addFirst((a + A[i] + c) % 10);
          c = 1;
        } else {
          list.addFirst(a + A[i] + c);
          c = 0;
        }
      }
      while (i >= 0) {
        if (c + A[i] >= 10) {
          list.addFirst((c + A[i]) % 10);
          c = 1;
        } else {
          list.addFirst(c + A[i]);
          c = 0;
        }
        i--;
      }
      if (K > 0) {
        while (K > 0) {
          int a = K % 10;
          if (a + c >= 10) {
            list.addFirst(0);
            c = 1;
          } else {
            list.addFirst(c + a);
            c = 0;
          }
          K /= 10;
        }
      }
      if (c == 1) {
        list.addFirst(c);
      }
      return list;
    }
  }
}
