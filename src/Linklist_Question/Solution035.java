package Linklist_Question;

public class Solution035 extends RandomLinkListed{


    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
        RandomListNode currentNode = pHead;
        //复制节点，放在原节点后
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }
        //将复制的节点同原节点所连接节点的复制节点相连。
        currentNode = pHead;
        while(currentNode != null){
            currentNode.next.random = currentNode.random == null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //拆分长链表为两个链表。
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null){
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null:cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }

}
