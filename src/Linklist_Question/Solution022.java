package Linklist_Question;

import java.util.LinkedList;

public class Solution022 extends LinkListed{

    /**
     * 链表中倒数第k个节点
     * 设快慢指针，快指针先走k-1步，再同步走
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        Solution022 list = new Solution022();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        LinkListed.ListNode head = list.head;
        LinkListed.ListNode num = list.FindKthToTail(head,2);
        System.out.print(num.val);








    }
}