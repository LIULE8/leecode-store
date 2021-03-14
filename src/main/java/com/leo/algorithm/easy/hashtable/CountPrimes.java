// 统计所有小于非负整数 n 的质数的数量。
//
//
//
// 示例 1：
//
// 输入：n = 10
// 输出：4
// 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//
//
// 示例 2：
//
// 输入：n = 0
// 输出：0
//
//
// 示例 3：
//
// 输入：n = 1
// 输出：0
//
//
//
//
// 提示：
//
//
// 0 <= n <= 5 * 106
//
// Related Topics 哈希表 数学
// 204. 计数质数

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.Printer;

public class CountPrimes {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(1229, new Solution().countPrimes(10000));
    Printer.printCorrectAnswer(8, new Solution().countPrimes(20));
    Printer.printCorrectAnswer(8, new Solution().countPrimes(20));
  }

  static class Solution {
    /**
     * 执行用时： 234 ms , 在所有 Java 提交中击败了 26.16% 的用户
     *
     * <p>内存消耗： 34.9 MB , 在所有 Java 提交中击败了 98.80% 的用户
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
      int count = 0;
      for (int i = 2; i < n; i++) {
        if (isPrime_3(i)) count++;
      }
      return count;
    }

    private boolean isPrime_3(int num) {
      // 两个较小数另外处理
      if (num == 2 || num == 3) return true;
      // 不在6的倍数两侧的一定不是质数
      if (num % 6 != 1 && num % 6 != 5) return false;
      double tmp = Math.sqrt(num);
      // 在6的倍数两侧的也可能不是质数
      for (int i = 5; i <= tmp; i += 6) if (num % i == 0 || num % (i + 2) == 0) return false;
      // 排除所有，剩余的是质数
      return true;
    }
  }
}
