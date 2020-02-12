package Linklist_Question;

import java.util.ArrayList;


public class Solution006 {

    /**
     * 链表节点数据结构的定义
     */
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 实现从尾到头打印链表
     *
     * @param listNode
     * @return
     */
    public ArrayList<Integer> PrintListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = listNode;
        while (temp != null) {
            list.add(0, temp.val);
            temp = temp.next;
        }
        return list;
    }


    public static void main(String[] args) {
        Solution006 solution = new Solution006();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        for (int i : solution.PrintListFromTailToHead(l1)) {
            System.out.print(i + " ");
        }
    }


}

