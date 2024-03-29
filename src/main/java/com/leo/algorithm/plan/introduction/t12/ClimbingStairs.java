// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
// 输出： 2
// 解释： 有两种方法可以爬到楼顶。
// 1.  1 阶 + 1 阶
// 2.  2 阶
//
// 示例 2：
//
// 输入： 3
// 输出： 3
// 解释： 有三种方法可以爬到楼顶。
// 1.  1 阶 + 1 阶 + 1 阶
// 2.  1 阶 + 2 阶
// 3.  2 阶 + 1 阶
//
// Related Topics 记忆化搜索 数学 动态规划
// 70. 爬楼梯

package com.leo.algorithm.plan.introduction.t12;

public class ClimbingStairs {
  public static void main(String[] args) {
    //    int i = new Solution().climbStairs(2);
    //    int i = new Solution().climbStairs(3);
    //    int i = new Solution().climbStairs(4);
    int i = new Solution().climbStairs(44);
    System.out.println(i);
  }

  static class Solution {
    public int climbStairs(int n) {
      //      int[] codes = new int[] {1, 2};
      //      return method1(codes, n);

      //      int[] codes = new int[] {1, 2};
      //      int[] node = new int[n];
      //      Arrays.fill(node, -1);
      //      return method2(node, codes, n);

      return method3(n);
    }

    /**
     * 本质上是斐波拉契数列
     *
     * <p>执行用时 : 0 ms , 在所有 java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 32.7 MB , 在所有 java 提交中击败了 75.54% 的用户
     *
     * <p>第10阶的走法数量 == 第9阶的走法数量 + 第8阶的走法数量 .. F(10) = F(9) + F(8)
     *
     * <p>第1阶的走法数量 == 1 F(1) = 1
     *
     * <p>第2阶的走法数量 == 2 F(2) = 2
     *
     * @param n
     * @return
     */
    private int method3(int n) {
      if (n == 1) return 1;
      int a = 1;
      int b = 1;
      int sum = 0;
      for (int i = 1; i < n; i++) {
        sum = a + b;
        a = b;
        b = sum;
      }
      return sum;
    }

    /**
     * 递归算法 --- 备忘录模式
     *
     * <p>执行用时 : 0 ms , 在所有 java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 33.1 MB , 在所有 java 提交中击败了 72.04% 的用户
     *
     * @param node
     * @param code
     * @param n
     * @return
     */
    private int method2(int[] node, int[] code, int n) {
      if (n == 0) return 0;
      if (n == 1) return 1;
      if (n == 2) return 2;
      if (node[n - 1] != -1) return node[n - 1];
      int sum = 0;
      for (int value : code) {
        int diff = n - value;
        if (diff < 0) continue;
        sum += method2(node, code, diff);
      }
      node[n - 1] = sum;
      return sum;
    }

    /**
     * 递归算法，超出时间限制 n = 44
     *
     * @param code
     * @param n
     * @return
     */
    private int method1(int[] code, int n) {
      if (n == 0) return 0;
      if (n == 1) return 1;
      if (n == 2) return 2;
      int sum = 0;
      for (int value : code) {
        int diff = n - value;
        if (diff < 0) continue;
        sum += method1(code, diff);
      }
      return sum;
    }

  }
}
