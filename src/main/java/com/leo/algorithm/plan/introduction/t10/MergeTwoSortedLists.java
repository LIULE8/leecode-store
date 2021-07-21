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

package com.leo.algorithm.plan.introduction.t10;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

public class MergeTwoSortedLists {
  public static void main(String[] args) {
    ListNode l1 = DataBuilder.buildListNode("1,2,4");
    ListNode l2 = DataBuilder.buildListNode("1,3,4");
    ListNode listNode = new Solution().mergeTwoLists(l1, l2);
    Printer.printListNode(listNode);
  }

  static class Solution {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗： 37.8 MB , 在所有 Java 提交中击败了 66.79% 的用户
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode head = new ListNode(0);
      ListNode p = head;
      while (l1 != null && l2 != null) {
        if (l1.val <= l2.val) {
          p.next = new ListNode(l1.val);
          p = p.next;
          if (l1.val == l2.val) {
            p.next = new ListNode(l2.val);
            p = p.next;
            l2 = l2.next;
          }
          l1 = l1.next;
        } else {
          p.next = new ListNode(l2.val);
          p = p.next;
          l2 = l2.next;
        }
      }
      while (l1 != null) {
        p.next = new ListNode(l1.val);
        p = p.next;
        l1 = l1.next;
      }
      while (l2 != null) {
        p.next = new ListNode(l2.val);
        p = p.next;
        l2 = l2.next;
      }
      return head.next;
    }
  }
}
