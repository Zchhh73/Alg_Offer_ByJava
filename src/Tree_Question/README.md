* [树和二叉树](/src/Tree_Question)
    * [树的三种遍历(6种实现方法)](MyTree.java)
    * [007--重建二叉树](Solution007.java)
    * [008--二叉树的下一个结点](Solution008.java)
    * [026--树的子结构](Solution026.java)
    * [027--二叉树的镜像](Solution027.java)
    * [028--对称的二叉树](Solution028.java)
    * [032(2)--分行从上到下打印二叉树](Solution032_2.java)
    * [032(3)--之字形打印二叉树](Solution032_3.java)
    * [033--二叉树的后序遍历序列](Solution033.java)
    * [034--二叉树中和为某一值的路径](Solution034.java)
    * [036--二叉搜索树和双向链表](Solution036.java)
    * [037--序列化二叉树](Solution037.java)
    * [054--二叉搜索树第k大节点](Solution054.java)
    * [055(1)--二叉树的深度](Solution055_1.java)
    * [055(2)--平衡二叉树](Solution055_2.java)



解题思路
------
&nbsp;&nbsp;在计算机科学中，树是一种抽象数据类型（ADT）或是实现这种抽象数据类型的数据结构，用来模拟具有树状结构性质的数据集合。树的结构特点：除根节点之外每个节点只有一个父节点，根节点没有父节点；除叶节点之外所有节点都有一个或多个子节点，叶节点没有子节点。<br>
&nbsp;&nbsp;Java中的树集TreeSet类是一个有序集合。可以以任意顺序将元素插入到集合中，在对集合进行遍历时，每个值将自动地按照排序后的顺序呈现。TreeSet的排序是用红黑树结构完成的，每次将一个元素添加到树中，都被放置在正确的排序位置上。<br>

### [树的三种遍历方式及实现](MyTree.java)
&nbsp;&nbsp;这里介绍了二叉树的三种遍历方法，分别是先序遍历，中序遍历和后序遍历，分别采用递归和非递归的方法实现。二叉树遍历是高频率的面试题，因此一定要掌握六种遍历方式，在此基础上才会出现题目设计思路的变化。

### [007--重建二叉树](Solution007.java)
&nbsp;&nbsp;本题输入二叉树的前序和中序遍历结果，重建二叉树。在前序遍历序列中，第一个数字为树根节点的值；在中序遍历序列中，根节点值在序列的中间，根前边的值都属于左子树，右边的值都属于右子树。左子树和右子树同样按照前序和中序遍历的序列进行递归操作，实现重建二叉树功能。<br>

### [008--二叉树的下一个结点](Solution008.java)
&nbsp;&nbsp;本题要求找出中序遍历序列的下一个节点。分几种情况讨论：<br/>
（1）如果一个节点有右子树，那么它的下一个节点就是它的右子树的最左子节点。<br/>
（2）如果一个节点没有右子树，且该节点是它父亲节点的左子节点，那么它的下一个节点为它的父节点。<br/>
（3）如果一个节点没有右子树，且该节点是它的父节点的右子节点，由题意给了一个指向父节点的指针next,沿着指向父节点的指针一直向上遍历，直到找到一个是它的父节点的左子节点的节点。若存在，那么该节点的父节点为下一个我们要找的节点。<br/>

### [026--树的子结构](Solution026.java)
&nbsp;&nbsp;大致分两步：首先在树A中找到和树B的根节点值相等的节点，采用递归的方法对树进行遍历。然后判断树A中以该节点为根的子树是不是包含和树B一样的结构，同样也可以使用递归的思路，若子树根节点的值与B的值不同，则该子树和树B肯定不具有相同的节点；若子树根节点的值与B的值相同，则递归地判断他们各自的左右子节点值是否相同，递归的终止条件是到达树B或者树A的叶子节点。<br>

### [027--二叉树的镜像](Solution027.java)
&nbsp;&nbsp;先序遍历树中每个节点，如果遍历的节点有子节点，就交换子节点。当交换完所有非叶节点的左，右子节点后，得到二叉树的镜像。<br>

