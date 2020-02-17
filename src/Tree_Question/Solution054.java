package Tree_Question;

import java.util.ArrayList;

public class Solution054 extends Tree {

    ArrayList<TreeNode> list = new ArrayList<>();

    private TreeNode KthNode(TreeNode root, int k) {
        addNode(root);
        if (k >= 1 && list.size() >= k) {
            return list.get(k - 1);
        }
        return null;
    }

    private void addNode(TreeNode cur) {
        if (cur != null) {
            addNode(cur.lChild);
            list.add(cur);
            addNode(cur.rChild);
        }
    }

    private ArrayList<TreeNode> InOrder(TreeNode cur) {
        if (cur != null) {
            addNode(cur.lChild);
            list.add(cur);
            addNode(cur.rChild);
        }
        return list;
    }



    public static void main(String[] args) {
        TreeNode t1_eight = new TreeNode(8, null, null);
        TreeNode t1_six = new TreeNode(6, null, null);
        TreeNode t1_four = new TreeNode(4, null, null);
        TreeNode t1_two = new TreeNode(2, null, null);
        TreeNode t1_seven = new TreeNode(7, t1_six, t1_eight);
        TreeNode t1_three = new TreeNode(3, t1_two, t1_four);
        TreeNode root = new TreeNode(5, t1_three, t1_seven);
        Solution054 solution1 = new Solution054();
        //打印第K个节点
        TreeNode result = solution1.KthNode(root, 4);
        System.out.println(result.data);
        //中序遍历
        Solution054 solution2 = new Solution054();
        ArrayList<TreeNode> list = solution2.InOrder(root);
        for(TreeNode node:list)
            System.out.print(node.data+" ");

    }
}
