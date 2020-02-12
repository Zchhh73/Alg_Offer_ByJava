package StackQueue_Question;

import java.util.Stack;

public class Solution031 {

    /**
     * 栈的压入，弹出序列
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0||popA.length != pushA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            //peek方法是返回栈顶的元素但不移除它
            while(!stack.isEmpty() && stack.peek()==popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = new int[]{1,2,3,4,5};
        int[] is_pop = new int[]{4,5,2,3,1};
        Solution031 solution = new Solution031();
        System.out.println(solution.IsPopOrder(push,is_pop));
    }
}
