// RGB 颜色用十六进制来表示的话，每个大写字母都代表了某个从 0 到 f 的 16 进制数。
//
// RGB 颜色 "#AABBCC" 可以简写成 "#ABC" 。例如，"#15c" 其实是 "#1155cc" 的简写。
//
// 现在，假如我们分别定义两个颜色 "#ABCDEF" 和 "#UVWXYZ"，则他们的相似度可以通过这个表达式 -(AB - UV)^2 - (CD - W
// X)^2 - (EF - YZ)^2 来计算。
//
// 那么给定颜色 "#ABCDEF"，请你返回一个与 #ABCDEF 最相似的 7 个字符代表的颜色，并且它是可以被简写形式表达的。（比如，可以表示成类似 "
// #XYZ" 的形式）
//
// 示例 1：
// 输入：color = "#09f166"
// 输出："#11ee66"
// 解释：
// 因为相似度计算得出 -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -7
// 3
// 这已经是所有可以简写的颜色中最相似的了
//
//
// 注意：
//
//
// color 是一个长度为 7 的字符串
// color 是一个有效的 RGB 颜色：对于仍和 i > 0，color[i] 都是一个在 0 到 f 范围的 16 进制数
// 假如答案具有相同的（最大）相似度的话，都是可以被接受的
// 所有输入、输出都必须使用小写字母，并且输出为 7 个字符
//
// Related Topics 数学 字符串
// 800. 相似 RGB 颜色

package com.leo.algorithm.easy.string;

public class SimilarRgbColor {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  /**
   * 我们可以发现，颜色中的每一维都是独立的，因此我们只需要分别计算出 color = #ABCDEF 中与 AB，CD 和 EF 相似度最大的颜色即可。最终的答案为这三个颜色的结合。
   *
   * <p>对于 AB，我们要在 00 到 ff 中找到一个相似度最大的。在方法一中我们得知，00 到 ff 均为 17 的倍数，因此我们需要找到一个 17 的倍数，使得其与 AB
   * 的差的绝对值最小。显然，当 AB mod 17 > 8 时，取刚好比 AB 大的那个数；当 AB mod 17 <= 8 时，取刚好比 AB 小或与 AB 相等的那个数。
   */
  static class Solution {
    /**
     * 执行用时： 26 ms , 在所有 Java 提交中击败了 16.67% 的用户
     *
     * <p>内存消耗： 39.4 MB , 在所有 Java 提交中击败了 21.21% 的用户
     *
     * @param color
     * @return
     */
    public String similarRGB(String color) {
      return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5));
    }

    public String f(String comp) {
      int q = Integer.parseInt(comp, 16);
      q = q / 17 + (q % 17 > 8 ? 1 : 0);
      return String.format("%02x", 17 * q);
    }
  }
}
