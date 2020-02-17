package Tree_Question;

public class Solution033 {


    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return isBST(sequence, 0, sequence.length - 1);
    }

    /**
     * 二叉搜索树的后序遍历序列
     *
     * @param sequence
     * @param start
     * @param end
     * @return
     */
    private boolean isBST(int[] sequence, int start, int end) {
        if (start >= end) return true;
        int val = sequence[end];
        int split = start;
        //到达分界点,前面为左子树节点
        for (; split < end && sequence[split] < val; split++);
        //右子树节点
        for (int i = split; i < end; i++) {
            if(sequence[i]<val) return false;
        }
        //判断左右子树
        return isBST(sequence,start,split-1) && isBST(sequence,split,end-1);
    }

    public static void main(String[] args) {
        int[] seq1 = {5,7,6,9,11,10,8};//return true
        int[] seq2 = {7,4,6,5};        //return false
        Solution033 solution = new Solution033();
        System.out.println(solution.VerifySquenceOfBST(seq1));

    }

}
