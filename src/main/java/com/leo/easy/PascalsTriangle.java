package com.leo.easy;

import com.leo.utils.Printer;

import java.util.ArrayList;
import java.util.List;

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
