package leetcode;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 *
 * @author Billy
 * @date 2020/8/3 6:47 上午
 */
public class P232 {
    class MyQueue {
        private Stack<Integer> stackA;
        private Stack<Integer> stackB;

        public MyQueue() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public void push(int x) {
            stackA.push(x);
        }

        public int pop() {
            if (stackB.isEmpty()) {
                if (stackA.isEmpty()) {
                    throw new RuntimeException("队列里没有元素");
                }
                transfer();
            }
            return stackB.pop();
        }

        public int peek() {
            if (stackB.isEmpty()) {
                if (stackA.isEmpty()) {
                    throw new RuntimeException("队列里没有元素");
                }
                transfer();
            }
            return stackB.peek();
        }

        private void transfer() {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }

        public boolean empty() {
            return stackA.isEmpty() && stackB.isEmpty();
        }
    }
}
