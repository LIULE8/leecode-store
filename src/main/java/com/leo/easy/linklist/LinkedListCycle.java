package com.leo.easy.linklist;

import com.leo.structure.ListNode;
import com.leo.utils.DataBuilder;

import java.util.HashSet;
import java.util.Set;
// 给定一个链表，判断链表中是否有环。
//
// 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//
// 示例 1：
//
// 输入：head = [3,2,0,-4], pos = 1
// 输出：true
// 解释：链表中有一个环，其尾部连接到第二个节点。
//
//
// 示例 2：
//
// 输入：head = [1,2], pos = 0
// 输出：true
// 解释：链表中有一个环，其尾部连接到第一个节点。
//
// 示例 3：
//
// 输入：head = [1], pos = -1
// 输出：false
// 解释：链表中没有环。
//
// 进阶：
//
// 你能用 O(1)（即，常量）内存解决此问题吗？
// Related Topics 链表 双指针

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
      return method3(head);
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
