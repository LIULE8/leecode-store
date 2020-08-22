package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.*;

// 给你一个不同学生的分数列表，请按 学生的 id 顺序 返回每个学生 最高的五科 成绩的 平均分。
//
// 对于每条 items[i] 记录， items[i][0] 为学生的 id，items[i][1] 为学生的分数。平均分请采用整数除法计算。
//
//
//
// 示例：
//
// 输入：[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
// 输出：[[1,87],[2,88]]
// 解释：
// id = 1 的学生平均分为 87。
// id = 2 的学生平均分为 88.6。但由于整数除法的缘故，平均分会被转换为 88。
//
//
// 提示：
//
// 1 <= items.length <= 1000
// items[i].length == 2
// 学生的 ID 在 1 到 1000 之间
// 学生的分数在 1 到 100 之间
// 每个学生至少有五个分数
//
// 1086. 前五科的均分
public class AverageScoreOfTheFirstFiveSubjects {
  public static void main(String[] args) {
    Printer.printDoubleArray(
        new Solution()
            .highFive(
                DataBuilder.buildDoubleArray(
                    "[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]")));
  }

  static class Solution {
    /**
     * 执行用时： 7 ms , 在所有 Java 提交中击败了 40.00% 的用户
     *
     * <p>内存消耗： 40.6 MB , 在所有 Java 提交中击败了 13.64% 的用户
     *
     * @param items
     * @return
     */
    public int[][] highFive(int[][] items) {
      Map<Integer, List<Integer>> map = new HashMap<>();
      for (int[] item : items) {
        List<Integer> list = map.getOrDefault(item[0], new ArrayList<>());
        list.add(item[1]);
        map.put(item[0], list);
      }
      Set<Integer> ids = map.keySet();
      int[][] result = new int[ids.size()][2];
      int k = 0;
      for (Integer id : ids) {
        List<Integer> scores = map.get(id);
        scores.sort(Comparator.reverseOrder());
        result[k++] =
            new int[] {
              id,
              (scores.get(0) + scores.get(1) + scores.get(2) + scores.get(3) + scores.get(4)) / 5
            };
      }
      return result;
    }
  }
}
