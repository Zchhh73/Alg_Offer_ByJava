package Tree_Question;

public class Solution008{

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val,TreeLinkNode left,TreeLinkNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 中序遍历二叉树的下一个节点
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) {
                pRight = pRight.left;
            }
            return pRight;
        }

        if (pNode.next != null && pNode.next.left == pNode) {
            return pNode.next;
        }

        if (pNode.next != null) {
            TreeLinkNode pNext = pNode.next;
            while (pNext.next != null && pNext.next.right == pNext) {
                pNext = pNext.next;
            }
            return pNext.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution008 solution = new Solution008();
        TreeLinkNode nodeF = new TreeLinkNode(6,null,null);
        TreeLinkNode nodeE = new TreeLinkNode(5,null,null);
        TreeLinkNode nodeC = new TreeLinkNode(3,nodeF,null);
        TreeLinkNode nodeB = new TreeLinkNode(2,null,nodeE);
        TreeLinkNode nodeA = new TreeLinkNode(1,nodeB,nodeC);
        nodeF.next = nodeC;
        nodeE.next = nodeB;
        nodeB.next = nodeA;
        nodeC.next = nodeA;
        TreeLinkNode result = solution.GetNext(nodeE);
        System.out.println(result.val);






    }
}
