package Linklist_Question;


public class Solution024 extends LinkListed {


    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        Solution024 list = new Solution024();
        list.addNode(2);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        ListNode head = list.head;
        ListNode last = list.ReverseList(head);
        while (last != null) {
            System.out.print(last.val + " ");
            last = last.next;
        }
    }

}
