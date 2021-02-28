// 不使用任何内建的哈希表库设计一个哈希映射
//
// 具体地说，你的设计应该包含以下的功能
//
//
// put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
// get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
// remove(key)：如果映射中存在这个键，删除这个数值对。
//
//
//
// 示例：
//
// MyHashMap hashMap = new MyHashMap();
// hashMap.put(1, 1);
// hashMap.put(2, 2);
// hashMap.get(1);            // 返回 1
// hashMap.get(3);            // 返回 -1 (未找到)
// hashMap.put(2, 1);         // 更新已有的值
// hashMap.get(2);            // 返回 1
// hashMap.remove(2);         // 删除键为2的数据
// hashMap.get(2);            // 返回 -1 (未找到)
//
//
// 706. 设计哈希映射
// 注意：
//
//
// 所有的值都在 [0, 1000000]的范围内。
// 操作的总数目在[1, 10000]范围内。
// 不要使用内建的哈希库。
//
// Related Topics 设计 哈希表
// 👍 118 👎 0

package com.leo.algorithm.easy.hashtable;

import java.util.ArrayList;
import java.util.List;

public class DesignHashmap {
  public static void main(String[] args) {}

  /**
   * 执行用时： 570 ms , 在所有 Java 提交中击败了 5.06% 的用户
   *
   * <p>内存消耗： 43.1 MB , 在所有 Java 提交中击败了 58.94% 的用户
   */
  static class MyHashMap {
    static class Entry<K, V> {
      private K key;
      private V value;

      public Entry(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    List<Entry<Integer, Integer>> entries;

    /** Initialize your data structure here. */
    public MyHashMap() {
      entries = new ArrayList<>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
      boolean flag = false;
      for (Entry<Integer, Integer> entry : entries) {
        if (entry.key.equals(key)) {
          entry.value = value;
          flag = true;
          break;
        }
      }
      if (!flag) {
        entries.add(new Entry<>(key, value));
      }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
     * for the key
     */
    public int get(int key) {
      for (Entry<Integer, Integer> entry : entries) {
        if (entry.key == key) return entry.value;
      }
      return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
      for (int i = 0; i < entries.size(); i++) {
        if (entries.get(i).key == key) {
          entries.remove(entries.get(i));
        }
      }
    }
  }

  /**
   * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
   * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
   */
}
