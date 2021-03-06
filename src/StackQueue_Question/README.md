* [栈和队列部分](#栈和队列部分)
    * [009--用两个栈实现队列](/src/StackQueue_Question/Solution009.java)
    * [030--包含min函数的栈](/src/StackQueue_Question/Solution030.java)
    * [031--栈的压入、弹出序列](/src/StackQueue_Question/Solution031.java)
    * [032--从上到下打印二叉树](/src/StackQueue_Question/Solution032.java)
    * [059--滑动窗口&&队列的最大值](/src/StackQueue_Question/Solution059.java)





解题思路
------

栈是一种常见的数据结构，它的特点是后进先出，操作系统中系统会给每个线程创建一个栈存储函数调用时的参数，返回地址和临时变量等。在Java中栈使用Stack类实现，Stack继承自Vector，底层通过数组实现，是线程安全的方法。



队列也是一种重要的数据结构，它的特点是先进先出，即第一个进入队列的元素将会第一个出来。Queue是Java集合框架中定义的一种接口，直接继承自Collection接口。Deque接口继承自Queue接口，但Deque支持同时从两端添加或移除元素，又被称为双端队列。因此Deque接口的实现可以被当做FIFO队列使用，也可以当作栈使用。



### [009--用两个栈实现队列](Solution009.java)
&nbsp;&nbsp;解题思路就是先将元素压入栈1，得到的原来序列的倒序。再将栈1的数据依次从栈顶元素压入栈2，即获得原来的顺序，最后依次出栈即可实现队列功能


### [030--包含min函数的栈](Solution030.java)
&nbsp;&nbsp;解题思路为借助一个辅助栈，这个辅助栈和数据栈同步压入数据。步骤大致为首先将第一个数据同时压入数据栈和辅助栈，当遍历到第二个数据时，在数据栈中将其压入，但在辅助栈中与栈顶元素进行比较。若小于栈顶元素，则将第二个元素压入辅助栈，反之则将栈顶元素再次压入栈，保持和数据栈相同的数据元素个数。这样做可以始终保持辅助栈的栈顶元素为最小，实现时间复杂度O(1)的min函数操作。


### [031--栈的压入、弹出序列](Solution031.java)
&nbsp;&nbsp;同样借助一个辅助栈把输入的第一个序列中的数字依次压入辅助栈中，并按照第二个序列的序列依次从栈中弹出数字。 判断序列是不是栈的弹出序列规律如下：如果下一个弹出的数字刚好是栈顶数字，则直接弹出；若下一个弹出的数字不在栈顶，则把压栈序列中还未入栈的数字压入发辅助栈，直到把下一个需要弹出的数字压入栈顶为止；若所有数字都压入栈后仍没有找到下一个弹出的数字，则该序列不是一个弹出序列。


### [032--从上到下打印二叉树](Solution032.java)
&nbsp;&nbsp;树的的层次遍历算法，需借助队列，规律是每次打印一个节点，若该节点有子节点，则把该节点的子节点放到队列的末尾。再从队列的头部取出最早进入队列的节点，重复此操作直至队列中所有节点都被打印出来。详细请见代码。


### [059--滑动窗口&&队列的最大值](Solution059.java)
&nbsp;&nbsp;借助双端队列Deque类实现，思路是如果新来的值比队尾的值小，则追加到队尾；如果新值比尾部的大，则删掉尾部，再将新值追加到后面；如果追加的值比索引和队列头部值的索引超过滑动窗口大小，则移除队头元素。总要保持队列的队头元素都是滑动窗口中最大的值。详细见代码，可以Debug感受一下过程。
