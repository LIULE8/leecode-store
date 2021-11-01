// 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//
//
// push(x) —— 将元素 x 推入栈中。
// pop() —— 删除栈顶的元素。
// top() —— 获取栈顶元素。
// getMin() —— 检索栈中的最小元素。
//
//
//
//
// 示例:
//
// 输入：
// ["MinStack","push","push","push","getMin","pop","top","getMin"]
// [[],[-2],[0],[-3],[],[],[],[]]
//
// 输出：
// [null,null,null,null,-3,null,0,-2]
//
// 解释：
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> 返回 -3.
// minStack.pop();
// minStack.top();      --> 返回 0.
// minStack.getMin();   --> 返回 -2.
//
//
//
//
// 提示：
//
//
// pop、top 和 getMin 操作总是在 非空栈 上调用。
//
// Related Topics 栈 设计
// 155. 最小栈

package com.leo.algorithm.easy.stack;

public class MinStack {

  private int[] items;
  private int n = 1024;
  private int count = 0;

  public MinStack() {
    items = new int[n];
  }

  public void push(int val) {
    if (count == n) {
      int[] tmp = new int[n * 2];
      System.arraycopy(items, 0, tmp, 0, n);
      items = tmp;
      n = n * 2;
    }
    items[count++] = val;
  }

  public void pop() {
    if (count == 0) return;
    count--;
  }

  public int top() {
    if (count == 0) return -1;
    return items[count - 1];
  }

  public int getMin() {
    int min = 0;
    for (int i = 1; i < count; i++) {
      if (items[i] < items[min]) {
        min = i;
      }
    }
    return items[min];
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(512);
    minStack.push(-1024);
    minStack.push(-1024);
    minStack.push(512);
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
  }
}
