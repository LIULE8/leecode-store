package com.leo.algorithm.easy.linklist;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例 1：
//
//
// 输入：l1 = [1,2,4], l2 = [1,3,4]
// 输出：[1,1,2,3,4,4]
//
//
// 示例 2：
//
//
// 输入：l1 = [], l2 = []
// 输出：[]
//
//
// 示例 3：
//
//
// 输入：l1 = [], l2 = [0]
// 输出：[0]
//
//
//
//
// 提示：
//
//
// 两个链表的节点数目范围是 [0, 50]
// -100 <= Node.val <= 100
// l1 和 l2 均按 非递减顺序 排列
//
// Related Topics 递归 链表
// 21. 合并两个有序链表

public class MergeTwoSortedLists {
  public static void main(String[] args) {
    ListNode l1 = DataBuilder.buildListNode("1,2,4");
    ListNode l2 = DataBuilder.buildListNode("1,3,4");
    ListNode listNode = new Solution().mergeTwoLists(l1, l2);
    Printer.printListNode(listNode);
  }

  static class Solution {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 84.93% 的用户
     *
     * <p>内存消耗： 38.6 MB , 在所有 Java 提交中击败了 28.83% 的用户
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode head = new ListNode(0); // 设立头节点
      ListNode tail = head;
      while (l1 != null && l2 != null) {
        ListNode newNode;
        if (l1.val <= l2.val) {
          newNode = new ListNode(l1.val);
          l1 = l1.next;
        } else {
          newNode = new ListNode(l2.val);
          l2 = l2.next;
        }
        tail.next = newNode;
        tail = tail.next;
      }
      while (l1 != null) {
        tail.next = new ListNode(l1.val);
        tail = tail.next;
        l1 = l1.next;
      }
      while (l2 != null) {
        tail.next = new ListNode(l2.val);
        tail = tail.next;
        l2 = l2.next;
      }
      return head.next;
    }
  }
}
