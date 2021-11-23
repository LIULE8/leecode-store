// 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
//
//
//
//
//
//
// 示例 1：
//
//
// 输入：n = 2
// 输出：[0,1,1]
// 解释：
// 0 --> 0
// 1 --> 1
// 2 --> 10
//
//
// 示例 2：
//
//
// 输入：n = 5
// 输出：[0,1,1,2,1,2]
// 解释：
// 0 --> 0
// 1 --> 1
// 2 --> 10
// 3 --> 11
// 4 --> 100
// 5 --> 101
//
//
//
//
// 提示：
//
//
// 0 <= n <= 10⁵
//
//
//
//
// 进阶：
//
//
// 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
// 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
//
// 338. 比特位计数
//
// Related Topics 位运算 动态规划

package com.leo.algorithm.easy.dp;

public class CountingBits {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 99.87% 的用户
     *
     * <p>内存消耗： 42.2 MB , 在所有 Java 提交中击败了 84.97% 的用户
     * <li>(i >> 1) 会把最低位去掉，(i >> 1) 也是比 i 小的
     * <li>当 i 的最低位是0，则 i 中 1 的个数和 (i >> 1) 中 1 的个数相同；
     * <li>当 i 的最低位是1，i 中 1 的个数是 (i >> 1)中 1 的个数再加 1
     *
     * @param n
     * @return
     */
    public int[] countBits(int n) {
      int[] dp = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        dp[i] = dp[i >> 1] + (i & 1);
      }
      return dp;
    }
  }
}
