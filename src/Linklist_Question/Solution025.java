package Linklist_Question;

public class Solution025 extends LinkListed{


    /**
     * 实现合并两个有序链表
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        //创建合并后链表
        ListNode newList = new ListNode(-1);
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p3 = newList;
        while (p1 != null && p2 != null){
            if(p1.val<p2.val){
                p3.next = p1;
                p1 = p1.next;
            }else{
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }
        while(p1 != null){
            p3.next = p1;
            p1 = p1.next;
            p3 = p3.next;
        }
        while(p2 != null){
            p3.next = p2;
            p2 = p2.next;
            p3 = p3.next;
        }
        return newList.next;
    }


    public static void main(String[] args) {
        Solution025 linkedlist1 = new Solution025();
        Solution025 linkedlist2 = new Solution025();
        Solution025 mergedLinkedList = new Solution025();
        linkedlist1.addNode(1);
        linkedlist1.addNode(4);
        linkedlist1.addNode(6);
        linkedlist1.addNode(7);
        linkedlist2.addNode(2);
        linkedlist2.addNode(5);
        linkedlist2.addNode(6);
        ListNode head1 = linkedlist1.head;
        ListNode head2 = linkedlist2.head;
        ListNode newHead = mergedLinkedList.Merge(head1,head2);
        while(newHead!=null){
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }





    }
}
