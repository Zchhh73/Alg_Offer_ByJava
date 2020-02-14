package Tree_Question;

public class Solution027 extends Tree{

    /**
     * 二叉树的镜像
     * @param root
     */
    public void Mirror(TreeNode root) {
        if(root == null) return;
        if(root.lChild==null && root.rChild==null) return;
        TreeNode temp = root.lChild;
        root.lChild = root.rChild;
        root.rChild = temp;
        Mirror(root.lChild);
        Mirror(root.rChild);
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5,null,null);
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node9 = new TreeNode(9,null,null);
        TreeNode node11 = new TreeNode(11,null,null);
        TreeNode node6 = new TreeNode(6,node5,node7);
        TreeNode node10 = new TreeNode(10,node9,node11);
        TreeNode root = new TreeNode(8,node6,node10);

        Solution027 solution = new Solution027();
        System.out.printf("镜像前根节点左右子节点值为 根：%d,左：%d,右：%d\n",root.data,root.lChild.data,root.rChild.data);
        solution.Mirror(root);
        System.out.printf("镜像后根节点左右子节点值为 根：%d,左：%d,右：%d",root.data,root.lChild.data,root.rChild.data);






    }
}
