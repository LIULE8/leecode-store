// 给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。
//
//
// 示例:
// 输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
// 输出: 2
// 解释:
// 这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
//
//
//
//
// 注意:
//
//
// 3 <= points.length <= 50.
// 不存在重复的点。
// -50 <= points[i][j] <= 50.
// 结果误差值在 10^-6 以内都认为是正确答案。
//
// Related Topics 数学
// 812. 最大三角形面积

package com.leo.algorithm.easy.math;

public class LargestTriangleArea {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 96.31% 的用户
     *
     * <p>内存消耗： 36.4 MB , 在所有 Java 提交中击败了 31.97% 的用户
     *
     * <p>枚举： 我们可以枚举每一个三角形，计算面积并找出最大的面积值。根据三角形的三个顶点计算出面积的方法有很多种：
     *
     * <p>鞋带公式，用于计算任意多边形的面积，可用于计算三角形的面积；
     *
     * <p>海伦公式，从三个顶点得到三边长，并使用海伦公式计算出面积；
     *
     * <p>三角形面积公式 S = 1/2 * a * b * sin(C)，首先得到两边的长度，通过叉积算出夹角的正弦值，并使用公式计算出面积。
     *
     * <p>下面的代码中使用的是鞋带公式计算三角形的面积。
     *
     * @param points
     * @return
     */
    public double largestTriangleArea(int[][] points) {
      double ans = 0;
      for (int i = 0; i < points.length; ++i)
        for (int j = i + 1; j < points.length; ++j)
          for (int k = j + 1; k < points.length; ++k)
            ans = Math.max(ans, area(points[i], points[j], points[k]));
      return ans;
    }

    public double area(int[] p, int[] q, int[] r) {
      return 0.5
          * Math.abs(
              p[0] * q[1] + q[0] * r[1] + r[0] * p[1] - p[1] * q[0] - q[1] * r[0] - r[1] * p[0]);
    }
  }
}
