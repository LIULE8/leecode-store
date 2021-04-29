// 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
//
// 操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素
// M[i][j] 的值都增加 1。
//
// 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
//
// 示例 1:
//
//
// 输入:
// m = 3, n = 3
// operations = [[2,2],[3,3]]
// 输出: 4
// 解释:
// 初始状态, M =
// [[0, 0, 0],
// [0, 0, 0],
// [0, 0, 0]]
//
// 执行完操作 [2,2] 后, M =
// [[1, 1, 0],
// [1, 1, 0],
// [0, 0, 0]]
//
// 执行完操作 [3,3] 后, M =
// [[2, 2, 1],
// [2, 2, 1],
// [1, 1, 1]]
//
// M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
//
//
// 注意:
//
//
// m 和 n 的范围是 [1,40000]。
// a 的范围是 [1,m]，b 的范围是 [1,n]。
// 操作数目不超过 10000。
//
// Related Topics 数学
// 598. 范围求和 II

package com.leo.algorithm.easy.math;

import com.leo.algorithm.utils.DataBuilder;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class RangeAdditionIi {
  public static void main(String[] args) {
    int i = new Solution().maxCount(3, 3, DataBuilder.buildDoubleArray("[[2,2],[3,3]]"));
    System.out.println(i);
  }

  static class Solution {
    public int maxCount(int m, int n, int[][] ops) {
      //      return method1(m, n, ops);
      return method2(m, n, ops);
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 77.63% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 23.29% 的用户
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    private int method2(int m, int n, int[][] ops) {
      if (ops.length == 0) return m * n;
      int x = Integer.MAX_VALUE;
      int y = Integer.MAX_VALUE;
      for (int[] op : ops) {
        x = Math.min(x, op[0]);
        y = Math.min(y, op[1]);
      }
      return x * y;
    }

    /**
     * 超出内存限制
     *
     * @param m
     * @param n
     * @param ops
     * @return
     */
    private Integer method1(int m, int n, int[][] ops) {
      int[][] nums = new int[m][n];
      for (int[] op : ops) {
        for (int i = 0; i < op[0]; i++) {
          for (int j = 0; j < op[1]; j++) {
            nums[i][j]++;
          }
        }
      }
      Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
      for (int[] num : nums) {
        for (int i : num) {
          map.put(i, map.getOrDefault(i, 0) + 1);
        }
      }
      return map.entrySet().iterator().next().getValue();
    }
  }
}
