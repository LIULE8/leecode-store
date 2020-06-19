package com.leo.algorithm.company.bytedance;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.utils.DataBuilder;
import com.leo.algorithm.utils.Printer;

/**
 * 21. 合并两个有序链表
 *
 * <p>将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * <p>示例：
 *
 * <p>输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoSortedLists {
  public static void main(String[] args) {
    ListNode l1 = DataBuilder.buildListNode("1,2,4");
    ListNode l2 = DataBuilder.buildListNode("1,3,4");
    ListNode listNode = new Solution().mergeTwoLists(l1, l2);
    Printer.printListNode(listNode);
  }

  static class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      return method1(l1, l2);
    }

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 62.58% 的用户
     *
     * <p>内存消耗 : 39.4 MB , 在所有 Java 提交中击败了 58.88% 的用户
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode method1(ListNode l1, ListNode l2) {
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
