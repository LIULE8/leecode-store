// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//
//
//
// 示例 1：
//
//
// 输入：head = [1,2,3,4,5]
// 输出：[5,4,3,2,1]
//
//
// 示例 2：
//
//
// 输入：head = [1,2]
// 输出：[2,1]
//
//
// 示例 3：
//
//
// 输入：head = []
// 输出：[]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目范围是 [0, 5000]
// -5000 <= Node.val <= 5000
//
//
//
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
//
//
// Related Topics 递归 链表
// 206. 反转链表 / 剑指 Offer 24. 反转链表

package com.leo.algorithm.easy.linklist;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class ReverseLinkedList {
  public static void main(String[] args) {
    Printer.printListNode(new Solution().reverseList(DataBuilder.buildListNode("1,2,3,4,5")));
  }

  static class Solution {

    public ListNode reverseList(ListNode head) {
      //      return method1(head);
      return method2(head);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 38.2 MB , 在所有 Java 提交中击败了 59.01% 的用户
     *
     * @param head
     * @return
     */
    private ListNode method2(ListNode head) {
      // 边界校验
      if (head == null || head.next == null) {
        return head;
      }
      ListNode p = head;
      ListNode newHead = null;
      while (p != null) {
        ListNode next = p.next;
        p.next = newHead;
        newHead = p;
        p = next;
      }
      return newHead;
    }

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 37.9 MB , 在所有 Java 提交中击败了 5.08% 的用户
     *
     * @param head
     * @return
     */
    private ListNode method1(ListNode head) {
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
