// 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
//
// 另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
//
// 如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
//
//
// ruleKey == "type" 且 ruleValue == typei 。
// ruleKey == "color" 且 ruleValue == colori 。
// ruleKey == "name" 且 ruleValue == namei 。
//
//
// 统计并返回 匹配检索规则的物品数量 。
//
//
//
// 示例 1：
//
//
// 输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","
// gold","iphone"]], ruleKey = "color", ruleValue = "silver"
// 输出：1
// 解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
//
//
// 示例 2：
//
//
// 输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","g
// old","iphone"]], ruleKey = "type", ruleValue = "phone"
// 输出：2
// 解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"]
// 。注意，["computer","silver","phone"] 未匹配检索规则。
//
//
//
// 提示：
//
//
// 1 <= items.length <= 104
// 1 <= typei.length, colori.length, namei.length, ruleValue.length <= 10
// ruleKey 等于 "type"、"color" 或 "name"
// 所有字符串仅由小写字母组成
//
// Related Topics 数组 字符串
// 1773. 统计匹配检索规则的物品数量

package com.leo.algorithm.easy.string;

import java.util.List;

public class CountItemsMatchingARule {
  public static void main(String[] args) {}

  static class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
      //      return method1(items, ruleKey, ruleValue);
      //      return method2(items, ruleKey, ruleValue);
      return method3(items, ruleKey, ruleValue);
    }

    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 97.96% 的用户
     *
     * <p>内存消耗： 43.2 MB , 在所有 Java 提交中击败了 54.62% 的用户
     *
     * @param items
     * @param ruleKey
     * @param ruleValue
     * @return
     */
    private int method3(List<List<String>> items, String ruleKey, String ruleValue) {
      int index = 0, count = 0;
      if (ruleKey.equals("color")) index = 1;
      else if (ruleKey.equals("name")) index = 2;
      for (List<String> item : items) {
        if (ruleValue.equals(item.get(index))) {
          count++;
        }
      }
      return count;
    }

    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 57.30% 的用户
     *
     * <p>内存消耗： 43 MB , 在所有 Java 提交中击败了 87.26% 的用户
     *
     * @param items
     * @param ruleKey
     * @param ruleValue
     * @return
     */
    private int method2(List<List<String>> items, String ruleKey, String ruleValue) {
      int count = 0, k = 0;
      switch (ruleKey) {
        case "type":
          while (k < items.size()) if (items.get(k++).get(0).equals(ruleValue)) count++;
          break;
        case "color":
          while (k < items.size()) if (items.get(k++).get(1).equals(ruleValue)) count++;
          break;
        case "name":
          while (k < items.size()) if (items.get(k++).get(2).equals(ruleValue)) count++;
          break;
      }
      return count;
    }

    /**
     * 执行用时： 9 ms , 在所有 Java 提交中击败了 9.36% 的用户
     *
     * <p>内存消耗： 43 MB , 在所有 Java 提交中击败了 79.63% 的用户
     *
     * @param items
     * @param ruleKey
     * @param ruleValue
     * @return
     */
    private int method1(List<List<String>> items, String ruleKey, String ruleValue) {
      int count = 0;
      for (List<String> item : items) {
        if (ruleKey.equals("type") && item.get(0).equals(ruleValue)) count++;
        else if (ruleKey.equals("color") && item.get(1).equals(ruleValue)) count++;
        else if (ruleKey.equals("name") && item.get(2).equals(ruleValue)) count++;
      }
      return count;
    }
  }
}
