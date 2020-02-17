package Tree_Question;

public class Solution055_2 extends Tree {

    /**
     * 平衡二叉树判定
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return Depth(root) != -1;
    }

    public int Depth(TreeNode root) {
        if (root == null) return 0;
        int left = Depth(root.lChild);
        if (left == -1) return -1;
        int right = Depth(root.rChild);
        if (right == -1) return -1;
        if (Math.abs(left-right)>1) {
            return -1;
        }else{
            return 1+((left>right)?left:right);
        }
    }

    public static void main(String[] args) {
        TreeNode t1_eight = new TreeNode(8, null, null);
        TreeNode t1_six = new TreeNode(6, null, null);
        TreeNode t1_four = new TreeNode(4, null, null);
        TreeNode t1_two = new TreeNode(2, null, null);
        TreeNode t1_seven = new TreeNode(7, t1_six, t1_eight);
        TreeNode t1_three = new TreeNode(3, t1_two, t1_four);
        TreeNode root = new TreeNode(5, t1_three, t1_seven);
        Solution055_2 solution = new Solution055_2();
        System.out.println(solution.IsBalanced_Solution(root));
    }
}
