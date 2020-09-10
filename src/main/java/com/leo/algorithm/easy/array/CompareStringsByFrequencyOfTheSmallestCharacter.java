// 我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s 中（按字典序比较）最小字母的出现频次。
//
// 例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
//
// 现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足
// f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
//
//
//
// 示例 1：
//
// 输入：queries = ["cbd"], words = ["zaaaz"]
// 输出：[1]
// 解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
//
//
// 示例 2：
//
// 输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
// 输出：[1,2]
// 解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
//
//
//
//
// 提示：
//
//
// 1 <= queries.length <= 2000
// 1 <= words.length <= 2000
// 1 <= queries[i].length, words[i].length <= 10
// queries[i][j], words[i][j] 都是小写英文字母
//
// Related Topics 数组 字符串
// 1170. 比较字符串最小字母出现频次

package com.leo.algorithm.easy.array;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.Arrays;

public class CompareStringsByFrequencyOfTheSmallestCharacter {
  public static void main(String[] args) {
    Printer.printArray(
        new Solution()
            .numSmallerByFrequency(
                DataBuilder.buildStringArray("cbd"), DataBuilder.buildStringArray("zaaaz")));
    Printer.printArray(
        new Solution()
            .numSmallerByFrequency(
                DataBuilder.buildStringArray("bbb", "cc"),
                DataBuilder.buildStringArray("a", "aa", "aaa", "aaaa")));
  }

  static class Solution {
    /**
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 54.71% 的用户
     *
     * <p>内存消耗： 39.7 MB , 在所有 Java 提交中击败了 91.81% 的用户
     *
     * @param queries
     * @param words
     * @return
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
      int[] res = new int[queries.length];
      int[] fw = new int[words.length];
      for (int i = 0; i < words.length; i++) {
        fw[i] = getFrequency(words[i]);
      }
      Arrays.sort(fw);
      for (int i = 0, k = 0; i < queries.length; i++) {
        int frequency = getFrequency(queries[i]);
        res[k++] = getCount(fw, frequency);
      }
      return res;
    }

    private int getCount(int[] fw, int frequency) {
      int count = 0;
      for (int j : fw) {
        if (frequency < j) count++;
      }
      return count;
    }

    private int getFrequency(String word) {
      char[] chars = word.toCharArray();
      Arrays.sort(chars);
      int count = 1;
      for (int i = 1; i < chars.length; i++) {
        if (chars[i - 1] == chars[i]) count++;
        else break;
      }
      return count;
    }
  }
}
