// 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。
//
// 示例:
//
// 输入:
// A = [1,2,3,0,0,0], m = 3
// B = [2,5,6],       n = 3
//
// 输出: [1,2,2,3,5,6]
//
// 说明:
//
//
// A.length == n + m
//
// Related Topics 数组 双指针
// 面试题 10.01. 合并排序的数组

package com.leo.algorithm.easy.array;

import java.util.Arrays;

public class SortedMergeLcci {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
      //      method1(A, m, B, n);
      method2(A, m, B, n);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.8 MB , 在所有 Java 提交中击败了 59.82% 的用户
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    private void method2(int[] A, int m, int[] B, int n) {
      int[] C = new int[m + n];
      int k = 0, i = 0, j = 0;
      while (j < n && i < m) {
        if (A[i] <= B[j]) C[k++] = A[i++];
        else C[k++] = B[j++];
      }
      if (i < m) {
        for (int l = i; l < m; l++) {
          C[k++] = A[l];
        }
      } else if (j < n) {
        for (int l = j; l < n; l++) {
          C[k++] = B[l];
        }
      }

      System.arraycopy(C, 0, A, 0, m + n);
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 25.90% 的用户
     *
     * <p>内存消耗： 40.1 MB , 在所有 Java 提交中击败了 10.31% 的用户
     *
     * @param A
     * @param m
     * @param B
     * @param n
     */
    private void method1(int[] A, int m, int[] B, int n) {
      for (int i = m, k = 0; i < n + m; i++, k++) {
        A[i] = B[k];
      }
      Arrays.sort(A);
    }
  }
}
