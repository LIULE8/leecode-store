// 假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
//
// 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。
//
// 示例 1:
//
// 输入:
// ["Shogun", "Tapioca Express", "Burger King", "KFC"]
// ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
// 输出: ["Shogun"]
// 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
//
//
// 示例 2:
//
// 输入:
// ["Shogun", "Tapioca Express", "Burger King", "KFC"]
// ["KFC", "Shogun", "Burger King"]
// 输出: ["Shogun"]
// 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
//
//
// 提示:
//
//
// 两个列表的长度范围都在 [1, 1000]内。
// 两个列表中的字符串的长度将在[1，30]的范围内。
// 下标从0开始，到列表的长度减1。
// 两个列表都没有重复的元素。
// 599. 两个列表的最小索引总和
// Related Topics 哈希表
// 👍 102 👎 0

package com.leo.algorithm.easy.hashtable;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.*;

public class MinimumIndexSumOfTwoLists {
  public static void main(String[] args) {
    Printer.printStringArray(
        new Solution()
            .findRestaurant(
                DataBuilder.buildStringArray("Shogun", "Tapioca Express", "Burger King", "KFC"),
                DataBuilder.buildStringArray(
                    "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun")));
    Printer.printStringArray(
        new Solution()
            .findRestaurant(
                DataBuilder.buildStringArray("Shogun", "Tapioca Express", "Burger King", "KFC"),
                DataBuilder.buildStringArray("KFC", "Shogun", "Burger King")));
  }

  static class Solution {
    /**
     * 执行用时： 16 ms , 在所有 Java 提交中击败了 32.32% 的用户
     *
     * <p>内存消耗： 39.5 MB , 在所有 Java 提交中击败了 5.00% 的用户
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
      Map<String, Integer> index1 = getMap(list1);
      Map<String, Integer> index2 = getMap(list2);
      Set<String> list = new HashSet<>();
      int min = getMinIndexAndBuildResult(Integer.MAX_VALUE, index1, index2, list);
      getMinIndexAndBuildResult(min, index1, index2, list);
      return list.toArray(new String[0]);
    }

    private int getMinIndexAndBuildResult(
        int min, Map<String, Integer> index1, Map<String, Integer> index2, Set<String> list) {
      for (Map.Entry<String, Integer> entry : index1.entrySet()) {
        if (index2.containsKey(entry.getKey())) {
          int i = index2.get(entry.getKey()) + entry.getValue();
          if (min > i) {
            list.clear();
            list.add(entry.getKey());
            min = i;
          } else if (min == i) {
            list.add(entry.getKey());
          }
        }
      }
      return min;
    }

    private Map<String, Integer> getMap(String[] list1) {
      Map<String, Integer> index = new HashMap<>();
      for (int i = 0; i < list1.length; i++) {
        index.put(list1[i], i);
      }
      return index;
    }
  }
}
