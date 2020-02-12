* [链表部分](#链表部分)
    * [006--从尾到头打印链表](/src/Linklist_Question/Solution006.java)
    * [018--删除链表中的重复节点](/src/Linklist_Question/Solution018.java)
    * [022--链表中倒数第k个接节点](/src/Linklist_Question/Solution022.java)
    * [024--反转链表](/src/Linklist_Question/Solution024.java)
    * [025--合并两个排序的链表](/src/Linklist_Question/Solution025.java)
    * [035--复杂链表的复制](/src/Linklist_Question/Solution035.java)
    * [052--两个链表的第一个公共节点](/src/Linklist_Question/Solution052.java)
    
    
解题思路
------
### 006--从尾到头打印链表
&nbsp;&nbsp;书上的思路是借助栈来实现，把链表的每个节点入栈，然后再从栈顶依次输出节点的值。


&nbsp;&nbsp;而我借助Java的ArrayList类实现。ArrayList是集合的一种实现，实现了List接口，底层的数据结构是数组。对ArrayList类的实例的所有操作底层都是基于数组。本题的实现思路就是通过ArrayList实例list的add(int index,Integer element)方法，将链表的每个元素添加到list的第一个位置，类似于头插法。然后顺序输出，实现从尾到头打印链表
    
   
   
    
