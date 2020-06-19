package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 *
 * <p>给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * <p>在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * <p>示例:
 *
 * <p>输入: 5 输出: [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/pascals-triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PascalsTriangle {
  public static void main(String[] args) {
    List<List<Integer>> generate = new Solution().generate(5);
    Printer.printDoubleList(generate);
  }

  static class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> list = new ArrayList<>();
      for (int i = 0; i < numRows; i++) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        if (i != 0) {
          if (i != 1) {
            List<Integer> lastRow = list.get(i - 1);
            for (int j = 0; j < lastRow.size() - 1; j++) {
              row.add(lastRow.get(j) + lastRow.get(j + 1));
            }
          }
          row.add(1);
        }
        list.add(row);
      }
      return list;
    }
  }
}
