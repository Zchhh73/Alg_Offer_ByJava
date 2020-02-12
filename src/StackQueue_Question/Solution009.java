package StackQueue_Question;

import java.util.Stack;

public class Solution009 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        //测试用例
        Solution009 solution = new Solution009();
        for (int i = 0; i <= 3; i++) {
            solution.push(i);
        }
        for (int i = 0; i <= 3; i++) {
            System.out.print(solution.pop() + " ");
        }



    }


}
