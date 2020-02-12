package Linklist_Question;


import java.util.HashSet;

public class Solution018 extends LinkListed {

    /**
     * 删除链表中的重复节点
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //第一次遍历，找出相同节点送到set
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = pHead;
        ListNode cur = pHead.next;
        while (cur != null) {
            if (cur.val == pre.val) {
                set.add(cur.val);
            }
            pre = cur;
            cur = cur.next;
        }
        //二次遍历，寻找链表中相同元素，移出链表
        while (pHead != null && set.contains(pHead.val)) {
            pHead = pHead.next;
        }
        if (pHead == null) {
            return null;
        }
        pre = pHead;
        cur = pHead.next;
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }


    private static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Solution018 list = new Solution018();
        list.addNode(1);
        list.addNode(2);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.deleteDuplication(list.head);
        print(list.head);
    }
}
