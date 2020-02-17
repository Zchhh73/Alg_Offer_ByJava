package Tree_Question;

public class Solution037 extends Tree {

    int i = -1;

    private String Serialize(TreeNode root) {
        //用先序遍历顺序来序列化二叉树。遇到空时用“#”代替，用“，”隔开。
        if (root == null) {
            return "#";
        } else {
            return root.data + "," + Serialize(root.lChild) + "," + Serialize(root.rChild);
        }
    }

    public TreeNode Deserialize(String str) {
        String[] s = str.split(",");
        i++;
        int len = s.length;
        if (i > len) return null;
        TreeNode node = null;
        if(!s[i].equals("#")){
            node = new TreeNode(Integer.parseInt(s[i]));
            node.lChild = Deserialize(str);
            node.rChild = Deserialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode t1_four = new TreeNode(4,null,null);
        TreeNode t1_seven = new TreeNode(7,null,null);
        TreeNode t1_five = new TreeNode(5,t1_four,t1_seven);
        TreeNode t1_twelve = new TreeNode(12,null,null);
        TreeNode root = new TreeNode(10,t1_five,t1_twelve);
        Solution037 solution = new Solution037();
        String tree_txt = solution.Serialize(root);
        TreeNode txt2node = solution.Deserialize(tree_txt);
        System.out.println("系列化后为："+tree_txt);
        System.out.printf("反序列化后的根节点及左右孩子：%d,%d,%d",txt2node.data,txt2node.lChild.data,txt2node.rChild.data);
    }
}
