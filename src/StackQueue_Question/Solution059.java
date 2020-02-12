package StackQueue_Question;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution059 {


    /**
     * 滑动窗口最大值
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length == 0 || size == 0 || size > num.length) return list;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while(!deque.isEmpty() && num[i] >= num[deque.peekLast()]){
                deque.removeLast();
            }
            if(!deque.isEmpty() && i-deque.peekFirst() >= size){
                deque.removeFirst();
            }
            deque.addLast(i);
            if(i >= size-1){
                list.add(num[deque.peekFirst()]);
            }
        }
        return list;
    }

    public static void main(String[] args) {

    }
}

