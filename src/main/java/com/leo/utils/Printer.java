package com.leo.utils;

import com.leo.structure.ListNode;

import java.util.StringJoiner;

public class Printer {

    public static void printArray(int[] a) {
        StringJoiner sj = new StringJoiner(",");
        for (int value : a) {
            sj.add(String.valueOf(value));
        }
        System.out.println(sj.toString());
    }

    public static void printListNode(ListNode listNode) {
        StringJoiner sj = new StringJoiner("->");
        ListNode indexNode = listNode;
        while (indexNode != null) {
            sj.add(String.valueOf(indexNode.val));
            indexNode = indexNode.next;
        }
        System.out.println(sj.toString());
    }
}
