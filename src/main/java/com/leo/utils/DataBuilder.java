package com.leo.utils;

import com.leo.structure.ListNode;

public class DataBuilder {

    /**
     * @param data data1,data2,data3 ..
     * @return ListNode head
     */
    public static ListNode buildListNode(String data) {
        String[] datas = data.split(",");
        ListNode head = new ListNode(Integer.parseInt(datas[0]));
        ListNode cur = head;
        for (int i = 1; i < datas.length; i++) {
            cur.next = new ListNode(Integer.parseInt(datas[i]));
            cur = cur.next;
        }
        return head;
    }

    /**
     *
     * @param data data1,data2,data3 ..
     * @return
     */
    public static int[] buildIntArray(String data){
        String[] datas = data.split(",");
        int[] result = new int[datas.length];
        for (int i = 0; i < datas.length; i++) {
            result[i] = Integer.parseInt(datas[i]);
        }
        return result;
    }
}
