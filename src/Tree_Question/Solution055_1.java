package Tree_Question;

public class Solution055_1 extends Tree {

    /**
     * 树的深度
     *
     * @param root
     * @return
     */
    private int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = TreeDepth(root.lChild);
        int rightDepth = TreeDepth(root.rChild);
        int result = 1 + ((leftDepth > rightDepth) ? leftDepth : rightDepth);
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1_eight = new TreeNode(8, null, null);
        TreeNode t1_six = new TreeNode(6, null, null);
        TreeNode t1_four = new TreeNode(4, null, null);
        TreeNode t1_two = new TreeNode(2, null, null);
        TreeNode t1_seven = new TreeNode(7, t1_six, t1_eight);
        TreeNode t1_three = new TreeNode(3, t1_two, t1_four);
        TreeNode root = new TreeNode(5, t1_three, t1_seven);
        Solution055_1 solution = new Solution055_1();
        System.out.println("树的深度为"+solution.TreeDepth(root));
    }
}
