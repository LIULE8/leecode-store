// 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
//
//
//
// 示例：
//
// 输入："Let's take LeetCode contest"
// 输出："s'teL ekat edoCteeL tsetnoc"
//
//
//
//
// 提示：
//
//
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
//
// Related Topics 双指针 字符串
// 557. 反转字符串中的单词 III

package com.leo.algorithm.plan.introduction.t04;

public class ReverseWordsInAStringIii {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 4 ms , 在所有 Java 提交中击败了 89.40% 的用户
     *
     * <p>内存消耗： 38.9 MB , 在所有 Java 提交中击败了 71.84% 的用户
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
      if (s == null || s.length() == 0) return s;
      StringBuilder sb = new StringBuilder();
      StringBuilder temp = new StringBuilder();
      for (String word : s.split(" ")) {
        sb.append(temp.append(word).reverse()).append(" ");
        temp.setLength(0);
      }
      sb.setLength(sb.length() - 1);
      return sb.toString();
    }
  }
}
