package com.leo.algorithm.easy.linklist;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.utils.DataBuilder;

/**
 * 234. 回文链表
 *
 * <p>请判断一个链表是否为回文链表。
 *
 * <p>示例 1:
 *
 * <p>输入: 1->2 输出: false 示例 2:
 *
 * <p>输入: 1->2->2->1 输出: true 进阶： 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {
  public static void main(String[] args) {
    ListNode listNode = DataBuilder.buildListNode("1,2,2,1");
    //    ListNode listNode = DataBuilder.buildListNode("1");
    //    ListNode listNode = DataBuilder.buildListNode("1,0,1");
    boolean palindrome = new Solution().isPalindrome(listNode);
    System.out.println(palindrome);
  }

  static class Solution {
    public boolean isPalindrome(ListNode head) {
      return method1(head);
    }

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 57.14% 的用户
     *
     * <p>内存消耗 : 42.3 MB , 在所有 Java 提交中击败了 13.22% 的用户
     *
     * @param head
     * @return
     */
    private boolean method1(ListNode head) {
      if (head == null || head.next == null) return true;
      ListNode mid = findMidNode(head);
      ListNode revse = reverseListNode(mid);
      ListNode p = head;
      while (revse != null) {
        if (revse.val != p.val) return false;
        revse = revse.next;
        p = p.next;
      }
      return true;
    }

    private ListNode reverseListNode(ListNode head) {
      if (head == null) return head;
      ListNode p = head;
      ListNode newHead = null;
      while (p != null) {
        ListNode s = new ListNode(p.val);
        s.next = newHead;
        newHead = s;
        p = p.next;
      }
      return newHead;
    }

    private ListNode findMidNode(ListNode head) {
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
