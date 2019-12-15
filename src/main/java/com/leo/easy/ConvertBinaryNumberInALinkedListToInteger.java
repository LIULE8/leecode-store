package com.leo.easy;

import com.leo.structure.ListNode;
import com.leo.utils.DataBuilder;

/**
 * 示例 1：
 * 1->0->1
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * 示例 2：
 * <p>
 * 输入：head = [0]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * 示例 5：
 * <p>
 * 输入：head = [0,0]
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * 链表不为空。
 * 链表的结点总数不超过 30。
 * 每个结点的值不是 0 就是 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {
//        ListNode listNode = DataBuilder.builderListNode("1,0,1");
        ListNode listNode = DataBuilder.buildListNode("1,0,0,1,0,0,1,1,1,0,0,0,0,0,0");
        int decimalValue = new Solution().getDecimalValue(listNode);
        System.out.println(decimalValue);
    }


    static class Solution {
        public int getDecimalValue(ListNode head) {
            ListNode cur = head;
            int result = 0;
            while (cur != null) {
                result <<= 1;
                result += cur.val;
                cur = cur.next;
            }
            return result;
        }
    }
}