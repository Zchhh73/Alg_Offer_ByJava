package Linklist_Question;

public class RandomLinkListed {

    private RandomListNode head = null;

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /**
     * 向链表中插入数据
     *
     * @param data
     */
    public void addNode(int data) {
        RandomListNode newNode = new RandomListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        RandomListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
}
