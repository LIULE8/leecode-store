// 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
// 功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
// ["CQueue","appendTail","deleteHead","deleteHead"]
// [[],[3],[],[]]
// 输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
// ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
// [[],[],[5],[2],[],[]]
// 输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计 队列
// 剑指 Offer 09. 用两个栈实现队列

package com.leo.algorithm.easy.stack;

import java.util.Stack;

public class YongLiangGeZhanShiXianDuiLieLcof {
  public static void main(String[] args) {}

  /**
   * Your CQueue object will be instantiated and called as such:
   *
   * <p>CQueue obj = new CQueue();
   *
   * <p>obj.appendTail(value);
   *
   * <p>int param_2 = obj.deleteHead();
   */
  class CQueue {

    private final Stack<Integer> data = new Stack<>();
    private final Stack<Integer> tmp = new Stack<>();

    /**
     * 执行用时： 231 ms , 在所有 Java 提交中击败了 10.11% 的用户
     *
     * <p>内存消耗： 46.3 MB , 在所有 Java 提交中击败了 84.68% 的用户
     */
    public CQueue() {}

    public void appendTail(int value) {
      synchronized (this) {
        data.add(value);
      }
    }

    public int deleteHead() {
      synchronized (this) {
        if (data.empty()) return -1;
        while (!data.empty()) {
          tmp.add(data.pop());
        }
        int target = tmp.pop();
        while (!tmp.empty()) {
          data.add(tmp.pop());
        }
        return target;
      }
    }
  }
}
