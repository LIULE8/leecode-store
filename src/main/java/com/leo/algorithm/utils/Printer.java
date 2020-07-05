package com.leo.algorithm.utils;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.structure.TreeNode;

import java.util.List;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.concurrent.LinkedBlockingQueue;

public class Printer {

  public static void printTreeNode(TreeNode treeNode) {
    if (treeNode == null) return;
    StringJoiner sj = new StringJoiner(", ", "[", "]");
    Queue<TreeNode> queue = new LinkedBlockingQueue<>();
    TreeNode curr;
    queue.add(treeNode);
    while (!queue.isEmpty()) {
      curr = queue.remove();
      sj.add(curr.val + "");
      if (curr.left != null) queue.add(curr.left);
      if (curr.right != null) queue.add(curr.right);
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

  public static void printDoubleArray(int[][] ints) {
    for (int[] anInt : ints) {
      for (int i : anInt) {
        System.out.print(i + ",");
      }
      System.out.println();
    }
  }

  public static void printArray(int[] a) {
    StringJoiner sj = new StringJoiner(",");
    for (int value : a) {
      sj.add(String.valueOf(value));
    }
    System.out.println(sj.toString());
  }

  public static void printIntegerList(List<Integer> list) {
    System.out.println(list.toString());
  }

  public static void printStringList(List<String> list) {
    System.out.println(list.toString());
  }


  public static void printCorrectAnswer(Object correct, Object algorithm){
    System.out.println("正确答案: " + correct +", 算法答案: " + algorithm);
  }
}
