// 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
//
// 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
//
//
//
// 示例 1：
//
// 输入：[[1,1],[2,3],[3,2]]
// 输出：true
//
//
// 示例 2：
//
// 输入：[[1,1],[2,2],[3,3]]
// 输出：false
//
//
//
// 提示：
//
//
// points.length == 3
// points[i].length == 2
// 0 <= points[i][j] <= 100
//
// Related Topics 数学
// 1037. 有效的回旋镖

package com.leo.algorithm.easy.math;

public class ValidBoomerang {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36 MB , 在所有 Java 提交中击败了 29.32% 的用户
     *
     * <p>枚举： 我们可以枚举每一个三角形，计算面积并找出最大的面积值。根据三角形的三个顶点计算出面积的方法有很多种：
     *
     * <p>鞋带公式，用于计算任意多边形的面积，可用于计算三角形的面积；
     *
     * <p>海伦公式，从三个顶点得到三边长，并使用海伦公式计算出面积；
     *
     * <p>三角形面积公式 S = 1/2 * a * b * sin(C)，首先得到两边的长度，通过叉积算出夹角的正弦值，并使用公式计算出面积。
     *
     * @param points
     * @return
     */
    public boolean isBoomerang(int[][] points) {
      return area(points[0], points[1], points[2]) != 0;
    }

    public double area(int[] p, int[] q, int[] r) {
      return 0.5
          * Math.abs(
              p[0] * q[1] + q[0] * r[1] + r[0] * p[1] - p[1] * q[0] - q[1] * r[0] - r[1] * p[0]);
    }
  }
}
