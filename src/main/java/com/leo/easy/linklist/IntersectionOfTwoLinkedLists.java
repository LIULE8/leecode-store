package com.leo.easy.linklist;

import com.leo.structure.ListNode;

import java.util.HashSet;
import java.util.Set;
// 编写一个程序，找到两个单链表相交的起始节点。
// 注意：
//
//
// 如果两个链表没有交点，返回 null.
// 在返回结果后，两个链表仍须保持原有的结构。
// 可假定整个链表结构中没有循环。
// 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
//
// Related Topics 链表

/**
 * 160. 相交链表
 *
 * <p>注意：
 *
 * <p>如果两个链表没有交点，返回 null.
 *
 * <p>在返回结果后，两个链表仍须保持原有的结构。
 *
 * <p>可假定整个链表结构中没有循环。
 *
 * <p>程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class IntersectionOfTwoLinkedLists {
  public static void main(String[] args) {
    Solution solution = new Solution();
  }

  static class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      //      return method1(headA, headB);
      return method2(headA, headB);
    }

    /**
     * 双指针方法, 遍历 A+B
     *
     * <p>执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 42.6 MB , 在所有 Java 提交中击败了 22.16% 的用户
     *
     * @param headA
     * @param headB
     * @return
     */
    private ListNode method2(ListNode headA, ListNode headB) {
      if (headA == null || headB == null) return null;
      ListNode p = headA;
      ListNode q = headB;
      while (p != q) {
        p = p.next;
        q = q.next;
        if (p == null && q == null) return null;
        if (p == null) p = headB;
        if (q == null) q = headA;
      }
      return p;
    }

    /**
     * 最简单的方法
     *
     * <p>执行用时 : 9 ms , 在所有 Java 提交中击败了 19.63% 的用户
     *
     * <p>内存消耗 : 44.9 MB , 在所有 Java 提交中击败了 8.85% 的用户
     *
     * @param headA
     * @param headB
     * @return
     */
    private ListNode method1(ListNode headA, ListNode headB) {
      Set<ListNode> set = new HashSet<>();
      if (headA == null || headB == null) return null;
      ListNode p = headA;
      ListNode q = headB;
      while (p != null) {
        set.add(p);
        p = p.next;
      }
      while (q != null) {
        if (set.contains(q)) return q;
        q = q.next;
      }
      return null;
    }
  }
}
