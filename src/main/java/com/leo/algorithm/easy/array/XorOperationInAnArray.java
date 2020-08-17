// 给你两个整数，n 和 start 。
//
// 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
//
// 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
//
//
//
// 示例 1：
//
// 输入：n = 5, start = 0
// 输出：8
// 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
//     "^" 为按位异或 XOR 运算符。
//
//
// 示例 2：
//
// 输入：n = 4, start = 3
// 输出：8
// 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
//
// 示例 3：
//
// 输入：n = 1, start = 7
// 输出：7
//
//
// 示例 4：
//
// 输入：n = 10, start = 5
// 输出：2
//
//
//
//
// 提示：
//
//
// 1 <= n <= 1000
// 0 <= start <= 1000
// n == nums.length
//
// Related Topics 位运算 数组
// 1486. 数组异或操作

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.Printer;

public class XorOperationInAnArray {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(8, new Solution().xorOperation(5, 0));
    Printer.printCorrectAnswer(8, new Solution().xorOperation(4, 3));
    Printer.printCorrectAnswer(7, new Solution().xorOperation(1, 7));
    Printer.printCorrectAnswer(2, new Solution().xorOperation(10, 5));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.2 MB , 在所有 Java 提交中击败了 85.09% 的用户
     *
     * @param n
     * @param start
     * @return
     */
    public int xorOperation(int n, int start) {
      if (n == 1) return start;
      int result = start;
      for (int i = 1; i < n; i++) {
        result ^= start + 2 * i;
      }
      return result;
    }
  }
}
