// 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//
//
//
// 示例 1：
//
// 输入：arr = [3,2,1], k = 2
// 输出：[1,2] 或者 [2,1]
//
//
// 示例 2：
//
// 输入：arr = [0,1,2,1], k = 1
// 输出：[0]
//
//
//
// 限制：
//
//
// 0 <= k <= arr.length <= 10000
// 0 <= arr[i] <= 10000
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列）
// 剑指 Offer 40. 最小的k个数

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.PriorityQueue;

public class ZuiXiaoDeKgeShuLcof {
  public static void main(String[] args) {
    //    int[] leastNumbers = new Solution().getLeastNumbers(DataBuilder.buildIntArray("0,1,2,1"),
    // 1);
    //    int[] leastNumbers =
    //        new Solution().getLeastNumbers(DataBuilder.buildIntArray("0,0,2,3,2,1,1,2,0,4"), 10);
    //    int[] leastNumbers =
    //        new Solution()
    //            .getLeastNumbers(
    //                DataBuilder.buildIntArray(
    //
    // "0,1,2,2,2,1,3,6,3,1,8,2,5,3,11,4,11,12,6,2,7,19,20,16,23,6,23,4,3,25,19,15,15,17,26,30,24,31,2,26,32,6,27,21,3,6,18,46,14,13,43,19,17,50,46,40,13,2,10,43,6,5,8,23,41,21,58,10,28,22,25,63,7,40,64,50,7,57,61,43,45,64,78,50,49,15,45,10,27,66,14,68,81,48,51,33,17,35,71,31"),
    //                24);
    int[] leastNumbers =
        new Solution().getLeastNumbers(DataBuilder.buildIntArray("0,0,0,2,0,5"), 0);
    Printer.printArray(leastNumbers);
  }

  static class Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
      //      return method1(arr, k);
      return method2(arr, k);
    }

    /**
     * 执行用时： 17 ms , 在所有 Java 提交中击败了 32.16% 的用户
     *
     * <p>内存消耗： 39.6 MB , 在所有 Java 提交中击败了 77.69% 的用户
     *
     * @param arr
     * @param k
     * @return
     */
    private int[] method2(int[] arr, int k) {
      int[] res = new int[k];
      if (k == 0) return res;
      // 大根堆
      PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
      for (int num : arr) {
        if (heap.size() < k) {
          heap.offer(num);
        } else if (heap.peek() > num) {
          heap.poll();
          heap.offer(num);
        }
      }
      for (int i = 0; i < k; i++) {
        res[i] = heap.poll();
      }
      return res;
    }

    /**
     * 执行用时： 483 ms , 在所有 Java 提交中击败了 5.01% 的用户
     *
     * <p>内存消耗： 39.6 MB , 在所有 Java 提交中击败了 77.45% 的用户
     *
     * @param arr
     * @param k
     * @return
     */
    private int[] method1(int[] arr, int k) {
      if (arr == null || arr.length == 0) return arr;
      int[] res = new int[k];
      for (int i = 0, h = 0; i < k; i++, h++) {
        for (int j = 0; j < arr.length - 1 - i; j++) {
          if (arr[j] < arr[j + 1]) {
            int temp = arr[j + 1];
            arr[j + 1] = arr[j];
            arr[j] = temp;
          }
        }
        res[h] = arr[arr.length - h - 1];
      }
      return res;
    }
  }
}
