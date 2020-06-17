// 编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
// 输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
// 输出: ""
// 解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串

package com.leo.easy.string;

import com.leo.utils.DataBuilder;

public class LongestCommonPrefix {
  public static void main(String[] args) {
    System.out.println(
        new Solution()
            .longestCommonPrefix(DataBuilder.buildStringArray("flower", "flow", "flight"))); // "fl"
    System.out.println(
        new Solution()
            .longestCommonPrefix(DataBuilder.buildStringArray("dog", "racecar", "car"))); // ""
    System.out.println(
        new Solution().longestCommonPrefix(DataBuilder.buildStringArray("aa", "a"))); // "a"
  }

  static class Solution {
    public String longestCommonPrefix(String[] strs) {
      return method1(strs);
    }

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 33.76% 的用户
     *
     * <p>内存消耗 : 37.5 MB , 在所有 Java 提交中击败了 45.00% 的用户
     *
     * @param strs
     * @return
     */
    private String method1(String[] strs) {
      if (strs == null || strs.length == 0) {
        return "";
      }
      StringBuilder sb = new StringBuilder();
      String str = strs[0];
      outer:
      for (int i = 0; i < str.length(); i++) {
        for (int j = 1; j < strs.length; j++) {
          if (i >= strs[j].length() || str.charAt(i) != strs[j].charAt(i)) {
            break outer;
          }
        }
        sb.append(str.charAt(i));
      }
      return sb.toString();
    }
  }
}
