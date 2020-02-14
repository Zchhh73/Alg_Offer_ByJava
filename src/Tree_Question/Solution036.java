package Tree_Question;

import java.util.ArrayList;

public class Solution036 extends Tree{

    /**
     * 将二叉搜索树转换成一个排序的双向链表
     *
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        //中序遍历二叉树，将节点保存到数组，再转换为双向链表
        if (pRootOfTree == null) return null;
        ArrayList<TreeNode> list = new ArrayList<>();
        InOrderAndAddList(pRootOfTree, list);
        return ConvertList(list);
    }

    public void InOrderAndAddList(TreeNode root, ArrayList<TreeNode> list) {
        if (root.lChild != null) {
            InOrderAndAddList(root.lChild, list);
        }

        list.add(root);

        if (root.rChild != null) {
            InOrderAndAddList(root.rChild, list);
        }
    }

    public TreeNode ConvertList(ArrayList<TreeNode> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).rChild = list.get(i + 1);
            list.get(i + 1).lChild = list.get(i);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution036 tree = new Solution036();
        TreeNode node4 = new TreeNode(7,null,null);
        TreeNode node3 = new TreeNode(5,null,null);
        TreeNode node2 = new TreeNode(8,node4,null);
        TreeNode node1 = new TreeNode(4,null,node3);
        TreeNode root = new TreeNode(6,node1,node2);

        TreeNode node = tree.Convert(root);
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.rChild;
        }
    }
}
