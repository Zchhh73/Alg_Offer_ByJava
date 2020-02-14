package Tree_Question;

public class Solution026 extends Tree{

    /**
     * 树的子结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null ||root2==null){
            return false;
        }
        return judgeSubTree(root1,root2)|| judgeSubTree(root1.lChild,root2)|| judgeSubTree(root1.rChild,root2);
    }

    private boolean judgeSubTree(TreeNode root1,TreeNode root2){
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.data != root2.data){
            return judgeSubTree(root1.lChild,root2) || judgeSubTree(root1.rChild,root2);
        }
        return judgeSubTree(root1.lChild,root2.lChild) && judgeSubTree(root1.rChild,root2.rChild);
    }

    public static void main(String[] args) {
        Solution026 solution = new Solution026();
        //第一棵树
        TreeNode t1_nine = new TreeNode(9,null,null);
        TreeNode t1_two = new TreeNode(2,null,null);
        TreeNode t1_eight = new TreeNode(8,t1_nine,t1_two);
        TreeNode t1_seven = new TreeNode(7,null,null);
        TreeNode t1_root = new TreeNode(8,t1_eight,t1_seven);
        //第二棵树
        TreeNode t2_two = new TreeNode(2,null,null);
        TreeNode t2_nine = new TreeNode(9,null,null);
        TreeNode t2_root = new TreeNode(8,t2_nine,t2_two);
        System.out.println(solution.HasSubtree(t1_root,t2_root));
    }
}
