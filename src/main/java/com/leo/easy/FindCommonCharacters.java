package com.leo.easy;

import com.leo.utils.DataBuilder;
import com.leo.utils.Printer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1002. 查找常用字符
 *
 * <p>给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4
 * 次，则需要在最终答案中包含该字符 3 次。
 *
 * <p>你可以按任意顺序返回答案。
 *
 * <p>
 *
 * <p>示例 1：
 *
 * <p>输入：["bella","label","roller"] 输出：["e","l","l"] 示例 2：
 *
 * <p>输入：["cool","lock","cook"] 输出：["c","o"]
 *
 * <p>提示：
 *
 * <p>1 <= A.length <= 100 1 <= A[i].length <= 100 A[i][j] 是小写字母
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindCommonCharacters {
  public static void main(String[] args) {
        String[] strings = DataBuilder.buildStringArray("bella", "label", "roller");
//    String[] strings = DataBuilder.buildStringArray("cool", "lock", "cook");
    List<String> list = new Solution().commonChars(strings);
    Printer.printList(list);
  }

  static class Solution {
    public List<String> commonChars(String[] A) {
      //      return method1(A);
      //      return method2(A);
      return method3(A);
    }

    private List<String> method3(String[] A) {
      int[] nums = new int[26];
      char[] chars = A[0].toCharArray();
      for (char ch : chars) {
        nums[ch - 'a']++;
      }
      for (int i = 1; i < A.length; i++) {
        int[] tempNum = new int[26];
        chars = A[i].toCharArray();
        for (char ch : chars) {
          tempNum[ch - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
          nums[j] = Math.min(nums[j], tempNum[j]);
        }
      }
      List<String> list = new ArrayList<>();
      for (int i = 0; i < nums.length; i++) {
        for(int j = 0; j < nums[i]; j++) {
          list.add(String.valueOf((char) (i + 'a')));
        }
      }
      return list;
    }

    private List<String> method2(String[] A) {
      int[][] nums = new int[A.length][26];
      for (int i = 0; i < A.length; i++) {
        char[] chars = A[i].toCharArray();
        for (char ch : chars) {
          nums[i][ch - 'a']++;
        }
      }
      for (int j = 0; j < 26; j++) {
        for (int i = 1; i < A.length; i++) {
          nums[0][j] = Math.min(nums[i][j], nums[0][j]);
        }
      }
      List<String> list = new ArrayList<>();
      for (int i = 0; i < nums[0].length; i++) {
        for (int j = 0; j < nums[0][i]; j++) {
          list.add(String.valueOf((char) (i + 'a')));
        }
      }
      return list;
    }

    private List<String> method1(String[] A) {
      Map<String, Integer> map = new HashMap<>();
      List<String> list = new ArrayList<>();
      if (A.length == 0) {
        return list;
      }
      for (char aChar : A[0].toCharArray()) {
        String key = String.valueOf(aChar);
        map.put(key, map.getOrDefault(key, 0) + 1);
      }
      Map<String, Integer> tempMap;
      for (int i = 1; i < A.length; i++) {
        tempMap = new HashMap<>();
        for (char aChar : A[i].toCharArray()) {
          String key = String.valueOf(aChar);
          if (map.containsKey(key)) {
            tempMap.put(key, tempMap.getOrDefault(key, 0) + 1);
          }
        }
        map.keySet().retainAll(tempMap.keySet());
        for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
          if (entry.getValue() < map.get(entry.getKey())) {
            map.put(entry.getKey(), entry.getValue());
          }
        }
      }
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        for (int i = 0; i < entry.getValue(); i++) {
          list.add(entry.getKey());
        }
      }
      return list;
    }
  }
}
