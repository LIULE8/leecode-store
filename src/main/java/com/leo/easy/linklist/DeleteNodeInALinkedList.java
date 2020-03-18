package com.leo.easy.linklist;

import com.leo.structure.ListNode;
import com.leo.utils.DataBuilder;
import com.leo.utils.Printer;

/**
 * 237. 删除链表中的节点
 *
 * <p>请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * <p>示例 1:
 *
 * <p>输入: head = [4,5,1,9], node = 5 输出: [4,1,9] 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 ->
 * 9. 示例 2:
 *
 * <p>输入: head = [4,5,1,9], node = 1 输出: [4,5,9] 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 ->
 * 9.
 *
 * <p>说明:
 *
 * <p>链表至少包含两个节点。 链表中所有节点的值都是唯一的。 给定的节点为非末尾节点并且一定是链表中的一个有效节点。 不要从你的函数中返回任何结果。
 */
public class DeleteNodeInALinkedList {
  public static void main(String[] args) {
    ListNode listNode = DataBuilder.buildListNode("4,5,1,9");
    ListNode listNode1 = findTargetNode(listNode, 5);
    new Solution().deleteNode(listNode1);
    Printer.printListNode(listNode);
  }

  private static ListNode findTargetNode(ListNode listNode, int pos) {
    while (listNode != null) {
      if (listNode.val == pos) {
        return listNode;
      }
      listNode = listNode.next;
    }
    return null;
  }

  static class Solution {

    /**
     * 当前需要删除的节点
     *
     * <p>执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     *
     * <p>内存消耗 : 38.8 MB , 在所有 Java 提交中击败了 5.25% 的用户
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
      node.val = node.next.val;
      node.next = node.next.next;
    }
  }
}
