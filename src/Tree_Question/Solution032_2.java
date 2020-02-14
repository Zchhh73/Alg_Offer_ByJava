package Tree_Question;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;


public class Solution032_2 extends Tree {

    /**
     * 分行从上到下打印二叉树
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        if (pRoot == null) return lists;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addFirst(pRoot);
        map.put(pRoot, 0);
        while (!queue.isEmpty()) {
            pRoot = queue.pollLast();
            int deep = map.get(pRoot);
            if (pRoot.lChild != null) {
                queue.addFirst(pRoot.lChild);
                map.put(pRoot.lChild, deep + 1);
            }
            if (pRoot.rChild != null) {
                queue.addFirst(pRoot.rChild);
                map.put(pRoot.rChild, deep + 1);
            }
            if (lists.size() <= deep) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(pRoot.data);
                lists.add(list);
            } else {
                ArrayList<Integer> list = lists.get(deep);
                list.add(pRoot.data);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        TreeNode t1_nine = new TreeNode(9,null,null);
        TreeNode t1_two = new TreeNode(2,null,null);
        TreeNode t1_eight = new TreeNode(8,t1_nine,t1_two);
        TreeNode t1_seven = new TreeNode(7,null,null);
        TreeNode t1_root = new TreeNode(8,t1_eight,t1_seven);
        Solution032_2 solution = new Solution032_2();
        System.out.println(solution.Print(t1_root));
        /*8
          8 7
          9 2
         */

    }
}
