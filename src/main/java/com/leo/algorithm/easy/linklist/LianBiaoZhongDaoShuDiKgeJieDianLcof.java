// 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
//
//
//
// 示例：
//
//
// 给定一个链表: 1->2->3->4->5, 和 k = 2.
//
// 返回链表 4->5.
// Related Topics 链表 双指针
// 剑指 Offer 22. 链表中倒数第k个节点

package com.leo.algorithm.easy.linklist;

import com.leo.algorithm.structure.ListNode;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.3 MB , 在所有 Java 提交中击败了 29.06% 的用户
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
      if (head == null || head.next == null) return head;
      ListNode f = head;
      ListNode s = head;
      for (int i = 0; i < k; i++) {
        f = f.next;
      }
      while (f != null) {
        s = s.next;
        f = f.next;
      }
      return s;
    }
  }
}
