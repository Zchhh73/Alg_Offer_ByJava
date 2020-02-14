package Tree_Question;

public class Tree {

    public static class TreeNode {
        /**
         * 定义树节点类型
         */
         int data;
         TreeNode lChild;
         TreeNode rChild;

        public TreeNode(int data, TreeNode lChild, TreeNode rChild) {
            this.data = data;
            this.lChild = lChild;
            this.rChild = rChild;
        }

        public TreeNode(int data){
            this.data = data;
        }
    }

    private TreeNode root = null;

}
