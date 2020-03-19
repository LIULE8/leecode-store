package com.leo.easy.linklist;

import com.leo.structure.ListNode;
import com.leo.utils.DataBuilder;
import com.leo.utils.Printer;

// 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
//
// 示例 1:
//
// 输入: 1->1->2
// 输出: 1->2
//
//
// 示例 2:
//
// 输入: 1->1->2->3->3
// 输出: 1->2->3
// Related Topics 链表

public class RemoveDuplicatesFromSortedList {
  public static void main(String[] args) {
//        ListNode listNode = DataBuilder.buildListNode("1,1,2,3,3");
    ListNode listNode = DataBuilder.buildListNode("1,1,1");
    ListNode listNode1 = new Solution().deleteDuplicates(listNode);
    Printer.printListNode(listNode1);
  }

  static class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      ListNode p = head; // 遍历指针
      ListNode q = head; // 修改结点指针(即删除操作)
      while (p != null) {
        while (p.next != null && p.val == p.next.val) p = p.next;
        q.next = p.next;
        q = q.next;
        p = p.next;
      }
      return head;
    }
  }
}
