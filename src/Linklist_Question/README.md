* [链表部分](#链表部分)
    * [006--从尾到头打印链表](/src/Linklist_Question/Solution006.java)
    * [018--删除链表中的重复节点](/src/Linklist_Question/Solution018.java)
    * [022--链表中倒数第k个节点](/src/Linklist_Question/Solution022.java)
    * [023--链表中环的入口](/src/Linklist_Question/Solution023.java)
    * [024--反转链表](/src/Linklist_Question/Solution024.java)
    * [025--合并两个排序的链表](/src/Linklist_Question/Solution025.java)
    * [035--复杂链表的复制](/src/Linklist_Question/Solution035.java)
    * [052--两个链表的第一个公共节点](/src/Linklist_Question/Solution052.java)
    
    
解题思路
------
### [006--从尾到头打印链表](Solution006.java)
&nbsp;&nbsp;书上的思路是借助栈来实现，把链表的每个节点入栈，然后再从栈顶依次输出节点的值。


&nbsp;&nbsp;我借助Java的ArrayList类实现。ArrayList是集合的一种实现，实现了List接口，底层的数据结构是数组，是非线程安全的。对ArrayList类的实例的所有操作底层都是基于数组。本题的实现思路就是通过ArrayList实例list的add(int index,Integer element)方法，将链表的每个元素添加到list的第一个位置，类似于头插法。然后顺序输出，实现从尾到头打印链表。


### [018--删除链表节点&删除链表中的重复节点](Solution018.java)
&nbsp;&nbsp;书上的思路是通过两个指针，一个是指向当前节点的pNode指针，另一个是指向当前节点前一个节点的pPreNode指针。当pNode指针与下一个节点值相同，即为重复节点，为待删节点。把当前节点的前一个节点pPreNode指针指向后面值不为待删节点的节点，实现删除重复节点功能。


&nbsp;&nbsp;我借助Java的HashSet类实现。Java中Set类继承于Collection接口，它不允许出现重复元素并且是无序的集合，主要有HashSet和TreeSet两个实现类。HashSet是哈希表结构，利用HashMap的Key来存储元素，计算插入元素的hashcode来获取元素在集合中的位置。HashSet实现Set接口，基于HashMap实现，存储唯一元素并允许空值，它不是非线程安全的。


&nbsp;&nbsp;该题的实现思路是首先遍历链表，找出相同的节点将其添加到到HashSet的set实例中。在这里使用的是add(E e)方法，HashSet的add方法调用的是底层HashMap的put()方法，首先判断元素是否存在，若不存在则插入，若存在则不插入。然后再次遍历链表，找到链表中的相同元素，将它们从列表中移除，实现此功能。


### [022--链表中倒数第k个节点](Solution022.java)
&nbsp;&nbsp;定义两个指针，第一个指针从链表的头指针开始遍历向前走k-1步，第二个指针保持不动。从第k步开始，第二个指针开始从链表的头指针开始遍历。因为两个指针之间的距离为k-1，所以当第一个指针到达链表尾节点时，第二个指针正好指向倒数第k个节点。


### [023--链表中环的入口](Solution023.java)
&nbsp;&nbsp;


### [024--反转链表](Solution024.java)
&nbsp;&nbsp;


### [025--合并两个排序的链表](Solution025.java)
&nbsp;&nbsp;


### [035--复杂链表的复制](Solution025.java)
&nbsp;&nbsp;


### [052--两个链表的第一个公共节点](Solution025.java)
&nbsp;&nbsp;







    
   
   
    
