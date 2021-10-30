package com.leo.algorithm.easy.linklist;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

// 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
//
// 如果有两个中间结点，则返回第二个中间结点。
//
//
//
// 示例 1：
//
//
// 输入：[1,2,3,4,5]
// 输出：此列表中的结点 3 (序列化形式：[3,4,5])
// 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
// 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
// ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next =
// NULL.
//
//
// 示例 2：
//
//
// 输入：[1,2,3,4,5,6]
// 输出：此列表中的结点 4 (序列化形式：[4,5,6])
// 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
//
//
//
//
// 提示：
//
//
// 给定链表的结点数介于 1 和 100 之间。
//
// Related Topics 链表 双指针
// 876. 链表的中间结点

public class MiddleOfTheLinkedList {
  public static void main(String[] args) {
    //      ListNode listNode = DataBuilder.buildListNode("1,2,3,4,5");
    ListNode listNode = DataBuilder.buildListNode("1,2,3,4,5,6");
    ListNode listNode1 = new Solution().middleNode(listNode);
    Printer.printListNode(listNode1);
  }

  static class Solution {

    public ListNode middleNode(ListNode head) {
      //      return method1(head);
      return method2(head);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 35.9 MB , 在所有 Java 提交中击败了 48.05% 的用户
     *
     * @param head
     * @return
     */
    private ListNode method2(ListNode head) {
      // 边界问题
      if (head == null || head.next == null) return head;
      ListNode first = head;
      ListNode second = head;
      while (first != null && first.next != null) {
        first = first.next.next;
        second = second.next;
      }
      return second;
    }

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 36.5 MB , 在所有 Java 提交中击败了 5.18% 的用户
     *
     * @param head
     * @return
     */
    private ListNode method1(ListNode head) {
      if (head == null) return null;
      ListNode f = head.next;
      ListNode s = head;
      while (f != null && f.next != null) {
        f = f.next.next;
        s = s.next;
      }
      return f == null ? s : s.next;
    }
  }
}
