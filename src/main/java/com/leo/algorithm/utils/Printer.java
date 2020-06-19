package com.leo.algorithm.utils;

import com.leo.algorithm.structure.ListNode;

import java.util.List;
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

  public static void printDoubleList(List<List<Integer>> list) {
    System.out.println(list.toString());
  }

  public static void printStringList(List<String> list) {
    System.out.println(list.toString());
  }

  public static void printIntegerList(List<Integer> list) {
    System.out.println(list.toString());
  }

  public static void printDoubleArray(int[][] ints) {
    for (int[] anInt : ints) {
      for (int i : anInt) {
        System.out.print(i + ",");
      }
      System.out.println();
    }
  }
}
