// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
// 输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 栈 递归 链表 双指针
// 剑指 Offer 06. 从尾到头打印链表

package com.leo.algorithm.easy.linklist;

import com.leo.algorithm.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class CongWeiDaoTouDaYinLianBiaoLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 73.88% 的用户
     *
     * <p>内存消耗： 38.9 MB , 在所有 Java 提交中击败了 69.19% 的用户
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
      if (head == null) return new int[0];
      List<Integer> list = new ArrayList<>();
      ListNode p = head;
      while (p != null) {
        list.add(p.val);
        p = p.next;
      }
      int[] result = new int[list.size()];
      for (int k = 0, i = list.size() - 1; i >= 0; i--) {
        result[k++] = list.get(i);
      }
      return result;
    }
  }
}