### [028--对称的二叉树](Solution028.java)
&nbsp;&nbsp;对于该二叉树的左子树的遍历顺序总是根左右，对于右子树的遍历顺序总是根右左，并将遍历结果分别存入两个链表中比较。相同则将元素移出链表，最后判断两个链表是否均为空，是则返回true，反之返回false。<br>

### [032(2)--分行从上到下打印二叉树](Solution032_2.java)
&nbsp;&nbsp;借助队列遍历二叉树，并借助HashMap用来保存节点深度值。从根节点开始，将遍历的节点放入队头，当队列非空时，从队尾取元素，若该元素有子节点，则依次加入队列。将每一行的元素按深度值都保存为一个sublist，该sublist表示为一行的元素值，最后又由一个存储list的列表根据sublist的添加顺序打印出来。<br>

### [032(3)--之字形打印二叉树](Solution032_3.java)
&nbsp;&nbsp;该题思路就是借助双栈实现。在打印某一层的节点时，把下一层的子节点保存到相应栈中。若当前打印奇数层，则先保存左子节点再保存右子节点到第一个栈中；若当前打印偶数层，则先保存右子节点再保存左子节点到第二个栈中。<br>  

### [033--二叉搜索树的后序遍历序列](Solution033.java)
&nbsp;&nbsp;在后序遍历得到的序列中，最后一个数字是树的根节点的值。数组中前面的数字可以分为两部分，一部分是左子树节点，它们的值比根节点（最后一个数的值小）；另一部分是右子树节点，它们的值比根节点（最后一个数的值大）。确定左右子树之后，再用同样的方法来判断它们的子树是否具有相同属性，即用递归的方法来判断该序列是否为二叉树的后序遍历序列<br>  

### [034--二叉树中和为某一值的路径](Solution034.java)
&nbsp;&nbsp;此题输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。使用前序遍历，当遍历到某一个节点时将该节点添加到路径上，并累加该节点的值。若该节点为叶节点，且路径中节点值的和刚好等于输入的整数，那么就符合要求并打印；如果是非叶节点，则访问子节点。这里使用递归的方法。<br>  

### [036--二叉搜索树和双向链表](Solution036.java)
&nbsp;&nbsp;二叉树中，每个节点都有两个指向子节点的指针；在双向链表中，每个节点也有两个指针pre,next;因此在转换为排序双向链表时，将原先指向左子节点的指针调整为链表中指向前一个节点的指针，原先指向左子节点的指针调整为链表中指向后一个节点的指针。实现方法是中序遍历二叉树，将节点保存到数组，再转换为双向链表。<br>

### [037--序列化二叉树](Solution037.java)
&nbsp;&nbsp;若二叉树的序列化是从根节点开始的，那么相应的反序列化在根节点的数值读出来时就开始。因此可以根据前序遍历顺序来序列化二叉树，因为前序遍历从根节点开始，并且遇到空指针时可以用“#”代替，节点数值之间用“，”隔开。<br> 
&nbsp;&nbsp;反序列化二叉树过程中，是指根据前序遍历得到的序列化字符串结果，重构该二叉树。序列化和反序列化都是递归的过程。<br>  

### [054--二叉搜索树第k大节点](Solution054.java)
&nbsp;&nbsp;使用中序遍历一棵二叉搜索树能得到一个升序排列，就可以轻松找到第K大的值<br>  

### [055(1)--二叉树的深度](Solution055_1.java)
&nbsp;&nbsp;如果一棵树只哟一个节点，则深度为1；若根节点只有左子树而没有右子树，则深度为左子树深度加1；如果根节点只有右子树而没左子树，则深度为右子树深度加1；如果左右子树都有，则深度为左右子树深度的较大值加1。用递归可轻松实现<br>  

### [055(2)--平衡二叉树](Solution055_2.java)
&nbsp;&nbsp;用后序遍历方法遍历二叉树的每个节点，则在遍历到一个节点之前就已经遍历到它的左，右子树。只要遍历每个节点的时候记录深度，就可以一边遍历一边判断每个节点是否平衡。<br>  
