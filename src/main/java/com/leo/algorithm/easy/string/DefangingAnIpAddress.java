// 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
//
// 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
//
//
//
// 示例 1：
//
// 输入：address = "1.1.1.1"
// 输出："1[.]1[.]1[.]1"
//
//
// 示例 2：
//
// 输入：address = "255.100.50.0"
// 输出："255[.]100[.]50[.]0"
//
//
//
//
// 提示：
//
//
// 给出的 address 是一个有效的 IPv4 地址
//
// Related Topics 字符串
// 1108. IP 地址无效化

package com.leo.algorithm.easy.string;

import com.leo.algorithm.utils.Printer;

public class DefangingAnIpAddress {
  public static void main(String[] args) {
    Printer.printCorrectAnswer("1[.]1[.]1[.]1", new Solution().defangIPaddr("1.1.1.1"));
    Printer.printCorrectAnswer("255[.]100[.]50[.]0", new Solution().defangIPaddr("255.100.50.0"));
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.6 MB , 在所有 Java 提交中击败了 65.91% 的用户
     *
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
      StringBuilder sb = new StringBuilder();
      for (char c : address.toCharArray()) {
        if (c == '.') sb.append("[").append(c).append("]");
        else sb.append(c);
      }
      return sb.toString();
    }
  }
}
