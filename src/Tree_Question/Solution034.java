package Tree_Question;

import java.util.ArrayList;
import java.util.List;

public class Solution034 extends Tree {
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    private ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return result;
        list.add(root.data);
        target = target - root.data;
        if (target == 0 && root.lChild == null && root.rChild == null){
            result.add(new ArrayList<Integer>(list));
        }
        ArrayList<ArrayList<Integer>> result1 = FindPath(root.lChild,target);
        ArrayList<ArrayList<Integer>> result2 = FindPath(root.rChild,target);
        list.remove(list.size()-1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1_four = new TreeNode(4,null,null);
        TreeNode t1_seven = new TreeNode(7,null,null);
        TreeNode t1_five = new TreeNode(5,t1_four,t1_seven);
        TreeNode t1_twelve = new TreeNode(12,null,null);
        TreeNode root = new TreeNode(10,t1_five,t1_twelve);
        Solution034 solution = new Solution034();
        ArrayList<ArrayList<Integer>> results = solution.FindPath(root,22);
        System.out.println(results);
    }
}
