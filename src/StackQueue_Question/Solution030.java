package StackQueue_Question;

import java.util.Stack;

public class Solution030 {


    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();


    /**
     * 包含min函数的栈
     * @param node
     */
    public void push(int node) {
        stackData.push(node);
        if (stackMin.empty()) {
            stackMin.push(node);
        } else {
            if (node <= stackMin.peek()) {
                stackMin.push(node);
            } else {
                stackMin.push(stackMin.peek());
            }
        }
    }

    public void pop() {
        stackData.pop();
        stackMin.pop();
    }


    public int top() {
        return stackData.peek();
    }

    public int min() {
        return stackMin.peek();
    }


    public static void main(String[] args) {
        Solution030 solution = new Solution030();
        solution.push(3);
        solution.push(4);
        solution.push(5);
        System.out.println("栈顶元素为:"+solution.top());
        System.out.println("最小值为:"+solution.min());
    }
}
