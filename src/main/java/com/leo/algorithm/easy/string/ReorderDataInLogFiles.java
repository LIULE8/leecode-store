// 你有一个日志数组 logs。每条日志都是以空格分隔的字串。
//
// 对于每条日志，其第一个字为字母与数字混合的 标识符 ，除标识符之外的所有字为这一条日志的 内容 。
//
//
// 除标识符之外，所有字均由小写字母组成的，称为 字母日志
// 除标识符之外，所有字均由数字组成的，称为 数字日志
//
//
// 题目所用数据保证每个日志在其标识符后面至少有一个字。
//
// 请按下述规则将日志重新排序：
//
//
// 所有 字母日志 都排在 数字日志 之前。
// 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序；
// 数字日志 应该按原来的顺序排列。
//
//
// 返回日志的最终顺序。
//
//
//
// 示例 ：
//
// 输入：["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
// 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
//
//
//
//
// 提示：
//
//
// 0 <= logs.length <= 100
// 3 <= logs[i].length <= 100
// logs[i] 保证有一个标识符，并且标识符后面有一个字。
//
// Related Topics 字符串
// 937. 重新排列日志文件

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class ReorderDataInLogFiles {
  public static void main(String[] args) {
    Printer.printStringArray(
        new Solution()
            .reorderLogFiles(
                DataBuilder.buildStringArray(
                    "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo")));
  }

  static class Solution {
    /**
     * 执行用时： 8 ms , 在所有 Java 提交中击败了 56.14% 的用户
     *
     * <p>内存消耗： 39 MB , 在所有 Java 提交中击败了 81.78% 的用户
     *
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
      Arrays.sort(
          logs,
          (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            // 都是字母
            if (!isDigit1 && !isDigit2) {
              int com = split1[1].compareTo(split2[1]);
              if (com != 0) return com;
              return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
          });
      return logs;
    }
  }
}