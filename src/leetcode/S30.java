package leetcode;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * @author Billy
 * @date 2020/7/26 3:24 下午
 */
public class S30 {
    /**
     * mainStack用于栈基本操作
     * minStack用于保存最小值
     * <p>
     * 时间复杂度：O(1)
     * 空间复杂度：O(n)
     */
    static class MinStack {
        private Stack<Integer> mainStack;
        private Stack<Integer> minStack;

        public MinStack() {
            mainStack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            mainStack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (mainStack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            mainStack.pop();
        }

        public int top() {
            return mainStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

    public static void main(String[] args) throws Exception {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.min();
        System.out.println(param_4);
    }
}


