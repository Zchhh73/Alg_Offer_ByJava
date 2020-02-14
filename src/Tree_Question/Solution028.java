package Tree_Question;

import java.util.LinkedList;

public class Solution028 extends Tree{


    /**
     * 判断二叉树是不是对称的
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null) return true;
        LinkedList<TreeNode> leftList = new LinkedList<>();
        LinkedList<TreeNode> rightList = new LinkedList<>();
        leftList.add(pRoot.lChild);
        rightList.add(pRoot.rChild);
        while(!leftList.isEmpty()&&!rightList.isEmpty()){
            TreeNode leftNode = leftList.poll();
            TreeNode rightNode = rightList.poll();
            if(leftNode==null && rightNode==null)
                continue;
            if(leftNode==null || rightNode==null)
                return false;
            if(leftNode.data!=rightNode.data)
                return false;
            leftList.add(leftNode.lChild);
            leftList.add(leftNode.rChild);

            rightList.add(rightNode.rChild);
            rightList.add(rightNode.lChild);
        }
        return leftList.isEmpty() && rightList.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode node5_l = new TreeNode(5,null,null);
        TreeNode node7_l = new TreeNode(7,null,null);
        TreeNode node7_r = new TreeNode(7,null,null);
        TreeNode node5_r = new TreeNode(5,null,null);
        TreeNode node6_l = new TreeNode(6,node5_l,node7_l);
        TreeNode node6_r = new TreeNode(6,node7_r,node5_r);
        TreeNode root = new TreeNode(8,node6_l,node6_r);

        Solution028 solution = new Solution028();
        System.out.println(solution.isSymmetrical(root));
    }
}
