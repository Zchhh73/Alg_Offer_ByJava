package StackQueue_Question;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution032 {

    public static class TreeNode {
        int val ;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 从上打印二叉树(层次遍历，借助队列)
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null){
            //空树返回空Linkedlist
            return list;
        }
        TreeNode cur = root;
        queue.offer(cur);
        while(!queue.isEmpty()){
            cur = queue.poll();
            list.add(cur.val);
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!= null){
                queue.offer(cur.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution032 solution = new Solution032();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;
        System.out.println(solution.PrintFromTopToBottom(root));


    }
}
