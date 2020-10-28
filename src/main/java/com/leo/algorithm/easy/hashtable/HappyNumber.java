// 编写一个算法来判断一个数 n 是不是快乐数。
//
// 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
// 如果 可以变为 1，那么这个数就是快乐数。
//
// 如果 n 是快乐数就返回 True ；不是，则返回 False 。
//
//
//
// 示例：
//
// 输入：19
// 输出：true
// 解释：
// 1^2 + 9^2 = 82
// 8^2 + 2^2 = 68
// 6^2 + 8^2 = 100
// 1^2 + 0^2 + 0^2 = 1
//
// Related Topics 哈希表 数学
// 202. 快乐数

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.Printer;

public class HappyNumber {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(true, new Solution().isHappy(19));
  }

  static class Solution {
    /**
     * 快慢指针
     *
     * <p>执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.4 MB , 在所有 Java 提交中击败了 90.16% 的用户
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
      int slow = n, fast = n;
      do {
        slow = bitSquareSum(slow);
        fast = bitSquareSum(bitSquareSum(fast));
      } while (slow != fast);
      return slow == 1;
    }

    private int bitSquareSum(int n) {
      int sum = 0;
      while (n > 0) {
        int bit = n % 10;
        sum += bit * bit;
        n /= 10;
      }
      return sum;
    }
  }
}
