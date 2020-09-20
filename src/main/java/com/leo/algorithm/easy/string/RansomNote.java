// 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
// 的字符构成。如果可以构成，返回 true ；否则返回 false。
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
//
//
//
// 注意：
//
// 你可以假设两个字符串均只含有小写字母。
//
// canConstruct("a", "b") -> false
// canConstruct("aa", "ab") -> false
// canConstruct("aa", "aab") -> true
//
// Related Topics 字符串
// 383. 赎金信

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(false, new Solution().canConstruct("a", "b"));
    Printer.printCorrectAnswer(false, new Solution().canConstruct("aa", "ab"));
    Printer.printCorrectAnswer(true, new Solution().canConstruct("aa", "aab"));
    Printer.printCorrectAnswer(true, new Solution().canConstruct("aab", "baa"));
  }

  static class Solution {
    /**
     * 执行用时： 17 ms , 在所有 Java 提交中击败了 22.88% 的用户
     *
     * <p>内存消耗： 39.5 MB , 在所有 Java 提交中击败了 17.27% 的用户
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
      if (magazine.contains(ransomNote)) return true;
      Map<Character, Integer> ranMap = buildMap(ransomNote);
      Map<Character, Integer> magaMap = buildMap(magazine);
      if (!magaMap.keySet().containsAll(ranMap.keySet())) return false;
      for (Map.Entry<Character, Integer> entry : ranMap.entrySet()) {
        if (magaMap.get(entry.getKey()) < entry.getValue()) return false;
      }
      return true;
    }

    private Map<Character, Integer> buildMap(String ransomNote) {
      Map<Character, Integer> map = new HashMap<>();
      for (int i = 0; i < ransomNote.length(); i++) {
        map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
      }
      return map;
    }
  }
}
