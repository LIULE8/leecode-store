// 给你两个数组，arr1 和 arr2，
//
//
// arr2 中的元素各不相同
// arr2 中的每个元素都出现在 arr1 中
//
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
// 尾。
//
//
//
// 示例：
//
// 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
// 输出：[2,2,2,1,4,3,3,9,6,7,19]
//
//
//
//
// 提示：
//
//
// arr1.length, arr2.length <= 1000
// 0 <= arr1[i], arr2[i] <= 1000
// arr2 中的元素 arr2[i] 各不相同
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中
//
// Related Topics 排序 数组
// 1122. 数组的相对排序

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class RelativeSortArray {
  public static void main(String[] args) {
    Printer.printArray(
        new Solution()
            .relativeSortArray(
                DataBuilder.buildIntArray("2,3,1,3,2,4,6,7,9,2,19"),
                DataBuilder.buildIntArray("2,1,4,3,9,6")));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38 MB , 在所有 Java 提交中击败了 96.31% 的用户
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
      int k = 0;
      int[] nums = new int[1001], result = new int[arr1.length];
      for (int i : arr1) nums[i]++;
      for (int j : arr2) while (nums[j]-- > 0) result[k++] = j;
      for (int q = 0; q < nums.length; q++) while (nums[q]-- > 0) result[k++] = q;
      return result;
    }
  }
}
