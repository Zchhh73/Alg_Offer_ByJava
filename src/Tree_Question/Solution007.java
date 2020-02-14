package Tree_Question;

import java.util.Arrays;

public class Solution007 extends Tree {

    /**
     * 重建二叉树
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                root.lChild = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.rChild = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        Solution007 solution = new Solution007();
        TreeNode root = solution.reConstructBinaryTree(pre, in);
        System.out.println("根节点为："+root.data);
        System.out.println("根的左孩子节点为："+root.lChild.data);
        System.out.println("根的右孩子节点为："+root.rChild.data);

    }
}

