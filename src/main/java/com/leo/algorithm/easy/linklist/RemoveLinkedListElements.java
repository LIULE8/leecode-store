package com.leo.algorithm.easy.linklist;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

/**
 * 203. 移除链表元素
 *
 * <p>删除链表中等于给定值 val 的所有节点。
 *
 * <p>示例:
 *
 * <p>输入: 1->2->6->3->4->5->6, val = 6 输出: 1->2->3->4->5
 */
public class RemoveLinkedListElements {
  public static void main(String[] args) {
    //    ListNode listNode = DataBuilder.buildListNode("1,2,6,3,4,5,6");
    ListNode listNode = DataBuilder.buildListNode("1,1");
    //    ListNode listNode = DataBuilder.buildListNode("1,2");
    ListNode listNode1 = new Solution().removeElements(listNode, 1);
    Printer.printListNode(listNode1);
  }

  static class Solution {
    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.97% 的用户
     *
     * <p>内存消耗 : 41.3 MB , 在所有 Java 提交中击败了 5.13% 的用户
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
      ListNode newHead = new ListNode(-1);
      newHead.next = head;
      ListNode cur = newHead;
      while (cur.next != null) {
        if (cur.next.val == val) {
          cur.next = cur.next.next;
        } else {
          cur = cur.next;
        }
      }
      return newHead.next;
    }
  }
}
