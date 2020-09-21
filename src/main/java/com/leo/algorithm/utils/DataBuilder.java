package com.leo.algorithm.utils;

import com.leo.algorithm.structure.ListNode;
import com.leo.algorithm.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
   * @param data data1,data2,data3 ..
   * @param pos 最后一个节点指向第i个节点，形成环
   * @return
   */
  public static ListNode buildCycleListNode(String data, int pos) {
    String[] datas = data.split(",");
    ListNode head = new ListNode(Integer.parseInt(datas[0]));
    ListNode cur = head;
    ListNode target = pos == 0 ? head : null;
    for (int i = 1; i < datas.length; i++) {
      cur.next = new ListNode(Integer.parseInt(datas[i]));
      if (i == pos) target = cur.next;
      cur = cur.next;
    }
    cur.next = target;
    return head;
  }

  /**
   * @param data data1,data2,data3 ..
   * @return
   */
  public static int[] buildIntArray(String data) {
    String[] datas = data.split(",");
    int[] result = new int[datas.length];
    for (int i = 0; i < datas.length; i++) {
      result[i] = Integer.parseInt(datas[i].trim());
    }
    return result;
  }

  /**
   * @param data data1,data2,data3 ..
   * @return
   */
  public static String[] buildStringArray(String data) {
    return data.split(",");
  }

  /**
   * @param data data1,data2,data3 ..
   * @return
   */
  public static String[] buildStringArray(String... data) {
    return data;
  }

  public static List<int[]> buildIntArrays(String... data) {
    List<int[]> list = new ArrayList<>();
    for (String s : data) {
      list.add(buildIntArray(s));
    }
    return list;
  }

  public static int[][] buildDoubleArray(String s) {
    s = s.replace("[[", "");
    s = s.replace("]]", "");
    String[] split = s.split("],\\s*\\[");
    int[][] a = new int[split.length][];
    for (int i = 0; i < split.length; i++) {
      String[] sp = split[i].split(",");
      a[i] = new int[sp.length];
      for (int j = 0; j < sp.length; j++) {
        a[i][j] = Integer.parseInt(sp[j].trim());
      }
    }
    return a;
  }

  public static List<List<Integer>> buildDoubleList(String s) {
    String[] split = s.split("],\\[");
    List<List<Integer>> results = new ArrayList<>();
    for (int i = 0; i < split.length; i++) {
      List<Integer> list = new ArrayList<>();
      results.add(list);
      if (i == 0) {
        String str = split[i].substring(2);
        String[] sp = str.split(",");
        for (String value : sp) {
          list.add(Integer.parseInt(value.trim()));
        }
      } else if (i == split.length - 1) {
        String str = split[i].substring(0, split[i].indexOf("]"));
        String[] sp = str.split(",");
        for (String value : sp) {
          list.add(Integer.parseInt(value.trim()));
        }
      } else {
        String[] sp = split[i].split(",");
        for (String value : sp) {
          list.add(Integer.parseInt(value.trim()));
        }
      }
    }
    return results;
  }

  public static TreeNode buildTreeNode(Integer[] value) {
    TreeNode headLink = new TreeNode(value[0]);
    TreeNode header = headLink;
    Queue<TreeNode> queue = new LinkedList<>();
    int i = 0;
    while (headLink != null) {
      if (2 * i + 1 < value.length && value[2 * i + 1] != null) {
        headLink.left = new TreeNode(value[2 * i + 1]);
        queue.add(headLink.left);
      }
      if (2 * i + 2 < value.length && value[2 * i + 2] != null) {
        headLink.right = new TreeNode(value[2 * i + 2]);
        queue.add(headLink.right);
      }
      headLink = queue.poll();
      i += 1;
    }
    return header;
  }

  public static Integer[] buildIntegerArray(String data) {
    String[] datas = data.split(",");
    Integer[] result = new Integer[datas.length];
    for (int i = 0; i < datas.length; i++) {
      String num = datas[i].trim();
      if (num.equals("null")) continue;
      result[i] = Integer.parseInt(num);
    }
    return result;
  }
}
