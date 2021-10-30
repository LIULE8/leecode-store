package com.leo.algorithm.easy.linklist;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.utils.DataBuilder;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. 环形链表
 *
 * <p>给定一个链表，判断链表中是否有环。
 *
 * <p>你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class LinkedListCycle {
  public static void main(String[] args) throws Exception {
    ListNode listNode = DataBuilder.buildCycleListNode("3,2,0,-4", 1);
    //    ListNode listNode = DataBuilder.buildListNode("1");
    //    ListNode listNode = DataBuilder.buildListNode("1,2");
    boolean b = new Solution().hasCycle(listNode);
    System.out.println(b);
  }

  static class Solution {

    public boolean hasCycle(ListNode head) {
      //      return method1(head);
      //      return method2(head);
      //      return method3(head);
      return method4(head);
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 39.4 MB , 在所有 Java 提交中击败了 62.25% 的用户
     *
     * @param head
     * @return
     */
    private boolean method4(ListNode head) {
      if (head == null || head.next == null) {
        return false;
      }
      ListNode first = head;
      ListNode second = head;
      while (first != null && first.next != null) {
        first = first.next.next;
        second = second.next;
        if (first != null && first == second) return true;
      }
      return false;
    }

    /**
     * 最简单方法
     *
     * <p>执行用时 : 5 ms , 在所有 Java 提交中击败了 24.82% 的用户
     *
     * <p>内存消耗 : 41.6 MB , 在所有 Java 提交中击败了 5.03% 的用户
     *
     * @param head
     * @return
     */
    private boolean method3(ListNode head) {
      ListNode p = head;
      Set<ListNode> set = new HashSet<>();
      while (p != null) {
        if (set.contains(p)) {
          return true;
        }
        set.add(p);
        p = p.next;
      }
      return false;
    }

    /**
     * 快慢指针
     *
     * <p>执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 40.9 MB , 在所有 Java 提交中击败了 5.03% 的用户
     *
     * @param head
     * @return
     */
    private boolean method2(ListNode head) {
      if (head == null || head.next == null) return false;
      ListNode fast = head.next;
      ListNode slow = head;
      while (slow != fast) {
        if (fast == null || fast.next == null) return false;
        fast = fast.next.next;
        slow = slow.next;
      }
      return true;
    }

    /**
     * 会破环链表，删除节点
     *
     * <p>执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 41 MB , 在所有 Java 提交中击败了 5.03% 的用户
     *
     * @param head
     * @return
     */
    private boolean method1(ListNode head) {
      ListNode p = head;
      while (p != null) {
        if (p == p.next) {
          return true;
        }
        if (p.next == null) return false;
        p.next = p.next.next;
        p = p.next;
      }
      return false;
    }
  }
}
