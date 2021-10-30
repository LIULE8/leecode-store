// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
//
// 进阶：你能尝试使用一趟扫描实现吗？
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,4,5], n = 2
// 输出：[1,2,3,5]
//
//
// 示例 2：
//
//
// 输入：head = [1], n = 1
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：head = [1,2], n = 1
// 输出：[1]
//
//
//
//
// 提示：
//
//
// 链表中结点的数目为 sz
// 1 <= sz <= 30
// 0 <= Node.val <= 100
// 1 <= n <= sz
//
// Related Topics 链表 双指针
// 19. 删除链表的倒数第 N 个结点

package com.leo.algorithm.plan.introduction.t05;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class RemoveNthNodeFromEndOfList {
  public static void main(String[] args) {
    ListNode listNode = DataBuilder.buildListNode("1");
    ListNode listNode1 = new Solution().removeNthFromEnd(listNode, 1);
    Printer.printListNode(listNode1);
  }

  static class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
      //      return method1(head, n);
      return method2(head, n);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.5 MB , 在所有 Java 提交中击败了 27.29% 的用户
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode method2(ListNode head, int n) {
      // 边界问题
      if (head == null) return head;
      ListNode first = head;
      ListNode second = head;
      // 快指针先走N步
      int i = 0;
      while (first != null && i < n) {
        first = first.next;
        i++;
      }
      if (first == null) return head.next;
      while (first.next != null) {
        first = first.next;
        second = second.next;
      }
      second.next = second.next.next;
      return head;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 36.4 MB , 在所有 Java 提交中击败了 46.84% 的用户
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode method1(ListNode head, int n) {
      if (head == null) return head;
      ListNode fast = head;
      ListNode slow = head;
      for (int i = 0; i < n && fast != null; i++) {
        fast = fast.next;
      }
      if (fast == null) return head.next;
      while (fast.next != null) {
        fast = fast.next;
        slow = slow.next;
      }
      slow.next = slow.next.next;
      return head;
    }
  }
}
