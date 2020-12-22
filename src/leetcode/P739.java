package leetcode;

import java.util.Stack;

import static leetcode.Util.printArray;

/**
 * 739. 每日温度
 *
 * @author Billy
 * @date 2020/8/2 3:29 下午
 */
public class P739 {
    /**
     * 维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。如果一个下标在单调栈里，则表示尚未找到下一次温度更高的下标。
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int length = T.length;
        int[] res = new int[length];
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            //栈不为空或当前元素大于栈顶元素，取出栈顶并计算结果
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        printArray(dailyTemperatures(temperatures));
    }
}
