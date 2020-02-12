package Linklist_Question;

public class Solution023 extends LinkListed{

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        //判断是否有环
        ListNode fast = pHead;
        ListNode slow = pHead;
        boolean flag = false;
        while(fast != null & fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                flag = true;
                break;
            }
        }
        //无环返回null，否则得到环中节点数目
        if(!flag){
            return null;
        }else{
            int n = 1;
            fast = fast.next;
            while(fast != slow){
                n++;
                fast = fast.next;
            }
            //找到入口
            fast = pHead;
            slow = pHead;
            for(int i=0 ; i<n ; i++){
                fast = fast.next;
            }
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }

    }
}
