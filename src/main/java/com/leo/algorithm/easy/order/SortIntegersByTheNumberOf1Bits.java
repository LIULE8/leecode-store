// 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
//
// 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
//
// 请你返回排序后的数组。
//
//
//
// 示例 1：
//
// 输入：arr = [0,1,2,3,4,5,6,7,8]
// 输出：[0,1,2,4,8,3,5,6,7]
// 解释：[0] 是唯一一个有 0 个 1 的数。
// [1,2,4,8] 都有 1 个 1 。
// [3,5,6] 有 2 个 1 。
// [7] 有 3 个 1 。
// 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
//
//
// 示例 2：
//
// 输入：arr = [1024,512,256,128,64,32,16,8,4,2,1]
// 输出：[1,2,4,8,16,32,64,128,256,512,1024]
// 解释：数组中所有整数二进制下都只有 1 个 1 ，所以你需要按照数值大小将它们排序。
//
//
// 示例 3：
//
// 输入：arr = [10000,10000]
// 输出：[10000,10000]
//
//
// 示例 4：
//
// 输入：arr = [2,3,5,7,11,13,17,19]
// 输出：[2,3,5,17,7,11,13,19]
//
//
// 示例 5：
//
// 输入：arr = [10,100,1000,10000]
// 输出：[10,100,10000,1000]
//
//
//
//
// 提示：
//
//
// 1 <= arr.length <= 500
// 0 <= arr[i] <= 10^4
//
// Related Topics 排序 位运算
// 1356. 根据数字二进制下 1 的数目排序

package com.leo.algorithm.easy.order;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.*;

public class SortIntegersByTheNumberOf1Bits {
  public static void main(String[] args) {
    Printer.printArray(
        new Solution().sortByBits(DataBuilder.buildIntArray("1024,512,256,128,64,32,16,8,4,2,1")));
    Printer.printArray(new Solution().sortByBits(DataBuilder.buildIntArray("2,3,5,7,11,13,17,19")));

    Printer.printArray(new Solution().sortByBits(DataBuilder.buildIntArray("10000,10000")));
    Printer.printArray(new Solution().sortByBits(DataBuilder.buildIntArray("0,1,2,3,4,5,6,7,8")));
    Printer.printArray(new Solution().sortByBits(DataBuilder.buildIntArray("10,100,1000,10000")));
  }

  static class Solution {
    public int[] sortByBits(int[] arr) {
      //      return method1(arr);
      return method2(arr);
    }

    /**
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 50.65% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 43.41% 的用户
     *
     * @param arr
     * @return
     */
    private int[] method2(int[] arr) {
      List<Integer> list = new ArrayList<>(arr.length);
      int[] bit = new int[10001];
      for (int num : arr) {
        list.add(num);
        bit[num] = Integer.bitCount(num);
      }
      list.sort(
          (o1, o2) -> {
            if (bit[o1] != bit[o2]) {
              return bit[o1] - bit[o2];
            }
            return o1 - o2;
          });
      int[] res = new int[arr.length];
      for (int i = 0; i < list.size(); i++) {
        res[i] = list.get(i);
      }
      return res;
    }

    /**
     * 执行用时： 19 ms , 在所有 Java 提交中击败了 16.54% 的用户
     *
     * <p>内存消耗： 39.3 MB , 在所有 Java 提交中击败了 7.62% 的用户
     *
     * @param arr
     * @return
     */
    private int[] method1(int[] arr) {
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int i : arr) {
        int key = Integer.bitCount(i);
        if (map.containsKey(key)) {
          map.get(key).add(i);
        } else {
          List<Integer> list = new LinkedList<>();
          list.add(i);
          map.put(key, list);
        }
      }
      List<Integer> entries =
          quickSort(new ArrayList<>(map.keySet()), 0, map.entrySet().size() - 1);
      int[] res = new int[arr.length];
      int k = 0;
      for (Integer key : entries) {
        List<Integer> list = quickSort(map.get(key), 0, map.get(key).size() - 1);
        for (Integer value : list) {
          res[k++] = value;
        }
      }
      return res;
    }

    private List<Integer> quickSort(List<Integer> entries, int left, int right) {
      if (left < right) {
        int partitionIndex = partition(entries, left, right);
        quickSort(entries, left, partitionIndex - 1);
        quickSort(entries, partitionIndex + 1, right);
      }
      return entries;
    }

    private int partition(List<Integer> entries, int left, int right) {
      int index = left + 1;
      for (int i = index; i <= right; i++) {
        if (entries.get(i) < entries.get(left)) {
          swap(entries, i, index);
          index++;
        }
      }
      swap(entries, left, index - 1);
      return index - 1;
    }

    private void swap(List<Integer> entries, int i, int j) {
      Integer temp = entries.get(i);
      entries.set(i, entries.get(j));
      entries.set(j, temp);
    }
  }
}
