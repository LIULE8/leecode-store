// A 和 B 在一个 3 x 3 的网格上玩井字棋。
//
// 井字棋游戏的规则如下：
//
//
// 玩家轮流将棋子放在空方格 (" ") 上。
// 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
// "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
// 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
// 如果所有方块都放满棋子（不为空），游戏也会结束。
// 游戏结束后，棋子无法再进行任何移动。
//
//
// 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各
// 自的棋子位置。
//
// 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"
// 。
//
// 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
//
//
//
// 示例 1：
//
// 输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
// 输出："A"
// 解释："A" 获胜，他总是先走。
// "X  "    "X  "    "X  "    "X  "    "X  "
// "   " -> "   " -> " X " -> " X " -> " X "
// "   "    "O  "    "O  "    "OO "    "OOX"
//
//
// 示例 2：
//
// 输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
// 输出："B"
// 解释："B" 获胜。
// "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
// "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
// "   "    "   "    "   "    "   "    "   "    "O  "
//
//
// 示例 3：
//
// 输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
// 输出："Draw"
// 输出：由于没有办法再行动，游戏以平局结束。
// "XXO"
// "OOX"
// "XOX"
//
//
// 示例 4：
//
// 输入：moves = [[0,0],[1,1]]
// 输出："Pending"
// 解释：游戏还没有结束。
// "X  "
// " O "
// "   "
//
//
//
//
// 提示：
//
//
// 1 <= moves.length <= 9
// moves[i].length == 2
// 0 <= moves[i][j] <= 2
// moves 里没有重复的元素。
// moves 遵循井字棋的规则。
//
// Related Topics 数组
// 1275. 找出井字棋的获胜者

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class FindWinnerOnATicTacToeGame {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        "A",
        new Solution().tictactoe(DataBuilder.buildDoubleArray("[[0,0],[2,0],[1,1],[2,1],[2,2]]")));
    Printer.printCorrectAnswer(
        "B",
        new Solution()
            .tictactoe(DataBuilder.buildDoubleArray("[[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]")));
    Printer.printCorrectAnswer(
        "Draw",
        new Solution()
            .tictactoe(
                DataBuilder.buildDoubleArray(
                    "[[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]")));
    Printer.printCorrectAnswer(
        "Pending", new Solution().tictactoe(DataBuilder.buildDoubleArray("[[0,0],[1,1]]")));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.5 MB , 在所有 Java 提交中击败了 47.14% 的用户
     *
     * @param moves
     * @return
     */
    public String tictactoe(int[][] moves) {
      String[][] a = new String[3][3];
      for (int i = 0; i < moves.length; i++) {
        a[moves[i][0]][moves[i][1]] = i % 2 == 0 ? "A" : "B";
      }
      String result =
          isTictactoe(
              a[0][0], a[0][1], a[0][2], a[1][0], a[1][1], a[1][2], a[2][0], a[2][1], a[2][2]);
      if (result.equals("C")) {
        return moves.length == 9 ? "Draw" : "Pending";
      }
      return result;
    }

    private String isTictactoe(String... a) {
      if (isEqual(a[0], a[1]) && isEqual(a[1], a[2])
          || isEqual(a[0], a[3]) && isEqual(a[3], a[6])
          || isEqual(a[0], a[4]) && isEqual(a[4], a[8])) {
        return a[0];
      } else if (isEqual(a[3], a[4]) && isEqual(a[4], a[5])
          || isEqual(a[1], a[4]) && isEqual(a[4], a[7])
          || isEqual(a[2], a[4]) && isEqual(a[4], a[6])) {
        return a[4];
      } else if (isEqual(a[6], a[7]) && isEqual(a[7], a[8])
          || isEqual(a[2], a[5]) && isEqual(a[5], a[8])) {
        return a[8];
      }
      return "C";
    }

    private boolean isEqual(CharSequence cs1, CharSequence cs2) {
      if (cs1 == null && cs2 == null) return false;
      else if (cs1 != null && cs2 != null) {
        if (cs1.length() != cs2.length()) {
          return false;
        } else if (cs1 instanceof String && cs2 instanceof String) {
          return cs1.equals(cs2);
        } else {
          int length = cs1.length();
          for (int i = 0; i < length; ++i) {
            if (cs1.charAt(i) != cs2.charAt(i)) {
              return false;
            }
          }
          return true;
        }
      } else {
        return false;
      }
    }
  }
}
