package com.leo.easy.linklist;

import com.leo.structure.ListNode;
import com.leo.utils.DataBuilder;
import com.leo.utils.Printer;

public class ReverseLinkedList {
  public static void main(String[] args) {
    ListNode listNode = DataBuilder.buildListNode("1,2,3,4,5");
    ListNode listNode1 = new Solution().reverseList(listNode);
    Printer.printListNode(listNode1);
  }

  static class Solution {
    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 37.9 MB , 在所有 Java 提交中击败了 5.08% 的用户
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
      ListNode p = head;
      ListNode newHead = null;
      while (p != null) {
        ListNode cur = new ListNode(p.val);
        cur.next = newHead;
        newHead = cur;
        p = p.next;
      }
      return newHead;
    }
  }
}
