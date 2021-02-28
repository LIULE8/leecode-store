// 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
//
// 实现 MyHashSet 类：
//
//
// void add(key) 向哈希集合中插入值 key 。
// bool contains(key) 返回哈希集合中是否存在这个值 key 。
// void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
//
//
//
// 示例：
//
//
// 输入：
// ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove
// ", "contains"]
// [[], [1], [2], [1], [3], [2], [2], [2], [2]]
// 输出：
// [null, null, null, true, false, null, true, null, false]
//
// 解释：
// MyHashSet myHashSet = new MyHashSet();
// myHashSet.add(1);      // set = [1]
// myHashSet.add(2);      // set = [1, 2]
// myHashSet.contains(1); // 返回 True
// myHashSet.contains(3); // 返回 False ，（未找到）
// myHashSet.add(2);      // set = [1, 2]
// myHashSet.contains(2); // 返回 True
// myHashSet.remove(2);   // set = [1]
// myHashSet.contains(2); // 返回 False ，（已移除）
//
//
// 705. 设计哈希集合
// 提示：
//
//
// 0 <= key <= 106
// 最多调用 104 次 add、remove 和 contains 。
//
//
//
//
// 进阶：你可以不使用内建的哈希集合库解决此问题吗？
// Related Topics 设计 哈希表
// 👍 88 👎 0

package com.leo.algorithm.easy.hashtable;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class DesignHashset {
  public static void main(String[] args) {}

  /**
   * 执行用时： 1272 ms , 在所有 Java 提交中击败了 5.01% 的用户
   *
   * <p>内存消耗： 46.4 MB , 在所有 Java 提交中击败了 35.56% 的用户
   */
  static class MyHashSet {

    static class Entry<V> {
      private final V value;

      public Entry(V value) {
        this.value = value;
      }

      @Override
      public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry<?> entry = (Entry<?>) o;
        return Objects.equals(value, entry.value);
      }

      @Override
      public int hashCode() {
        return Objects.hash(value);
      }
    }

    private final List<Entry<Integer>> entries;

    /** Initialize your data structure here. */
    public MyHashSet() {
      entries = new LinkedList<>();
    }

    public void add(int key) {
      boolean flag = false;
      for (Entry<Integer> entry : entries) {
        if (entry.value == key) {
          flag = true;
          break;
        }
      }
      if (!flag) {
        entries.add(new Entry<>(key));
      }
    }

    public void remove(int key) {
      entries.removeIf(entry -> entry.value == key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
      return entries.contains(new Entry<>(key));
    }
  }

  /**
   * Your MyHashSet object will be instantiated and called as such: MyHashSet obj = new MyHashSet();
   * obj.add(key); obj.remove(key); boolean param_3 = obj.contains(key);
   */
}
