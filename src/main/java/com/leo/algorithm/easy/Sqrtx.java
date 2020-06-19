package com.leo.algorithm.easy;

/**
 * 69. x 的平方根
 *
 * <p>实现 int sqrt(int x) 函数。
 *
 * <p>计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * <p>由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * <p>示例 1:
 *
 * <p>输入: 4 输出: 2 示例 2:
 *
 * <p>输入: 8 输出: 2 说明: 8 的平方根是 2.82842...,   由于返回类型是整数，小数部分将被舍去。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/sqrtx 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sqrtx {
  public static void main(String[] args) {
    int i = new Solution().mySqrt(2147483647); // 46340
    //    int i = new Solution().mySqrt(8);
    System.out.println(i);
  }

  static class Solution {
    public int mySqrt(int x) {
      //      return method1(x);
      return method2(x);
      //      return method3(x);
    }

    /**
     * 二分查找法, 一个数a的平方根一定比它的一半的平方要小或等于, (a/2)^2 >= a
     *
     * @param x
     * @return
     */
    private int method3(int x) {
      if (x == 0) return 0;
      long l = 1;
      long r = x >> 1;
      while (l < r) {
        long mid = (l + r + 1) >> 1;
        long a = mid * mid;
        if (a > x) {
          r = mid - 1;
        } else {
          l = mid;
        }
      }
      return (int) l;
    }
    /**
     * 牛顿迭代法，可以用切线近似预测曲线的值
     *
     * <p>假设n=x 2 ，现在求n的方根，即x 2 −n=0，把他转换为f(x)=x 2 −n，如上图所示 选取x 0 ​ 作为求解方根的初始近似值，过点(x 0 ​ ,f(x 0 ​
     * ))作切线T，T的方程为 y=f(x 0 ​ )+f ′ (x 0 ​ )(x−x 0 ​ ) 求出T与x轴交点的横坐标x 1 ​ =x 0 ​ − f ′ (x 0 ​ ) f(x 0
     * ​ ) ​ ，称x 1 ​ 为n方根的一次近似值 过点(x 1 ​ ,f(x 1 ​ ))再作切线，并求得该切线与x轴交点的横坐标：x 2 ​ =x 1 ​ − f ′ (x 1 ​ )
     * f(x 1 ​ ) ​
     *
     * <p>称x 2 ​ 为n方根的二次近似值。以此类推，得到牛顿法的迭代公式：x n+1 ​ =x n ​ − f ′ (x n ​ ) f(x n ​ ) ​
     *
     * <p>（注：f ′ (x n ​ )是导数，这里也就是切线的斜率，数值是2∗x n ​
     *
     * @param x
     * @return
     */
    private int method2(int x) {
      if (x <= 1) return x;
      long r = x; // 在f(x)中随便找一个点r
      long a = x / r;
      while (r - a > 0) {
        r = (r + a) / 2; //
        a = x / r;
      }
      return (int) r;
    }

    /**
     * 执行用时 : 26 ms , 在所有 java 提交中击败了 7.09% 的用户
     *
     * <p>内存消耗 : 34 MB , 在所有 java 提交中击败了 75.02% 的用户
     *
     * @param x
     * @return
     */
    private int method1(int x) {
      if (x == 0) return 0;
      long length = (x >> 1) + 1;
      int product = 1;
      for (int i = 1; i <= length; i++) {
        if (product == x) {
          return i;
        }
        product = (i + 1) * (i + 1);
        if (product > x || product < 0) {
          return i;
        } else if (product == x) {
          return i + 1;
        }
      }
      return -1;
    }
  }
}
