// 给出一个整数数组 A 和一个查询数组 queries。
//
// 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上
// 。然后，第 i 次查询的答案是 A 中偶数值的和。
//
// （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
//
// 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
//
//
//
// 示例：
//
// 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
// 输出：[8,6,2,4]
// 解释：
// 开始时，数组为 [1,2,3,4]。
// 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
// 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
// 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
// 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 10000
// -10000 <= A[i] <= 10000
// 1 <= queries.length <= 10000
// -10000 <= queries[i][0] <= 10000
// 0 <= queries[i][1] < A.length
//
// Related Topics 数组
// 985. 查询后的偶数和

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class SumOfEvenNumbersAfterQueries {
  public static void main(String[] args) {
    Printer.printArray(
        new Solution()
            .sumEvenAfterQueries(
                DataBuilder.buildIntArray("1,2,3,4"),
                DataBuilder.buildDoubleArray("[[1,0],[-3,1],[-4,0],[2,3]]")));
    Printer.printArray(
        new Solution()
            .sumEvenAfterQueries(
                DataBuilder.buildIntArray("-10,2,-4,5,-3,3"),
                DataBuilder.buildDoubleArray(
                    "[[-4,2], [9,0], [-8,1], [5,4], [1,4], [9,0]]"))); // [-16,-6,-14,-12,-14,-6]
  }

  static class Solution {
    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 38.71% 的用户
     *
     * <p>内存消耗： 48.3 MB , 在所有 Java 提交中击败了 37.50% 的用户
     *
     * @param A
     * @param queries
     * @return
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
      int sum = 0;
      for (int j : A) {
        if (j % 2 == 0) sum += j;
      }
      int[] res = new int[queries.length];
      for (int i = 0; i < queries.length; i++) {
        int s = A[queries[i][1]] + queries[i][0];
        if (Math.abs(A[queries[i][1]] % 2) == 1) {
          if (s % 2 == 0) sum += s;
        } else {
          if (s % 2 == 0) sum += queries[i][0];
          else sum -= A[queries[i][1]];
        }
        A[queries[i][1]] = s;
        res[i] = sum;
      }
      return res;
    }
  }
}
