// 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
//
// 示例1：
//
// 输入：1->2->4, 1->3->4
// 输出：1->1->2->3->4->4
//
// 限制：
//
// 0 <= 链表长度 <= 1000
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
// Related Topics 递归 链表
// 剑指 Offer 25. 合并两个排序的链表

package com.leo.algorithm.easy.linklist;

import com.leo.algorithm.structure.ListNode;

public class HeBingLiangGePaiXuDeLianBiaoLcof {
  public static void main(String[] args) {
    Solution solution = new Solution();
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
      ListNode newHead = new ListNode(0);
      ListNode p = newHead;
      while (l1 != null && l2 != null) {
        ListNode tmp;
        if (l1.val <= l2.val) {
          tmp = new ListNode(l1.val);
          l1 = l1.next;
        } else {
          tmp = new ListNode(l2.val);
          l2 = l2.next;
        }
        p.next = tmp;
        p = p.next;
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
      return newHead.next;
    }
  }
}
