package com.leo.easy;

import com.leo.structure.ListNode;
import com.leo.utils.DataBuilder;
import com.leo.utils.Printer;

/**
 * 21. 合并两个有序链表
 * <p>
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
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
            if (l1 == null && l2 == null) {
                return null;
            }
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode p = l1, q = l2, newList;
            if (p.val >= q.val) {
                newList = new ListNode(q.val);
                q = q.next;
            } else {
                newList = new ListNode(p.val);
                p = p.next;
            }
            ListNode nexIndex = newList;
            while (p != null && q != null) {
                if (p.val >= q.val) {
                    nexIndex.next = new ListNode(q.val);
                    q = q.next;
                } else {
                    nexIndex.next = new ListNode(p.val);
                    p = p.next;
                }
                nexIndex = nexIndex.next;
            }
            while (p != null) {
                nexIndex.next = new ListNode(p.val);
                nexIndex = nexIndex.next;
                p = p.next;
            }

            while (q != null) {
                nexIndex.next = new ListNode(q.val);
                nexIndex = nexIndex.next;
                q = q.next;
            }
            return newList;
        }
    }
}