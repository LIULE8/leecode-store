// 首先，给你一个初始数组 arr。然后，每天你都要根据前一天的数组生成一个新的数组。
//
// 第 i 天所生成的数组，是由你对第 i-1 天的数组进行如下操作所得的：
//
//
// 假如一个元素小于它的左右邻居，那么该元素自增 1。
// 假如一个元素大于它的左右邻居，那么该元素自减 1。
// 首、尾元素 永不 改变。
//
//
// 过些时日，你会发现数组将会不再发生变化，请返回最终所得到的数组。
//
//
//
// 示例 1：
//
// 输入：[6,2,3,4]
// 输出：[6,3,3,4]
// 解释：
// 第一天，数组从 [6,2,3,4] 变为 [6,3,3,4]。
// 无法再对该数组进行更多操作。
//
//
// 示例 2：
//
// 输入：[1,6,3,4,3,5]
// 输出：[1,4,4,4,4,5]
// 解释：
// 第一天，数组从 [1,6,3,4,3,5] 变为 [1,5,4,3,4,5]。
// 第二天，数组从 [1,5,4,3,4,5] 变为 [1,4,4,4,4,5]。
// 无法再对该数组进行更多操作。
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 100
// 1 <= arr[i] <= 100
//
// Related Topics 数组
// 1243. 数组变换

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class ArrayTransformation {
  public static void main(String[] args) {
    Printer.printIntegerList(new Solution().transformArray(DataBuilder.buildIntArray("6,2,3,4")));
    Printer.printIntegerList(
        new Solution().transformArray(DataBuilder.buildIntArray("1,6,3,4,3,5")));
    Printer.printIntegerList(
        new Solution()
            .transformArray(
                DataBuilder.buildIntArray(
                    "1,5,4,7,9,2,5,1,2,5,8,8,3,8,4,4,6,3"))); // 1,4,5,7,7,4,3,2,2,5,8,8,6,5,4,4,4,3
    Printer.printIntegerList(
        new Solution()
            .transformArray(DataBuilder.buildIntArray("2,1,2,1,1,2,2,1"))); // 2,2,1,1,1,2,2,1
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 94.12% 的用户
     *
     * <p>内存消耗： 37.7 MB , 在所有 Java 提交中击败了 94.44% 的用户
     *
     * @param arr
     * @return
     */
    public List<Integer> transformArray(int[] arr) {
      boolean flag = true;
      int[] a = new int[arr.length];
      while (flag) {
        flag = false;
        System.arraycopy(arr, 0, a, 0, arr.length);
        for (int i = 1; i < arr.length - 1; i++) {
          if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
            a[i]--;
            flag = true;
          } else if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
            a[i]++;
            flag = true;
          }
        }
        System.arraycopy(a, 0, arr, 0, arr.length);
      }
      List<Integer> list = new ArrayList<>();
      for (int i : arr) {
        list.add(i);
      }
      return list;
    }
  }
}
