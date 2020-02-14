package Tree_Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyTree {

    private Node root = null;

    private class Node {
        /**
         * 定义树节点类型
         */
        private int data;
        private Node lChild;
        private Node rChild;

        public Node(int data, Node lChild, Node rChild) {
            this.data = data;
            this.lChild = lChild;
            this.rChild = rChild;
        }
    }

    public MyTree() {
        init();
    }


    private void init() {
        Node e = new Node(5, null, null);
        Node d = new Node(4, null, null);
        Node c = new Node(3, null, null);
        Node b = new Node(2, d, e);
        Node a = new Node(1, b, c);
        root = a;
    }

    private List<Node> list = new ArrayList<Node>();

    public List<Node> getList() {
        return list;
    }

    /**
     * 先序遍历(递归):12453
     *
     * @param node
     * @return
     */
    public boolean preorderTraverse(Node node) {
        list.add(node);
        if (node.lChild != null) {
            preorderTraverse(node.lChild);
        }
        if (node.rChild != null) {
            preorderTraverse(node.rChild);
        }
        return true;
    }

    /**
     * 先序遍历(非递归)：借助栈实现
     *
     * @param root
     */
    public void preOrder(Node root) {
        if(root == null){
            System.out.print("空树");
            return;
        }
        Node temp = root;
        Stack<Node> s = new Stack<Node>();
        //根节点入栈
        s.push(temp);
        while(!s.empty()){
            //访问根节点
            Node p = s.pop();
            System.out.print(p.data+" ");
            //若存在右孩子，入栈；若存在左孩子，入栈
            if(p.rChild!=null){
                s.push(p.rChild);
            }
            if(p.lChild!=null){
                s.push(p.lChild);
            }
        }
        System.out.println();
    }


    /**
     * 中序遍历(递归):42513
     *
     * @param node
     * @return
     */
    public boolean inorderTraverse(Node node) {
        if (node.lChild != null) {
            inorderTraverse(node.lChild);
        }
        list.add(node);
        if (node.rChild != null) {
            inorderTraverse(node.rChild);
        }
        return true;
    }

    /**
     * 中序遍历(非递归)：
     *
     * @param root
     */
    public void inOrder(Node root) {
        if(root == null){
            System.out.print("空树");
            return;
        }
        Node temp = root;
        Stack<Node> s = new Stack<Node>();
        while(temp!=null || !s.empty()){
            while(temp!=null){
                //将根节点入栈，将所有左孩子入栈
                s.push(temp);
                temp = temp.lChild;
            }
            //访问栈顶元素
            temp = s.pop();
            System.out.print(temp.data+" ");
            //若有右孩子，则入栈，否则为空
            if(temp.rChild!=null){
                temp = temp.rChild;
            }else{
                temp = null;
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历(递归)：45231
     *
     * @param node
     * @return
     */
    public boolean postorderTraverse(Node node) {
        if (node.lChild != null) {
            postorderTraverse(node.lChild);
        }
        if (node.rChild != null) {
            postorderTraverse(node.rChild);
        }
        list.add(node);
        return true;
    }

    /**
     * 后序遍历(非递归)：
     *
     * @param root
     */
    public void postOrder(Node root) {
        if(root == null){
            System.out.print("空树");
            return;
        }
        Node temp = root;
        Node prev = null;
        Stack<Node> s = new Stack<Node>();
        while(temp!=null || !s.empty()){
            while(temp!=null){
                s.push(temp);
                temp = temp.lChild;
            }
            if(!s.empty()){
                //取栈顶元素
                temp = s.peek();
                //没有右孩子，或已被访问
                if(temp.rChild==null||temp.rChild==prev){
                    temp = s.pop();
                    System.out.print(temp.data+" ");
                    prev = temp;
                    temp = null;
                }else{
                    temp = temp.rChild;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyTree mt = new MyTree();
        mt.preOrder(mt.root);
        mt.inOrder(mt.root);
        mt.postOrder (mt.root);
//        if (mt.preorderTraverse(mt.root)) System.out.print("先序遍历结果：");
//        if (mt.inorderTraverse(mt.root)) System.out.print("中序遍历结果：");
//        if (mt.postorderTraverse(mt.root)) System.out.print("后序遍历结果：");
//        for (Node node : mt.getList()) {
//            System.out.print(node.data);
//        }
    }
}
