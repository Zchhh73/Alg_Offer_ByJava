package Tree_Question;

import java.util.ArrayList;
import java.util.Stack;

public class Solution032_3 extends Tree{

    /**
     * 之字形打印二叉树
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack1 = new Stack<TreeNode>();//奇数层
        Stack<TreeNode> stack2 = new Stack<TreeNode>();//偶数层
        if(pRoot == null) return results;
        stack1.push(pRoot);
        while(stack1.size()!=0 || stack2.size()!=0){
            if(stack1.size()!=0){
                TreeNode node = stack1.peek();
                if(node.lChild!=null){
                    stack2.push(node.lChild);
                }
                if(node.rChild!=null){
                    stack2.push(node.rChild);
                }
                result.add(stack1.pop().data);
                if(stack1.size()==0){
                    ArrayList<Integer> currentResult = new ArrayList<Integer>();
                    for(int i=0;i<result.size();i++){
                        currentResult.add(result.get(i));
                    }
                    results.add(currentResult);
                    while(result.size()>0){
                        result.remove(0);
                    }
                }
            }else{
                while(true){
                    TreeNode node = stack2.peek();
                    if(node.rChild!=null){
                        stack1.push(node.rChild);
                    }
                    if(node.lChild!=null){
                        stack1.push(node.lChild);
                    }
                    result.add(stack2.pop().data);
                    if(stack2.size()==0){
                        ArrayList<Integer> currentResult = new ArrayList<Integer>();
                        for(int i=0;i<result.size();i++){
                            currentResult.add(result.get(i));
                        }
                        results.add(currentResult);
                        while(result.size()>0){
                            result.remove(0);
                        }
                        break;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        TreeNode t1_nine = new TreeNode(9,null,null);
        TreeNode t1_two = new TreeNode(2,null,null);
        TreeNode t1_eight = new TreeNode(8,t1_nine,t1_two);
        TreeNode t1_seven = new TreeNode(7,null,null);
        TreeNode t1_root = new TreeNode(8,t1_eight,t1_seven);
        Solution032_3 solution = new Solution032_3();
        System.out.println(solution.Print(t1_root));
        /* 8
           7 8
           9 2
         */

    }
}
