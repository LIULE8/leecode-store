// 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c
// " 对应 "-.-.", 等等。
//
// 为了方便，所有26个英文字母对应摩尔斯密码表如下：
//
// [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","-
// -","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--
// .."]
//
// 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" +
// "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。
//
// 返回我们可以获得所有词不同单词翻译的数量。
//
// 例如:
// 输入: words = ["gin", "zen", "gig", "msg"]
// 输出: 2
// 解释:
// 各单词翻译如下:
// "gin" -> "--...-."
// "zen" -> "--...-."
// "gig" -> "--...--."
// "msg" -> "--...--."
//
// 共有 2 种不同翻译, "--...-." 和 "--...--.".
//
//
//
//
// 注意:
//
//
// 单词列表words 的长度不会超过 100。
// 每个单词 words[i]的长度范围为 [1, 12]。
// 每个单词 words[i]只包含小写字母。
//
// Related Topics 字符串
// 804. 唯一摩尔斯密码词

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
  public static void main(String[] args) {
    Printer.printCorrectAnswer(
        2,
        new Solution()
            .uniqueMorseRepresentations(DataBuilder.buildStringArray("gin", "zen", "gig", "msg")));
  }

  static class Solution {
    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 99.15% 的用户
     *
     * <p>内存消耗： 36.6 MB , 在所有 Java 提交中击败了 83.40% 的用户
     *
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
      String[] pw = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
        "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
      };
      Set<String> set = new HashSet<>();
      StringBuilder sb = new StringBuilder();
      for (String word : words) {
        for (char ch : word.toCharArray()) {
          sb.append(pw[ch - 'a']);
        }
        set.add(sb.toString());
        sb.setLength(0);
      }
      return set.size();
    }
  }
}
