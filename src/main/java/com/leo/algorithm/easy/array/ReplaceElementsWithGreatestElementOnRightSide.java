// 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
//
// 完成所有替换操作后，请你返回这个数组。
//
//
//
// 示例：
//
//
// 输入：arr = [17,18,5,4,6,1]
// 输出：[18,6,6,6,1,-1]
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10^4
// 1 <= arr[i] <= 10^5
//
// Related Topics 数组
// 1299. 将每个元素替换为右侧最大元素

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ReplaceElementsWithGreatestElementOnRightSide {
  public static void main(String[] args) {
    Printer.printArray(new Solution().replaceElements(DataBuilder.buildIntArray("17,18,5,4,6,1")));
  }

  static class Solution {
    /**
     * 执行用时： 184 ms , 在所有 Java 提交中击败了 18.35% 的用户
     *
     * <p>内存消耗： 41.3 MB , 在所有 Java 提交中击败了 16.74% 的用户
     *
     * @param arr
     * @return
     */
    public int[] replaceElements(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
        arr[i] = selectMaxElement(arr, i + 1, arr.length);
      }
      return arr;
    }

    private int selectMaxElement(int[] arr, int start, int end) {
      if (start == end) return -1;
      int max = Integer.MIN_VALUE;
      for (int i = start; i < end; i++) {
        if (max < arr[i]) max = arr[i];
      }
      return max;
    }
  }
}
