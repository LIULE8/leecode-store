// 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityA
// i 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
//
// 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
//
//
//
// 示例 1：
//
// 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
// 输出："Sao Paulo"
// 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima
// " -> "Sao Paulo" 。
//
//
// 示例 2：
//
// 输入：paths = [["B","C"],["D","B"],["C","A"]]
// 输出："A"
// 解释：所有可能的线路是：
// "D" -> "B" -> "C" -> "A".
// "B" -> "C" -> "A".
// "C" -> "A".
// "A".
// 显然，旅行终点站是 "A" 。
//
//
// 示例 3：
//
// 输入：paths = [["A","Z"]]
// 输出："Z"
//
//
//
//
// 提示：
//
//
// 1 <= paths.length <= 100
// paths[i].length == 2
// 1 <= cityAi.length, cityBi.length <= 10
// cityAi != cityBi
// 所有字符串均由大小写英文字母和空格字符组成。
//
// Related Topics 字符串
// 1436. 旅行终点站

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "Sao Paulo",
        new Solution()
            .destCity(
                DataBuilder.buildDoubleStringList(
                    "[[\"London\",\"New York\"],[\"New York\",\"Lima\"],[\"Lima\",\"Sao Paulo\"]]")));
    Printer.printCorrectAnswer(
        "A",
        new Solution()
            .destCity(
                DataBuilder.buildDoubleStringList("[[\"B\",\"C\"],[\"D\",\"B\"],[\"C\",\"A\"]]")));
  }

  static class Solution {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 62.44% 的用户
     *
     * <p>内存消耗： 38.4 MB , 在所有 Java 提交中击败了 73.94% 的用户
     *
     * @param paths
     * @return
     */
    public String destCity(List<List<String>> paths) {
      Set<String> lset = new HashSet<>();
      Set<String> rset = new HashSet<>();
      for (List<String> path : paths) {
        lset.add(path.get(0));
        rset.add(path.get(1));
      }
      String result = "";
      for (String s : rset) {
        if (!lset.contains(s)) {
          result = s;
          break;
        }
      }
      return result;
    }
  }
}
