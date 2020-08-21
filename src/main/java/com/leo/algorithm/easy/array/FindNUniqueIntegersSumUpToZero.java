// 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
//
//
//
// 示例 1：
//
// 输入：n = 5
// 输出：[-7,-1,1,3,4]
// 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
//
//
// 示例 2：
//
// 输入：n = 3
// 输出：[-1,0,1]
//
//
// 示例 3：
//
// 输入：n = 1
// 输出：[0]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1000
//
// Related Topics 数组
// 1304. 和为零的N个唯一整数

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.Printer;

public class FindNUniqueIntegersSumUpToZero {
  public static void main(String[] args) {
    Printer.printArray(new Solution().sumZero(7));
    Printer.printArray(new Solution().sumZero(6));
    Printer.printArray(new Solution().sumZero(5));
    Printer.printArray(new Solution().sumZero(4));
    Printer.printArray(new Solution().sumZero(3));
    Printer.printArray(new Solution().sumZero(2));
    Printer.printArray(new Solution().sumZero(1));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.7 MB , 在所有 Java 提交中击败了 67.18% 的用户
     *
     * @param n
     * @return
     */
    public int[] sumZero(int n) {
      int[] a = new int[n];
      for (int i = 0; i < n - 1; i += 2) {
        a[i] = i + 1;
        a[i + 1] = -(i + 1);
      }
      return a;
    }
  }
}
