// 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
//
// 注意：请不要在超过该数组长度的位置写入元素。
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
//
//
//
// 示例 1：
//
// 输入：[1,0,2,3,0,4,5,0]
// 输出：null
// 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
//
//
// 示例 2：
//
// 输入：[1,2,3]
// 输出：null
// 解释：调用函数后，输入的数组将被修改为：[1,2,3]
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 10000
// 0 <= arr[i] <= 9
//
// Related Topics 数组
// 1089. 复写零

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class DuplicateZeros {
  public static void main(String[] args) {
    int[] arr = DataBuilder.buildIntArray("1,0,2,3,0,4,5,0");
    new Solution().duplicateZeros(arr);
    Printer.printArray(arr);
    arr = DataBuilder.buildIntArray("1,2,3");
    new Solution().duplicateZeros(arr);
    Printer.printArray(arr);
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.36% 的用户
     *
     * <p>内存消耗： 40.7 MB , 在所有 Java 提交中击败了 6.96% 的用户
     *
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
      int[] clone = new int[arr.length << 1];
      int k = 0;
      for (int num : arr) {
        clone[k++] = num;
        if (num == 0) clone[k++] = num;
      }
      System.arraycopy(clone, 0, arr, 0, arr.length);
    }
  }
}
