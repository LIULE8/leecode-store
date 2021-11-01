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

/**
 * 执行用时： 4 ms , 在所有 Java 提交中击败了 99.78% 的用户
 *
 * <p>内存消耗： 40 MB , 在所有 Java 提交中击败了 73.70% 的用户
 */
public class MinStack {

  private int[] items;
  private int size;
  private int minVal;
  private int minCount;

  public MinStack() {
    items = new int[100];
    minVal = Integer.MAX_VALUE;
  }

  public void push(int val) {
    if (size == items.length) {
      int[] tmp = new int[items.length + items.length];
      System.arraycopy(items, 0, tmp, 0, items.length);
      items = tmp;
    }
    items[size++] = val;
    if (val < minVal) {
      minVal = val;
      minCount = 1;
    } else if (val == minVal) minCount++;
  }

  public void pop() {
    int lastVal = items[--size];
    if (lastVal == minVal && --minCount == 0) {
      // 刷新min值
      refreshMin();
    }
  }

  public int top() {
    return items[size - 1];
  }

  public int getMin() {
    return minVal;
  }

  private void refreshMin() {
    minVal = Integer.MAX_VALUE;
    for (int i = 0; i < size; i++) {
      minVal = Math.min(minVal, items[i]);
    }
    minCount = 1;
  }

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(2147483646);
    minStack.push(2147483646);
    minStack.push(2147483647);
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
    minStack.pop();
    minStack.push(2147483647);
    minStack.top();
    System.out.println(minStack.getMin());
    minStack.push(-2147483648);
    minStack.top();
    System.out.println(minStack.getMin());
    minStack.pop();
    System.out.println(minStack.getMin());
  }
}
