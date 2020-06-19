package com.leo.algorithm.easy.linklist;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

/**
 * 2. 两数相加
 *
 * <p>给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * <p>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * <p>您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * <p>示例：
 *
 * <p>输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
  public static void main(String[] args) {
    //      ListNode l1 = DataBuilder.buildListNode("2,4,3");
    //      ListNode l2 = DataBuilder.buildListNode("5,6,4");
    ListNode l1 = DataBuilder.buildListNode("5");
    ListNode l2 = DataBuilder.buildListNode("5");
    //        ListNode l1 = DataBuilder.buildListNode("1,8");
    //        ListNode l2 = DataBuilder.buildListNode("0");
    //    ListNode l1 = DataBuilder.buildListNode("9,8");
    //    ListNode l2 = DataBuilder.buildListNode("1");
    ListNode listNode = new Solution().addTwoNumbers(l1, l2);
    Printer.printListNode(listNode);
  }

  static class Solution {
    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 42.23% 的用户
     *
     * <p>内存消耗 : 45.1 MB , 在所有 Java 提交中击败了 8.90% 的用户
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      if (l1 == null && l2 == null) return null;
      if (l1 == null) return l2;
      if (l2 == null) return l1;

      ListNode head, n, t;
      ListNode p = l1;
      ListNode q = l2;
      int sum = p.val + q.val;
      if (sum >= 10) {
        head = new ListNode(sum % 10);
        t = new ListNode(1);
        head.next = t;
      } else {
        head = new ListNode(sum);
        t = new ListNode(0);
      }
      n = head;
      while (p.next != null && q.next != null) {
        p = p.next;
        q = q.next;
        sum = p.val + q.val + t.val;
        ListNode temp;
        if (sum >= 10) {
          temp = new ListNode(sum % 10);
          t = new ListNode(1);
          temp.next = t;
        } else {
          temp = new ListNode(sum);
          t = new ListNode(0);
        }
        n.next = temp;
        n = n.next;
      }
      n = getListNode(n, t, p);
      n = getListNode(n, t, q);
      return head;
    }

    private ListNode getListNode(ListNode n, ListNode t, ListNode p) {
      int sum;
      while (p.next != null) {
        sum = p.next.val + t.val;
        if (sum >= 10) {
          n.next = new ListNode(sum % 10);
          n.next.next = new ListNode(1);
          t.val = 1;
        } else {
          n.next = new ListNode(sum);
          t.val = 0;
        }
        n = n.next;
        p = p.next;
      }
      return n;
    }
  }
}
