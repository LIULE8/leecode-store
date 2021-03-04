// 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
//
// 示例1:
//
//  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
// s = "ta"
// 输出：-1
// 说明: 不存在返回-1。
//
//
// 示例2:
//
//  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""],
// s = "ball"
// 输出：4
//
//
// 提示:
//
//
// words的长度在[1, 1000000]之间
//
// Related Topics 二分查找
// 面试题 10.05. 稀疏数组搜索

package com.leo.algorithm.easy.binarySearch;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class SparseArraySearchLcci {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        -1,
        new Solution()
            .findString(
                DataBuilder.buildStringArray(
                    "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""),
                "ta"));
    Printer.printCorrectAnswer(
        4,
        new Solution()
            .findString(
                DataBuilder.buildStringArray(
                    "at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""),
                "ball"));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 14.27% 的用户
     *
     * @param words
     * @param s
     * @return
     */
    public int findString(String[] words, String s) {
      int l = 0, r = words.length - 1;
      while (l <= r) {
        while (l < r && words[l].equals("")) l++;
        while (l < r && words[r].equals("")) r--;
        if (l <= r) {
          int mid = l + ((r - l) >> 1);
          while (mid < r && words[mid].equals("")) mid++;
          if (words[mid].compareTo(s) > 0) {
            r = mid - 1;
          } else if (words[mid].compareTo(s) < 0) {
            l = mid + 1;
          } else {
            return mid;
          }
        }
      }
      return -1;
    }
  }
}
