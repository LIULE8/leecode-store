// 给你一个字符串 path，其中 path[i] 的值可以是 'N'、'S'、'E' 或者 'W'，分别表示向北、向南、向东、向西移动一个单位。
//
// 机器人从二维平面上的原点 (0, 0) 处开始出发，按 path 所指示的路径行走。
//
// 如果路径在任何位置上出现相交的情况，也就是走到之前已经走过的位置，请返回 True ；否则，返回 False 。
//
//
//
// 示例 1：
//
//
//
// 输入：path = "NES"
// 输出：false
// 解释：该路径没有在任何位置相交。
//
// 示例 2：
//
//
//
// 输入：path = "NESWW"
// 输出：true
// 解释：该路径经过原点两次。
//
//
//
// 提示：
//
//
// 1 <= path.length <= 10^4
// path 仅由 {'N', 'S', 'E', 'W} 中的字符组成
//
// Related Topics 字符串
// 1496. 判断路径是否相交

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(false, new Solution().isPathCrossing("NES"));
    Printer.printCorrectAnswer(true, new Solution().isPathCrossing("NESWW"));
    Printer.printCorrectAnswer(true, new Solution().isPathCrossing("NNSWWEWSSESSWENNW"));
  }

  static class Solution {
    /**
     * 执行用时： 5 ms , 在所有 Java 提交中击败了 42.49% 的用户
     *
     * <p>内存消耗： 38.2 MB , 在所有 Java 提交中击败了 43.35% 的用户
     *
     * @param path
     * @return
     */
    public boolean isPathCrossing(String path) {
      int x = 0, y = 0;
      Set<String> points = new HashSet<>();
      String point = x + "" + y;
      points.add(point);
      for (char c : path.toCharArray()) {
        if (c == 'N') x++;
        else if (c == 'S') x--;
        else if (c == 'W') y += 2;
        else if (c == 'E') y -= 2;
        point = x + "" + y;
        if (points.contains(point)) return true;
        points.add(point);
      }
      return false;
    }
  }
}
