package Linklist_Question;

public class Solution052 extends LinkListed {


    /**
     * 实现寻找两个递增链表的第一个公共节点
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode FindFirstCommonCode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //寻找公共点
        while (p1.val != p2.val) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1.val != p2.val) {
                //判断谁先走到头，走到头回来继续走另一个链表的部分。时间复杂度O(2n)
                if (p1.next == null) p1.next = pHead2;
                if (p2.next == null) p2.next = pHead1;
            }
        }
        return p1;
    }


    public static void main(String[] args) {
        Solution025 linkedlist1 = new Solution025();
        Solution025 linkedlist2 = new Solution025();
        linkedlist1.addNode(1);
        linkedlist1.addNode(4);
        linkedlist1.addNode(6);
        linkedlist1.addNode(7);
        linkedlist2.addNode(2);
        linkedlist2.addNode(5);
        linkedlist2.addNode(6);
        linkedlist2.addNode(8);
        linkedlist2.addNode(9);
        ListNode list1_head = linkedlist1.head;
        ListNode list2_head = linkedlist2.head;
        ListNode FirstCommonCode = FindFirstCommonCode(list1_head,list2_head);
        System.out.print(FirstCommonCode.val);

    }
}
